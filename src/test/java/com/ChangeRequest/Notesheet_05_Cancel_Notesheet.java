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



public class Notesheet_05_Cancel_Notesheet extends BaseClass_Web {
	
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
		@Test(description = "Scenario:3 - Verify the functionality of End to End workflow of Sanction Note with Predefine workflow")
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
			ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
			change_requestobj.nevigateToNotesheetList();
			change_requestobj.createNotesheet();
			change_requestobj.noteSheetSubmit();
			change_requestobj.NoApproval_IndentWF();
			change_requestobj.verifyNoteSheetStatus("Completed");
			change_requestobj.searchNotesheet();
			change_requestobj.cancelNotesheet();
			mailAndAttachmentVeification(411 , 1,"Approver(s) will get an intimation mail after document is cancelled by the creator");
			change_requestobj.cancelDeletedNotesheetStatus("Cancelled");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			
			
			
		}}