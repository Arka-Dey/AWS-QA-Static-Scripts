package com.components;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.baseClasses.ThreadLocalWebdriver;
import com.objectRepository.TenderCreation_Locators;


public class PagesUpAndRunningComponent extends BaseClass_Web {

	TenderCreation_Locators tendercreationlocators = new TenderCreation_Locators();
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	SoftAssert softAssert=new SoftAssert();
	String SystemIndentnoLocatorText = null;
	//String SystemIndentnoLocatorText = "2040";
	String expectedSuccessMessage= null;
	String TemplateGroup=null;
	ArrayList<String> commentlist=new ArrayList<String>();
	ArrayList<String> tabcontentList=new ArrayList<String>();
	String tenderIDdromDraft=null;
	
	public PagesUpAndRunningComponent(PDFResultReport pdfresultReport) {
		this.pdfResultReport = pdfresultReport;
	}
	
	//================PagesUpAndRunning Component==================================================
	
	public static String getDataFromPropertiesFile(String value, String filepath ) throws IOException {
		FileInputStream fileReader = null;
		Properties properties = null;
		String propertyValue;
		try {
			final String filePath = filepath;

			fileReader = new FileInputStream(filePath);

			properties = new Properties();
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		propertyValue = properties.getProperty(value);

		fileReader.close();

		return propertyValue;

	}
	
	public void commonLogin(String username, String password, String moduleType, String roleType) throws Throwable {
		try {
			log.info("started executing the method:: IndentapproverLogin");
			set(tendercreationlocators.userName, username, "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, password, "password");
			click(tendercreationlocators.okButton, "okButton");
			waitForElement(tendercreationlocators.dashboardIcon, 500);
			pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" must be sucessfully logged in",
					"Successfully logged in as "+moduleType+" "+roleType+"" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentapproverLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" is not logged in",
					"Unable to login as "+moduleType+" "+roleType+"" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void commonLogin_Supplier(String username, String password, String moduleType, String roleType) throws Throwable {
		try {
			log.info("started executing the method:: IndentapproverLogin");
			set(tendercreationlocators.userName, username, "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, password, "password");
			click(tendercreationlocators.okButton, "okButton");

			pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" must be sucessfully logged in",
					"Successfully logged in as "+moduleType+" "+roleType+"" + " ", "Pass", "Y");
			log.info("completed executing the method:: IndentapproverLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails(""+moduleType+" "+roleType+" login", ""+moduleType+" "+roleType+" is not logged in",
					"Unable to login as "+moduleType+" "+roleType+"" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void openURL(String Environment) throws Exception {
		System.out.println("Now Selenium hit the URL");
		String ENV= Environment;
		System.out.println(ENV);
		try {
			if(ENV.equalsIgnoreCase("QA")) {
			launchapp("https://epsnewprodaws.mjunction.in/EPSV2Web/");
			waitForObj(3000);
			}
			else if(ENV.equalsIgnoreCase("STG")) {
				launchapp("https://epsstagingaws.mjunction.in/EPSV2Web/");
				waitForObj(3000);
				}
			else if(ENV.equalsIgnoreCase("Production")){
				launchapp("https://eprocurement.mjunction.in/EPSV2Web/");
				waitForObj(3000);
				}
				
			pdfResultReport.addStepDetails("openURL", "Application should open the url",
					"Successfully opened the URL" + " ", "Pass", "Y");
		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("openURL", "Application should open the url",
					"Unable to open the URL" + e.getMessage(), "Fail", "N");
		}

	}
	
	public void tenderLogoutOld(String Environment) throws Throwable {
		try {
			log.info("started executing the method:: tendercreatorLogout");
			waitForObj(2000);
			if(ThreadLocalWebdriver.getDriver().findElement(By.xpath("//div[@id='overlay']")).isDisplayed())
			{
	
				waitForElementToBeInvisible(tendercreationlocators.loadingOverlay);
			}
			JSClick(tendercreationlocators.logoutOptionOld, "logoutOption");
			click(tendercreationlocators.logoutOld, "logout");
			click(tendercreationlocators.logoutConfirmationOld, "logoutConfirmation");
			waitForObj(5000);
			String ENV= Environment;
			System.out.println(ENV);
				if(ENV.equalsIgnoreCase("QA")) {
				ThreadLocalWebdriver.getDriver().navigate().to("https://epsnewprodaws.mjunction.in/EPSV2Web/");
				waitForObj(1000);
				}
				else if(ENV.equalsIgnoreCase("STG")) {
					ThreadLocalWebdriver.getDriver().navigate().to("https://epsstagingaws.mjunction.in/EPSV2Web/");
					waitForObj(1000);
					}
				else if(ENV.equalsIgnoreCase("Production")){
					ThreadLocalWebdriver.getDriver().navigate().to("https://eprocurement.mjunction.in/EPSV2Web/");
					waitForObj(1000);
					}
					
				pdfResultReport.addStepDetails("openURL", "Application should open the url",
						"Successfully opened the URL" + " ", "Pass", "Y");
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator must be sucessfully logout",
					"Successfully logout" + " ", "Pass", "Y");
			log.info("completed executing the method:: tendercreatorLogout");

		} catch (Exception e) {
			log.fatal("Unable to logout as tender creator" + e.getMessage());
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator is not logged out",
					"Unable to logout as tender creator" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void tenderLogout(String Environment) throws Throwable {
		try {
			log.info("started executing the method:: UserLogout");
			waitForObj(2000);
			
			JSClick(tendercreationlocators.logoutOption, "logoutOption");
			waitForObj(2000);
			click(tendercreationlocators.logout, "logout");
			waitForObj(2000);
			click(tendercreationlocators.logoutConfirmation, "logoutConfirmation");
			universalWait();
			String ENV= Environment;
			System.out.println(ENV);
				if(ENV.equalsIgnoreCase("QA")) {
				ThreadLocalWebdriver.getDriver().navigate().to("https://epsnewprodaws.mjunction.in/EPSV2Web/");
				waitForObj(1000);
				}
				else if(ENV.equalsIgnoreCase("STG")) {
					ThreadLocalWebdriver.getDriver().navigate().to("https://epsstagingaws.mjunction.in/EPSV2Web/");
					waitForObj(1000);
					}
				else if(ENV.equalsIgnoreCase("Production")){
					ThreadLocalWebdriver.getDriver().navigate().to("https://eprocurement.mjunction.in/EPSV2Web/");
					waitForObj(1000);
					}
			pdfResultReport.addStepDetails("User logout", "User must be sucessfully logout",
					"Successfully logout" + " ", "Pass", "Y");
			log.info("completed executing the method:: UserLogout");

		} catch (Exception e) {
			log.fatal("Unable to logout as User" + e.getMessage());
			pdfResultReport.addStepDetails("User logout", "User is not logged out",
					"Unable to logout as User" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void validateTenderEvaluationTabDetails_WithEvaluatorUser() throws Throwable {
		try {
			log.info("started executing the method:: validateTenderEvaluationTabDetails_WithEvaluatorUser");

			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			//waitForObj(10000);
			waitForElementToBeClickable(tendercreationlocators.TenEvalTab_Evaluation);
			JSClick(tendercreationlocators.TenEvalTab_Evaluation, "Tender_Evaluation");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "Tender_Evaluation_Completed_List");
			universalWait();

			pdfResultReport.addStepDetails("validateTenderEvaluationTabDetails_WithEvaluatorUser",
					"Tender Evaluation tab Details must be validated",
					"SucessFully validated Tender Evaluation TabDetails" + " ", "Pass", "Y");
			log.info("completed executing the method:: validateTenderEvaluationTabDetails_WithEvaluatorUser");
		} catch (Exception e) {
			log.fatal("Not able to Tender Evaluation TabDetails" + e.getMessage());
			pdfResultReport.addStepDetails("validateTenderEvaluationTabDetails_WithEvaluatorUser",
					"Tender Evaluation tab Details must be validated",
					"Unable to validate Tender Evaluation TabDetails" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void GoToApprovalworkFlowPendingindentAndSearchTheIndent() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheIndent");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			waitForElementToBeVisible(tendercreationlocators.IndentListTab);
			waitForObj(5000);
			click(tendercreationlocators.IndentListTab, "Indent");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "Indent_Approver_Completed_List");
			universalWait();

		
		} catch (Exception e) {
			log.fatal("Unable to display the pending indent in approval work flow" + e.getMessage());
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheIndent",
					"Should display the pending indent in approval work flow","Unable to display the pending indent in approval work flow" + e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	
	public void GoToApprovalworkFlowPendingindentAndSearchTheNotesheet() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheNotesheet");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			universalWait();
			JSClick(tendercreationlocators.notesheetTab_Updated, "notesheet tab");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "NoteSheet_Approver_Completed_List");
			universalWait();
			
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheNotesheet",
					"Should complete GoToApprovalworkFlowPendingindentAndSearchTheNotesheet",
					"Successfully passed GoToApprovalworkFlowPendingindentAndSearchTheNotesheet" + " ", "Pass", "Y");
			log.info("completed executing the method::GoToApprovalworkFlowPendingindentAndSearchTheNotesheet");
		}
		catch (Exception e) {
			log.fatal("Not able to GoToApprovalworkFlowPendingindentAndSearchTheNotesheet" + e.getMessage());
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchTheNotesheet", "Should complete GoToApprovalworkFlowPendingindentAndSearchTheNotesheet",
					"Not passed GoToApprovalworkFlowPendingindentAndSearchTheNotesheet" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void GoToVerifyPOListPage() throws Throwable {
		try {
			log.info("started executing the method:: GoToVerifyPOListPage");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			String Order="//body/section[@id='container']/section[@id='main-content-nw']/aside[1]/div[2]/div[1]/ul[1]/li[5]/a[1]";
			String AllOrders="//span[contains(text(),'All Orders')]";
			mouseOver(By.xpath(Order));
			click(By.xpath(AllOrders), "AllOrders");
			universalWait();
			
			pdfResultReport.addStepDetails("GoToVerifyPOListPage",
					"Should complete GoToVerifyPOListPage",
					"Successfully passed GoToVerifyPOListPage" + " ", "Pass", "Y");
			log.info("completed executing the method::GoToVerifyPOListPage");
		}
		catch (Exception e) {
			log.fatal("Not able to GoToVerifyPOListPage" + e.getMessage());
			pdfResultReport.addStepDetails("GoToVerifyPOListPage", "Should complete GoToVerifyPOListPage",
					"Not passed GoToVerifyPOListPage" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void navigateToApprovalPendingPage_SN() throws Throwable {
		try {
			log.info("started executing the method:: navigateToApprovalPendingPage");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			universalWait();
			JSClick(tendercreationlocators.sanctionTab, "sanction tab");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "SN_Approver_Completed_List");
			universalWait();
			
			pdfResultReport.addStepDetails("navigateToApprovalPendingPage",
					"Approval Pending page must be navigate successfully",
					"Successfully navigated to Approval Pendong page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToApprovalPendingPage");

		} catch (Exception e) {
			log.fatal("Unable to navigate to Approval Pendong page" + e.getMessage());
			pdfResultReport.addStepDetails("navigateToApprovalPendingPage",
					"Approval Pending page must be navigate successfully",
					"Unable to navigate to Approval Pendong page" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void navigateToApprovalPendingPage_PO() throws Throwable {
		try {
			log.info("started executing the method:: navigateToApprovalPendingPage");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			JSClick(tendercreationlocators.pending, "pending");
			universalWait();
			JSClick(tendercreationlocators.poTab, "PO tab");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "PO_Approver_Completed_List");
			universalWait();
			
			pdfResultReport.addStepDetails("navigateToApprovalPendingPage",
					"Approval Pending page must be navigate successfully",
					"Successfully navigated to Approval Pendong page" + " ", "Pass", "Y");
			log.info("completed executing the method:: navigateToApprovalPendingPage");

		} catch (Exception e) {
			log.fatal("Unable to navigate to Approval Pendong page" + e.getMessage());
			pdfResultReport.addStepDetails("navigateToApprovalPendingPage",
					"Approval Pending page must be navigate successfully",
					"Unable to navigate to Approval Pendong page" + e.getMessage(), "Fail", "N");
		}
	}
	
	public void GoToApprovalworkFlowPendingTendersAndSearchTheTender() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingTendersAndSearchTheTender");
			
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			universalWait();
			JSClick(tendercreationlocators.Tenderlink_approver_tender, "Tenderlink_approver_tender");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "PO_Approver_Completed_List");
			universalWait();

		} catch (Exception e) {
			log.fatal("Unable to display the pending tender in approval work flow" + e.getMessage());
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingTendersAndSearchTheTender",
					"Should display the pending tender in approval work flow","Unable to display the pending tender in approval work flow" + e.getMessage(),
					"Fail", "N");
                    Assert.fail("Failed Due to " + e.getMessage());
		}
	}
	
	public void clickCorrigendumTabAndSearchThePendingListTenderNo() throws Throwable {
		try {
			log.info("started executing the method:: clickCorrigendumTabAndSearchThePendingListTenderNo");
			
			/*
			 * JSClick(tendercreationlocators.workFlow, "workFlow");
			 */
			
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			universalWait();
			JSClick(tendercreationlocators.corrigendumTab, "corrigendumTab");
			universalWait();
			String xpath="//span[contains(text(),'Completed')]";
			JSClick(By.xpath(xpath), "PO_Approver_Completed_List");
			universalWait();
			
		} catch (Exception e) {
			log.fatal("Unable to display the pending tender in approval work flow" + e.getMessage());
			pdfResultReport.addStepDetails("clickCorrigendumTabAndSearchThePendingListTenderNo",
					"Should display the pending tender under Corrigendum tab in approval work flow",
					"Unable to display the pending tender under Corrigendum tab in approval work flow" + e.getMessage(),
					"Fail", "N");
			Assert.fail("Failed due to -->" + e.getMessage());
		}
	}
	
	//==================================================================
	
}


