package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;

public class TG7_TC_Negotiation_17_Openingapproval_N_Evaluationapproval_N_NegotiateTwobidder_RejectOnebidder extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	

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
	@Test(description = "Tender_Evaluation_with_OpeningApproval_N_Evaluationapproval_N_NegotiateTwobidder_RejectOnebidder")
	public void Tender_Evaluation_with_OpeningApproval_N_Evaluationapproval_N_NegotiateTwobidder_RejectOnebidder_TG7(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG7_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}

		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
//Creating a new Open tender with approval type Not Required
		etendercomponentobj.openURL();
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.createTenderWithNewRfq();
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableGeneralInfoWithThreeBidders("SERVICES_v1.1");
		etendercomponentobj.TG3_RFQ_attachmentsTab_Verifying();
		etendercomponentobj.TG3_RFQ_TermsAndConditionsTab();
		etendercomponentobj.TG3_RFQ_CommercialTermsAndConditionsTab();
		etendercomponentobj.TG7_RFQ_PrebidDiscussionTab_Verifying_Services_v1();
		etendercomponentobj.TG7_RFQ_RFQItemTab_Verifying();
		//etendercomponentobj.TG7_RFQ_PriceFormatTab_Verifying_Services_v1();
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableDateSchedule(3,19,20);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.tenderIdSave();
		etendercomponentobj.sendForNoApproval_validation();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		etendercomponentobj.tenderLogout();

	//Bid submission process for bidder1	
		etendercomponentobj.waitTillBidstartDateReached();
		etendercomponentobj.bidder_01_Login();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		etendercomponentobj.generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		etendercomponentobj.TG7_Bidsubmission_ListSparePartsAndEquipmentsWithoutPriceTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_DateSchedule_attachmentsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_TermsConditionsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_CommercialTermsConditionsTab_Verifying();
		etendercomponentobj.TG7_BidSubmission_PriceFormatTab_Verifying();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG7_validateAllInPrevieAllSubmitbidPage();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogout();
		
	//Bid submission process for bidder2		
		etendercomponentobj.bidder_02_Login();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		etendercomponentobj.generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		etendercomponentobj.TG7_Bidsubmission_ListSparePartsAndEquipmentsWithoutPriceTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_DateSchedule_attachmentsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_TermsConditionsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_CommercialTermsConditionsTab_Verifying();
		etendercomponentobj.TG7_BidSubmission_PriceFormatTab_Verifying();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG7_validateAllInPrevieAllSubmitbidPage();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogout();
		
	//Bid submission process for bidder3		
		etendercomponentobj.bidder_03_Login();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		etendercomponentobj.generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		etendercomponentobj.TG7_Bidsubmission_ListSparePartsAndEquipmentsWithoutPriceTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_DateSchedule_attachmentsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_TermsConditionsTab_Verifying();
		etendercomponentobj.TG3_BidSubmission_CommercialTermsConditionsTab_Verifying();
		etendercomponentobj.TG7_BidSubmission_PriceFormatTab_Verifying();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG7_validateAllInPrevieAllSubmitbidPage();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogout();

	//Evaluation: Cover 1 work flow
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.waitTillBidDuetDateReached();
		etendercomponentobj.waitTillBidOpentDateReached();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();
		etendercomponentobj.SendForApprovalInEvaluationsetting();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickPendingForEvaluationApprovalStage_new();
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("CTS_AUTO_01");
		etendercomponentobj.TG7_validateBidDetails_EveN_ForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("CTS_AUTO_01",
				"CTS test (CTS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TCS_AUTO_01");
		etendercomponentobj.TG7_validateBidDetails_EveN_ForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectNegotiateForTheBidder("TCS_AUTO_01", "TCS test (TCS_AUTO_01) is successfully Negotiated", 
				"Mandatory");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TECH_AUTO_01");
		etendercomponentobj.TG7_validateBidDetails_EveN_ForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectNegotiateForTheBidder("TECH_AUTO_01", "Tech Mahindra test (TECH_AUTO_01) is successfully Negotiated", 
				"Mandatory");
		etendercomponentobj.enterOverallComment();
		
		// Negotiation WorkFlow for the bidder TCS and Tech Mahindra
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusAndTenderStage();
		etendercomponentobj.clickInitiateNegotiationLink();
		etendercomponentobj.negotiationDetailPageValidation_new();
		etendercomponentobj.negotiation_dateSchedule(4, 14);
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.negotiationTenderStatusAndTenderStage();
		etendercomponentobj.tenderLogout();
		
		etendercomponentobj.waitTillBidstartDateReached();
		
		// Bid submission of the negotiated bidder TCS
		etendercomponentobj.bidder_02_Login();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.BidNoSave();
		etendercomponentobj.TG7_negotiatedBidderSubmission();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.VerifyBidno_after_Negotiatedbid();
		etendercomponentobj.TG7_validateBidPreview_BidListPage(); 
		etendercomponentobj.tenderLogout();
		
		// Bid submission of the negotiated bidder Tech Mahindra
		etendercomponentobj.bidder_03_Login();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.BidNoSave();
		etendercomponentobj.TG7_negotiatedBidderSubmission();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.VerifyBidno_after_Negotiatedbid();
		etendercomponentobj.TG7_validateBidPreview_BidListPage();
		etendercomponentobj.tenderLogout();
		
		etendercomponentobj.waitTillBidDuetDateReached();
		
		//Evaluation: Cover 1 work flow after negotiation
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();
		etendercomponentobj.Submitevalsettings_ConfirmationPopUpValidation_new();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusIsInevaluationState();
		etendercomponentobj.clickPendingForEvaluationApprovalStage_new(); 
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TCS_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover2_afterNegotiation();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder_new("TCS_AUTO_01",
				"TCS test (TCS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TECH_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover2_afterNegotiation();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder_new("TECH_AUTO_01",
				"Tech Mahindra test (TECH_AUTO_01) is successfully Approved");
		etendercomponentobj.enterOverallComment();
		
		//Check tender status Completed
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusIsIncompletedState();
		etendercomponentobj.tenderLogout();
	}
}
