package com.ChangeRequest;
import com.components.Change_request_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;



public class Notesheet_Notesheet_with_User_defined_Approver_2 extends BaseClass_Web {

	public Change_request_Component change_requestobj=new Change_request_Component(pdfResultReport);
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	public PostTenderComponent posttendercomponentobj =new PostTenderComponent(pdfResultReport);

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
		@Test(description = "Scenario:3 - Verify the functionality of Notesheet with user defined workflow")
		public void f(String no) throws Throwable {
			System.out.println("Entered in the Test method..................");
			try {
				pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
						+ "/Resources/TG1_Testdata_static_scripts.xls", no);
			} catch (Exception e) {
				System.out.println("Unable to read the data from excel file");
			}
			initializeRepository();
			etenderPRcomponentobj.updateNotesheetDetails();
			//deleteBrowserCookies();
			ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
			change_requestobj.nevigateToNotesheetList();
			change_requestobj.createNotesheet();
			change_requestobj.noteSheetSubmit();
			change_requestobj.AddTwoUsersForSequentialApproval();
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
			  //approver1
			rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover1"));
			change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
			change_requestobj.TenderApproverValidation();
			change_requestobj.provideApproverCommentforTenderApprover();
			change_requestobj.appprovalDecision("approve");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
			
			rfqfromintendcomponentobj.ApproverLogin(pdfResultReport.testData.get("UserTenderApprover2"));
			change_requestobj.GoToApprovalworkFlowPendingindentAndSearchTheNotesheet();
			change_requestobj.TenderApproverValidation();
			change_requestobj.provideApproverCommentforTenderApprover();
			etendercomponentobj.tenderApprovalDecision("final approve Tender");
			mailAndAttachmentVeification(408 , 1,"Creator will get an intimation mail after document is approved by approver(s).");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
			
		//Verifying the Notesheet status after approval
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
			change_requestobj.nevigateToNotesheetList();
			change_requestobj.searchNotesheet();
			change_requestobj.verifyNoteSheetStatus("Completed");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		
			
			
			
			
			
		}}