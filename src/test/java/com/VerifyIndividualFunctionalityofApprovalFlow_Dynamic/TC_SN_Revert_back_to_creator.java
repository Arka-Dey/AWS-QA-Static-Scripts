package com.VerifyIndividualFunctionalityofApprovalFlow_Dynamic;


import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;


public class TC_SN_Revert_back_to_creator extends BaseClass_Web {

	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	
	public void initializeRepository() throws Exception {		
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "2");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	@Parameters("TestcaseNo")
	@Test(description = "Scenario:2 - Verify the functionality of End to End workflow of Sanction Note with Userdefine workflow")
  public void f(String no) throws Throwable {
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
		etenderPRcomponentobj.updateTendertoSNDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		etendercomponentobj.vistCompletedTenderList();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.createSanctionFromCompletedTenderList();
		etendercomponentobj.fillup_SanctionNoteReference();
		posttendercomponentobj.supplierSelection_SN();
		dynamicity.fillup_Supplier_Specific_Detail();
		posttendercomponentobj.ScantionComment_recommendationTab();
		posttendercomponentobj.clickOnSubmitButton();
		posttendercomponentobj.documentNoSave();
	  posttendercomponentobj.sendForApprovalUserDefinedSequential_Coordinator();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));  
	  
	  //approver1
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationApprove();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	 
	  //approver2
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("forward");
	  posttendercomponentobj.sendForForwardParallelSNApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
		  
	 	  
	  //approver4
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	
	//approver5
	  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
	  posttendercomponentobj.navigateToApprovalPendingPage();
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
	  posttendercomponentobj.sanctionNoteEvaluationValidation();
	  posttendercomponentobj.provideApproverComment();
	  posttendercomponentobj.sanctionNoteEvaluationDecision("Review Back to Creator");
	  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	   
	  //verify SN status
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.navigateToCompletedTenderDetailsPage();
	  posttendercomponentobj.enterDocumentNoInSearch_PendinList();
	  posttendercomponentobj.verifySNSatus("Draft");
	 		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4)); 
	 

}}