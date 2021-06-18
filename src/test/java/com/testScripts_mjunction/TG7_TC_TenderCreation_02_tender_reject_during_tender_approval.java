package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;

public class TG7_TC_TenderCreation_02_tender_reject_during_tender_approval extends BaseClass_Web{
	
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
	@Test(description = "TenderReject_after_tender_approval")
	public void TenderReject_after_tender_approval_TG7(String no) throws Throwable {
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
//Creating a new tender with sequential 2 approver userdefined WF
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
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableDateSchedule(25,40,42);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.tenderIdSave();
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.tenderLogout();
		
	//Reviewing pending tender in 1st approver login	
		etendercomponentobj.tenderApproverLogin();
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.TG7_tenderApprover_dynamicity();
		etendercomponentobj.ReviewTender_withoverall_comment();
		etendercomponentobj.tenderLogout();
		
	//verifying pending tender in 2nd approver login	
		etendercomponentobj.tenderApprover2Login();
		etendercomponentobj.Verifying_Pendingtender_sequentialWF();
		etendercomponentobj.tenderLogout();
		
	//verifying Draft tender status 
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkDraft_tenderstatus_after_review();
		etendercomponentobj.tenderLogout();
		
	}

}
