package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;

public class TG4_TC_BidSubmission_07_verifying_Rebid_functionality extends BaseClass_Web{
	
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
	@Test(description = "Verifying_Rebid_functionality")
	public void Verifying_Rebid_functionality_TG4(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG4_Testdata_static_scripts.xls", no);
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
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableGeneralInfoWithThreeBidders("Purchase_FPU_Type1&2_v2.3");
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableDateSchedule(6,40,42);
		etendercomponentobj.Tender_PrebidDiscussionTab_Verifying_TG4(29,32);
		etendercomponentobj.TG3_RFQ_attachmentsTab_Verifying();
		etendercomponentobj.TG4_RFQ_NITTermsAndConditionsTab();
		etendercomponentobj.TG4_SpecAndTechnicalReqCompTab();
		etendercomponentobj.TG4_RFQItemTab();
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.tenderIdSave();
		etendercomponentobj.sendForNoApproval_validation();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		etendercomponentobj.tenderLogout();

	//Bid submission process	
		etendercomponentobj.waitTillBidstartDateReached();
		etendercomponentobj.bidder_01_Login();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		etendercomponentobj.generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		etendercomponentobj.TG4_BidSubmission_attachmentsTab_Verifying();
		etendercomponentobj.TG4_BidSubmission_TermsConditionsTab_Verifying();
		etendercomponentobj.TG4_BidSubmission_TechnicalComplianceTableTab_Verifying();
		etendercomponentobj.TG4_BidSubmission_RFQItemTab_Verifying();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG4_validateAllInPrevieAllSubmitbidPage();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.TG4_validateTenderpreviewInBidListPage();
		etendercomponentobj.TG4_validateBidPreview_BidListPage();
		etendercomponentobj.BidNoSave();

	//Rebid functionality verification
		etendercomponentobj.reBid_bidListPage();
		etendercomponentobj.TG4_Bid_submission_during_Rebid();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.VerifyBidno_after_rebid();
		etendercomponentobj.tenderLogout();
	}

}
