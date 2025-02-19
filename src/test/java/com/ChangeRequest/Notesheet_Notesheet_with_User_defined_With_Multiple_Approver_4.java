package com.ChangeRequest;

import com.components.Change_request_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class Notesheet_Notesheet_with_User_defined_With_Multiple_Approver_4 extends BaseClass_Web {

	public Change_request_Component change_requestobj = new Change_request_Component(pdfResultReport);
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity = new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj = new PostTenderComponent(pdfResultReport);

	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "3");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description = "Scenario:3 - Verify the functionality of Notesheet with user defined multiple approver workflow")
	public void f(String no) throws Throwable {
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
		etenderPRcomponentobj.updateNotesheetDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.createNotesheet();
		change_requestobj.noteSheetSubmit();
		change_requestobj.AddTwoUsersForSequentialApproval();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// Approve the created Notesheet
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardParallelTenderApprovalProcess(); // forward to sn_approver_03, sn_approver_04
																			// and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequentialNoteSheetApprovalProcess(); // forward to sn_approver_06,
																				// sn_approver_07 and sn_approver_08(c),
																				// min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("Review Back to Creator");
		mailAndAttachmentVeification(409, 1,
				"Approver(s) or Creator will get an intimation mail after document is reviewed by Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.editNotesheet();
		change_requestobj.noteSheetSubmit();
		change_requestobj.AddMultipleUsersForSequentialParallelApproval_Notesheet_WF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// notesheet creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.recallNotesheet();
		mailAndAttachmentVeification(412, 1,
				"Approver(s) will get an intimation mail after NoteSheet is recalled by the creator");
		mailAndAttachmentVeification(413, 1,
				"In case of parallel group, approver(s) who have not taken any action yet will get an intimation mail after document is approved/reviewed by the coordinator");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator again initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.editNotesheet();
		change_requestobj.noteSheetSubmit();
		change_requestobj.AddMultipleUsersForSequentialParallelApproval_Notesheet_WF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// notesheet creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.recallNotesheet();
		change_requestobj.verifyNoteSheetStatus("Draft");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// notesheet creator initiates WF again with 1 approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.editNotesheet();
		change_requestobj.noteSheetSubmit();
		change_requestobj
				.AddSingleUsersForSequentialApproval_NotesheetWF(pdfResultReport.testData.get("UserTenderApprover1"));
		change_requestobj.verifyNoteSheetStatus("Pending For Approval");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover2"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover3"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover4"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover5"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover6"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover7"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("forward");
		change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover8"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		change_requestobj.appprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
		change_requestobj.TenderApproverValidation();
		change_requestobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("final approve Tender");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// Verifying the Notesheet status after approval
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.verifyNoteSheetStatus("Completed");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	}
}