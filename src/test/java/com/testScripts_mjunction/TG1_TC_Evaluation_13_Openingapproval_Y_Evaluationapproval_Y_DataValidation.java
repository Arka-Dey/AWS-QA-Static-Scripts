package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.RfqFromIndentComponent;
import com.components.eTenderComponent;

public class TG1_TC_Evaluation_13_Openingapproval_Y_Evaluationapproval_Y_DataValidation extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);

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
	@Test(description = "Tender_Evaluation_with_OpeningApproval_Y_Evaluationapproval_Y_RFQ_from_Indent")
	public void Tender_Evaluation_with_OpeningApproval_Y_Evaluationapproval_Y(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}

		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
	//Creating a new Indent with No approval
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
		rfqfromintendcomponentobj.NoApproval_IndentWF();
		//rfqfromintendcomponentobj.navigateToIndentListing();
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
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
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
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
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
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		 
		//Evaluation: Cover 1 work flow where opening approval Yes and evaluation approval Yes      
		etendercomponentobj.tendercreatorLogin();
		rfqfromintendcomponentobj.waitTillBidDuetDateReached();
		rfqfromintendcomponentobj.waitTillBidOpentDateReached();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();		
		
		etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
		etendercomponentobj.selectBidOpeningAndProvideCommentsForBidOpeningApproval();
		etendercomponentobj.selectEvaluationAndProvideCommentsForBidOpeningApproval();
		etendercomponentobj.SendForApprovalInEvaluationsetting();
	
		etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Cover 1");
		etendercomponentobj.tenderLogout();
		
	
		
		//Opening approver approve the tender for Cover1
		etendercomponentobj.tenderApproverLogin();
		etendercomponentobj.validateTenderOpeningTab_ForBidOpeningUser();
		etendercomponentobj.clickDetailsLink();
		etendercomponentobj.validateBidOpeningApprovalpage("Cover 1", "3", "3");
		etendercomponentobj.provideApproverCommentInCommentsection();
		etendercomponentobj.clickApproveBtnAndCheckTenderIsDisplayingOrNotInTenderOpeningTab();
		etendercomponentobj.tenderLogout();	
	
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
		etendercomponentobj.tenderLogout();
	
		//============change will be applied
		//Evaluation: Cover 2 work flow where opening approval Yes and evaluation approval Yes
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();
		etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
		etendercomponentobj.selectBidOpeningAndProvideCommentsForBidOpeningApproval4Cover2();
		etendercomponentobj.selectEvaluationAndProvideCommentsForBidOpeningApproval4Cove2();
		etendercomponentobj.SendForApprovalInEvaluationsetting();
		etendercomponentobj.enterTenderIdInSearch();
		//etendercomponentobj.checktenderStatusIsInOpening(); //Issue raised, Defect ID: 136575
		etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Cover 2"); // might be, script will fail here
		etendercomponentobj.tenderLogout();
		
		//Login with opening approver for cover2
		etendercomponentobj.tenderApproverLogin();
		etendercomponentobj.validateTenderOpeningTab_ForBidOpeningUser();
		etendercomponentobj.clickDetailsLink();
		etendercomponentobj.validateBidOpeningApprovalpage("Cover 2", "3", "3");
		etendercomponentobj.provideApproverCommentInCommentsection();
		etendercomponentobj.clickApproveBtnAndCheckTenderIsDisplayingOrNotInTenderOpeningTab();
		etendercomponentobj.tenderLogout();
	
		//============change will be applied
		//Tender creator decrypt the bid for all the bidder cover2
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusIsInevaluationState();
		//etendercomponentobj.checktenderStageIsInevaluationStage();
		etendercomponentobj.clickPendingForEvaluationApprovalStage();
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.submitBidDetailPage();
		//etendercomponentobj.enterTenderIdInSearch();
		//etendercomponentobj.verifyTenderStageIsInFinalApprovalCover_1Or_Cover2();
		etendercomponentobj.tenderLogout();
		
		//Tender Evaluator evaluate(approve) the bid cover2
		etendercomponentobj.evaluator1Login();
		etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser();
		etendercomponentobj.clickDetailsLink();
		etendercomponentobj.evaluateSupplier("Tech Mahindra", "Approve", "Approve Tech Mahindra", 2);
		etendercomponentobj.evaluateSupplier("CTS", "Approve", "Approve CTS", 2);
		etendercomponentobj.evaluateSupplier("TCS", "Approve", "Approve TCS", 2);
		etendercomponentobj.enterOverallComment_EvaluatorUser();
		etendercomponentobj.tenderLogout();
	
		
		//validate evaluation approverWf data and Bid Details Data
		etendercomponentobj.evaluator1Login();
		etendercomponentobj.validateTenderEvaluationTabDetails_for_CompletedList();
		etendercomponentobj.clickDetailsLink();
		etendercomponentobj.validateEvaluationApprovalHistory();   //approval history validation
		etendercomponentobj.tenderLogoutOld();
		
		//============change will be applied
		//Checking tender status Completed
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusIsIncompletedState();
		etendercomponentobj.tenderLogout(); 
		
		
	}
}
