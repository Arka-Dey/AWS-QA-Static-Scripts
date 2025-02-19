package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.RfqFromIndentComponent;
import com.components.eTenderComponent;

public class TG1_TC_Indent_07_Creation_with_Predefined_approval extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
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
		rfqfromintendcomponentobj.addPredefinedIndentApprover();
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
	
		
		//S1 approver 
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("IndentApproverUserName"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by indent_approver_02"); 
		etendercomponentobj.tenderLogout();
		
		//S2 approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_01"); 
		etendercomponentobj.tenderLogout();
		
		//P1 approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_02"); 
		etendercomponentobj.tenderLogout();
		
		//P2 approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.Approve_Indent_by_NonCoordinators("Indent Process Is Approved by test_approver_03"); 
		etendercomponentobj.tenderLogout();
		
		//P3 approver (C)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("Approver5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.ApproverOverAllComentWithIndentHasBeenApproved();
		etendercomponentobj.tenderLogout();
		
	}
}
