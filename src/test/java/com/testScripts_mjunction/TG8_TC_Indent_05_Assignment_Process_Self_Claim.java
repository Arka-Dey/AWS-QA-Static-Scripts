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

public class TG8_TC_Indent_05_Assignment_Process_Self_Claim extends BaseClass_Web{
	
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
	@Test(description = "Verifying_indent_AssignmentProcess_selfClaim")
	public void Verifying_indent_AssignmentProcess_selfClaim_TG8(String no) throws Throwable {
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
		etendercomponentobj.tenderLogout();
	}

}
