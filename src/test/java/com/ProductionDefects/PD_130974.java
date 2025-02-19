package com.ProductionDefects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class PD_130974 extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	
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
	@Test(description = "Tenderpublished_after_tender_approval_tender_from_indent")
	public void ProductionDefect_130974(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/ProductionDefects_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
	//Creating a new Indent with No approval
		
		ProductionDefectobj.openURL("STG");
		etenderPRcomponentobj.commonLogin("RDCIS_AUTOMATION_TC", "pass@123", "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentCreation();
		dynamicity.Indent_General_Info_Dynamic("Indigenous Indent (Supply & Service Both) V-004");
		dynamicity.CreateIndentwithNonSOR();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSaveNew();
		rfqfromintendcomponentobj.NoApproval_IndentWF();
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		
		//Mark the created indent 'Marked for RFQ'
		rfqfromintendcomponentobj.Indent_Mark_for_RFQ_functionality();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Marked For RFQ");
		ProductionDefectobj.Logout("STG");
			
		//Indent assignment Process (self claim)
		etenderPRcomponentobj.commonLogin("RDCIS_AUTOMATION_TC", "pass@123", "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
		//rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned");
		rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
		rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
				 
		//Create and publish RFQ from indent
		rfqfromintendcomponentobj.Create_RFQ_From_Indent("Live Indigenous Tender (Supply & Service) V-3.3");
		dynamicity.generalInformation_TenderFromIndent();
		//dynamicity.CreateTenderFromPRwithNonSOR_STG();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.sendForNoApproval_validation_New();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		ProductionDefectobj.Logout("STG");

		etenderPRcomponentobj.commonLogin("RDCIS_AUTOMATION_TC", "pass@123", "Indent", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.cancelTender();
		rfqfromintendcomponentobj.validateCancelledMessage();
		etendercomponentobj.checkTenderStatusforCancelledorDeleted("Cancelled");
		ProductionDefectobj.Logout("STG");
		
		}
	}