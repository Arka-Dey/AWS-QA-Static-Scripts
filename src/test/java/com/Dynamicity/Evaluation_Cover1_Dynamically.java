package com.Dynamicity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class Evaluation_Cover1_Dynamically extends BaseClass_Web {
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
		dynamicity.templateGroupDetails_afterQueryparamCaptured(Dynamicity.getDataFromPropertiesFile("tokenExtractor", filePath_4));
		int suppliercount = Integer.parseInt(Dynamicity.getDataFromPropertiesFile("supplierCount", filePath_4));
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//============Evaluation settings: Cover 1 =============================================
		rfqfromintendcomponentobj.waitTillBidDuetDateReached();
		rfqfromintendcomponentobj.waitTillBidOpentDateReached();
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "Tender", "Creator");
		etenderPRcomponentobj.SupplierOrgWiseLogin();
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
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Evaluator", filePath_4), Dynamicity.getDataFromPropertiesFile("Evaluator_PWD", filePath_4), "Evaluation", "Evaluator");
		etendercomponentobj.validateTenderEvaluationTabDetails_WithEvaluatorUser_Dynamic();
		etendercomponentobj.clickDetailsLink();
		for(s=1; s<=suppliercount; s++ ) {
		dynamicity.evaluateSupplier_Dynamic(Dynamicity.getDataFromPropertiesFile("Supplier"+s+"", filePath_4), "Approve", "Approve Supplier"+s+"", 1);
		}
		etendercomponentobj.enterOverallComment_EvaluatorUser();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		}
	}