package com.ProductionDefects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.Change_request_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class LOA_PD_135137 extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public Change_request_Component change_requestobj=new Change_request_Component(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	/**
	 * TestScript Environment Details
	 * 
	 * @throws Exception
	 */
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Venkatesh Jujjuru");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	
	
	@Parameters("TestcaseNo")
	@Test(description = "Tenderpublished_after_tender_approval_tender_from_indent")
	public void ProductionDefect_135540(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/ProductionDefects_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		initializeRepository();
		etenderPRcomponentobj.updateTendertoSNDetails();
		Dynamicity.updateDataIntoPropertyFile("snCreator", "RDCIS_AUTOMATION_TC", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("snCreator_Password", "pass@123", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("tenderID", "2744", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Organization", "RDCIS", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
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
		posttendercomponentobj.enterDocumentNoInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		change_requestobj.nevigateToAllSanctions();
		change_requestobj.searchCompletedSN();
		change_requestobj.issueLOA();
		change_requestobj.submitLOA();
		change_requestobj.LOANoSave();
		change_requestobj.AddTwoUsersForSequentialApproval();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		  //approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchThe_LOA();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Approve the created Notesheet
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchThe_LOA();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardParallelTenderApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		}
	}

/**130842	Defect	Closed	Severity - 1	Hmel_ Buyer was unable to cancel the tender.





*/
