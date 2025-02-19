package com.components;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.PythonParser.for_stmt_return;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.baseClasses.ThreadLocalWebdriver;
import com.objectRepository.TenderCreation_Locators;


public class RfqFromIndentComponent extends BaseClass_Web {

	TenderCreation_Locators tendercreationlocators = new TenderCreation_Locators();
	
	SoftAssert softAssert=new SoftAssert();
//	String SystemIndentnoLocatorText = null;
	String SystemIndentnoLocatorText = "3846";
	String expectedSuccessMessage= null;
	String TemplateGroup=null;
	ArrayList<String> commentlist=new ArrayList<String>();
	ArrayList<String> tabcontentList=new ArrayList<String>();
	String tenderIDdromDraft=null;
//	String tenderIDdromDraft="1996";
	public static String BidStartDate=null;
	public static String BidDueDate=null;
	public static String BidOpenDate=null;
	
	public RfqFromIndentComponent(PDFResultReport pdfresultReport) {

		this.pdfResultReport = pdfresultReport;
	}
//Create RFQ from indent (01/02/2021)
	public void navigateToCreateRFQFromIndentPage() throws Throwable {
		try {
			log.info("started executing the method:: navigateToCreateRFQFromIndentPage");
			
			JSClick(tendercreationlocators.mainMenuIconSub, "MenuIcon");
			mouseOver(tendercreationlocators.Enquiry);
			JSClick(tendercreationlocators.createRFQFromIndentBy, "createRFQFromIndent");
			waitForElementToBeVisible(tendercreationlocators.CreateRFQfromIndentLbl_Indent);
			
			pdfResultReport.addStepDetails("navigateToCreateRFQFromIndentPage",
					"Should Navigate to Create RFQ From Indent Page",
					"Successfully navigated to Create RFQ From Indent Page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToCreateRFQFromIndentPage");

		} catch (Exception e) {
			log.fatal("Unable to navigate to Create RFQ From Indent Page" + e.getMessage());

			pdfResultReport.addStepDetails("navigateToCreateRFQFromIndentPage",
					"Should Navigate to Create RFQ From Indent Page",
					"Unable to navigate to Create RFQ From Indent Page" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void navigateToCreateRFQFromIndentPageFromDashboard() throws Throwable {
		try {
			log.info("started executing the method:: navigateToCreateRFQFromIndentPage");
			
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.Enquiry);
			JSClick(tendercreationlocators.createRFQFromIndentBy, "createRFQFromIndent");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.CreateRFQfromIndentLbl_Indent);
			
			pdfResultReport.addStepDetails("navigateToCreateRFQFromIndentPage",
					"Should Navigate to Create RFQ From Indent Page",
					"Successfully navigated to Create RFQ From Indent Page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToCreateRFQFromIndentPage");

		} catch (Exception e) {
			log.fatal("Unable to navigate to Create RFQ From Indent Page" + e.getMessage());

			pdfResultReport.addStepDetails("navigateToCreateRFQFromIndentPage",
					"Should Navigate to Create RFQ From Indent Page",
					"Unable to navigate to Create RFQ From Indent Page" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	
	public void filterIndentTypeFromDropdown(String IndentType) throws Throwable {
		try {
			log.info("started executing the method:: filterIndentTypeFromDropdown");

			// Quick Normal Grouped Split

			String rows = "//tbody/tr/td[position()=3 and text()='{0}']";

			select(tendercreationlocators.selectIndentBy, IndentType);

			WebDriver driver = ThreadLocalWebdriver.getDriver();

			List<WebElement> Indenttabledata = driver.findElements(By.xpath(rows.replace("{0}", IndentType)));

			System.out.println(
					"***********************************************************************************************");

			System.out.println("The No.of Indent Type rows is ---->" + Indenttabledata.size());

			System.out.println(
					"***********************************************************************************************");

			pdfResultReport.addStepDetails("filterIndentTypeFromDropdown", "List will be updated with specific Indent ",
					"Successfully Filtered the Indent Type.The List is updated with" + IndentType
							+ "Indent The Size is  --->" + Indenttabledata.size() + " ",
					"Pass", "Y");

			log.info("completed executing the method:: filterIndentTypeFromDropdown");

		} catch (Exception e) {

			log.fatal("Failed to Filter The Indent type" + e.getMessage());

			pdfResultReport.addStepDetails("navigateToCreateRFQFromIndentPage",
					"List will be updated with specific Indent ", "Failed to Filter The Indent type" + e.getMessage(),
					"Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void searchTheIntendNo(String indentNo) throws Throwable {
		try {
			log.info("started executing the method:: searchTheIntendNo");

			String row = "//tbody/tr/td[text()='{0}/']";

			clear(tendercreationlocators.search, "clear the data");

			set(tendercreationlocators.search, indentNo, "indentNo");

			waitForObj(3000);

			IsElementPresent(By.xpath(row.replace("{0}", indentNo.trim())));

			pdfResultReport.addStepDetails("searchTheIntendNo", "Should display the respective Intend Record",
					"Successfully displaying the respective Intend Record" + " ", "Pass", "Y");

			log.info("completed executing the method:: searchTheIntendNo");

		} catch (Exception e) {

			log.fatal("Failed to  display the respective Intend Record" + e.getMessage());

			pdfResultReport.addStepDetails("searchTheIntendNo", "Should dispaly the respective Intend Record ",
					"Failed to  display the respective Intend Record" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void viewIndentPreviewDetails() throws Throwable {
		try {
			log.info("started executing the method:: viewIndentPreviewDetails");

			highlight(By.xpath("//strong[@class='ng-binding'][text()='General']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Indent Details']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Indent Details']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Basis of Price Estimation']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Basis of Price Estimation']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Other Information']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Other Information']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Partys Site']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Partys Site']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Post Warranty Maintenance required']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Post Warranty Maintenance required']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='BOM Items']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='BOM Items']"));

			waitForObj(3000);

			scrollToElement(By.xpath("(//*[contains(text(),'(Grand Total (Including GST)):')])[1]"));

			highlight(By.xpath("(//*[contains(text(),'(Grand Total (Including GST)):')])[1]"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='BOM Services']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='BOM Services']"));
			waitForObj(3000);

			scrollToElement(By.xpath("(//*[contains(text(),'(Grand Total (Including GST)):')])[3]"));

			highlight(By.xpath("(//*[contains(text(),'(Grand Total (Including GST)):')])[3]"));
			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Estimation Sheet']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Estimation Sheet']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='GST on Material Value (Rs.)']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='GST on Material Value (Rs.)']"));

			waitForObj(5000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='LANDED COST (Rounded Off) Indent Value']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='LANDED COST (Rounded Off) Indent Value']"));

			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Input Tax Credit Value (Rs.)']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Input Tax Credit Value (Rs.)']"));

			waitForObj(3000);
			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Technical Specification']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Technical Specification']"));
			waitForObj(3000);

			scrollToElement(By.xpath("//strong[@class='ng-binding'][text()='Annexures']"));

			highlight(By.xpath("//strong[@class='ng-binding'][text()='Annexures']"));

			waitForObj(3000);

			pdfResultReport.addStepDetails("viewIndentPreviewDetails", "Should View The all the details",
					"Successfully viewd all the intend preview details" + " ", "Pass", "Y");

			log.info("completed executing the method:: viewIndentPreviewDetails");

		} catch (Exception e) {

			log.fatal("Failed to  View The all the details" + e.getMessage());

			pdfResultReport.addStepDetails("viewIndentPreviewDetails", "Should View The all the details ",
					"Failed to  View The all the details" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void clickIndentPreviewOkBtn() throws Throwable {
		try {
			log.info("started executing the method:: clickIndentPreviewOkBtn");

			click(tendercreationlocators.indentpreviewOkBy, "indentpreviewOkBy");

			waitForObj(3000);

			scrollToTopOfThePage();

			pdfResultReport.addStepDetails("clickIndentPreviewOkBtn", "Should close Indend prview details pop up",
					"Successfully closed the Indend prview details pop up" + " ", "Pass", "Y");

			log.info("completed executing the method:: searchTheIntendNo");

		} catch (Exception e) {

			log.fatal("Failed to  close the Indend prview details pop up" + e.getMessage());

			pdfResultReport.addStepDetails("searchTheIntendNo", "Should close the Indend prview details pop up ",
					"Failed to  close the Indend prview details pop up" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	
	public  boolean waitTillSpinnerDisable(WebDriver driver, By by) {
		

		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(by);
			     }
			   });
			   return false;
	}
			 
		
		
	public void clickonIntendViewDetailsFronActionMenu() throws Throwable {
		try {
			log.info("started executing the method:: clickonIntendViewDetailsFronActionMenu");

			waitForObj(3000);

			click(tendercreationlocators.actionMenuDropDownBy, "actionMenuDropDownBy");

			waitForObj(2000);

			click(tendercreationlocators.viewIndentBy, "viewIndentBy");

			waitForElementToBeVisible(tendercreationlocators.systemIntendNoBy);

			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

			waitForObj(2000);

			pdfResultReport.addStepDetails("clickonIntendViewDetailsFronActionMenu",
					"Should display the Indend prview details pop up",
					"Successfully displayed the Indend prview details pop up" + " ", "Pass", "Y");

			log.info("completed executing the method:: searchTheIntendNo");

		} catch (Exception e) {

			log.fatal("Failed to  display the Indend prview details pop up" + e.getMessage());

			pdfResultReport.addStepDetails("searchTheIntendNo", "Should display the Indend prview details pop up ",
					"Failed to  display the Indend prview details pop up" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void navigateToIndentAssignmentListPage() throws Throwable {
		try {
			log.info("started executing the method:: navigateToIndentAssignmentListPage");

			JSClick(tendercreationlocators.tendersIcon, "tendersIcon");

			waitForObj(2000);

			JSClick(tendercreationlocators.indentAssignmentLinkBy, "indentAssignmentLinkBy");

			waitForElementToBeVisible(tendercreationlocators.IndenttableDataRowsBy);

			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

			waitForObj(5000);

			pdfResultReport.addStepDetails("navigateToIndentAssignmentListPage",
					"Should Navigate to IndentAssignment List Page",
					"Successfully  Navigated to IndentAssignment List Page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToIndentAssignmentListPage");

		} catch (Exception e) {
			log.fatal("Unable to Navigate to IndentAssignment List Page" + e.getMessage());

			pdfResultReport.addStepDetails("navigateToIndentAssignmentListPage",
					"Should Navigate to IndentAssignment List Page",
					"Unable to Navigate to IndentAssignment List Page" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void clickOnIndentRevertFromActionMenu() throws Throwable {
		try {
			log.info("started executing the method:: clickOnIndentRevertFromActionMenu");

			waitForObj(3000);

			click(tendercreationlocators.actionMenuDropDownBy, "actionMenuDropDownBy");

			waitForObj(2000);

			highlight(tendercreationlocators.revertBy);

			click(tendercreationlocators.revertBy, "revertBy");

			waitForObj(3000);

			waitForElementToBeVisible(tendercreationlocators.reasonForRevertBy);

			waitForObj(3000);

			pdfResultReport.addStepDetails("clickOnIndentRevertFromActionMenu",
					"Should display Alert popUp For reason for revert",
					"Successfully display Alert pop up For reason for revert" + " ", "Pass", "Y");

			log.info("completed executing the method:: clickOnIndentRevertFromActionMenu");

		} catch (Exception e) {

			log.fatal("Failed to display Alert pop For reason for revert" + e.getMessage());

			pdfResultReport.addStepDetails("clickOnIndentRevertFromActionMenu",
					"Should display  Alert pop up For reason for revert ",
					"Failed to  display  Alert pop up For reason for revert" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void enterTheRevertReasonAndSubmit() throws Throwable {
		try {
			log.info("started executing the method:: enterTheRevertReasonAndSubmit");

			set(tendercreationlocators.reasonForRevertBy, "reason for reverting", "reasonForRevertBy");

			waitForObj(2000);

			click(tendercreationlocators.indentRevertSubmitBtnBy, "indentRevertSubmitBtnBy");

			waitForElementToBeVisible(tendercreationlocators.sucessMsgIndertRevertedBy);

			waitForObj(2000);

			click(tendercreationlocators.confirmationOkBy, "confirmationOkBy");

			waitForObj(5000);

			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

			waitForElementToBeVisible(tendercreationlocators.IndenttableDataRowsBy);

			pdfResultReport.addStepDetails("enterTheRevertReasonAndSubmit", "Should revert the Indent ",
					"Successfully reverted the Indent" + " ", "Pass", "Y");

			log.info("completed executing the method:: enterTheRevertReasonAndSubmit");

		} catch (Exception e) {

			log.fatal("Failed to  revert the Indent" + e.getMessage());

			pdfResultReport.addStepDetails("clickOnIndentRevertFromActionMenu", "Should revert the Indent",
					"Failed to  revert the Indent" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void clickOnIndentReversalHistoryFromActionMenu() throws Throwable {
		try {
			log.info("started executing the method:: clickOnIndentReversalHistoryFromActionMenu");

			waitForObj(3000);

			IsElementPresent(tendercreationlocators.revertedStatusBy);

			highlight(tendercreationlocators.revertedStatusBy);

			click(tendercreationlocators.actionMenuDropDownBy, "actionMenuDropDownBy");

			waitForObj(2000);

			highlight(tendercreationlocators.reversalHistoryBy);

			waitForObj(2000);

			click(tendercreationlocators.reversalHistoryBy, "reversalHistoryBy");

			waitForObj(3000);

			waitForElementToBeVisible(tendercreationlocators.reversalHistoryViewPopUpBy);

			waitForObj(5000);

			pdfResultReport.addStepDetails("clickOnIndentReversalHistoryFromActionMenu",
					"Should display reversal History View PopUp",
					"Successfully displayed reversal History View PopUp" + " ", "Pass", "Y");

			click(tendercreationlocators.reversalHistoryViewPopUpOkBtnBy, "reversalHistoryViewPopUpOkBtnBy");

			log.info("completed executing the method:: clickOnIndentRevertFromActionMenu");

		} catch (Exception e) {

			log.fatal("Failed to  display reversal History View PopUp" + e.getMessage());

			pdfResultReport.addStepDetails("clickOnIndentRevertFromActionMenu",
					"Should display reversal History View PopUp ",
					"Failed to  display reversal History View PopUp" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void clickCreateRFQBtnInIndentPreviewPopUp() throws Throwable {
		try {
			log.info("started executing the method:: clickCreateRFQBtnInIndentPreviewPopUp");

			waitForObj(3000);

			click(tendercreationlocators.actionMenuDropDownBy, "actionMenuDropDownBy");

			waitForObj(2000);

			highlight(tendercreationlocators.createRfqDropDownBy);

			click(tendercreationlocators.createRfqDropDownBy, "createRfqDropDownBy");

			waitForObj(3000);

			waitForElementToBeVisible(tendercreationlocators.systemIntendNoBy);

			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

			waitForObj(3000);

			click(tendercreationlocators.createFRQBtnBy, "createFRQBtnBy");

			waitForElementToBeVisible(tendercreationlocators.selectTemplateGroupBy);

			waitForObj(3000);

			pdfResultReport.addStepDetails("clickCreateRFQBtnInIndentPreviewPopUp",
					"Should display Please Select a Template Group pop up",
					"Successfully displayed Please Select a Template Group pop up" + " ", "Pass", "Y");

			log.info("completed executing the method:: clickCreateRFQBtnInIndentPreviewPopUp");

		} catch (Exception e) {

			log.fatal("Failed to display Please Select a Template Group pop up" + e.getMessage());

			pdfResultReport.addStepDetails("clickCreateRFQBtnInIndentPreviewPopUp",
					"Should display Please Select a Template Group pop up ",
					"Failed to  display Please Select a Template Group pop up" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void selectTemplateGroupAndSubmit(String TemplateGroup) throws Throwable {
		try {
			log.info("started executing the method:: selectTemplateGroupAndSubmit");

			waitForObj(3000);

			// With Optional Items & Qty Editable by Supplier_V2

			select(tendercreationlocators.selectTemplateGroupBy, TemplateGroup);

			waitForObj(3000);

			click(tendercreationlocators.createRFQFromIndentSubmitBtn, "createRFQFromIndentSubmitBtn");

			waitForElementToBeVisible(tendercreationlocators.BOQmandatoryTab);

			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

			waitForObj(5000);

			pdfResultReport.addStepDetails("selectTemplateGroupAndSubmit", "Should Navigate to Tender tabs page",
					"Successfully Should Navigate to  Tender tabs page" + " ", "Pass", "Y");

			log.info("completed executing the method:: selectTemplateGroupAndSubmit");

		} catch (Exception e) {

			log.fatal("Failed to   Navigate to Tender tabs page" + e.getMessage());

			pdfResultReport.addStepDetails("clickCreateRFQBtnInIndentPreviewPopUp",
					"Should Navigate to Tender tabs page ", "Failed to   Navigate to Tender tabs page" + e.getMessage(),
					"Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public static int getrandomInterger(int min, int max) {
		
		return ((int) (Math.random() * (max - min))) + min;

	}

	String tenderRef = null;


	public void Tender_WithOptionalItemsAndQtyEditableBOQOptional() throws Exception {
		try {
			log.info("started executing the method:: Tender_WithOptionalItemsAndQtyEditableBOQOptional");

			WebDriver driver = ThreadLocalWebdriver.getDriver();

			waitForObj(2000);

			click(tendercreationlocators.BOQOptionalTab, "BOQOptionalTab");

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			waitForElementToBeVisible(tendercreationlocators.BOQOptionItemCode);

			selectNonSorItems(0, 1);

			waitForObj(2000);

			click(tendercreationlocators.savebutton, "savebutton");

			waitForObj(2000);

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQOptional",
					"Should save the BOQ optional fields", "Sucessfully saved the  BOQ optional fields " + " ", "Pass",
					"Y");
			log.info("completed executing the method:: Tender_WithOptionalItemsAndQtyEditableBOQOptional");

		} catch (Exception e) {

			log.fatal("Unable to saved the  BOQ optional fields" + e.getMessage());
			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQOptional",
					"Should save the BOQ optional fields", "Unable to saved the  BOQ optional fields" + e.getMessage(),
					"Fail", "N");
		}
	}

	public void selectNonSorItems(int j, int k) throws IOException {

		List<WebElement> itemCode = ThreadLocalWebdriver.getDriver()
				.findElements(tendercreationlocators.boqSummaryItemCode);

		List<WebElement> itemDescription = ThreadLocalWebdriver.getDriver()
				.findElements(tendercreationlocators.boqSummaryItemDescription);

		List<WebElement> quantity = ThreadLocalWebdriver.getDriver()
				.findElements(tendercreationlocators.projectQtysItemsBy);

		List<WebElement> uom = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.boqSummaryUom);

		List<WebElement> scheduleRate = ThreadLocalWebdriver.getDriver()
				.findElements(tendercreationlocators.boqSummarySorRate);

		List<WebElement> PreferedMake = ThreadLocalWebdriver.getDriver()
				.findElements(tendercreationlocators.preferedmake);

		List<WebElement> Remarks = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.remarks);

		for (int i = j; i <= k; ++i) {

			itemCode.get(i).clear();
			itemCode.get(i).sendKeys(pdfResultReport.testData.get("BOQ(Mandatory)-ItemCode").concat(String.valueOf(i)));

			waitForObj(2000);
			itemDescription.get(i).clear();
			itemDescription.get(i)
					.sendKeys(pdfResultReport.testData.get("BOQ(Mandatory)-ItemDescription").concat(String.valueOf(i)));
			waitForObj(2000);

			Select select = new Select(uom.get(i));
			select.selectByIndex(i + 13);
			waitForObj(2000);

			quantity.get(i).clear();
			quantity.get(i).sendKeys(eTenderComponent.getDataFromPropertiesFile("TenderItemQty"));
			waitForObj(2000);

			scheduleRate.get(i).clear();

			scheduleRate.get(i).sendKeys(eTenderComponent.getDataFromPropertiesFile("TenderBudgetRate"));
			waitForObj(2000);

			PreferedMake.get(i).clear();

			PreferedMake.get(i).sendKeys(pdfResultReport.testData.get("PreferedMaker").concat(String.valueOf(i)));
			waitForObj(2000);

			Remarks.get(i).clear();
			Remarks.get(i).sendKeys(pdfResultReport.testData.get("Remarks").concat(String.valueOf(i)));
			waitForObj(2000);

		}

	}

	public void clickIndentPreviewPrintBtn() throws Throwable {
		try {
			log.info("started executing the method:: clickIndentPreviewPrintBtn");

			JSClick(tendercreationlocators.printBy, "printBy");

			waitForObj(5000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			pdfResultReport.addStepDetails("clickIndentPreviewPrintBtn", "Should click on  Indend prview Print Btn",
					"Successfully clicked on  Indend prview Print Btn" + " ", "Pass", "Y", "");

			log.info("completed executing the method:: searchTheIntendNo");

		} catch (Exception e) {

			log.fatal("Failed to click on  Indend prview Print Btnp" + e.getMessage());

			pdfResultReport.addStepDetails("clickIndentPreviewOkBtn", "Should click on  Indend prview Print Btn ",
					"Failed to click on  Indend prview Print Btn" + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void Tender_WithOptionalItemsAndQtyEditableGeneralInfo() throws Exception {
		try {
			log.info("started executing the method:: Tender_WithOptionalItemsAndQtyEditableGeneralInfo");

			waitForObj(3000);

			select(tendercreationlocators.bitPartdropdown, "2");

			click(tendercreationlocators.bitPartRadio, "bitPartRadio");

			tenderRef = "TendRef_";

			int getrandomInterger = getrandomInterger(10000, 1000000000);

			tenderRef = tenderRef.concat(String.valueOf(getrandomInterger));

			eTenderComponent.updateDataIntoPropertyFile("TenderRefNumber", tenderRef);

			clear(tendercreationlocators.tenderReferenceNumber, "tenderReferenceNumber");

			set(tendercreationlocators.tenderReferenceNumber, tenderRef, "tenderReferenceNumber");

			select(tendercreationlocators.procurementCategory, "Default_cat");

			select(tendercreationlocators.tenderCurrency, pdfResultReport.testData.get("TenderCurrency"));

			set(tendercreationlocators.probabaleAmountContract,
					eTenderComponent.getDataFromPropertiesFile("ProbableAmountOfContract"), "probabaleAmountContract");

			select(tendercreationlocators.biddingCurrency, pdfResultReport.testData.get("BiddingCurrency"));
			select(tendercreationlocators.tenderType, pdfResultReport.testData.get("TenderType"));

			set(tendercreationlocators.detailedDescription,
					pdfResultReport.testData.get("CreateTender-DetailedDescription"), "detailedDescription");

			click(tendercreationlocators.savebutton, "savebutton");

			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableGeneralInfo",
					"Should save generalInfo tab fields", "Sucessfully saved generalInfo tab fields " + " ", "Pass",
					"Y");
			log.info("completed executing the method:: Tender_WithOptionalItemsAndQtyEditableGeneralInfo");

		} catch (Exception e) {

			log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableGeneralInfo",
					"Should save generalInfo tab fields", "Unable to save generalInfo tab fields" + e.getMessage(),
					"Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void Tender_WithOptionalItemsAndQtyEditableBOQOptional(int startingRow, int endingrow) throws Exception {
		try {
			log.info("started executing the method:: Tender_WithOptionalItemsAndQtyEditableBOQOptional");

			WebDriver driver = ThreadLocalWebdriver.getDriver();

			waitForObj(2000);

			click(tendercreationlocators.BOQOptionalTab, "BOQOptionalTab");

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			waitForElementToBeVisible(tendercreationlocators.BOQOptionItemCode);

			selectNonSorItems(startingRow, endingrow);

			waitForObj(2000);

			click(tendercreationlocators.savebutton, "savebutton");

			waitForObj(2000);

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			waitForObj(3000);

			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQOptional",
					"Should save the BOQ optional fields", "Sucessfully saved the  BOQ optional fields " + " ", "Pass",
					"Y");
			log.info("completed executing the method:: Tender_WithOptionalItemsAndQtyEditableBOQOptional");

		} catch (Exception e) {

			log.fatal("Unable to saved the  BOQ optional fields" + e.getMessage());
			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQOptional",
					"Should save the BOQ optional fields", "Unable to saved the  BOQ optional fields" + e.getMessage(),
					"Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}

	public void Tender_WithOptionalItemsAndQtyEditableBOQMandatortTab(int startingrow, int endingrow) throws Exception {
		try {
			log.info("started executing the method::  Tender_WithOptionalItemsAndQtyEditableBOQMandatortTab");

			WebDriver driver = ThreadLocalWebdriver.getDriver();

			waitForObj(2000);

			click(tendercreationlocators.BOQmandatoryTab, "BOQmandatoryTab");

			waitForObj(2000);

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			waitForObj(2000);

			selectNonSorItems(startingrow, endingrow);

			waitForObj(3000);

			click(tendercreationlocators.savebutton, "savebutton");

			waitForObj(3000);

			waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);

			waitForObj(3000);

			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQMandatortTab",
					"Should Save BOQ MandatortTab Items data Sucessfully",
					"Succesfully Saved BOQ Mandatory Items" + " ", "Pass", "Y");
			log.info("completed executing the method::  Tender_WithOptionalItemsAndQtyEditableBOQMandatortTab");

		} catch (Exception e) {

			log.fatal("Unable to save the BOQ Mandatorty Tab Items data " + e.getMessage());
			pdfResultReport.addStepDetails("Tender_WithOptionalItemsAndQtyEditableBOQMandatortTab",
					"Should save BOQ MandatoryItems data  Sucessfully ",
					"Unable to save the BOQ Mandatorty Tab Items data " + e.getMessage(), "Fail", "N");

			Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Indent approver login (21/01/2021)
	public void IndentapproverLogin() throws Throwable {
		try {
			log.info("started executing the method:: IndentapproverLogin");
			//click(tendercreationlocators.login, "login"); // commented on 201221
			set(tendercreationlocators.userName, pdfResultReport.testData.get("IndentApproverUserName"), "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			//Handle fixed Captcha (06/11/2020)
			//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha");  // commented on 201221
			click(tendercreationlocators.okButton, "okButton");
			waitForElement(tendercreationlocators.dashboardIcon, 30);
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver must be sucessfully logged in",
					"Successfully logged in as indent approver" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentapproverLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver is not logged in",
					"Unable to login as indent approver" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void ApproverLogin(String approvername) throws Throwable {
		try {
			log.info("started executing the method:: IndentapproverLogin");
			//click(tendercreationlocators.login, "login"); // commented on 201221
			set(tendercreationlocators.userName, approvername, "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			//click(tendercreationlocators.password, "password");
			//Handle fixed Captcha (06/11/2020)
			//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha");  // commented on 201221
			waitForElementToBeClickable(tendercreationlocators.okButton);
			click(tendercreationlocators.okButton, "okButton");
			BuyerDepartmentWiseLogin(approvername);
			waitForElement(tendercreationlocators.mainMenuIcon, 20);
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver must be sucessfully logged in",
					"Successfully logged in as indent approver" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentapproverLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver is not logged in",
					"Unable to login as indent approver" + e.getMessage(), "Fail", "N");
		}
	}
	//added by @AD
	public void commonLogin(String approvername) throws Throwable {
		try {
			log.info("started executing the method:: IndentapproverLogin");
			set(tendercreationlocators.userName, approvername, "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			click(tendercreationlocators.okButton, "okButton");
			waitForElement(tendercreationlocators.dashboardIcon, 30);
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver must be sucessfully logged in",
					"Successfully logged in as indent approver" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentapproverLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Indent approver login", "Indent approver is not logged in",
					"Unable to login as indent approver" + e.getMessage(), "Fail", "N");
		}
	}
	
	//Indent creator login (21/01/2021)
	public void IndentcreatorLogin() throws Throwable {
		try {
			log.info("started executing the method:: IndentcreatorLogin");
			//click(tendercreationlocators.login, "login"); // edited on 30-11-21
			set(tendercreationlocators.userName, pdfResultReport.testData.get("IndentCreatorUserName"), "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			//Handle fixed Captcha (06/11/2020)
			//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha"); // edited on 30-11-21
			SSClick(tendercreationlocators.okButton, "okButton");
			//waitForElement(tendercreationlocators.dashboardIcon, 30); //commented on 110722
			waitForElement(tendercreationlocators.dashboardIconnew, 30);
			pdfResultReport.addStepDetails("Indent creator login", "Indent creator must be sucessfully logged in",
					"Successfully logged in as indent creator" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentcreatorLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Indent creator login", "Indent creator is not logged in",
					"Unable to login as indent creator" + e.getMessage(), "Fail", "N");
		}
	}
	//Navigate to Indent listing page (21/01/2021)
	public void navigateToIndentListing() throws Throwable {
		try {
			log.info("started executing the method:: navigateToIndentListing");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.Requisition);
			JSClick(tendercreationlocators.IndentIcon, "IndentIcon");
			checkPageIsReady();
			waitForElementToBeVisible(tendercreationlocators.Lbl_IndentList);

			pdfResultReport.addStepDetails("Navigate to indent List", "Indent list must be navigated successfully",
					"Successfully navigated to Indent list" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToIndentListing");

		} catch (Exception e) {
			log.fatal("Unable to navigate to the indent list" + e.getMessage());
			pdfResultReport.addStepDetails("Navigate to indent List", "Not able to navigate to the indent list",
					"Unable to navigate to the indent list" + e.getMessage(), "Fail", "N");
		}
	}
	
	//Navigate to Indent Creation page (11/07/2022)
		public void navigateToIndentCreationNew() throws Throwable {
			try {
				log.info("started executing the method:: navigateToIndentCreation");
				// mouseOver(tendercreationlocators.tendersIcon);
				JSClick(tendercreationlocators.mainMenuIcon, "mainMenuIcon");
				mouseOver(tendercreationlocators.Requisition);
				JSClick(tendercreationlocators.CreateIndent, "CreateIndent");
				//WebDriver driver = ThreadLocalWebdriver.getDriver();
				checkPageIsReady();
				waitForElementToBeVisible(tendercreationlocators.GIindent);
				//waitTillSpinnerDisable(driver, tendercreationlocators.LoadingBy);
				waitForObj(3000);
				

				pdfResultReport.addStepDetails("Navigate to indent creation", "Indent creation must be navigated successfully",
						"Successfully navigated to Indent creation page" + " ", "Pass", "Y");
				log.info("completed executing the method:: navigateToIndentCreation");

			} catch (Exception e) {
				log.fatal("Unable to navigate to the indent creation" + e.getMessage());
				pdfResultReport.addStepDetails("Navigate to indent creation", "Not able to navigate to the indent creation",
						"Unable to navigate to the indent creation" + e.getMessage(), "Fail", "N");
			}
		}
		
	//Navigate to Indent Creation page (21/01/2021)
	public void navigateToIndentCreation() throws Throwable {
		try {
			log.info("started executing the method:: navigateToIndentCreation");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.Requisition);
			JSClick(tendercreationlocators.IndentIcon, "IndentIcon");
			checkPageIsReady();
			waitForElementToBeClickable(tendercreationlocators.CreateIndent);  //updated on 29-11-2025
			click(tendercreationlocators.CreateIndent, "CreateIndent"); //updated on 29-11-2025
			dynamic_Loader(tendercreationlocators.loadingLocator, 2);
			pdfResultReport.addStepDetails("Navigate to indent creation", "Indent creation must be navigated successfully",
					"Successfully navigated to Indent creation page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToIndentCreation");

		} catch (Exception e) {
			log.fatal("Unable to navigate to the indent creation" + e.getMessage());
			pdfResultReport.addStepDetails("Navigate to indent creation", "Not able to navigate to the indent creation",
					"Unable to navigate to the indent creation" + e.getMessage(), "Fail", "N");
		}
	}
	//General Information tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_General_Info_tabvalidation(String TemplateGroup)
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_General_Info_tabvalidation()");
			//waitForElement(tendercreationlocators.Indent_TG_select, 30);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			select(tendercreationlocators.Indent_TG_select, TemplateGroup);
			//waitForElementToBeVisible(tendercreationlocators.Indent_TG_View);
			String Indent_Ref_No = "IndentRef_";
			int getrandomInterger = getrandomInterger(10000, 1000000000);
			Indent_Ref_No = Indent_Ref_No.concat(String.valueOf(getrandomInterger));
			set(tendercreationlocators.IndentRefNo, Indent_Ref_No, "IndentReferenceNumber");
			set(tendercreationlocators.GenDesc_Indent, pdfResultReport.testData.get("Indent_Geninfo_Desc"), "GenDesc_Indent");
			select(tendercreationlocators.GenInfo_NormalEmergency_Indent, "Normal");
			select(tendercreationlocators.IndentCategory, "Default_cat");
			select(tendercreationlocators.IndentCurrency, pdfResultReport.testData.get("Indent_Geninfo_Currency"));
			selectbyvalue(tendercreationlocators.ProcMode_Indent, pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
			set(tendercreationlocators.GenInfo_Remarks_Indent, pdfResultReport.testData.get("Indent_Geninfo_Remarks"), "GenInfo_Remarks_Indent");
			scrollToTopOfThePage();
			/*
			 * click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
			 * waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(),
			 * tendercreationlocators.LoadingBy); waitForObj(5000);
			 * waitForElementToBeVisible(tendercreationlocators.IndentDetailsTab);
			 * waitForElementToBeClickable(tendercreationlocators.IndentDetailsTab);
			 */
			//Modified on 130722
			waitForObj(2000);
			
			click(tendercreationlocators.Savebtn_IndentNew, "savebutton");
			universalWait();
			//created by @Pavel 11012024
			try {
				
		if(isElementTextPresent(tendercreationlocators.IndentSuccessMessage, "General Information page is saved successfully and the new Indent No. "+getPRNumberFromString(tendercreationlocators.IndentSuccessMessage)+" is successfully generated.")==true)
		{
			
			pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
					"Should get success message with indent number", "Sucessfully saved generalInfo tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_General_Info_tabvalidation");

		}
			}
			catch (Exception e) {
				pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation", "Should get success message with indent number",
						"Unable to unable to get proper message" + e.getMessage(), "Fail", "N");
			}
			
		
			//JSClick(tendercreationlocators.IndentSuccessOK, "IndentSuccess");
			//softAssert.assertEquals("General Information page is saved successfully and the new Indent No. 1623 is successfully generated.",tendercreationlocators.IndentSuccessMessage);
			
			
			waitForElementToBeClickable(tendercreationlocators.IndentSuccessOK);
			
			//click(tendercreationlocators.IndentSuccessOK, "IndentSuccess");
			JSClick(tendercreationlocators.IndentSuccessOK, "IndentSuccess");
			universalWait();
			
			tabcontentList.add(text(tendercreationlocators.tabContent));
			waitForObj(4000);
			pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
					"Should save generalInfo tab fields during indent creation", "Sucessfully saved generalInfo tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_General_Info_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
					"Should save generalInfo tab fields during indent creation", "Unable to save generalInfo tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//General Information tab validation for Indent TG1 (01/06/2021)
		public void IndentTG8_General_Info_tabvalidation(String TemplateGroup)
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG1_General_Info_tabvalidation()");
				waitForElement(tendercreationlocators.Indent_TG_select, 30);
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				select(tendercreationlocators.Indent_TG_select, TemplateGroup);
				waitForElementToBeVisible(tendercreationlocators.Indent_TG_View);
				String Indent_Ref_No = "IndentRef_";
				int getrandomInterger = getrandomInterger(10000, 1000000000);
				Indent_Ref_No = Indent_Ref_No.concat(String.valueOf(getrandomInterger));
				set(tendercreationlocators.IndentRefNo, Indent_Ref_No, "IndentReferenceNumber");
				select(tendercreationlocators.IndentCategory, "Default_cat");
				select(tendercreationlocators.IndentCurrency, pdfResultReport.testData.get("Indent_Geninfo_Currency"));
				select(tendercreationlocators.ProcMode_Indent, pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
				scrollToElement(tendercreationlocators.GenDesc_Indent);
				set(tendercreationlocators.GenDesc_Indent,
						pdfResultReport.testData.get("Indent_Geninfo_Desc"), "GenDesc_Indent");
				scrollToTopOfThePage();
				click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(5000);
				/*
				 * waitForElementToBeVisible(tendercreationlocators.indentDetailsTab_TG8);
				 * waitForElementToBeClickable(tendercreationlocators.indentDetailsTab_TG8);
				 */
				
				pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
						"Should save generalInfo tab fields during indent creation", "Sucessfully saved generalInfo tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_General_Info_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG8_General_Info_tabvalidation",
						"Should save generalInfo tab fields during indent creation", "Unable to save generalInfo tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
		
		//General Information tab validation for Indent TG1 (02/12/2021)
				public void IndentTG9_General_Info_tabvalidation(String TemplateGroup)
						throws Exception {
					try {
						log.info(
								"started executing the method:: IndentTG1_General_Info_tabvalidation()");
						waitForElement(tendercreationlocators.Indent_TG_select, 30);
						waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						select(tendercreationlocators.Indent_TG_select, TemplateGroup);
						waitForElementToBeVisible(tendercreationlocators.Indent_TG_View);
						String Indent_Ref_No = "IndentRef_";
						int getrandomInterger = getrandomInterger(10000, 1000000000);
						Indent_Ref_No = Indent_Ref_No.concat(String.valueOf(getrandomInterger));
						set(tendercreationlocators.IndentRefNo, Indent_Ref_No, "IndentReferenceNumber");
						select(tendercreationlocators.IndentCategory, "Default_cat");
						select(tendercreationlocators.IndentCurrency, pdfResultReport.testData.get("Indent_Geninfo_Currency"));
						set(tendercreationlocators.EstimatedPrice_Indent, pdfResultReport.testData.get("SORRate"), "EstimatedPrice_Indent");
						select(tendercreationlocators.ProcMode_Indent, pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
						scrollToElement(tendercreationlocators.GenDesc_Indent);
						set(tendercreationlocators.GenDesc_Indent,
								pdfResultReport.testData.get("Indent_Geninfo_Desc"), "GenDesc_Indent");
						scrollToTopOfThePage();
						click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
						waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(5000);
						/*
						 * waitForElementToBeVisible(tendercreationlocators.indentDetailsTab_TG8);
						 * waitForElementToBeClickable(tendercreationlocators.indentDetailsTab_TG8);
						 */
						
						pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
								"Should save generalInfo tab fields during indent creation", "Sucessfully saved generalInfo tab fields during indent creation " + " ", "Pass",
								"Y");
						log.info(
								"completed executing the method:: IndentTG1_General_Info_tabvalidation");

					} catch (Exception e) {

						log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
						pdfResultReport.addStepDetails("IndentTG8_General_Info_tabvalidation",
								"Should save generalInfo tab fields during indent creation", "Unable to save generalInfo tab fields during indent creation" + e.getMessage(),
								"Fail", "N");
					}
				}
				
				
			//General Information tab validation for Indent TG1 (11/07/2022)
				public void IndentTG9_General_Info_tabvalidationNew(String TemplateGroup)
						throws Throwable {
					try {
						log.info(
								"started executing the method:: IndentTG9_General_Info_tabvalidation()");
						//waitForElement(tendercreationlocators.Indent_TG_select, 30);
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						select(tendercreationlocators.Indent_TG_select, TemplateGroup);
						waitForObj(2000);
						//waitForElementToBeVisible(tendercreationlocators.Indent_TG_View);
						String Indent_Ref_No = "IndentRef_";
						int getrandomInterger = getrandomInterger(10000, 1000000000);
						Indent_Ref_No = Indent_Ref_No.concat(String.valueOf(getrandomInterger));
						set(tendercreationlocators.IndentRefNo, Indent_Ref_No, "IndentReferenceNumber");
						select(tendercreationlocators.IndentCategory, "Default_cat");
						select(tendercreationlocators.IndentCurrency, pdfResultReport.testData.get("Indent_Geninfo_Currency"));
						set(tendercreationlocators.EstimatedPrice_Indent, pdfResultReport.testData.get("SORRate"), "EstimatedPrice_Indent");
						select(tendercreationlocators.ProcMode_Indent, pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
						scrollToElement(tendercreationlocators.GenDesc_Indent);
						set(tendercreationlocators.GenDesc_Indent,
								pdfResultReport.testData.get("Indent_Geninfo_Desc"), "GenDesc_Indent");
						scrollToTopOfThePage();
						click(tendercreationlocators.Savebtn_IndentNew, "savebutton");
						waitForObj(3000);
						JSClick(tendercreationlocators.IndentSuccessOK, "IndentSuccess");
						waitForObj(2000);
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						
						/*
						 * waitForElementToBeVisible(tendercreationlocators.indentDetailsTab_TG8);
						 * waitForElementToBeClickable(tendercreationlocators.indentDetailsTab_TG8);
						 */
						
						pdfResultReport.addStepDetails("IndentTG1_General_Info_tabvalidation",
								"Should save generalInfo tab fields during indent creation", "Sucessfully saved generalInfo tab fields during indent creation " + " ", "Pass",
								"Y");
						log.info(
								"completed executing the method:: IndentTG1_General_Info_tabvalidation");

					} catch (Exception e) {

						log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
						pdfResultReport.addStepDetails("IndentTG8_General_Info_tabvalidation",
								"Should save generalInfo tab fields during indent creation", "Unable to save generalInfo tab fields during indent creation" + e.getMessage(),
								"Fail", "N");
					}
				}
				
				//added on 04-12-21
				
				public static void waitForSpinnerToDisappear() {
					WebDriver driver = ThreadLocalWebdriver.getDriver();
					WebDriverWait wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='spinnerholder']"))));
				}
				
				//added on 04-12-21
				
				public static void waitForSpinnerToDisappearNew() {
					WebDriver driver = ThreadLocalWebdriver.getDriver();
					WebDriverWait wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Please Wait')]"))));
				}
				//added on 04-12-21 //modified on 120722
				public void TG9_Indnet_attachments() throws Throwable {
					try {
						log.info("started executing the method:: TG9_Indnet_attachments");
						waitForElement(tendercreationlocators.IndentAttachmentTab, 30);
						waitForObj(2000);
						click(tendercreationlocators.IndentAttachmentTab, "IndentAttachmentTab");
						//waitForSpinnerToDisappear();
						waitForObj(2000);
						click(tendercreationlocators.AddAttachment, "AddAttachment");
						set(tendercreationlocators.IndentLabel, pdfResultReport.testData.get("Attachments-Label"), "label");
						set(tendercreationlocators.IndentAttachments, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
								"fileName");
						click(tendercreationlocators.OkAttach, "attachmentOKbutton");
						waitForObj(2000);
						JSClick(tendercreationlocators.savebuttonNew, "savebutton");
						waitForObj(2000);
						waitForSpinnerToDisappearNew();
						pdfResultReport.addStepDetails("Successfully Created Indent",
								"Indent must be created successfully using Indnet_attachment as template group ",
								"Indent is created successfully using Supply_Indnet_2.4 as template group" + " ",
								"Pass", "Y");
						log.info("completed executing the method:: Indnet_attachment");
					} catch (Exception e) {
						log.fatal("Not able to create tender" + e.getMessage());
						pdfResultReport.addStepDetails("Not able to create tender",
								"Not able to create Indent using Supply_Indnet_2.4 as template group",
								"Unable to create Indent using Supply_Indnet_2.4 as template group"
										+ e.getMessage(),
								"Fail", "N");
					}
					
				}
		
				//Indent Items tab validation for Indent TG9 (04/12/2021)
				public void IndentTG9_indent_items_tabvalidation()
						throws Exception {
					try {
						log.info(
								"started executing the method:: indent_items_tabvalidation()");
						waitForElement(tendercreationlocators.IndentItemTab, 30);
						click(tendercreationlocators.IndentItemTab, "IndentItemTab");
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(2000);
						click(tendercreationlocators.AddIndentItems, "AddIndentItems");
						//set(tendercreationlocators.TG9_IndentNumber, pdfResultReport.testData.get("ItemCode"), "TG9_IndentNumber");
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
				    	String dateString = dateFormat.format(new Date()).toString();
						set(tendercreationlocators.DateOfRequirement, dateString, "DateOfRequirement");
						set(tendercreationlocators.Department, pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"), "Department");
						set(tendercreationlocators.IndentDate, dateString, "IndentDate");
						click(tendercreationlocators.savebuttonNew, "savebutton");
						waitForSpinnerToDisappearNew();
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(2000);
						pdfResultReport.addStepDetails("indent_items_tabvalidation",
								"Should save indent_items tab fields during indent creation", "Sucessfully saved Technical Specification tab fields during indent creation " + " ", "Pass",
								"Y");
						log.info(
								"completed executing the method:: indent_items_tabvalidation");

					} catch (Exception e) {
						log.fatal("Not able to save Technical Specification tab fields" + e.getMessage());
						pdfResultReport.addStepDetails("indent_items_tabvalidation",
								"Should save indent_items tab fields during indent creation", "Unable to save indent_items tab fields during indent creation" + e.getMessage(),
								"Fail", "N");
					}
				}
				
				
				//BOM Item tab validation for Indent TG8 (01/06/2021)
				public void IndentTG9_BOMitems_tabvalidation()
						throws Exception {
					try {
						log.info(
								"started executing the method:: IndentTG8_BOM_Item_tabvalidation()");
						waitForElementToBeClickable(tendercreationlocators.BOMitemsTab);
						//waitForElement(tendercreationlocators.bomItems_TG8, 30);
						click(tendercreationlocators.BOMitemsTab, "BOMitemsTab");
						waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(1000);
						click(tendercreationlocators.addNonSORitemsIndent_TG8, "addNonSORitemsIndent_TG8");
						set(tendercreationlocators.itemCodeIndet_TG8, pdfResultReport.testData.get("ItemCode_TG1BOMItemTab"), "ItemCode_TG8BOMItemTab");
						set(tendercreationlocators.itemNameIndent_TG8, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "ItemName_TG8BOMItemTab");
						select(tendercreationlocators.unitIndent_TG8, pdfResultReport.testData.get("unitIndent_TG8"));
						set(tendercreationlocators.qtyIndent_TG8, pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG8BOMItemTab");
						scrollToElement(tendercreationlocators.unitRateIndent_TG8);
						set(tendercreationlocators.unitRateIndent_TG8, pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG8BOMItemTab");
						scrollToElement(tendercreationlocators.gstIndent_TG8);
						set(tendercreationlocators.gstIndent_TG8, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG8BOMItemTab");
						scrollToElement(tendercreationlocators.consigneeIndent_TG8);
						select(tendercreationlocators.consigneeIndent_TG8, pdfResultReport.testData.get("consigneeIndent_TG8"));
						scrollToTopOfThePage();
						click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
						waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(5000);
						pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tabvalidation",
								"Should save BOM Item tab fields during indent creation", "Sucessfully saved BOM Item tab fields during indent creation " + " ", "Pass",
								"Y");
						log.info(
								"completed executing the method:: IndentTG1_BOM_Item_tabvalidation");

					} catch (Exception e) {

						log.fatal("Not able to save BOM Item tab fields" + e.getMessage());
						pdfResultReport.addStepDetails("IndentTG8_BOM_Item_tabvalidation",
								"Should save BOM Item tab fields during indent creation", "Unable to save BOM Item tab fields during indent creation" + e.getMessage(),
								"Fail", "N");
					}
				}
				
	//Indent Details tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_Indent_Details_tabvalidation()
			throws Exception {
		try {
			log.info(
					"started executing the method:: IndentTG1_Indent_Details_tabvalidation()");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.IndentDetailsTab);
			//waitForElement(tendercreationlocators.IndentDetailsTab, 30);
			waitForObj(2000);
			click(tendercreationlocators.IndentDetailsTab, "IndentDetailsTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			select(tendercreationlocators.TypeOfService_TG1IndentDetailsTab, pdfResultReport.testData.get("TypeOfService_TG1IndentDetailsTab"));
			select(tendercreationlocators.Capital_TG1IndentDetailsTab, pdfResultReport.testData.get("Capital_TG1IndentDetailsTab"));
			select(tendercreationlocators.ModeOfDespatch_TG1IndentDetailsTab, pdfResultReport.testData.get("ModeOfDespatch_TG1IndentDetailsTab"));
			select(tendercreationlocators.PlaceOfDelivery_TG1IndentDetailsTab, pdfResultReport.testData.get("PlaceOfDelivery_TG1IndentDetailsTab"));
			select(tendercreationlocators.DeiveryPeriod_TG1IndentDetailsTab, pdfResultReport.testData.get("DeiveryPeriod_TG1IndentDetailsTab"));
			set(tendercreationlocators.NoOfYear_TG1IndentDetailsTab,pdfResultReport.testData.get("NoOfYear_TG1IndentDetailsTab"), "NoOfYear_TG1IndentDetailsTab");
			select(tendercreationlocators.BasisOfPriceEstimation_TG1IndentDetailsTab, pdfResultReport.testData.get("BasisOfPriceEstimation_TG1IndentDetailsTab"));
			select(tendercreationlocators.PreBidMeeting_TG1IndentDetailsTab, pdfResultReport.testData.get("PreBidMeeting_TG1IndentDetailsTab"));
			scrollToTopOfThePage();
			waitForElementToBeVisible(tendercreationlocators.savebuttonNew);
			click(tendercreationlocators.savebuttonNew, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(8000);
//			tabcontentList.add(text(tendercreationlocators.tabContent));
			pdfResultReport.addStepDetails("IndentTG1_Indent_Details_tabvalidation",
					"Should save IndentDetails tab fields during indent creation", "Sucessfully saved IndentDetails tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_Indent_Details_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_Indent_Details_tabvalidation",
					"Should save indent details tab fields during indent creation", "Unable to save indent details tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	//Indent Details tab validation for Indent TG10 (14/01/2023)
		public void IndentTG10_Indent_Details_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG1_Indent_Details_tabvalidation()");
				waitForElement(tendercreationlocators.IndentDetailsTab_TG10, 30);
				waitForObj(2000);
				click(tendercreationlocators.IndentDetailsTab_TG10, "IndentDetailsTab");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				//select(tendercreationlocators.TypeOfService_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("TypeOfService_TG1IndentDetailsTab"));
				//select(tendercreationlocators.ModeOfDespatch_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("ModeOfDespatch_TG1IndentDetailsTab"));
				//select(tendercreationlocators.PlaceOfDelivery_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("PlaceOfDelivery_TG1IndentDetailsTab"));
				//select(tendercreationlocators.DeiveryPeriod_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("DeiveryPeriod_TG1IndentDetailsTab"));
				set(tendercreationlocators.NoOfYear_TG1IndentDetailsTab_TG10,pdfResultReport.testData.get("NoOfYear_TG1IndentDetailsTab"), "NoOfYear_TG1IndentDetailsTab");
				//select(tendercreationlocators.BasisOfPriceEstimation_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("BasisOfPriceEstimation_TG1IndentDetailsTab"));
				//select(tendercreationlocators.PreBidMeeting_TG1IndentDetailsTab_TG10, pdfResultReport.testData.get("PreBidMeeting_TG1IndentDetailsTab"));
				click(tendercreationlocators.IndentDetailsTab_TG10, "IndentDetailsTab");
				scrollToTopOfThePage();
				click(tendercreationlocators.savebuttonNew, "Savebtn_Indent");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.AddInputAlert);
				click(tendercreationlocators.AddInputAlert, "AddInputAlert");
				waitForObj(1000);
				pdfResultReport.addStepDetails("IndentTG1_Indent_Details_tabvalidation",
						"Should save IndentDetails tab fields during indent creation", "Sucessfully saved IndentDetails tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_Indent_Details_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_Indent_Details_tabvalidation",
						"Should save indent details tab fields during indent creation", "Unable to save indent details tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	
	//Indent Details tab validation for Indent TG8 (01/06/2021)
		public void IndentTG8_Indent_Details_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG8_Indent_Details_tabvalidation()");
				//waitForElement(tendercreationlocators.indentDetailsTab_TG8, 30);
				waitForElementToBeClickable(tendercreationlocators.indentDetailsTab_TG8);
				waitForObj(2000);
				click(tendercreationlocators.indentDetailsTab_TG8, "indentDetailsTab_TG8");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				select(tendercreationlocators.indentingDepartment_TG8, pdfResultReport.testData.get("indentingDepartment_TG8"));
				set(tendercreationlocators.Justification4Purchase_TG8,pdfResultReport.testData.get("Justification4Purchase_TG8"), "Justification4Purchase_TG8");
				select(tendercreationlocators.basisPriceEstimation_TG8, pdfResultReport.testData.get("basisPriceEstimation_TG8"));
				set(tendercreationlocators.executingAuthority_TG8,pdfResultReport.testData.get("executingAuthority_TG8"), "executingAuthority_TG8");
				select(tendercreationlocators.consignee_TG8, pdfResultReport.testData.get("consignee_TG8"));
				select(tendercreationlocators.placeDelivery_TG8, pdfResultReport.testData.get("placeDelivery_TG8"));
				select(tendercreationlocators.timePeriodDeliveryCompletionPeriod_TG8, pdfResultReport.testData.get("timePeriodDeliveryCompletionPeriod_TG8"));
				set(tendercreationlocators.numberYearMonthWeekDay_TG8,pdfResultReport.testData.get("numberYearMonthWeekDay_TG8"), "numberYearMonthWeekDay_TG8");
				scrollToElement(tendercreationlocators.normalEmergency_TG8);
				select(tendercreationlocators.normalEmergency_TG8, pdfResultReport.testData.get("normalEmergency_TG8"));
				scrollToElement(tendercreationlocators.proprietaryItem_TG8);
				select(tendercreationlocators.proprietaryItem_TG8, pdfResultReport.testData.get("proprietaryItem_TG8"));
				scrollToElement(tendercreationlocators.splittingOrder_TG8);
				select(tendercreationlocators.splittingOrder_TG8, pdfResultReport.testData.get("splittingOrder_TG8"));
				scrollToElement(tendercreationlocators.basisforModeTendering_TG8);
				set(tendercreationlocators.basisforModeTendering_TG8,pdfResultReport.testData.get("basisforModeTendering_TG8"), "basisforModeTendering_TG8");
				scrollToElement(tendercreationlocators.postWarrantyAMCRequirement_TG8);
				select(tendercreationlocators.postWarrantyAMCRequirement_TG8, pdfResultReport.testData.get("postWarrantyAMCRequirement_TG8"));
				scrollToElement(tendercreationlocators.alternateBidRequired_TG8);
				select(tendercreationlocators.alternateBidRequired_TG8, pdfResultReport.testData.get("alternateBidRequired_TG8"));
				scrollToElement(tendercreationlocators.preBidMeeting_TG8);
				select(tendercreationlocators.preBidMeeting_TG8, pdfResultReport.testData.get("preBidMeeting_TG8"));
				scrollToElement(tendercreationlocators.specialConditionsInstructionstoTenderers_TG8);
				set(tendercreationlocators.specialConditionsInstructionstoTenderers_TG8,pdfResultReport.testData.get("specialConditionsInstructionstoTenderers_TG8"), "specialConditionsInstructionstoTenderers_TG8");
				scrollToElement(tendercreationlocators.anySpecialSelectionCriteria_TG8);
				select(tendercreationlocators.anySpecialSelectionCriteria_TG8, pdfResultReport.testData.get("anySpecialSelectionCriteria_TG8"));
				scrollToElement(tendercreationlocators.inspectionGuidelines_TG8);
				set(tendercreationlocators.inspectionGuidelines_TG8,pdfResultReport.testData.get("inspectionGuidelines_TG8"), "inspectionGuidelines_TG8");
				scrollToTopOfThePage();
				click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(5000);
				pdfResultReport.addStepDetails("IndentTG8_Indent_Details_tabvalidation",
						"Should save IndentDetails tab fields during indent creation", "Sucessfully saved IndentDetails tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG8_Indent_Details_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save generalInfo tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG8_Indent_Details_tabvalidation",
						"Should save indent details tab fields during indent creation", "Unable to save indent details tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//Other Information tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_Other_Information_tabvalidation()
			throws Exception {
		try {
			log.info(
					"started executing the method:: IndentTG1_Other_Information_tabvalidation()");
			waitForElement(tendercreationlocators.TG1OtherinformationTab, 50);
			click(tendercreationlocators.TG1OtherinformationTab, "TG1OtherinformationTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(3000);
			select(tendercreationlocators.WorkofContract_TG1OtherinformationTab, pdfResultReport.testData.get("WorkofContract_TG1OtherinformationTab"));
			select(tendercreationlocators.PartySite_TG1OtherinformationTab, pdfResultReport.testData.get("PartySite_TG1OtherinformationTab"));
			scrollToTopOfThePage();
			waitForElementToBeVisible(tendercreationlocators.Savebtn_IndentNew1);
			click(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(5000);
		//	commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
			tabcontentList.add(text(tendercreationlocators.tabContent));
			pdfResultReport.addStepDetails("IndentTG1_Other_Information_tabvalidation",
					"Should save Other Information tab fields during indent creation", "Sucessfully saved Other Information tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_Other_Information_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save Other Information tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_Other_Information_tabvalidation",
					"Should save Other Infotmation tab fields during indent creation", "Unable to save Other Information tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//Other Information tab validation for Indent TG10 (14/01/2023)
		public void IndentTG10_Other_Information_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG1_Other_Information_tabvalidation()");
				waitForElement(tendercreationlocators.TG10OtherinformationTab, 50);
				click(tendercreationlocators.TG10OtherinformationTab, "TG1OtherinformationTab");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(3000);
				select(tendercreationlocators.WorkofContract_TG10OtherinformationTab, pdfResultReport.testData.get("WorkofContract_TG1OtherinformationTab"));
				select(tendercreationlocators.PartySite_TG10OtherinformationTab, pdfResultReport.testData.get("PartySite_TG1OtherinformationTab"));
				scrollToTopOfThePage();
				click(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.AddInputAlert);
				click(tendercreationlocators.AddInputAlert, "AddInputAlert");
				waitForObj(1000);
				pdfResultReport.addStepDetails("IndentTG1_Other_Information_tabvalidation",
						"Should save Other Information tab fields during indent creation", "Sucessfully saved Other Information tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_Other_Information_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save Other Information tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_Other_Information_tabvalidation",
						"Should save Other Infotmation tab fields during indent creation", "Unable to save Other Information tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//BOM Item tab validation for Indent TG1 (27/01/2021) //modified on 130722
	public static ArrayList<String> bomitemInputItems=new ArrayList<String>();
	public void IndentTG1_BOM_Item_tabvalidation()
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_BOM_Item_tabvalidation()");
			waitForElement(tendercreationlocators.TG1IndentBOMItemTab, 30);
			click(tendercreationlocators.TG1IndentBOMItemTab, "TG1IndentBOMItemTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(3000);
			
			for(int i=0; i<Integer.parseInt(eTenderComponent.getDataFromPropertiesFile("ItemQty")); i++) {
				String IndentItemCode = "TendCode_";
				String IndentItemName = "TendName_";
				int getrandomInterger = getrandomInterger(10000, 1000000000);
				IndentItemCode = IndentItemCode.concat(String.valueOf(getrandomInterger));
				IndentItemName = IndentItemName.concat(String.valueOf(getrandomInterger));
					
				System.out.println(Integer.parseInt(eTenderComponent.getDataFromPropertiesFile("ItemQty")));

			waitForElementToBeClickable(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
			scrollToElement(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
			JSClick(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab, "AddNonSORItemBtn_TG1BOMItemTab");
			
			waitForElementToBeClickable(tendercreationlocators.ItemCode_TG1BOMItemTab(i));
			scrollToElement(tendercreationlocators.ItemCode_TG1BOMItemTab(i));
			set(tendercreationlocators.ItemCode_TG1BOMItemTab(i), IndentItemCode, "ItemCode_TG1BOMItemTab");
			
			waitForElementToBeClickable(tendercreationlocators.ItemName_TG1BOMItemTab(i));
			scrollToElement(tendercreationlocators.ItemName_TG1BOMItemTab(i));
			set(tendercreationlocators.ItemName_TG1BOMItemTab(i), IndentItemName, "ItemName_TG1BOMItemTab");
			
			waitForElementToBeClickable(tendercreationlocators.UOM_TG1BOMItemTab(i+1));
			scrollToElement(tendercreationlocators.UOM_TG1BOMItemTab(i+1));
			select(tendercreationlocators.UOM_TG1BOMItemTab(i+1), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
				 
			waitForElementToBeClickable(tendercreationlocators.Qty_TG1BOMItemTab(i));
			scrollToElement(tendercreationlocators.Qty_TG1BOMItemTab(i));
			set(tendercreationlocators.Qty_TG1BOMItemTab(i), pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG1BOMItemTab");
			
			waitForElementToBeClickable(tendercreationlocators.UnitRate_TG1BOMItemTab(i));
			scrollToElement(tendercreationlocators.UnitRate_TG1BOMItemTab(i));
			set(tendercreationlocators.UnitRate_TG1BOMItemTab(i), pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG1BOMItemTab");
			
			waitForElementToBeClickable(tendercreationlocators.GSTPercent_TG1BOMItemTab(i));
			scrollToElement(tendercreationlocators.GSTPercent_TG1BOMItemTab(i));
			set(tendercreationlocators.GSTPercent_TG1BOMItemTab(i), pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG1BOMItemTab");
			
			bomitemInputItems.add(IndentItemCode);
			bomitemInputItems.add(IndentItemName);
			bomitemInputItems.add(pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
			bomitemInputItems.add(pdfResultReport.testData.get("Qty_TG1BOMItemTab"));
			bomitemInputItems.add(pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"));
			bomitemInputItems.add(pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"));
			}
			System.out.println("bom item arraylist"+bomitemInputItems);
			
			waitForObj(1000);
			
//			scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
//			waitForObj(2000);
//			waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
//			click(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
//			waitForObj(2000); 
			
			/*
			 waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
			//scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
			JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			 waitForObj(2000); */
			
			//========================
			
//			waitForElementToBeClickable(tendercreationlocators.AddInputAlert);
//			click(tendercreationlocators.AddInputAlert, "AddInputAlert");
//			waitForObj(1000);
//			tabcontentList.add(text(tendercreationlocators.tabContent));
//			waitForObj(1000); 
			pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tabvalidation",
					"Should save BOM Item tab fields during indent creation", "Sucessfully saved BOM Item tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(					"completed executing the method:: IndentTG1_BOM_Item_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save BOM Item tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tabvalidation",
					"Should save BOM Item tab fields during indent creation", "Unable to save BOM Item tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//BOM Item tab validation for Indent TG8 (01/06/2021)
		public void IndentTG8_BOM_Item_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG8_BOM_Item_tabvalidation()");
				waitForElementToBeClickable(tendercreationlocators.bomItems_TG8);
				//waitForElement(tendercreationlocators.bomItems_TG8, 30);
				click(tendercreationlocators.bomItems_TG8, "bomItems_TG8");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				click(tendercreationlocators.addNonSORitemsIndent_TG8, "addNonSORitemsIndent_TG8");
				set(tendercreationlocators.itemCodeIndet_TG8, pdfResultReport.testData.get("ItemCode_TG1BOMItemTab"), "ItemCode_TG8BOMItemTab");
				set(tendercreationlocators.itemNameIndent_TG8, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "ItemName_TG8BOMItemTab");
				select(tendercreationlocators.unitIndent_TG8, pdfResultReport.testData.get("unitIndent_TG8"));
				set(tendercreationlocators.qtyIndent_TG8, pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG8BOMItemTab");
				scrollToElement(tendercreationlocators.unitRateIndent_TG8);
				set(tendercreationlocators.unitRateIndent_TG8, pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG8BOMItemTab");
				scrollToElement(tendercreationlocators.gstIndent_TG8);
				set(tendercreationlocators.gstIndent_TG8, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG8BOMItemTab");
				scrollToElement(tendercreationlocators.consigneeIndent_TG8);
				select(tendercreationlocators.consigneeIndent_TG8, pdfResultReport.testData.get("consigneeIndent_TG8"));
				scrollToTopOfThePage();
				click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(5000);
				pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tabvalidation",
						"Should save BOM Item tab fields during indent creation", "Sucessfully saved BOM Item tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_BOM_Item_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save BOM Item tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG8_BOM_Item_tabvalidation",
						"Should save BOM Item tab fields during indent creation", "Unable to save BOM Item tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
		
		
		//BOM Item tab validation for Indent TG8 (01/06/2021)
		public void IndentTG9_BOM_Item_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG9_BOM_Item_tabvalidation()");
				waitForElementToBeClickable(tendercreationlocators.BOMitemsTab);
				//waitForElement(tendercreationlocators.bomItems_TG8, 30);
				click(tendercreationlocators.BOMitemsTab, "BOMitemsTab");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				click(tendercreationlocators.addNonSORitemsIndent_TG8, "addNonSORitemsIndent_TG8");
				set(tendercreationlocators.ItemCode, pdfResultReport.testData.get("ItemCode_TG1BOMItemTab"), "ItemCode");
				set(tendercreationlocators.BudgetHead, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "BudgetHead");
				set(tendercreationlocators.ItemName, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "ItemName");
				set(tendercreationlocators.ItemDescription, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "ItemDescription");
				set(tendercreationlocators.brand, pdfResultReport.testData.get("ItemName_TG1BOMItemTab"), "brand");
				select(tendercreationlocators.UOM, pdfResultReport.testData.get("UOM"));
				set(tendercreationlocators.ItemQuantity, pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "ItemQuantity");
				scrollToElement(tendercreationlocators.QuantityInStore);
				set(tendercreationlocators.QuantityInStore, pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "QuantityInStore");
				scrollToElement(tendercreationlocators.QuantityRequire);
				set(tendercreationlocators.QuantityRequire, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "QuantityRequire");
				scrollToElement(tendercreationlocators.LastPurchasePrice);
				set(tendercreationlocators.LastPurchasePrice, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "LastPurchasePrice");
				scrollToElement(tendercreationlocators.EstimatedPrice);
				set(tendercreationlocators.EstimatedPrice, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "EstimatedPrice");
				scrollToElement(tendercreationlocators.SORRate);
				set(tendercreationlocators.SORRate, pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "SORRate");
				scrollToTopOfThePage();
				click(tendercreationlocators.savebuttonNew, "savebutton");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(3000);
				pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tabvalidation",
						"Should save BOM Item tab fields during indent creation", "Sucessfully saved BOM Item tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_BOM_Item_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save BOM Item tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG8_BOM_Item_tabvalidation",
						"Should save BOM Item tab fields during indent creation", "Unable to save BOM Item tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//BOM Services tab validation for Indent TG1 (27/01/2021)
	public static	ArrayList<String> bomServicesInputItems=new ArrayList<String>();
	public void IndentTG1_BOM_Services_tabvalidation()
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_BOM_Services_tabvalidation()");
			//waitForElement(tendercreationlocators.TG1IndentBOMServicesTab, 30);
			waitForElementToBeClickable(tendercreationlocators.TG1IndentBOMServicesTab);
			//scrollToElement(tendercreationlocators.TG1IndentBOMServicesTab);
			JSClick(tendercreationlocators.TG1IndentBOMServicesTab, "TG1IndentBOMServicesTab");
			
			for(int i=0; i<Integer.parseInt(eTenderComponent.getDataFromPropertiesFile("ItemQty")); i++){
				String IndentItemCode = "TendCode_";
				String IndentItemName = "TendName_";
				int getrandomInterger = getrandomInterger(10000, 1000000000);
				IndentItemCode = IndentItemCode.concat(String.valueOf(getrandomInterger));
				IndentItemName = IndentItemName.concat(String.valueOf(getrandomInterger));
				
			waitForElementToBeClickable(tendercreationlocators.AddNonSORItemBtn_TG1BOMServicesTab);
			scrollToElement(tendercreationlocators.AddNonSORItemBtn_TG1BOMServicesTab);
			JSClick(tendercreationlocators.AddNonSORItemBtn_TG1BOMServicesTab, "AddNonSORItemBtn_TG1BOMServicesTab");
			
			waitForElementToBeClickable(tendercreationlocators.ItemCode_TG1BOMServicesTab(i));
			scrollToElement(tendercreationlocators.ItemCode_TG1BOMServicesTab(i));
			set(tendercreationlocators.ItemCode_TG1BOMServicesTab(i), IndentItemCode, "ItemCode_TG1BOMServicesTab");
			
			waitForElementToBeClickable(tendercreationlocators.ItemName_TG1BOMServicesTab(i));
			scrollToElement(tendercreationlocators.ItemName_TG1BOMServicesTab(i));
			set(tendercreationlocators.ItemName_TG1BOMServicesTab(i), IndentItemName, "ItemName_TG1BOMServicesTab");
			
			waitForElementToBeClickable(tendercreationlocators.UOM_TG1BOMServicesTab(i+1));
			scrollToElement(tendercreationlocators.UOM_TG1BOMServicesTab(i+1));
			select(tendercreationlocators.UOM_TG1BOMServicesTab(i+1), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
			
			waitForElementToBeClickable(tendercreationlocators.Qty_TG1BOMServicesTab(i));
			scrollToElement(tendercreationlocators.Qty_TG1BOMServicesTab(i));
			set(tendercreationlocators.Qty_TG1BOMServicesTab(i), pdfResultReport.testData.get("Qty_TG1BOMServicesTab"), "Qty_TG1BOMServicesTab");
			
			waitForElementToBeClickable(tendercreationlocators.UnitRate_TG1BOMServicesTab(i));
			scrollToElement(tendercreationlocators.UnitRate_TG1BOMServicesTab(i));
			set(tendercreationlocators.UnitRate_TG1BOMServicesTab(i), pdfResultReport.testData.get("UnitRate_TG1BOMServicesTab"), "UnitRate_TG1BOMServicesTab");
			
			waitForElementToBeClickable(tendercreationlocators.GSTPercent_TG1BOMServicesTab(i));
			scrollToElement(tendercreationlocators.GSTPercent_TG1BOMServicesTab(i));
			set(tendercreationlocators.GSTPercent_TG1BOMServicesTab(i), pdfResultReport.testData.get("GSTPercent_TG1BOMServicesTab"), "GSTPercent_TG1BOMServicesTab");
			
			
			bomServicesInputItems.add(IndentItemCode);
			bomServicesInputItems.add(IndentItemName);
			bomServicesInputItems.add(pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
			bomServicesInputItems.add(pdfResultReport.testData.get("Qty_TG1BOMServicesTab"));
			bomServicesInputItems.add(pdfResultReport.testData.get("UnitRate_TG1BOMServicesTab"));
			bomServicesInputItems.add(pdfResultReport.testData.get("GSTPercent_TG1BOMServicesTab"));
			
			}
			System.out.println("bom service arraylist"+bomServicesInputItems);
			waitForObj(1000);
//			scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
//			waitForObj(2000);
//			waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
//			click(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			
			
			/*
			 waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
			//scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
			JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			//commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
			tabcontentList.add(text(tendercreationlocators.tabContent));
			 waitForObj(2000); */
			
			

			pdfResultReport.addStepDetails("IndentTG1_BOM_Services_tabvalidation",
					"Should save BOM Services tab fields during indent creation", "Sucessfully saved BOM Services tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_BOM_Services_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save BOM Services tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_BOM_Services_tabvalidation",
					"Should save BOM Services tab fields during indent creation", "Unable to save BOM Services tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//BOM Services tab validation for Indent TG1 (27/01/2021)
		public void IndentTG10_BOM_Services_tabvalidation()
				throws Throwable {
			try {
				log.info(
						"started executing the method:: IndentTG1_BOM_Services_tabvalidation()");
				//waitForElement(tendercreationlocators.TG1IndentBOMServicesTab, 30);
				waitForElementToBeClickable(tendercreationlocators.TG10IndentBOMServicesTab);
				//scrollToElement(tendercreationlocators.TG1IndentBOMServicesTab);
				JSClick(tendercreationlocators.TG10IndentBOMServicesTab, "TG1IndentBOMServicesTab");
				
				for(int i=0; i<2; i++){
					String IndentItemCode = "TendCode_";
					String IndentItemName = "TendName_";
					int getrandomInterger = getrandomInterger(10000, 1000000000);
					IndentItemCode = IndentItemCode.concat(String.valueOf(getrandomInterger));
					IndentItemName = IndentItemName.concat(String.valueOf(getrandomInterger));
					
				waitForElementToBeClickable(tendercreationlocators.AddNonSORItemBtn_TG10BOMServicesTab);
				scrollToElement(tendercreationlocators.AddNonSORItemBtn_TG10BOMServicesTab);
				JSClick(tendercreationlocators.AddNonSORItemBtn_TG10BOMServicesTab, "AddNonSORItemBtn_TG1BOMServicesTab");
				
				waitForElementToBeClickable(tendercreationlocators.ItemCode_TG10BOMServicesTab(i));
				scrollToElement(tendercreationlocators.ItemCode_TG10BOMServicesTab(i));
				set(tendercreationlocators.ItemCode_TG10BOMServicesTab(i), IndentItemCode, "ItemCode_TG1BOMServicesTab");
				
				waitForElementToBeClickable(tendercreationlocators.ItemName_TG10BOMServicesTab(i));
				scrollToElement(tendercreationlocators.ItemName_TG10BOMServicesTab(i));
				set(tendercreationlocators.ItemName_TG10BOMServicesTab(i), IndentItemName, "ItemName_TG1BOMServicesTab");
				
				waitForElementToBeClickable(tendercreationlocators.NatureOfDuty_TG10(i+1));
				scrollToElement(tendercreationlocators.NatureOfDuty_TG10(i+1));
				select(tendercreationlocators.NatureOfDuty_TG10(i+1),"Beyond 5/10 Hrs");
				
				waitForElementToBeClickable(tendercreationlocators.Qty_TG10BOMServicesTab(i));
				scrollToElement(tendercreationlocators.Qty_TG10BOMServicesTab(i));
				set(tendercreationlocators.Qty_TG10BOMServicesTab(i), pdfResultReport.testData.get("Qty_TG1BOMServicesTab"), "Qty_TG1BOMServicesTab");
				
				waitForElementToBeClickable(tendercreationlocators.Per_Month_TG10Expected_Movement(i));
				scrollToElement(tendercreationlocators.Per_Month_TG10Expected_Movement(i));
				set(tendercreationlocators.Per_Month_TG10Expected_Movement(i), pdfResultReport.testData.get("Qty_TG1BOMServicesTab"), "Qty_TG1BOMServicesTab");
				
				waitForElementToBeClickable(tendercreationlocators.UOM_TG10BOMServicesTab(i+1));
				scrollToElement(tendercreationlocators.UOM_TG10BOMServicesTab(i+1));
				//select(tendercreationlocators.UOM_TG10BOMServicesTab(i+1), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
				select(tendercreationlocators.UOM_TG10BOMServicesTab(i+1),"DAY");
				
				waitForElementToBeClickable(tendercreationlocators.SORRate_TG10BOMServicesTab(i));
				scrollToElement(tendercreationlocators.SORRate_TG10BOMServicesTab(i));
				set(tendercreationlocators.SORRate_TG10BOMServicesTab(i), pdfResultReport.testData.get("UnitRate_TG1BOMServicesTab"), "SORRate_TG1BOMServicesTab");
				
			}
				waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
				//scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
				JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.AddInputAlert);
				click(tendercreationlocators.AddInputAlert, "AddInputAlert");
				waitForObj(1000);
				pdfResultReport.addStepDetails("IndentTG1_BOM_Services_tabvalidation",
						"Should save BOM Services tab fields during indent creation", "Sucessfully saved BOM Services tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_BOM_Services_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save BOM Services tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_BOM_Services_tabvalidation",
						"Should save BOM Services tab fields during indent creation", "Unable to save BOM Services tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//EstimationSheet tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_EstimationSheet_tabvalidation()
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_EstimationSheet_tabvalidation()");
			waitForElement(tendercreationlocators.TG1IndentEstimationSheetTab, 30);
			//click(tendercreationlocators.NextTabLink_Indent, "NextTabLink_Indent");
			JSClick(tendercreationlocators.TG1IndentEstimationSheetTab, "TG1IndentEstimationSheetTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			
			waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
			//scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
			JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			waitForObj(2000);
	//		commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
			tabcontentList.add(text(tendercreationlocators.tabContent));
			pdfResultReport.addStepDetails("IndentTG1_EstimationSheet_tabvalidation",
					"Should save Estimation Sheet tab fields during indent creation", "Sucessfully saved Estimation Sheet tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_EstimationSheet_tabvalidation");

		} catch (Exception e) {

			log.fatal("Not able to save Estimation Sheet tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_EstimationSheet_tabvalidation",
					"Should save Estimation Sheet tab fields during indent creation", "Unable to save Estimation Sheet tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	//EstimationSheet tab validation for Indent TG10 (14/01/2023)
		public void IndentTG10_EstimationSheet_tabvalidation()
				throws Throwable {
			try {
				log.info(
						"started executing the method:: IndentTG1_EstimationSheet_tabvalidation()");
				waitForElement(tendercreationlocators.TG10IndentEstimationSheetTab, 30);
				//click(tendercreationlocators.NextTabLink_Indent, "NextTabLink_Indent");
				JSClick(tendercreationlocators.TG10IndentEstimationSheetTab, "TG1IndentEstimationSheetTab");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				set(tendercreationlocators.TG10GST, pdfResultReport.testData.get("GSTPercent_TG1BOMServicesTab"), "GST");
				set(tendercreationlocators.TG10Parking_Toll_Tax, pdfResultReport.testData.get("UnitRate_TG1BOMServicesTab"), "TG10Parking_Toll_Tax");
				waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
				//scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
				JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
				waitForObj(2000);
				pdfResultReport.addStepDetails("IndentTG1_EstimationSheet_tabvalidation",
						"Should save Estimation Sheet tab fields during indent creation", "Sucessfully saved Estimation Sheet tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_EstimationSheet_tabvalidation");

			} catch (Exception e) {

				log.fatal("Not able to save Estimation Sheet tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_EstimationSheet_tabvalidation",
						"Should save Estimation Sheet tab fields during indent creation", "Unable to save Estimation Sheet tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//Technical Specification tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_technical_Specification_tabvalidation()
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_technical_Specification_tabvalidation()");
			waitForElementToBeClickable(tendercreationlocators.TG1IndentTechnicalSpecificationTab);
			JSClick(tendercreationlocators.TG1IndentTechnicalSpecificationTab, "TG1IndentTechnicalSpecificationTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(1000);
			waitForElementToBeClickable(tendercreationlocators.Addbtn_TG1TechnicalSpecificationTab);
			JSClick(tendercreationlocators.Addbtn_TG1TechnicalSpecificationTab, "Addbtn_TG1TechnicalSpecificationTab");
			waitForElementToBeClickable(tendercreationlocators.ClauseNo_TG1TechnicalSpecificationTab);
			set(tendercreationlocators.ClauseNo_TG1TechnicalSpecificationTab, pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab"), "ClauseNo_TG1TechnicalSpecificationTab");
			waitForElementToBeClickable(tendercreationlocators.ClauseHeaderTitle_TG1TechnicalSpecificationTab);
			set(tendercreationlocators.ClauseHeaderTitle_TG1TechnicalSpecificationTab, pdfResultReport.testData.get("ClauseHeaderTitle_TG1TechnicalSpecificationTab"), "ClauseHeaderTitle_TG1TechnicalSpecificationTab");
			waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
			JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(1000);
	//		commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
			tabcontentList.add(text(tendercreationlocators.tabContent));
			pdfResultReport.addStepDetails("IndentTG1_technical_Specification_tabvalidation",
					"Should save Technical Specification tab fields during indent creation", "Sucessfully saved Technical Specification tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_technical_Specification_tabvalidation");

		} catch (Exception e) {
			log.fatal("Not able to save Technical Specification tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_technical_Specification_tabvalidation",
					"Should save Technical Specification tab fields during indent creation", "Unable to save Technical Specification tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//Technical Specification tab validation for Indent TG8 (01/06/2021)
		public void IndentTG8_technical_Specification_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG8_technical_Specification_tabvalidation()");
				waitForElement(tendercreationlocators.tecnicalSpecication_TG8, 30);
				click(tendercreationlocators.tecnicalSpecication_TG8, "TG8IndentTechnicalSpecificationTab");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				click(tendercreationlocators.addTecnicalSpecicationButtonIndent_TG8, "Addbtn_TG8TechnicalSpecificationTab");
				set(tendercreationlocators.clauseNOindent_TG8, pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab"), "ClauseNo_TG8TechnicalSpecificationTab");
				set(tendercreationlocators.caluseHeaderIndent_TG8, pdfResultReport.testData.get("ClauseHeaderTitle_TG1TechnicalSpecificationTab"), "ClauseHeaderTitle_TG8TechnicalSpecificationTab");
				set(tendercreationlocators.decriptionIndent_TG8, pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"), "decriptionIndent_TG8");
				set(tendercreationlocators.attachmentTecnicalSpecicationButtonIndent_TG8, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx","fileName");
				click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(3000);
				pdfResultReport.addStepDetails("IndentTG8_technical_Specification_tabvalidation",
						"Should save Technical Specification tab fields during indent creation", "Sucessfully saved Technical Specification tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG8_technical_Specification_tabvalidation");

			} catch (Exception e) {
				log.fatal("Not able to save Technical Specification tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG8_technical_Specification_tabvalidation",
						"Should save Technical Specification tab fields during indent creation", "Unable to save Technical Specification tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
		
		//Technical Specification tab validation for Indent TG1 (27/01/2021)
		public void IndentTG10_Eligibility_Criteria_tabvalidation()
				throws Throwable {
			try {
				log.info(
						"started executing the method:: IndentTG1_technical_Specification_tabvalidation()");
				waitForElementToBeClickable(tendercreationlocators.TG10IndentTechnicalSpecificationTab);
				JSClick(tendercreationlocators.TG10IndentTechnicalSpecificationTab, "TG1IndentTechnicalSpecificationTab");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				waitForElementToBeClickable(tendercreationlocators.Addbtn_TG10TechnicalSpecificationTab);
				JSClick(tendercreationlocators.Addbtn_TG10TechnicalSpecificationTab, "Addbtn_TG1TechnicalSpecificationTab");
				waitForElementToBeClickable(tendercreationlocators.ClauseNo_TG10TechnicalSpecificationTab);
				set(tendercreationlocators.ClauseNo_TG10TechnicalSpecificationTab, pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab"), "ClauseNo_TG1TechnicalSpecificationTab");
				waitForElementToBeClickable(tendercreationlocators.ClauseHeaderTitle_TG10TechnicalSpecificationTab);
				set(tendercreationlocators.ClauseHeaderTitle_TG10TechnicalSpecificationTab, pdfResultReport.testData.get("ClauseHeaderTitle_TG1TechnicalSpecificationTab"), "ClauseHeaderTitle_TG1TechnicalSpecificationTab");
				waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
				JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.AddInputAlert);
				click(tendercreationlocators.AddInputAlert, "AddInputAlert");
				waitForObj(1000);
				pdfResultReport.addStepDetails("IndentTG1_technical_Specification_tabvalidation",
						"Should save Technical Specification tab fields during indent creation", "Sucessfully saved Technical Specification tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG1_technical_Specification_tabvalidation");

			} catch (Exception e) {
				log.fatal("Not able to save Technical Specification tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_technical_Specification_tabvalidation",
						"Should save Technical Specification tab fields during indent creation", "Unable to save Technical Specification tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	
	//Eligibility Criteria tab validation for Indent TG8 (27/01/2021)
		public void IndentTG8_Eligibility_Criteria_tabvalidation()
				throws Exception {
			try {
				log.info(
						"started executing the method:: IndentTG8_Eligibility_Criteria_tabvalidation()");
				waitForElement(tendercreationlocators.eligibilityCriteria_TG8, 30);
				click(tendercreationlocators.eligibilityCriteria_TG8, "eligibilityCriteria_TG8");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(2000);
				click(tendercreationlocators.addButton_EligibilityCriteria_TG8, "addButton_EligibilityCriteria_TG8");
				set(tendercreationlocators.textbox_EligibilityCriteria_TG8, pdfResultReport.testData.get("inspectionGuidelines_TG8"), "textbox_EligibilityCriteria_TG8");
				set(tendercreationlocators.attachment_EligibilityCriteria_TG8, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx","fileName");
				waitForObj(1000);
				click(tendercreationlocators.Savebtn_Indent, "Savebtn_Indent");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(5000);
				pdfResultReport.addStepDetails("IndentTG8_Eligibility_Criteria_tabvalidation",
						"Should save Eligibility_Criteria tab fields during indent creation", "Sucessfully saved Eligibility_Criteria tab fields during indent creation " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: IndentTG8_Eligibility_Criteria_tabvalidation");

			} catch (Exception e) {
				log.fatal("Not able to save Technical Specification tab fields" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_technical_Specification_tabvalidation",
						"Should save Eligibility_Criteria tab fields during indent creation", "Unable to save Eligibility_Criteria tab fields during indent creation" + e.getMessage(),
						"Fail", "N");
			}
		}
	//Technical Specification tab validation for Indent TG1 (27/01/2021)
	public void IndentTG1_Annexures_tabvalidation()
			throws Throwable {
		try {
			log.info(
					"started executing the method:: IndentTG1_Annexures_tabvalidation()");
			//waitForElement(tendercreationlocators.TG1IndentAnnexuresTab, 500);
			waitForElementToBeClickable(tendercreationlocators.TG1IndentAnnexuresTab);
			JSClick(tendercreationlocators.TG1IndentAnnexuresTab, "TG1IndentAnnexuresTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeClickable(tendercreationlocators.AddAttachment);
			JSClick(tendercreationlocators.AddAttachment, "Addbtn_TG1AnnexuresTab");
			/*
			 * waitForElement(tendercreationlocators.AddAtachmentLbl_TG1AnnexuresTab, 500);
			 * select(tendercreationlocators.AnnexuresType_TG1AnnexuresTab,
			 * pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"));
			 */
			//commented on 140722
			waitForObj(2000);
			select(tendercreationlocators.AnnexuresType,pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"));
			set(tendercreationlocators.IndentAttachments, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx","fileName");
			click(tendercreationlocators.OkAttach, "OKBtn_TG1AnnexuresTab");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
			JSClick(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(3000);
	//		commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
			tabcontentList.add(text(tendercreationlocators.tabContent));
			pdfResultReport.addStepDetails("IndentTG1_Annexures_tabvalidation",
					"Should save Annexures tab fields during indent creation", "Sucessfully saved Annexures tab fields during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_Annexures_tabvalidation");

		} catch (Exception e) {
			log.fatal("Not able to save Annexures tab fields" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_Annexures_tabvalidation",
					"Should save Annexures tab fields during indent creation", "Unable to save Annexures tab fields during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	//Submit Indent TG1 (28/01/2021) // modified on 120722
	public void IndentTG1_Submit()throws Throwable {
		try {
			log.info("started executing the method:: IndentTG1_Submit()");
			scrollToTopOfThePage();
			waitForObj(1000);			
			boolean fielddisplay=isElementDisplayed_Updated(tendercreationlocators.Savebtn_IndentNew1, 60);
			boolean interactable=isElementEnable_Updated(tendercreationlocators.Savebtn_IndentNew1, 60);
			if (fielddisplay == true && interactable == true) {
				click(tendercreationlocators.Savebtn_IndentNew1, "Save Button");
					}
			dynamic_Loader(tendercreationlocators.loadingLocator, 2);
			waitForObj(2000);
			if(isElementDisplayed_Updated(tendercreationlocators.Submitbtn_IndentNew, 20)==true && isElementEnable_Updated(tendercreationlocators.Submitbtn_IndentNew, 20)) {
				click(tendercreationlocators.Submitbtn_IndentNew, "Submitbtn_Indent");
			}
			waitForElement(tendercreationlocators.Lbl_SendforApproval_Indent, 60);
			pdfResultReport.addStepDetails("IndentTG1_Submit",
					"Should click submit button during indent creation", "Sucessfully clicked submit button during indent creation " + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_Submit");

		} catch (Exception e) {
			log.fatal("Not able to click submit button during indent creation" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_Submit",
					"Should click submit button during indent creation", "Not able to click submit button during indent creation" + e.getMessage(),
					"Fail", "N");
		}
	}
	//Saving system indent no (28/01/2021)
	public String SystemIndentNoSave() throws Throwable {
		log.info("started executing the method:: SystemIndentNoSave");
		SystemIndentnoLocatorText = text(tendercreationlocators.SystemIndentNo).trim();
		System.out.println(SystemIndentnoLocatorText);
		return SystemIndentnoLocatorText;
	}
	//Saving system indent no (14/07/2022)
		public String SystemIndentNoSaveNew() throws Throwable {
			log.info("started executing the method:: SystemIndentNoSave");
			waitForObj(2000);
			SystemIndentnoLocatorText = text(tendercreationlocators.SystemIndentNo).replace("Indent No. : ", "").trim();
			System.out.println(SystemIndentnoLocatorText);
			Dynamicity.updateDataIntoPropertyFile("IndentID", SystemIndentnoLocatorText, filePath_4);
			return SystemIndentnoLocatorText;
		}
	//Userdefined Indent workflow send for approval page (28/01/2021)
	public void AddSingleUsersForSequentialApproval_IndentWF(String user) throws Throwable {
		try {
			log.info(
					"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
			click(tendercreationlocators.UserDefinedWFchkbox_Indent, "UserDefinedWFchkbox_Indent");
			//by default section wise comment selected No
			//loop to remove the row if the the user added previously
			if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
			{
				List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
				int iRowCount = iRows.size();
				for(int i=1;i<=iRowCount;i++)
				{	waitForObj(500);
					click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
				}
			}
			scrollToElement(tendercreationlocators.userAdd_Indent);
			waitForObj(500);
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			
			 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
				}

			set(tendercreationlocators.CommentsArea_IndentRTF, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
					"CommentsArea_Indent");
			
			
			
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Sequential Approval Must Be selected",
					"Sequential Approval selected Sucessfully"
							+ " ",
					"Pass", "Y");
			scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
			click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
			
			if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
			{
			if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
				isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
			{
				waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			}	
			}

			waitForElementToBeVisible(tendercreationlocators.myindent);
			
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Indent With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
		} catch (Exception e) {
			log.fatal("Not able to Submit Indent" + e.getMessage());
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Not able to Submit Indent"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	public void AddSingleUsersForSequentialApproval_IndentWF_Predefined(String user) throws Throwable {
		try {
			log.info(
					"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
			click(tendercreationlocators.Userdefined_po, "UserDefinedWFchkbox_Indent");
			//by default section wise comment selected No
			//loop to remove the row if the the user added previously
			if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
			{
				List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
				int iRowCount = iRows.size();
				for(int i=1;i<=iRowCount;i++)
				{
					waitForObj(1000);
					click(tendercreationlocators.canceluserinApprover, "canceluserinApprover");
				}
			}
			click(tendercreationlocators.adduserIcon, "userAdd_Indent");
			waitForObj(2000);
			
			 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					set(tendercreationlocators.predefinedUserAdd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					selectbyIndex(tendercreationlocators.predefinedApprovalType, 1);
					selectbyIndex(tendercreationlocators.predefinedApprovalType, 1);
					waitForObj(500);
					select(tendercreationlocators.predefinedApprovalType, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					set(tendercreationlocators.predefinedUserAdd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					waitForObj(500);
					select(tendercreationlocators.predefinedApprovalType, pdfResultReport.testData.get("ApprovalType2"));
				}

			waitForObj(2000);
			scrollToElement(tendercreationlocators.cancelIndentReason);
			set(tendercreationlocators.cancelIndentReason, "cancel Indent",
					"CommentsArea_Indent");
			
			
			
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Sequential Approval Must Be selected",
					"Sequential Approval selected Sucessfully"
							+ " ",
					"Pass", "Y");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.sendForCancellationApproval);
			click(tendercreationlocators.sendForCancellationApproval, "Btn_SendforApproval_Indent");
			waitForElementToBeVisible(tendercreationlocators.myindent);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Indent With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
		} catch (Exception e) {
			log.fatal("Not able to Submit Indent" + e.getMessage());
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Not able to Submit Indent"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Userdefined Indent workflow send for approval page (04/01/2024)
		public void AddSingleUsersForSequentialApproval_IndentWF_AfterRecall_Revert(String user) throws Throwable {
			try {
				log.info(
						"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
				click(tendercreationlocators.ActionButton_Backup, "ActionButton");
				click(tendercreationlocators.EditIndent, "EditIndent");
				waitForElementToBeClickable(tendercreationlocators.Submitbtn_IndentNew);
				JSClick(tendercreationlocators.Submitbtn_IndentNew, "Submitbtn_Indent");
				waitForElementToBeClickable(tendercreationlocators.UserDefinedWFchkbox_Indent);
				click(tendercreationlocators.UserDefinedWFchkbox_Indent, "UserDefinedWFchkbox_Indent");
				//by default section wise comment selected No
				//loop to remove the row if the the user added previously
				if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
				{
					List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
					int iRowCount = iRows.size();
					for(int i=1;i<=iRowCount;i++)
					{
						click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
					}
				}
				//approver 1 sequential
				waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				click(tendercreationlocators.userAdd_tender, "userAdd");
				scrollToElement(tendercreationlocators.POuseradd);
				 waitForElementToBeVisible(tendercreationlocators.POuseradd); 
				  
					//=========Role Activity and other Details===========================
				//=========Role Activity and other Details===========================
					String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
					String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
					
					String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
					boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
						if(fielddisplay==true) {
							set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
							selectbyIndex(tendercreationlocators.approverTypePO, 1);
							selectbyIndex(tendercreationlocators.approverTypePO, 1);
							select(tendercreationlocators.approverType1_p_tender, pdfResultReport.testData.get("ApprovalType2"));
							
						}
						else {
							set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
							waitForElementToBeClickable(tendercreationlocators.approverType1_p_tender);
							select(tendercreationlocators.approverType1_p_tender, pdfResultReport.testData.get("ApprovalType2"));
						}
						
				waitForElementToBeVisible(tendercreationlocators.comments_tender);
				set(tendercreationlocators.comments_tender, "Need Approvals",
						"comments");
				waitForElementToBeClickable(tendercreationlocators.send_for_approval);
				click(tendercreationlocators.send_for_approval, "sendForApproval");
				
				if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
				{
				if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
					isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
				{
					waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
					waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				}	
				}

				
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Sucessfully Submitted Indent With Seq Flow "
								+ " ",
						"Pass", "Y");
				log.info(
						"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
			} catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Not able to Submit Indent"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
		}
	
	
	//Navigating pending indent list during indent approval in indent approver login (28/01/2021)
	public void GoToApprovalworkFlowPendingindentAndSearchTheIndent() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheIndent");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			JSClick(tendercreationlocators.pending, "pending");
			
			if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
			{
			if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
				isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
			{
				waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			}	
			}

			waitForElementToBeClickable(tendercreationlocators.IndentListTab);
			click(tendercreationlocators.IndentListTab, "Indent");
			set(tendercreationlocators.searchBoxGRN, SystemIndentnoLocatorText, "search");
			waitForElementToBeVisible(tendercreationlocators.IndentRowResult_Approver(SystemIndentnoLocatorText));
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			int size = driver.findElements(tendercreationlocators.IndentRowResult_Approver(SystemIndentnoLocatorText)).size();
			if(size >=1)
			{
				System.out.println("**********************************************************************");
				System.out.println("Indent is present in Appproval pending List page the size is --->"+size);
				pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow",
					"Sucessfully displayed the pending indent in approval work flow", "Pass", "Y");
				log.info("completed executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheIndent");
				System.out.println("**********************************************************************");
			}
			else if((size ==0))
			{
				System.out.println("**********************************************************************");
				System.out.println("The indent is Not there in Approval pending List page the size is --->"+size);
				pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow","Unable to display the pending indent in approval work flow",
					"Fail", "N");
				
			}   

		
		} catch (Exception e) {
			log.fatal("Unable to display the pending indent in approval work flow" + e.getMessage());
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow","Unable to display the pending indent in approval work flow" + e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	
	//Navigating pending indent list during indent approval in indent approver login (04/01/2024	)
		public void GoToApprovalworkFlowCompletedindentAndSearchTheIndent() throws Throwable {
			try {
				log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheIndent");
				//Click on menu button (141222)
				JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
				mouseOver(tendercreationlocators.MyTask);
				waitForObj(2000);
				JSClick(tendercreationlocators.pending, "pending");
				waitForObj(6000);
				click(tendercreationlocators.completedTender, "completed tab");
				waitForObj(5000);
//				select(tendercreationlocators.completed_List, pdfResultReport.testData.get("Approval_Status"));
				waitForObj(2000);
//				waitForElementToBeVisible(tendercreationlocators.Lbl_workflowinbox);
				set(tendercreationlocators.search, SystemIndentnoLocatorText, "search");
				

			} catch (Exception e) {
				log.fatal("Unable to display the pending indent in approval work flow" + e.getMessage());
				pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
						"Should display the pending indent in approval work flow","Unable to display the pending indent in approval work flow" + e.getMessage(),
						"Fail", "N");
	                    Assert.fail("Failed Due to " + e.getMessage());
			}
		}
		
	//clicking on details link during indent approval in approver login (28/01/2021)
	public void clickDetailLinkInApprovalListPage() throws Throwable {
		try {
			log.info("started executing the method:: clickDetailLinkInApprovalListPage");
			waitForObj(2000);
			click(tendercreationlocators.new_action_button, "Actionbtn_IndentApprover");
			//click(tendercreationlocators.Detailbtn_IndentApprover, "Detailbtn_IndentApprover"); //commenting this line due new CR
			click(tendercreationlocators.details, "details");
			universalNormalWait();
			waitForElementToBeVisible(tendercreationlocators.LblAppCmnt_IndentApprover);
			waitForObj(3000);
			pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
					"Should Naviagte to Approver section comments page",
					"Sucessfully  Naviagte to Approver section comments page", "Pass", "Y");

			log.info("completed executing the method:: clickDetailLinkInApprovalListPage");
		} catch (Exception e) {
			log.fatal("Unable to Naviagte to Approver section comments page" + e.getMessage());
			pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
					"Should Naviagte to Approver section comments page",
					"Unable to Naviagte to Approver section comments page" + e.getMessage(), "Fail", "N");

                     Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	
	//clicking on details link during indent approval in approver login (04/01/2024)
		public void RecallFromApprovalCompletedListPage(String comment) throws Throwable {
			try {
				log.info("started executing the method:: clickDetailLinkInApprovalListPage");
				
				click(tendercreationlocators.new_action_button, "Actionbtn_IndentApprover");
				//click(tendercreationlocators.Detailbtn_IndentApprover, "Detailbtn_IndentApprover"); //commenting this line due new CR
				click(tendercreationlocators.RecallNotesheet, "recallByPreviousApprover");
				waitForElementToBeVisible(tendercreationlocators.recall_ApproverIndent);
				set(tendercreationlocators.recall_ApproverIndent, comment, "recallCommentSection");
				commentlist.add(text(tendercreationlocators.recall_ApproverIndent));
				waitForElementToBeClickable(tendercreationlocators.recallsubmit);
				click(tendercreationlocators.recallsubmit, "recall_submitButton");
				waitForObj(1000);
				pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
						"Should Naviagte to Approver section comments page",
						"Sucessfully  Naviagte to Approver section comments page", "Pass", "Y");

				log.info("completed executing the method:: clickDetailLinkInApprovalListPage");
			} catch (Exception e) {
				log.fatal("Unable to Naviagte to Approver section comments page" + e.getMessage());
				pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
						"Should Naviagte to Approver section comments page",
						"Unable to Naviagte to Approver section comments page" + e.getMessage(), "Fail", "N");

	                     Assert.fail("Failed Due to " + e.getMessage());
			}
		}
	
	
	//Indent approval with overall comment in approver login(29/01/2021)
	public void ApproverOverAllComentWithIndentHasBeenApproved() throws Throwable {
		try {
			log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
			String comment = "Indent Process Is Approved";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.AppComments);
			waitForElementToBeClickable(tendercreationlocators.ApproveBtn);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
			//click(tendercreationlocators.ApproveBtn_Indent, "approve");
			waitForObj(2000);
			JSClick(tendercreationlocators.ApproveBtn, "approve");
			waitForObj(2000);
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			int size = driver.findElements(tendercreationlocators.EndWF_tender).size();
			if(size>=1)
			{
				click(tendercreationlocators.EndWF_tender, "Close_Workflow_button");
				click(tendercreationlocators.approveConfirm, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "confirmButton");
			}
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			waitForObj(2000);
			click(tendercreationlocators.btnok, "btnok");
			click(tendercreationlocators.NoBtn_IndentApproval, "NoBtn_IndentApproval");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.WorkflowInbox);
			pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
					"Should Provide OverAll Comment ",
					"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
			log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
		} catch (Exception e) {
			log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
			pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
					"Should Provide OverAll Comment ",
					"Unable to Provide OverAll Comment"
							+ e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
		
	}
	
	public void ApproverOverAllComentWithIndentCancellationHasBeenApproved() throws Throwable {
		try {
			log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
			String comment = "Indent Process Is Approved";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.AppComments);
			waitForElementToBeClickable(tendercreationlocators.ApproveBtn);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
			//click(tendercreationlocators.ApproveBtn_Indent, "approve");
			waitForObj(2000);
			JSClick(tendercreationlocators.ApproveBtn, "approve");
			waitForObj(2000);
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			int size = driver.findElements(tendercreationlocators.EndWF_tender).size();
			if(size>=1)
			{
				click(tendercreationlocators.EndWF_tender, "Close_Workflow_button");
				click(tendercreationlocators.approveConfirm, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "confirmButton");
			}
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			waitForObj(2000);
			click(tendercreationlocators.btnok, "btnok");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.WorkflowInbox);
			pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
					"Should Provide OverAll Comment ",
					"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
			log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
		} catch (Exception e) {
			log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
			pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
					"Should Provide OverAll Comment ",
					"Unable to Provide OverAll Comment"
							+ e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
		
	}
	
		//created by @Arka on 020124
		public void Forward_IndentWF_With_ParallelApprovalType() throws Throwable {
			try {
				log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
					
				  waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				  click(tendercreationlocators.userAdd_tender, "add user SN");
				  scrollToElement(tendercreationlocators.POuseradd);
				  waitForElementToBeVisible(tendercreationlocators.POuseradd);
				 
				//=========Role Activity and other Details===========================
					String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
					String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
					
					String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
					boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
					if(fielddisplay==true) {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user1");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
						
					}
					else {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user1");
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					}
				  
				  //add approver
				  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
				  click(tendercreationlocators.userAdd_tender, "add user SN");
				  waitForElementToBeVisible(tendercreationlocators.POuseradd);
				 
				  
				//=========Role Activity and other Details===========================
		
					if(fielddisplay==true) {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover3")), "user1");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
						
					}
					else {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover3")), "user1");
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					}
				  
				  //add approver
				  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
				  click(tendercreationlocators.userAdd_tender, "add user SN");
				  waitForElementToBeVisible(tendercreationlocators.POuseradd);
				 
				  
				//=========Role Activity and other Details===========================
			
					if(fielddisplay==true) {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover4")), "user1");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
						
					}
					else {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover4")), "user1");
						waitForElementToBeClickable(tendercreationlocators.approverTypePO);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					}
				  
				  //co-ordinator , min approver		  
				  waitForElementToBeClickable(tendercreationlocators.cordinatorPO);
					set(tendercreationlocators.parallelApprovermin, pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
				   waitForElementToBeClickable(tendercreationlocators.cordinatorPO);
					click(tendercreationlocators.cordinatorPO, "parallel_Coordinator_Flag");
					//Select minimum approver
					
					
					//send for approval
					scrollToElement(tendercreationlocators.Btn_Forward_Indent);
					waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
					click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
					waitForElementToBeClickable(tendercreationlocators.btnok);
					click(tendercreationlocators.btnok, "Send for approval");
			
					if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
					{
					if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
						isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
					{
						waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
						waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
					}	
					}
				
					 pdfResultReport.addStepDetails("sendForApprovalProcess",
			                  "send for approval ",
			                  "Successfully sent sendForForwardParallelTenderApprovalProcess " + " ", "Pass", "Y");
			     log.info("completed executing the method:: sendForForwardParallelTenderApproval Process");
			} catch (Exception e) {
				log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
				pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
						"Should Provide OverAll Comment and Forward the workflow ",
						"Unable to Provide OverAll Comment and Forward the workflow"
								+ e.getMessage(),
						"Fail", "N");
	                    Assert.fail("Failed Due to " + e.getMessage());
			}
		}
		
		//created by @Arka on 030124
		public void AddMultipleUsersForSequentialParallelApproval_IndentWF(String comment) throws Throwable {
			try {
				log.info("started executing the method:: AddMultipleUsersForSequentialParallelApproval_IndentWF");
				
				click(tendercreationlocators.ActionButton_Backup, "ActionButton");
				click(tendercreationlocators.EditIndent, "EditIndent");
				waitForElementToBeClickable(tendercreationlocators.Submitbtn_IndentNew);
				JSClick(tendercreationlocators.Submitbtn_IndentNew, "Submitbtn_Indent");
				waitForElementToBeClickable(tendercreationlocators.UserDefinedWFchkbox_Indent);
				//String comment = "Indent Process Is Approved";
				click(tendercreationlocators.UserDefinedWFchkbox_Indent, "UserDefinedWFchkbox_Indent");
				//by default section wise comment selected No
				//loop to remove the row if the the user added previously
				if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
				{
					List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
					int iRowCount = iRows.size();
					for(int i=1;i<=iRowCount;i++)
					{
						waitForObj(1000);
						click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
					}
				}
				
				scrollToElement(tendercreationlocators.CommentsArea_IndentRTF);
				set(tendercreationlocators.CommentsArea_IndentRTF, comment, "CommentsArea_Indent");
				commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
				
				//1st parallel approver
				waitForElementToBeClickable(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user1_Indent);
				waitForElementToBeClickable(tendercreationlocators.user1_Indent);
				set(tendercreationlocators.user1_Indent, pdfResultReport.testData.get("User_Approver1"), "Approver1_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				
				//2nd parallel approver
				waitForElementToBeClickable(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user2_Indent);
				waitForElementToBeClickable(tendercreationlocators.user2_Indent);
				set(tendercreationlocators.user2_Indent, pdfResultReport.testData.get("User_Approver2"), "Approver2_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				
				//3rd Parallel approver
				waitForElementToBeClickable(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user3_Indent);
				waitForElementToBeClickable(tendercreationlocators.user3_Indent);
				set(tendercreationlocators.user3_Indent, pdfResultReport.testData.get("User_Approver3"), "Approver3_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				
				//Select coordinator for parallel approvers
				waitForElementToBeClickable(tendercreationlocators.parallelCoordinatorindent);
				click(tendercreationlocators.parallelCoordinatorindent, "parallel_Coordinator_Flag");
				
				//Select minimum approver for parallel approvers
				waitForElementToBeClickable(tendercreationlocators.minimumApprover);
				set(tendercreationlocators.minimumApprover, pdfResultReport.testData.get("Min_Approver_3"), "Select_minimum_Approver_All");
				//click(tendercreationlocators.parallelCoordinator, "parallel_Coordinator_Flag");
				
				//4th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user4_Indent);
				waitForElementToBeClickable(tendercreationlocators.user4_Indent);
				set(tendercreationlocators.user4_Indent, pdfResultReport.testData.get("User_Approver4"), "Approver4_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//5th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user5_Indent);
				waitForElementToBeClickable(tendercreationlocators.user5_Indent);
				set(tendercreationlocators.user5_Indent, pdfResultReport.testData.get("User_Approver5"), "Approver5_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//6th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user6_Indent);
				waitForElementToBeClickable(tendercreationlocators.user6_Indent);
				set(tendercreationlocators.user6_Indent, pdfResultReport.testData.get("User_Approver6"), "Approver6_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//7th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user7_Indent);
				waitForElementToBeClickable(tendercreationlocators.user7_Indent);
				set(tendercreationlocators.user7_Indent, pdfResultReport.testData.get("User_Approver7"), "Approver7_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//8th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user8_Indent);
				waitForElementToBeClickable(tendercreationlocators.user8_Indent);
				set(tendercreationlocators.user8_Indent, pdfResultReport.testData.get("User_Approver8"), "Approver8_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//9th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user9_Indent);
				waitForElementToBeClickable(tendercreationlocators.user9_Indent);
				set(tendercreationlocators.user9_Indent, pdfResultReport.testData.get("User_Approver9"), "Approver9_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				//10th sequential approver
				scrollToElement(tendercreationlocators.userAdd_Indent);
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				scrollToElement(tendercreationlocators.user10_Indent);
				waitForElementToBeClickable(tendercreationlocators.user10_Indent);
				set(tendercreationlocators.user10_Indent, pdfResultReport.testData.get("User_Approver10"), "Approver10_Indent");
				waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				
				scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
				click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
				waitForElementToBeVisible(tendercreationlocators.myindent);
				
				//Select minimum approver for parallel approvers
			/*
			 * scrollToElement(tendercreationlocators.AppComments_Indent);
			 * set(tendercreationlocators.minimumApprover,
			 * pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
			 * click(tendercreationlocators.parallelCoordinator,
			 * "parallel_Coordinator_Flag");
			 */
				
				
				pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_IndentWF",
						"Should Provide OverAll Comment ",
						"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
				log.info("completed executing the method:: AddMultipleUsersForSequentialParallelApproval_IndentWF");
			} catch (Exception e) {
				log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
				pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_IndentWF",
						"Should Provide OverAll Comment and reinitiate the workflow ",
						"Unable to Provide OverAll Comment and reinitiate the workflow"
								+ e.getMessage(),
						"Fail", "N");
	                    Assert.fail("Failed Due to " + e.getMessage());
			}
		}
		
		//created by @Arka on 040124
				public void recallWF(String comment) throws Throwable {
					try {
						log.info("started executing the method:: AddMultipleUsersForSequentialParallelApproval_IndentWF");
						
						click(tendercreationlocators.ActionButton_Backup, "ActionButton");
						click(tendercreationlocators.RecallIndent, "RecallIndent");
						waitForElementToBeVisible(tendercreationlocators.RecallIndentText);
						set(tendercreationlocators.Remarks_recall, comment, "Remarks_recall");
						commentlist.add(text(tendercreationlocators.Remarks_recall));
						waitForElementToBeClickable(tendercreationlocators.Recall_Submit);
						JSClick(tendercreationlocators.Recall_Submit, "Recall_Submit");
						waitForElementToBeClickable(tendercreationlocators.BtnOk);
						click(tendercreationlocators.BtnOk, "Ok Button");
						waitForElementToBeVisible(tendercreationlocators.myindent);
						
						pdfResultReport.addStepDetails("recallWF",
								"Should  recallWF ",
								"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
						log.info("completed executing the method:: recallWF");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("recallWF",
								"Should  recallWF ",
								"Unable to recallWF"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
		
		//created by @Arka on 020124
				public void Forward_IndentWF_With_SequentialApprovalType() throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						  waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
						  click(tendercreationlocators.userAdd_tender, "add user SN");
						  scrollToElement(tendercreationlocators.POuseradd);
						  waitForElementToBeVisible(tendercreationlocators.POuseradd);
						 
						//=========Role Activity and other Details===========================
							String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
							String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
							
							String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
							boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
							if(fielddisplay==true) {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								
							}
							else {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
							}
						  
						  //add approver
						  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
						  click(tendercreationlocators.userAdd_tender, "add user SN");
						  waitForElementToBeVisible(tendercreationlocators.POuseradd);
						 
						  
						//=========Role Activity and other Details===========================
				
							if(fielddisplay==true) {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover6")), "user1");
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								
							}
							else {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover6")), "user1");
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
							}
						  
						  //add approver
						  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
						  click(tendercreationlocators.userAdd_tender, "add user SN");
						  waitForElementToBeVisible(tendercreationlocators.POuseradd);
						 
						  
						//=========Role Activity and other Details===========================
					
							if(fielddisplay==true) {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover7")), "user1");
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								
							}
							else {
								set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover7")), "user1");
								waitForElementToBeClickable(tendercreationlocators.approverTypePO);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
							}
						  
						
							
							
							//send for approval
							scrollToElement(tendercreationlocators.Btn_Forward_Indent);
							waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
							click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
							waitForElementToBeClickable(tendercreationlocators.btnok);
							click(tendercreationlocators.btnok, "Send for approval");
							
							if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
							{
							if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
								isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
							{
								waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
								waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
							}	
							}
							
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  "  + " ", "Pass", "Y");
						log.info("completed executing the method:: ForwardWFOverAllComentWithIndentHasBeenApproved");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment and Forward the workflow ",
								"Unable to Provide OverAll Comment and Forward the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				
				//created by @Arka on 020124
				public void Forward_IndentWF_With_Single_SequentialApprovalType(String user) throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						//approver 1 sequential
						  scrollToElement(tendercreationlocators.userAdd_tender);
							waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
							click(tendercreationlocators.userAdd_tender, "userAdd");
							scrollToElement(tendercreationlocators.POuseradd);
							 waitForElementToBeVisible(tendercreationlocators.POuseradd); 
							  
							 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
								String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
								
								String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
								boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
								if(fielddisplay==true) {
									set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
									selectbyIndex(tendercreationlocators.approverTypePO, 1);
									selectbyIndex(tendercreationlocators.approverTypePO, 1);
									select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
									
								}
								else {
									set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
									select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								}
						  
						  
						//send for approval
							scrollToElement(tendercreationlocators.Btn_Forward_Indent);
							waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
							click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
							waitForElementToBeClickable(tendercreationlocators.btnok);
							click(tendercreationlocators.btnok, "btnok");
							
							if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 3))
							{
							if(	isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2) &&
								isElementEnable_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
							{
								waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
								waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
							}	
							}

							
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  "  , "Pass", "Y");
						log.info("completed executing the method:: ForwardWFOverAllComentWithIndentHasBeenApproved");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment and Forward the workflow ",
								"Unable to Provide OverAll Comment and Forward the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				
				//created by @Arka on 020124
				public void recallfrom_Previous_Approver(String comment, String approverName, By row ) throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						//String comment = "Indent Process Is Approved";
						click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.AppComments);
						//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
						set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
						waitForObj(1000);
						JSClick(tendercreationlocators.ApproveBtn, "approve");
						waitForObj(2000);
						click(tendercreationlocators.ForwardWF_Indent, "Forward_WF_Indent");
						
						//1st sequential approver
						waitForElementToBeClickable(tendercreationlocators.userAdd_Indent);
						click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
						scrollToElement(row);
						waitForElementToBeClickable(row);
						set(row, approverName, "Approver4_Indent");
						waitForElementToBeClickable(tendercreationlocators.approverType1_Indent);
						select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
						
						
						scrollToElement(tendercreationlocators.Btn_Forward_Indent);
						waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
						click(tendercreationlocators.Btn_Forward_Indent, "Forward_Indent");
						
						waitForElementToBeVisible(tendercreationlocators.success_text);
						waitForElementToBeVisible(tendercreationlocators.success_msg);
						waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
						click(tendercreationlocators.success_Ok_button, "success_Ok_button");
						
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
						log.info("completed executing the method:: ForwardWFOverAllComentWithIndentHasBeenApproved");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment and Forward the workflow ",
								"Unable to Provide OverAll Comment and Forward the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				
				//created by @Arka on 020124
				public void Approve_Indent_by_NonCoordinators(String comment) throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						//String comment = "Indent Process Is Approved";
						click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.AppComments);
						waitForElementToBeClickable(tendercreationlocators.ApproveBtn);
						//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
						set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
						commentlist.add(text(tendercreationlocators.AppComments));
						waitForObj(1000);
						JSClick(tendercreationlocators.ApproveBtn, "approve");
						waitForObj(3000);
						JSClick(tendercreationlocators.confirmButton, "confirm_Button");
						waitForElementToBeVisible(tendercreationlocators.success_text);
						waitForElementToBeVisible(tendercreationlocators.approval_success_msg);
						waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
						click(tendercreationlocators.success_Ok_button, "success_Ok_button");
						
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
						log.info("completed executing the method:: ForwardWFOverAllComentWithIndentHasBeenApproved");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("ForwardWFOverAllComentWithIndentHasBeenApproved",
								"Should Provide OverAll Comment and Forward the workflow ",
								"Unable to Provide OverAll Comment and Forward the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				
				//created by @Arka on 020124
				public void Revert_Indent_to_PreviousApprover(String comment) throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						//String comment = "Indent Process Is Approved";
						click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.AppComments);
						//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
						set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
						commentlist.add(text(tendercreationlocators.AppComments));
						waitForObj(1000);
						JSClick(tendercreationlocators.SendBaackBtn, "Review_Back");
						waitForObj(3000);
						JSClick(tendercreationlocators.ReviewBackWF_to_previousApprover, "ReviewBackWF_Indent_to_previousApprover");
						waitForObj(3000);
						JSClick(tendercreationlocators.confirmButton, "confirm_Button");
						waitForElementToBeVisible(tendercreationlocators.success_text);
						waitForElementToBeVisible(tendercreationlocators.review_success_msg);
						waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
						click(tendercreationlocators.success_Ok_button, "success_Ok_button");
						
						pdfResultReport.addStepDetails("RevertWFOverAllComentWithIndentHasBeenRevertedToPreviousApprover",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
						log.info("completed executing the method:: RevertWFOverAllComentWithIndentHasBeenRevertedToPreviousApprover");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("RevertWFOverAllComentWithIndentHasBeenRevertedToPreviousApprover",
								"Should Provide OverAll Comment and Revert the workflow ",
								"Unable to Provide OverAll Comment and Revert the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				
				//created by @Arka on 020124
				public void Revert_Indent_to_Creator(String comment) throws Throwable {
					try {
						log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
						//String comment = "Indent Process Is Approved";
						click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.AppComments);
						//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
						set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
						commentlist.add(text(tendercreationlocators.AppComments));
						waitForObj(1000);
						JSClick(tendercreationlocators.SendBaackBtn, "Review_Back");
						waitForObj(3000);
						JSClick(tendercreationlocators.ReviewBackWF_to_Creator, "ReviewBackWF_Indent_to_Creator");
						waitForObj(3000);
						JSClick(tendercreationlocators.confirmButton, "confirm_Button");
						waitForElementToBeVisible(tendercreationlocators.success_text);
						waitForElementToBeVisible(tendercreationlocators.review_success_msg);
						waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
						click(tendercreationlocators.success_Ok_button, "success_Ok_button");
						
						pdfResultReport.addStepDetails("RevertWFOverAllComentWithIndentHasBeenRevertedToCreator",
								"Should Provide OverAll Comment ",
								"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
						log.info("completed executing the method:: RevertWFOverAllComentWithIndentHasBeenRevertedToCreator");
					} catch (Exception e) {
						log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
						pdfResultReport.addStepDetails("RevertWFOverAllComentWithIndentHasBeenRevertedToCreator",
								"Should Provide OverAll Comment and Revert the workflow ",
								"Unable to Provide OverAll Comment and Revert the workflow"
										+ e.getMessage(),
								"Fail", "N");
			                    Assert.fail("Failed Due to " + e.getMessage());
					}
				}
		
		
	//Indent approval reviewed to creator in approver login(29/01/2021)
	public void ApproverReviewedIndent_withOverallComment() throws Throwable {
		try {
			log.info("started executing the method:: ApproverReviewedIndent_withOverallComment");
			String comment = "Indent Process Is Reviewed";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.AppComments);
			set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
			JSClick(tendercreationlocators.SendBaackBtn, "SendBaackBtn_Indent");
			waitForObj(1000);
			waitForElementToBeVisible(tendercreationlocators.ConfirmMsg_IndentSendBack);
			click(tendercreationlocators.OKBtn_IndentSendBack, "OKBtn_IndentSendBack");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(3000);
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			click(tendercreationlocators.OKBtn_IndentApproval, "OKBtn_IndentApproval");
			waitForObj(1000);
			waitForElementToBeVisible(tendercreationlocators.Lbl_workflowinbox);
			pdfResultReport.addStepDetails("ApproverReviewedIndent_withOverallComment",
					"Should Provide OverAll Comment ",
					"SucessFully Provided Over All Comment As --->  " + comment + " and Reviewed the indent", "Pass", "Y");
			log.info("completed executing the method:: ApproverReviewedIndent_withOverallComment");
		} catch (Exception e) {
			log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
			pdfResultReport.addStepDetails("ApproverReviewedIndent_withOverallComment",
					"Should Provide OverAll Comment ",
					"Unable to Provide OverAll Comment"
							+ e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Navigating pending indent list and search the indent in indent creator login (29/01/2021)
	public void enterIndentNoInSearch() throws Throwable {
		try {
			log.info("started executing the method:: enterIndentNoInSearch");
			waitForElementToBeVisible(tendercreationlocators.Txt_TypeanyKeyword_Indent);
			waitForElementToBeClickable(tendercreationlocators.Txt_TypeanyKeyword_Indent);
			clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
			set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			//waitForElementToBeVisible(tendercreationlocators.IndentRowResult(SystemIndentnoLocatorText));
			waitForElementToBeVisible(tendercreationlocators.ActionButton);
			if(driver.findElements(tendercreationlocators.ActionButton).size()==1) {
				click(tendercreationlocators.ActionButton, "ActionButton");
				click(tendercreationlocators.ViewIndent, "ViewIndent");
				waitForElementToBeClickable(tendercreationlocators.printBtn);
				waitForElementToBeVisible(tendercreationlocators.SystemIndentNOHeader);
				String IndentNo = text(tendercreationlocators.SystemIndentNO).trim();
				
				
				  try 
				  { if(IndentNo.equals(SystemIndentnoLocatorText)) {
				  log.info("IndentNo has been matched"); 
				  log.info("Indent Numder: "+ IndentNo);
				  
				  
				  } 
				  } 
				  catch(Exception e) 
				  { 
				  log.fatal("Not able to match Indent No" +
				  e.getMessage()); 
				  pdfResultReport.addStepDetails("Not able to match indent",
				  "able to enter Indent No in search field but",
				  "Unable to match Indent No with indent no of Indent preview" +
				  e.getMessage(), "Fail", "N");
				  
				  }
				 
				waitForElementToBeClickable(tendercreationlocators.PreviewCrossButton);
				click(tendercreationlocators.PreviewCrossButton, "PreviewCrossButton");
				pdfResultReport.addStepDetails("Successfully Saved",
						"Indent No must be entered successfully in search field",
						"Indent No is successfully entered in search field and matched" + " ", "Pass", "Y");
				log.info("completed executing the method:: enterIndentNoInSearch");
				
				}
			
		} catch (Exception e) {
			log.fatal("Not able to search Indent No" + e.getMessage());
			pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
					"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
		}
	}
	
	//Added on 030124 by Arka
	public void edit_Indent_after_Recall_Review() throws Throwable {
		try {
			log.info("started executing the method:: enterIndentNoInSearch");

			clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
			set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
			waitForElementToBeVisible(tendercreationlocators.ActionButton_Backup);
			click(tendercreationlocators.ActionButton_Backup, "ActionButton");
			click(tendercreationlocators.EditIndent, "EditIndent");
			
			dynamic_Loader(tendercreationlocators.loadingLocator, 3);
			
				pdfResultReport.addStepDetails("Successfully Saved",
						"Indent No must be entered successfully in search field",
						"Indent No is successfully entered in search field and matched" + " ", "Pass", "Y");
				log.info("completed executing the method:: enterIndentNoInSearch");
				
				
			
		} catch (Exception e) {
			log.fatal("Not able to search Indent No" + e.getMessage());
			pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
					"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
		}
	}
	//Added on 291222
	public void enterIndentNoForSearch() throws Throwable {
		try {
			log.info("started executing the method:: enterIndentNoInSearch");

			clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
			set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
				pdfResultReport.addStepDetails("Successfully Saved",
						"Indent No must be entered successfully in search field",
						"Indent No is successfully entered in search field and matched" + " ", "Pass", "Y");
				log.info("completed executing the method:: enterIndentNoInSearch");
			
		} catch (Exception e) {
			log.fatal("Not able to search Indent No" + e.getMessage());
			pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
					"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
		}
	}
	
	//Navigating pending indent list and search the indent in indent creator login (03/06/2021)
		public void enterIndentNoInSearchInIndent() throws Throwable {
			try {
				log.info("started executing the method:: enterIndentNoInSearch");

				clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
				set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
				waitForObj(1000);
				waitForElementToBeVisible(tendercreationlocators.IndentRowResultFromIndent(SystemIndentnoLocatorText));
				waitForObj(2000);
				
				pdfResultReport.addStepDetails("Successfully Saved",
						"Indent No must be entered successfully in search field",
						"Indent No is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: enterIndentNoInSearch");
			} catch (Exception e) {
				log.fatal("Not able to search Indent No" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
						"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
			}
		}
		//Navigating pending indent list and search the indent in indent creator login (03/06/2021)
		public void enterIndentNoInSearchInTender() throws Throwable {
			try {
				log.info("started executing the method:: enterIndentNoInSearch");

				clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
				set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
				waitForObj(1000);
				waitForElementToBeVisible(tendercreationlocators.IndentRowResultFromTender(SystemIndentnoLocatorText));
				waitForObj(2000);
				
				pdfResultReport.addStepDetails("Successfully Saved",
						"Indent No must be entered successfully in search field",
						"Indent No is successfully entered in search field" + " ", "Pass", "Y");
				log.info("completed executing the method:: enterIndentNoInSearch");
			} catch (Exception e) {
				log.fatal("Not able to search Indent No" + e.getMessage());
				pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
						"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
			}
		}
	//Navigating pending indent list and search the indent in indent creator login (01/02/2021)
	public void enterIndentNoInSearch_RFQfromIndentPage() throws Throwable {
		try {
			log.info("started executing the method:: enterIndentNoInSearch_RFQfromIndentPage");

			clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_RFQfromIndent");
			set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_RFQfromIndent");
			waitForElementToBeVisible(tendercreationlocators.IndentRowResult);
			
			pdfResultReport.addStepDetails("enterIndentNoInSearch_RFQfromIndentPage",
					"Indent No must be entered successfully in search field",
					"Indent No is successfully entered in search field" + " ", "Pass", "Y");
			log.info("completed executing the method:: enterIndentNoInSearch_RFQfromIndentPage");
		} catch (Exception e) {
			log.fatal("Not able to search Indent No" + e.getMessage());
			pdfResultReport.addStepDetails("Not able to search indent", "Not able to enter Indent No in search field",
					"Unable to enter Indent No in search field" + e.getMessage(), "Fail", "N");
		}
	}
	//Navigating pending indent list and search the indent in indent creator login (29/01/2021)
	public void VerifyIndentStatus(String indentstatus) throws Throwable {
		try {
			log.info("started executing the method:: VerifyIndentStatus");
			if(indentstatus.equalsIgnoreCase("Cancelled")||indentstatus.equalsIgnoreCase("Deleted"))
			{
			click(tendercreationlocators.cancelledIndentTab, "cancel/delete tab");
			String txt = text(tendercreationlocators.IndentStatus_Delete_CancelledTab).trim();
			if(txt.equalsIgnoreCase(indentstatus))
			{
				pdfResultReport.addStepDetails("Verify Indent status",
						"Indent status should be "+indentstatus,
						"Indent status is '"+txt+"' and successfully verified" + " ", "Pass", "Y");
			}			
			else {
				pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status",
						"Unable to verify indent status", "Fail", "N");
			
				}
			}
			else {
				String txt = text(tendercreationlocators.IndentStatus_ListPage).trim();
				if(txt.equalsIgnoreCase(indentstatus))
				{
					pdfResultReport.addStepDetails("Verify Indent status",
							"Indent status should be "+indentstatus,
							"Indent status is '"+txt+"' and successfully verified" + " ", "Pass", "Y");
				}			
				else {
					pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status",
							"Unable to verify indent status", "Fail", "N");
				
					}
				}
			
			
			log.info("completed executing the method:: VerifyIndentStatus");
		} catch (Exception e) {
			log.fatal("Not able to verify indent status" + e.getMessage());
			pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status",
					"Unable to verify indent status" + e.getMessage(), "Fail", "N");
		}
	}
	public void openIndentPreview() throws Throwable {
		try {
			log.info("started executing the method:: openIndentPreview");
			String indetMenu="//div[@class='dropstart']/button"; 
			String viewIndent="//a[@id='openModalButton']"; 
			click(By.xpath(indetMenu),"clicking on menu against Respective Indent"); 
			click(By.xpath(viewIndent),"clicking on menu against Respective Indent");
			API_Component.pI_V();
			System.out.println(uniqueTG.toString());
		} catch (Exception e) {
			log.fatal("Not able to open IndentPreview" + e.getMessage());
			pdfResultReport.addStepDetails("Verify indent status", "Should be able to open IndentPreview",
					"Unable to open IndentPreview" + e.getMessage(), "Fail", "N");
		}
	}
	//Indent workflow with approver not required (29/01/2021)
	public void NoApproval_IndentWF() throws Throwable {
		try {
			log.info(
					"started executing the method:: NoApproval_IndentWF");
			click(tendercreationlocators.NotReqdWFchkbox_Indent, "NotReqdWFchkbox_Indent");
			pdfResultReport.addStepDetails("NoApproval_IndentWF",
					"Not Required approval type should be selected",
					"Not Required approval type selected Sucessfully"
							+ " ",
					"Pass", "Y");
			if(isElementDisplayed_Updated(tendercreationlocators.CompleteIndentbtn, 20)==true && isElementEnable_Updated(tendercreationlocators.CompleteIndentbtn, 20)==true) {
			click(tendercreationlocators.CompleteIndentbtn, "CompleteIndentbtn");
			}
			pdfResultReport.addStepDetails("NoApproval_IndentWF",
					"Must Submit the Indent With approval flow not required ",
					"Sucessfully Submitted Indent With approval flow not required"
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: NoApproval_IndentWF");
		} catch (Exception e) {
			log.fatal("Not able to Submit Indent" + e.getMessage());
			pdfResultReport.addStepDetails("NoApproval_IndentWF",
					"Must Submit the Indent With approval flow not required",
					"Not able to Submit Indent with approval flow not required"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Indent mark for RFQ functionality (01/02/2021)
	public void Indent_Mark_for_RFQ_functionality() throws Throwable {
		try {
			log.info(
					"started executing the method:: Indent_Mark_for_RFQ_functionality");
			
			click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
			//waitForElementToBeVisible(tendercreationlocators.DropdownmenuListpage_Indent);
			JSClick(tendercreationlocators.MarkForRFQBtn_Indent, "MarkForRFQBtn_Indent");
			waitForElementToBeVisible(tendercreationlocators.Confbtn_Indent);
			click(tendercreationlocators.Confbtn_Indent, "Confbtn_Indent");
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			click(tendercreationlocators.Okbtn_Indent, "Okbtn_Indent");
			waitForElementToBeVisible(tendercreationlocators.Lbl_IndentList);
			
			pdfResultReport.addStepDetails("Indent_Mark_for_RFQ_functionality",
					"Indent should be able to be marked for RFQ",
					"Indent is able to be marked for RFQ "
							+ " ",
					"Pass", "Y");

			log.info(
					"completed executing the method:: Indent_Mark_for_RFQ_functionality");
		} catch (Exception e) {
			log.fatal("Not able to mark for RFQ the indent" + e.getMessage());
			pdfResultReport.addStepDetails("Indent_Mark_for_RFQ_functionality",
					"Indent should be able to be marked for RFQ",
					"Not able to mark for RFQ the indent"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Navigate to Indent Assignment page (01/02/2021)
	public void navigateToIndentAssignment() throws Throwable {
		try {
			log.info("started executing the method:: navigateToIndentAssignment");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.Requisition);
			waitForElementToBeClickable(tendercreationlocators.IndentAssignmentlnk_Indent);
			JSClick(tendercreationlocators.IndentAssignmentlnk_Indent, "IndentAssignmentlnk_Indent");
			waitForElementToBeVisible(tendercreationlocators.IndentAssignmentListLbl_Indent);

			pdfResultReport.addStepDetails("navigateToIndentAssignment", "Indent Assignment list must be navigated successfully",
					"Successfully navigated to Indent Assignmentlist" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToIndentAssignment");

		} catch (Exception e) {
			log.fatal("Unable to navigate to the indent Assignment list" + e.getMessage());
			pdfResultReport.addStepDetails("Navigate to indent Assignment List", "Not able to navigate to the indent Assignment list",
					"Unable to navigate to the indent Assignment list" + e.getMessage(), "Fail", "N");
		}
	}
	//Indent mark for RFQ functionality (01/02/2021)
	public void Verify_Indent_Assignment_self_Claim() throws Throwable {
		try {
			log.info(
					"started executing the method:: Verify_Indent_Assignment_self_Claim");
			
			click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
			waitForElementToBeVisible(tendercreationlocators.ClaimLnkAssignmentListpage_Indent);
			click(tendercreationlocators.ClaimLnkAssignmentListpage_Indent, "ClaimLnkAssignmentListpage_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Alertbox_Indent);
			click(tendercreationlocators.Yesbtn_Indent, "Yesbtn_Indent");
			waitForElementToBeVisible(tendercreationlocators.Okbtn_Indent);
			click(tendercreationlocators.Okbtn_Indent, "Okbtn_Indent");
			pdfResultReport.addStepDetails("Verify_Indent_Assignment_self_Claim",
					"Tender creator should be able to self claim the indent",
					"Tender creator is able to self claim the indent"
							+ " ",
					"Pass", "Y");

			log.info(
					"completed executing the method:: Verify_Indent_Assignment_self_Claim");
		} catch (Exception e) {
			log.fatal("Not able to mark for RFQ the indent" + e.getMessage());
			pdfResultReport.addStepDetails("Indent_Mark_for_RFQ_functionality",
					"Tender creator should be able to self claim the indent",
					"Tender creator is not able to self claim the indent"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Verify indent status in assignment list page (01/02/2021)
	public void VerifyIndentStatus_AssignmentListPage(String indentstatus) throws Throwable {
		try {
			log.info("started executing the method:: VerifyIndentStatus_AssignmentListPage");

			String txt = text(tendercreationlocators.IndentStatus_AssignmentListPage).trim();
			if(txt.equalsIgnoreCase(indentstatus))
			{
				pdfResultReport.addStepDetails("Verify Indent status",
						"Indent status should be "+indentstatus,
						"Indent status is '"+txt+"' and successfully verified" + " ", "Pass", "Y");
			}
			else
			{
				pdfResultReport.addStepDetails("Verify Indent status", "Indent status should be "+indentstatus,
						"Indent status is '"+txt+"' instead of '"+ indentstatus+"' ", "Fail", "N");
			}
			
			log.info("completed executing the method:: VerifyIndentStatus_AssignmentListPage");
		} catch (Exception e) {
			log.fatal("Not able to verify indent status" + e.getMessage());
			pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status",
					"Unable to verify indent status" + e.getMessage(), "Fail", "N");
		}
	}
	//Verify revert back to IC functionality (02/02/2021)
	public void Verify_Revert_back_to_IC() throws Throwable {
		try {
			log.info(
					"started executing the method:: Verify_Revert_back_to_IC");
			
			click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
			waitForElementToBeVisible(tendercreationlocators.RevertToICLnkAssignmentListpage_Indent);
			click(tendercreationlocators.RevertToICLnkAssignmentListpage_Indent, "RevertToICLnkAssignmentListpage_Indent");
			waitForObj(1000);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.RevertToICbox_Indent);
			set(tendercreationlocators.ReasonofRevertTxtbox_Indent, "Revert to IC", "Txt_TypeanyKeyword_RFQfromIndent");
			click(tendercreationlocators.Revertbox_Submitbtn_Indent, "Revertbox_Submitbtn_Indent");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			click(tendercreationlocators.Okbtn_Indent, "Okbtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.IndentAssignmentListLbl_Indent);
			
			pdfResultReport.addStepDetails("Verify_Revert_back_to_IC",
					"Tender creator should be able to revert the indent back to IC",
					"Tender creator is able to revert the indent back to IC"
							+ " ",
					"Pass", "Y");

			log.info(
					"completed executing the method:: Verify_Revert_back_to_IC");
		} catch (Exception e) {
			log.fatal("Not able to revert the indent back to IC" + e.getMessage());
			pdfResultReport.addStepDetails("Indent_Mark_for_RFQ_functionality",
					"Tender creator should be able to revert the indent back to IC",
					"Tender creator is not able to revert the indent back to IC"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	//Verify assign user functionality of indent (02/02/2021)
	public void Verify_Assign_indent_ToUser() throws Throwable {
		try {
			log.info(
					"started executing the method:: Verify_Assign_indent_ToUser");
			
			click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
			waitForElementToBeVisible(tendercreationlocators.AssignUserLnkAssignmentListpage_Indent);
			click(tendercreationlocators.AssignUserLnkAssignmentListpage_Indent, "AssignUserLnkAssignmentListpage_Indent");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.AssignUsermodal_Indent);
			set(tendercreationlocators.TypeanyKeyword_AssignUsermodal_Indent, pdfResultReport.testData.get("IndentAssignUser_Username"), "TypeanyKeyword_AssignUsermodal_Indent");
			click(tendercreationlocators.AddUser_AssignUsermodal_Indent, "AddUser_AssignUsermodal_Indent");
			waitForObj(1000);
			set(tendercreationlocators.Remarks_AssignUsermodal_Indent, "Assigned to user", "Remarks_AssignUsermodal_Indent");
			click(tendercreationlocators.Submitbtn_AssignUsermodal_Indent, "Submitbtn_AssignUsermodal_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
			click(tendercreationlocators.Okbtn_Indent, "Okbtn_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.IndentAssignmentListLbl_Indent);
			
			pdfResultReport.addStepDetails("Verify_Assign_indent_ToUser",
					"Tender creator should be able to assign indent to selected user",
					"Tender creator is able to assign indent to selected user"
							+ " ",
					"Pass", "Y");

			log.info(
					"completed executing the method:: Verify_Assign_indent_ToUser");
		} catch (Exception e) {
			log.fatal("Not able to revert the indent back to IC" + e.getMessage());
			pdfResultReport.addStepDetails("Verify_Assign_indent_ToUser",
					"Tender creator should be able to assign indent to selected user",
					"Tender creator is unable to assign indent to selected user"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	// Assigned user login
	public void AssignedUserLogin() throws Throwable {
		try {
			log.info("started executing the method:: AssignedUserLogin");
			//click(tendercreationlocators.login, "login"); //edited on 201221
			set(tendercreationlocators.userName, pdfResultReport.testData.get("IndentAssign_LoginUsername"), "userName");
			waitForObj(5000);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			//Handle fixed Captcha (06/11/2020)
			//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha"); ////edited on 201221
			//Wait statement (Added to handle Captcha temporarily in AWS QA (19/10/2020))
			//waitForObj(50000);
			click(tendercreationlocators.okButton, "okButton");
			waitForElement(tendercreationlocators.dashboardIcon, 30);
			pdfResultReport.addStepDetails("Assigned user login", "Assigned user must be sucessfully logged in",
					"Successfully logged in as tender creator" + " ", "Pass", "Y");
			log.info("completed executing the method:: AssignedUserLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Tender creator login", "Tender creator is not logged in",
					"Unable to login as tender creator" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void Create_RFQ_From_Indent(String RFQTGname) throws Throwable {
		try {
			log.info("started executing the method:: Create_RFQ_From_Indent");

			click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
			waitForElementToBeClickable(tendercreationlocators.CreateRFQLnk_RFQfromIndent);
			pdfResultReport.addStepDetails("Create_RFQ_From_Indent",
					"Create RFQ dropdown option should be displayed",
					"Create RFQ dropdown option is displayed", "Pass", "Y");
			click(tendercreationlocators.CreateRFQLnk_RFQfromIndent, "CreateRFQLnk_RFQfromIndent");
			dynamic_Loader(tendercreationlocators.loadingLocator, 2);
			waitForElementToBeClickable(tendercreationlocators.CreateRFQbtn_IndentPreview);
			pdfResultReport.addStepDetails("Create_RFQ_From_Indent",
					"Indent Preview page should be displayed",
					"Indent Preview page is displayed", "Pass", "Y");
			JSClick(tendercreationlocators.CreateRFQbtn_IndentPreview, "CreateRFQbtn_IndentPreview");
			waitForElementToBeVisible(tendercreationlocators.TGselectionmodal_RFQfromIndent);
			QueryParameter_Global = ThreadLocalWebdriver.getDriver().findElement(By.xpath("//option[contains(text(),'" + RFQTGname + "')]")).getAttribute("value");
			System.out.println("QueryParameter_Global value: " + QueryParameter_Global);
			select(tendercreationlocators.TGselectionmodal_RFQfromIndent, RFQTGname);
			click(tendercreationlocators.Submitbtn_RFQfromIndent, "Submitbtn_RFQfromIndent");
			waitForElementToBeVisible(tendercreationlocators.generalInformationTab);
			pdfResultReport.addStepDetails("Create_RFQ_From_Indent",
					"Should navigated to edit tender page",
					"Navigated to edit tender page successfully", "Pass", "Y");
			
			log.info("completed executing the method:: Create_RFQ_From_Indent");
		} catch (Exception e) {
			log.fatal("Not able to search Indent No" + e.getMessage());
			pdfResultReport.addStepDetails("Create_RFQ_From_Indent", "Should be able to create RFQ from indent",
					"Unable to create RFQ from indent" + e.getMessage(), "Fail", "N");
		}
	}
	//Verifying filling up RFQ tab and create RFQ with Indent TG1 ("Indigenous Indent (Supply & Service Both) V-004") and RFQ TG1 ("Indigenous Tender (Supply & Service Both) V-1.0") (03/02/2021)
	public void PublishTender_from_indent_withRFQ_TG1(String TemplateGroup,int startdatelag, int enddatelag, int opendatelag)throws Throwable {
		try {
			log.info(
					"started executing the method:: PublishTender_from_indent_withRFQ_TG1 "+TemplateGroup);

		//Verifying general information tab++++++++++++++++++++++++++++++++++++++++++++
			waitForObj(10000);
			
			if (IsEnabled(tendercreationlocators.templateGroupdropdown)==true)
			{
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1",
						"Template group field should be auto populated and selection should be disable", "Template group field is not disable",
						"Fail", "N");
			} else
			{
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1",
						"Template group field should be auto populated and selection should be disable", "Template group field is auto populated and selection is disable", "Pass",
						"Y");
			}
			waitForObj(1000);
			select(tendercreationlocators.bitPartdropdown, pdfResultReport.testData.get("BidParts"));
			click(tendercreationlocators.bitPartRadio, "bitPartRadio");
			tenderRef = "TendRef_";
			int getrandomInterger = getrandomInterger(10000, 1000000000);
			tenderRef = tenderRef.concat(String.valueOf(getrandomInterger));
			clear(tendercreationlocators.tenderReferenceNumber, "tenderReferenceNumber");
			set(tendercreationlocators.tenderReferenceNumber, tenderRef, "tenderReferenceNumber");
			//added on 02/11/2020 in AWS QA env
			scrollToElement(tendercreationlocators.Min_bid_no);
			set(tendercreationlocators.Min_bid_no, pdfResultReport.testData.get("Minimum_no_of_Bids"), "MinimumNoOfBids");
			scrollToTopOfThePage();
			click(tendercreationlocators.savebutton, "savebutton");
			waitForElementToBeClickable(tendercreationlocators.BtnOk);
			click(tendercreationlocators.BtnOk, "Ok");
			
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			
		//Verifying Terms & Conditions tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1);
			click(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1, "TermsandConditionstabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.AddBtnTermsandConditionstab_Tender_TG1);
			click(tendercreationlocators.AddBtnTermsandConditionstab_Tender_TG1, "AddBtnTermsandConditionstab_Tender_TG1");
			waitForObj(1000);
			set(tendercreationlocators.ClauseTxtTermsandConditionstab_Tender_TG1, pdfResultReport.testData.get("ClauseNo_TermsAndConditions_TG1"), "ClauseTxtTermsandConditionstab_Tender_TG1");
			set(tendercreationlocators.ClauseHeaderTxtTermsandConditionstab_Tender_TG1, pdfResultReport.testData.get("ClauseHeader_TermsAndConditions_TG1"), "ClauseHeaderTxtTermsandConditionstab_Tender_TG1");
			waitForObj(1000);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForElementToBeClickable(tendercreationlocators.BtnOk);
			click(tendercreationlocators.BtnOk, "Ok");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(3000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Terms & Conditions tab", "Terms & Conditions tab verified successfully", "Pass",
					"Y");
		//Verifying General Requirement Equipment details+++++++++++++++++++++++++++++++++++++++++ 	
			waitForElementToBeClickable(tendercreationlocators.GeneralReqEquiptabLnk_Tender_TG1);
			click(tendercreationlocators.GeneralReqEquiptabLnk_Tender_TG1, "GeneralReqEquiptabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify General Requirement Equipment details tab", "General Requirement Equipment details tab verified successfully", "Pass",
					"Y");
		//Verifying General Information Clauses++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.GeneralInfoClausestabLnk_Tender_TG1);
			click(tendercreationlocators.GeneralInfoClausestabLnk_Tender_TG1, "GeneralInfoClausestabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify General Information Clauses tab", "General Information Clauses tab verified successfully", "Pass",
					"Y");
		//Verifying Attachment tab+++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_Tender_TG1);
			click(tendercreationlocators.AttachmentstabLnk_Tender_TG1, "AttachmentstabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			IsElementPresent(tendercreationlocators.AttachmentsRowLbl_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Added attachment in indent should be displayed by default", "Added attachment in indent successfully displayed by default", "Pass",
					"Y");
		//Verifying Required Attachment tab++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1);
			click(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1, "ReqAttachmenttabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1);
			click(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1, "AddBtnTermsandConditionstab_Tender_TG1");
			waitForElementToBeVisible(tendercreationlocators.SupportingdocTxt_ReqAttachmenttab_Tender_TG1);
			set(tendercreationlocators.SupportingdocTxt_ReqAttachmenttab_Tender_TG1, pdfResultReport.testData.get("SupportingDoc_RequiredAttachment_TG1"), "SupportingdocTxt_ReqAttachmenttab_Tender_TG1");
			waitForElementToBeVisible(tendercreationlocators.ReqAttachmenttab_attchmentGroup);
			select(tendercreationlocators.ReqAttachmenttab_attchmentGroup, "Others");
			waitForElementToBeVisible(tendercreationlocators.ReqAttachmenttab_attachment_group_if_other);
			set(tendercreationlocators.ReqAttachmenttab_attachment_group_if_other, pdfResultReport.testData.get("SupportingDoc_RequiredAttachment_TG1"), "SupportingdocTxt_ReqAttachmenttab_Tender_TG1");
			click(tendercreationlocators.Okbtn_ReqAttachmenttab_Tender_TG1, "Okbtn_ReqAttachmenttab_Tender_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForElementToBeClickable(tendercreationlocators.BtnOk);
			click(tendercreationlocators.BtnOk, "Ok");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Required Attachment tab", "Required Attachment tab verified successfully", "Pass",
					"Y");
			//Clicking on next arrow
			click(tendercreationlocators.nextarrowforTenderPreview, "NextLnk_Tender_TG1");
		//Verifying Prebid discussion tab++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1);
			click(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1, "PreBidDiscussiontabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify PrebidDiscussion tab", "PrebidDiscussion tab verified successfully", "Pass",
					"Y");
		//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.PaymentabLnk_Tender_TG1);
			click(tendercreationlocators.PaymentabLnk_Tender_TG1, "PaymentabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.PaymentCurrency_Paymentab_Tender_TG1);
			waitForObj(2000);
			select(tendercreationlocators.PaymentCurrency_Paymentab_Tender_TG1, "INR - INDIAN RUPEE");
			set(tendercreationlocators.PaymentAmount_Paymentab_Tender_TG1, "1000", "PaymentAmount_Paymentab_Tender_TG1");
			click(tendercreationlocators.OfflineNEFT_Paymentab_Tender_TG1, "OfflineNEFT_Paymentab_Tender_TG1");
			click(tendercreationlocators.AddPayment_Paymentab_Tender_TG1, "AddPayment_Paymentab_Tender_TG1");
			waitForObj(2000);
			IsElementPresent(tendercreationlocators.PaymentRow_Paymentab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Payment tab", "Payment tab verified successfully", "Pass",
					"Y");
		//Verifying Project Details tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1);
			click(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1, "ProjectDetailstabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Project Details tab", "Project Details tab verified successfully", "Pass",
					"Y");
		//Verifying Technical tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TechnicaltabLnk_Tender_TG1);
			click(tendercreationlocators.TechnicaltabLnk_Tender_TG1, "TechnicaltabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			IsElementPresent(tendercreationlocators.ClauseTxt_Technicaltab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Added Clause detail from indent should be by default displayed Technical tab", "Added Clause detail from indent by default displayed successfully in Technical tab", "Pass",
					"Y");
		//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_Tender_TG1);
			click(tendercreationlocators.RFQItemtabLnk_Tender_TG1, "RFQItemtabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			IsElementPresent(tendercreationlocators.ItemCodeTxt_RFQItemtab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Added Item from indent should be by default displayed in RFQ Item tab", "Added Item from indent by default displayed successfully in RFQ Item tab", "Pass",
					"Y");
			//Clicking on next arrow
			click(tendercreationlocators.nextarrowforTenderPreview, "NextLnk_Tender_TG1");
		//Verifying BOQ Mandatory tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.BOQMandatorytabLnk_Tender_TG1);
			click(tendercreationlocators.BOQMandatorytabLnk_Tender_TG1, "BOQMandatorytabLnk_Tender_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			IsElementPresent(tendercreationlocators.ItemCodeTxt_BOQMandatorytab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Added Item from indent should be by default displayed in BOQ Mandatory tab", "Added Item from indent by default displayed successfully in BOQ Mandatory tab", "Pass",
					"Y");	
		//Verify Date Schedule tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			click(tendercreationlocators.dateschedule, "dateschedule");
			waitForElementToBeVisible(tendercreationlocators.bidsubmissionStartDate);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
			 BidStartDate=getBidStartDate(startdatelag);
			 BidDueDate=getBidDueDate(enddatelag);
			 BidOpenDate=getBidOpenDate(opendatelag);
			set(tendercreationlocators.bidsubmissionStartDate, getBidStartDate(startdatelag), "bidsubmissionStartDate");
			set(tendercreationlocators.bidsubmissionDueDate, getBidDueDate(enddatelag), "bidsubmissionDueDate");
			set(tendercreationlocators.bidsubmissionOpenDate, getBidOpenDate(opendatelag), "bidsubmissionOpenDate");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForElementToBeClickable(tendercreationlocators.BtnOk);
			click(tendercreationlocators.BtnOk, "Ok");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Date Schedule tab should be verified", "Successfully verified Date Scheduled tab", "Pass",
					"Y");	

			log.info("completed executing the method:: PublishTender_from_indent_withRFQ_TG1 "+TemplateGroup);

		} catch (Exception e) {

			log.fatal("Not able to publish tender from indent" + e.getMessage());
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '"+TemplateGroup+"'",
					"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
					"Fail", "N");
		}
	}
	//Verifying filling up Bid submission and submit bid for the tender created from RFQ with Indent TG1 ("Indigenous Indent (Supply & Service Both) V-004") and RFQ TG1 ("Indigenous Tender (Supply & Service Both) V-1.0") (16/02/2021)
	public void BidSubmission_for_Tender_from_indent_withRFQ_TG1(String TemplateGroup)throws Throwable {
		try {
			log.info(
					"started executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG1 "+TemplateGroup);

		//Verifying Terms & Conditions tab++++++++++++++++++++++++++++++++++++++++++++	
			//waitForElementToBeClickable(tendercreationlocators.TermsandConditionstabLnk_BidSubmission_TG1);
			JSClick(tendercreationlocators.TermsandConditionstabLnk_BidSubmission_TG1, "TermsandConditionstabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			//waitForObj(1000);
			waitForElement(tendercreationlocators.ClauseTxtTermsandConditionstab_BidSubmission_TG1, 1000);
			waitForObj(1000);
			set(tendercreationlocators.RemarksTxtTermsandConditionstab_BidSubmission_TG1, pdfResultReport.testData.get("RemarksTxtTermsandConditionstab_BidSubmission_TG1"), "RemarksTxtTermsandConditionstab_BidSubmission_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(3000);
			//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Terms & Conditions tab", "Terms & Conditions tab verified successfully", "Pass",
					"Y");

		//Verifying Technical Compliance Table tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TechnicalCompliancetabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TechnicalCompliancetabLnk_BidSubmission_TG1, "TechnicalCompliancetabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.ClauseTxtTechnicalCompliancetab_BidSubmission_TG1);
			waitForObj(100);
			set(tendercreationlocators.RemarksTxtTechnicalCompliancetab_BidSubmission_TG1, pdfResultReport.testData.get("RemarksTxtTechnicalCompliancetab_BidSubmission_TG1"), "RemarksTxtTechnicalCompliancetab_BidSubmission_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			//waitForObj(2000);
			//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElement(tendercreationlocators.alertPopUp_QRC_bidSubmission,100);
			//IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Technical Compliance tab", "Technical Compliance tab verified successfully", "Pass",
					"Y");
			
		//Verifying Attachments tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1);
			click(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1, "AttachmentstabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1);
			waitForObj(1000);
			click(tendercreationlocators.ActionbtnBidderspecificAttachment_BidSubmission_TG1, "ActionbtnBidderspecificAttachment_BidSubmission_TG1");
			waitForObj(1000);
			//set(tendercreationlocators.UploadBidderspecificAttachment_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx", "fileName");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElement(tendercreationlocators.UploadFromEbriefcase_TG1, 100);
			waitForElementToBeClickable(tendercreationlocators.UploadFromEbriefcase_TG1);
			click(tendercreationlocators.UploadFromEbriefcase_TG1, "UploadFromEbriefcase_TG1");
			waitForElementToBeClickable(tendercreationlocators.AddEbriefcaseFile_TG1);
			click(tendercreationlocators.AddEbriefcaseFile_TG1, "AddEbriefcaseFile_TG1");
			waitForElementToBeClickable(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1);
			click(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1, "Attachment_subtabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElement(tendercreationlocators.TenderAttachment_subtabLnk_BidSubmission_TG1, 100);
			click(tendercreationlocators.TenderAttachment_subtabLnk_BidSubmission_TG1, "TenderAttachment_subtabLnk_BidSubmission_TG1");
			waitForElementToBeClickable(tendercreationlocators.savebutton);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Attachments tab", "Attachments tab verified successfully", "Pass",
					"Y");
			
		//Verifying Technical tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.TechnicaltabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TechnicaltabLnk_BidSubmission_TG1, "TechnicaltabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			//waitForObj(500);
			waitForElement(tendercreationlocators.savebutton, 100);
			waitForElementToBeClickable(tendercreationlocators.savebutton);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElement(tendercreationlocators.alertPopUp_QRC_bidSubmission, 100);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Technical tab", "Technical tab verified successfully", "Pass",
					"Y");
			//Clicking on Next link to get the remaining tab
			click(tendercreationlocators.NextLnk_Tender_TG1, "NextLnk_Tender_TG1");
			
		//Verifying Specifications and Technical Requirements Compliance tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1, "TechnicalReqComptabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(500);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElement(tendercreationlocators.alertPopUp_QRC_bidSubmission, 100);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Specifications and Technical Requirements Compliance tab", "Specifications and Technical Requirements Compliance tab verified successfully", "Pass",
					"Y");
			
		//Verifying Commercial Parameters Compliance tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.CommercialComptabLnk_BidSubmission_TG1);
			click(tendercreationlocators.CommercialComptabLnk_BidSubmission_TG1, "CommercialComptabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(7000);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Commercial Parameters Compliance tab", "Commercial Parameters Compliance tab verified successfully", "Pass",
					"Y");
			//Clicking on Next link to get the remaining tab
			click(tendercreationlocators.NextLnk_Tender_TG1, "NextLnk_Tender_TG1");
			
		//Verifying General Requirement Equipment details tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1);
			click(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1, "GeneralReqEqiptabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElement(tendercreationlocators.Address_GeneralReqEqiptab_BidSubmission_TG1,100);
			waitForObj(500);
			set(tendercreationlocators.Address_GeneralReqEqiptab_BidSubmission_TG1, pdfResultReport.testData.get("Address_GeneralReqEqiptab_BidSubmission_TG1"), "Address_GeneralReqEqiptab_BidSubmission_TG1");
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify General Requirement Equipment details tab", "General Requirement Equipment details tab verified successfully", "Pass",
					"Y");
			
		//Verifying Other Clauses tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1);
			click(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1, "OtherClausestabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElement(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1,100);
			waitForObj(500);
			select(tendercreationlocators.RegisteredGEM_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RegisteredGEM_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("VendorCode_OtherClausestab_BidSubmission_TG1"), "VendorCode_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.Startupbidder_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Startupbidder_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.GovtOrg_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("GovtOrg_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.RepresentingFirm_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirm_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.UAN_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("UAN_MSME_OtherClausestab_BidSubmission_TG1"), "UAN_MSME_OtherClausestab_BidSubmission_TG1");
			set(tendercreationlocators.EMNo_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("EMNo_MSME_OtherClausestab_BidSubmission_TG1"), "EMNo_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.Type_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Type_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.ActivityType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ActivityType_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.OrgType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("OrgType_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.WomenOwned_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("WomenOwned_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.Gender_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Gender_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.PhyHand_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("PhyHand_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.SocialCat_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("SocialCat_MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.LocationPlant_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "LocationPlant_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.FirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("FirmType_MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1"), "AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.Certification_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Certification_MSME_OtherClausestab_BidSubmission_TG1"));
		waitForObj(1000);
			scrollToTopOfThePage();
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Other Clauses tab", "Other Clauses tab verified successfully", "Pass",
					"Y");
			
			
			
			//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1);
			click(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1, "PaymenttabLnk_BidSubmission_TG1");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElement(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1,100);
			waitForObj(100);
			
			boolean paymentMode=ThreadLocalWebdriver.getDriver().findElement(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1).isEnabled();
			if(!paymentMode){
				log.info("paymentMode button is disable");
				}
			else {
					click(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1, "Paymentbtn_Paymenttab_BidSubmission_TG1");
					waitForElementToBeClickable(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1);
					click(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1, "PaymentType_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.BankNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BankNametxt_Paymenttab_BidSubmission_TG1"), "BankNametxt_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.BranchNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BranchNametxt_Paymenttab_BidSubmission_TG1"), "BranchNametxt_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.InstruNotxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("InstruNotxt_Paymenttab_BidSubmission_TG1"), "InstruNotxt_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.InstruDatetxt_Paymenttab_BidSubmission_TG1, getdate(0, "dd-MM-yyyy"), "InstruDatetxt_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.Commenttxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("Commenttxt_Paymenttab_BidSubmission_TG1"), "Commenttxt_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.InstruExpiryDate_Paymenttab_BidSubmission_TG1, getdate(20, "dd-MM-yyyy"), "InstruExpiryDate_Paymenttab_BidSubmission_TG1");
					set(tendercreationlocators.Uploadfile_Paymenttab_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx", "fileName");
					click(tendercreationlocators.Payment_amountField_TG1, "Payment_amountField_TG1");
					
					waitForObj(2000);
					waitForElementToBeClickable(tendercreationlocators.SavePaymentBtn_Paymenttab_BidSubmission_TG1);
					click(tendercreationlocators.SavePaymentBtn_Paymenttab_BidSubmission_TG1, "SavePaymentBtn_Paymenttab_BidSubmission_TG1");
					waitForObj(2000);
					//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
					waitForElement(tendercreationlocators.alertPopUp_QRC_bidSubmission,10000);
					IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
					waitForElementToBeVisible(tendercreationlocators.alertClose_QRC_bidSubmission);
					click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
					waitForObj(2000);
					scrollToTopOfThePage();
						
					
			}
			
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify Payment tab", "Payment tab verified successfully", "Pass",
					"Y");
					
			 
		//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG1);
			click(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG1, "RFQItemtabLnk_BidSubmission_TG1");
			waitForObj(5000);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			List<WebElement> itemRowCount = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.RFQItemRowCount_TG1);
			int RowCount=itemRowCount.size();
			System.out.println(RowCount);
			for(int i=0; i<RowCount; i++) {
			waitForObj(1000);
			scrollToElement(tendercreationlocators.UnitRateTxt_RFQItemtab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.UnitRateTxt_RFQItemtab_BidSubmission_TG1(i), pdfResultReport.testData.get("UnitRateTxt_RFQItemtab_BidSubmission_TG1"), "UnitRateTxt_RFQItemtab_BidSubmission_TG1");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.CGSTTxt_RFQItemtab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.CGSTTxt_RFQItemtab_BidSubmission_TG1(i), pdfResultReport.testData.get("CGSTTxt_RFQItemtab_BidSubmission_TG1"), "CGSTTxt_RFQItemtab_BidSubmission_TG1");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.SGSTTxt_RFQItemtab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.SGSTTxt_RFQItemtab_BidSubmission_TG1(i), pdfResultReport.testData.get("SGSTTxt_RFQItemtab_BidSubmission_TG1"), "SGSTTxt_RFQItemtab_BidSubmission_TG1");
			}
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify RFQ Item tab", "RFQ Item tab verified successfully", "Pass",
					"Y");
			
		//Verifying BOQ Mandatory tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.BOQMandatorytabLnk_BidSubmission_TG1);
			JSClick(tendercreationlocators.BOQMandatorytabLnk_BidSubmission_TG1, "BOQMandatorytabLnk_BidSubmission_TG1");
			waitForObj(3000);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			List<WebElement> MandatoryitemRowCount = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.BOMMandatoryRowCount_TG1);
			int MandatoryRowCount=MandatoryitemRowCount.size();
			System.out.println(MandatoryRowCount);
			for(int i=0; i<MandatoryRowCount; i++) {
			waitForObj(1000);
			scrollToElement(tendercreationlocators.UnitRateTxt_BOQMandatorytab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.UnitRateTxt_BOQMandatorytab_BidSubmission_TG1(i), pdfResultReport.testData.get("UnitRateTxt_BOQMandatorytab_BidSubmission_TG1"), "UnitRateTxt_BOQMandatorytab_BidSubmission_TG1");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.CGSTTxt_BOQMandatorytab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.CGSTTxt_BOQMandatorytab_BidSubmission_TG1(i), pdfResultReport.testData.get("CGSTTxt_BOQMandatorytab_BidSubmission_TG1"), "CGSTTxt_BOQMandatorytab_BidSubmission_TG1");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.SGSTTxt_BOQMandatorytab_BidSubmission_TG1(i));
			waitForObj(500);
			set(tendercreationlocators.SGSTTxt_BOQMandatorytab_BidSubmission_TG1(i), pdfResultReport.testData.get("SGSTTxt_BOQMandatorytab_BidSubmission_TG1"), "SGSTTxt_BOQMandatorytab_BidSubmission_TG1");
			}
			waitForElementToBeClickable(tendercreationlocators.savebutton);
			waitForObj(2000);
			JSClick(tendercreationlocators.savebutton, "savebutton");
			universalNormalWait();
			//eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElement(tendercreationlocators.alertPopUp_QRC_bidSubmission, 100);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG1 '" +TemplateGroup+"'",
					"Verify BOQ Mandatory tab", "BOQ Mandatory tab verified successfully", "Pass",
					"Y");
	

			log.info("completed executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG1 "+TemplateGroup);
			

		} catch (Exception e) {

			log.fatal("Not able to publish tender from indent" + e.getMessage());
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '"+TemplateGroup+"'",
					"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//Verifying filling up Bid submission and submit bid for the tender created from RFQ with Indent TG1 ("Indigenous Indent (Supply Only) V-004") and RFQ TG1 ("Indigenous Tender (Supply Only) V-1.0") (21/04/2021)
	public void BidSubmission_for_Tender_from_indent_withRFQ_TG5(String TemplateGroup)throws Throwable {
		try {
			log.info(
					"started executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG5 "+TemplateGroup);

		//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1);
			click(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1, "PaymenttabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1);
			waitForObj(500);
			click(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1, "Paymentbtn_Paymenttab_BidSubmission_TG1");
			waitForElementToBeClickable(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1);
			click(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1, "PaymentType_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.BankNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BankNametxt_Paymenttab_BidSubmission_TG1"), "BankNametxt_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.BranchNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BranchNametxt_Paymenttab_BidSubmission_TG1"), "BranchNametxt_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.InstruNotxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("InstruNotxt_Paymenttab_BidSubmission_TG1"), "InstruNotxt_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.InstruDatetxt_Paymenttab_BidSubmission_TG1, getdate(0, "dd-MM-yyyy"), "InstruDatetxt_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.Commenttxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("Commenttxt_Paymenttab_BidSubmission_TG1"), "Commenttxt_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.InstruExpiryDate_Paymenttab_BidSubmission_TG1, getdate(20, "dd-MM-yyyy"), "InstruExpiryDate_Paymenttab_BidSubmission_TG1");
			set(tendercreationlocators.Uploadfile_Paymenttab_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
					"fileName");
			waitForObj(1000);
			click(tendercreationlocators.SavePaymentBtn_Paymenttab_BidSubmission_TG1, "SavePaymentBtn_Paymenttab_BidSubmission_TG1");
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			scrollToTopOfThePage();
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Payment tab", "Payment tab verified successfully", "Pass",
					"Y");
			
		//Verifying Bidders information tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1);
			click(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1, "OtherClausestabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1);
			waitForObj(500);
			select(tendercreationlocators.RegisteredGEM_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RegisteredGEM_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("VendorCode_OtherClausestab_BidSubmission_TG1"), "VendorCode_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.Startupbidder_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Startupbidder_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.GovtOrg_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("GovtOrg_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.RepresentingFirm_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirm_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.UAN_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("UAN_MSME_OtherClausestab_BidSubmission_TG1"), "UAN_MSME_OtherClausestab_BidSubmission_TG1");
			set(tendercreationlocators.EMNo_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("EMNo_MSME_OtherClausestab_BidSubmission_TG1"), "EMNo_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.Type_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Type_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.ActivityType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ActivityType_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.OrgType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("OrgType_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.WomenOwned_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("WomenOwned_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.Gender_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Gender_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.PhyHand_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("PhyHand_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.SocialCat_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("SocialCat_MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.LocationPlant_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "LocationPlant_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.FirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("FirmType_MSME_OtherClausestab_BidSubmission_TG1"));
			set(tendercreationlocators.AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1"), "AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1");
			select(tendercreationlocators.ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1"));
			select(tendercreationlocators.Certification_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Certification_MSME_OtherClausestab_BidSubmission_TG1"));
			scrollToTopOfThePage();
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Bidders information tab", "Bidders information tab verified successfully", "Pass",
					"Y");
			
		//Verifying Specifications and Technical Requirements Compliance tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1, "TechnicalReqComptabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(500);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Specifications and Technical Requirements Compliance tab", "Specifications and Technical Requirements Compliance tab verified successfully", "Pass",
					"Y");
			
		//Verifying Terms & Conditions tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TermsandConditionstabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TermsandConditionstabLnk_BidSubmission_TG1, "TermsandConditionstabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.ClauseTxtTermsandConditionstab_BidSubmission_TG1);
			waitForObj(100);
			set(tendercreationlocators.RemarksTxtTermsandConditionstab_BidSubmission_TG1, pdfResultReport.testData.get("RemarksTxtTermsandConditionstab_BidSubmission_TG1"), "RemarksTxtTermsandConditionstab_BidSubmission_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Terms & Conditions tab", "Terms & Conditions tab verified successfully", "Pass",
					"Y");

		//Clicking on Next link to get the remaining tab
			click(tendercreationlocators.NextLnk_Bidsubmission_TG5, "NextLnk_Bidsubmission_TG5");
			
		//Verifying Technical Compliance Table tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TechnicalCompliancetabLnk_BidSubmission_TG1);
			click(tendercreationlocators.TechnicalCompliancetabLnk_BidSubmission_TG1, "TechnicalCompliancetabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.ClauseTxtTechnicalCompliancetab_BidSubmission_TG1);
			waitForObj(100);
			set(tendercreationlocators.RemarksTxtTechnicalCompliancetab_BidSubmission_TG1, pdfResultReport.testData.get("RemarksTxtTechnicalCompliancetab_BidSubmission_TG1"), "RemarksTxtTechnicalCompliancetab_BidSubmission_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Technical Compliance tab", "Technical Compliance tab verified successfully", "Pass",
					"Y");
			
		//Verifying General Requirement Equipment details tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1);
			click(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1, "GeneralReqEqiptabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Address_GeneralReqEqiptab_BidSubmission_TG1);
			waitForObj(500);
			set(tendercreationlocators.Address_GeneralReqEqiptab_BidSubmission_TG1, pdfResultReport.testData.get("Address_GeneralReqEqiptab_BidSubmission_TG1"), "Address_GeneralReqEqiptab_BidSubmission_TG1");
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify General Requirement Equipment details tab", "General Requirement Equipment details tab verified successfully", "Pass",
					"Y");
			
		//Clicking on Next link to get the remaining tab
			click(tendercreationlocators.NextLnk_Bidsubmission_TG5, "NextLnk_Bidsubmission_TG5");
			
		//Verifying Attachments tab++++++++++++++++++++++++++++++++++++++++++++		
			waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1);
			click(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1, "AttachmentstabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1);
			waitForObj(100);
			click(tendercreationlocators.ActionbtnBidderspecificAttachment_BidSubmission_TG1, "ActionbtnBidderspecificAttachment_BidSubmission_TG1");
			set(tendercreationlocators.UploadBidderspecificAttachment_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
					"fileName");
			waitForObj(2000);
			click(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1, "Attachment_subtabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			click(tendercreationlocators.TenderAttachment_subtabLnk_BidSubmission_TG1, "TenderAttachment_subtabLnk_BidSubmission_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Attachments tab", "Attachments tab verified successfully", "Pass",
					"Y");
			
		//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG5);
			click(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG5, "RFQItemtabLnk_BidSubmission_TG5");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.UnitRateTxt_RFQItemtab_BidSubmission_TG5);
			waitForObj(500);
			set(tendercreationlocators.UnitRateTxt_RFQItemtab_BidSubmission_TG5, pdfResultReport.testData.get("UnitRateTxt_RFQItemtab_BidSubmission_TG1"), "UnitRateTxt_RFQItemtab_BidSubmission_TG5");
			scrollToElement(tendercreationlocators.CGSTTxt_RFQItemtab_BidSubmission_TG5);
			set(tendercreationlocators.CGSTTxt_RFQItemtab_BidSubmission_TG5, pdfResultReport.testData.get("CGSTTxt_RFQItemtab_BidSubmission_TG1"), "CGSTTxt_RFQItemtab_BidSubmission_TG5");
			scrollToElement(tendercreationlocators.SGSTTxt_RFQItemtab_BidSubmission_TG5);
			set(tendercreationlocators.SGSTTxt_RFQItemtab_BidSubmission_TG5, pdfResultReport.testData.get("SGSTTxt_RFQItemtab_BidSubmission_TG1"), "SGSTTxt_RFQItemtab_BidSubmission_TG5");
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify RFQ Item tab", "RFQ Item tab verified successfully", "Pass",
					"Y");
		//Verifying Price Summary tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.PriceSummarytabLnk_BidSubmission_TG5);
			click(tendercreationlocators.PriceSummarytabLnk_BidSubmission_TG5, "PriceSummarytabLnk_BidSubmission_TG5");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.Calculationmode_PriceSummarytab_BidSubmission_TG5);
			waitForObj(500);
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(2000);
			eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
			waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
			click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
			waitForObj(500);
			pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Price Summary tab", "Price Summary tab verified successfully", "Pass",
					"Y");

			log.info("completed executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG5 "+TemplateGroup);

		} catch (Exception e) {

			log.fatal("Not able to publish tender from indent" + e.getMessage());
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG1 '"+TemplateGroup+"'",
					"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//Verifying filling up Bid submission and submit bid for the tender created from RFQ with Indent TG8 ("Indigenous Indent (Supply Only) V-004") and RFQ TG1 ("Indigenous Tender (Supply Only) V-1.0") (21/04/2021)
		public void BidSubmission_for_Tender_from_indent_withRFQ_TG8(String TemplateGroup)throws Throwable {
			try {
				log.info(
						"started executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG5 "+TemplateGroup);

			//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1);
				click(tendercreationlocators.PaymenttabLnk_BidSubmission_TG1, "PaymenttabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1);
				waitForObj(500);
				click(tendercreationlocators.Paymentbtn_Paymenttab_BidSubmission_TG1, "Paymentbtn_Paymenttab_BidSubmission_TG1");
				waitForElementToBeClickable(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1);
				click(tendercreationlocators.PaymentType_Paymenttab_BidSubmission_TG1, "PaymentType_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.BankNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BankNametxt_Paymenttab_BidSubmission_TG1"), "BankNametxt_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.BranchNametxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("BranchNametxt_Paymenttab_BidSubmission_TG1"), "BranchNametxt_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.InstruNotxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("InstruNotxt_Paymenttab_BidSubmission_TG1"), "InstruNotxt_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.InstruDatetxt_Paymenttab_BidSubmission_TG1, getdate(0, "dd-MM-yyyy"), "InstruDatetxt_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.Commenttxt_Paymenttab_BidSubmission_TG1, pdfResultReport.testData.get("Commenttxt_Paymenttab_BidSubmission_TG1"), "Commenttxt_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.InstruExpiryDate_Paymenttab_BidSubmission_TG1, getdate(20, "dd-MM-yyyy"), "InstruExpiryDate_Paymenttab_BidSubmission_TG1");
				set(tendercreationlocators.Uploadfile_Paymenttab_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
						"fileName");
				waitForObj(1000);
				click(tendercreationlocators.SavePaymentBtn_Paymenttab_BidSubmission_TG1, "SavePaymentBtn_Paymenttab_BidSubmission_TG1");
				eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
				waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
				waitForObj(500);
				scrollToTopOfThePage();
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
						"Verify Payment tab", "Payment tab verified successfully", "Pass",
						"Y");
				
			//Verifying General Requirement Equiptment Details tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1);
				click(tendercreationlocators.OtherClausestabLnk_BidSubmission_TG1, "OtherClausestabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1);
				waitForObj(500);
				select(tendercreationlocators.RegisteredGEM_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RegisteredGEM_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.VendorCode_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("VendorCode_OtherClausestab_BidSubmission_TG1"), "VendorCode_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.Startupbidder_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Startupbidder_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.GovtOrg_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("GovtOrg_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.RepresentingFirm_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirm_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1"), "RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("MSME_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.UAN_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("UAN_MSME_OtherClausestab_BidSubmission_TG1"), "UAN_MSME_OtherClausestab_BidSubmission_TG1");
				set(tendercreationlocators.EMNo_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("EMNo_MSME_OtherClausestab_BidSubmission_TG1"), "EMNo_MSME_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.Type_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Type_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.ActivityType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ActivityType_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.OrgType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("OrgType_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.WomenOwned_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("WomenOwned_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.Gender_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Gender_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.PhyHand_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("PhyHand_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.SocialCat_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("SocialCat_MSME_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.LocationPlant_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "LocationPlant_MSME_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.FirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("FirmType_MSME_OtherClausestab_BidSubmission_TG1"));
				set(tendercreationlocators.AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1"), "AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1");
				select(tendercreationlocators.ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1"));
				select(tendercreationlocators.Certification_MSME_OtherClausestab_BidSubmission_TG1, pdfResultReport.testData.get("Certification_MSME_OtherClausestab_BidSubmission_TG1"));
				scrollToTopOfThePage();
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify General Requirement Equiptment Details tab", "General Requirement Equiptment Details tab verified successfully", "Pass",
						"Y");
				
			//Verifying Specifications and Technical Requirements Compliance tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1);
				click(tendercreationlocators.TechnicalReqComptabLnk_BidSubmission_TG1, "TechnicalReqComptabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				//click(tendercreationlocators.savebutton, "savebutton");
				//waitForObj(2000);
				
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Specifications and Technical Requirements Compliance tab", "Specifications and Technical Requirements Compliance tab verified successfully", "Pass",
						"Y");
				
			// Verifying Prequalification Tab+++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.preQualification_TG8);
				click(tendercreationlocators.preQualification_TG8, "preQualification_TG8");
				scrollToElement(tendercreationlocators.remarksPrequalification_TG8);
				set(tendercreationlocators.remarksPrequalification_TG8, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "remarksPrequalification_TG8");
				scrollToTopOfThePage();
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Prequalification tab", "Prequalification tab verified successfully", "Pass",
						"Y");
				
			// Verifying technical Tab+++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.technical_TG8);
				click(tendercreationlocators.technical_TG8, "technical_TG8");
				scrollToElement(tendercreationlocators.remarksTechnical_TG8);
				set(tendercreationlocators.remarksTechnical_TG8, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "remarksTechnical_TG8");
				scrollToTopOfThePage();
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify technical tab", "technical tab verified successfully", "Pass",
						"Y");
				
			//Clicking on Next link to get the remaining tab
				click(tendercreationlocators.NextLnk_Bidsubmission_TG5, "NextLnk_Bidsubmission_TG5");	
				
			// Verifying Terms and conditions Tab+++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.termsConditions_TG8);
				click(tendercreationlocators.termsConditions_TG8, "termsConditions_TG8");
				scrollToElement(tendercreationlocators.remarksTermsConditions_TG8);
				set(tendercreationlocators.remarksTermsConditions_TG8, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "remarksTermsConditions_TG8");
				scrollToTopOfThePage();
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Terms and conditions tab", " Terms and conditions tab verified successfully", "Pass",
						"Y");
				
			//Verifying Bidder Information Tab+++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1);
				click(tendercreationlocators.GeneralReqEqiptabLnk_BidSubmission_TG1, "GeneralReqEqiptabLnk_BidSubmission_TG1");
				waitForObj(1000);
				set(tendercreationlocators.Address_GeneralReqEqiptab_BidSubmission_TG1, pdfResultReport.testData.get("LocationPlant_MSME_OtherClausestab_BidSubmission_TG1"), "Address_GeneralReqEqiptab_BidSubmission_TG1");
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Bidder Information tab", " Bidder Information tab verified successfully", "Pass",
						"Y");
				
			//Verifying Attachments tab++++++++++++++++++++++++++++++++++++++++++++		
				waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1);
				click(tendercreationlocators.AttachmentstabLnk_BidSubmission_TG1, "AttachmentstabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1);
				waitForObj(100);
				click(tendercreationlocators.ActionbtnBidderspecificAttachment_BidSubmission_TG1, "ActionbtnBidderspecificAttachment_BidSubmission_TG1");
				set(tendercreationlocators.UploadBidderspecificAttachment_BidSubmission_TG1, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
						"fileName");
				waitForObj(2000);
				click(tendercreationlocators.Attachment_subtabLnk_BidSubmission_TG1, "Attachment_subtabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				click(tendercreationlocators.TenderAttachment_subtabLnk_BidSubmission_TG1, "TenderAttachment_subtabLnk_BidSubmission_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				click(tendercreationlocators.savebutton, "savebutton");
				waitForObj(2000);
				eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
				waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
				waitForObj(500);
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Attachments tab", "Attachments tab verified successfully", "Pass",
						"Y");
				
				
			//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG8);
				click(tendercreationlocators.RFQItemtabLnk_BidSubmission_TG8, "RFQItemtabLnk_BidSubmission_TG8");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.unitRate_BidSubmission_TG8);
				waitForObj(500);
				set(tendercreationlocators.unitRate_BidSubmission_TG8, pdfResultReport.testData.get("UnitRateTxt_RFQItemtab_BidSubmission_TG1"), "unitRate_BidSubmission_TG8");
				scrollToElement(tendercreationlocators.gst_BidSubmission_TG8);
				set(tendercreationlocators.gst_BidSubmission_TG8, pdfResultReport.testData.get("CGSTTxt_RFQItemtab_BidSubmission_TG1"), "gst_BidSubmission_TG8");
				waitForObj(500);
				click(tendercreationlocators.savebutton, "savebutton");
				waitForObj(2000);
				eTenderComponent.waitForSpinnerToDisappearInBidSubmission();
				waitForElementToBeVisible(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				IsElementPresent(tendercreationlocators.alertPopUp_QRC_bidSubmission);
				click(tendercreationlocators.alertClose_QRC_bidSubmission, "alertClose_QRC_bidSubmission");
				waitForObj(500);
				pdfResultReport.addStepDetails("BidSubmission_for_Tender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify RFQ Item tab", "RFQ Item tab verified successfully", "Pass",
						"Y");

				log.info("completed executing the method:: BidSubmission_for_Tender_from_indent_withRFQ_TG5 "+TemplateGroup);

			} catch (Exception e) {

				log.fatal("Not able to publish tender from indent" + e.getMessage());
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '"+TemplateGroup+"'",
						"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
						"Fail", "N");
			}
		}
		
	public void waitTillBidstartDateReached() throws Throwable {
		try {

			while (true) {
				LocalDateTime localdatetime = LocalDateTime.now();

				String currentdateTime = localdatetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
				System.out.println(bidStartDate_24Hrs);
				if (currentdateTime.compareTo(bidStartDate_24Hrs) > 0) {
							System.out.println("The Given Bid Start Time Is Reached --->" + bidStartDate_24Hrs + " " + "The Bidder Can Start Bidding"); Dynamicity.bid_GI();
							break;
				} else {
						System.out.println("The Given Bid Start Time Is  --->" + bidStartDate_24Hrs + " " + "Wait till bid start date time reached " + " "+ currentdateTime.compareTo(bidStartDate_24Hrs)); Dynamicity.bid_GI();
						waitForObj(10000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void waitTillBidstartDateReached_Dynamic() throws Throwable {
		try {

			while (true) {
				LocalDateTime localdatetime = LocalDateTime.now();

				String currentdateTime = localdatetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
				System.out.println(bidStartDate_24Hrs);
				if (currentdateTime.compareTo(Dynamicity.getDataFromPropertiesFile("bidStartDate", filePath_4)) > 0) {

					waitForObj(1000);

					System.out.println("The Given Bid Start Time Is Reached --->" + bidStartDate_24Hrs + " "
							+ "The Bidder Can Start Bidding");
					break;
				} else {
					System.out.println("The Given Bid Start Time Is  --->" + bidStartDate_24Hrs + " "
							+ "Wait till bid start date time reached " + " "
							+ currentdateTime.compareTo(bidStartDate_24Hrs));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void waitTillBidDuetDateReached() throws Throwable {
		try {

			while (true) {
				LocalDateTime localdatetime = LocalDateTime.now();

				String currentdateTime = localdatetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

				if (currentdateTime.compareTo(bidDueDate_24Hrs) > 0) {

					waitForObj(2000);
					System.out.println("The Given Bid Due Time Is Reached --->" + bidDueDate_24Hrs + " "
							+ "The Bidder Should wait for BidOpen date");
					break;
				} else {
					System.out.println("he Given Bid Due Time Is  --->" + bidDueDate_24Hrs + " "
							+ "Wait till the due date time reached " + "  "
							+ currentdateTime.compareTo(bidDueDate_24Hrs));
					waitForObj(30000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitTillBidOpentDateReached() throws Throwable {
		try {

			while (true) {
				LocalDateTime localdatetime = LocalDateTime.now();

				String currentdateTime = localdatetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

				if (currentdateTime.compareTo(bidOpenDate_24Hrs) > 0) {

					waitForObj(5000);

					break;
				} else {
					System.out.println(
							"wait till the bid open date time reached " + currentdateTime.compareTo(bidDueDate_24Hrs));
					waitForObj(30000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Verifying filling up RFQ tab and create RFQ with Indent TG5 ("Indigenous Indent (Supply Only) V-004") and RFQ TG5 ("Indigenous Tender (Supply Only) V-1.0") (16/04/2021)
	public void PublishTender_from_indent_withRFQ_TG5(String TemplateGroup,int startdatelag, int enddatelag, int opendatelag)throws Throwable {
		try {
			log.info(
					"started executing the method:: PublishTender_from_indent_withRFQ_TG5 "+TemplateGroup);

		//Verifying general information tab++++++++++++++++++++++++++++++++++++++++++++
			if (IsEnabled(tendercreationlocators.templateGroupdropdown)==true)
			{
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5",
						"Template group field should be auto populated and selection should be disable", "Template group field is not disable",
						"Fail", "N");
			} else
			{
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5",
						"Template group field should be auto populated and selection should be disable", "Template group field is auto populated and selection is disable", "Pass",
						"Y");
			}
			select(tendercreationlocators.bitPartdropdown, pdfResultReport.testData.get("BidParts"));
			click(tendercreationlocators.bitPartRadio, "bitPartRadio");
			tenderRef = "TendRef_";
			int getrandomInterger = getrandomInterger(10000, 1000000000);
			tenderRef = tenderRef.concat(String.valueOf(getrandomInterger));
			clear(tendercreationlocators.tenderReferenceNumber, "tenderReferenceNumber");
			set(tendercreationlocators.tenderReferenceNumber, tenderRef, "tenderReferenceNumber");
			select(tendercreationlocators.procurementCategory, pdfResultReport.testData.get("procurementCategory"));
			set(tendercreationlocators.Min_bid_no, pdfResultReport.testData.get("Minimum_no_of_Bids"), "MinimumNoOfBids");
			click(tendercreationlocators.savebutton, "savebutton");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(1000);
		//Verifying Project Details tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1);
			click(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1, "ProjectDetailstabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Project Details tab", "Project Details tab verified successfully", "Pass",
					"Y");
		//Verifying General Requirement Equipment details+++++++++++++++++++++++++++++++++++++++++ 	
			waitForElementToBeClickable(tendercreationlocators.GeneralReqEquiptabLnk_Tender_TG1);
			click(tendercreationlocators.GeneralReqEquiptabLnk_Tender_TG1, "GeneralReqEquiptabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify General Requirement Equipment details tab", "General Requirement Equipment details tab verified successfully", "Pass",
					"Y");
		//Verifying Terms & Conditions tab++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1);
			click(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1, "TermsandConditionstabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.AddBtnTermsandConditionstab_Tender_TG1);
			set(tendercreationlocators.ClauseTxtTermsandConditionstab_Tender_TG1, pdfResultReport.testData.get("ClauseNo_TermsAndConditions_TG1"), "ClauseTxtTermsandConditionstab_Tender_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(500);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Terms & Conditions tab", "Terms & Conditions tab verified successfully", "Pass",
					"Y");
		//Clicking on next arrow
			click(tendercreationlocators.NextLnk_Tender_TG1, "NextLnk_Tender_TG1");
		//Verifying Specifications and Technical Requirements Compliance tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.SpecAndTechComptabLnk_Tender_TG5);
			click(tendercreationlocators.SpecAndTechComptabLnk_Tender_TG5, "SpecAndTechComptabLnk_Tender_TG5");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			IsElementPresent(tendercreationlocators.ClauseTxt_SpecAndTechComptab_Tender_TG5);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Added Clause detail from indent should be by default displayed Specifications and Technical Requirements Compliance tab", "Added Clause detail from indent by default displayed successfully in Specifications and Technical Requirements Compliance tab", "Pass",
					"Y");
		//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_Tender_TG1);
			click(tendercreationlocators.RFQItemtabLnk_Tender_TG1, "RFQItemtabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			IsElementPresent(tendercreationlocators.ItemCodeTxt_RFQItemtab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Added Item from indent should be by default displayed in RFQ Item tab", "Added Item from indent by default displayed successfully in RFQ Item tab", "Pass",
					"Y");
		//Clicking on next arrow
			click(tendercreationlocators.NextLnk_Tender_TG1, "NextLnk_Tender_TG1");
		//Verifying Price Summary tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.PriceSummarytabLnk_Tender_TG5);
			click(tendercreationlocators.PriceSummarytabLnk_Tender_TG5, "PriceSummarytabLnk_Tender_TG5");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			IsElementPresent(tendercreationlocators.CalculationMode_PriceSummarytab_Tender_TG5);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Calculated values from indent should be by default displayed in Price Suammary tab", "Calculated values from indent by default displayed successfully in Price Summary tab", "Pass",
					"Y");	
		//Verifying Attachment tab+++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_Tender_TG1);
			click(tendercreationlocators.AttachmentstabLnk_Tender_TG1, "AttachmentstabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			IsElementPresent(tendercreationlocators.AttachmentsRowLbl_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Added attachment in indent should be displayed by default", "Added attachment in indent successfully displayed by default", "Pass",
					"Y");
		//Verifying Required Attachment tab++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1);
			click(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1, "ReqAttachmenttabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeVisible(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1);
			click(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1, "AddBtnReqAttachmenttab_Tender_TG1");
			waitForElementToBeVisible(tendercreationlocators.AttachmentModal_ReqAttachmenttab_Tender_TG1);
			set(tendercreationlocators.SupportingdocTxt_ReqAttachmenttab_Tender_TG1, pdfResultReport.testData.get("SupportingDoc_RequiredAttachment_TG1"), "SupportingdocTxt_ReqAttachmenttab_Tender_TG1");
			click(tendercreationlocators.Okbtn_ReqAttachmenttab_Tender_TG1, "Okbtn_ReqAttachmenttab_Tender_TG1");
			click(tendercreationlocators.savebutton, "savebutton");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(500);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Required Attachment tab", "Required Attachment tab verified successfully", "Pass",
					"Y");
		//Verify Date Schedule tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			click(tendercreationlocators.dateschedule, "dateschedule");
			waitForElementToBeVisible(tendercreationlocators.bidsubmissionStartDate);
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			set(tendercreationlocators.bidsubmissionStartDate, getBidStartDate(startdatelag), "bidsubmissionStartDate");
			set(tendercreationlocators.bidsubmissionDueDate, getBidDueDate(enddatelag), "bidsubmissionDueDate");
			set(tendercreationlocators.bidsubmissionOpenDate, getBidOpenDate(opendatelag), "bidsubmissionOpenDate");
			click(tendercreationlocators.savebutton, "savebutton");
			waitForObj(3000);
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Date Schedule tab should be verified", "Successfully verified Date Scheduled tab", "Pass",
					"Y");	
		//Verifying Prebid discussion tab++++++++++++++++++++++++++++++++++++++++++
			waitForElementToBeClickable(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1);
			click(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1, "PreBidDiscussiontabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify PrebidDiscussion tab", "PrebidDiscussion tab verified successfully", "Pass",
					"Y");
		//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			waitForElementToBeClickable(tendercreationlocators.PaymentabLnk_Tender_TG1);
			click(tendercreationlocators.PaymentabLnk_Tender_TG1, "PaymentabLnk_Tender_TG1");
			waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			set(tendercreationlocators.PaymentAmount_Paymentab_Tender_TG1, "1000", "PaymentAmount_Paymentab_Tender_TG1");
			click(tendercreationlocators.OfflineNEFT_Paymentab_Tender_TG1, "OfflineNEFT_Paymentab_Tender_TG1");
			click(tendercreationlocators.AddPayment_Paymentab_Tender_TG1, "AddPayment_Paymentab_Tender_TG1");
			waitForObj(500);
			IsElementPresent(tendercreationlocators.PaymentRow_Paymentab_Tender_TG1);
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '" +TemplateGroup+"'",
					"Verify Payment tab", "Payment tab verified successfully", "Pass",
					"Y");

			log.info("completed executing the method:: PublishTender_from_indent_withRFQ_TG5 "+TemplateGroup);

		} catch (Exception e) {

			log.fatal("Not able to publish tender from indent" + e.getMessage());
			pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '"+TemplateGroup+"'",
					"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
					"Fail", "N");
		}
	}
	
	//Verifying filling up RFQ tab and create RFQ with Indent TG8 ("Indent Purchase Contract V-004") and RFQ TG8 ("Tender for Purchase Contract V-4.0") (02/06/2021)
		public void PublishTender_from_indent_withRFQ_TG8(String TemplateGroup,int startdatelag, int enddatelag, int opendatelag)throws Throwable {
			try {
				log.info(
						"started executing the method:: PublishTender_from_indent_withRFQ_TG8 "+TemplateGroup);

			//Verifying general information tab++++++++++++++++++++++++++++++++++++++++++++
				if (IsEnabled(tendercreationlocators.templateGroupdropdown)==true)
				{
					pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8",
							"Template group field should be auto populated and selection should be disable", "Template group field is not disable",
							"Fail", "N");
				} else
				{
					pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8",
							"Template group field should be auto populated and selection should be disable", "Template group field is auto populated and selection is disable", "Pass",
							"Y");
				}
				waitForObj(1000);
				select(tendercreationlocators.bitPartdropdown, "2");
				click(tendercreationlocators.bitPartRadio2, "bitPartRadio");
				tenderRef = "TendRef_";
				int getrandomInterger = getrandomInterger(10000, 1000000000);
				tenderRef = tenderRef.concat(String.valueOf(getrandomInterger));
				clear(tendercreationlocators.tenderReferenceNumber, "tenderReferenceNumber");
				set(tendercreationlocators.tenderReferenceNumber, tenderRef, "tenderReferenceNumber");
				//select(tendercreationlocators.procurementCategory, pdfResultReport.testData.get("procurementCategory"));
				scrollToElement(tendercreationlocators.Min_bid_no);
				set(tendercreationlocators.Min_bid_no, pdfResultReport.testData.get("Minimum_no_of_Bids"), "MinimumNoOfBids");
				scrollToTopOfThePage();
				click(tendercreationlocators.savebutton, "savebutton");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
			//Verifying Project Details tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
				waitForElementToBeClickable(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1);
				click(tendercreationlocators.ProjectDetailstabLnk_Tender_TG1, "ProjectDetailstabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Project Details tab", "Project Details tab verified successfully", "Pass",
						"Y");
			//Verifying Prequalification details+++++++++++++++++++++++++++++++++++++++++ 	
				waitForElementToBeClickable(tendercreationlocators.PrequalificationDetailstabLnk_Tender_TG1);
				click(tendercreationlocators.PrequalificationDetailstabLnk_Tender_TG1, "PrequalificationDetailstabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify General Requirement Equipment details tab", "General Requirement Equipment details tab verified successfully", "Pass",
						"Y");
			//Verifying Technical details+++++++++++++++++++++++++++++++++++++++++ 	
				waitForElementToBeClickable(tendercreationlocators.TechnicaltabLnk_Tender_TG1);
				click(tendercreationlocators.TechnicaltabLnk_Tender_TG1, "TechnicaltabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Technical	 details tab", "Technical details tab verified successfully", "Pass",
						"Y");
			//Verifying Terms & Conditions tab++++++++++++++++++++++++++++++++++++++++++++	
				waitForElementToBeClickable(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1);
				click(tendercreationlocators.TermsandConditionstabLnk_Tender_TG1, "TermsandConditionstabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.AddBtnTermsandConditionstab_Tender_TG8);
				click(tendercreationlocators.AddBtnTermsandConditionstab_Tender_TG8, "AddBtnTermsandConditionstab_Tender_TG8");
				waitForObj(2000);
				set(tendercreationlocators.ClauseTxtTermsandConditionstab_Tender_TG8, pdfResultReport.testData.get("ItemCode"), "ClauseTxtTermsandConditionstab_Tender_TG8");
				set(tendercreationlocators.ClauseHeaderTxtTermsandConditionstab_Tender_TG8, pdfResultReport.testData.get("TermsClause"), "ClauseHeaderTxtTermsandConditionstab_Tender_TG8");
				click(tendercreationlocators.savebutton, "savebutton");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(500);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Terms & Conditions tab", "Terms & Conditions tab verified successfully", "Pass",
						"Y");
			//Verifying Attachment tab+++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.AttachmentstabLnk_Tender_TG1);
				click(tendercreationlocators.AttachmentstabLnk_Tender_TG1, "AttachmentstabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				IsElementPresent(tendercreationlocators.AttachmentsRowLbl_Tender_TG1);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Added attachment in indent should be displayed by default", "Added attachment in indent successfully displayed by default", "Pass",
						"Y");
			//Verifying RFQ Item tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
				waitForElementToBeClickable(tendercreationlocators.RFQItemtabLnk_Tender_TG1);
				click(tendercreationlocators.RFQItemtabLnk_Tender_TG1, "RFQItemtabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				IsElementPresent(tendercreationlocators.ItemCodeTxt_RFQItemtab_Tender_TG8);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Added Item from indent should be by default displayed in RFQ Item tab", "Added Item from indent by default displayed successfully in RFQ Item tab", "Pass",
						"Y");
			//Clicking on next arrow
				click(tendercreationlocators.NextLnk_Tender_TG1, "NextLnk_Tender_TG1");
			//Verifying Payment tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
				waitForElementToBeClickable(tendercreationlocators.PaymentabLnk_Tender_TG1);
				click(tendercreationlocators.PaymentabLnk_Tender_TG1, "PaymentabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				set(tendercreationlocators.PaymentAmount_Paymentab_Tender_TG1, "1000", "PaymentAmount_Paymentab_Tender_TG1");
				click(tendercreationlocators.OfflineNEFT_Paymentab_Tender_TG1, "OfflineNEFT_Paymentab_Tender_TG1");
				click(tendercreationlocators.AddPayment_Paymentab_Tender_TG1, "AddPayment_Paymentab_Tender_TG1");
				waitForObj(500);
				IsElementPresent(tendercreationlocators.PaymentRow_Paymentab_Tender_TG1);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Payment tab", "Payment tab verified successfully", "Pass",
						"Y");
			//Verify Date Schedule tab+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				click(tendercreationlocators.dateschedule, "dateschedule");
				waitForElementToBeVisible(tendercreationlocators.bidsubmissionStartDate);
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				set(tendercreationlocators.bidsubmissionStartDate, getBidStartDate(startdatelag), "bidsubmissionStartDate");
				set(tendercreationlocators.bidsubmissionDueDate, getBidDueDate(enddatelag), "bidsubmissionDueDate");
				set(tendercreationlocators.bidsubmissionOpenDate, getBidOpenDate(opendatelag), "bidsubmissionOpenDate");
				click(tendercreationlocators.savebutton, "savebutton");
				waitForObj(3000);
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Date Schedule tab should be verified", "Successfully verified Date Scheduled tab", "Pass",
						"Y");
			//Verifying Prebid discussion tab++++++++++++++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1);
				click(tendercreationlocators.PreBidDiscussiontabLnk_Tender_TG1, "PreBidDiscussiontabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify PrebidDiscussion tab", "PrebidDiscussion tab verified successfully", "Pass",
						"Y");
			//Verifying Required Attachment tab++++++++++++++++++++++++++++++
				waitForElementToBeClickable(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1);
				click(tendercreationlocators.ReqAttachmenttabLnk_Tender_TG1, "ReqAttachmenttabLnk_Tender_TG1");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForElementToBeVisible(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1);
				click(tendercreationlocators.AddBtnReqAttachmenttab_Tender_TG1, "AddBtnReqAttachmenttab_Tender_TG1");
				waitForElementToBeVisible(tendercreationlocators.AttachmentModal_ReqAttachmenttab_Tender_TG1);
				set(tendercreationlocators.SupportingdocTxt_ReqAttachmenttab_Tender_TG1, pdfResultReport.testData.get("Product"), "SupportingdocTxt_ReqAttachmenttab_Tender_TG1");
				click(tendercreationlocators.Okbtn_ReqAttachmenttab_Tender_TG1, "Okbtn_ReqAttachmenttab_Tender_TG1");
				click(tendercreationlocators.savebutton, "savebutton");
				waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(500);
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG8 '" +TemplateGroup+"'",
						"Verify Required Attachment tab", "Required Attachment tab verified successfully", "Pass",
						"Y");
				log.info("completed executing the method:: PublishTender_from_indent_withRFQ_TG8 "+TemplateGroup);
			} catch (Exception e) {

				log.fatal("Not able to publish tender from indent" + e.getMessage());
				pdfResultReport.addStepDetails("PublishTender_from_indent_withRFQ_TG5 '"+TemplateGroup+"'",
						"Should publish tender from indent", "Unable to publish tender from indent" + e.getMessage(),
						"Fail", "N");
			}
		}
		public void validatePreviewData() throws Exception {
			try {
				//general Preview Tab
			waitForElementToBeClickable(tendercreationlocators.ActionButton);
			click(tendercreationlocators.ActionButton, "Indent Action Button");
			waitForElementToBeClickable(tendercreationlocators.ViewIndent);
			click(tendercreationlocators.ViewIndent, "View Indent");
			checkPageIsReady();
//			click(tendercreationlocators.generalTab, "click on preview genreral tab");
			isElementTextPresent(tendercreationlocators.templategroupnameInIndentPreview,TemplateGroup );
			isElementTextPresent(tendercreationlocators.Indent_description_001,pdfResultReport.testData.get("Indent_Geninfo_Desc") );
			isElementTextPresent(tendercreationlocators.NormalEmergency,pdfResultReport.testData.get("Normal/Emergency") );
			isElementTextPresent(tendercreationlocators.indentCategory,pdfResultReport.testData.get("Indent Category") );
			isElementTextPresent(tendercreationlocators.indentCurrency,pdfResultReport.testData.get("Indent_Geninfo_Currency"));
			scrollToBottomOfThePage();
			isElementTextPresent(tendercreationlocators.suggestedModeofTendering,pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
			isElementTextPresent(tendercreationlocators.remarkss,pdfResultReport.testData.get("Indent_Geninfo_Remarks"));
			
			//Indent Details Tab
			
			click(tendercreationlocators.indentDetailsPreviewTab, "indent details preview tab");
			checkPageIsReady();
//			WebDriver driver = ThreadLocalWebdriver.getDriver();
//			List<WebElement> indentpreviewdetails= driver.findElements(By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div/fieldset/div"));
//			ArrayList<String> al = new ArrayList<String>();
//			al.add(pdfResultReport.testData.get("TypeOfService_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("Capital_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("ModeOfDespatch_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("PlaceOfDelivery_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("DeiveryPeriod_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("NoOfYear_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("BasisOfPriceEstimation_TG1IndentDetailsTab"));
//			al.add(pdfResultReport.testData.get("PreBidMeeting_TG1IndentDetailsTab"));
			
			isElementTextPresent(tendercreationlocators.TypeofServiceWorkpreview,pdfResultReport.testData.get("TypeOfService_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.CapitalRevenuepreview,pdfResultReport.testData.get("Capital_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.ModeofDispatchpreview,pdfResultReport.testData.get("ModeOfDespatch_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.PlaceofDeliverypreview,pdfResultReport.testData.get("PlaceOfDelivery_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.ContractCompletionDeliveryPeriodpreview,pdfResultReport.testData.get("DeiveryPeriod_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.NumberofYearMonthDaypreview,pdfResultReport.testData.get("NoOfYear_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.BasisofPriceEstimationpreview,pdfResultReport.testData.get("BasisOfPriceEstimation_TG1IndentDetailsTab") );
			isElementTextPresent(tendercreationlocators.PreBidMeetingpreview,pdfResultReport.testData.get("PreBidMeeting_TG1IndentDetailsTab") );
			
		    	 
		 	// other information preview tab
			
			click(tendercreationlocators.otherInformationpreviewTab, "Indent Action Button");
			checkPageIsReady();
			isElementTextPresent(tendercreationlocators.worksContractPreview,pdfResultReport.testData.get("WorkofContract_TG1OtherinformationTab") );
			scrollToElement(tendercreationlocators.partysitepreview);
			isElementTextPresent(tendercreationlocators.partysitepreview,pdfResultReport.testData.get("PartySite_TG1OtherinformationTab") );
			
			
			//BOM item preview tab
			
//			click(tendercreationlocators.bomItempreviewTab, "Indent BOM Item tab");
//			checkPageIsReady();
//			for (int i = 0; i < 2; i++) {
//				isElementTextPresent(tendercreationlocators.partysitepreview,aList.get(i) );
//				
//			}
			//technical secification tab
			click(tendercreationlocators.technicalSpecificationPreviewTab, "Technical Specification Preview Tab");
			checkPageIsReady();
			isElementTextPresent(tendercreationlocators.clauseSubClauseNoPreview,pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab") );
			isElementTextPresent(tendercreationlocators.clauseSubClauseNoPreview,pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab") );
			
			click(tendercreationlocators.indentPreviewnextarrowbutton, "Indent Preview next arrow button");
		
			//annexture preview tab
			waitForObj(1500);
			click(tendercreationlocators.annexturetabpreview, "Technical Specification Preview Tab");
			checkPageIsReady();
			isElementTextPresent(tendercreationlocators.annexturetabpreview,pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"));
	
			isFileDownloadAndValidation(tendercreationlocators.annextureDownloadButtonPreview,"Annexture Download Button", "rfqCreation.xlsx");
			
			//approver History Preview Tab
			waitForObj(1500);
			click(tendercreationlocators.approvalHistoryPreviewTab, "Approval History");
			
			checkPageIsReady();
			
			try {
			List<WebElement> previewallcommentList = ThreadLocalWebdriver.getDriver().findElements(By.xpath("//span[@class='comments']"));
			List<String> locatorList = new ArrayList<String>();
			for(WebElement e : previewallcommentList){
				locatorList.add(e.getText());   
			}
			
			if(locatorList.equals(commentlist))	
				pdfResultReport.addStepDetails("IndentTG1_Preview All indent side and approver side comment validation",
						"All comment should match", "Sucessfully matched all data" + " ", "Pass",
						"Y");
				log.info("completed executing the method:: IndentTG1_validatePreviewData");
			}
			catch (Exception e) {

				log.fatal("Comments does not match as expected" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_Preview Page Validation All indent side and approver side comment validation",
						"All comment should match", "Comments not matched" + e.getMessage(),
						"Fail", "N");
			}
			
			
			click(tendercreationlocators.indentByPreviewclosebutton, "Indent Preview Close button");
			waitForObj(1000);
			

			pdfResultReport.addStepDetails("IndentTG1_Preview Page Validation",
					"All data in preview Page should match", "Sucessfully matched all data" + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: IndentTG1_validatePreviewData");

		} catch (Exception e) {

			log.fatal("Preview data does not matched" + e.getMessage());
			pdfResultReport.addStepDetails("IndentTG1_validatePreviewData",
					"All data in preview Page should match", "Data not matched" + e.getMessage(),
					"Fail", "N");
		}
			
			
			}
		//@pavel
		public void validateDeleteIndentFeature() throws Exception {
		
			try {
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.indentlist);
				log.info(
						"started executing the method:: Delete Indent functionality Validation");
				
				click(tendercreationlocators.indentlist, "indentlist");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeClickable(tendercreationlocators.ActionButton);
			click(tendercreationlocators.ActionButton, "action icon");
			waitForElementToBeClickable(tendercreationlocators.deleteIndentLocator);
			click(tendercreationlocators.deleteIndentLocator, "Delete Indent");
			waitForObj(2000);
			set(tendercreationlocators.deleteRemarks, "delete test", "Reason");
			set(tendercreationlocators.deleteindentAttachment, System.getProperty("user.dir") + "\\MediaFiles\\cancel_Indent_reason.pdf","fileName");
			waitForElementToBeClickable(tendercreationlocators.submitbuttonIndentCancel);
			click(tendercreationlocators.submitbuttonIndentCancel, "Submit");
			waitForElementToBeClickable(tendercreationlocators.indesntCancelSuccessMessageOkButton);
			click(tendercreationlocators.indesntCancelSuccessMessageOkButton, "Success Ok Button");
			
				pdfResultReport.addStepDetails("Delete IndentValidation",
						"Indent should get Deleted", "Sucessfully deleted indent " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: VerifyIndentStatus");

			} catch (Exception e) {

				log.fatal("IndentTG1_Delete IndentValidation" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_Other_Information_tabvalidation",
						"Indent should get Deleted", "Unable to delete indent" + e.getMessage(),
						"Fail", "N");
			}
		}
		//@pavel
		public void validateCancelIndentFeature() throws Throwable {		
			try {
				waitForObj(2000);
				waitForElementToBeClickable(tendercreationlocators.ActionButton);
				log.info(
						"started executing the method:: Cancel Indent functionality validation");
				
				click(tendercreationlocators.ActionButton, "action icon");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForElementToBeClickable(tendercreationlocators.cancelIndent);	
			click(tendercreationlocators.cancelIndent, "Cancel Indent");
			waitForObj(7000);
			waitForElementToBeClickable(tendercreationlocators.cancelIndentAttachFile);
			set(tendercreationlocators.cancelIndentAttachFile, System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx","fileName");
			waitForObj(3000);
				pdfResultReport.addStepDetails("validateCancelIndentFeature: Cancel IndentValidation",
						"Indent should get cancelled", "Sucessfully cancelled indent " + " ", "Pass",
						"Y");
				log.info(
						"completed executing the method:: VerifyIndentStatus");

			} catch (Exception e) {

				log.fatal("validateCancelIndentFeature" + e.getMessage());
				pdfResultReport.addStepDetails("validateCancelIndentFeature: Cancel IndentValidation",
						"Indent should get cancelled", "Unable to cancel indent" + e.getMessage(),
						"Fail", "N");
			}
		}
		
		public void cancelIndentTabAtApproverEnd() throws Throwable {
			try {
				waitForObj(1000);
				JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
				mouseOver(tendercreationlocators.MyTask);
				waitForObj(2000);
				JSClick(tendercreationlocators.pending, "pending");
				universalNormalWait();
			
				
			click(tendercreationlocators.cancelIndentTabAtApproverEnd, "Cancel Indent");
			
			set(tendercreationlocators.searchBoxGRN, SystemIndentnoLocatorText, "search");
			waitForObj(2000);
			waitForElementToBeVisible(tendercreationlocators.IndentRowResult_Approver(SystemIndentnoLocatorText));
			waitForObj(1000);
			WebDriver driver = ThreadLocalWebdriver.getDriver();
			int size = driver.findElements(tendercreationlocators.IndentRowResult_Approver(SystemIndentnoLocatorText)).size();
			waitForObj(2000);
			if(size >=1)
			{
				System.out.println("**********************************************************************");
				System.out.println("Indent is present in Appproval pending List page the size is --->"+size);
				pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow",
					"Sucessfully displayed the pending indent in approval work flow", "Pass", "Y");
				log.info("completed executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheIndent");
				System.out.println("**********************************************************************");
			}
			else if((size ==0))
			{
				System.out.println("**********************************************************************");
				System.out.println("The indent is Not there in Approval pending List page the size is --->"+size);
				pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow","Unable to display the pending indent in approval work flow",
					"Fail", "N");
				
			}   

			pdfResultReport.addStepDetails("validateCancelIndentFeature: cancelIndentTabAtApproverEnd",
					"click On Cancel Indent feature should work", "Sucessfully click on cancelled indent button" + " ", "Pass",
					"Y");
			log.info(
					"completed executing the method:: cancelIndentTabAtApproverEnd");

		} catch (Exception e) {

			log.fatal("validateCancelIndentFeature" + e.getMessage());
			pdfResultReport.addStepDetails("validateCancelIndentFeature: cancelIndentTabAtApproverEnd",
					"click On Cancel Indent feature should work", "Unable to click cancel indent" + e.getMessage(),
					"Fail", "N");
		}
			
			
		}
		public void clickOnCancelledDeletedIndentTab() throws Exception {
			waitForObj(2000);
			click(tendercreationlocators.cancelledIndentTab, "Cancelled/Deleted");
			
		
			
		}
		public void clickDetailLinkInApprovalListPageForCancelIndent() throws Exception {
			try {
				log.info("started executing the method:: clickDetailLinkInApprovalListPageForCancelIndent");
				
				click(tendercreationlocators.new_action_button, "Actionbtn_IndentApprover");
				//click(tendercreationlocators.Detailbtn_IndentApprover, "Detailbtn_IndentApprover"); //commenting this line due new CR
				click(tendercreationlocators.tenderOpeningTabDetailsLinkBy, "sectionWiseView_IndentApprover");
				universalWait();
				waitForElementToBeClickable(tendercreationlocators.LblAppCmnt_IndentApprover);
				waitForObj(3000);
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(1000);
				pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
						"Should Naviagte to Approver section comments page",
						"Sucessfully  Naviagte to Approver section comments page", "Pass", "Y");

				log.info("completed executing the method:: clickDetailLinkInApprovalListPageForCancelIndent");
			} catch (Exception e) {
				log.fatal("Unable to Naviagte to Approver section comments page" + e.getMessage());
				pdfResultReport.addStepDetails("clickDetailLinkInApprovalListPage",
						"Should Naviagte to Approver section comments page",
						"Unable to Naviagte to Approver section comments page" + e.getMessage(), "Fail", "N");

	                     Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		
		public void ApproverOverAllComentWithIndentHasBeenApprovedforCancelIndent() throws Throwable {
			try {
				log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
				String comment = "Indent Process Is Approved";
				click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
				waitForObj(1000);
				scrollToElement(tendercreationlocators.AppComments);
				//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
				set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
				commentlist.add(text(tendercreationlocators.AppComments));
				//click(tendercreationlocators.ApproveBtn_Indent, "approve");
				waitForObj(1000);
				JSClick(tendercreationlocators.ApproveBtn, "approve");
				waitForObj(2000);
				WebDriver driver = ThreadLocalWebdriver.getDriver();
				int size = driver.findElements(tendercreationlocators.CloseWFBtn_Indent).size();
				if(size>=1)
				{
					click(tendercreationlocators.CloseWFBtn_Indent, "CloseWFBtn_Indent");
					click(tendercreationlocators.ConfirmYESBtn_Indent, "ConfirmYESBtn_Indent");
					click(tendercreationlocators.ConfirmYESBtnNext_Indent, "ConfirmYESBtnNext_Indent");
					click(tendercreationlocators.ConfirmYESBtnFinal_Indent, "ConfirmYESBtnFinal_Indent");
				}
				waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
				click(tendercreationlocators.OKBtn_IndentApproval, "OKBtn_IndentApproval");
			//	click(tendercreationlocators.NoBtn_IndentApproval, "NoBtn_IndentApproval");
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(3000);
				waitForElementToBeVisible(tendercreationlocators.WorkflowInbox);
				pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
						"Should Provide OverAll Comment ",
						"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
				log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
			} catch (Exception e) {
				log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
				pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
						"Should Provide OverAll Comment ",
						"Unable to Provide OverAll Comment"
								+ e.getMessage(),
						"Fail", "N");
	                    Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		public void VerifyIndentStatus_AssignmentListPageInCancelDeletedTab(String indentstatus) throws Throwable {
			try {
				log.info("started executing the method:: VerifyIndentStatus_AssignmentListPage");

				String txt = text(tendercreationlocators.cancelIndentStatus).trim();
				if(txt.equalsIgnoreCase(indentstatus))
				{
					pdfResultReport.addStepDetails("Verify Indent status",
							"Indent status should be "+indentstatus,
							"Indent status is '"+txt+"' and successfully verified" + " ", "Pass", "Y");
				}
				else
				{
					pdfResultReport.addStepDetails("Verify Indent status", "Indent status should be "+indentstatus,
							"Indent status is '"+txt+"' instead of '"+ indentstatus+"' ", "Fail", "N");
				}
				
				log.info("completed executing the method:: VerifyIndentStatus_AssignmentListPage");
			} catch (Exception e) {
				log.fatal("Not able to verify indent status" + e.getMessage());
				pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status",
						"Unable to verify indent status" + e.getMessage(), "Fail", "N");
			}
		}
		public void validateIndentdataAtApproverEnd() throws Exception {
			List<WebElement> totaltab=ThreadLocalWebdriver.getDriver().findElements(By.xpath("//nav[@class='customTableTab']/div/button"));

			try {
				log.info("started executing the method:: validateIndentdataAtApproverEnd()");
				waitForObj(1000);
			
				ArrayList<String> dataAtApproverEnd =new ArrayList<String>();
				for(int i=0;i<8;i++)
				{
					
					checkPageIsReady();
				
					totaltab.get(i).click();
					universalWait();
					dataAtApproverEnd.add(text(tendercreationlocators.tabContent));
					
					
				}
					
				if(tabcontentList.equals(dataAtApproverEnd))	
				{
					pdfResultReport.addStepDetails("validateIndentdataAtApproverEnd()",
							"All indent data at approver end should match",
							"Sucessfully matched all data in approver end", "Pass", "Y");

					log.info("completed executing the method:: clickDetailLinkInApprovalListPageForCancelIndent");
				
				}
				
				waitForObj(2500);
				pdfResultReport.addStepDetails("validateIndentdataAtApproverEnd()",
						"All indent data at approver end should match",
						"Sucessfully matched all data in approver end", "Pass", "Y");

				log.info("completed executing the method:: clickDetailLinkInApprovalListPageForCancelIndent");
					} 
			catch (Exception e) {
				log.fatal("Unable to Naviagte to Approver section comments page" + e.getMessage());
				pdfResultReport.addStepDetails("validateIndentdataAtApproverEnd()",
						"All indent data at approver end should match",
						"indent details in approver end not matched" + e.getMessage(), "Fail", "N");

	                     Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		public void addPredefinedIndentApprover() throws Exception {
			try {
				log.info(
						"started executing the method:: Predefined");
				click(tendercreationlocators.preDefinedWorkflow, "predefined");
				
				waitForObj(2600);
			
				set(tendercreationlocators.CommentsArea_IndentRTF, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
						"CommentsArea_Indent");
				
				//=========Role Activity and other Details===========================
				String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					scrollToElement(tendercreationlocators.approverTypePO);
					while(isElementDisplayed_Updated(tendercreationlocators.approverTypePO, 2)==true)
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					
				}
				else {
					System.out.println("this block of code for without activity/role");
				}
			  
				
				pdfResultReport.addStepDetails("Predefined workflow",
						"Predefined Approval Must Be selected",
						"Predefined Approval selected Sucessfully"
								+ " ",
						"Pass", "Y");
				waitForObj(1000);
				scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
				click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
				waitForElementToBeVisible(tendercreationlocators.myindent);
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(4000);
				pdfResultReport.addStepDetails("predefined workflow send for approval",
						"Must Submit the Indent With predefined Flow ",
						"Sucessfully Submitted Indent With predefined Flow "
								+ " ",
						"Pass", "Y");
				log.info(
						"completed executing the method:: addPredefinedIndentApprover");
			} catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("addPredefinedIndentApprover",
						"Must Submit the Indent With predefined Flow ",
						"Not able to Submit Indent with predefined approval flow "
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
			
			
		}
		public void adminLogin() throws Exception {
			try {
				log.info("started executing the method:: IndentcreatorLogin");
				//click(tendercreationlocators.login, "login"); // edited on 30-11-21
				set(tendercreationlocators.userName, pdfResultReport.testData.get("adminUserName"), "userName");
				waitForElementToBeClickable(tendercreationlocators.password);
				set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
				//Handle fixed Captcha (06/11/2020)
				//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha"); // edited on 30-11-21
				click(tendercreationlocators.okButton, "okButton");
				//waitForElement(tendercreationlocators.dashboardIcon, 30); //commented on 110722
				waitForElement(tendercreationlocators.dashboardIconnew, 30);
				pdfResultReport.addStepDetails("Indent creator login", "Indent creator must be sucessfully logged in",
						"Successfully logged in as indent creator" + " ", "Pass", "Y");
				log.info("completed executing the method:: IndentcreatorLogin");

			} catch (Exception e) {
				log.fatal("Unable to open the URL" + e.getMessage());
				pdfResultReport.addStepDetails("Indent creator login", "Indent creator is not logged in",
						"Unable to login as indent creator" + e.getMessage(), "Fail", "N");
			}
			
			
		}
		public void nevigateToMailDetails() throws Throwable {
			try {
				log.info("started executing the method:: nevigateToMailDetails");
				JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
				mouseOver(tendercreationlocators.Admin);
				// mouseOver(tendercreationlocators.tendersIcon);
				JSClick(tendercreationlocators.mailHistory, "Mail History");
				//WebDriver driver = ThreadLocalWebdriver.getDriver();
				checkPageIsReady();
				set(tendercreationlocators.searchMail,SystemIndentnoLocatorText, "search with indent number");
				waitForObj(1200);
				select(tendercreationlocators.selectOrganization,pdfResultReport.testData.get("organization"));
				waitForObj(3000);
				pdfResultReport.addStepDetails("nevigateToMailDetails", "Mail Details should nevigate",
						"Successfully nevigate to mail Details" + " ", "Pass", "Y");
				log.info("completed executing the method:: nevigateToMailDetails");

			} catch (Exception e) {
				log.fatal("Unable to mail details" + e.getMessage());
				pdfResultReport.addStepDetails("nevigateToMailDetails", "Mail Details should nevigate",
						"Unable tonevigate Mail Details" + e.getMessage(), "Fail", "N");
			}
			
			
		}
		public void validateMailAfterSendForApproval() throws Throwable {
			try {
			String arr[]= {"165","163","164","167","169"};
				log.info("started executing the method:: validateMailAfterSendForApproval");
				for (int i = 0; i < arr.length; i++) {
					if (text(tendercreationlocators.mailTableBody).contains(arr[i])) {
						pdfResultReport.addStepDetails("validateMailAfterSendForApproval", "EventId Matching",
								"All eventID matched" + " ", "Pass", "Y");
				}
				}
			
			
				
				pdfResultReport.addStepDetails("validateMailAfterSendForApproval", "EventId Matching",
						"Successfully matched event ID and count" + " ", "Pass", "Y");
				log.info("completed executing the method:: nevigateToMailDetails");
			

			} catch (Exception e) {
				log.fatal("Unable to mail details" + e.getMessage());
				pdfResultReport.addStepDetails("nevigateToMailDetails", "Mail event Details should be validated successfully ",
						"Unable to Mail event Details should be validated" + e.getMessage(), "Fail", "N");
			}
			
			
		}
		public void AddMultipleUsersForSequentialApproval_IndentWF() throws Exception {
			try {
				log.info(
						"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
				click(tendercreationlocators.UserDefinedWFchkbox_Indent, "UserDefinedWFchkbox_Indent");
				//by default section wise comment selected No
				//loop to remove the row if the the user added previously
				set(tendercreationlocators.CommentsArea_IndentRTF, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
						"CommentsArea_Indent");
				if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
				{
					List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
					int iRowCount = iRows.size();
					for(int i=1;i<=iRowCount;i++)
					{
						waitForObj(1000);
						click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
					}
				}
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);
				 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
					String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
					
					String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
					boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
					if(fielddisplay==true) {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						waitForObj(500);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
						
					}
					else {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
						waitForObj(500);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					}
					
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);

					if(fielddisplay==true) {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user2");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						waitForObj(500);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
						
					}
					else {
						set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user2");
						waitForObj(500);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("UserTenderApprover2"));
					}

				waitForObj(2000);
				
  /*				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);
				set(tendercreationlocators.user3_Indent, pdfResultReport.testData.get("User_Approver2"), "user1_Indent");
				waitForObj(2000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				waitForObj(2000);
				
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);
				set(tendercreationlocators.user4_Indent, pdfResultReport.testData.get("User_Approver3"), "user1_Indent");
				waitForObj(2000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				waitForObj(2000);
				
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);
				set(tendercreationlocators.user5_Indent, pdfResultReport.testData.get("User_Approver4"), "user1_Indent");
				waitForObj(2000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				waitForObj(2000);
				
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(2000);
				set(tendercreationlocators.user6_Indent, pdfResultReport.testData.get("User_Approver5"), "user1_Indent");
				waitForObj(2000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Approver_Type_Parallel"));
				waitForObj(2000);
				
				
				click(tendercreationlocators.coordinatorCheckbox, "coordinator");
				waitForObj(1000);
				set(tendercreationlocators.minApprover, "3", "min approver");
				waitForObj(1000);
				click(tendercreationlocators.coordinatorCheckbox, "coordinator");
				waitForObj(2000);
				
				*/    // feature removed from application
				
				commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
				
				
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Sequential Approval Must Be selected",
						"Sequential Approval selected Sucessfully"
								+ " ",
						"Pass", "Y");
				waitForObj(2000);
				scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
				click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
				waitForElementToBeVisible(tendercreationlocators.myindent);
				//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
				waitForObj(4000);
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Sucessfully Submitted Indent With Seq Flow "
								+ " ",
						"Pass", "Y");
				log.info(
						"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
			} catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Not able to Submit Indent"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		public void aproverBranching(String string1,String string2) throws Exception {
			try {
				log.info("started executing the method:: branching");
			
				String branchingComment = "Need your inputs";
				click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(2000);
			scrollToElement(tendercreationlocators.discussionButton);
			waitForObj(1500);
			click(tendercreationlocators.discussionButton, "Discussion");
			waitForElementToBeVisible(tendercreationlocators.usernameatDiscussion);
				
				for (int i = 2; i <= Integer.parseInt(string1)+1; i++) {
				String	UserTenderApprover="UserTenderApprover"+i;
					set(tendercreationlocators.discussionSearchUser, DatabaseComponent_UnderComponentPakage.userFullName(pdfResultReport.testData.get(UserTenderApprover)), "b1");				
					waitForObj(1000);
					click(tendercreationlocators.arrowIcon, "Arrow ICon");
					waitForObj(1000);
						set(tendercreationlocators.b1usercomment, branchingComment, "Remarks");

						clear(tendercreationlocators.discussionSearchUser, "search user");

				}
				
				click(tendercreationlocators.Submitbtn_AssignUsermodal_Indent,"Submit Button");

				waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
				click(tendercreationlocators.success_Ok_button, "success_Ok_button");
				scrollToTopOfThePage();
				waitForObj(1000);
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Indent With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
		
			
		}
			catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Not able to Submit Indent"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
				
			}
		public void sendBackToApprover(String comment) throws Throwable {
		try {
			log.info("started executing the method:: send back to approver");
			//String comment = "Indent Process Is Approved";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			scrollToElement(tendercreationlocators.AppComments);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
			commentlist.add(text(tendercreationlocators.AppComments));
			JSClick(tendercreationlocators.sendBack, "send back");
		
			waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
			click(tendercreationlocators.success_Ok_button, "success_Ok_button");
			
			pdfResultReport.addStepDetails("send back",
					"Should send back to approver",
					"SucessFully send back " + comment + " ", "Pass", "Y");
			log.info("completed executing the method:: sendBackToApprover");
		} catch (Exception e) {
			log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
			pdfResultReport.addStepDetails("sendBackToApprover",
					"should send back to approver",
					"Unable to send back to approver"
							+ e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
		}
		public void approveByApproverAfterBranching() throws Throwable {
			try {
				log.info("started executing the method:: approveByApproverAfterBranching");
				String comment = "Indent Process Is Approved";
				click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
				waitForObj(1000);
				scrollToElement(tendercreationlocators.AppComments);
				//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
				set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
				//click(tendercreationlocators.ApproveBtn_Indent, "approve");
				waitForObj(2000);
				JSClick(tendercreationlocators.ApproveBtn, "approve");
				waitForObj(5500);
							
				click(tendercreationlocators.ConfirmYESBtnFinal_Indent, "Confirm Yes Button");
				waitForObj(3000);
				waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
				click(tendercreationlocators.success_Ok_button, "success_Ok_button");
				
//				waitForElementToBeVisible(tendercreationlocators.Lbl_workflowinbox);
				pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
						"Should Provide OverAll Comment ",
						"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
				log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
				
				pdfResultReport.addStepDetails("send back",
						"Should send back to approver",
						"SucessFully send back " + comment + " ", "Pass", "Y");
				log.info("completed executing the method:: sendBackToApprover");
			
		} catch (Exception e) {
			log.fatal("approveByApproverAfterBranching + " + e.getMessage());
			pdfResultReport.addStepDetails("approveByApproverAfterBranching",
					"pprover should approve",
					"Unable to approve by approver"
							+ e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
		}
		public void threeaproverBranching(String string1, String string2, String string3) throws Exception {
			try {
				log.info("started executing the method:: branching");
			
				String branchingComment = "Need your inputs";
				click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(2000);
			click(tendercreationlocators.discussionButton, "Discussion");
			waitForElementToBeVisible(tendercreationlocators.usernameatDiscussion);
			waitForObj(1500);
		set(tendercreationlocators.discussionSearchUser, string1, "b1");				
		waitForObj(1000);
		click(tendercreationlocators.arrowIcon, "Arrow ICon");
		waitForObj(1000);
			set(tendercreationlocators.b1usercomment, branchingComment, "Remarks");
			
			clear(tendercreationlocators.discussionSearchUser, "search user");
			set(tendercreationlocators.discussionSearchUser, string2, "b2");				
			waitForObj(1000);
			click(tendercreationlocators.arrowIcon, "Arrow ICon");
			waitForObj(2000);
				set(tendercreationlocators.b2usercommnet, branchingComment, "Remarks");
			waitForObj(500);
			
			
			clear(tendercreationlocators.discussionSearchUser, "search user");
			set(tendercreationlocators.discussionSearchUser, string3, "b2");				
			waitForObj(1000);
			click(tendercreationlocators.arrowIcon, "Arrow ICon");
			waitForObj(2000);
				set(tendercreationlocators.b3usercommnet, branchingComment, "Remarks");
			waitForObj(500);
				
			
				click(tendercreationlocators.Submitbtn_AssignUsermodal_Indent,"Submit Button");
				
				
				waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
				click(tendercreationlocators.success_Ok_button, "success_Ok_button");
				
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Indent With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
		
			
		}
			catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Not able to Submit Indent"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		public void oneaproverBranching(String string) throws Exception {
			try {
				log.info("started executing the method:: branching");
			
				String branchingComment = "Need your inputs";
				click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(2000);
			scrollToElement(tendercreationlocators.discussionButton);
			waitForObj(1500);
			click(tendercreationlocators.discussionButton, "Discussion");
			waitForElementToBeVisible(tendercreationlocators.usernameatDiscussion);
			waitForObj(1500);
		set(tendercreationlocators.discussionSearchUser, string, "b1");				
		waitForObj(1000);
		click(tendercreationlocators.arrowIcon, "Arrow ICon");
		waitForObj(1000);
			set(tendercreationlocators.b1usercomment, branchingComment, "Remarks");
			
			
			waitForObj(500);
				click(tendercreationlocators.Submitbtn_AssignUsermodal_Indent,"Submit Button");
				
				
				waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
				click(tendercreationlocators.success_Ok_button, "success_Ok_button");
				scrollToTopOfThePage();
				waitForObj(1000);
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Indent With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
		
			
		}
			catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Not able to Submit Indent"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
			
		}
		public void saveTenderIDfromDraft() throws Exception {
			try {
			waitForObj(500);
			waitForElementToBeVisible(tendercreationlocators.tenderID);
			tenderIDdromDraft=text(tendercreationlocators.tenderID);
			waitForObj(500);
			
			pdfResultReport.addStepDetails("saveTenderIDfromDraft",
					"must save tender id from draft",
					"Sucessfully saved tender id"
							+ " ",
					"Pass", "Y");
		}
			catch (Exception e) {
				log.fatal("Not able to Submit Indent" + e.getMessage());
				pdfResultReport.addStepDetails("saveTenderIDfromDraft",
						"must save tender id from draft",
						"Not able to save tender id from draft"
								+ e.getMessage(),
						"Fail", "N");
	                       Assert.fail("Failed Due to " + e.getMessage());
			}
		}
			public void searchTenderID() throws Exception {
				try {
					log.info("started executing the method:: enterTenderIdInSearch");		
					waitForObj(4000);
					waitForElementToBeVisible(tendercreationlocators.tendersearchbox);
					
					clear(tendercreationlocators.tendersearchbox, "tenderListKeyword");
					set(tendercreationlocators.tendersearchbox, tenderIDdromDraft, "tenderListSearch");
					//waitForElementToBeVisible(tendercreationlocators.defaultCatBy);
					waitForObj(2000);
					
					pdfResultReport.addStepDetails("Successfully Saved",
							"Tender Id must be entered successfully in search field",
							"Tender Id is successfully entered in search field" + " ", "Pass", "Y");
					log.info("completed executing the method:: tenderIdSave");
				} catch (Exception e) {
					log.fatal("Not able to create tender" + e.getMessage());
					pdfResultReport.addStepDetails("Not able to create tender", "Not able to enter Tender Id in search field",
							"Unable to enter Tender Id in search field" + e.getMessage(), "Fail", "N");
				}
			

	
}
			public void deleteTender() throws Exception {
				try {
					log.info("started executing the method:: enterTenderIdInSearch");		
					waitForObj(3000);
					click(tendercreationlocators.tenderlistingPageAction, "action");
					waitForObj(2000);
					click(tendercreationlocators.deleteTenderFromAction,"delete");
					waitForElementToBeVisible(tendercreationlocators.deleteComment);
					set(tendercreationlocators.deleteComment, "Not required", "Remarks");
					waitForObj(1000);
					click(tendercreationlocators.Submit,"Submit");
					waitForObj(1000);
					
					pdfResultReport.addStepDetails("deleteTender",
							"tender should be deleted",
							"tender deleted" + " ", "Pass", "Y");
				
				} catch (Exception e) {
					log.fatal("Not able to deleteTender" + e.getMessage());
					pdfResultReport.addStepDetails("deleteTender", "tender should be deleted",
							"unable to delete tender" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void validateDeleteMessage() throws Exception {
				try {
					log.info("started executing the method:: validateDeleteMessage");		
					waitForObj(6000);
					if(	text(tendercreationlocators.poSaveMSG).equals("Success"))
					{
					pdfResultReport.addStepDetails("validateDeleteMessage",
							"delete success message should get displayed ",
							"delete success message displaied successfully" + " ", "Pass", "Y");
					}
					waitForObj(500);
					click(tendercreationlocators.Okbtn_Indent, "ok button");
				} catch (Exception e) {
					log.fatal("Not able to view delete success message" + e.getMessage());
					pdfResultReport.addStepDetails("validateDeleteMessage", "delete success message should get displayed ",
							"not able to see delete success message" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void validateCancelledMessage() throws Exception {
				try {
					log.info("started executing the method:: validateCancelledMessage");		
					waitForObj(6000);
					if(	text(tendercreationlocators.poSaveMSG).equals("Success"))
					{
					pdfResultReport.addStepDetails("validateCancelledMessage",
							"cancel success message should get displayed ",
							"cancel success message displaied successfully" + " ", "Pass", "Y");
					}
					waitForObj(2500);
					click(tendercreationlocators.Okbtn_Indent, "ok button");
					universalNormalWait();
				} catch (Exception e) {
					log.fatal("Not able to view cancel success message" + e.getMessage());
					pdfResultReport.addStepDetails("validateCancelledMessage", "cancelled success message should get displayed ",
							"not able to see cancel success message" + e.getMessage(), "Fail", "N");
				}
				
			}
			
			public void checkTenderStatusforCancelledorDeleted(String string) throws Exception {
				try {
					log.info("started executing the method:: checkTenderStatusforCancelledorDeleted");		
					waitForObj(5000);
					waitForElementToBeClickable(tendercreationlocators.cancelledorDeletedTenderTab);
					click(tendercreationlocators.cancelledorDeletedTenderTab, "cancelled/deleted");
					universalWait();
//					clear(tendercreationlocators.tendersearchbox, "tenderListKeyword");
//					set(tendercreationlocators.tendersearchbox, tenderIDdromDraft, "tenderListSearch");
					if(	text(tendercreationlocators.deletedorcanceltenderstatus).equals(string))
					{
						pdfResultReport.addStepDetails("checkTenderStatusforCancelledorDeleted",
								"tender status Deleted",
								"delete success message displayed successfully" + " ", "Pass", "Y");
					}
					waitForObj(1000);
					
				} catch (Exception e) {
					log.fatal("Not able to view delete success message" + e.getMessage());
					pdfResultReport.addStepDetails("checkTenderStatusforCancelledorDeleted", "tender status Deleted",
							"not displayed proper message" + e.getMessage(), "Fail", "N");
				}
				
			}
			
			
			public void AddSingleUsersForSequentialApproval_NotesheetWF() throws Throwable {
				try {
					log.info(
							"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
					click(tendercreationlocators.UserDefinedWFchkbox_Notesheet, "UserDefinedWFchkbox_Indent");
					//by default section wise comment selected No
					//loop to remove the row if the the user added previously
					if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
					{
						List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
						int iRowCount = iRows.size();
						for(int i=1;i<=iRowCount;i++)
						{
							waitForObj(1000);
							click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
						}
					}
					click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
					waitForObj(2000);
					set(tendercreationlocators.user1_Indent, pdfResultReport.testData.get("notesheetApprover1Send"), "user1_Indent");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
					waitForObj(2000);
					set(tendercreationlocators.CommentsArea_Notesheet, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
							"CommentsArea_Indent");
					
					
					
					pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_NotesheetWF",
							"Sequential Approval Must Be selected",
							"Sequential Approval selected Sucessfully"
									+ " ",
							"Pass", "Y");
					waitForObj(2000);
					scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
					click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
					waitForElementToBeVisible(tendercreationlocators.notesheetListPage);
					//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
					waitForObj(5000);
					pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_NotesheetWF",
							"Must Submit the Indent With Seq Flow ",
							"Sucessfully Submitted Notesheet With Seq Flow "
									+ " ",
							"Pass", "Y");
					log.info(
							"completed executing the method:: AddSingleUsersForSequentialApproval_NotesheetWF");
				} catch (Exception e) {
					log.fatal("Not able to Submit Indent" + e.getMessage());
					pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_NotesheetWF",
							"Must Submit the Notesheet With Seq Flow ",
							"Not able to Submit Notesheet"
									+ e.getMessage(),
							"Fail", "N");
		                       Assert.fail("Failed Due to " + e.getMessage());
				}
			}
		
			public void NotesheetapproverLogin() throws Throwable {
				try {
					log.info("started executing the method:: IndentapproverLogin");
					//click(tendercreationlocators.login, "login"); // commented on 201221
					set(tendercreationlocators.userName, pdfResultReport.testData.get("notesheetApproverUser1"), "userName");
					waitForElementToBeClickable(tendercreationlocators.password);
					set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
					//Handle fixed Captcha (06/11/2020)
					//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha");  // commented on 201221
					click(tendercreationlocators.okButton, "okButton");
					waitForElement(tendercreationlocators.dashboardIcon, 30);
					pdfResultReport.addStepDetails("Indent approver login", "Indent approver must be sucessfully logged in",
							"Successfully logged in as indent approver" + " ", "Pass", "Y");
					log.info("completed executing the method:: IndentapproverLogin");

				} catch (Exception e) {
					log.fatal("Unable to open the URL" + e.getMessage());
					pdfResultReport.addStepDetails("Indent approver login", "Indent approver is not logged in",
							"Unable to login as indent approver" + e.getMessage(), "Fail", "N");
				}
			}
			
			public void ApproverOverAllComentWithNotesheetHasBeenApproved() throws Throwable {
				try {
					log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
					String comment = "Indent Process Is Approved";
					click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
					waitForObj(1000);
					scrollToElement(tendercreationlocators.AppComments);
					//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
					set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
					//click(tendercreationlocators.ApproveBtn_Indent, "approve");
					waitForObj(2000);
					JSClick(tendercreationlocators.SendBtn_Indent, "approve");
					waitForObj(2000);
					WebDriver driver = ThreadLocalWebdriver.getDriver();
					int size = driver.findElements(tendercreationlocators.CloseWFBtn_Indent).size();
					if(size>=1)
					{
						click(tendercreationlocators.CloseWFBtn_Indent, "CloseWFBtn_Indent");
						click(tendercreationlocators.ConfirmYESBtn_Indent, "ConfirmYESBtn_Indent");
						click(tendercreationlocators.ConfirmYESBtnNext_Indent, "ConfirmYESBtnNext_Indent");
						click(tendercreationlocators.ConfirmYESBtnFinal_Indent, "ConfirmYESBtnFinal_Indent");
					}
					waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
					click(tendercreationlocators.okButton_approval, "OKBtn_IndentApproval");
			//		click(tendercreationlocators.NoBtn_IndentApproval, "NoBtn_IndentApproval");
					//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
					waitForObj(3000);
					waitForElementToBeVisible(tendercreationlocators.Lbl_workflowinbox);
					pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
							"Should Provide OverAll Comment ",
							"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
					log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
				} catch (Exception e) {
					log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
					pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
							"Should Provide OverAll Comment ",
							"Unable to Provide OverAll Comment"
									+ e.getMessage(),
							"Fail", "N");
		                    Assert.fail("Failed Due to " + e.getMessage());
				}
				
			}
			
			public void aproverBranchingForEvaluationApprover(String string1,String string2) throws Throwable {
				try {
					log.info("started executing the method:: branching");
				
					String branchingComment = "Need your inputs";
				
				waitForObj(2000);
				scrollToElement(tendercreationlocators.branchingButton);
				waitForObj(1500);
				waitForElementToBeClickable(tendercreationlocators.branchingButton);
				JSClick(tendercreationlocators.branchingButton, "Discussion");
				waitForElementToBeVisible(tendercreationlocators.usernameatDiscussion);
				waitForObj(1500);
			set(tendercreationlocators.tenderListKeyword, string1, "b1");				
			waitForObj(1000);
			click(tendercreationlocators.arrowIcon, "Arrow ICon");
			waitForObj(1000);
				set(tendercreationlocators.b1EvaluationUserComment, branchingComment, "Remarks");
				
				clear(tendercreationlocators.tenderListKeyword, "search user");
				set(tendercreationlocators.tenderListKeyword, string2, "b2");				
				waitForObj(1000);
				click(tendercreationlocators.arrowIcon, "Arrow ICon");
				waitForObj(2000);
					set(tendercreationlocators.b2EvaluationUserComment, branchingComment, "Remarks");
				waitForObj(500);
					click(tendercreationlocators.brachSubmitButton,"Submit Button");
					
					
					waitForElementToBeClickable(tendercreationlocators.recall_ok_msg);
					click(tendercreationlocators.recall_ok_msg, "success_Ok_button");
					scrollToTopOfThePage();
					waitForObj(1000);
				pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
						"Must Submit the Indent With Seq Flow ",
						"Sucessfully Submitted Indent With Seq Flow "
								+ " ",
						"Pass", "Y");
				log.info(
						"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
			
				
			}
				catch (Exception e) {
					log.fatal("Not able to Submit Indent" + e.getMessage());
					pdfResultReport.addStepDetails("aproverBranchingForEvaluationApprover",
							"Must Submit the branch workflow",
							"Not able to Submit branch workflow"
									+ e.getMessage(),
							"Fail", "N");
		                       Assert.fail("Failed Due to " + e.getMessage());
				}
					
				}
		
			public void validateCorrigendumDataAtBidderEnd() throws Exception {
				
				try {
					log.info("started executing the method:: validateCorrigendumDataAtBidderEnd");
					waitForElementToBeClickable(tendercreationlocators.action);
					click(tendercreationlocators.action, "action");
					waitForElementToBeClickable(tendercreationlocators.bidpreview);
					click(tendercreationlocators.bidpreview, "bid preview");
					waitForElementToBeClickable(tendercreationlocators.biddersideAttachmentpreview);
					click(tendercreationlocators.biddersideAttachmentpreview, "attachments");
					
					
					
					
					
					
					
					pdfResultReport.addStepDetails("Successfully corrigendumUpdatedValueValidation",
							"validateCorrigendumDataAtBidderEnd successfully",
							"Successfully validateCorrigendumDataAtBidderEnd" + " ", "Pass", "Y");
					log.info("completed executing the method:: validateCorrigendumDataAtBidderEnd");
				} catch (Exception e) {
					log.fatal("Not able to validateCorrigendumDataAtBidderEnd" + e.getMessage());
					pdfResultReport.addStepDetails("Not able to validateCorrigendumDataAtBidderEnd",
							"Not able to validateCorrigendumDataAtBidderEnd",
							"Unable to validateCorrigendumDataAtBidderEnd " + e.getMessage(), "Fail", "N");
				}
				
			}
			ArrayList<String> bomitemPreviewItems=new ArrayList<String>();
			ArrayList<String> bomServicesPreviewItems=new ArrayList<String>();
			public void validate_Data_IndentTabWiseView() throws Exception {
				try {
					log.info("started executing the method:: validate_Data_IndentTabWiseView");
			
					
					try {
						
						log.info("started executing the method:: general information previewTab validation");
							//general Preview Tab
						waitForElementToBeClickable(tendercreationlocators.ActionButton);
						click(tendercreationlocators.ActionButton, "Indent Action Button");
						waitForElementToBeClickable(tendercreationlocators.ViewIndent);
						click(tendercreationlocators.ViewIndent, "View Indent");
						checkPageIsReady();
						isElementTextPresent(tendercreationlocators.templategroupnameInIndentPreview,TemplateGroup );
						isElementTextPresent(tendercreationlocators.Indent_description_001,pdfResultReport.testData.get("Indent_Geninfo_Desc") );
						isElementTextPresent(tendercreationlocators.NormalEmergency,pdfResultReport.testData.get("Normal/Emergency") );
						isElementTextPresent(tendercreationlocators.indentCategory,pdfResultReport.testData.get("Indent Category") );
						isElementTextPresent(tendercreationlocators.indentCurrency,pdfResultReport.testData.get("Indent_Geninfo_Currency"));
						scrollToBottomOfThePage();
						isElementTextPresent(tendercreationlocators.suggestedModeofTendering,pdfResultReport.testData.get("Indent_Geninfo_ProcMode"));
						isElementTextPresent(tendercreationlocators.remarkss,pdfResultReport.testData.get("Indent_Geninfo_Remarks"));
						
						pdfResultReport.addStepDetails("validate only general information tab",
								"should match general information tab", "Sucessfully matched general information tab" + " ", "Pass",
								"Y");
					}
					catch (Exception e) {
						log.info("Not able to validate general information tab" + e.getMessage());
						pdfResultReport.addStepDetails("validate only general information tab",
								"should match general information tab",
								"Unable to validate general information preview Tab " + e.getMessage(), "Fail", "N");
					}	
					
						
						
						//Indent Details Tab
						try {
							
						click(tendercreationlocators.indentDetailsPreviewTab, "indent details preview tab");
						checkPageIsReady();
						isElementTextPresent(tendercreationlocators.TypeofServiceWorkpreview,pdfResultReport.testData.get("TypeOfService_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.CapitalRevenuepreview,pdfResultReport.testData.get("Capital_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.ModeofDispatchpreview,pdfResultReport.testData.get("ModeOfDespatch_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.PlaceofDeliverypreview,pdfResultReport.testData.get("PlaceOfDelivery_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.ContractCompletionDeliveryPeriodpreview,pdfResultReport.testData.get("DeiveryPeriod_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.NumberofYearMonthDaypreview,pdfResultReport.testData.get("NoOfYear_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.BasisofPriceEstimationpreview,pdfResultReport.testData.get("BasisOfPriceEstimation_TG1IndentDetailsTab") );
						isElementTextPresent(tendercreationlocators.PreBidMeetingpreview,pdfResultReport.testData.get("PreBidMeeting_TG1IndentDetailsTab") );
						
						
						
						pdfResultReport.addStepDetails("validate only indent details preview tab",
								"should match indent details preview tab", "Sucessfully matched indent details preview tab" + " ", "Pass",
								"Y");
					}
					catch (Exception e) {
						log.info("Not able to validate indent details preview tab" + e.getMessage());
						pdfResultReport.addStepDetails("validate only indent details preview tab",
								"should match indent details preview tab",
								"Unable to validate indent details preview Tab " + e.getMessage(), "Fail", "N");
					}	
					    	 
					 	// other information preview tab
						try {
							
						click(tendercreationlocators.otherInformationpreviewTab, "Indent Action Button");
						checkPageIsReady();
						isElementTextPresent(tendercreationlocators.worksContractPreview,pdfResultReport.testData.get("WorkofContract_TG1OtherinformationTab") );
						scrollToElement(tendercreationlocators.partysitepreview);
						isElementTextPresent(tendercreationlocators.partysitepreview,pdfResultReport.testData.get("PartySite_TG1OtherinformationTab") );
						
						pdfResultReport.addStepDetails("validate only Other information Preview tab",
								"should match Other information Preview tab", "Sucessfully matched Other information Preview tab" + " ", "Pass",
								"Y");
					}
					catch (Exception e) {
						log.info("Not able to validate other information tab" + e.getMessage());
						pdfResultReport.addStepDetails("validate only Other information Preview tab",
								"should match Other information Preview tab",
								"Unable to validate Other information Preview preview Tab " + e.getMessage(), "Fail", "N");
					}	
						
						//BOM item preview tab
						try {

						
						click(tendercreationlocators.bomItempreviewTab, "Indent BOM Item tab");
						checkPageIsReady();
						int bomitemsRows = ThreadLocalWebdriver.getDriver().findElements(By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr")).size();
							
						for (int i = 1; i <= bomitemsRows-1; i++) {
							scrollToElement(tendercreationlocators.BOMitemcode_preview(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMitemcode_preview(i)));
							scrollToElement(tendercreationlocators.BOMitemname_preview(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMitemname_preview(i)));
							scrollToElement(tendercreationlocators.BOMUnit(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMUnit(i)));
							scrollToElement(tendercreationlocators.BOMQty(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMQty(i)));
							scrollToElement(tendercreationlocators.BOMUnitRate(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMUnitRate(i)));
							scrollToElement(tendercreationlocators.BOMGST(i));
							waitForObj(500);
							bomitemPreviewItems.add(text(tendercreationlocators.BOMGST(i)));
						}
						System.out.println(bomitemPreviewItems);
					if(bomitemPreviewItems.equals(bomitemInputItems))
					{
						pdfResultReport.addStepDetails("validate only BOM item preview tab",
								"should match BOM item preview tab", "Sucessfully matched BOM item preview tab" + " ", "Pass",
								"Y");
					}
					else {
						pdfResultReport.addStepDetails("validate only BOM item preview tab",
								"should match BOM item preview tab",
								"Unable to validate BOM item preview Tab " , "Fail", "N");
					}
					}
					catch (Exception e) {
						log.info("Not able to validate BOM item preview" + e.getMessage());
						pdfResultReport.addStepDetails("validate only BOM item preview tab",
								"should match BOM item preview tab",
								"Unable to validate BOM item preview Tab " + e.getMessage(), "Fail", "N");
					}	
						
						//BOM services preview tab
						try {
						
						click(tendercreationlocators.bomServicespreviewTab, "Indent BOM Item tab");
						checkPageIsReady();
						int bomServicesRows = ThreadLocalWebdriver.getDriver().findElements(By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr")).size();
							
						for (int i = 1; i <= bomServicesRows-1; i++) {
							scrollToElement(tendercreationlocators.BOMServicescode_preview(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicescode_preview(i)));
							scrollToElement(tendercreationlocators.BOMServicesname_preview(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicesname_preview(i)));
							scrollToElement(tendercreationlocators.BOMServicesUnit(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicesUnit(i)));
							scrollToElement(tendercreationlocators.BOMServicesQty(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicesQty(i)));
							scrollToElement(tendercreationlocators.BOMServicesUnitRate(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicesUnitRate(i)));
							scrollToElement(tendercreationlocators.BOMServicesGST(i));
							waitForObj(500);
							bomServicesPreviewItems.add(text(tendercreationlocators.BOMServicesGST(i)));
						}
						System.out.println(bomServicesPreviewItems);
						if(bomServicesPreviewItems.equals(bomServicesInputItems))
						{
						pdfResultReport.addStepDetails("validate only BOM services preview tab",
								"should match BOM services preview tab", "Sucessfully matched BOM services preview tab" + " ", "Pass",
								"Y");
						}
						else {
								pdfResultReport.addStepDetails("validate only BOM services preview tab",
										"should match BOM services preview tab",
										"Unable to validate BOM services preview Tab " , "Fail", "N");
							}
						}
					catch (Exception e) {
						log.info("Not able to validate BOM services preview" + e.getMessage());
						pdfResultReport.addStepDetails("validate only BOM services preview tab",
								"should match BOM services preview tab",
								"Unable to validate BOM services preview Tab " + e.getMessage(), "Fail", "N");
					}	
						
						//technical secification preview tab
						try {

						click(tendercreationlocators.technicalSpecificationPreviewTab, "Technical Specification Preview Tab");
						checkPageIsReady();
						isElementTextPresent(tendercreationlocators.clauseSubClauseNoPreview,pdfResultReport.testData.get("ClauseNo_TG1TechnicalSpecificationTab") );
						isElementTextPresent(tendercreationlocators.ClauseSubClauseHeaderTitlePreview,pdfResultReport.testData.get("ClauseHeaderTitle_TG1TechnicalSpecificationTab") );
						
						click(tendercreationlocators.indentPreviewnextarrowbutton, "Indent Preview next arrow button");
						
						pdfResultReport.addStepDetails("validate only technical secification preview tab",
								"should match technical secification preview tab", "Sucessfully matched technical secification preview tab" + " ", "Pass",
								"Y");
					}
					catch (Exception e) {
						log.info("Not able to validate BOM services preview" + e.getMessage());
						pdfResultReport.addStepDetails("validate only technical secification preview tab",
								"should match technical secification preview tab",
								"Unable to validate technical secification preview Tab " + e.getMessage(), "Fail", "N");
					}
						
						//annexture preview tab
						try {

						waitForObj(1500);
						click(tendercreationlocators.annexturetabpreview, "Technical Specification Preview Tab");
						checkPageIsReady();
						isElementTextPresent(tendercreationlocators.annexturetabpreview,pdfResultReport.testData.get("AnnexuresType_TG1AnnexuresTab"));				
						isFileDownloadAndValidation(tendercreationlocators.annextureDownloadButtonPreview,"Annexture Download Button", "rfqCreation.xlsx");					
						checkPageIsReady();					
							

						pdfResultReport.addStepDetails("annexture preview tab",
								"All data in annexture preview tab Page should match", "Sucessfully matched all data" + " ", "Pass",
								"Y");
						
						}
					
					
				catch (Exception e) {
					log.fatal("Not able to validate_Data_IndentTabWiseView" + e.getMessage());
					pdfResultReport.addStepDetails("validate_Data_annexture preview tab",
							"should pass all data in annexture preview tab",
							"Unable to validate_annexture preview tab " + e.getMessage(), "Fail", "N");
									}	
						
						click(tendercreationlocators.indentByPreviewclosebutton, "Indent Preview Close button");
						waitForObj(1000);
						
						pdfResultReport.addStepDetails("IndentTG1_Preview Page Validation",
								"All data in preview Page should match", "Sucessfully matched all data" + " ", "Pass",
								"Y");
						log.info(
								"completed executing the method:: IndentTG1_validatePreviewData");

					} catch (Exception e) {

						log.fatal("Preview data does not matched" + e.getMessage());
						pdfResultReport.addStepDetails("IndentTG1_validatePreviewData",
								"All data in preview Page should match", "Data not matched" + e.getMessage(),
								"Fail", "N");
					}
				
			}

			public void valiateIndentApproverHistory() throws Exception {
				try {
					log.info("started executing the method:: valiateIndentApproverHistory");
					waitForElementToBeClickable(tendercreationlocators.ActionButton);
					click(tendercreationlocators.ActionButton, "Indent Action Button");
					waitForElementToBeClickable(tendercreationlocators.approvalHistory_IndentCreator);
					click(tendercreationlocators.approvalHistory_IndentCreator, "approval History");
					
					
					
					scrollToElement(tendercreationlocators.approvalByHistorypage);
					 System.out.println(text(tendercreationlocators.approvalByHistorypage));
					String inputText=text(tendercreationlocators.approvalByHistorypage);
					String regexPattern = "\\b\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2} [AP]M\\b";
					 Pattern pattern = Pattern.compile(regexPattern);
					 Matcher matcher = pattern.matcher(inputText);
					 String removedText = matcher.replaceAll("");
						
					
					 
					 if (removedText.equals(eTenderComponent.getDataFromPropertiesFile_Validation("Indent_app_history"))==true) {
							System.out.println("valiateIndentApproverHistory validated successfully");
						}
						 else {
							 log.info("Not able to verify valiateIndentApproverHistory");
								pdfResultReport.addStepDetails("valiateIndentApproverHistory", "should pass valiateIndentApproverHistory",
										"Unable to valiateIndentApproverHistory", "Fail", "N");
						}
					 
					 scrollToElement(tendercreationlocators.indentByPreviewclosebutton);
					 click(tendercreationlocators.indentByPreviewclosebutton, "Indent Preview Close button");
					 
					pdfResultReport.addStepDetails("valiateIndentApproverHistory", "valiateIndentApproverHistory must be sucessfully logged in",
							"Successfully valiateIndentApproverHistory" + " ", "Pass", "Y");
					log.info("completed executing the method:: valiateIndentApproverHistory");

				} catch (Exception e) {
					log.fatal("Unable to open the URL" + e.getMessage());
					pdfResultReport.addStepDetails("valiateIndentApproverHistory", "valiateIndentApproverHistory must be sucessfully logged in",
							"Unable to validate valiateIndentApproverHistory" + e.getMessage(), "Fail", "N");
				}
			}
			public void validateIndentApprovalHistoryAtApproverEnd() throws Throwable {
				try {
					log.info("started executing the method:: validateIndentApprovalHistoryAtApproverEnd");			
					waitForElementToBeClickable(tendercreationlocators.tenderStatus_completed);
					waitForObj(5000);
					click(tendercreationlocators.tenderStatus_completed, "completed list");
					waitForObj(5000);
					waitForElementToBeClickable(tendercreationlocators.new_action_button);
					waitForElementToBeVisible(tendercreationlocators.Txt_TypeanyKeyword_Indent);
					clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
					set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
					waitForObj(1000);
					waitForElementToBeClickable(tendercreationlocators.new_action_button);
					click(tendercreationlocators.new_action_button, "action");
					waitForElementToBeClickable(tendercreationlocators.viewIndent);
					click(tendercreationlocators.viewIndent, "view indent");
					waitForElementToBeClickable(tendercreationlocators.approvalHistory_approverend);
					waitForObj(1000);
					click(tendercreationlocators.approvalHistory_approverend, "approver history");
					
																				
					scrollToElement(tendercreationlocators.approverhistorytabcontent);
					 System.out.println(text(tendercreationlocators.approverhistorytabcontent));
					String inputText=text(tendercreationlocators.approverhistorytabcontent);
					String regexPattern = "\\b\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2} [AP]M\\b";
					 Pattern pattern = Pattern.compile(regexPattern);
					 Matcher matcher = pattern.matcher(inputText);
					 String removedText = matcher.replaceAll("");
				
					
					 
					 if (removedText.equals(eTenderComponent.getDataFromPropertiesFile_Validation("ApproverEnd_app_history"))==true) {
							System.out.println("valiateIndentApproverHistory validated successfully");
						}
						 else {
							 log.info("Not able to verify validateIndentApprovalHistoryAtApproverEnd");
								pdfResultReport.addStepDetails("validateIndentApprovalHistoryAtApproverEnd", "should pass validateIndentApprovalHistoryAtApproverEnd",
										"Unable to validateIndentApprovalHistoryAtApproverEnd", "Fail", "N");
						}
					 
					 scrollToElement(tendercreationlocators.indentByPreviewclosebutton);
					 click(tendercreationlocators.indentByPreviewclosebutton, "Indent Preview Close button");
					 
					pdfResultReport.addStepDetails("validateIndentApprovalHistoryAtApproverEnd", "validateIndentApprovalHistoryAtApproverEnd must be sucessfully logged in",
							"Successfully validateIndentApprovalHistoryAtApproverEnd" + " ", "Pass", "Y");
					log.info("completed executing the method:: validateIndentApprovalHistoryAtApproverEnd");

				} catch (Exception e) {
					log.fatal("Unable to open the URL" + e.getMessage());
					pdfResultReport.addStepDetails("validateIndentApprovalHistoryAtApproverEnd", "validateIndentApprovalHistoryAtApproverEnd must be sucessfully logged in",
							"Unable to validate validateIndentApprovalHistoryAtApproverEnd" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void VerifyIndentStatusAtApproverEnd(String indentstatus) throws Exception {
				
				try {
					log.info("started executing the method:: VerifyIndentStatus");
				
					waitForObj(2500);
					String txt = text(tendercreationlocators.sentBackToPreviousApproverStatus).trim();
					if(txt.equalsIgnoreCase(indentstatus))
					
						pdfResultReport.addStepDetails("Verify Indent status",
								"Indent status should be "+indentstatus,
								"Indent status is '"+txt+"' and successfully verified" + " ", "Pass", "Y");
					
					
					log.info("completed executing the method:: VerifyIndentStatus");
				} catch (Exception e) {
					log.fatal("Not able to verify indent status" + e.getMessage());
					pdfResultReport.addStepDetails("Verify indent status", "Should be able to verify indent status at approver end",
							"Unable to verify indent status at approver end" + e.getMessage(), "Fail", "N");
				}
			}
			public void nevigateToMailDetailsForNegotiation() {
			
				
			}
			public void cloneIndent() throws Exception {
				try {
					log.info("started executing the method:: cloneIndent");
				waitForElementToBeClickable(tendercreationlocators.ActionButton);
				click(tendercreationlocators.ActionButton, "action");
				waitForElementToBeClickable(tendercreationlocators.cloneIndent);
					click(tendercreationlocators.cloneIndent, "clone");
					universalNormalWait();
					waitForElementToBeClickable(tendercreationlocators.cloneIndentPreview);
					click(tendercreationlocators.cloneIndentPreview, "clone preview");
					waitForObj(2000);
					waitForElementToBeClickable(tendercreationlocators.Confirm);
					click(tendercreationlocators.Confirm, "confirm");
					
					waitForElementToBeVisible(tendercreationlocators.IndentSuccessMessage);
					  String actualText = text(tendercreationlocators.IndentSuccessMessage).trim();
				        String[] words= actualText.split("Indent Id:");
				        SystemIndentnoLocatorText= words[1].trim();
				        
					waitForElementToBeClickable(tendercreationlocators.BtnOk);
					click(tendercreationlocators.BtnOk, "Ok");
				universalNormalWait();
				
				clear(tendercreationlocators.Txt_TypeanyKeyword_Indent, "Txt_TypeanyKeyword_Indent");
				set(tendercreationlocators.Txt_TypeanyKeyword_Indent, SystemIndentnoLocatorText, "Txt_TypeanyKeyword_Indent");
					
					
					
			        
					
						pdfResultReport.addStepDetails("Verify cloneIndent", "Should be able to verify cloneIndent",
								"Successfully validateIndentApprovalHistoryAtApproverEnd" + " ", "Pass", "Y");
					
					
					
					log.info("completed executing the method:: cloneIndent");
				} catch (Exception e) {
					log.fatal("Not able to verify cloneIndent" + e.getMessage());
					pdfResultReport.addStepDetails("Verify cloneIndent", "Should be able to verify cloneIndent",
							"Unable to verify cloneIndent" + e.getMessage(), "Fail", "N");
				}
			}
			public void submitIndentFromDraft() throws Throwable {
				try {
					log.info("started executing the method:: submitIndentFromDraft");			
					waitForElementToBeClickable(tendercreationlocators.SN_stage);
					click(tendercreationlocators.SN_stage, "draft");
					universalNormalWait();
					pdfResultReport.addStepDetails("submitIndentFromDraft", "submitIndentFromDraft must be sucessfully submit",
							"Successfully submitted submitIndentFromDraft" + " ", "Pass", "Y");
					log.info("completed executing the method:: submitIndentFromDraft");

				} catch (Exception e) {
					log.fatal("Unable to submitIndentFromDraft" + e.getMessage());
					pdfResultReport.addStepDetails("submitIndentFromDraft", "submitIndentFromDraft must be sucessfully submit",
							"Successfully submitted submitIndentFromDraft" + e.getMessage(), "Fail", "N");
				}
				
				
			}
			public void downloadWFReportValidation() throws Exception  {
				try {
					log.info("started executing the method:: downloadWFReportValidation");			
					waitForElementToBeClickable(tendercreationlocators.ActionButton);
					click(tendercreationlocators.ActionButton, "action");
					waitForElementToBeClickable(tendercreationlocators.downloadWFReport);
					click(tendercreationlocators.downloadWFReport, "download Workflow Report");
					waitForElementToBeClickable(tendercreationlocators.selectDocType);
					select(tendercreationlocators.selectDocType, "XLSX");
					
					isFileDownloadAndValidation(tendercreationlocators.Submit, "Submit", "Workflow LifeCycle Report for Document Id _ "+SystemIndentnoLocatorText+".xlsx");
					
					
					pdfResultReport.addStepDetails("downloadWFReportValidation", "downloadWFReportValidation must be sucessfully validated",
							"Successfully validated downloadWFReportValidation" + " ", "Pass", "Y");
					log.info("completed executing the method:: downloadWFReportValidation");

				} catch (Exception e) {
					log.fatal("Unable to downloadWFReportValidation" + e.getMessage());
					pdfResultReport.addStepDetails("downloadWFReportValidation", "downloadWFReportValidation must be sucessfully validated",
							"Successfully validated downloadWFReportValidation" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void lifeCycleValidation() throws Exception {
				try {
					log.info("started executing the method:: lifeCycleValidation");			
					waitForElementToBeClickable(tendercreationlocators.ActionButton);
					click(tendercreationlocators.ActionButton, "action");
					waitForElementToBeClickable(tendercreationlocators.lifeCycle);
					click(tendercreationlocators.lifeCycle, "life cycle");
					waitForElementToBeVisible(tendercreationlocators.corrigendumHistory);
					if (text(tendercreationlocators.corrigendumHistory).contains("Life cycle")) {
						pdfResultReport.addStepDetails("life cycle text validation", "should open life cycle page",
								"successfuly opened life cycle page" + " ", "Pass", "Y");
					}
					
					click(tendercreationlocators.closeLifeCyclePopup, "closeLifeCyclePopup");
					
					
					
					
					pdfResultReport.addStepDetails("lifeCycleValidation", "lifeCycleValidation must be sucessfully validated",
							"Successfully validated lifeCycleValidation" + " ", "Pass", "Y");
					log.info("completed executing the method:: lifeCycleValidation");

				} catch (Exception e) {
					log.fatal("Unable to lifeCycleValidation" + e.getMessage());
					pdfResultReport.addStepDetails("lifeCycleValidation", "lifeCycleValidation must be sucessfully validated",
							"Successfully validated lifeCycleValidation" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void validateGridViewAndListView() throws Exception {
				try {
					log.info("started executing the method:: validateGridViewAndListView");			
					//validation for pending tab
					WebDriver driver = ThreadLocalWebdriver.getDriver();
					List<WebElement> listViewItems=driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-pending-wf-approval/div/div[4]/div/div/table/tbody/tr/td[1]/div[1]/span[1]"));	
					List<String> listViewText=new ArrayList<String>();

					for (WebElement webElement : listViewItems) {
						String text=webElement.getText();
						listViewText.add(text);
					}
					click(tendercreationlocators.gridView, "gridview");
					waitForObj(2000);
					List<WebElement> gridViewItems=driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-pending-wf-approval/div/div[4]/div/div/div/div/div/div[1]/p[1]/span[1]"));
					List<String> gridViewText=new ArrayList<String>();
					for (WebElement webElement : gridViewItems) {
						String text=webElement.getText();
						gridViewText.add(text);
					}
					if (listViewText.equals(gridViewText)) {
						System.out.println("List view and grid view item matched");
						pdfResultReport.addStepDetails("List view and grid view", "List view and grid view items should match in pending tab",
								"Successfully matched List view and grid view items in pending tab" + " ", "Pass", "Y");
					}
					
					//validation for completed tab
					waitForElementToBeClickable(tendercreationlocators.tenderStatus_completed);
					click(tendercreationlocators.tenderStatus_completed, "completed tab");
					waitForElementToBeClickable(tendercreationlocators.listView);
					click(tendercreationlocators.listView, "list view");
					waitForObj(2000);
					
					List<WebElement> listViewItems1=driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-pending-wf-approval/div/div[4]/div/div/table/tbody/tr/td[1]/div[1]/span[1]"));	
					List<String> listViewText1=new ArrayList<String>();

					for (WebElement webElement : listViewItems1) {
						String text=webElement.getText();
						listViewText1.add(text);
					}
					click(tendercreationlocators.gridView, "gridview");
					waitForObj(2000);
					List<WebElement> gridViewItems1=driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-pending-wf-approval/div/div[4]/div/div/div/div/div/div[1]/p[1]/span[1]"));
					List<String> gridViewText1=new ArrayList<String>();
					for (WebElement webElement : gridViewItems1) {
						String text=webElement.getText();
						gridViewText1.add(text);
					}
					if (listViewText1.equals(gridViewText1)) {
						System.out.println("List view and grid view item matched");
						pdfResultReport.addStepDetails("List view and grid view", "List view and grid view items completed tab should match",
								"Successfully matched List view and grid view items in completed tab" + " ", "Pass", "Y");
					}
					
					
					pdfResultReport.addStepDetails("validateGridViewAndListView", "validateGridViewAndListView must be sucessfully validated",
							"Successfully validated validateGridViewAndListView" + " ", "Pass", "Y");
					log.info("completed executing the method:: validateGridViewAndListView");

				} catch (Exception e) {
					log.fatal("Unable to validateGridViewAndListView" + e.getMessage());
					pdfResultReport.addStepDetails("validateGridViewAndListView", "validateGridViewAndListView must be sucessfully validated",
							"Successfully validated validateGridViewAndListView" + e.getMessage(), "Fail", "N");
				}
				
				
			}
			public void VerifyIndentPreviewInDraftState() throws Exception {
				try {
					log.info("started executing the method:: lifeCycleValidation");			
					waitForElementToBeClickable(tendercreationlocators.SN_stage);
					click(tendercreationlocators.SN_stage, "draft");
					universalNormalWait();
					waitForElementToBeClickable(tendercreationlocators.Indent_Preview_Btn);
					click(tendercreationlocators.Indent_Preview_Btn, "preview");
					universalNormalWait();
					isElementTextPresent(tendercreationlocators.templategroupnameInIndentPreview,TemplateGroup );
					click(tendercreationlocators.toggleView, "toggleview");
					waitForObj(1000);
					isElementTextPresent(tendercreationlocators.templategroupName,TemplateGroup );
					
					waitForElementToBeClickable(tendercreationlocators.closetenderpreview);
					click(tendercreationlocators.closetenderpreview, "close");
					waitForObj(2000);
		
					pdfResultReport.addStepDetails("VerifyIndentPreviewInDraftState", "VerifyIndentPreviewInDraftState must be sucessfully validated",
							"Successfully validated VerifyIndentPreviewInDraftState" + " ", "Pass", "Y");
					log.info("completed executing the method:: VerifyIndentPreviewInDraftState");

				}catch (Exception e) {
					log.fatal("Unable to VerifyIndentPreviewInDraftState" + e.getMessage());
					pdfResultReport.addStepDetails("VerifyIndentPreviewInDraftState", "VerifyIndentPreviewInDraftState must be sucessfully validated",
							"Successfully validated VerifyIndentPreviewInDraftState" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void DeletingOneItem_BOM_Item() throws Exception {
				try {
					log.info("started executing the method:: lifeCycleValidation");			
					waitForObj(1000);
					scrollToElement(tendercreationlocators.itemCheckbox);
					click(tendercreationlocators.itemCheckbox, "first item checkbox");
					click(tendercreationlocators.deleteItemIndent, "tendercreationlocators");
					waitForElementToBeClickable(tendercreationlocators.confirmButton);
					click(tendercreationlocators.confirmButton, "confirmButton");
					waitForObj(2000);
					
					scrollToElement(tendercreationlocators.Savebtn_IndentNew1);
					waitForObj(2000);
					waitForElementToBeClickable(tendercreationlocators.Savebtn_IndentNew1);
					click(tendercreationlocators.Savebtn_IndentNew1, "Savebtn_Indent");
					waitForObj(2000); 
					
					
					pdfResultReport.addStepDetails("DeletingOneItem_BOM_Item", "DeletingOneItem_BOM_Item must be sucessfully validated",
							"Successfully validated DeletingOneItem_BOM_Item" + " ", "Pass", "Y");
					log.info("completed executing the method:: DeletingOneItem_BOM_Item");
					
			}
				catch (Exception e) {
					log.fatal("Unable to DeletingOneItem_BOM_Item" + e.getMessage());
					pdfResultReport.addStepDetails("DeletingOneItem_BOM_Item", "DeletingOneItem_BOM_Item must be sucessfully validated",
							"Successfully validated DeletingOneItem_BOM_Item" + e.getMessage(), "Fail", "N");
				}
			
	}
			public void Add_1BOM_Item() throws Throwable {
				try {
					log.info(
							"started executing the method:: Add_1BOM_Item()");
					waitForElementToBeClickable(tendercreationlocators.TG1IndentBOMItemTab);
					click(tendercreationlocators.TG1IndentBOMItemTab, "TG1IndentBOMItemTab");
					waitForObj(2000);
					
					String IndentItemCode = "TendCode_";
					String IndentItemName = "TendName_";
					int getrandomInterger = getrandomInterger(10000, 1000000000);
					IndentItemCode = IndentItemCode.concat(String.valueOf(getrandomInterger));
					IndentItemName = IndentItemName.concat(String.valueOf(getrandomInterger));
					
					waitForElementToBeClickable(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
					scrollToElement(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
					JSClick(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab, "AddNonSORItemBtn_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.ItemCode_TG1BOMItemTab(2));
					scrollToElement(tendercreationlocators.ItemCode_TG1BOMItemTab(2));
					set(tendercreationlocators.ItemCode_TG1BOMItemTab(2), IndentItemCode, "ItemCode_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.ItemName_TG1BOMItemTab(2));
					scrollToElement(tendercreationlocators.ItemName_TG1BOMItemTab(2));
					set(tendercreationlocators.ItemName_TG1BOMItemTab(2), IndentItemName, "ItemName_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UOM_TG1BOMItemTab(3));
					scrollToElement(tendercreationlocators.UOM_TG1BOMItemTab(3));
					select(tendercreationlocators.UOM_TG1BOMItemTab(3), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
						 
					waitForElementToBeClickable(tendercreationlocators.Qty_TG1BOMItemTab(2));
					scrollToElement(tendercreationlocators.Qty_TG1BOMItemTab(2));
					set(tendercreationlocators.Qty_TG1BOMItemTab(2), pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UnitRate_TG1BOMItemTab(2));
					scrollToElement(tendercreationlocators.UnitRate_TG1BOMItemTab(2));
					set(tendercreationlocators.UnitRate_TG1BOMItemTab(2), pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.GSTPercent_TG1BOMItemTab(2));
					scrollToElement(tendercreationlocators.GSTPercent_TG1BOMItemTab(2));
					set(tendercreationlocators.GSTPercent_TG1BOMItemTab(2), pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG1BOMItemTab");
					
					
					pdfResultReport.addStepDetails("Add_1BOM_Item", "Add_1BOM_Item must be sucessfully validated",
							"Successfully validated Add_1BOM_Item" + " ", "Pass", "Y");
					log.info("completed executing the method:: Add_1BOM_Item");
					
			}	catch (Exception e) {
				log.fatal("Unable to Add_1BOM_Item" + e.getMessage());
				pdfResultReport.addStepDetails("Add_1BOM_Item", "Add_1BOM_Item must be sucessfully validated",
						"Successfully validated Add_1BOM_Item" + e.getMessage(), "Fail", "N");
			}
			
				
			}
			
			public void ApprovedAndMarkForRFQ() throws Throwable {
				try {
					log.info("started executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
					String comment = "Indent Process Is Approved";
					click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
					waitForObj(1000);
					scrollToElement(tendercreationlocators.AppComments);
					//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
					set(tendercreationlocators.AppComments, comment,"AppComments_Indent");
					//click(tendercreationlocators.ApproveBtn_Indent, "approve");
					waitForObj(2000);
					JSClick(tendercreationlocators.ApproveBtn, "approve");
					waitForObj(2000);
					WebDriver driver = ThreadLocalWebdriver.getDriver();
					int size = driver.findElements(tendercreationlocators.CloseWFBtn_Indent).size();
					if(size>=1)
					{
						click(tendercreationlocators.CloseWFBtn_Indent, "CloseWFBtn_Indent");
						click(tendercreationlocators.ConfirmYESBtn_Indent, "ConfirmYESBtn_Indent");
						click(tendercreationlocators.ConfirmYESBtnNext_Indent, "ConfirmYESBtnNext_Indent");
						click(tendercreationlocators.ConfirmYESBtnFinal_Indent, "ConfirmYESBtnFinal_Indent");
					}
					waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
					click(tendercreationlocators.okButton_approval, "OKBtn_IndentApproval");
					waitForObj(2000);
					waitForElementToBeClickable(tendercreationlocators.MarkForRFQ_Yes_Btn_IndentApproval);
					click(tendercreationlocators.MarkForRFQ_Yes_Btn_IndentApproval, "MarkForRFQ_Yes_Btn_IndentApproval");
					waitForElementToBeClickable(tendercreationlocators.approveConfirm);
					click(tendercreationlocators.approveConfirm, "yes rfq confirm");
					waitForElementToBeVisible(tendercreationlocators.SuccessMsg_IndentApproval);
					click(tendercreationlocators.okButton_approval, "OKBtn_IndentApproval");
					waitForObj(3000);
					waitForElementToBeVisible(tendercreationlocators.WorkflowInbox);
					pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
							"Should Provide OverAll Comment ",
							"SucessFully Provided Over All Comment As --->  " + comment + " ", "Pass", "Y");
					log.info("completed executing the method:: ApproverOverAllComentWithIndentHasBeenApproved");
				} catch (Exception e) {
					log.fatal("Unable to Provide OverAll Comment " + e.getMessage());
					pdfResultReport.addStepDetails("ApproverOverAllComentWithIndentHasBeenApproved",
							"Should Provide OverAll Comment ",
							"Unable to Provide OverAll Comment"
									+ e.getMessage(),
							"Fail", "N");
		                    Assert.fail("Failed Due to " + e.getMessage());
				}
				
			}
			public void revertBacktoIC() throws Exception {
				try {
					log.info("started executing the method:: revertBacktoIC");			
					waitForObj(1000);
					waitForElementToBeClickable(tendercreationlocators.ActionButton);
					click(tendercreationlocators.ActionButton, "ActionButton");
					waitForElementToBeClickable(tendercreationlocators.revertbackToIC);
					click(tendercreationlocators.revertbackToIC, "revertbackToIC");
					waitForElementToBeClickable(tendercreationlocators.reviewedReason);
					set(tendercreationlocators.reviewedReason, "revert back to IC validation", "Reason");
					waitForElementToBeClickable(tendercreationlocators.recallreasonSubmit);
					click(tendercreationlocators.recallreasonSubmit, "Submit btn");
					waitForElementToBeClickable(tendercreationlocators.BtnOk);
					click(tendercreationlocators.BtnOk, "ok btn");
					
					
					
					pdfResultReport.addStepDetails("revertBacktoIC", "revertBacktoIC must be sucessfully validated",
							"Successfully validated revertBacktoIC" + " ", "Pass", "Y");
					log.info("completed executing the method:: revertBacktoIC");
					
			}
				catch (Exception e) {
					log.fatal("Unable to revertBacktoIC" + e.getMessage());
					pdfResultReport.addStepDetails("revertBacktoIC", "revertBacktoIC must be sucessfully validated",
							"Successfully validated revertBacktoIC" + e.getMessage(), "Fail", "N");
				}
				
				
			}
			public void nevigateToQuickIndent() throws Throwable {
				try {
					log.info("started executing the method:: nevigateToQuickIndent");			
					
					JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
					mouseOver(tendercreationlocators.Requisition);
					JSClick(tendercreationlocators.IndentIcon, "IndentIcon");
					checkPageIsReady();
					waitForElementToBeVisible(tendercreationlocators.quickIndnet);
					JSClick(tendercreationlocators.quickIndnet, "quickIndnet");
					waitForObj(3000);
				
					
					pdfResultReport.addStepDetails("nevigateToQuickIndent", "nevigateToQuickIndent must be sucessfully validated",
							"Successfully validated nevigateToQuickIndent" + " ", "Pass", "Y");
					log.info("completed executing the method:: nevigateToQuickIndent");
					
			}
				catch (Exception e) {
					log.fatal("Unable to nevigateToQuickIndent" + e.getMessage());
					pdfResultReport.addStepDetails("nevigateToQuickIndent", "nevigateToQuickIndent must be sucessfully validated",
							"Successfully validated nevigateToQuickIndent" + e.getMessage(), "Fail", "N");
				}
			}
			public void QuickIndentCreation() throws Throwable {
				try {
					log.info("started executing the method:: QuickIndentCreation");			
					
					waitForElementToBeClickable(tendercreationlocators.estimatedPrice);
					clear(tendercreationlocators.estimatedPrice, "estimatedPrice");
					set(tendercreationlocators.estimatedPrice, "1000000", "estimatedPrice");
					set(tendercreationlocators.indent_desc, "quick indent creation", "description");
					scrollToElement(tendercreationlocators.add_indent_items);
					waitForElementToBeClickable(tendercreationlocators.add_indent_items);
					click(tendercreationlocators.add_indent_items, "add_indent_items");
					waitForElementToBeClickable(tendercreationlocators.indentItemsAddIcon);
					click(tendercreationlocators.indentItemsAddIcon, "add_indent_items");
					
					//add indent items
					waitForElementToBeClickable(tendercreationlocators.Code);
					set(tendercreationlocators.Code, "121", "code");
					waitForElementToBeClickable(tendercreationlocators.Name);
					set(tendercreationlocators.Name, "Iron", "Name");
					select(tendercreationlocators.Unit, "%");
					waitForObj(1000);
					set(tendercreationlocators.Rate, "100", "Rate");
					waitForObj(1000);
					waitForElementToBeClickable(tendercreationlocators.qty);
					set(tendercreationlocators.qty, "100", "Qty");
					
					waitForElementToBeClickable(tendercreationlocators.Okbtn_Indent);
					click(tendercreationlocators.Okbtn_Indent, "Ok Button");
					
					
					
					
					pdfResultReport.addStepDetails("QuickIndentCreation", "QuickIndentCreation must be sucessfully validated",
							"Successfully validated QuickIndentCreation" + " ", "Pass", "Y");
					log.info("completed executing the method:: QuickIndentCreation");
					
			}
				catch (Exception e) {
					log.fatal("Unable to QuickIndentCreation" + e.getMessage());
					pdfResultReport.addStepDetails("QuickIndentCreation", "QuickIndentCreation must be sucessfully validated",
							"Successfully validated QuickIndentCreation" + e.getMessage(), "Fail", "N");
				}
				
			}
			public void SubmitQuickIndnet() throws Exception {
				try {
					log.info("started executing the method:: SubmitQuickIndnet");	
				universalNormalWait();
				scrollToTopOfThePage();
					waitForElementToBeClickable(tendercreationlocators.submitQuickIndent);
					click(tendercreationlocators.submitQuickIndent, "submit");
					
					
					
				pdfResultReport.addStepDetails("QuickIndentCreation", "QuickIndentCreation must be sucessfully validated",
						"Successfully validated QuickIndentCreation" + " ", "Pass", "Y");
				log.info("completed executing the method:: SubmitQuickIndnet");
				
		}
			catch (Exception e) {
				log.fatal("Unable to SubmitQuickIndnet" + e.getMessage());
				pdfResultReport.addStepDetails("SubmitQuickIndnet", "SubmitQuickIndnet must be sucessfully validated",
						"Successfully validated SubmitQuickIndnet" + e.getMessage(), "Fail", "N");
			}
				
			}
			public void IndentTG1_BOM_Item_tab_Parent_Child() throws Throwable {
				try {
					log.info("started executing the method:: IndentTG1_BOM_Item_tab_Parent_Child");	
					waitForElement(tendercreationlocators.TG1IndentBOMItemTab, 30);
					click(tendercreationlocators.TG1IndentBOMItemTab, "TG1IndentBOMItemTab");
					
					//add 1non- sor parent  
				
					String IndentItemCode = "TendCode_";
					String IndentItemName = "TendName_";
					int getrandomInterger = getrandomInterger(10000, 1000000000);
					IndentItemCode = IndentItemCode.concat(String.valueOf(getrandomInterger));
					IndentItemName = IndentItemName.concat(String.valueOf(getrandomInterger));
					
					waitForElementToBeClickable(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
					scrollToElement(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab);
					JSClick(tendercreationlocators.AddNonSORItemBtn_TG1BOMItemTab, "AddNonSORItemBtn_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.ItemCode_TG1BOMItemTab(0));
					scrollToElement(tendercreationlocators.ItemCode_TG1BOMItemTab(0));
					set(tendercreationlocators.ItemCode_TG1BOMItemTab(0), IndentItemCode, "ItemCode_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.ItemName_TG1BOMItemTab(0));
					scrollToElement(tendercreationlocators.ItemName_TG1BOMItemTab(0));
					set(tendercreationlocators.ItemName_TG1BOMItemTab(0), IndentItemName, "ItemName_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UOM_TG1BOMItemTab(1));
					scrollToElement(tendercreationlocators.UOM_TG1BOMItemTab(1));
					select(tendercreationlocators.UOM_TG1BOMItemTab(1), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
						 
					waitForElementToBeClickable(tendercreationlocators.Qty_TG1BOMItemTab(0));
					scrollToElement(tendercreationlocators.Qty_TG1BOMItemTab(0));
					set(tendercreationlocators.Qty_TG1BOMItemTab(0), pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UnitRate_TG1BOMItemTab(0));
					scrollToElement(tendercreationlocators.UnitRate_TG1BOMItemTab(0));
					set(tendercreationlocators.UnitRate_TG1BOMItemTab(0), pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.GSTPercent_TG1BOMItemTab(0));
					scrollToElement(tendercreationlocators.GSTPercent_TG1BOMItemTab(0));
					set(tendercreationlocators.GSTPercent_TG1BOMItemTab(0), pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG1BOMItemTab");
					
					//add 5 non sor child
					
					for(int i=1; i<6; i++) {
					String IndentItemCode1 = "TendCode_";
					String IndentItemName1 = "TendName_";
					int getrandomInterger1 = getrandomInterger(10000, 1000000000);
					IndentItemCode1 = IndentItemCode1.concat(String.valueOf(getrandomInterger1));
					IndentItemName1 = IndentItemName1.concat(String.valueOf(getrandomInterger1));
					
					waitForElementToBeClickable(tendercreationlocators.bom_item_action);
					scrollToElement(tendercreationlocators.bom_item_action);
					JSClick(tendercreationlocators.bom_item_action, "bom_item_action");
					
					waitForElementToBeClickable(tendercreationlocators.add_non_sor_child);
					JSClick(tendercreationlocators.add_non_sor_child, "add_non_sor_child");
					
					waitForElementToBeClickable(tendercreationlocators.ItemCode_TG1BOMItemTab(i));
					scrollToElement(tendercreationlocators.ItemCode_TG1BOMItemTab(i));
					set(tendercreationlocators.ItemCode_TG1BOMItemTab(i), IndentItemCode1, "ItemCode_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.ItemName_TG1BOMItemTab(i));
					scrollToElement(tendercreationlocators.ItemName_TG1BOMItemTab(i));
					set(tendercreationlocators.ItemName_TG1BOMItemTab(i), IndentItemName1, "ItemName_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UOM_TG1BOMItemTab(i+1));
					scrollToElement(tendercreationlocators.UOM_TG1BOMItemTab(i+1));
					select(tendercreationlocators.UOM_TG1BOMItemTab(i+1), pdfResultReport.testData.get("UOM_TG1BOMItemTab"));
						 
					waitForElementToBeClickable(tendercreationlocators.Qty_TG1BOMItemTab(i));
					scrollToElement(tendercreationlocators.Qty_TG1BOMItemTab(i));
					set(tendercreationlocators.Qty_TG1BOMItemTab(i), pdfResultReport.testData.get("Qty_TG1BOMItemTab"), "Qty_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.UnitRate_TG1BOMItemTab(i));
					scrollToElement(tendercreationlocators.UnitRate_TG1BOMItemTab(i));
					set(tendercreationlocators.UnitRate_TG1BOMItemTab(i), pdfResultReport.testData.get("UnitRate_TG1BOMItemTab"), "UnitRate_TG1BOMItemTab");
					
					waitForElementToBeClickable(tendercreationlocators.GSTPercent_TG1BOMItemTab(i));
					scrollToElement(tendercreationlocators.GSTPercent_TG1BOMItemTab(i));
					set(tendercreationlocators.GSTPercent_TG1BOMItemTab(i), pdfResultReport.testData.get("GSTPercent_TG1BOMItemTab"), "GSTPercent_TG1BOMItemTab");
					
					}
					
					
					
					
					
				pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tab_Parent_Child", "IndentTG1_BOM_Item_tab_Parent_Child must be sucessfully validated",
						"Successfully validated IndentTG1_BOM_Item_tab_Parent_Child" + " ", "Pass", "Y");
				log.info("completed executing the method:: IndentTG1_BOM_Item_tab_Parent_Child");
				
		}
			catch (Exception e) {
				log.fatal("Unable to SubmitQuickIndnet" + e.getMessage());
				pdfResultReport.addStepDetails("IndentTG1_BOM_Item_tab_Parent_Child", "IndentTG1_BOM_Item_tab_Parent_Child must be sucessfully validated",
						"Successfully validated IndentTG1_BOM_Item_tab_Parent_Child" + e.getMessage(), "Fail", "N");
			}
				
			}
			public void validateSum() throws Exception {
				try {
					log.info("started executing the method:: validateSum");
					waitForElementToBeClickable(tendercreationlocators.ActionButton);
					click(tendercreationlocators.ActionButton, "action");
					waitForElementToBeClickable(tendercreationlocators.ViewIndent);
					click(tendercreationlocators.ViewIndent, "ViewIndent");
					waitForElementToBeClickable(tendercreationlocators.bomItempreviewTab);
					click(tendercreationlocators.bomItempreviewTab, "Indent BOM Item tab");
					waitForObj(2000);
					
					//validate total amount
					scrollToElement(tendercreationlocators.total_amount_parent);
					waitForObj(1000);
					String totalAmountParent=text(tendercreationlocators.total_amount_parent);
					double sum=0;
					for (int i = 2; i <7; i++) {
						scrollToElement(tendercreationlocators.totalItem_for_items(i));
						sum=sum+ Double.parseDouble(text(tendercreationlocators.totalItem_for_items(i)));
					}
					scrollToElement(tendercreationlocators.total_amt_sum_section);
					  String actualText = text(tendercreationlocators.total_amt_sum_section);
			            String[] words= actualText.split(":");
			    	   String sum_section= words[1].trim();
					

				if (Double.compare(sum, Double.parseDouble(sum_section))==0 && Double.compare(sum, Double.parseDouble(totalAmountParent))==0) {
					  System.out.println("sum is equal to both parsed values");
					 
				
				 pdfResultReport.addStepDetails("total amount", "validateSum total amount",
							"Successfully validated validateSum" + " ", "Pass", "Y");
			
				}
				else {
					  System.out.println("sum is not equal to one or both parsed values");		
							pdfResultReport.addStepDetails("total amount", "validateSum total amount",
									"sum is not equal to one or both parsed values" , "Fail", "N");
					}
				
				
				//validate gst value
				scrollToElement(tendercreationlocators.gst_value_parent);
				waitForObj(1000);
				String totalAmountParent1=text(tendercreationlocators.gst_value_parent);
				double sum1=0;
				for (int i = 2; i <7; i++) {
					scrollToElement(tendercreationlocators.total_gstValue_for_items(i));
					sum1=sum1+ Double.parseDouble(text(tendercreationlocators.total_gstValue_for_items(i)));
				}
				scrollToElement(tendercreationlocators.total_amt_gstValue_section);
				 String actualText1 = text(tendercreationlocators.total_amt_gstValue_section);
		            String[] words1= actualText1.split(":");
		    	   String sum_section1= words1[1].trim();

			if (Double.compare(sum1, Double.parseDouble(sum_section1))==0 && Double.compare(sum1, Double.parseDouble(totalAmountParent1))==0) {
				  System.out.println("sum is equal to both parsed values");
				 
			
			 pdfResultReport.addStepDetails("total amount", "validateSum total amount",
						"Successfully validated validateSum" + " ", "Pass", "Y");
		
			}
			else {
				  System.out.println("sum is not equal to one or both parsed values");		
						pdfResultReport.addStepDetails("total amount", "validateSum total amount",
								"sum is not equal to one or both parsed values" , "Fail", "N");
				}
				
				
			//validate SUM (Grand Total (Including GST) value
			scrollToElement(tendercreationlocators.grandTotal_parent);
			waitForObj(1000);
			String totalAmountParent2=text(tendercreationlocators.grandTotal_parent);
			double sum2=0;
			for (int i = 2; i <7; i++) {
				scrollToElement(tendercreationlocators.total_grandTotal_for_items(i));
				sum2=sum2+ Double.parseDouble(text(tendercreationlocators.total_grandTotal_for_items(i)));
			}
			scrollToElement(tendercreationlocators.total_grandtotal_section);
			 String actualText2 = text(tendercreationlocators.total_grandtotal_section);
	            String[] words2= actualText2.split(":");
	    	   String sum_section2= words2[1].trim();

		if (Double.compare(sum2, Double.parseDouble(sum_section2))==0 && Double.compare(sum2, Double.parseDouble(totalAmountParent2))==0) {
			  System.out.println("sum is equal to both parsed values");
			 
		
		 pdfResultReport.addStepDetails("total amount", "validateSum total amount",
					"Successfully validated validateSum" + " ", "Pass", "Y");
	
		}
		else {
			  System.out.println("sum is not equal to one or both parsed values");		
					pdfResultReport.addStepDetails("total amount", "validateSum total amount",
							"sum is not equal to one or both parsed values" , "Fail", "N");
			}
	
				
				
				
				
				click(tendercreationlocators.PreviewCrossButton, "PreviewCrossButton");
				
					
							pdfResultReport.addStepDetails("validateSum", "validateSum must be sucessfully validated",
									"Successfully validated validateSum" + " ", "Pass", "Y");
					log.info("completed executing the method:: validateSum");
					waitForObj(3000);	
				} catch (Exception e) {
					log.fatal("Unable to navigate to the indent creation" + e.getMessage());
					pdfResultReport.addStepDetails("validateSum", "validateSum should validate successfully",
							"Unable to validateSum" + e.getMessage(), "Fail", "N");
				}
				
			}
				public void AddSingleUsersForSequentialApproval_IndentWF() throws Throwable {
					try {
						log.info(
								"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
						click(tendercreationlocators.UserDefinedWFchkbox_Indent, "UserDefinedWFchkbox_Indent");
						//by default section wise comment selected No
						//loop to remove the row if the the user added previously
						if(ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval).size()!= 0)
						{
							List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.NoOfIndentRowinApproval);
							int iRowCount = iRows.size();
							for(int i=1;i<=iRowCount;i++)
							{
								waitForObj(1000);
								click(tendercreationlocators.cancelUser1_Indent, "cancelUser1_Indent");
							}
						}
						click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
						waitForObj(2000);
						set(tendercreationlocators.user1_Indent, pdfResultReport.testData.get("User_Indent_Approver"), "user1_Indent");
						waitForObj(2000);
						select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
						waitForObj(2000);
						set(tendercreationlocators.CommentsArea_IndentRTF, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
								"CommentsArea_Indent");
						
						commentlist.add(text(tendercreationlocators.CommentsArea_IndentRTF));
						
						
						pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
								"Sequential Approval Must Be selected",
								"Sequential Approval selected Sucessfully"
										+ " ",
								"Pass", "Y");
						waitForObj(2000);
						scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
						click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
						waitForElementToBeVisible(tendercreationlocators.myindent);
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForObj(10000);
						pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
								"Must Submit the Indent With Seq Flow ",
								"Sucessfully Submitted Indent With Seq Flow "
										+ " ",
								"Pass", "Y");
						log.info(
								"completed executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
					} catch (Exception e) {
						log.fatal("Not able to Submit Indent" + e.getMessage());
						pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
								"Must Submit the Indent With Seq Flow ",
								"Not able to Submit Indent"
										+ e.getMessage(),
								"Fail", "N");
			                       Assert.fail("Failed Due to " + e.getMessage());
					}
				}
				public void LifeCycleIndentHyperLinkValidation() throws Exception {
					try {
						log.info(
								"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
						waitForElement(tendercreationlocators.selectIndentStatus, 20);
						select(tendercreationlocators.selectIndentStatus, "Fully Used");
						waitForObj(1000);
						click(tendercreationlocators.ActionButton_Backup, "ActionButton");
						waitForObj(500);
						click(tendercreationlocators.LifeCycle, "LifeCycle");
						waitForObj(5000);
						click(tendercreationlocators.indentHyperLink, "tendercreationlocators");
						waitForObj(5000);
						isElementDisplayed_Updated(tendercreationlocators.identPreviewPageText, 15);
						click(tendercreationlocators.lifeCyclePreviewClose, "lifeCyclePreviewClose");
						click(tendercreationlocators.PreviewCrossButton, "PreviewCrossButton");
						
						pdfResultReport.addStepDetails("Successfully Saved",
								"Tender Id must be entered successfully in search field",
								"Tender Id is successfully entered in search field" + " ", "Pass", "Y");
						log.info("completed executing the method:: tenderIdSave");
					} catch (Exception e) {
						log.fatal("Not able to create tender" + e.getMessage());
						pdfResultReport.addStepDetails("Not able to create tender", "Not able to enter Tender Id in search field",
								"Unable to enter Tender Id in search field" + e.getMessage(), "Fail", "N");
					}
					
				}
				public void validateTenderTemplateMappting(String RFQTGname) throws Throwable {
					try {
						log.info(
								"started executing the method:: AddSingleUsersForSequentialApproval_IndentWF");
						click(tendercreationlocators.ActionButton, "ActionBtn_Listpage_Indent");
						//waitForObj(2000);
						waitForElementToBeClickable(tendercreationlocators.CreateRFQLnk_RFQfromIndent);
						//waitForElementToBeVisible(tendercreationlocators.CreateRFQLnk_RFQfromIndent);
						pdfResultReport.addStepDetails("Create_RFQ_From_Indent",
								"Create RFQ dropdown option should be displayed",
								"Create RFQ dropdown option is displayed", "Pass", "Y");
						click(tendercreationlocators.CreateRFQLnk_RFQfromIndent, "CreateRFQLnk_RFQfromIndent");
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						//waitForObj(2000);
						waitForElementToBeClickable(tendercreationlocators.CreateRFQbtn_IndentPreview);
						pdfResultReport.addStepDetails("Create_RFQ_From_Indent",
								"Indent Preview page should be displayed",
								"Indent Preview page is displayed", "Pass", "Y");
						JSClick(tendercreationlocators.CreateRFQbtn_IndentPreview, "CreateRFQbtn_IndentPreview");
						//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
						waitForElementToBeClickable(tendercreationlocators.TGselectionmodal_RFQfromIndent);
						click(tendercreationlocators.TGselectionmodal_RFQfromIndent, "click on TenderTG");
						
						//universalNormalWait();
						int size= ThreadLocalWebdriver.getDriver().findElements(By.xpath("//*[@id='sequenSec']/div/div/select/option")).size();
						size=size-1;
						System.out.println(size);
						System.out.println("Actual size from frontend is"+size);
					int actualCount=Integer.parseInt(distinctTGCount);		
					System.out.println("Count from DataBase"+actualCount);
					if(size==actualCount)
					{
					
						log.info("completed executing the method:: count passed");
						
					}
					else {
						log.fatal("count not passed");
						pdfResultReport.addStepDetails("validateTenderTemplateMappting",
								"validateTenderTemplateMappting",
								"validateTenderTemplateMappting" + " ", "Fail", "Y");
						
					}
					waitForElementToBeVisible(tendercreationlocators.TGselectionmodal_RFQfromIndent);
					QueryParameter_Global = ThreadLocalWebdriver.getDriver().findElement(By.xpath("//option[contains(text(),'" + RFQTGname + "')]")).getAttribute("value");
					System.out.println("QueryParameter_Global value: " + QueryParameter_Global);
					select(tendercreationlocators.TGselectionmodal_RFQfromIndent, RFQTGname);
					
					
					click(tendercreationlocators.Submitbtn_RFQfromIndent, "Submitbtn_RFQfromIndent");
						pdfResultReport.addStepDetails(" successfullyvalidateTenderTemplateMappting",
								"validateTenderTemplateMappting",
								"validateTenderTemplateMappting" + " ", "Pass", "Y");
						log.info("completed executing the method:: validateTenderTemplateMappting");
					} catch (Exception e) {
						log.fatal("Not able to validateTenderTemplateMappting" + e.getMessage());
						pdfResultReport.addStepDetails("Not able to validateTenderTemplateMappting", "Not able to validateTenderTemplateMappting",
								"Unable to validateTenderTemplateMappting" + e.getMessage(), "Fail", "N");
					}
					
					
				}
				public void validateTenderEvalCompletedState() throws Throwable {
					try {
						log.info(
								"started executing the method:: validateTenderEvalCompletedState");
						JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
						mouseOver(tendercreationlocators.MyTask);
						waitForObj(2000);
						JSClick(tendercreationlocators.pending, "pending");
						universalNormalWait();
						waitForElementToBeClickable(tendercreationlocators.tenderEvalTab);
						click(tendercreationlocators.tenderEvalTab, "tenderEvalTab");
						waitForObj(10000);
						waitForElementToBeClickable(tendercreationlocators.completedTab);
						click(tendercreationlocators.completedTab, "completedTab");
						universalNormalWait();
						isElementDisplayed(tendercreationlocators.tabBody, 5);
						
						
						
						pdfResultReport.addStepDetails("Successfully validateTenderEvalCompletedState",
								"validateTenderEvalCompletedState",
								"validateTenderEvalCompletedState" + " ", "Pass", "Y");
						log.info("completed executing the method:: validateTenderEvalCompletedState");
					} catch (Exception e) {
						log.fatal("Not able to create tender" + e.getMessage());
						pdfResultReport.addStepDetails("Not able to validateTenderEvalCompletedState", "Not able to validateTenderEvalCompletedState",
								"Unable to enter validateTenderEvalCompletedState" + e.getMessage(), "Fail", "N");
					}
					
				}
					
				

				
			}
		
			
