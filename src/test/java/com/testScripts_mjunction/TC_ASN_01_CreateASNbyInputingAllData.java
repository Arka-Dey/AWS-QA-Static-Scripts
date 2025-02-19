package com.testScripts_mjunction;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.ASN_GRNComponent;
import com.components.PostTenderComponent;
import com.components.PreConditionPo_SanctionCreation;
import com.components.eTenderComponent;

public class TC_ASN_01_CreateASNbyInputingAllData extends BaseClass_Web {

	public PreConditionPo_SanctionCreation preConditionPo = new PreConditionPo_SanctionCreation(pdfResultReport);
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj = new PostTenderComponent(pdfResultReport);
	public ASN_GRNComponent ASN_GRNComponent = new ASN_GRNComponent(pdfResultReport);

	/**
	 * TestScript Environment Details
	 * 
	 * @throws Exception
	 */
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "6");
		reportDetails.put("Test Author Name", "Bhowmick");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description = "TC_ASN_01: CreateASNbyInputingAllData")
	public void CreateASNbyInputingAllData(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TenderCreation_CreateNewRFQ_TestData_pt2.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		
		  initializeRepository();
		  etendercomponentobj.openURL();
		  
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.clickPostTenderProcessLink();
		  posttendercomponentobj.enterCompleted_TenderId_new() ;
		 
		  posttendercomponentobj.createSanctionNote();
		  posttendercomponentobj.sanctionReferenceNumber();
		  posttendercomponentobj.SanctionsupplierOrgNameWiseSelection("CTS");
		  posttendercomponentobj.SanctionItemsAllotment();
		  posttendercomponentobj.ScantionComment_recommendationTab();
		  posttendercomponentobj.clickOnSubmitButton();
		  posttendercomponentobj.notSendForApproval();
		
		  posttendercomponentobj.enterDocumentNoInSearch();
		  
		  posttendercomponentobj.issuePObuttonValidation();
		  posttendercomponentobj.IssuePO_From_Completed_SNList();
		  posttendercomponentobj.Add_AllTemplate_Items_Submit();
		  posttendercomponentobj.InitiatePOfromSN();
		  posttendercomponentobj.EPS_PO_Submission();
		
		  posttendercomponentobj.POSaveandApproval();
		  posttendercomponentobj.savePoDocNumber();
		  posttendercomponentobj.ApprovalNotRequired();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Acceptance");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		  etendercomponentobj.tenderLogout();
	  
		  etendercomponentobj.bidder_01_Login();
		  posttendercomponentobj.navigateToPoListingWithBidderUser();
		  posttendercomponentobj.searchThePoRefNoInPoListPage_SupplierSide();
		  posttendercomponentobj.clickAcceptPoInDropDown();
		  posttendercomponentobj.verifySummaryTabAndEnterComment();
		  posttendercomponentobj.clickAccepPotBtn();
		  posttendercomponentobj.verifyPOStatusIsAccepted_SupplierSide();
		  etendercomponentobj.tenderLogout();
		  
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.navigateToPurchasrOrderList();
		  posttendercomponentobj.verifyPOStatusIsAccepted();
		  etendercomponentobj.tenderLogout();
	  
		  etendercomponentobj.bidder_01_Login();
		  ASN_GRNComponent.SelectASNModule();
		  ASN_GRNComponent.CreateASN();
		  ASN_GRNComponent.SaveASN();
		  ASN_GRNComponent.myInformationTab();
		  //=========My Information Tab ==========
		  	/*
			ASN_GRNComponent.TabMyInformation();
			ASN_GRNComponent.verifyMyInformationTabFieldsAutoPopulated();
		   */
		  //========================================
		  ASN_GRNComponent.TabShipmentInformation("Patna");
		  ASN_GRNComponent.TabWhatIamShippingWithBoxesOnly("10", "80", "AU");
		  ASN_GRNComponent.TabDeliveryChallenChecklist();
		  ASN_GRNComponent.TabInvoice("Invoice");
		  ASN_GRNComponent.SaveASN();
		  ASN_GRNComponent.SubmitASN();
		  /*
		  ASN_GRNComponent.ASNListPage();
		  ASN_GRNComponent.SearchPoInASNList();
		  */
		  ASN_GRNComponent.SearchASNRefInASNList();
		  //ASN_GRNComponent.VerifyDraftStatus();
		  ASN_GRNComponent.VerifyStatus("Approved");
		  etendercomponentobj.tenderLogoutOld();
		

	}

}
