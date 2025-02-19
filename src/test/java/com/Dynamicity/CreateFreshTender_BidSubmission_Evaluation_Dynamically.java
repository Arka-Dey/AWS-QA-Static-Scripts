package com.Dynamicity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class CreateFreshTender_BidSubmission_Evaluation_Dynamically extends BaseClass_Web {
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		initializeRepository();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderList();
		dynamicity.generalInformation_FreshTender();
		//dynamicity.CreateTenderFromPRwithNonSOR_STG(); //dynamicity.tendercreator_template_DataAutoPopulate_Updated();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.sendForNoApproval_validation_New();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//===========Bid submission process	======================================
				rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
				try {
		            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
		            String[] suppliers = supplierValue.split(",\\s*");
		            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
		            String[] suppliersP = supplierPValue.split(",\\s*");
		            
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
							dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New(); //Scenario for apply to all
							//dynamicity.CreateTender_BidSubmission_withNonSOR();
							etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
							etendercomponentobj.submitBid_link_in_previewAllPage();
							/*
							etendercomponentobj.navigate_to_bidList_page();
							etendercomponentobj.enterTenderIdInSearch_bidsubmission_Old_Dynamic();
							etendercomponentobj.submittedBid_Tab_Validation_Dynamic();
							*/
							ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
							s++;
			            	}
		            	} 
						catch (IOException ex) {
			            ex.printStackTrace();
			        }
		
		//============Evaluation settings: Cover 1 =============================================
		rfqfromintendcomponentobj.waitTillBidDuetDateReached();
		rfqfromintendcomponentobj.waitTillBidOpentDateReached();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.clickEvaluationSettingsLink_Dynamic();		
		etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
		etendercomponentobj.selectEvaluatorAndProvideCommentsForBidEvaluationFlow_Dynamic("Evaluator");
		etendercomponentobj.SendForApprovalInEvaluationsetting();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//==============Decrypt cover 1 Bid details========================================
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checktenderStatusIsInevaluationState();
		//etendercomponentobj.checktenderStageIsInevaluationStage();
		etendercomponentobj.clickPendingForEvaluationApprovalStage();
		etendercomponentobj.decryptingTheBidder();
		etendercomponentobj.submitBidDetailPage();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		 
		//==============Evaluator evaluates cover1 Bid details===================================
		/*
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Evaluator", filePath_4), Dynamicity.getDataFromPropertiesFile("Evaluator_PWD", filePath_4), "Evaluation", "Evaluator");
		etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser_Dynamic();
		etendercomponentobj.clickDetailsLink();
		for(s=1; s<=suppliercount; s++ ) {
		dynamicity.evaluateSupplier_Dynamic(Dynamicity.getDataFromPropertiesFile("Supplier"+s+"", filePath_4), "Approve", "Approve Supplier"+s+"", 1);
		}
		etendercomponentobj.enterOverallComment_EvaluatorUser();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//=============Evaluation Settings: Cover 2 ================================================
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.clickEvaluationSettingsLink_Dynamic();
		etendercomponentobj.selectYesForApprovalAndEvaluationRequired();
		if(!Dynamicity.getDataFromPropertiesFile("Decryptor_Cover2", filePath_4).equalsIgnoreCase("")) {
		etendercomponentobj.SelectDecryptor("Decryptor_Cover2");
		}
		etendercomponentobj.selectEvaluatorAndProvideCommentsForBidEvaluationFlow_Cover2_Dynamic("Evaluator_Cover2");
		etendercomponentobj.SendForApprovalInEvaluationsetting();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//============Decryptor/TC decrypts cover2 Bid details===========================
		if(!Dynamicity.getDataFromPropertiesFile("Decryptor_Cover2", filePath_4).equalsIgnoreCase("")) {
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Decryptor_Cover2", filePath_4), Dynamicity.getDataFromPropertiesFile("Decryptor_Cover2_PWD", filePath_4), "Tender", "Decryptor");
			etendercomponentobj.Visit_Decryptor_PendingPage();
			etendercomponentobj.decryptingTheBidder();
			etendercomponentobj.submitBidDetailPage();
			etendercomponentobj.enterTenderIdInSearch_Dynamic();
			ProductionDefectobj.LogoutOld(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		}
		else {
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
			etendercomponentobj.navigateToTenderListing();
			etendercomponentobj.enterTenderIdInSearch();
			etendercomponentobj.checktenderStatusIsInevaluationState();
			//etendercomponentobj.checktenderStageIsInevaluationStage();
			etendercomponentobj.clickPendingForEvaluationApprovalStage();
			etendercomponentobj.decryptingTheBidder();
			etendercomponentobj.submitBidDetailPage();
			etendercomponentobj.enterTenderIdInSearch_Dynamic();
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		}
		
		
		//Tender Evaluator evaluate(approve) the bid cover2
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Evaluator", filePath_4), Dynamicity.getDataFromPropertiesFile("Evaluator_PWD", filePath_4), "Evaluation", "Evaluator");
		etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser_Dynamic();
		etendercomponentobj.clickDetailsLink();
		for(s=1; s<=suppliercount; s++ ) {
		dynamicity.evaluateSupplier_Dynamic(Dynamicity.getDataFromPropertiesFile("Supplier"+s+"", filePath_4), "Approve", "Approve Tech Mahindra", 2);
		}
		etendercomponentobj.enterOverallComment_EvaluatorUser();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//===============Checking tender status Completed=============================================
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checktenderStatusIsIncompletedState();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		*/
		}
	}