package com.testScripts_mjunction;


import com.components.PostTenderComponent;
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
	  WebDriver driver = ThreadLocalWebdriver.getDriver();
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	  
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
	  posttendercomponentobj.documentNoSave();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_Coordinator();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  
	  etendercomponentobj.tenderLogout(); 
	  
	  //approver1
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationApprove();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	 
	  //approver2
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();

	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardParallelSNApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
		  
		  
	  //approver4
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	  //approver5
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequentialSNApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
	  etendercomponentobj.tenderLogout();
	   
	  //approver6
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	  
	  //approver7
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  

	  //approver8
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("Review Back to Previous Approver");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	  //approver7
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	//approver8
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("Review Back to Creator");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	 

	  //creator action initiate wf  with 3 parallel and 5 sequential flow
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.nevigateToPendingSNList();
	  posttendercomponentobj.sendforApproverFromDraftSN();
	  posttendercomponentobj.clickOnSubmitButton();
	  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
	  etendercomponentobj.tenderLogout();
	
	  //SN creator recall WF
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.nevigateToPendingSNList();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  posttendercomponentobj.recallButtonValidation();
	  //posttendercomponentobj.recallSuccessOk(); // need to raise defect
	  etendercomponentobj.tenderLogout();
	  
	  //creator action initiate wf parallel and sequential with 3 parallel and 5 sequential flow
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.nevigateToPendingSNList();
	  posttendercomponentobj.sendforApproverFromDraftSN();
	  posttendercomponentobj.clickOnSubmitButton();
	  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
	  etendercomponentobj.tenderLogout();
	  
	 
	  //approver1
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	//approver2
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
  
	//approver3
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
  
		//approver4
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
  
	//approver5
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
  
	//approver6
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
	  
	  //SN creator recall WF
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.nevigateToPendingSNList();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  posttendercomponentobj.recallButtonValidation();
	  //posttendercomponentobj.recallSuccessOk();
	  etendercomponentobj.tenderLogout();
	  
	  //SN creator initiates WF again with 1 approver
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.nevigateToPendingSNList();
	  posttendercomponentobj.sendforApproverFromDraftSN();	
	  posttendercomponentobj.clickOnSubmitButton();
	  posttendercomponentobj.AddSingleUsersForSequentialApproval_SNWF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1"));
	  etendercomponentobj.tenderLogout();
	  
	//approver1
  	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
	  etendercomponentobj.tenderLogout();
	  
	//approver2
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
	  etendercomponentobj.tenderLogout();
	  
	//approver3
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
	  etendercomponentobj.tenderLogout();
	  
	//approver4
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
	  etendercomponentobj.tenderLogout();
	  
	//approver5
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
	  etendercomponentobj.tenderLogout();
	  
	//approver6
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
	  etendercomponentobj.tenderLogout();
	  
	//approver7
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
	  etendercomponentobj.tenderLogout();
	  
	//approver8
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("Review Back to Previous Approver");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	  etendercomponentobj.tenderLogout();
  		
	//approver7
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  etendercomponentobj.tenderLogout();
	  
	//approver8
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationApprove_C();
	  posttendercomponentobj.sanctionNoteCloseWorkflow();
	  etendercomponentobj.tenderLogout();
	  
	  //verify SN status after approval
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.navigateToCompletedTenderDetailsPage();
	  posttendercomponentobj.enterDocumentNoInSearch();
	  etendercomponentobj.tenderLogout();
		  
	  
}}