package com.testScripts_mjunction;

import java.util.Arrays;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.ASN_GRNComponent;
import com.components.PostTenderComponent;
import com.components.PreConditionPo_SanctionCreation;
import com.components.RfqFromIndentComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;


public class TG1_TC_GRN_Create3StagesGRN_From_Indent_E2E extends BaseClass_Web{
	PreConditionPo_SanctionCreation preConditionPo = new PreConditionPo_SanctionCreation(pdfResultReport);
	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
    public ASN_GRNComponent asn_grncomponentobj=new ASN_GRNComponent(pdfResultReport);
    public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {		
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "05");
		reportDetails.put("Test Author Name", "Vamshi");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	@Parameters("TestcaseNo")
	@Test(description = "TC_GRN_02:Verify the Submit Functionality during Create GRN with approval workflow & Check the GRN Status as Created")
  public void Create3StagesGRN_WithoutApprovalFlow(String no) throws Throwable {
	  System.out.println("Entered in the Test method..................");
	  try {
		pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
	} catch (Exception e) {
		System.out.println("Unable to read the data from excel file");
	}
	     initializeRepository();
	     etendercomponentobj.openURL();
	    
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentCreation();
		rfqfromintendcomponentobj.IndentTG1_General_Info_tabvalidation("Indigenous Indent (Supply & Service Both) V-004");
		rfqfromintendcomponentobj.IndentTG1_Indent_Details_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Other_Information_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_BOM_Item_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_BOM_Services_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_EstimationSheet_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_technical_Specification_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Annexures_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSaveNew();
		rfqfromintendcomponentobj.AddSingleUsersForSequentialApproval_IndentWF();
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
		
		//Approve the created indent
		rfqfromintendcomponentobj.IndentapproverLogin();
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.validateIndentdataAtApproverEnd();   //validate indent data at sectionWise view
		rfqfromintendcomponentobj.ApproverOverAllComentWithIndentHasBeenApproved();
		etendercomponentobj.tenderLogoutOld();
		
		//Verifying the indent status after approval
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");

	 	//Mark the created indent 'Marked for RFQ'
	 	rfqfromintendcomponentobj.Indent_Mark_for_RFQ_functionality();
	 	rfqfromintendcomponentobj.enterIndentNoForSearch();
	 	rfqfromintendcomponentobj.VerifyIndentStatus("Marked For RFQ");
	 	etendercomponentobj.tenderLogout();
	 	
	 	
	 	//Indent assignment Process (self claim)
	 	etendercomponentobj.tendercreatorLogin();
	 	rfqfromintendcomponentobj.navigateToIndentAssignment();
	 	rfqfromintendcomponentobj.enterIndentNoForSearch();
	 	rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
	 	//rfqfromintendcomponentobj.enterIndentNoForSearch();
	 	rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned");
	 	rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
	 	rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
	 	 
	 	//Create and publish RFQ from indent
	 	rfqfromintendcomponentobj.Create_RFQ_From_Indent("Indigenous Tender (Supply & Service Both) V-1.0");
	 	rfqfromintendcomponentobj.PublishTender_from_indent_withRFQ_TG1("Indigenous Tender (Supply & Service Both) V-1.0",5,30,32);
	 	//Clicking on submit button and verify tender status
	 	etendercomponentobj.clickSubmitBtn();
	 	etendercomponentobj.tenderIdSave();
	 	etendercomponentobj.sendForNoApproval_validation();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.checkTenderStatusAndTenderStage();
	 	etendercomponentobj.tenderLogout();

	 	//Bid submission process	
	 	rfqfromintendcomponentobj.waitTillBidstartDateReached();
	 	
	 	
	 	etendercomponentobj.bidder_01_Login();
	 	etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.navigateToActionDropdown_bidsubmission();
	 	etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
	 	etendercomponentobj.TG1_generalInformationPageValidation_bidsubmission();
	 	etendercomponentobj.quotationReferenceCode_bidsubmission();
	 	rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG1("Indigenous Tender (Supply & Service Both) V-1.0");
	 	etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
	 	//etendercomponentobj.TG1_validateAllInPrevieAllSubmitbidPage();
	 	etendercomponentobj.submitBid_link_in_previewAllPage();
	 	etendercomponentobj.navigate_to_bidList_page();
	 	//etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.submittedBid_Tab_Validation();
	 	etendercomponentobj.tenderLogoutOld();
	 			
	 	//Bid submission process for bidder2		
	 	etendercomponentobj.bidder_02_Login();
	 	etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.navigateToActionDropdown_bidsubmission();
	 	etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
	 	etendercomponentobj.TG1_generalInformationPageValidation_bidsubmission();
	 	etendercomponentobj.quotationReferenceCode_bidsubmission();
	 	rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG1("Indigenous Tender (Supply & Service Both) V-1.0");
	 	etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
	 	//etendercomponentobj.TG1_validateAllInPrevieAllSubmitbidPage();
	 	etendercomponentobj.submitBid_link_in_previewAllPage();
	 	etendercomponentobj.navigate_to_bidList_page();
	 	//etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.submittedBid_Tab_Validation();
	 	etendercomponentobj.tenderLogoutOld();
	 		
	 	//Bid submission process for bidder3		
	 	etendercomponentobj.bidder_03_Login();
	 	etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.navigateToActionDropdown_bidsubmission();
	 	etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
	 	etendercomponentobj.TG1_generalInformationPageValidation_bidsubmission();
	 	etendercomponentobj.quotationReferenceCode_bidsubmission();
	 	rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG1("Indigenous Tender (Supply & Service Both) V-1.0");
	 	etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
	 	//etendercomponentobj.TG1_validateAllInPrevieAllSubmitbidPage();
	 	etendercomponentobj.submitBid_link_in_previewAllPage();
	 	etendercomponentobj.navigate_to_bidList_page();
	 	//etendercomponentobj.enterTenderIdInSearch_bidsubmission();
	 	etendercomponentobj.submittedBid_Tab_Validation();
	 	etendercomponentobj.tenderLogoutOld();
	 	 
	 	//============change will be applied
	 	//Evaluation: Cover 1 work flow where opening approval Yes and evaluation approval Yes      
	 	etendercomponentobj.tendercreatorLogin();
	 	rfqfromintendcomponentobj.waitTillBidDuetDateReached();
	 	rfqfromintendcomponentobj.waitTillBidOpentDateReached();
	 	etendercomponentobj.navigateToTenderListing();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.clickEvaluationSettingsLink();		
	 	//Set the schedule opening date and time
	 	/*
	 	 etendercomponentobj.ScheduleOpening_Evaluationsettings(4); //Need to enable respective field
	 	*/
	    
	 	etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
	 	etendercomponentobj.selectBidOpeningAndProvideCommentsForBidOpeningApproval();
	 	etendercomponentobj.selectEvaluationAndProvideCommentsForBidOpeningApproval();
	 	etendercomponentobj.SendForApprovalInEvaluationsetting();
	 	//etendercomponentobj.checktenderStatusIsInOpening();
	 	etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Cover 1");
	 	etendercomponentobj.tenderLogout();
	 	
	 	//Waiting for schedule opening time reached
	 	/*
	 	etendercomponentobj.waitTillScheduleOpeningDateReached(); // dependent on method: ScheduleOpening_Evaluationsettings
	 	*/
	 	
	 	//Opening approver approve the tender for Cover1
	 	etendercomponentobj.tenderApproverLogin();
	 	etendercomponentobj.validateTenderOpeningTab_ForBidOpeningUser();
	 	etendercomponentobj.clickDetailsLink();
	 	etendercomponentobj.validateBidOpeningApprovalpage("Cover 1", "3", "3");
	 	etendercomponentobj.provideApproverCommentInCommentsection();
	 	etendercomponentobj.clickApproveBtnAndCheckTenderIsDisplayingOrNotInTenderOpeningTab();
	 	etendercomponentobj.tenderLogoutOld();
	 	 
	 	//Tender creator decrypt the bid for all the bidder cover1
	 	etendercomponentobj.tendercreatorLogin();
	 	etendercomponentobj.navigateToTenderListing();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.checktenderStatusIsInevaluationState();
	 	//etendercomponentobj.checktenderStageIsInevaluationStage();
	 	etendercomponentobj.clickPendingForEvaluationApprovalStage();
	 	etendercomponentobj.decryptingTheBidder();
	 	etendercomponentobj.submitBidDetailPage();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.verifyTenderStageIsInFinalApprovalCover_1Or_Cover2();
	 	etendercomponentobj.tenderLogout();
	 		 
	 	//Tender Evaluator evaluate(approve) the bid cover1
	 	etendercomponentobj.evaluator1Login();
	 	etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser();
	 	etendercomponentobj.clickDetailsLink();
	 	etendercomponentobj.evaluateSupplier("Tech Mahindra", "Approve", "Approve Tech Mahindra", 1);
	 	etendercomponentobj.evaluateSupplier("CTS", "Approve", "Approve CTS", 1);
	 	etendercomponentobj.evaluateSupplier("TCS", "Approve", "Approve TCS", 1);
	 	etendercomponentobj.enterOverallComment_EvaluatorUser();
	 	etendercomponentobj.tenderLogoutOld();
	 	
	 	//============change will be applied
	 	//Evaluation: Cover 2 work flow where opening approval Yes and evaluation approval Yes
	 	etendercomponentobj.tendercreatorLogin();
	 	etendercomponentobj.navigateToTenderListing();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.clickEvaluationSettingsLink();
	 	
	 	//Set the schedule opening date and time
	 	//etendercomponentobj.ScheduleOpening_Evaluationsettings(4); //Need to enable respective field
	 	
	 	//===================added on 180124
	 	
	 	etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
	 	etendercomponentobj.selectBidOpeningAndProvideCommentsForBidOpeningApproval4Cover2();
	 	etendercomponentobj.selectEvaluationAndProvideCommentsForBidOpeningApproval4Cove2();
	 	etendercomponentobj.SendForApprovalInEvaluationsetting();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	//etendercomponentobj.checktenderStatusIsInOpening(); //Issue raised, Defect ID: 136575
	 	etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Cover 2");
	 	etendercomponentobj.tenderLogout();
	 	
	 	//Waiting for schedule opening time reached
	 	//etendercomponentobj.waitTillScheduleOpeningDateReached(); // dependent on method: ScheduleOpening_Evaluationsettings
	 	
	 	//Opening approver approve the tender for Cover2
	 	etendercomponentobj.tenderApproverLogin();
	 	etendercomponentobj.validateTenderOpeningTab_ForBidOpeningUser();
	 	etendercomponentobj.clickDetailsLink();
	 	etendercomponentobj.validateBidOpeningApprovalpage("Cover 2", "3", "3");
	 	etendercomponentobj.provideApproverCommentInCommentsection();
	 	etendercomponentobj.clickApproveBtnAndCheckTenderIsDisplayingOrNotInTenderOpeningTab();
	 	etendercomponentobj.tenderLogoutOld();

	 	//Tender creator decrypt the bid for all the bidder cover2
	 	etendercomponentobj.tendercreatorLogin();
	 	etendercomponentobj.navigateToTenderListing();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.checktenderStatusIsInevaluationState();
	 	etendercomponentobj.checktenderStageIsInevaluationStage();
	 	etendercomponentobj.clickPendingForEvaluationApprovalStage();
	 	etendercomponentobj.decryptingTheBidder();
	 	etendercomponentobj.submitBidDetailPage();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.verifyTenderStageIsInFinalApprovalCover_1Or_Cover2();
	 	etendercomponentobj.tenderLogout();
	 	
	 	//Tender Evaluator evaluate(approve) the bid cover2
	 	etendercomponentobj.evaluator1Login();
	 	etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser();
	 	etendercomponentobj.clickDetailsLink();
	 	etendercomponentobj.evaluateSupplier("Tech Mahindra", "Approve", "Approve Tech Mahindra", 2);
	 	etendercomponentobj.evaluateSupplier("CTS", "Approve", "Approve CTS", 2);
	 	etendercomponentobj.evaluateSupplier("TCS", "Approve", "Approve TCS", 2);
	 	etendercomponentobj.enterOverallComment_EvaluatorUser();
	 	etendercomponentobj.tenderLogoutOld();
	 	
	 	//Checking tender status Completed
	 	etendercomponentobj.tendercreatorLogin();
	 	etendercomponentobj.navigateToTenderListing();
	 	etendercomponentobj.enterTenderIdInSearch();
	 	etendercomponentobj.checktenderStatusIsIncompletedState();
	 	etendercomponentobj.tenderLogout();
	 	  
	 	  //==========Create a new Sanction from a completed Tender=============
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
		  posttendercomponentobj.ApprovalNotRequired();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Acceptance");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		  etendercomponentobj.tenderLogout();
		  
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
		 
		  etendercomponentobj.bidder_01_Login();
		  asn_grncomponentobj.SelectASNModule();
		  asn_grncomponentobj.CreateASN();
		  asn_grncomponentobj.SaveASN();
		  asn_grncomponentobj.myInformationTab();
		  asn_grncomponentobj.TabShipmentInformation("Patna");
		  asn_grncomponentobj.TabWhatIamShippingWithBoxesOnly("10", "80", "AU");
		  asn_grncomponentobj.TabDeliveryChallenChecklist();
		  asn_grncomponentobj.TabInvoice("Invoice");
		  asn_grncomponentobj.SaveASN();
		  asn_grncomponentobj.SubmitASN();
		  asn_grncomponentobj.SearchASNRefInASNList();
		  asn_grncomponentobj.VerifyStatus("Completed");
		  waitForObj(15000);
		  etendercomponentobj.tenderLogoutOld();
		  
		//=============Gate Pass creation===============
 		 asn_grncomponentobj.GRN_Creator_Login();
 		 asn_grncomponentobj.navigateToApprovedASNListPage();
 		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
 		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
 		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
 		 asn_grncomponentobj.grnAttachment();
 		 asn_grncomponentobj.saveGrnDetails();
 		 asn_grncomponentobj.submitGrnDetails1("Yes");
 		 asn_grncomponentobj.grnSendForApproval();
 		 //asn_grncomponentobj.verifyGRNStatus("Pending for QC creation");
 		 asn_grncomponentobj.verifyGRNStatus("Pending for GP approval");
 		 etendercomponentobj.tenderLogout();
 		 
 		//Approval of GRN
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_01");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.Forward_GRNWF_With_SequentialApprovalType("Test  Approver02 (inbox2csoft@gmail.com)-TEST_AUTOMATION"); //forward to test_approver_02
 		etendercomponentobj.tenderLogoutOld();
 		
 		//Forward to another person
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_02");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.END_GRN_WF(); 
 		etendercomponentobj.tenderLogoutOld();
 		waitForObj(10000);
 		 
 		 //==========QC creation================
 		asn_grncomponentobj.GRN_Creator_Login();
		 asn_grncomponentobj.navigateToApprovedASNListPage();
		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.grnAttachment();
		 asn_grncomponentobj.saveGrnDetails();
		 asn_grncomponentobj.submitGrnDetails1("Yes");
		 asn_grncomponentobj.grnSendForApproval();
		 asn_grncomponentobj.verifyGRNStatus("Pending for QC approval");
		 etendercomponentobj.tenderLogout();
		 
		//Approval of QC GRN
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_01");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.Forward_GRNWF_With_SequentialApprovalType("Test  Approver02 (inbox2csoft@gmail.com)-TEST_AUTOMATION"); //forward to test_approver_02
 		etendercomponentobj.tenderLogoutOld();
 		
 		//Forward to another person
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_02");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.END_GRN_WF(); 
 		etendercomponentobj.tenderLogoutOld();
 		waitForObj(10000);
 		
		 //===========QV creation================
		 asn_grncomponentobj.GRN_Creator_Login();
		 asn_grncomponentobj.navigateToApprovedASNListPage();
		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.grn_InspectionDetails();
		 asn_grncomponentobj.grnAttachment();
		 asn_grncomponentobj.saveGrnDetails();
		 asn_grncomponentobj.submitGrnDetails1("Yes");
		 /*
		 //This method needs application configuration, unless this method does not required for this flow
		 /*asn_grncomponentobj.submitNotificationTab();
		 */
		 asn_grncomponentobj.grnSendForApproval();
		 asn_grncomponentobj.verifyGRNStatus("Pending for QV approval");
		 etendercomponentobj.tenderLogout();
	 
		//Approval of QV GRN
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_01");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.Forward_GRNWF_With_SequentialApprovalType("Test  Approver02 (inbox2csoft@gmail.com)-TEST_AUTOMATION"); //forward to test_approver_02
 		etendercomponentobj.tenderLogoutOld();
	 		
 		//Forward to another person
 		rfqfromintendcomponentobj.commonLogin("TEST_APPROVER_02");
 		asn_grncomponentobj.GoToApprovalworkFlowPendingGRNAndSearchTheGRN();
 		asn_grncomponentobj.clickDetailLinkInApprovalListPage();
 		asn_grncomponentobj.END_GRN_WF(); 
 		etendercomponentobj.tenderLogoutOld();
	}

}
