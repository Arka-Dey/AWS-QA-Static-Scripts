package com.ChangeRequest;
import com.components.Change_request_Component;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;



public class Notesheet_Notesheet_with_User_defined_With_Multiple_Approver_4 extends BaseClass_Web {

		public Change_request_Component change_requestobj=new Change_request_Component(pdfResultReport);

		public void initializeRepository() throws Exception {
			reportDetails.put("Test Script Name", this.getClass().getSimpleName());
			reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
			reportDetails.put("Test Script Revision No", "3");
			reportDetails.put("Test Author Name", "Pooja");
			reportDetails.put("Test Script Type", "Automated Testing");
			reportDetails.put("Requirement Document ID of System", "Doc1234567");
			reportDetails.put("Requirement ID", "US2202");
		}

		@Parameters("TestcaseNo")
		@Test(description = "Scenario:3 - Verify the functionality of Notesheet with user defined multiple approver workflow")
		public void f(String no) throws Throwable {
			System.out.println("Entered in the Test method..................");
			try {
				pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
						+ "/Resources/Notesheet_TestData.xls", no);
			} catch (Exception e) {
				System.out.println("Unable to read the data from excel file");
			}
			initializeRepository();
			//deleteBrowserCookies();
			change_requestobj.openURL();
			change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
			change_requestobj.nevigateToNotesheetList();
			change_requestobj.createNotesheet();
			change_requestobj.noteSheetSubmit();
			change_requestobj.AddSingleUsersForSequentialApproval_NotesheetWF();
			change_requestobj.verifyNoteSheetStatus("Pending For Approval");
			change_requestobj.tenderLogout();
		
			//Approve the created Notesheet
			change_requestobj.NotesheetapproverLogin();
			change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
			change_requestobj.clickDetailLinkInApprovalListPage();
			change_requestobj.provideApproverCommentforNotesheetApprover();
			change_requestobj.appprovalDecision("forward");
			change_requestobj.sendForForwardParallelTenderApprovalProcess(); //forward to sn_approver_03, sn_approver_04 and sn_approver_05(c), min app: 2
			change_requestobj.tenderLogoutOld();
			
			
			  //approver4
			change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName4"));
			change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
			change_requestobj.clickDetailLinkInApprovalListPage();
			change_requestobj.provideApproverCommentforNotesheetApprover();
			change_requestobj.appprovalDecision("approve");
			change_requestobj.tenderLogoutOld();
	
			  //approver5
			change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName5"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequentialNoteSheetApprovalProcess();  //forward to sn_approver_06, sn_approver_07 and sn_approver_08(c), min app: 2
				change_requestobj.tenderLogoutOld();
			   
			  //approver6
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName6"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
			  	
			  
			  //approver7
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName7"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
			  
			  
			  //approver8
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName8"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("revert back to approver");
				change_requestobj.tenderLogoutOld();
			  
				//approver7
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName7"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
			  
			//approver8
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName8"));
				 change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
					change_requestobj.clickDetailLinkInApprovalListPage();
					change_requestobj.provideApproverCommentforNotesheetApprover();
					change_requestobj.appprovalDecision("revert back to creator");
				change_requestobj.tenderLogoutOld();
		
				//creator  initiate wf  with 3 parallel and 5 sequential flow
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
				change_requestobj.nevigateToNotesheetList();
				change_requestobj.editNotesheet();
				change_requestobj.noteSheetSubmit();
				change_requestobj.AddMultipleUsersForSequentialParallelApproval_Notesheet_WF();
				change_requestobj.tenderLogout();
					
				//notesheet creator recall WF
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
				change_requestobj.nevigateToNotesheetList();
				change_requestobj.recallNotesheet();
				change_requestobj.tenderLogout();
				
			
				//creator again  initiate wf  with 3 parallel and 5 sequential flow
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
				change_requestobj.nevigateToNotesheetList();
				change_requestobj.editNotesheet();
				change_requestobj.noteSheetSubmit();
				change_requestobj.AddMultipleUsersForSequentialParallelApproval_Notesheet_WF();
				change_requestobj.tenderLogout();
					
				 //approver1
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("notesheetApproverUser1"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				 //approver2
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName2"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				 //approver3
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName3"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				 //approver4
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName4"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				 //approver5
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName5"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				 //approver6
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName6"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				//notesheet creator recall WF
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
				change_requestobj.nevigateToNotesheetList();
				change_requestobj.recallNotesheet();
				change_requestobj.tenderLogout();
				
				
				//notesheet creator initiates WF again with 1 approver
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
				change_requestobj.nevigateToNotesheetList();
				change_requestobj.editNotesheet();
				change_requestobj.noteSheetSubmit();
				change_requestobj.AddSingleUsersForSequentialApproval_NotesheetWF();
				change_requestobj.verifyNoteSheetStatus("Pending For Approval");
				change_requestobj.tenderLogout();
				
			
				 //approver1
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("notesheetApproverUser1"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover2"));
				change_requestobj.tenderLogoutOld();
						
				//approver2
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName2"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover3"));
				change_requestobj.tenderLogoutOld();
			
				//approver3
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName3"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover4"));
				change_requestobj.tenderLogoutOld();
			
				//approver4
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName4"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover5"));
				change_requestobj.tenderLogoutOld();
				
				//approver5
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName5"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover6"));
				change_requestobj.tenderLogoutOld();
				
				//approver6
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName6"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover7"));
				change_requestobj.tenderLogoutOld();
				
				//approver7
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName7"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("forward");
				change_requestobj.sendForForwardSequential_Single_User_Notesheet_ApprovalProcess( pdfResultReport.testData.get("UserNotesheetApprover8"));
				change_requestobj.tenderLogoutOld();
				
				//approver8
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName8"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("revert back to approver");
				change_requestobj.tenderLogoutOld();
				
				//approver7
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName7"));
			  change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.provideApproverCommentforNotesheetApprover();
				change_requestobj.appprovalDecision("approve");
				change_requestobj.tenderLogoutOld();
				
				//approver8
				change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetApproverUserName8"));
				change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
				change_requestobj.clickDetailLinkInApprovalListPage();
				change_requestobj.ApproverOverAllComentWithNotesheetHasBeenApproved();
				change_requestobj.tenderLogoutOld();
				
				
			//Verifying the Notesheet status after approval
			change_requestobj.NoteSheetLogin(pdfResultReport.testData.get("NotesheetCreatorUserName"));
			change_requestobj.nevigateToNotesheetList();
			change_requestobj.verifyNoteSheetStatus("Approved");
			change_requestobj.tenderLogout();
			
			
			
			
			
			
		}}