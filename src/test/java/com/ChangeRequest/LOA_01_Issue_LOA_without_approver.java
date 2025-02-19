package com.ChangeRequest;
import com.components.Change_request_Component;
import com.components.Dynamicity;
import com.components.PostTenderComponent;
import com.components.ProductionDefectComponent;
import com.components.RfqFromIndentComponent;
import com.components.RfqFromPRComponent;
import com.components.eTenderComponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;



public class LOA_01_Issue_LOA_without_approver extends BaseClass_Web {
	
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
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			initializeRepository();
			etenderPRcomponentobj.updateLOADetails();
			ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
			etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("snCreator_Password", filePath_4), "SN", "Creator");
			change_requestobj.nevigateToAllSanctions();
			change_requestobj.searchCompletedSN();
			change_requestobj.issueLOA();
			change_requestobj.submitLOA();
			change_requestobj.LOANoSave();
			change_requestobj.approverNotRequired();
			change_requestobj.verifyLOAStatus("Pending For Acceptance");
			ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
	
		}}