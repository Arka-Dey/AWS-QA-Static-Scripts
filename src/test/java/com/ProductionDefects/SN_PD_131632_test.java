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

public class SN_PD_131632_test extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
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
	public void ProductionDefect_131632(String no) throws Throwable {
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
		
		initializeRepository();
		etenderPRcomponentobj.updateFreshSNDetails();
		Dynamicity.updateDataIntoPropertyFile("snCreator", "RDCISSTG_INDENTCREATOR", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("snCreator_Password", "pass@123", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Organization", "RDCIS", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", "Yes", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Template", "Indigenous Tender (Supply & Service Both) V-4.0", filePath_4);
		
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		ProductionDefectobj.navigateToFreshSNCreation();
		ProductionDefectobj.sanctionReferenceNumberANDselectTG_msn();
		posttendercomponentobj.supplierSelection_MSN();
		dynamicity.fillup_Supplier_Specific_Detail_msn();
		posttendercomponentobj.ScantionComment_recommendationTab();
		posttendercomponentobj.clickOnSubmitButton();
		//posttendercomponentobj.documentNoSave();
		ProductionDefectobj.documentNoSave();
		posttendercomponentobj.notSendForApproval();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	}

}
