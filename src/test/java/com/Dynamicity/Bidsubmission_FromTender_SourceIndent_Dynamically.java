package com.Dynamicity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class Bidsubmission_FromTender_SourceIndent_Dynamically extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description ="Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void CreateTenderFromIndentDynamically(String no)
			throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		initializeRepository();
		
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentCreation();
		dynamicity.Indent_General_Info_Dynamic(Dynamicity.getDataFromPropertiesFile("IndentTemplate", filePath_4));
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
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		//Indent assignment Process (self claim)
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Tender", "Creator");
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
		//rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned");
		rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
		rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
				 
		//Create and publish RFQ from indent
		rfqfromintendcomponentobj.Create_RFQ_From_Indent(Dynamicity.getDataFromPropertiesFile("Template", filePath_4));
		dynamicity.generalInformation_TenderFromIndent();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.sendForNoApproval_validation_New();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached();
		try {
            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
            String[] suppliers = supplierValue.split(",\\s*");
            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
            String[] suppliersP = supplierPValue.split(",\\s*");
            System.out.println(suppliersP);
            
            for(String supplierP: suppliersP) {
            	supplierPasswords.add(supplierP);
            }
            int s=0;
	            for (String supplier : suppliers) {
	            	etenderPRcomponentobj.commonLogin(supplier, supplierPasswords.get(s), "BidSubmission", "Supplier");
					etendercomponentobj.VisitTenderListPage_BidderSide();
					etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
					etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted_Dynamic();
					//etendercomponentobj.navigateToActionDropdown_bidsubmission();
					etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
					dynamicity.generalInformaionSupplier();
					dynamicity.BidSubmission_ExGI();
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