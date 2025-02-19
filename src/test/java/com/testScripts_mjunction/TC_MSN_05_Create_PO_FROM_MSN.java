package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.eTenderComponent;

public class TC_MSN_05_Create_PO_FROM_MSN extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
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
		reportDetails.put("Test Author Name", "Arka Dey");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	
	
	@Parameters("TestcaseNo")
	@Test(description = "Tenderpublished_after_tender_approval_tender_from_indent")
	public void MSN_01VerifyEndToEndWorkFlowOfSanctionNoteTest(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/ProductionDefects_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
		
		ProductionDefectobj.openURL(ProductionDefectComponent.getDataFromPropertiesFile_PD("Environment"));
		ProductionDefectobj.commonLogin(ProductionDefectComponent.getDataFromPropertiesFile_PD("SNCreator"), "SN", "SNCreator");
		ProductionDefectobj.navigateToFreshSNCreation();
		ProductionDefectobj.sanctionReferenceNumberANDselectTG_msn();
		ProductionDefectobj.supplierSelection_msn();
		ProductionDefectobj.validateTemplate_msn();
		ProductionDefectobj.ValidateBOM_Aggregation_msn();
		posttendercomponentobj.ScantionComment_recommendationTab();
		posttendercomponentobj.clickOnSubmitButton();
		ProductionDefectobj.documentNoSave();
		posttendercomponentobj.notSendForApproval();
		ProductionDefectobj.enterDocumentNoInSearch_msn();

		
		ProductionDefectobj.issuePObuttonValidationFromMSN();
		ProductionDefectobj.IssuePO_From_Completed_MSNList();
		ProductionDefectobj.Add_AllTemplate_Items_Submit();
		  posttendercomponentobj.Add_AllTemplate_Items_Submit();
		  posttendercomponentobj.InitiatePOfromSN();
		  posttendercomponentobj.EPS_PO_Submission();
		
		  posttendercomponentobj.POSaveandApproval();
		  posttendercomponentobj.savePoDocNumber();
		  posttendercomponentobj.ApprovalNotRequired();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Acceptance");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		  etendercomponentobj.tenderLogout();
		  
		  etendercomponentobj.bidder_01_Login();
		  posttendercomponentobj.navigateToPoListingWithBidderUser();
		  posttendercomponentobj.searchThePoRefNoInPoListPage_SupplierSide();
		  posttendercomponentobj.clickAcceptPoInDropDown();
		  posttendercomponentobj.verifySummaryTabAndEnterComment();
		  posttendercomponentobj.clickAccepPotBtn();
		  posttendercomponentobj.verifyPOStatusIsAccepted_SupplierSide();
		  etendercomponentobj.tenderLogout();
		  
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.navigateToPurchasrOrderList();
		  posttendercomponentobj.verifyPOStatusIsAccepted();
		  //posttendercomponentobj.validatePOPreviewDetails();  //po header validation
		  etendercomponentobj.tenderLogout();
		 
		 
		
			
			
	}

}
