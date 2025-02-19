package com.Dynamicity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class CreateDraftTender_FromPR_Dynamically extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	

	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Arka");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description ="Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void createEvaluationFromPR_Dynamically(String no)
			throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		initializeRepository();
		etendercomponentobj.openURL();
		
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderList();
		dynamicity.templateGroupDetails();
		//==============Fetch All fields Names for new TG====================
				if(!Dynamicity.getDataFromPropertiesFile("Template", filePath_4).equalsIgnoreCase(Dynamicity.getDataFromPropertiesFile("Template", filePath_3))) {
				dynamicity.fetchAllFieldNames_RFQ();
				}
		//===================================================================
		etenderPRcomponentobj.navigateToPRList();
		if(Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4).equalsIgnoreCase("")) {
			API_Component.prUpload();
			etenderPRcomponentobj.enterPRInSearch();
		}
		else {
			etenderPRcomponentobj.enterPRInSearch_ExceptHMEL();
		}
		etenderPRcomponentobj.itemAllSelection();
		etenderPRcomponentobj.createTenderFromPR();
		//dynamicity.CreateTenderFromPRwithNonSOR_STG();
		etendercomponentobj.tenderLogoutOld_Stg();
		}
	}