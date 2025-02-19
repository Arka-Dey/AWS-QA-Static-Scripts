package com.Tender_Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.python.antlr.PythonParser.for_stmt_return;

import com.components.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Database.DatabaseComponent;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.ThreadLocalWebdriver;

public class TC_11_All_ClarificationOrDiscussion extends BaseClass_Web {
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public RfqFromPRComponent etenderPRcomponentobj = new RfqFromPRComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public ProductionDefectComponent ProductionDefectobj = new ProductionDefectComponent(pdfResultReport);
	public RfqFromIndentComponent rfqfromintendcomponentobj = new RfqFromIndentComponent(pdfResultReport);
	
	public void initializeRepository() throws Exception {
		reportDetails.put("Test Script Name", this.getClass().getSimpleName());
		reportDetails.put("Test Script MyWorksshop Document ID", "Doc1234567");
		reportDetails.put("Test Script Revision No", "1");
		reportDetails.put("Test Author Name", "Pooja");
		reportDetails.put("Test Script Type", "Automated Testing");
		reportDetails.put("Requirement Document ID of System", "Doc1234567");
		reportDetails.put("Requirement ID", "US2202");
	}

	@Parameters("TestcaseNo")
	@Test(description ="Scenario:1 -Verify mandatory negotiation functionality of a bidder")
	public void CreateIndentDynamically(String no)
			throws Throwable {
		System.out.println("Entered in the Test method..................");
		try {
			pdfResultReport.readTestDataFile(System.getProperty("user.dir").replace("\\", "/")	+ "/Resources/TG1_Testdata_static_scripts.xls", no);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel file");
		}
		WebDriver driver = ThreadLocalWebdriver.getDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		initializeRepository();
		etenderPRcomponentobj.updateTenderClarificationDetails();
		ProductionDefectobj.openURL(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		etenderPRcomponentobj.commonLogin(Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4), Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", filePath_4), "Tender", "Creator");
	    etendercomponentobj.navigateToTenderListing();
	    etendercomponentobj.enterTenderIdInSearch_Dynamic();
	    etendercomponentobj.openClarificationOrDiscussion();
	    etendercomponentobj.inviteBuyer();
	    etendercomponentobj.verifyAttachment();
	    etendercomponentobj.inviteSupplier();  
	    etendercomponentobj.validateTenderClarificationDetails();
		ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
		  
	    //Dynamicity.updateDataIntoPropertyFile("Environment", "STG", filePath_4);
	    //orgValue= DatabaseComponent.OrgID("HPCL_AUTOMATION_TC");
	
		
		//buyer side clarification
				try {
		            String BuyerValue = Dynamicity.getDataFromPropertiesFile("Buyer", filePath_4);
		            String[] Buyers = BuyerValue.split(",\\s*");
		            String BuyersPValue = Dynamicity.getDataFromPropertiesFile("Buyer_Password", filePath_4);
		            String[] BuyerP = BuyersPValue.split(",\\s*");
		            System.out.println(BuyerP);
		            
		            for(String buyerP: BuyerP) {
		            	buyerPasswords.add(buyerP);
		            }
		           
			            for (String Buyer : Buyers) {
			            	 int s=0;
							etenderPRcomponentobj.commonLogin(Buyer, buyerPasswords.get(s), "Buyer", "user");
							etendercomponentobj.supplierSideClarificationOrDiscussion();
						    ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
							s++;
			            	}
		            	} 
						catch (Exception e) {
			            e.printStackTrace();
			        }
		
		
		
		
		//supplier side clarification
		try {
            String supplierValue = Dynamicity.getDataFromPropertiesFile("Supplier", filePath_4);
            String[] suppliers = supplierValue.split(",\\s*");
            String supplierPValue = Dynamicity.getDataFromPropertiesFile("Supplier_Password", filePath_4);
            String[] suppliersP = supplierPValue.split(",\\s*");
            System.out.println(suppliersP);
            
            for(String supplierP: suppliersP) {
            	supplierPasswords.add(supplierP);
            }
           
	            for (String supplier : suppliers) {
	            	 int s=0;
					etenderPRcomponentobj.commonLogin(supplier, supplierPasswords.get(s), "TenderCreator", "Supplier");
					etendercomponentobj.supplierSideClarificationOrDiscussion();
				    ProductionDefectobj.Logout(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4));
					s++;
	            	}
            	} 
				catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		}
	}