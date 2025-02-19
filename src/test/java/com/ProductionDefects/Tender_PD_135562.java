package com.ProductionDefects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Database.DatabaseComponent;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.API_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class Tender_PD_135562 extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
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
	@Test(description = "Tenderpublished_after_tender_approval_tender_from_indent")
	public void ProductionDefect_135540(String no) throws Throwable {
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
	Dynamicity.updateDataIntoPropertyFile("Organization", "HMEL", filePath_4);
	  Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("tenderID", "4890", filePath_4);
		  Dynamicity.updateDataIntoPropertyFile("Supplier", "JSL-DUMMY_VENDOR1", filePath_4);
		ProductionDefectobj.openURL("STG");
		etenderPRcomponentobj.commonLogin("HPCL_AUTOMATION_TC", "pass@123", "Tender", "Creator");
		  etendercomponentobj.navigateToTenderListing();
//		  etendercomponentobj.enterTenderIdInSearch();
		  etendercomponentobj.openClarificationOrDiscussion();
		  etendercomponentobj.inviteSupplier();		  
		  ProductionDefectobj.Logout("STG");   
		  

		  orgValue= DatabaseComponent.OrgID("HPCL_AUTOMATION_TC");
		  etenderPRcomponentobj.commonLogin("JSL-DUMMY_VENDOR1", "pass@123", "Clarification", "Supplier");
		  etendercomponentobj.supplierSideClarificationOrDiscussion();
			ProductionDefectobj.Logout("STG");
		}
	}	

/** 
135562	Defect	Closed	Severity - 2	GSML_Prod - Taking too much time to load buyer & supplier data in Clarification -> Add User 

*/
