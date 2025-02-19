package com.Dynamicity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;


public class CreateTender_BidSubmission_FromPR_Dynamically extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);

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
	@Test(description ="Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void createTenderBidSubmissionFromPR_Dynamically(String no)
			throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
		initializeRepository();
		etenderPRcomponentobj.updatePRtoTenderDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", filePath_4), "PR", "Creator");
		etenderPRcomponentobj.navigateToPRList();
			if(Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4).equalsIgnoreCase("")) {
				int PRItemCount= Integer.parseInt(Dynamicity.getDataFromPropertiesFile("PRItemCount", filePath_4));
				if(PRItemCount>=50){
					double prPost= PRItemCount/50;
					String prPostS=Double.toString(prPost);
					 // Splitting the string based on the decimal point
			        String[] parts = prPostS.split("\\.");

			        // Extracting the parts
			        String beforeDecimal = parts[0]; // Part before the decimal point
			        String afterDecimal = parts[1]; // Part after the decimal point
			        int pr50=Integer.parseInt(beforeDecimal);
			        int prRest50=(PRItemCount-(pr50*50));
			        for(int pc=0; pc<pr50; pc++){
						API_Component.prUpload();
						if(pc<(pr50-2)) {
						String refresh="(//button[@class='btn refresh px-2'])[2]";
						boolean fielddisplay=isElementDisplayed_Updated(By.xpath(refresh), 60);
						boolean interactable=isElementEnable_Updated(By.xpath(refresh), 60);
						System.out.println("Field is displayed after uploading PR ("+(pc+1)+"): " + fielddisplay);
						System.out.println("Field is interactable after uploading PR ("+(pc+1)+"): " + interactable);

						if (fielddisplay == true && interactable == true) {
							click(By.xpath(refresh), "Refresh");
								}
							}
						}
			        if(prRest50>0) {
			        	for(int pc=0; pc<prRest50; pc++){
							API_Component.prUploadForSingleItem();
							}
			        }
				}
				else {
					if(PRItemCount<50) {
			        	for(int pc=0; pc<PRItemCount; pc++){
							API_Component.prUploadForSingleItem();
							if(pc%4==0) {
								String refresh="(//button[@class='btn refresh px-2'])[2]";
								click(By.xpath(refresh), "Refresh");
								}
							}
			        }
				}
				etenderPRcomponentobj.enterPRInSearch();
			}
			else {
				etenderPRcomponentobj.enterPRInSearch_ExceptHMEL();
			}
			if(Dynamicity.getDataFromPropertiesFile("RowCount", filePath_4).equalsIgnoreCase("All")) {
				etenderPRcomponentobj.itemAllSelection();
			}
			else {
			etenderPRcomponentobj.itemWiseSelection(Dynamicity.getDataFromPropertiesFile("RowCount", filePath_4));
			}
		etenderPRcomponentobj.createTenderFromPR();
		dynamicity.generalInformation();
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

		}
	}