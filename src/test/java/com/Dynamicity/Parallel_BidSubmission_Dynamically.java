package com.Dynamicity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class Parallel_BidSubmission_Dynamically extends BaseClass_Web {
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
	@Test(description ="Scenario:0 -Capture JSResponse")
	public void CaptureJSResponse(String no)
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
		
		etendercomponentobj.openURL();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderList();
		dynamicity.templateGroupDetails();
		etendercomponentobj.tenderLogoutOld_Stg();
		}
	
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:1 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission1stSupplier_Dynamically(String no)
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
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier1", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:2 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission2ndSupplier_Dynamically(String no)
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
		universalWait();
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier2", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:3 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission3rdSupplier_Dynamically(String no)
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
		universalWait();
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier3", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:4 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission4thSupplier_Dynamically(String no)
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
		universalWait();
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier4", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:5 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission5thSupplier_Dynamically(String no)
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
		universalWait();
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier5", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	
	@Parameters("TestcaseNo")
	@Test(description ="Scenario:6 -Verify Bidsubmission functionality of a bidder")
	public void BidSubmission6thSupplier_Dynamically(String no)
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
		universalWait();
		universalWait();
		initializeRepository();
		etendercomponentobj.openURL();
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier6", filePath_4), Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
		etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted();
		//etendercomponentobj.navigateToActionDropdown_bidsubmission();
		etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
		dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New();
		etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
		etendercomponentobj.submitBid_link_in_previewAllPage();
		etendercomponentobj.navigate_to_bidList_page();
		etendercomponentobj.enterTenderIdInSearch_bidsubmission();
		etendercomponentobj.submittedBid_Tab_Validation();
		etendercomponentobj.tenderLogoutOld();
		
		}
	}