package com.ProductionDefects;

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

public class Tender_PD_134705 extends BaseClass_Web{
	
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
		etenderPRcomponentobj.updatePRtoTenderDetails();
		ProductionDefectobj.openURL("STG");
		Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", "Yes", filePath_4);
		Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
		etenderPRcomponentobj.commonLogin("HPCL_AUTOMATION_TC", "pass@123", "Indent", "Creator");
		Dynamicity.updateDataIntoPropertyFile("TenderCreator", "HPCL_AUTOMATION_TC", filePath_4);
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
			        for(int pc=1; pc<=pr50; pc++){
						API_Component.prUpload();
						if(pc<(pr50-2)) {
							String refresh="(//button[@class='btn refresh px-2'])[2]";
							boolean fielddisplay=isElementDisplayed_Updated(By.xpath(refresh), 5);
							boolean interactable=isElementEnable_Updated(By.xpath(refresh), 5);
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
										if(pc%4==0) {
											String refresh="(//button[@class='btn refresh px-2'])[2]";
											click(By.xpath(refresh), "Refresh");
											}
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
		Dynamicity.updateDataIntoPropertyFile("Template", "Material Indigenous V.7", filePath_4);
		dynamicity.generalInformation();
		Dynamicity.updateDataIntoPropertyFile("PreBidDiscussionType", "Not Required", filePath_3);
		//dynamicity.CreateTenderFromPRwithNonSOR_STG();
		dynamicity.CreateTenderwithNonSOR();
		etendercomponentobj.clickSubmitBtn_New();
		etendercomponentobj.tenderIdSave_New();
		etendercomponentobj.AddTwoUsersForSequentialApproval();
		etendercomponentobj.enterTenderIdInSearch();
		 ProductionDefectobj.Logout("STG");

	//verifying pending tender in 2nd approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.Verifying_Pendingtender_sequentialWF();
		 ProductionDefectobj.Logout("STG");
				
	//approving pending tender in 1st approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.clickDetailLinkInApprovalListPage();
		etendercomponentobj.TG1_tenderApprover_dynamicityNew();
		etendercomponentobj.ApproverOverAllComentWithTenderHasBeenApproved();
		 ProductionDefectobj.Logout("STG");
					
	//approving pending tender in 2nd approver login	
		rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
		etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tenderApprovalDecision("forward");
		etendercomponentobj.sendForForwardParallelTenderApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		 ProductionDefectobj.Logout("STG");
			
		  //approver4
		  rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover4"));
		  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
			 ProductionDefectobj.Logout("STG");
	}
}	

/** HMEL_Proc:- Buyer user unable to download the CS report for tender id : 3179





*/
