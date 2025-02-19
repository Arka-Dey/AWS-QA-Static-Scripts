package com.Tender_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.API_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class TC_02_TenderCreation_From_PR_with_multiple_approver extends BaseClass_Web {

	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public Dynamicity dynamicity = new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj = new PostTenderComponent(pdfResultReport);

	/**
	 * TestScript Environment Details
	 * 
	 * @throws Exception
	 */
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Venkatesh Jujjuru");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description = "Tenderpublished_after_tender_approval_tender_from_indent")
	public void Tenderpublished_after_tender_approval_TG1(String no) throws Throwable {
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
		etenderPRcomponentobj.updatePRtoTenderDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etenderPRcomponentobj.navigateToPRList();
		if (Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4).equalsIgnoreCase("")) {
			int PRItemCount = Integer.parseInt(Dynamicity.getDataFromPropertiesFile("PRItemCount", filePath_4));
			if (PRItemCount >= 50) {
				double prPost = PRItemCount / 50;
				String prPostS = Double.toString(prPost);
				// Splitting the string based on the decimal point
				String[] parts = prPostS.split("\\.");

				// Extracting the parts
				String beforeDecimal = parts[0]; // Part before the decimal point
				String afterDecimal = parts[1]; // Part after the decimal point
				int pr50 = Integer.parseInt(beforeDecimal);
				int prRest50 = (PRItemCount - (pr50 * 50));
				for (int pc = 1; pc <= pr50; pc++) {
					API_Component.prUpload();
					if (pc < (pr50 - 2)) {
						String refresh = "(//button[@class='btn refresh px-2'])[2]";
						boolean fielddisplay = isElementDisplayed_Updated(By.xpath(refresh), 5);
						boolean interactable = isElementEnable_Updated(By.xpath(refresh), 5);
						System.out.println("Field is displayed after uploading PR (" + (pc + 1) + "): " + fielddisplay);
						System.out.println(
								"Field is interactable after uploading PR (" + (pc + 1) + "): " + interactable);

						if (fielddisplay == true && interactable == true) {
							click(By.xpath(refresh), "Refresh");
						}
					}
				}
				if (prRest50 > 0) {
					for (int pc = 0; pc < prRest50; pc++) {
						API_Component.prUploadForSingleItem();
						if (pc % 4 == 0) {
							String refresh = "(//button[@class='btn refresh px-2'])[2]";
							click(By.xpath(refresh), "Refresh");
						}
					}
				}
			} else {
				if (PRItemCount < 50) {
					for (int pc = 0; pc < PRItemCount; pc++) {
						API_Component.prUploadForSingleItem();
						if (pc % 4 == 0) {
							String refresh = "(//button[@class='btn refresh px-2'])[2]";
							click(By.xpath(refresh), "Refresh");
						}
					}
				}
			}
			etenderPRcomponentobj.enterPRInSearch();
		} else {
			etenderPRcomponentobj.enterPRInSearch_ExceptHMEL();
		}
		if (Dynamicity.getDataFromPropertiesFile("RowCount", filePath_4).equalsIgnoreCase("All")) {
			etenderPRcomponentobj.itemAllSelection();
		} else {
			etenderPRcomponentobj.itemWiseSelection(Dynamicity.getDataFromPropertiesFile("RowCount", filePath_4));
		}
		etenderPRcomponentobj.createTenderFromPR();
		dynamicity.generalInformation();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.enterTenderIdInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// verifying pending tender in 2nd approver login
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.Verifying_Pendingtender_sequentialWF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approving pending tender in 1st approver login
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approving pending tender in 2nd approver login
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardParallelTenderApprovalProcess(); // forward to sn_approver_03, sn_approver_04
																			// and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		posttendercomponentobj.sendForForwardSequentialTenderApprovalProcess(); // forward to sn_approver_06,
																				// sn_approver_07 and sn_approver_08(c)
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Creator");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.editDraftTender();
		// etendercomponentobj.updateDateScheduleAtDraftTender(30,55,56);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF(
				"Reinitiated after reverted back the workflow");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// tender creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.recallTender();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.editDraftTender();
		// etendercomponentobj.updateDateScheduleAtDraftTender(30,55,56);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF(
				"Reinitiated after reverted back the workflow");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		// posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// tender creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.recallTender();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// ender creator initiates WF again with 1 approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.editDraftTender();
		// etendercomponentobj.updateDateScheduleAtDraftTender(45,55,56);
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(
				pdfResultReport.testData.get("UserTenderApprover1"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover2"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover3"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover4"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover5"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover6"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover7"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover8"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("final approve Tender");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// verifying Published tender status
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkTenderStatusAndTenderStage("Published");
		etendercomponentobj.validateApprovalHistoryAtTenderCreatorEnd(); // validate approval history at tender creator
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	}

}
