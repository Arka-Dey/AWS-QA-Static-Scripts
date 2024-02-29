package com.testScripts_mjunction;

import java.util.Arrays;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.components.ASN_GRNComponent;
import com.components.PostTenderComponent;
import com.components.PreConditionPo_SanctionCreation;
import com.components.eTenderComponent;
import com.objectRepository.TenderCreation_Locators;

public class TC_GRN_01_Create3StagesGRN_WithoutApprovalFlow extends BaseClass_Web{
	PreConditionPo_SanctionCreation preConditionPo = new PreConditionPo_SanctionCreation(pdfResultReport);
	public eTenderComponent etendercomponentobj =new eTenderComponent(pdfResultReport);
	public TenderCreation_Locators tendercreationobj =new TenderCreation_Locators(); 
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);
    public ASN_GRNComponent asn_grncomponentobj=new ASN_GRNComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {		
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "05");
		reportDetails.put("Test Author Name", "Vamshi");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	@Parameters("TestcaseNo")
	@Test(description = "TC_GRN_01:Verify the Submit Functionality during Create GRN & Check the GRN Status as Created")
  public void Create3StagesGRN_WithoutApprovalFlow(String no) throws Throwable {
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
		  posttendercomponentobj.ApprovalNotRequired();
		  posttendercomponentobj.verifyPoRefNumberInPoListPage();
		  posttendercomponentobj.verifyPOStatus("Pending for Acceptance");
		  posttendercomponentobj.savePoDocNumberFromPoListpage();
		  etendercomponentobj.tenderLogout();
		  
		  etendercomponentobj.bidder_01_Login();
		  posttendercomponentobj.navigateToPoListingWithBidderUser();
		  posttendercomponentobj.searchThePoRefNoInPoListPage();
		  posttendercomponentobj.clickAcceptPoInDropDown();
		  posttendercomponentobj.verifySummaryTabAndEnterComment();
		  posttendercomponentobj.clickAccepPotBtn();
		  posttendercomponentobj.verifyPOStatusIsAccepted();
		  etendercomponentobj.tenderLogout();
		  
		  posttendercomponentobj.sanction_Creator_Login();
		  posttendercomponentobj.navigateToPurchasrOrderList();
		  posttendercomponentobj.verifyPOStatusIsAccepted();
		  etendercomponentobj.tenderLogout();
		 
		  etendercomponentobj.bidder_01_Login();
		  asn_grncomponentobj.SelectASNModule();
		  asn_grncomponentobj.CreateASN();
		  asn_grncomponentobj.SaveASN();
		  asn_grncomponentobj.myInformationTab();
		  asn_grncomponentobj.TabShipmentInformation("Patna");
		  asn_grncomponentobj.TabWhatIamShippingWithBoxesOnly("10", "80", "AU");
		  asn_grncomponentobj.TabDeliveryChallenChecklist();
		  asn_grncomponentobj.TabInvoice("Invoice");
		  asn_grncomponentobj.SaveASN();
		  asn_grncomponentobj.SubmitASN();
		  asn_grncomponentobj.SearchASNRefInASNList();
		  asn_grncomponentobj.VerifyStatus("Completed");
		  etendercomponentobj.tenderLogoutOld();
		  
	     //Gate Pass creation
 		 asn_grncomponentobj.GRN_Creator_Login();
 		 asn_grncomponentobj.navigateToApprovedASNListPage();
 		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
 		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
 		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
 		 asn_grncomponentobj.grnAttachment();
 		 asn_grncomponentobj.saveGrnDetails();
 		 asn_grncomponentobj.submitGrnDetails1("Yes");
 		 asn_grncomponentobj.grnNotSendForApproval();
 		 asn_grncomponentobj.verifyGRNStatus("Pending for QC creation");
 		 etendercomponentobj.tenderLogout();
 		 
 		 //QC creation
 		asn_grncomponentobj.GRN_Creator_Login();
		 asn_grncomponentobj.navigateToApprovedASNListPage();
		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.grnAttachment();
		 asn_grncomponentobj.saveGrnDetails();
		 asn_grncomponentobj.submitGrnDetails1("Yes");
		 asn_grncomponentobj.grnNotSendForApproval();
		 asn_grncomponentobj.verifyGRNStatus("Pending for QV creation");
		 etendercomponentobj.tenderLogout();
		 
		 //QV creation
		 asn_grncomponentobj.GRN_Creator_Login();
		 asn_grncomponentobj.navigateToApprovedASNListPage();
		 asn_grncomponentobj.enterASNShipmentAndSelectVendorName("CTS");
		 asn_grncomponentobj.clickApprovedAsnListActionMenu(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.createGrn(eTenderComponent.getDataFromPropertiesFile("ASNNum"));
		 asn_grncomponentobj.grn_InspectionDetails();
		 asn_grncomponentobj.grnAttachment();
		 asn_grncomponentobj.saveGrnDetails();
		 asn_grncomponentobj.submitGrnDetails1("Yes");
		 /*
		 //This method needs application configuration, unless this method does not required for this flow
		 /*asn_grncomponentobj.submitNotificationTab();
		 */
		 asn_grncomponentobj.grnNotSendForApproval();
		 asn_grncomponentobj.verifyGRNStatus("QV completed");
		 etendercomponentobj.tenderLogout();
 		  
	}

}
