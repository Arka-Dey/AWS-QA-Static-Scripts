package com.Sanction_Note_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class SN_14_Create_SN_From_Completed_Tender_with_branching extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
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
	public void CreateFreshTenderDynamically(String no)
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
 
		//approving pending tender in 1st approver login	
			//sent for branching by s1
					rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
					posttendercomponentobj.navigateToApprovalPendingPage();
					  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  posttendercomponentobj.sanctionNoteEvaluationValidation();
					rfqfromintendcomponentobj.aproverBranching(Dynamicity.getDataFromPropertiesFile("Total_Branch_User", filePath_4),Dynamicity.getDataFromPropertiesFile("Dicision_taken_by_branch_user", filePath_4));
					ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					
					
					for (int i = 2; i <Integer.parseInt(Dynamicity.getDataFromPropertiesFile("Total_Branch_User", filePath_4)) +1 ; i++) {
						String	UserTenderApprover="UserTenderApprover"+i;
						rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get(UserTenderApprover));
						  posttendercomponentobj.navigateToApprovalPendingPage();
						  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
						  posttendercomponentobj.sanctionNoteEvaluationValidation();
						rfqfromintendcomponentobj.sendBackToApprover("Indent Process Is Approved by branch user b1(S2)"); 
						ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					}
						 
		 
		  //approver1
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	 
		  //approver2
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		  posttendercomponentobj.navigateToApprovalPendingPage();
		  posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  posttendercomponentobj.sanctionNoteEvaluationValidation();
		  etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("forward");
			etendercomponentobj.tenderApprovalDecision("final approve Tender");
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		  //verify SN status after approval
		 etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		  posttendercomponentobj.navigateToCompletedTenderDetailsPage();
		  posttendercomponentobj.enterDocumentNoInSearch();
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  }
	}