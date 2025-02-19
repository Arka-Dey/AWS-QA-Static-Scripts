package com.PO_Purchase_Order_From_Sanction;


import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;


public class TC_PO_06_Recall_by_creator extends BaseClass_Web {

	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	
	public void initializeRepository() throws Exception {		
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "2");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	@Parameters("TestcaseNo")
	@Test(description = "Scenario:2 - Verify the functionality of End to End workflow of 'PO from Sanction note' with approval type 'User defined'")
  public void f(String no) throws Throwable {
	  System.out.println("Entered in the Test method..................");
	  try {
		pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TenderCreation_CreateNewRFQ_TestData_pt1.xls", no);
	} catch (Exception e) {
		System.out.println("Unable to read the data from excel file");
	}
	  WebDriver driver = ThreadLocalWebdriver.getDriver();
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		initializeRepository();
		etenderPRcomponentobj.updateSNtoPODetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		etendercomponentobj.vistCompletedTenderList();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.createSanctionFromCompletedTenderList();
		etendercomponentobj.fillup_SanctionNoteReference();
		posttendercomponentobj.supplierSelection_SN();
		dynamicity.fillup_Supplier_Specific_Detail();
		posttendercomponentobj.ScantionComment_recommendationTab();
		posttendercomponentobj.clickOnSubmitButton();
		posttendercomponentobj.documentNoSave();
		posttendercomponentobj.notSendForApproval();
		//posttendercomponentobj.enterDocumentNoInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPOList();
		posttendercomponentobj.CreatePOfromSN(Dynamicity.getDataFromPropertiesFile("CompletedSN", filePath_4), Dynamicity.getDataFromPropertiesFile("poTemplate", filePath_4));
		posttendercomponentobj.Add_SN_Items_Submit();
		posttendercomponentobj.InitiatePOfromSN();
		dynamicity.CreatePODynamically();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj.savePoDocNumber();
		posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Approval");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 

		  //PO creator recall WF
		  etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		  posttendercomponentobj.navigateToPurchasrOrderList();
		  posttendercomponentobj.searchThePoRefNoInPoListPage();
		  posttendercomponentobj.recallPOValidation();
		  mailAndAttachmentVeification(221 , 1,"Approver(s) will get an intimation mail after Purchase Order is recalled by the creator");
			mailAndAttachmentVeification(223 , 1,"In case of parallel group, approver(s) who have not taken any action yet will get an intimation mail after purchase order is approved/reviewed by the coordinator");
		  posttendercomponentobj.searchThePoRefNoInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	  
	}

}
