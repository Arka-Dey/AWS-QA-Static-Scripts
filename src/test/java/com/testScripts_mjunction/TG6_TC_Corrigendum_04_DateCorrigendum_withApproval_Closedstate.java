package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;

public class TG6_TC_Corrigendum_04_DateCorrigendum_withApproval_Closedstate extends BaseClass_Web{
	
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
	@Test(description = "Date_Corrigendum_approval_closed_state")
	public void Date_Corrigendum_approval_closed_state_TG6(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG6_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}

		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
//Creating a new tender with approval type Not Required
		etendercomponentobj.openURL();
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.createTenderWithNewRfq();
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableGeneralInfoWithThreeBidders("RAW MATERIAL_v1");
		etendercomponentobj.TG3_RFQ_attachmentsTab_Verifying();
		etendercomponentobj.TG3_RFQ_TermsAndConditionsTab();
		etendercomponentobj.TG3_RFQ_CommercialTermsAndConditionsTab();
		etendercomponentobj.TG6_RFQ_RFQItemTab_Verifying();
		etendercomponentobj.Tender_WithOptionalItemsAndQtyEditableDateSchedule(4,5,42);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.tenderIdSave();
		etendercomponentobj.sendForNoApproval_validation();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		etendercomponentobj.tenderLogout();
		
	//Date corrigendum during Closed tender status
		etendercomponentobj.waitTillBidDuetDateReached();
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.datecorrigendum();
		etendercomponentobj.corrigendumSaveButton();
		etendercomponentobj.modifyDateScheduleTemplate1(30,35);  
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.tenderLogout();
		
	//verifying pending corrigendum in 2nd approver login	
		etendercomponentobj.tenderApprover2Login();
		etendercomponentobj.Verifying_Pendingtender_Corrigendumtab_sequentialWF();
		etendercomponentobj.tenderLogout();
	
	//Verifying pending corrigendum in 1st approver login and approve the corrigendum 
		etendercomponentobj.tenderApproverLogin();
		etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
		etendercomponentobj.clickDetailLinkInApprovalListPage_CorrigendumApproval();
		etendercomponentobj.provideApproverCommentsForDateScheduleTab();
		etendercomponentobj.ApproverOverAllComentWithCorrigendumHasBeenApproved();
		etendercomponentobj.tenderLogout();
		
	//Verifying pending corrigendum in 2nd approver login and approve the corrigendum 
		etendercomponentobj.tenderApprover2Login();
		etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
		etendercomponentobj.clickDetailLinkInApprovalListPage_CorrigendumApproval();
		etendercomponentobj.provideApproverCommentsForDateScheduleTab();
		etendercomponentobj.ApproverOverAllComentWithCorrigendumHasBeenApproved();
		etendercomponentobj.tenderLogout();
		
	//Verifying Corrigendum status and corrigendum history
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.corrigendumStatus();
		etendercomponentobj.corrigendumStatus_Yes_Hyperlink_Validation();
		etendercomponentobj.corrigendumNumber_Hyperlink_Validation();
		etendercomponentobj.corrigendumHistory_Hyperlink_Validation();
		etendercomponentobj.checkLive_tenderstatus_after_corrigendum();
		etendercomponentobj.tenderLogout();
	}

}
