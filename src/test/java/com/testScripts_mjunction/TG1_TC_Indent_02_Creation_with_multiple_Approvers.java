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
import com.objectRepository.TenderCreation_Locators;

public class TG1_TC_Indent_02_Creation_with_multiple_Approvers extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	TenderCreation_Locators tendercreationlocators = new TenderCreation_Locators();

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
	@Test(description = "Indent_creation_with_approval")
	public void Indent_creation_with_multiapproval(String no) throws Throwable {
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
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Forward_IndentWF_With_ParallelApprovalType(); //forward to test_approver_01, test_approver_02 and test_approver_03(c), min app: 2
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_02"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_03 (coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Forward_IndentWF_With_SequentialApprovalType(); 
		etendercomponentobj.tenderLogout();
		 
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_04"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_05"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_06 (coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Revert_Indent_to_PreviousApprover("Indent Process Is Reverted by test_approver_06"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_05 after reverted back by test_approver_06"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_06 (coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Revert_Indent_to_Creator("Indent Process Is Reverted by test_approver_06"); 
		etendercomponentobj.tenderLogout();
		
		//Indent creator initiates WF again with 10 approvers in parallel and sequential but recall it before taking decision by any approver
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		rfqfromintendcomponentobj.AddMultipleUsersForSequentialParallelApproval_IndentWF("Reinitiated after reverted back the workflow");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
 
		//Indent creator recalls WF before taking decision by any approver
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		rfqfromintendcomponentobj.recallWF("Recall the workflow by creator");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		etendercomponentobj.tenderLogout();
		
		//Indent creator initiates WF again with 10 approvers in parallel and sequential but recall it after taking decision by some approvers
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		rfqfromintendcomponentobj.AddMultipleUsersForSequentialParallelApproval_IndentWF("Reinitiated after reverted back the workflow");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
			
		//Login with test_approver_01 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_01"); 
		etendercomponentobj.tenderLogout();
			
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_02"); 
		etendercomponentobj.tenderLogout();
				
		//Login with test_approver_03 (coordinator but not WF coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_03"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_04"); 
		etendercomponentobj.tenderLogout();
				
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_05"); 
		etendercomponentobj.tenderLogout();
				
		//Login with test_approver_06 (non coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Reverted by test_approver_06"); 
		etendercomponentobj.tenderLogout();
	
		//Indent creator recalls WF before taking decision by any approver
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		rfqfromintendcomponentobj.recallWF("Recall the workflow by creator");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		etendercomponentobj.tenderLogout();
		
		
		//Indent creator initiates WF again with 1 approver
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		rfqfromintendcomponentobj.AddSingleUsersForSequentialApproval_IndentWF_AfterRecall_Revert(pdfResultReport.testData.get("User_Indent_Approver"));
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
		
		//Login with User_Indent_Approver (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("IndentApproverUserName"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_01 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_03 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_06 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		 
		
		//Login with test_approver_07 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver7"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_08 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver8"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_09 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver9"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Recall by test_approver_09 from test_approver_10 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver9"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowCompletedindentAndSearchTheIndent();
		rfqfromintendcomponentobj.RecallFromApprovalCompletedListPage("Recall by previous approver"); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_09 to test_approver_10 again (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver9"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1")); 
		etendercomponentobj.tenderLogout();
		
		//Login with test_approver_10 and approve finally (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver10"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.ApproverOverAllComentWithIndentHasBeenApproved(); 
		rfqfromintendcomponentobj.validateIndentApprovalHistoryAtApproverEnd();   //validate approver history tab at approver end
		etendercomponentobj.tenderLogout();
				
				
		//Verifying the indent status after approval
		 rfqfromintendcomponentobj.IndentcreatorLogin();
		 rfqfromintendcomponentobj.navigateToIndentListing();
		 rfqfromintendcomponentobj.enterIndentNoInSearch();
		 rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		 
		//preview tab validation  validatePreviewData
		 rfqfromintendcomponentobj.validatePreviewData();   //validate preview tab validation at creator end
		 rfqfromintendcomponentobj.enterIndentNoInSearch();
		 rfqfromintendcomponentobj.valiateIndentApproverHistory();   //validate indent approver history preview data at creator end
		 etendercomponentobj.tenderLogout();
			 
	}

}
