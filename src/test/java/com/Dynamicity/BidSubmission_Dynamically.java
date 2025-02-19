	package com.Dynamicity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class BidSubmission_Dynamically extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	

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
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		
		initializeRepository();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		dynamicity.templateGroupDetails_And_UpdateTG(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4));
		//===========Bid submission process	======================================
		tID=Dynamicity.getDataFromPropertiesFile("tenderID", filePath_4);
		rfqfromintendcomponentobj.waitTillBidstartDateReached();
		try {
            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
            String[] suppliers = supplierValue.split(",\\s*");
            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
            String[] suppliersP = supplierPValue.split(",\\s*");
            
            for(String supplierP: suppliersP) {
            	supplierPasswords.add(supplierP);
           }
            s=0;
	            for (String supplier : suppliers) {
					etenderPRcomponentobj.commonLogin(supplier, supplierPasswords.get(s), "BidSubmission", "Supplier");
					etendercomponentobj.VisitTenderListPage_BidderSide();
					etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
					etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted_Dynamic();
					//etendercomponentobj.navigateToActionDropdown_bidsubmission();
					etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
					dynamicity.generalInformaionSupplier();
					dynamicity.BidSubmission_ExGI_MDV();
					etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
					etendercomponentobj.submitBid_link_in_previewAllPage();
					ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					s++;
	            	}
            	} 
				catch (IOException ex) {
	            ex.printStackTrace();
	     }
		}
	}