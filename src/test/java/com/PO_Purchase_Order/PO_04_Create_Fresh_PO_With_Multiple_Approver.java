package com.PO_Purchase_Order;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import com.objectRepository.TenderCreation_Locators;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class PO_04_Create_Fresh_PO_With_Multiple_Approver extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity = new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj = new PostTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj = new TenderCreation_Locators();

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
	@Test(description = "Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void createPOFromSN_Dynamically(String no) throws Throwable {
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
		etenderPRcomponentobj.updateFreshPODetails();
		Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		ProductionDefectobj.openURL("STG");
		etenderPRcomponentobj.commonLogin("GSML_BUYER", "pass@123", "PO", "Creator");
		posttendercomponentobj.navigateToPOList();
		posttendercomponentobj.createFreshPO();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj.savePoDocNumber();
		posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
		posttendercomponentobj.verifyPoRefNumberInPoListPage();
		posttendercomponentobj.verifyPOStatus("Pending for Approval");
		posttendercomponentobj.savePoDocNumberFromPoListpage();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardParallelPOApprovalProcess(); // forward to sn_approver_02, sn_approver_03
																			// and sn_approver_04(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequentialSNApprovalProcess(); // forward to sn_approver_05, sn_approver_06
																			// and sn_approver_07(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Creator");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.verifyPOStatus("Draft (Rejected by approver)");
		posttendercomponentobj.editPO();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj
				.AddMultipleUsersForSequentialParallelApproval_PO_WF("Reinitiated after reverted back the workflow");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// PO creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.recallPOValidation();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// creator action initiate wf with 3 parallel and 5 sequential flow
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
		posttendercomponentobj.editPO();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj
				.AddMultipleUsersForSequentialParallelApproval_PO_WF("Reinitiated after reverted back the workflow");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// PO creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.recallPOValidation();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// PO creator initiates WF again with 1 approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.searchThePoRefNoInPoListPage();
		posttendercomponentobj.verifyPOStatus("Draft (Recalled)");
		posttendercomponentobj.editPO();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj.sendForApprovalUserDefinedSequential_pocreator();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver1
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover2"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver2
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover3"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver3
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover4"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver4
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover5"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver5
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover6"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver6
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover7"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("forward");
		posttendercomponentobj.sendForForwardSequential_Single_User_PO_ApprovalProcess(
				pdfResultReport.testData.get("UserTenderApprover8"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver7
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		posttendercomponentobj.purchaseOrderEvaluationDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// approver8
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		posttendercomponentobj.navigateToApprovalPendingPage(tendercreationobj.poTab);
		posttendercomponentobj.navigateToPurchaseOrderApproval();
		posttendercomponentobj.provide_PO_ApproverComment();
		etendercomponentobj.tenderApprovalDecision("final approve Tender");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		// supplier login
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4),
				Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		posttendercomponentobj.navigateToPoListingWithBidderUser();
		posttendercomponentobj.searchThePoRefNoInPoListPage_SupplierSide();
		posttendercomponentobj.clickAcceptPoInDropDown();
		posttendercomponentobj.verifySummaryTabAndEnterComment();
		posttendercomponentobj.clickAccepPotBtn();
		posttendercomponentobj.verifyPOStatusIsAccepted_SupplierSide();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4),
				Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPurchasrOrderList();
		posttendercomponentobj.verifyPOStatusIsAccepted();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	}

}