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

public class TG9_TC_Indent_01_Creation_with_approval extends BaseClass_Web{
	
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
	public void Indent_creation_with_approval_TG8(String no) throws Throwable {
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
//Creating a new Indent with sequential 1 approver userdefined WF
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
		rfqfromintendcomponentobj.AddSingleUsersForSequentialApproval_IndentWF();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		etendercomponentobj.tenderLogout();
		
		//Approve the created indent
		rfqfromintendcomponentobj.IndentapproverLogin();
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		rfqfromintendcomponentobj.clickDetailLinkInApprovalListPage();
		rfqfromintendcomponentobj.ApproverOverAllComentWithIndentHasBeenApproved();
		etendercomponentobj.tenderLogout();
		
		//Verifying the indent status after approval
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearchInIndent();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		etendercomponentobj.tenderLogout();
	}

}
