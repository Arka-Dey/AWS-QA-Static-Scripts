package com.VerifyIndividualFunctionalityofApprovalFlow_Dynamic;

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

public class TC_03_Tender_creation_From_Indent_Revert_back_to_previous_approver extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
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
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
	//Creating a new Indent with No approval
		etenderPRcomponentobj.updateIndenttoTenderDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentCreation();
		dynamicity.Indent_General_Info_Dynamic(Dynamicity.getDataFromPropertiesFile("IndentTemplate", filePath_4));
		dynamicity.CreateIndentwithNonSOR();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSaveNew();
		rfqfromintendcomponentobj.NoApproval_IndentWF();
		//rfqfromintendcomponentobj.navigateToIndentListing();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		
		//Mark the created indent 'Marked for RFQ'
		rfqfromintendcomponentobj.Indent_Mark_for_RFQ_functionality();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Marked For RFQ");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		//Indent assignment Process (self claim)
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Tender", "Creator");
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
		//rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned"); 
		rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
		rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
				 
		//Create and publish RFQ from indent
		rfqfromintendcomponentobj.Create_RFQ_From_Indent(Dynamicity.getDataFromPropertiesFile("Template", filePath_4));
		dynamicity.generalInformation_TenderFromIndent();
		//dynamicity.CreateTenderFromPRwithNonSOR_STG();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.enterTenderIdInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	//verifying pending tender in 2nd approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.Verifying_Pendingtender_sequentialWF();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
				
	//approving pending tender in 1st approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		 etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					
	//approving pending tender in 2nd approver login	
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
			etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("forward");
			etendercomponentobj.sendForForwardParallelTenderApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		  //approver4
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		  //approver5
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("forward");
		  posttendercomponentobj.sendForForwardSequentialTenderApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		   
		  //approver6
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		  
		  //approver7
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	 
		  
		  //approver8
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		  //approver7
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		//approver8
		  posttendercomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("Review Back to Creator");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
			//verifying tender status 
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
			etendercomponentobj.navigateToTenderListing();
			etendercomponentobj.enterTenderIdInSearch();
			etendercomponentobj.checkTenderStatusAndTenderStage("Draft");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	}
}