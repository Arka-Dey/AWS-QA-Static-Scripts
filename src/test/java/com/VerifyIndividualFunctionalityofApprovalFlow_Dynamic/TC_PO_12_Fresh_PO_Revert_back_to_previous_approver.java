package com.VerifyIndividualFunctionalityofApprovalFlow_Dynamic;


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


public class TC_PO_12_Fresh_PO_Revert_back_to_previous_approver extends BaseClass_Web {

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
		pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
	} catch (Exception e) {
		System.out.println("Unable to read the data from excel file");
	}
	  
	  WebDriver driver = ThreadLocalWebdriver.getDriver();
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		initializeRepository();
		//etenderPRcomponentobj.updateFreshPODetails();
		Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin("GSML_BUYER", "pass@123", "PO", "Creator");
		posttendercomponentobj.navigateToPOList();
		posttendercomponentobj.createFreshPO();	
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj.savePoDocNumber();
		posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Approval");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	 
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardParallelPOApprovalProcess(); //forward to sn_approver_02, sn_approver_03 and sn_approver_04(c), min app: 2
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		 
		//approver3
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		   
		  //approver4
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequentialSNApprovalProcess();  //forward to sn_approver_05, sn_approver_06 and sn_approver_07(c), min app: 2
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		  
		  //approver5
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		  
		  //approver6
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
			   
		  //approver7
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		  posttendercomponentobj.navigateToPurchaseOrderApproval();
		  posttendercomponentobj.provide_PO_ApproverComment();
		  posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Previous Approver");
		 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		  
		  
		 		etenderPRcomponentobj.commonLogin("GSML_BUYER", "pass@123", "PO", "Creator");
		  posttendercomponentobj.navigateToPurchasrOrderList();
		  posttendercomponentobj.searchThePoRefNoInPoListPage();
		 posttendercomponentobj.verifyPOStatus("Pending for Approval");
				 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	
	}

}
