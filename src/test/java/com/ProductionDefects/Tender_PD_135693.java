package com.ProductionDefects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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

public class Tender_PD_135693 extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
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
	public void ProductionDefect_135540(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/ProductionDefects_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
				initializeRepository();
				//Creating a new Indent with sequential 1 approver userdefined WF
				ProductionDefectobj.openURL("STG");
				etendercomponentobj.SupplierRegistration();
				etendercomponentobj.fillRegistrationDetails();
//				etendercomponentobj.switchTab();
//				rfqfromintendcomponentobj.adminLogin();
				etendercomponentobj.getOTP();
				etendercomponentobj.itemCategoryandOrganization();
//				etendercomponentobj.setUserName();
				rfqfromintendcomponentobj.adminLogin();
				etendercomponentobj.resetPassword();
				etendercomponentobj.validateLogin();
				 ProductionDefectobj.Logout("STG");
				

				dynamicity.templateGroupDetails_And_UpdateTG(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4));
				//===========Bid submission process	======================================
				
				rfqfromintendcomponentobj.waitTillBidstartDateReached_Dynamic();
				try {
		            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
		            String[] suppliers = supplierValue.split(",\\s*");
		            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
		            String[] suppliersP = supplierPValue.split(",\\s*");
		            System.out.println(suppliersP);
		            
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
							dynamicity.CreateTender_BidSubmission_FromPRwithNonSOR_STG_New(); //Scenario for apply to all
							//dynamicity.CreateTender_BidSubmission_withNonSOR();
							etendercomponentobj.mandatoryFieldValidation_submitButton_bidsubmission();
							etendercomponentobj.submitBid_link_in_previewAllPage();
							/*
							etendercomponentobj.navigate_to_bidList_page();
							etendercomponentobj.enterTenderIdInSearch_bidsubmission_Dynamic();
							etendercomponentobj.submittedBid_Tab_Validation_Dynamic();
							*/
							 ProductionDefectobj.Logout("STG");
							s++;
			            	}
		            	} 
						catch (IOException ex) {
			            ex.printStackTrace();
			        }
				}
			}


