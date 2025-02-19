package com.VerifyIndividualFunctionalityofApprovalFlow_Dynamic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class TC_Corrigendum_Corrigendum_Revert_back_to_creator extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
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
	@Test(description = "Date_Corrigendum_approval_Live_state_RFQ_from_Indent")
	public void Date_Corrigendum_approval_Live_state(String no) throws Throwable {
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
		etenderPRcomponentobj.updateCorrigendumDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderList_Only();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.initiateCorrigendum();
		etendercomponentobj.corrigendumSaveButton();
		dynamicity.Corrigendum_Tender();
		etendercomponentobj.clickSubmitBtn_Corrigendum();
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.enterTenderIdInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));

	//approving pending tender in 1st approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					
	//approving pending tender in 2nd approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardParallelTenderApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
		  //approver4
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
			etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		  //approver5
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover5"));
			etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("forward");
		  posttendercomponentobj.sendForForwardSequentialTenderApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		   
		  //approver6
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover6"));
			etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		  
		  //approver7
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
		  etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	 
		  
		  //approver8
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
		  etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("Review Back to Previous Approver");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		  //approver7
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover7"));
			etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		//approver8
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover8"));
			etendercomponentobj.GoToApprovalworkFlowPendingCorrigendumAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("Review Back to Creator");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
		//verifying tender status 
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
			etendercomponentobj.navigateToTenderListing();
			etendercomponentobj.enterTenderIdInSearch();
			etendercomponentobj.corrigendumStatus("Initiated");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	}
}