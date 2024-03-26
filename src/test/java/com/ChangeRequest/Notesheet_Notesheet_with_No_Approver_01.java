package com.ChangeRequest;
import com.components.Change_request_Component;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;



public class Notesheet_Notesheet_with_No_Approver_01 extends BaseClass_Web {
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
		@Test(description = "Scenario:3 - Verify the functionality of End to End workflow of Sanction Note with Predefine workflow")
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
			change_requestobj.NoApproval_IndentWF();
			change_requestobj.verifyNoteSheetStatus("Approved");
			change_requestobj.tenderLogout();
			
			
			
		}}