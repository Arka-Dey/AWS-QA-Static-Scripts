package com.components;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.Database.DatabaseComponent;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.objectRepository.TenderCreation_Locators;


public class RfqFromPRComponent extends BaseClass_Web {

	TenderCreation_Locators tendercreationlocators = new TenderCreation_Locators();
	//public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);

	SoftAssert softAssert=new SoftAssert();
	String SystemIndentnoLocatorText = null;
	//String SystemIndentnoLocatorText = "1951";
	String expectedSuccessMessage= null;
	String TemplateGroup=null;
	ArrayList<String> commentlist=new ArrayList<String>();
	ArrayList<String> tabcontentList=new ArrayList<String>();

	String tenderIDdromDraft=null;
	public RfqFromPRComponent(PDFResultReport pdfresultReport) {

		this.pdfResultReport = pdfresultReport;
	}
	
	
	//================================RFQFromPR==================================
	
	//added by @AD
		public void commonLogin(String username, String password, String moduleType, String roleType) throws Throwable {
			try {
				log.info("started executing the method:: IndentapproverLogin");
				isElementEnable(tendercreationlocators.userName, 100);
				set(tendercreationlocators.userName, username, "userName");
				waitForElementToBeClickable(tendercreationlocators.password);
				set(tendercreationlocators.password, password, "password");
				boolean fielddisplay=isElementDisplayed_Updated(tendercreationlocators.okButton, 1);
				boolean interactable=isElementEnable_Updated(tendercreationlocators.okButton, 1);
				if (fielddisplay == true && interactable == true) {
					click(tendercreationlocators.okButton, "okButton");
				}
				else {
					click(tendercreationlocators.okButton_HMEL, "okButton");
				}
				if(!roleType.equalsIgnoreCase("Supplier")) {
					BuyerDepartmentWiseLogin(username);
					waitForElement(tendercreationlocators.mainMenuIcon, 20);
				}
				else
				{
					SupplierOrgWiseLogin();
					waitForElement(tendercreationlocators.mainMenuIcon, 20);
				}
				user=username;
				pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" must be sucessfully logged in",
						"Successfully logged in as "+moduleType+" "+roleType+"" + " ", "Pass", "Y");
				log.info("completed executing the method:: IndentapproverLogin");

			} catch (Exception e) {
				log.fatal("Unable to open the URL" + e.getMessage());
				pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" is not logged in",
						"Unable to login as "+moduleType+" "+roleType+"" + e.getMessage(), "Fail", "N");
			}
		}
		public void SupplierOrgWiseLogin() throws Throwable {
			try {
				log.info("started executing the method:: SupplierOrgWiseLogin");
				String xpath="//*[@id='myModalLabel']";
				String orgSelection="//div[@class='input-group']/select[1]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(xpath), 2);
				boolean interactable=isElementEnable_Updated(By.xpath(xpath), 2);
				if (fielddisplay == true && interactable == true) {
					waitForObj(2000);
					selectbyvalue(By.xpath(orgSelection), orgValue);
					click(By.xpath("//button[contains(text(), 'Ok')]"), "Click on OK button");
					waitForObj(1000);
				}
				
				pdfResultReport.addStepDetails("Navigate to tender List", "Tender list must be navigated successfully",
						"Successfully navigated to tender list" + " ", "Pass", "Y");
				log.info("completed executing the method:: navigateToTenderList");

			} catch (Exception e) {
				log.fatal("Unable to navigate to the tender list" + e.getMessage());
				pdfResultReport.addStepDetails("Navigate to tender List", "Not able to navigate to the tender list",
						"Unable to navigate to the tender list" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void navigateToPRList() throws Throwable {
			try {
				log.info("started executing the method:: navigateToTenderList");
				JSClick(tendercreationlocators.mainMenuIconSub, "MenuIcon");
				mouseOver(tendercreationlocators.Requisition);
				waitForElementToBeClickable(tendercreationlocators.prList);
				JSClick(tendercreationlocators.prList, "prList");
				//JSClick(tendercreationlocators.createNewTender, "createNewRfq");
				dynamic_Loader(tendercreationlocators.loadingLocator, 2);
				pdfResultReport.addStepDetails("Navigate to tender List", "Tender list must be navigated successfully",
						"Successfully navigated to tender list" + " ", "Pass", "Y");
				log.info("completed executing the method:: navigateToTenderList");

			} catch (Exception e) {
				log.fatal("Unable to navigate to the tender list" + e.getMessage());
				pdfResultReport.addStepDetails("Navigate to tender List", "Not able to navigate to the tender list",
						"Unable to navigate to the tender list" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void enterPRInSearch() throws Throwable {
			try {
				log.info("started executing the method:: PRInSearch");
				
				String refresh="(//button[@class='btn refresh px-2'])[2]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(refresh), 60);
				boolean interactable=isElementEnable_Updated(By.xpath(refresh), 60);
				System.out.println("Field is displayed: " + fielddisplay);
				System.out.println("Field is interactable: " + interactable);

				if (fielddisplay == true && interactable == true) {
					click(By.xpath(refresh), "Refresh");
					dynamic_Loader(tendercreationlocators.loadingLocator, 2);
				}
				
				waitForElementToBeInvisible(tendercreationlocators.PleaseWait);
				waitForElementToBeVisible(tendercreationlocators.typeAnyKeyword_Pending);
				
				clear(tendercreationlocators.typeAnyKeyword_Pending, "PRKeyword");
				String prNUmber=String.valueOf(PR_Nu);
				set(tendercreationlocators.typeAnyKeyword_Pending, prNUmber, "tenderListSearch");

				String deepSearch="(//button[@class='btn refresh px-2'])[1]";
				boolean fielddisplayDS=isElementDisplayed_Updated(By.xpath(deepSearch), 60);
				boolean interactableDS=isElementEnable_Updated(By.xpath(deepSearch), 60);
				System.out.println("Field is displayed: " + fielddisplayDS);
				System.out.println("Field is interactable: " + interactableDS);

				if (fielddisplayDS == true && interactableDS == true) {
					click(By.xpath(deepSearch), "deepSearch");
				}
				dynamic_Loader(tendercreationlocators.loadingLocator,2);
				
				int PRItemCount= Integer.parseInt(Dynamicity.getDataFromPropertiesFile("PRItemCount", filePath_4));
				for(int lm=0; lm<(PRItemCount/500); lm++ ) {
				String LoadMore="//button[@tooltip='Load More']";
				boolean fielddisplayLM=isElementDisplayed_Updated(By.xpath(LoadMore), 60);
				boolean interactableLM=isElementEnable_Updated(By.xpath(LoadMore), 60);
				System.out.println("Field is displayed: " + fielddisplayLM);
				System.out.println("Field is interactable: " + interactableLM);

				if (fielddisplayLM == true && interactableLM == true) {
					click(By.xpath(LoadMore), "LoadMore");
					dynamic_Loader(tendercreationlocators.loadingLocator, 2);
						}
					}
				pdfResultReport.addStepDetails("Successfully Saved",
						"PR must be entered successfully in search field",
						"PR is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: PRSave");
			} catch (Exception e) {
				log.fatal("Not able to search PR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to search PR", "Not able to enter PR in search field",
						"Unable to enter PR in search field" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void enterPRInSearch_ExceptHMEL() throws Throwable {
			try {
				log.info("started executing the method:: PRInSearch");

				waitForElementToBeInvisible(tendercreationlocators.PleaseWait);
				waitForElementToBeVisible(tendercreationlocators.typeAnyKeyword_Pending);
				
				clear(tendercreationlocators.typeAnyKeyword_Pending, "PRKeyword");
				System.out.println(Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4));
				set(tendercreationlocators.typeAnyKeyword_Pending, Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4), "tenderListSearch");
				
				String deepSearch="(//button[@class='btn refresh px-2'])[1]";
				boolean fielddisplayDS=isElementDisplayed_Updated(By.xpath(deepSearch), 60);
				boolean interactableDS=isElementEnable_Updated(By.xpath(deepSearch), 60);
				System.out.println("Field is displayed: " + fielddisplayDS);
				System.out.println("Field is Enable: " + interactableDS);

				if (fielddisplayDS == true && interactableDS == true) {
					click(By.xpath(deepSearch), "deepSearch");
				}
				dynamic_Loader(tendercreationlocators.loadingLocator, 1);
				
				int PRItemCount= Integer.parseInt(Dynamicity.getDataFromPropertiesFile("PRItemCount", filePath_4));
				for(int lm=0; lm<(PRItemCount/500); lm++ ) {
				String LoadMore="//button[@tooltip='Load More']";
				boolean fielddisplayLM=isElementDisplayed_Updated(By.xpath(LoadMore), 60);
				boolean interactableLM=isElementEnable_Updated(By.xpath(LoadMore), 60);
				System.out.println("Field is displayed: " + fielddisplayLM);
				System.out.println("Field is Enable: " + interactableLM);

				if (fielddisplayLM == true && interactableLM == true) {
					click(By.xpath(LoadMore), "LoadMore");
						}
					}
				
				pdfResultReport.addStepDetails("Successfully Saved",
						"PR must be entered successfully in search field",
						"PR is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: PRSave");
			} catch (Exception e) {
				log.fatal("Not able to search PR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to search PR", "Not able to enter PR in search field",
						"Unable to enter PR in search field" + e.getMessage(), "Fail", "N");
			}
		}
		public void enterPRInSearch_ExceptHMEL_multiData() throws Throwable {
			try {
				log.info("started executing the method:: PRInSearch");

				waitForElementToBeInvisible(tendercreationlocators.PleaseWait);
				waitForElementToBeVisible(tendercreationlocators.typeAnyKeyword_Pending);
				
				clear(tendercreationlocators.typeAnyKeyword_Pending, "PRKeyword");
				String PR=Dynamicity.getDataFromPropertiesFile("PRNumber", filePath_4);
				String[] PRs = PR.split(",\\s*");
				set(tendercreationlocators.typeAnyKeyword_Pending, PRs[ivC], "tenderListSearch");
				String deepSearch="(//button[@class='btn refresh px-2'])[1]";
				boolean fielddisplayDS=isElementDisplayed_Updated(By.xpath(deepSearch), 60);
				boolean interactableDS=isElementEnable_Updated(By.xpath(deepSearch), 60);
				if (fielddisplayDS == true && interactableDS == true) {
					click(By.xpath(deepSearch), "deepSearch");
				}
				dynamic_Loader(tendercreationlocators.loadingLocator, 1);
				
				int PRItemCount= Integer.parseInt(Dynamicity.getDataFromPropertiesFile("PRItemCount", filePath_4));
				for(int lm=0; lm<(PRItemCount/500); lm++ ) {
				String LoadMore="//button[@tooltip='Load More']";
				boolean fielddisplayLM=isElementDisplayed_Updated(By.xpath(LoadMore), 60);
				boolean interactableLM=isElementEnable_Updated(By.xpath(LoadMore), 60);

				if (fielddisplayLM == true && interactableLM == true) {
					click(By.xpath(LoadMore), "LoadMore");
						}
					}
				
				pdfResultReport.addStepDetails("Successfully Saved",
						"PR must be entered successfully in search field",
						"PR is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: PRSave");
			} catch (Exception e) {
				log.fatal("Not able to search PR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to search PR", "Not able to enter PR in search field",
						"Unable to enter PR in search field" + e.getMessage(), "Fail", "N");
			}
		}
		public void itemAllSelection() throws Throwable {
			try {
				log.info("started executing the method:: itemAllSelection");
				click(tendercreationlocators.allPRCheck, "CheckPRItems");
				pdfResultReport.addStepDetails("Successfully Saved",
						"itemAllSelection must be selected successfully in search field",
						"itemAllSelection is successfully selected in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: itemAllSelection");
			} catch (Exception e) {
				log.fatal("Not able to select itemAllSelection" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to select itemAllSelection", "Not able to select itemAllSelection",
						"Unable to select itemAllSelection" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void itemWiseSelection(String RowCount) throws Throwable {
			try {
				log.info("started executing the method:: itemAllSelection");
				 int count = Integer.parseInt(RowCount);
				for(int rowSelection=1; rowSelection<=count; rowSelection++ ) {
					String RS="//tbody/tr["+rowSelection+"]/td[1]/label[1]/span[1]";
					click(By.xpath(RS), "CheckPRItems");
				}
				pdfResultReport.addStepDetails("Successfully Saved",
						"itemAllSelection must be selected successfully in search field",
						"itemAllSelection is successfully selected in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: itemAllSelection");
			} catch (Exception e) {
				log.fatal("Not able to select itemAllSelection" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to select itemAllSelection", "Not able to select itemAllSelection",
						"Unable to select itemAllSelection" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void createTenderFromPR() throws Throwable {
			try {
				log.info("started executing the method:: createTenderFromPR");
				click(tendercreationlocators.allPRActionButton, "allPRActionButton");
				click(tendercreationlocators.createTenderFromButton, "createTenderFromButton");
				waitForElementToBeClickable(tendercreationlocators.confirmationPRtoRFQ);
				click(tendercreationlocators.confirmationPRtoRFQ, "confirmationPRtoRFQ");
				pdfResultReport.addStepDetails("Successfully Saved",
						"createTenderFromPR must be entered successfully in search field",
						"createTenderFromPR is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: createTenderFromPR");
			} catch (Exception e) {
				log.fatal("Not able to createTenderFromPR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to createTenderFromPR", "Not able to createTenderFromPR",
						"Unable to createTenderFromPR" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void createSNFromPR() throws Throwable {
			try {
				log.info("started executing the method:: createSNFromPR");
				click(tendercreationlocators.allPRActionButton, "allPRActionButton");
				waitForObj(1000);
				click(tendercreationlocators.createSNFromPRButton, "createTenderFromButton");
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.confirmationPRtoRFQ);
				click(tendercreationlocators.confirmationPRtoRFQ, "confirmationPRtoRFQ");
				pdfResultReport.addStepDetails("Successfully Saved",
						"createSNFromPR must be entered successfully in search field",
						"createSNFromPR is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: createSNFromPR");
			} catch (Exception e) {
				log.fatal("Not able to createSNFromPR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to createSNFromPR", "Not able to createSNFromPR",
						"Unable to createSNFromPR" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void addPRFromCorrigendum() throws Throwable {
			try {
				log.info("started executing the method:: addPRFromCorrigendum");
				click(tendercreationlocators.allPRActionButton, "allPRActionButton");
				waitForObj(1000);
				click(tendercreationlocators.addToTender, "addToTender");
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.confirmationPRtoRFQ);
				click(tendercreationlocators.confirmationPRtoRFQ, "confirmationPRtoRFQ");
				universalNormalWait();
				checkPageIsReady();
				pdfResultReport.addStepDetails("Successfully Saved",
						"addPRFromCorrigendum must be entered successfully in search field",
						"addPRFromCorrigendum is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: PRSave");
			} catch (Exception e) {
				log.fatal("Not able to addPRFromCorrigendum" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to addPRFromCorrigendum", "Not able to addPRFromCorrigendum",
						"Unable to addPRFromCorrigendum" + e.getMessage(), "Fail", "N");
			}
		}
		
		public void validateMISOrderReport() throws Throwable {
			try {
				log.info("started executing the method:: validateMISOrderReport");
				JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
				String MIS="//a[text()='MIS']";
				String order="//*[@class='subMenuUnderline' and text()='Order']";
				mouseOver(By.xpath(MIS));
				waitForObj(2000);
				JSClick(By.xpath(order), "order");
				
				String poStatus="//*[@placeholder='Po Status']";
				String Draft="(//*[@class='mat-pseudo-checkbox mat-mdc-option-pseudo-checkbox mat-pseudo-checkbox-full ng-star-inserted'])[2]";
				String fromDate="//*[@name='validFrom']";
				String toDate="//*[@name='validTo']";
				String format="//*[@name='doctype']";
				String download="//*[@tooltip='Download']";
				waitForElementToBeClickable(By.xpath(poStatus));
				click(By.xpath(poStatus), "poStatus");
				click(By.xpath(Draft), "poStatus");
				waitForObj(1000);
				JSClick(By.xpath("//div[contains(@id, 'mat-select-value')]"), "poStatus");
				//String clickoutside="cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing";
				//click(By.xpath(clickoutside), "clickoutside");
				
				 LocalDate currentDate = LocalDate.now();
			        
			        // Subtract 30 days from the current date
			        LocalDate date30DaysAgo = currentDate.minusDays(30);
			        
			        // Define the desired format
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			        
			        // Format the date 30 days ago
			        String formattedDate30DaysAgo = date30DaysAgo.format(formatter);
				
				set(By.xpath(fromDate), formattedDate30DaysAgo, "formattedDate30DaysAgo");
				
		        
		        // Format the current date
		        String formattedDate = currentDate.format(formatter);
		        
		        set(By.xpath(toDate), formattedDate, "toDate");
				JSClick(By.xpath(format), "XLSX");
		        select(By.xpath(format), "XLSX");
		        //JSClick(By.xpath(download), "file downloadi");
		        isFileDownloadAndValidation(By.xpath(download), "file downloadi", "PO Report_Research & Development Centre for Iron & Steel _ SAIL.xlsx");
				universalNormalWait();
		        
		        
				pdfResultReport.addStepDetails("Successfully validateMISOrderReport",
						"validateMISOrderReport",
						"validateMISOrderReport is successfully validated" + " ", "Pass", "Y");
				log.info("completed executing the method:: validateMISOrderReport");
			} catch (Exception e) {
				log.fatal("Not able to createTenderFromPR" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to validateMISOrderReport", "Not able to validateMISOrderReport",
						"Unable to validateMISOrderReport" + e.getMessage(), "Fail", "N");
			}
		}

		public void updatePRtoTenderDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRItemCount", Dynamicity.getDataFromPropertiesFile("PRItemCount", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("RowCount", Dynamicity.getDataFromPropertiesFile("RowCount", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRNumber", Dynamicity.getDataFromPropertiesFile("PRNumber", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", PRtoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", PRtoTenderFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	

		public void updateIndenttoTenderDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentTemplate", Dynamicity.getDataFromPropertiesFile("IndentTemplate", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", IndenttoTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", IndenttoTenderFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
	
		public void updateFreshTenderDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", FreshTenderFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", FreshTenderFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateIndentDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentTemplate", Dynamicity.getDataFromPropertiesFile("IndentTemplate", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", IndentFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", IndentFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateFreshSNDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", FreshSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", FreshSNFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		
		public void updateIndenttoSNDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentTemplate", Dynamicity.getDataFromPropertiesFile("IndentTemplate", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", IndenttoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", IndenttoSNFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
			
		public void updatePRtoSNDetails() {
			try {
				
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRNumber", Dynamicity.getDataFromPropertiesFile("PRNumber", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRItemCount", Dynamicity.getDataFromPropertiesFile("PRItemCount", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("RowCount", Dynamicity.getDataFromPropertiesFile("RowCount", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("snCreator", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", PRtoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", PRtoSNFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateTendertoSNDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("SupplierForSN", Dynamicity.getDataFromPropertiesFile("SupplierForSN", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("AutomaticSNCreationBasedOn", Dynamicity.getDataFromPropertiesFile("AutomaticSNCreationBasedOn", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("tenderID", Dynamicity.getDataFromPropertiesFile("tenderID", TendertoSNFieldDetails), filePath_4);				
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", TendertoSNFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", TendertoSNFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateFreshPODetails() {
			try {
				
				Dynamicity.updateDataIntoPropertyFile("queryPOparam", Dynamicity.getDataFromPropertiesFile("queryPOparam", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poTemplate", Dynamicity.getDataFromPropertiesFile("poTemplate", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("POItemCount", Dynamicity.getDataFromPropertiesFile("POItemCount", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("CompletedSN", Dynamicity.getDataFromPropertiesFile("CompletedSN", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", FreshPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", FreshPOFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateSNtoPODetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poCreator", Dynamicity.getDataFromPropertiesFile("poCreator", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("tenderID", Dynamicity.getDataFromPropertiesFile("tenderID", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poCreator_password", Dynamicity.getDataFromPropertiesFile("poCreator_password", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poTemplate", Dynamicity.getDataFromPropertiesFile("poTemplate", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("POItemCount", Dynamicity.getDataFromPropertiesFile("POItemCount", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("SupplierForSN", Dynamicity.getDataFromPropertiesFile("SupplierForSN", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("AutomaticSNCreationBasedOn", Dynamicity.getDataFromPropertiesFile("AutomaticSNCreationBasedOn", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", SNtoPOFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", SNtoPOFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateCorrigendumDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("CorrigendumTemplate", Dynamicity.getDataFromPropertiesFile("CorrigendumTemplate", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("tenderID", Dynamicity.getDataFromPropertiesFile("tenderID", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", CorrigendumFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", CorrigendumFieldDetails), filePath_4);
			
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		
		public void updateNotesheetDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", NotesheetFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", NotesheetFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", NotesheetFieldDetails), filePath_4);	
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", NotesheetFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", NotesheetFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateLOADetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", LOAFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", LOAFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("CompletedSN", Dynamicity.getDataFromPropertiesFile("CompletedSN", LOAFieldDetails), filePath_4);	
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", LOAFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", LOAFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", LOAFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}


		public void updateTenderClarificationDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("tenderID", Dynamicity.getDataFromPropertiesFile("tenderID", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Buyer", Dynamicity.getDataFromPropertiesFile("Buyer", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Buyer_Password", Dynamicity.getDataFromPropertiesFile("Buyer_Password", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", TenderCLarificationOrDiscussionFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
			
		public void updateFreshTenderBidSubmissionDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCurrency", Dynamicity.getDataFromPropertiesFile("TenderCurrency", FreshTenderBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", FreshTenderBidSubmissionFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateIndentTenderBidSubmissionDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentTemplate", Dynamicity.getDataFromPropertiesFile("IndentTemplate", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCurrency", Dynamicity.getDataFromPropertiesFile("TenderCurrency", IndentTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", IndentTendertoBidSubmissionFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updateIndent_to_PO_E2E() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator", Dynamicity.getDataFromPropertiesFile("IndentCreator", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentCreator_Password", Dynamicity.getDataFromPropertiesFile("IndentCreator_Password", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("IndentTemplate", Dynamicity.getDataFromPropertiesFile("IndentTemplate", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCurrency", Dynamicity.getDataFromPropertiesFile("TenderCurrency", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poCreator", Dynamicity.getDataFromPropertiesFile("poCreator", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poCreator_password", Dynamicity.getDataFromPropertiesFile("poCreator_password", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("poTemplate", Dynamicity.getDataFromPropertiesFile("poTemplate", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("POItemCount", Dynamicity.getDataFromPropertiesFile("POItemCount", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("SupplierForSN", Dynamicity.getDataFromPropertiesFile("SupplierForSN", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("AutomaticSNCreationBasedOn", Dynamicity.getDataFromPropertiesFile("AutomaticSNCreationBasedOn", IndenttoPO_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", IndenttoPO_E2E_FieldDetails), filePath_4);
				
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}	
		
		public void updatePRTendertoBidSubmissionDetails() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRItemCount", Dynamicity.getDataFromPropertiesFile("PRItemCount", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("RowCount", Dynamicity.getDataFromPropertiesFile("RowCount", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRNumber", Dynamicity.getDataFromPropertiesFile("PRNumber", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCurrency", Dynamicity.getDataFromPropertiesFile("TenderCurrency", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", PRTendertoBidSubmissionFieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidFromRowNumber", Dynamicity.getDataFromPropertiesFile("BidFromRowNumber", PRTendertoBidSubmissionFieldDetails), filePath_4);
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}
		
		public void updatePRtoSN_E2E() {
			try {
				Dynamicity.updateDataIntoPropertyFile("TenderType", Dynamicity.getDataFromPropertiesFile("TenderType", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("BidPart", Dynamicity.getDataFromPropertiesFile("BidPart", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRItemCount", Dynamicity.getDataFromPropertiesFile("PRItemCount", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FreshIndentTenderItemCount", Dynamicity.getDataFromPropertiesFile("FreshIndentTenderItemCount", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator", Dynamicity.getDataFromPropertiesFile("TenderCreator", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("StartTime", Dynamicity.getDataFromPropertiesFile("StartTime", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Template", Dynamicity.getDataFromPropertiesFile("Template", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCreator_Password", Dynamicity.getDataFromPropertiesFile("TenderCreator_Password", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("RowCount", Dynamicity.getDataFromPropertiesFile("RowCount", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier_Password", Dynamicity.getDataFromPropertiesFile("Supplier_Password", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("bidTime", Dynamicity.getDataFromPropertiesFile("bidTime", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Environment", Dynamicity.getDataFromPropertiesFile("Environment", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("PRNumber", Dynamicity.getDataFromPropertiesFile("PRNumber", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Supplier", Dynamicity.getDataFromPropertiesFile("Supplier", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("OfferValidity", Dynamicity.getDataFromPropertiesFile("OfferValidity", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Minimum_Number_Of_Bids", Dynamicity.getDataFromPropertiesFile("Minimum_Number_Of_Bids", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("DescriptionForGeneralInformation", Dynamicity.getDataFromPropertiesFile("DescriptionForGeneralInformation", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("ExcelUpload", Dynamicity.getDataFromPropertiesFile("ExcelUpload", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("Organization", Dynamicity.getDataFromPropertiesFile("Organization", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("FirstTimeRun", Dynamicity.getDataFromPropertiesFile("FirstTimeRun", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("TenderCurrency", Dynamicity.getDataFromPropertiesFile("TenderCurrency", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator", Dynamicity.getDataFromPropertiesFile("snCreator", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("snCreator_Password", Dynamicity.getDataFromPropertiesFile("snCreator_Password", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("SupplierForSN", Dynamicity.getDataFromPropertiesFile("SupplierForSN", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("AutomaticSNCreationBasedOn", Dynamicity.getDataFromPropertiesFile("AutomaticSNCreationBasedOn", PRtoSN_E2E_FieldDetails), filePath_4);
				Dynamicity.updateDataIntoPropertyFile("UpdateFieldDetails", Dynamicity.getDataFromPropertiesFile("UpdateFieldDetails", PRtoSN_E2E_FieldDetails), filePath_4);
				
			}
			catch(Exception e) {
				System.out.println("Unable to update data: "+ e);
			}
		}


}


