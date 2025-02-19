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
	  posttendercomponentobj.SanctionsupplierOrgNameWiseSelection("CTS");
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
	  posttendercomponentobj.savePoDocNumber();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
	  posttendercomponentobj.verifyPoRefNumberInPoListPage();
	  posttendercomponentobj.verifyPOStatus("Pending for Approval");
	  posttendercomponentobj.savePoDocNumberFromPoListpage();
	  etendercomponentobj.tenderLogout();
 
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardParallelPOApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
	  etendercomponentobj.tenderLogout();
	 
	//approver4
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	   
	  //approver5
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequentialSNApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
	  etendercomponentobj.tenderLogout();
	  
	  //approver6
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	  //approver7
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
		   
	  //approver8
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Previous Approver");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	
	  //approver7
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();

	//approver8
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Creator");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	   
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
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	//approver2
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	  
	//approver3
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	  
		//approver4
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	//approver5
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	  
	//approver6
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  etendercomponentobj.tenderLogout();
	  
	
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
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
	  etendercomponentobj.tenderLogout();
	  
	  //approver2
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName2"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
	  etendercomponentobj.tenderLogout();
	  
	//approver3
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
	  etendercomponentobj.tenderLogout();
	  
	//approver4
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
	  etendercomponentobj.tenderLogout();
	  
	//approver5
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
	  etendercomponentobj.tenderLogout();
	  
	//approver6
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
	  etendercomponentobj.tenderLogout();
	  
	//approver7
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
	  etendercomponentobj.tenderLogout();
	  
		//approver8
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Creator");
	  etendercomponentobj.tenderLogout();
	  
	//approver7
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
	  etendercomponentobj.tenderLogout();
	  
	//approver8
	  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
	  posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
	  posttendercomponentobj.navigateToPurchaseOrderApproval();
	  posttendercomponentobj.provide_PO_ApproverComment();
	  posttendercomponentobj.purchaseOrderApproval();
	  etendercomponentobj.tenderLogout();
	  
	  etendercomponentobj.bidder_01_Login();
	  posttendercomponentobj.navigateToPoListingWithBidderUser();
	  posttendercomponentobj.searchThePoRefNoInPoListPage_SupplierSide();
	  posttendercomponentobj.clickAcceptPoInDropDown();
	  posttendercomponentobj.verifySummaryTabAndEnterComment();
	  posttendercomponentobj.clickAccepPotBtn();
	  posttendercomponentobj.verifyPOStatusIsAccepted_SupplierSide();
	  etendercomponentobj.tenderLogout();
	  
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.navigateToPurchasrOrderList();
	  posttendercomponentobj.verifyPOStatusIsAccepted();
	  etendercomponentobj.tenderLogout();
	   
	}

}
