package com.Sanction_Note_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class SN_12_Create_MSN_From_Completed_Tender_with_approver extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description ="Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void CreateFreshTenderDynamically(String no)
			throws Throwable {
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
		etenderPRcomponentobj.updateFreshSNDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		ProductionDefectobj.navigateToFreshSNCreation();
		ProductionDefectobj.sanctionReferenceNumberANDselectTG_msn();
		posttendercomponentobj.supplierSelection_MSN();
		dynamicity.fillup_Supplier_Specific_Detail_msn();
		posttendercomponentobj.ScantionComment_recommendationTab();
		posttendercomponentobj.clickOnSubmitButton();
		//posttendercomponentobj.documentNoSave();
		ProductionDefectobj.documentNoSave();
		 posttendercomponentobj.sendForApprovalUserDefinedSequential_Coordinator(); 
		 ProductionDefectobj.LogoutOld(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	
		  //approver1
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	 
		  //approver2
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("forward");
		  posttendercomponentobj.fowardTeam3Approvers(); //team WF to to sn_approver_03, sn_approver_04 and sn_approver_05
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			  
		  //approver4
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("final approve Tender");
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	  	  
		  //verify SN status after approval
			 etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
			  posttendercomponentobj.MSNlistPage();
			  ProductionDefectobj.enterDocumentNoInSearch_msn();
			  ProductionDefectobj.msnStatus("Completed");
			  ProductionDefectobj.LogoutOld(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		 
	}
	}