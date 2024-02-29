package com.testScripts_mjunction;


import com.components.PostTenderComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.eTenderComponent;


public class TC_EPS_PO_05_with_multiple_approvers extends BaseClass_Web {

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
	@Test(description = "Scenario:2 - Verify the functionality of End to End workflow of 'PO from Sanction note' with approval type 'User defined'")
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
	  posttendercomponentobj.notSendForApproval();
	  
	  posttendercomponentobj.enterDocumentNoInSearch();
	  
	  posttendercomponentobj.issuePObuttonValidation();
	  posttendercomponentobj.IssuePO_From_Completed_SNList();
	  posttendercomponentobj.Add_AllTemplate_Items_Submit();
	  posttendercomponentobj.InitiatePOfromSN();
	  posttendercomponentobj.EPS_PO_Submission();
	  posttendercomponentobj.POSaveandApproval();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
	  posttendercomponentobj.verifyPoRefNumberInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Pending for Approval");
	  posttendercomponentobj.savePoDocNumberFromPoListpage();
	  etendercomponentobj.tenderLogout();
	  
	  
	  
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardParallelPOApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
	  etendercomponentobj.tenderLogoutOld();
	  
	 
	  
	  
	  
	  
	//approver4
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	   
	  //approver5
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequentialSNApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
	  etendercomponentobj.tenderLogoutOld();
	  
	  //approver6
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
	  //approver7
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
	  //approver8
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("revert back to approver");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	
	  //approver7
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();

	//approver8
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("revert back to creator");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	   
	//creator action initiate wf  with 3 parallel and 5 sequential flow
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Draft (Rejected by approver)");
	  posttendercomponentobj.editPO();
	  posttendercomponentobj.POSaveandApproval();
	  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_PO_WF("Reinitiated after reverted back the workflow");
	  etendercomponentobj.tenderLogout();
	
	  
	  //PO creator recall WF
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.recallPOValidation();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
	  etendercomponentobj.tenderLogout();
	    
	 //issue 
	  //creator action initiate wf  with 3 parallel and 5 sequential flow
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
	  posttendercomponentobj.editPO();
	  posttendercomponentobj.POSaveandApproval();
	  posttendercomponentobj.AddMultipleUsersForSequentialParallelApproval_PO_WF("Reinitiated after reverted back the workflow");
	  etendercomponentobj.tenderLogout();
	  
	  
	//approver1
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver2
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
	//approver3
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
		//approver4
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver5
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
	//approver6
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogoutOld();
	  
	
	  //PO creator recall WF
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.recallPOValidation();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
	  etendercomponentobj.tenderLogout();
	  
	  
	//SN creator initiates WF again with 1 approver
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
	  posttendercomponentobj.editPO();
	  posttendercomponentobj.POSaveandApproval();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
	  etendercomponentobj.tenderLogout();
	  
	//approver1
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
	  etendercomponentobj.tenderLogoutOld();
	  
	  //approver2
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver3
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver4
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver5
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver6
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver7
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
	  etendercomponentobj.tenderLogoutOld();
	  
		//approver8
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("revert back to approver");
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver7
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  etendercomponentobj.tenderLogoutOld();
	  
	//approver8
	  posttendercomponentobj.poApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderApproval();
	  etendercomponentobj.tenderLogoutOld();
	  
	  
	  
	  etendercomponentobj.bidder_01_Login();
	  posttendercomponentobj.navigateToPoListingWithBidderUser();
	  posttendercomponentobj.searchThePoRefNoInPoListPage();
	  posttendercomponentobj.clickAcceptPoInDropDown();
	  posttendercomponentobj.verifySummaryTabAndEnterComment();
	  posttendercomponentobj.clickAccepPotBtn();
	  posttendercomponentobj.verifyPOStatusIsAccepted();
	  etendercomponentobj.tenderLogout();
	  
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.verifyPOStatusIsAccepted();
	  etendercomponentobj.tenderLogout();
	  
	  
	 
	}

}
