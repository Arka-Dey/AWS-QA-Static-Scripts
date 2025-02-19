package com.testScripts_mjunction;


import com.components.PostTenderComponent;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.eTenderComponent;

public class TC_EPS_PO_07_Amend_PO extends BaseClass_Web {

	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {		
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "jit");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	@Parameters("TestcaseNo")
	@Test(description = "Scenario:1 - Verify the functionality of End to End workflow of Sanction Note")
  public void f(String no) throws Throwable {
	  System.out.println("Entered in the Test method..................");
	  try {
		pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TenderCreation_CreateNewRFQ_TestData_pt2.xls", no);
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
	  posttendercomponentobj.amendPO();
	  etendercomponentobj.tenderLogout();
	  
	  posttendercomponentobj.sanction_Creator_Login();
	  posttendercomponentobj.clickPostTenderProcessLink();
	  posttendercomponentobj.enterCompleted_TenderId_new() ;
	  posttendercomponentobj.clickOnSnStage();
	  posttendercomponentobj.enterDocumentNoInSearch();
	  posttendercomponentobj.amendSN();
	  posttendercomponentobj.SanctionsupplierOrgNameWiseSelection("CTS");
	  posttendercomponentobj.assignAmendItems("100");
	  posttendercomponentobj.ScantionComment_recommendationTab();
	  posttendercomponentobj.clickOnSubmitButton();
	  posttendercomponentobj.documentNoSave();
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
	  posttendercomponentobj.validateItemInPOPreview();
	  
	  etendercomponentobj.tenderLogout();
	 
	}
}
