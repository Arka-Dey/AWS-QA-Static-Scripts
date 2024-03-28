package com.testScripts_mjunction;


import com.components.PostTenderComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.eTenderComponent;


public class TC_SN_06_VerifyEndToEndWorkFlowOfSanctionNoteWithUserdefinedWorkFlowMultipleApprover extends BaseClass_Web {

	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	
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
	@Test(description = "Scenario:2 - Verify the functionality of End to End workflow of Sanction Note with Userdefine workflow")
  public void f(String no) throws Throwable {
	  System.out.println("Entered in the Test method..................");
	  try {
		pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TenderCreation_CreateNewRFQ_TestData_pt1.xls", no);
	} catch (Exception e) {
		System.out.println("Unable to read the data from excel file");
	}
	  initializeRepository();
	  etendercomponentobj.openURL();
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.createSanctionNote();
	  posttendercomponentobj.sanctionReferenceNumber();
	  posttendercomponentobj.SanctionsupplierSelection();
	  posttendercomponentobj.SanctionItemsAllotment();
	  posttendercomponentobj.ScantionComment_recommendationTab();
	  posttendercomponentobj.clickOnSubmitButton();
	  //posttendercomponentobj.documentNoSave();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_Coordinator();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  /*
	  posttendercomponentobj.viewDetailsValidation();
	  posttendercomponentobj.clickOnDownloadSanctionReport();
	  */
	  etendercomponentobj.tenderLogoutOld(); 
	  
	  //approver1
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationApprove();
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	 
	  //approver2
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();

		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardParallelSNApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  
		  //approver4
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //approver5
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequentialSNApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
		  etendercomponentobj.tenderLogoutOld();
		   
		  //approver6
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  
		  //approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
	
		  //approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("Back to Previous Approver");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("Back to Creator");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();

		  //creator action initiate wf  with 3 parallel and 5 sequential flow
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.nevigateToPendingSNList();
		  posttendercomponentobj.sendforApproverFromDraftSN();
		
		  posttendercomponentobj.clickOnSubmitButton();
		  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
		  etendercomponentobj.tenderLogoutOld();
		  
		  //SN creator recall WF
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.nevigateToPendingSNList();
		  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
		  posttendercomponentobj.recallButtonValidation();
		  posttendercomponentobj.recallSuccessOk();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //creator action initiate wf parallel and sequential with 3 parallel and 5 sequential flow
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.nevigateToPendingSNList();
		  posttendercomponentobj.sendforApproverFromDraftSN();
		
		  posttendercomponentobj.clickOnSubmitButton();
		  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
		  etendercomponentobj.tenderLogoutOld();
		  

		  //approver1
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver2
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
	  
		//approver3
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
	  
			//approver4
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
	  
		//approver5
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
	  
		//approver6
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //SN creator recall WF
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.nevigateToPendingSNList();
		  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
		  posttendercomponentobj.recallButtonValidation();
		  posttendercomponentobj.recallSuccessOk();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //SN creator initiates WF again with 1 approver
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.nevigateToPendingSNList();
		  posttendercomponentobj.sendforApproverFromDraftSN();	
		  posttendercomponentobj.clickOnSubmitButton();
		  posttendercomponentobj.AddSingleUsersForSequentialApproval_SNWF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver1
	  	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver2
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver3
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver4
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver5
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver6
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
		  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("Back to Previous Approver");
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
	  
		//approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationApprove_C();
		  posttendercomponentobj.sanctionNoteCloseWorkflow();
		  etendercomponentobj.tenderLogoutOld();
		  
		  
		  //verify SN status after approval
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.navigateToCompletedTenderDetailsPage();
		  posttendercomponentobj.enterDocumentNoInSearch();
		  etendercomponentobj.tenderLogoutOld();
	  
}}