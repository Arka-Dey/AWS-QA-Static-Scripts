package com.Sanction_Note_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class SN_02_Create_SN_From_Completed_Tender_Multiple_approver extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity = new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj = new PostTenderComponent(pdfResultReport);

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
	@Test(description = "Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void CreateFreshTenderDynamically(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(
					System.getProperty("user.dir").replace("\\", "/") + "/Resources/TG1_Testdata_static_scripts.xls",
					no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		initializeRepository();
		etenderPRcomponentobj.updateTendertoSNDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
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

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardParallelSNApprovalProcess(); // forward to sn_approver_03, sn_approver_04
																			// and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequentialSNApprovalProcess(); // forward to sn_approver_06, sn_approver_07
																			// and sn_approver_08(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		posttendercomponentobj.sanctionNoteEvaluationDecision("approve");
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover_AfterTakingDecision();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		posttendercomponentobj.provideApproverComment();
		etendercomponentobj.tenderApprovalDecision("Review Back to Creator");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.nevigateToPendingSNList();
		posttendercomponentobj.sendforApproverFromDraftSN();
		posttendercomponentobj.clickOnSubmitButton();
		posttendercomponentobj
				.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
		posttendercomponentobj.enterDocumentNoInSearch_PendinList();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// SN creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.nevigateToPendingSNList();
		posttendercomponentobj.enterDocumentNoInSearch_PendinList();
		posttendercomponentobj.recallButtonValidation();
		posttendercomponentobj.recallSuccessOk(); // need to raise defect
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf parallel and sequential with 3 parallel and 5
		// sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.nevigateToPendingSNList();
		posttendercomponentobj.sendforApproverFromDraftSN();
		posttendercomponentobj.clickOnSubmitButton();
		posttendercomponentobj
				.AddMultipleUsersForSequentialParallelApproval_SNWF("Reinitiated after reverted back the workflow");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// SN creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.nevigateToPendingSNList();
		posttendercomponentobj.enterDocumentNoInSearch_PendinList();
		posttendercomponentobj.recallButtonValidation();
		posttendercomponentobj.recallSuccessOk(); // need to raise defect
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// SN creator initiates WF again with 1 approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.nevigateToPendingSNList();
		posttendercomponentobj.sendforApproverFromDraftSN();
		posttendercomponentobj.clickOnSubmitButton();
		posttendercomponentobj.AddSingleUsersForSequentialApproval_SNWF_AfterRecall_Revert(
				pdfResultReport.testData.get("UserTenderApprover1"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover2"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover3"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover4"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover5"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover6"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover7"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_SNApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover8"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage();
		posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		posttendercomponentobj.sanctionNoteEvaluationValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("final approve Tender");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// verify SN status after approval
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
		posttendercomponentobj.clickPostTenderProcessLink();
		posttendercomponentobj.enterCompleted_TenderId_new();
		posttendercomponentobj.navigateToCompletedTenderDetailsPage();
		posttendercomponentobj.enterDocumentNoInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	}

}