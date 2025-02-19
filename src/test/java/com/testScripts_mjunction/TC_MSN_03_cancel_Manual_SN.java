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

public class TC_MSN_03_cancel_Manual_SN extends BaseClass_Web{
	
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
		posttendercomponentobj.sendForApprovalUserDefinedSequential_Coordinator_for_MSN();
		ProductionDefectobj.enterDocumentNoInSearch_msn();
		ProductionDefectobj.Validate_aggregationValueFromView_msn();
		etendercomponentobj.tenderLogoutOld();
		
		 //approver1
		ProductionDefectobj.commonLogin(ProductionDefectComponent.getDataFromPropertiesFile_PD("SNApprover1"), "SN", "SNApprover");
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationApproveForRDCIS();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
		  etendercomponentobj.tenderLogout();
		 
		  //approver2
		  ProductionDefectobj.commonLogin(ProductionDefectComponent.getDataFromPropertiesFile_PD("SNApprover2"), "SN", "SNApprover");
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  posttendercomponentobj.provideApproverComment();
		  posttendercomponentobj.sanctionNoteEvaluationApprove_RDCIS_C();
		  posttendercomponentobj.sanctionNoteCloseWorkflow_Repeat_Once();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
		  etendercomponentobj.tenderLogout();
		  
	 
			//cancel msn
			ProductionDefectobj.commonLogin(ProductionDefectComponent.getDataFromPropertiesFile_PD("SNCreator"), "SN", "SNCreator");
			ProductionDefectobj.navigateToFreshSNListingPage();
			ProductionDefectobj.enterDocumentNoInSearch_msn();
			ProductionDefectobj.validateMSNStatus("Completed");
			ProductionDefectobj.cancelMSN();
			ProductionDefectobj.varifyCancelMSN();
			
			ProductionDefectobj.varifyCancellationHistory();  
			etendercomponentobj.tenderLogoutOld();
			
			
	}

}
