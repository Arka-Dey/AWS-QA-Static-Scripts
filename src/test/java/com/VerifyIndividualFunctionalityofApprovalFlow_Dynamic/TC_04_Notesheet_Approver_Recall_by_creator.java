package com.VerifyIndividualFunctionalityofApprovalFlow_Dynamic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.Change_request_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

public class TC_04_Notesheet_Approver_Recall_by_creator extends BaseClass_Web{
	
	public Change_request_Component change_requestobj=new Change_request_Component(pdfResultReport);
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
		reportDetails.put("Test Author Name", "Arka Dey");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}
	
	
	@Parameters("TestcaseNo")
	@Test(description = "Indent_creation_with_approval")
	public void Indent_creation_with_approval(String no) throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")
					+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}

		WebDriver driver = ThreadLocalWebdriver.getDriver();
		
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);	
		
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
	
		//notesheet creator recall WF
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("IndentCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Indent", "Creator");
		change_requestobj.nevigateToNotesheetList();
		change_requestobj.searchNotesheet();
		change_requestobj.recallNotesheet();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	}
}
					
				