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

public class TG8_TC_Evaluation_13_Openingapproval_N_Evaluationapproval_N extends BaseClass_Web{
	
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
	@Test(description = "Tender_Evaluation_with_OpeningApproval_N_Evaluationapproval_N_RFQ_from_Indent")
	public void Tender_Evaluation_with_OpeningApproval_N_Evaluationapproval_N_TG8(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG8_Testdata_static_scripts.xls", no);
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
		rfqfromintendcomponentobj.IndentTG8_General_Info_tabvalidation("Indent Purchase Contract V-004");
		rfqfromintendcomponentobj.IndentTG8_Indent_Details_tabvalidation();
		rfqfromintendcomponentobj.IndentTG8_Eligibility_Criteria_tabvalidation();
		rfqfromintendcomponentobj.IndentTG8_BOM_Item_tabvalidation();
		rfqfromintendcomponentobj.IndentTG8_technical_Specification_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Annexures_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSave();
		rfqfromintendcomponentobj.NoApproval_IndentWF();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearchInIndent();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");

	//Mark the created indent 'Marked for RFQ'
		rfqfromintendcomponentobj.Indent_Mark_for_RFQ_functionality();
		rfqfromintendcomponentobj.enterIndentNoInSearchInIndent();
		rfqfromintendcomponentobj.VerifyIndentStatus("Marked For RFQ");
		etendercomponentobj.tenderLogout();
		
	//Indent assignment Process (self claim)
		etendercomponentobj.tendercreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoInSearchInTender();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
		rfqfromintendcomponentobj.enterIndentNoInSearchInTender();
		rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned");
		rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
		rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
		
	//Create and publish RFQ from indent
		rfqfromintendcomponentobj.Create_RFQ_From_Indent("Tender for Purchase Contract V-4.0");
		rfqfromintendcomponentobj.PublishTender_from_indent_withRFQ_TG8("Tender for Purchase Contract V-4.0",5,25,26);
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
		rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG8("Tender for Purchase Contract V-4.0");
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG8_validateAllInPrevieAllSubmitbidPage();
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
		etendercomponentobj.TG1_generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG8("Tender for Purchase Contract V-4.0");
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG8_validateAllInPrevieAllSubmitbidPage();
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
		etendercomponentobj.TG1_generalInformationPageValidation_bidsubmission();
		etendercomponentobj.quotationReferenceCode_bidsubmission();
		rfqfromintendcomponentobj.BidSubmission_for_Tender_from_indent_withRFQ_TG8("Tender for Purchase Contract V-4.0");
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.TG8_validateAllInPrevieAllSubmitbidPage();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogout();

	//Evaluation: Cover 1 work flow
		etendercomponentobj.tendercreatorLogin();
		rfqfromintendcomponentobj.waitTillBidDuetDateReached();
		rfqfromintendcomponentobj.waitTillBidOpentDateReached();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();
		etendercomponentobj.SendForApprovalInEvaluationsetting();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickPendingForEvaluationApprovalStage_new();  //etendercomponentobj.clickPendingForEvaluationApprovalStage();
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("CTS_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("CTS_AUTO_01",
				"CTS test (CTS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TCS_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("TCS_AUTO_01",
				"TCS test (TCS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TECH_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover1();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("TECH_AUTO_01",
				"Tech Mahindra test (TECH_AUTO_01) is successfully Approved");
		etendercomponentobj.enterOverallComment();

	//Evaluation: Cover 2 work flow
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusAndTenderStage();
		etendercomponentobj.clickEvaluationSettingsLink();
		etendercomponentobj.SendForApprovalInEvaluationsetting();
        etendercomponentobj.enterTenderIdInSearch();
        etendercomponentobj.clickPendingForEvaluationApprovalStage_new(); //etendercomponentobj.clickPendingForEvaluationApprovalStage();
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("CTS_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover2();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("CTS_AUTO_01",
				"CTS test (CTS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TCS_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover2();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("TCS_AUTO_01",
				"TCS test (TCS_AUTO_01) is successfully Approved");
		etendercomponentobj.clickBidDetailsSectionForchoosenBidder("TECH_AUTO_01");
		etendercomponentobj.TG1_validateBidDetailsForCover2();
		etendercomponentobj.clickEditableLinkPendingStatusAndSelectApproveForTheBidder("TECH_AUTO_01",
				"Tech Mahindra test (TECH_AUTO_01) is successfully Approved");
		//Check tender status Completed
		etendercomponentobj.enterOverallComment();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checktenderStatusIsIncompletedState();
		etendercomponentobj.tenderLogout();
	}
}
