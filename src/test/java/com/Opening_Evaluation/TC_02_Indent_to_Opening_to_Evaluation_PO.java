package com.Opening_Evaluation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class TC_02_Indent_to_Opening_to_Evaluation_PO extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
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
	@Test(description = "Tender_Evaluation_with_OpeningApproval_Y_Evaluationapproval_Y_RFQ_from_Indent")
	public void Tender_Evaluation_with_OpeningApproval_Y_Evaluationapproval_Y(String no) throws Throwable {
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
		etenderPRcomponentobj.updateIndent_to_PO_E2E();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		rfqfromintendcomponentobj.navigateToIndentCreation();
		dynamicity.Indent_General_Info_Dynamic(Dynamicity.getDataFromPropertiesFile("IndentTemplate", filePath_4));
		dynamicity.CreateIndentwithNonSOR();
		rfqfromintendcomponentobj.IndentTG1_Submit();
		rfqfromintendcomponentobj.SystemIndentNoSaveNew();
		rfqfromintendcomponentobj.NoApproval_IndentWF();
		rfqfromintendcomponentobj.enterIndentNoInSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Completed");
		
		//Mark the created indent 'Marked for RFQ'
		rfqfromintendcomponentobj.Indent_Mark_for_RFQ_functionality();
		mailAndAttachmentVeification(353 , 1,"Users will get intimation mail after Indent is Mark For Rfq");
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus("Marked For RFQ");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//Indent assignment Process (self claim)
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Tender", "Creator");
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
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
		etendercomponentobj.sendForNoApproval_validation_New();
		etendercomponentobj.enterTenderIdInSearch_Dynamic();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//===========Bid submission process	======================================
		rfqfromintendcomponentobj.waitTillBidstartDateReached();
		try {
            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
            String[] suppliers = supplierValue.split(",\\s*");
            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
            String[] suppliersP = supplierPValue.split(",\\s*");
            
            for(String supplierP: suppliersP) {
            	supplierPasswords.add(supplierP);
            }
            int s=0;
	            for (String supplier : suppliers) {
	            	etenderPRcomponentobj.commonLogin(supplier, supplierPasswords.get(s), "BidSubmission", "Supplier");
					etendercomponentobj.VisitTenderListPage_BidderSide();
					etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
					etendercomponentobj.navigateToActionDropdown_bidsubmissionBidWhereBidIsDraftedOrSubmitted_Dynamic();
					//etendercomponentobj.navigateToActionDropdown_bidsubmission();
					etendercomponentobj.newTermsAndServicesCheckBox_bidsubmission();
					dynamicity.generalInformaionSupplier();
					dynamicity.BidSubmission_ExGI();
					etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
					etendercomponentobj.submitBid_link_in_previewAllPage();
					ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					s++;
	            	}
            	} 
				catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
			rfqfromintendcomponentobj.waitTillBidDuetDateReached();
			waitForObj(150000);
			//rfqfromintendcomponentobj.waitTillBidOpentDateReached();
		//Evaluation: Cover 1 work flow where opening approval No and evaluation approval No 
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");		      
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();				
		etendercomponentobj.selectNoEvaluationsetting();		
		etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Pending for Evaluation Approval (Cover 1)");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.decryption_BidDetails();
		etendercomponentobj.bidDetailsEvaluation(1);
		etendercomponentobj.approveAllandSubmit();
		//Evaluation: Cover 2 work flow where opening approval No and evaluation approval No 
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.clickEvaluationSettingsLink();				
		etendercomponentobj.selectNoEvaluationsetting();		
		etendercomponentobj.checktenderStageIsInPendingForOpeningApprovalCover1("Pending for Evaluation Approval (Cover 2)");
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.decryption_BidDetails();
		etendercomponentobj.bidDetailsEvaluation(2);
		etendercomponentobj.approveAllandSubmit();		
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
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
		posttendercomponentobj.notSendForApproval();
		posttendercomponentobj.enterDocumentNoInSearch();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		posttendercomponentobj.navigateToPOList();
		posttendercomponentobj.CreatePOfromSN(Dynamicity.getDataFromPropertiesFile("CompletedSN", filePath_4), Dynamicity.getDataFromPropertiesFile("poTemplate", filePath_4));
		posttendercomponentobj.Add_SN_Items_Submit();
		posttendercomponentobj.InitiatePOfromSN();
		dynamicity.CreatePODynamically();
		posttendercomponentobj.POSaveandApproval();
		posttendercomponentobj.savePoDocNumber();
		posttendercomponentobj.ApprovalNotRequired();
		posttendercomponentobj.verifyPoRefNumberInPoListPage();
		posttendercomponentobj.verifyPOStatus("Pending for Acceptance");
		posttendercomponentobj.savePoDocNumberFromPoListpage();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		//supplier login  for accept PO
		 etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4),  Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4), "BidSubmission", "Supplier");
		 posttendercomponentobj.navigateToPoListingWithBidderUser();
		 posttendercomponentobj.searchThePoRefNoInPoListPage_SupplierSide();
		 posttendercomponentobj.clickAcceptPoInDropDown();
		 posttendercomponentobj.verifySummaryTabAndEnterComment();
		 posttendercomponentobj.clickAccepPotBtn();
		 posttendercomponentobj.verifyPOStatusIsAccepted_SupplierSide();
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
		 etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("poCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("poCreator_password", filePath_4), "PO", "Creator");
		 posttendercomponentobj.navigateToPurchasrOrderList();
		 posttendercomponentobj.verifyPOStatusIsAccepted();
		 ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
	}
}