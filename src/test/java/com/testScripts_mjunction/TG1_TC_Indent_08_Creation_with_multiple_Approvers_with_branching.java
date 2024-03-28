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

public class TG1_TC_Indent_08_Creation_with_multiple_Approvers_with_branching extends BaseClass_Web{
	
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
	public void Indent_creation_with_approval(String no) throws Throwable {
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
//Creating a new Indent with sequential 1 approver userdefined WF
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
		rfqfromintendcomponentobj.AddMultipleUsersForSequentialApproval_IndentWF();
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
		
		//sent for branching by s1
		rfqfromintendcomponentobj.IndentapproverLogin();
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.aproverBranching("Mr Test Approver01","Mr Test Approver02");
		etendercomponentobj.tenderLogout();
		
		//action by branch b1(S2) user
		rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("Approver1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.sendBackToApprover("Indent Process Is Approved by branch user b1(S2)"); 
		etendercomponentobj.tenderLogoutOld();
		
		//action by branch b2 user
				rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("Approver2"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.sendBackToApprover("Indent Process Is Approved by branch user b2"); 
				etendercomponentobj.tenderLogoutOld();
				
				//approve s1 approver
				rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("IndentApproverUserName"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.approveByApproverAfterBranching();
				etendercomponentobj.tenderLogoutOld();
				
				//sent for branching by s2
				rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("Approver1"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.aproverBranching("Mr Indent Approver test","Mr Test Approver03");
				etendercomponentobj.tenderLogout();
				
				//action by branch b3(S1) user
				rfqfromintendcomponentobj.IndentapproverLogin();
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.sendBackToApprover("Indent Process Is Approved by branch user b3(S1)"); 
				etendercomponentobj.tenderLogoutOld();
				
				//action by branch b4 user
				rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("Approver3"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.sendBackToApprover("Indent Process Is Approved by branch user b4"); 
				etendercomponentobj.tenderLogoutOld();
				
				//approve s2 approver
				rfqfromintendcomponentobj.IndentapproverLogin(pdfResultReport.testData.get("Approver1"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
				rfqfromintendcomponentobj.ApproverOverAllComentWithIndentHasBeenApproved();
				etendercomponentobj.tenderLogoutOld();
				
						
				//Verifying the indent status after approval
				rfqfromintendcomponentobj.IndentcreatorLogin();
				rfqfromintendcomponentobj.navigateToIndentListing();
				rfqfromintendcomponentobj.enterIndentNoInSearch();
				rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
				etendercomponentobj.tenderLogout();
				
				
				
				
				
		
	}
}