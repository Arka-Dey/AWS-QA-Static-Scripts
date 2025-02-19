package com.Indent_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class TC_08_Indent_Mail_Validation extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	
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
	public void CreateIndentDynamically(String no)
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
		etenderPRcomponentobj.updateIndentDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentCreation();
		dynamicity.Indent_General_Info_Dynamic(Dynamicity.getDataFromPropertiesFile("IndentTemplate", filePath_4));
		dynamicity.CreateIndentwithNonSOR();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSaveNew();
		rfqfromintendcomponentobj.AddSingleUsersForSequentialApproval_IndentWF( pdfResultReport.testData.get("UserTenderApprover1"));
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		 
		//Approve the created indent
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_ParallelApprovalType(); //forward to test_approver_02, test_approver_03 and test_approver_04(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_03 (coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_SequentialApprovalType(); //forward to test_approver_05, test_approver_06 and test_approver_07(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		 
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_06 (coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");  
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_06 (coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Creator"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Indent creator initiates WF again with 10 approvers in parallel and sequential but recall it before taking decision by any approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "PR", "Creator");
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.edit_Indent_after_Recall_Review();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Indent_WF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
 
		//Indent creator recalls WF before taking decision by any approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "PR", "Creator");
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		rfqfromintendcomponentobj.recallWF("Recall the workflow by creator");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Indent creator initiates WF again with 10 approvers in parallel and sequential but recall it after taking decision by some approvers
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "PR", "Creator");
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.edit_Indent_after_Recall_Review();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Indent_WF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
		//Login with test_approver_01 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
		//Login with test_approver_03 (coordinator but not WF coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
		//Login with test_approver_06 (non coordinator) revert back to previous approver
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve"); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		//Indent creator recalls WF before taking decision by any approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		rfqfromintendcomponentobj.recallWF("Recall the workflow by creator");
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		
		//Indent creator initiates WF again with 1 approver
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Draft");
		rfqfromintendcomponentobj.AddSingleUsersForSequentialApproval_IndentWF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1"));
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Pending For Approval");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
			//Login with test_approver_01 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover2"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		//Login with test_approver_02 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover3"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_03 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover3"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover4"));
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_04 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover5")); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		//Login with test_approver_05 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover6")); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		//Login with test_approver_06 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover7")); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		//Login with test_approver_07 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		rfqfromintendcomponentobj.Forward_IndentWF_With_Single_SequentialApprovalType(pdfResultReport.testData.get("UserTenderApprover8")); 
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Login with test_approver_08 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
		//Login with test_approver_07 (non coordinator)
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("approve");  
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		//Login with test_approver_08 (non coordinator)
				rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
				rfqfromintendcomponentobj.GoToApprovalworkFlowPendingindentAndSearchTheIndent();
				etendercomponentobj.TenderApproverValidation();
				etendercomponentobj.provideApproverCommentforTenderApprover();
				etendercomponentobj.tenderApprovalDecision("final approve Indent");  
				ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));		
			
		//Verifying the indent status after approval
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		 rfqfromintendcomponentobj.navigateToIndentListing();
		 rfqfromintendcomponentobj.enterIndentNoInSearch();
		 rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			 
		 
		//validate mail
			etenderPRcomponentobj.commonLogin(pdfResultReport.testData.get("adminUserName"), pdfResultReport.testData.get("AppPassword"), "MJADMIN", "MJADMIN");
			rfqfromintendcomponentobj.nevigateToMailDetails();
			rfqfromintendcomponentobj.validateMailAfterSendForApproval();
			etendercomponentobj.tenderLogoutOld();
	 
	}

}

		
		