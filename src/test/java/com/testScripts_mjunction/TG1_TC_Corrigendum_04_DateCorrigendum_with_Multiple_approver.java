package com.testScripts_mjunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.PostTenderComponent;
import com.components.RfqFromIndentComponent;
import com.components.eTenderComponent;

public class TG1_TC_Corrigendum_04_DateCorrigendum_with_Multiple_approver extends BaseClass_Web{
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
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
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		initializeRepository();
	//Creating a new Indent with No approval
		etendercomponentobj.openURL();
		rfqfromintendcomponentobj.IndentcreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentCreation();
		rfqfromintendcomponentobj.IndentTG1_General_Info_tabvalidation("Indigenous Indent (Supply & Service Both) V-004");
		rfqfromintendcomponentobj.IndentTG1_Indent_Details_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Other_Information_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_BOM_Item_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_BOM_Services_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_EstimationSheet_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_technical_Specification_tabvalidation();
		rfqfromintendcomponentobj.IndentTG1_Annexures_tabvalidation();
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
		etendercomponentobj.tenderLogout();
		
		
		//Indent assignment Process (self claim)
		etendercomponentobj.tendercreatorLogin();
		rfqfromintendcomponentobj.navigateToIndentAssignment();
		rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.Verify_Indent_Assignment_self_Claim();
		//rfqfromintendcomponentobj.enterIndentNoForSearch();
		rfqfromintendcomponentobj.VerifyIndentStatus_AssignmentListPage("Assigned");
		rfqfromintendcomponentobj.navigateToCreateRFQFromIndentPage();
		rfqfromintendcomponentobj.enterIndentNoInSearch_RFQfromIndentPage();
		 
	//Create and publish RFQ from indent
		rfqfromintendcomponentobj.Create_RFQ_From_Indent("Indigenous Tender (Supply & Service Both) V-1.0");
		rfqfromintendcomponentobj.PublishTender_from_indent_withRFQ_TG1("Indigenous Tender (Supply & Service Both) V-1.0",5,150,160);
		//Clicking on submit button and verify tender status
		etendercomponentobj.clickSubmitBtn();
		etendercomponentobj.tenderIdSave();
		etendercomponentobj.sendForNoApproval_validation();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.checkTenderStatusAndTenderStage();
		etendercomponentobj.tenderLogout();
		
	//Date corrigendum during Live tender status
		etendercomponentobj.waitTillBidstartDateReached();
	etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.datecorrigendum();
		etendercomponentobj.corrigendumSaveButton();
		etendercomponentobj.modifyDateScheduleTemplate1(	30,35);  
		etendercomponentobj.AddTwoUsersForSequentialCorrigendumApproval();
		etendercomponentobj.tenderLogout();
		
	//verifying pending corrigendum in 2nd approver login	
		etendercomponentobj.tenderApprover2Login();
		etendercomponentobj.Verifying_Pendingtender_Corrigendumtab_sequentialWF();
		etendercomponentobj.tenderLogoutOld();
	
	//Verifying pending corrigendum in 1st approver login and approve the corrigendum 
		etendercomponentobj.tenderApproverLogin();
		etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
		etendercomponentobj.clickDetailLinkInApprovalListPage_CorrigendumApproval();
		etendercomponentobj.provideApproverCommentsForDateScheduleTab();
		etendercomponentobj.ApproverOverAllComentWithCorrigendumHasBeenApproved();
		etendercomponentobj.tenderLogoutOld();
		
	//Verifying pending corrigendum in 2nd approver login and approve the corrigendum 
		etendercomponentobj.tenderApprover2Login();
		etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
		etendercomponentobj.TenderApproverValidation();
		etendercomponentobj.provideApproverCommentforTenderApprover();
		etendercomponentobj.tender_Corrigendum_ApprovalDecision("forward");
		etendercomponentobj.sendForForwardParallelTender_Corrigendum_ApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
		etendercomponentobj.tenderLogoutOld();
		

		
		  //approver4
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
			
		  //approver5
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("forward");
		  posttendercomponentobj.sendForForwardSequentialTender_CorrigendumApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
		  etendercomponentobj.tenderLogoutOld();
		   
		  //approver6
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  
		  //approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  	
		  //approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("revert back to approver");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		  //approver7
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("approve");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		  
		//approver8
		  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
		  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
			etendercomponentobj.TenderApproverValidation();
			etendercomponentobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tender_Corrigendum_ApprovalDecision("revert back to creator");
		  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
		  etendercomponentobj.tenderLogoutOld();
		
		//creator action initiate wf  with 3 parallel and 5 sequential flow
		  etendercomponentobj.tendercreatorLogin();
			etendercomponentobj.navigateToTenderListing();
			etendercomponentobj.enterTenderIdInSearch();
			etendercomponentobj.datecorrigendum();
			etendercomponentobj.corrigendumSaveButton();
			etendercomponentobj.modifyDateScheduleTemplate1(	30,35);
			etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF("Reinitiated after reverted back the workflow");
			etendercomponentobj.tenderLogout();
		
	//tender creator recall WF
			etendercomponentobj.tendercreatorLogin();
			  etendercomponentobj.navigateToTenderListing();
				etendercomponentobj.enterTenderIdInSearch();
				etendercomponentobj.recallTender();
				etendercomponentobj.tenderLogout();
		
		
		
				//creator action initiate wf  with 3 parallel and 5 sequential flow
				etendercomponentobj.tendercreatorLogin();
				etendercomponentobj.navigateToTenderListing();
				etendercomponentobj.enterTenderIdInSearch();
				etendercomponentobj.datecorrigendum();
				etendercomponentobj.corrigendumSaveButton();
				etendercomponentobj.modifyDateScheduleTemplate1(	30,35);
					etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF("Reinitiated after reverted back the workflow");
					etendercomponentobj.tenderLogout();
		
					//approver1
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
		
					//approver2
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover2UserName"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
		 
						//approver3
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
		
					//approver4
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
					  
					//approver5
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
					   
					//approver6
					  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
					  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
						etendercomponentobj.TenderApproverValidation();
						etendercomponentobj.provideApproverCommentforTenderApprover();
						etendercomponentobj.tenderApprovalDecision("approve");
					  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
					  etendercomponentobj.tenderLogoutOld();
		
					//tender creator recall WF
						etendercomponentobj.tendercreatorLogin();
						  etendercomponentobj.navigateToTenderListing();
							etendercomponentobj.enterTenderIdInSearch();
							etendercomponentobj.recallTender();
							etendercomponentobj.tenderLogout();
						
							
						 //ender creator initiates WF again with 1 approver
							etendercomponentobj.tendercreatorLogin();
							etendercomponentobj.navigateToTenderListing();
							etendercomponentobj.enterTenderIdInSearch();
							etendercomponentobj.datecorrigendum();
							etendercomponentobj.corrigendumSaveButton();
							etendercomponentobj.modifyDateScheduleTemplate1(	180,200);
								etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1"));
								etendercomponentobj.tenderLogout();	
								
								
								//approver1
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApproverUserName"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
								  etendercomponentobj.tenderLogoutOld();				
		
									//approver2
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover2UserName"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
								  etendercomponentobj.tenderLogoutOld();


									//approver3
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
								  etendercomponentobj.tenderLogoutOld();
								  
									//approver4
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
								  etendercomponentobj.tenderLogoutOld();
								  
									//approver5
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
								  etendercomponentobj.tenderLogoutOld();
	
								//approver6
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
								  etendercomponentobj.tenderLogoutOld();
		
		
								//approver7
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("forward");
									etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
								  etendercomponentobj.tenderLogoutOld();
		
		
								//approver8
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("revert back to approver");
								  etendercomponentobj.tenderLogoutOld();
		
								//approver7
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.tenderApprovalDecision("approve");
								  etendercomponentobj.tenderLogoutOld();
		
								//approver8
								  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
								  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
									etendercomponentobj.TenderApproverValidation();
									etendercomponentobj.provideApproverCommentforTenderApprover();
									etendercomponentobj.TenderApprover_Approve_C();
									etendercomponentobj.tenderCloseWorkflow();
								  etendercomponentobj.tenderLogoutOld();
		
		
			
	
								  
								  
								  
								//creator action initiate wf  with 3 parallel and 5 sequential flow
									etendercomponentobj.tendercreatorLogin();
									  etendercomponentobj.navigateToTenderListing();
										etendercomponentobj.enterTenderIdInSearch();
										etendercomponentobj.editDraftTender();
										//etendercomponentobj.updateDateScheduleAtDraftTender(30,55,56);
										etendercomponentobj.clickSubmitBtn();
										etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF("Reinitiated after reverted back the workflow");
										etendercomponentobj.tenderLogout();
									
								//tender creator recall WF
										etendercomponentobj.tendercreatorLogin();
										  etendercomponentobj.navigateToTenderListing();
											etendercomponentobj.enterTenderIdInSearch();
											etendercomponentobj.recallTender();
											etendercomponentobj.tenderLogout();
									
									
											
											//creator action initiate wf  with 3 parallel and 5 sequential flow
											etendercomponentobj.tendercreatorLogin();
											  etendercomponentobj.navigateToTenderListing();
												etendercomponentobj.enterTenderIdInSearch();
												etendercomponentobj.editDraftTender();
												//etendercomponentobj.updateDateScheduleAtDraftTender(30,55,56);
												etendercomponentobj.clickSubmitBtn();
												etendercomponentobj.AddMultipleUsersForSequentialParallelApproval_Tender_WF("Reinitiated after reverted back the workflow");
												etendercomponentobj.tenderLogout();
									
												//approver1
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
									
												//approver2
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover2UserName"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
									 
													//approver3
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
									
												//approver4
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
												  
												//approver5
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
												   
												//approver6
												  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
												  etendercomponentobj.clickCorrigendumTabAndSearchThePendingListTenderNo();
													etendercomponentobj.TenderApproverValidation();
													etendercomponentobj.provideApproverCommentforTenderApprover();
													etendercomponentobj.tenderApprovalDecision("approve");
												  //posttendercomponentobj.enterDocumentNoInSearchSanctionApprover();
												  etendercomponentobj.tenderLogoutOld();
									
												//tender creator recall WF
													etendercomponentobj.tendercreatorLogin();
													  etendercomponentobj.navigateToTenderListing();
														etendercomponentobj.enterTenderIdInSearch();
														etendercomponentobj.recallTender();
														etendercomponentobj.tenderLogout();
													
														
													 //ender creator initiates WF again with 1 approver
														etendercomponentobj.tendercreatorLogin();
														  etendercomponentobj.navigateToTenderListing();
															etendercomponentobj.enterTenderIdInSearch();
															etendercomponentobj.editDraftTender();
															//etendercomponentobj.updateDateScheduleAtDraftTender(30,55,56);
															etendercomponentobj.clickSubmitBtn();
															etendercomponentobj.AddSingleUsersForSequentialApproval_Tender_WF_AfterRecall_Revert(pdfResultReport.testData.get("UserTenderApprover1"));
															etendercomponentobj.tenderLogout();	
															
															
															//approver1
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApproverUserName"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover2"));
															  etendercomponentobj.tenderLogoutOld();				
									
																//approver2
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("TenderApprover2UserName"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover3"));
															  etendercomponentobj.tenderLogoutOld();


																//approver3
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName3"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover4"));
															  etendercomponentobj.tenderLogoutOld();
															  
																//approver4
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName4"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover5"));
															  etendercomponentobj.tenderLogoutOld();
															  
																//approver5
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName5"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover6"));
															  etendercomponentobj.tenderLogoutOld();
								
															//approver6
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName6"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover7"));
															  etendercomponentobj.tenderLogoutOld();
									
									
															//approver7
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("forward");
																etendercomponentobj.sendForForwardSequential_Single_User_Tender_ApprovalProcess( pdfResultReport.testData.get("UserTenderApprover8"));
															  etendercomponentobj.tenderLogoutOld();
									
									
															//approver8
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("revert back to approver");
															  etendercomponentobj.tenderLogoutOld();
									
															//approver7
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName7"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.tenderApprovalDecision("approve");
															  etendercomponentobj.tenderLogoutOld();
									
															//approver8
															  posttendercomponentobj.sanctionNoteApproverLogin(pdfResultReport.testData.get("SanctionNoteApproverUserName8"));
															  etendercomponentobj.GoToApprovalworkFlowPendingTendersAndSearchTheTender();
																etendercomponentobj.TenderApproverValidation();
																etendercomponentobj.provideApproverCommentforTenderApprover();
																etendercomponentobj.TenderApprover_Approve_C();
																etendercomponentobj.tenderCloseWorkflow();
															  etendercomponentobj.tenderLogoutOld();
									
									
									
									
								//verifying Published tender status 
									etendercomponentobj.tendercreatorLogin();
									etendercomponentobj.navigateToTenderListing();
									etendercomponentobj.enterTenderIdInSearch();
									etendercomponentobj.checkTenderStatusAndTenderStage("Published");
									etendercomponentobj.tenderLogout();
									
								  
								  
								  
								  
								  
								  
								  
								  
								  
								  
								  
		
	//Verifying Corrigendum status and corrigendum history
		etendercomponentobj.tendercreatorLogin();
		etendercomponentobj.navigateToTenderListing();
		etendercomponentobj.enterTenderIdInSearch();
		etendercomponentobj.corrigendumStatus();
		etendercomponentobj.corrigendumStatus_Yes_Hyperlink_Validation();
		etendercomponentobj.corrigendumNumber_Hyperlink_Validation();
		etendercomponentobj.corrigendumComparison_Hyperlink_Validation();
		etendercomponentobj.tenderLogout();
	}

}
