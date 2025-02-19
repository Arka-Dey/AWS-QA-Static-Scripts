package com.components;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Database.DatabaseComponent;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.baseClasses.ThreadLocalWebdriver;
import com.objectRepository.TenderCreation_Locators;

public class Change_request_Component extends BaseClass_Web {

//	String NoteSheetNo = null;
	String NoteSheetNo="1657";
//	String SN_No = "3075";
	String SN_No = null;
//	String LOA_No=null;
	String LOA_No="1331";
	TenderCreation_Locators tendercreationlocators = new TenderCreation_Locators();

	public Change_request_Component(PDFResultReport pdfresultReport) {
		this.pdfResultReport = pdfresultReport;
	}
	
	public void openURL() throws Exception {
		try {
			launchapp(pdfResultReport.testDataValue.get("AppURL"));
			waitForObj(3000);

			pdfResultReport.addStepDetails("openURL", "Application should open the url",
					"Successfully opened the URL" + " ", "Pass", "Y");
		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("openURL", "Application should open the url",
					"Unable to open the URL" + e.getMessage(), "Fail", "N");
		}

	}
	
	public void NoteSheetLogin(String string) throws Exception {
		try {
			log.info("started executing the method:: NoteSheetCreatorLogin");
			//click(tendercreationlocators.login, "login"); // edited on 30-11-21
			set(tendercreationlocators.userName, string, "userName");
			waitForElementToBeClickable(tendercreationlocators.password);
			set(tendercreationlocators.password, pdfResultReport.testData.get("AppPassword"), "password");
			//Handle fixed Captcha (06/11/2020)
			//set(tendercreationlocators.Captcha_Login, "1234", "Login_Captcha"); // edited on 30-11-21
			SSClick(tendercreationlocators.okButton, "okButton");
			//waitForElement(tendercreationlocators.dashboardIcon, 5000); //commented on 110722
			waitForElement(tendercreationlocators.dashboardIconnew, 5000);
			pdfResultReport.addStepDetails("NoteSheet creator login", "Notesheet creator must be sucessfully logged in",
					"Successfully logged in as Notesheet creator" + " ", "Pass", "Y");
			log.info("completed executing the method:: NoteSheetCreatorLogin");

		} catch (Exception e) {
			log.fatal("Unable to open the URL" + e.getMessage());
			pdfResultReport.addStepDetails("Indent creator login", "NoteSheet creator is not logged in",
					"Unable to login as Notesheet creator" + e.getMessage(), "Fail", "N");
		}
		
	}
	
	public void nevigateToNotesheetList() throws Throwable {
		try {
			log.info("started executing the method:: nevigateToNotesheetList");		
			click(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.Others);
			// mouseOver(tendercreationlocators.tendersIcon);
			JSClick(tendercreationlocators.allNotesheet, "allNotesheet");
			//WebDriver driver = ThreadLocalWebdriver.getDriver();
			checkPageIsReady();
			waitForElementToBeVisible(tendercreationlocators.notesheetListPage);
			pdfResultReport.addStepDetails("nevigateToNotesheetList",
					"nevigateToNotesheetList should displayed",
					"nevigateToNotesheetList displayed successfully" + " ", "Pass", "Y");
		
			
		} catch (Exception e) {
			log.fatal("not able to nevigateToNotesheetList" + e.getMessage());
			pdfResultReport.addStepDetails("nevigateToNotesheetList", "nevigateToNotesheetList should displayed",
					"not able to nevigateToNotesheetList page" + e.getMessage(), "Fail", "N");
		}
		
	}
	
	public void nevigateToLOAList() throws Throwable {
		try {
			log.info("started executing the method:: nevigateToNotesheetList");		
			click(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.orderFromMenu);
			// mouseOver(tendercreationlocators.tendersIcon);
			JSClick(tendercreationlocators.allLOA, "allLOA");
			//WebDriver driver = ThreadLocalWebdriver.getDriver();
			checkPageIsReady();
			waitForElementToBeVisible(tendercreationlocators.LOAListPage);
			pdfResultReport.addStepDetails("nevigateToNotesheetList",
					"nevigateToNotesheetList should displayed",
					"nevigateToNotesheetList displayed successfully" + " ", "Pass", "Y");
		
			
		} catch (Exception e) {
			log.fatal("not able to nevigateToNotesheetList" + e.getMessage());
			pdfResultReport.addStepDetails("nevigateToNotesheetList", "nevigateToNotesheetList should displayed",
					"not able to nevigateToNotesheetList page" + e.getMessage(), "Fail", "N");
		}
		
	}
	
	public void createNotesheet() throws Throwable {
		try {
			log.info("started executing the method:: createNotesheet");		
			
			scrollToTopOfThePage();
			click(tendercreationlocators.createNotesheetIcon, "create notesheet");
			waitForElementToBeVisible(tendercreationlocators.subject);
			set(tendercreationlocators.subject, "NoteSheet for discussion", "subject");
			set(tendercreationlocators.notesheetRefNo, "NoteSheet ref. no", "ref no");
			/*waitForElementToBeClickable(tendercreationlocators.briefcaseNotesheet);
			click(tendercreationlocators.briefcaseNotesheet, "ebriefcase icon");
			waitForElementToBeClickable(tendercreationlocators.addfile);
			click(tendercreationlocators.addfile, "add file");
			 	*/
			waitForElementToBeClickable(tendercreationlocators.createNotesheetIcon);
			click(tendercreationlocators.createNotesheetIcon, "add attachment icon");
			waitForObj(1000);
			set(By.xpath("//*[@id='fileInput']"), System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
					"fileName");
			set(tendercreationlocators.notesheetcreateDeatils, "item quantity discussion", "details");

			pdfResultReport.addStepDetails("createNotesheet",
					"create notesheet should perform",
					"create notesheet performed successfully" + " ", "Pass", "Y");
		
			
		} catch (Exception e) {
			log.fatal("not able to createNotesheet" + e.getMessage());
			pdfResultReport.addStepDetails("createNotesheet", "create notesheet should perform",
					"not able to perform createNotesheet page" + e.getMessage(), "Fail", "N");
		}
		
	}
	
	public void noteSheetSubmit() throws Throwable {
		try {
			log.info("started executing the method:: clickSubmitBtn");
			waitForElementToBeVisible(tendercreationlocators.notesheetSubmit);
			click(tendercreationlocators.notesheetSubmit, "submitbutton");
			waitForElementToBeVisible(tendercreationlocators.notesheetNO);
			NoteSheetNo=NotesheetNoSave();
			System.out.println(NoteSheetNo);
			pdfResultReport.addStepDetails("clickSubmitBtn",
					"Should click Submit Btn and  Send For Approval Pop Up should Appear",
					"Successfully clicked Submit Btn and  Send For Approval Pop Up is displayed " + " ", "Pass", "Y");
			log.info("completed executing the method::clickSubmitBtn");

		} catch (Exception e) {

			log.fatal("Unable to click Subtmin Btn Send For Approval Pop Up is not Appear" + e.getMessage());
			pdfResultReport.addStepDetails("clickSubmitBtn",
					"Should click Submit Btn and  Send For Approval Pop Up should Appear",
					"Unable to click Subtmin Btn Send For Approval Pop Up is not Appeared" + e.getMessage(), "Fail",
					"N");
		}
		
	}
	public String NotesheetNoSave() throws Throwable {
		try {
		log.info("started executing the method:: tenderIdSave");
		String notesheettext = text(tendercreationlocators.notesheetNO);
		String[] splittedWord=notesheettext.split(":");
		NoteSheetNo=splittedWord[1].trim();
		System.out.println(NoteSheetNo);
		eTenderComponent.updateDataIntoPropertyFile("NoteSheetNo", NoteSheetNo);
		
		}
		catch (Exception e) {
			log.fatal("Unable to save notesheet no" + e.getMessage());
			pdfResultReport.addStepDetails("clickSubmitBtn",
					"notesheet no should save",
					"Unable to save notesheet no" + e.getMessage(), "Fail",
					"N");
		}
		return NoteSheetNo;
	}
	public String LOANoSave() throws Throwable {
		try {
		log.info("started executing the method:: tenderIdSave");
		String LOA_NoText = text(tendercreationlocators.notesheetNO);
		String[] splittedWord=LOA_NoText.split(":");
		LOA_No=splittedWord[1].trim();
		System.out.println("LOA no is"+LOA_No);
		
		}
		catch (Exception e) {
			log.fatal("Unable to save notesheet no" + e.getMessage());
			pdfResultReport.addStepDetails("clickSubmitBtn",
					"notesheet no should save",
					"Unable to save notesheet no" + e.getMessage(), "Fail",
					"N");
		}
		return LOA_No;
	}
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
			waitForElementToBeClickable(tendercreationlocators.CompleteIndentbtn);
			click(tendercreationlocators.CompleteIndentbtn, "CompleteIndentbtn");
			waitForElementToBeVisible(tendercreationlocators.notesheetListPage);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
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
	public void verifyNoteSheetStatus(String status) throws Exception {
		
		try {
			log.info("started executing the method:: verifyNoteSheetStatus");		
		waitForElementToBeVisible(tendercreationlocators.notesheetListPage);
		waitForElementToBeClickable(tendercreationlocators.searchBoxGRN);
		clear(tendercreationlocators.searchBoxGRN, NoteSheetNo);
		set(tendercreationlocators.searchBoxGRN, NoteSheetNo, "search notesheet");
		mouseOver(tendercreationlocators.statusIcon);
		if(text(tendercreationlocators.notesheet_status)== status) {
			pdfResultReport.addStepDetails("verifyNoteSheetStatus",
					"NoteSheetStatus status should matched",
					"Successfully mached status" + " ", "Pass", "Y");
		}
		else {
			log.fatal("Not able to verifyNoteSheetStatus" );
		}
				pdfResultReport.addStepDetails("verifyNoteSheetStatus",
						"NoteSheetStatus should matched",
						"Successfully mached notesheetstatus" + " ", "Pass", "Y");
			
			
		} catch (Exception e) {
			log.fatal("Not able to verifyNoteSheetStatuse" + e.getMessage());
			pdfResultReport.addStepDetails("verifyNoteSheetStatus", "verifyNoteSheetStatus should matched",
					"Notesheet status not mached" + e.getMessage(), "Fail", "N");
		}
		
		
	}
	
public void verifyLOAStatus(String status) throws Exception {
		
		try {
			log.info("started executing the method:: verifyLOAStatus");		
		waitForElementToBeVisible(tendercreationlocators.LOAListPage);
		clear(tendercreationlocators.searchBoxGRN, "loa search");
		set(tendercreationlocators.searchBoxGRN, LOA_No, "search LOA_No");

		if(text(tendercreationlocators.LOA_status)== status) {
			pdfResultReport.addStepDetails("verifyNoteSheetStatus",
					"NoteSheetStatus status should matched",
					"Successfully mached status" + " ", "Pass", "Y");
		}
		else {
			log.fatal("Not able to verifyLOAStatus" );
		}
				pdfResultReport.addStepDetails("verifyLOAStatus",
						"verifyLOAStatus should matched",
						"Successfully mached verifyLOAStatus" + " ", "Pass", "Y");
			
		} catch (Exception e) {
			log.fatal("Not able to verifyLOAStatus" + e.getMessage());
			pdfResultReport.addStepDetails("verifyLOAStatus", "verifyLOAStatus should matched",
					"verifyLOAStatus not mached" + e.getMessage(), "Fail", "N");
		}
		
		
	}
	
	
	public void tenderLogout() throws Throwable {
		try {
			log.info("started executing the method:: tendercreatorLogout");
			waitForObj(2000);
			
			JSClick(tendercreationlocators.logoutOption, "logoutOption");
			waitForObj(2000);
			click(tendercreationlocators.logout, "logout");
			click(tendercreationlocators.logoutConfirmation, "logoutConfirmation");
			ThreadLocalWebdriver.getDriver().navigate().to("https://epsnewprodaws.mjunction.in/EPSV2Web/");
			waitForObj(10000);
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator must be sucessfully logout",
					"Successfully logout" + " ", "Pass", "Y");
			log.info("completed executing the method:: tendercreatorLogout");

		} catch (Exception e) {
			log.fatal("Unable to logout as tender creator" + e.getMessage());
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator is not logged out",
					"Unable to logout as tender creator" + e.getMessage(), "Fail", "N");
		}
	}
	public void verifyNoteSheetReinitiatedOrNot(String status) throws Exception {
		try {
			log.info("started executing the method:: verifyNoteSheetReinitiatedOrNot");
					
				log.info("started executing the method:: verifyNoteSheetStatus");		
			waitForElementToBeVisible(tendercreationlocators.notesheetListPage);

		if(text(tendercreationlocators.reinitiatedmsg).contains(status))
		{
			pdfResultReport.addStepDetails("verifyNoteSheetReinitiatedOrNot",
					"Should complete verifyNoteSheetReinitiatedOrNot",
					"Successfully passed verifyNoteSheetReinitiatedOrNot" + " ", "Pass", "Y");
			log.info("completed executing the method::verifyNoteSheetReinitiatedOrNot");
		}
		}
		catch (Exception e) {
			log.fatal("Not able to verifyNoteSheetReinitiatedOrNot" + e.getMessage());
			pdfResultReport.addStepDetails("verifyNoteSheetReinitiatedOrNot", "Should complete verifyNoteSheetReinitiatedOrNot",
					"Not passed verifyNoteSheetReinitiatedOrNot" + e.getMessage(), "Fail", "N");
		}
		
	}
	public void GoToApprovalworkFlowPendingindentAndSearchTheNotesheet() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchTheNotesheet");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			JSClick(tendercreationlocators.pending, "pending");
			if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2)==true)
			{
				waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			}	
			scrollToElement(tendercreationlocators.notesheetTab);
			click(tendercreationlocators.notesheetTab, "notesheetTab");
			set(tendercreationlocators.search,NoteSheetNo, "search");
			waitForElementToBeClickable(tendercreationlocators.new_action_button);
			
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
	public void GoToApprovalworkFlowPendingindentAndSearchThe_LOA() throws Throwable {
		try {
			log.info("started executing the method:: GoToApprovalworkFlowPendingindentAndSearchThe_LOA");
			//Click on menu button (141222)
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.MyTask);
			JSClick(tendercreationlocators.pending, "pending");
			if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2)==true)
			{
				waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			}	
			
			scrollToElement(tendercreationlocators.LOATab);
			click(tendercreationlocators.LOATab, "LOATab");
			set(tendercreationlocators.search,LOA_No, "search");
			waitForElementToBeClickable(tendercreationlocators.new_action_button);
			
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchThe_LOA",
					"Should complete GoToApprovalworkFlowPendingindentAndSearchThe_LOA",
					"Successfully passed GoToApprovalworkFlowPendingindentAndSearchThe_LOA" + " ", "Pass", "Y");
			log.info("completed executing the method::GoToApprovalworkFlowPendingindentAndSearchThe_LOA");
		}
		catch (Exception e) {
			log.fatal("Not able to GoToApprovalworkFlowPendingindentAndSearchThe_LOA" + e.getMessage());
			pdfResultReport.addStepDetails("GoToApprovalworkFlowPendingindentAndSearchThe_LOA", "Should complete GoToApprovalworkFlowPendingindentAndSearchThe_LOA",
					"Not passed GoToApprovalworkFlowPendingindentAndSearchThe_LOA" + e.getMessage(), "Fail", "N");
		}
	}
	public void TenderApproverValidation() throws Throwable {
		try {
			log.info("started executing the method:: TenderApproverValidation");
			
			click(tendercreationlocators.ActionButton_approver_tender, "ActionButton_approver_tender");
			click(tendercreationlocators.details, "details");
			dynamic_Loader(tendercreationlocators.loadingLocator, 1);
			waitForElementToBeClickable(tendercreationlocators.approverComment);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			
			
			pdfResultReport.addStepDetails("TenderApproverValidation",
					"tender section wise view should pass",
					"Successfully validated tender section wise view" + " ", "Pass", "Y");
			log.info("completed executing the method:: TenderApproverValidation");

		} catch (Exception e) {
			log.fatal("Unable to validate sanction Note Evaluation" + e.getMessage());
			pdfResultReport.addStepDetails("TenderApproverValidation",
					"tender section wise view should pass",
					"Unable to validate tender section wise view" + e.getMessage(), "Fail", "N");
		}
	}
	public void clickDetailLinkInApprovalListPage() throws Throwable {
		try {
			log.info("started executing the method:: clickDetailLinkInApprovalListPage");
			waitForObj(2000);
			click(tendercreationlocators.Actionbtn_IndentApprover, "Actionbtn_IndentApprover");
			//click(tendercreationlocators.Detailbtn_IndentApprover, "Detailbtn_IndentApprover"); //commenting this line due new CR
			click(tendercreationlocators.sectionWiseView_IndentApprover, "sectionWiseView_IndentApprover");
			waitForElementToBeVisible(tendercreationlocators.LblAppCmnt_IndentApprover);
			waitForObj(3000);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
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
	
	public void tenderLogoutOld() throws Throwable {
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
			if(ThreadLocalWebdriver.getDriver().findElement(By.xpath("//div[@id='overlay']")).isDisplayed())
			{
	
				waitForElementToBeInvisible(tendercreationlocators.loadingOverlay);
			}
			ThreadLocalWebdriver.getDriver().navigate().to("https://epsnewprodaws.mjunction.in/EPSV2Web/");
			waitForObj(10000);
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator must be sucessfully logout",
					"Successfully logout" + " ", "Pass", "Y");
			log.info("completed executing the method:: tendercreatorLogout");

		} catch (Exception e) {
			log.fatal("Unable to logout as tender creator" + e.getMessage());
			pdfResultReport.addStepDetails("Tender creator logout", "Tender creator is not logged out",
					"Unable to logout as tender creator" + e.getMessage(), "Fail", "N");
		}
	}

	public void reInitiate() throws Exception {
		try {
			log.info("started executing the method:: reInitiate");
		waitForElementToBeClickable(tendercreationlocators.actionButtonotesheet);
		click(tendercreationlocators.actionButtonotesheet, "action");
		waitForElementToBeClickable(tendercreationlocators.reinitiated);
		click(tendercreationlocators.reinitiated, "reinitiated");
			
			
			pdfResultReport.addStepDetails("reInitiate",
					"Should complete reInitiate",
					"Successfully passed reInitiate" + " ", "Pass", "Y");
			log.info("completed executing the method::reInitiate");
		}
		catch (Exception e) {
			log.fatal("Not able to reInitiate" + e.getMessage());
			pdfResultReport.addStepDetails("reInitiate", "Should complete reInitiate",
					"Not passed reInitiate" + e.getMessage(), "Fail", "N");
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
			waitForElement(tendercreationlocators.dashboardIcon, 5000);
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
	public void sendForForwardParallelTenderApprovalProcess() throws Exception {
		try {
			  log.info("started executing the method:: sendForForwardParallelTenderApprovalProcess");
			  //add approver
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
			  
			  //add approver
			  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
			  click(tendercreationlocators.userAdd_tender, "add user SN");
			  waitForElementToBeVisible(tendercreationlocators.POuseradd);
			 
			  
			//=========Role Activity and other Details===========================
		
				if(fielddisplay==true) {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					
				}
				else {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
				}
			  
			  //co-ordinator , min approver		  
			  waitForElementToBeClickable(tendercreationlocators.cordinatorSN);
				set(tendercreationlocators.parallelApprovermin, pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
			   waitForElementToBeClickable(tendercreationlocators.cordinatorSN);
				click(tendercreationlocators.cordinatorSN, "parallel_Coordinator_Flag");
				//Select minimum approver
				
				
				//send for approval
				scrollToElement(tendercreationlocators.Btn_Forward_Indent);
				waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
				click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
				waitForElementToBeClickable(tendercreationlocators.BtnOk);
				click(tendercreationlocators.BtnOk, "Send for approval");
				
				
			  pdfResultReport.addStepDetails("sendForApprovalProcess",
	                  "send for approval ",
	                  "Successfully sent sendForForwardParallelTenderApprovalProcess " + " ", "Pass", "Y");
	     log.info("completed executing the method:: sendForForwardParallelTenderApproval Process");
			
		} catch (Exception e) {
			log.fatal("Unable to sendForForwardParallelTenderApprovalProcess" + e.getMessage());
	        pdfResultReport.addStepDetails("sendForForwardParallelTenderApprovalProcess",
	                     "send for approval ",
	                     "Unable to send for approval sendForForwardParallelTenderApprovalProcess" + e.getMessage(), "Fail", "N");
		}
		
	}

	public void AddSingleUsersForSequentialApproval_NotesheetWF(String user) throws Throwable {
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
					click(tendercreationlocators.canceluserinApprover, "cancelUserNotesheet");
				}
			}
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			
			 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					set(tendercreationlocators.user1_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					set(tendercreationlocators.user1_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(user), "user1");
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
				}

			set(tendercreationlocators.CommentsArea_Notesheet,"need approval",
					"CommentsArea_notesheet");
			
			
			
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Sequential Approval Must Be selected",
					"Sequential Approval selected Sucessfully"
							+ " ",
					"Pass", "Y");
			scrollToElement(tendercreationlocators.sendForApprovalNotesheet);
			click(tendercreationlocators.sendForApprovalNotesheet, "Btn_SendforApproval_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);

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
	
	public void appprovalDecision(String decision) throws Throwable {
		 try {
             log.info("started executing the method:: sanctionNoteEvaluationApprove");
             if(decision=="approve") {
           	  waitForElementToBeClickable(tendercreationlocators.Approvebutton_tender);
                 click(tendercreationlocators.Approvebutton_tender, "sanctionNoteEvaluationApprove");
                if( isElementDisplayed_Updated(tendercreationlocators.warningYes, 2)==true)
                {
              JSClick(tendercreationlocators.warningYes, "warning Ok");
                }
               
                waitForElementToBeClickable(tendercreationlocators.confirmButton);
				click(tendercreationlocators.confirmButton, "confirmButton");
				waitForElementToBeClickable(tendercreationlocators.btnok);
				click(tendercreationlocators.btnok, "btnok");
               
             							}
             else if(decision=="Review Back to Previous Approver") {
                    waitForElementToBeClickable(tendercreationlocators.SendBaackBtn);
                   click(tendercreationlocators.SendBaackBtn, "SendBaackBtn");
                   waitForElementToBeClickable(tendercreationlocators.backToPreviousApprover);
                   click(tendercreationlocators.backToPreviousApprover, "revert back to approver");
                   waitForElementToBeVisible(tendercreationlocators.confirmButton);
                     click(tendercreationlocators.confirmButton, "approveConfirm");
                   waitForElementToBeClickable(tendercreationlocators.btnok);
                   click(tendercreationlocators.btnok, "approveOk");
             }
             
             else if(decision=="send back by branch user") {
                 waitForElementToBeClickable(tendercreationlocators.sendback);
                click(tendercreationlocators.sendback, "send back");
                waitForElementToBeClickable(tendercreationlocators.confirmBtn);
                click(tendercreationlocators.confirmBtn, "review Confirm");
                waitForElementToBeClickable(tendercreationlocators.POSUccessMsg);
                click(tendercreationlocators.POSUccessMsg, "success ok");
                
          }
             
             
             else if(decision=="forward") {
                   waitForElementToBeClickable(tendercreationlocators.Approvebutton_tender);
                   click(tendercreationlocators.Approvebutton_tender, "sanctionNoteEvaluationApprove");
                   waitForElementToBeClickable(tendercreationlocators.ForwardWF_Indent);
                   click(tendercreationlocators.ForwardWF_Indent, "forward to next person");
                   	 if( isElementDisplayed_Updated(tendercreationlocators.warningYes,2)==true)
                        {
                       
                      JSClick(tendercreationlocators.warningYes, "warning Ok");
                        }
             }
             else if (decision=="Review Back to Creator") {
           	  scrollToElement(tendercreationlocators.SendBaackBtn);
                 JSClick(tendercreationlocators.SendBaackBtn, "SendBaackBtn");
                 waitForElementToBeClickable(tendercreationlocators.BackToCreator);
                 click(tendercreationlocators.BackToCreator, "revert back to creator");
                 waitForElementToBeVisible(tendercreationlocators.confirmButton);
                 click(tendercreationlocators.confirmButton, "approveConfirm");
                 waitForElementToBeClickable(tendercreationlocators.btnok);
                 click(tendercreationlocators.btnok, "approveOk");
			}
             
             else if (decision=="final approve Indent") {
           	  waitForElementToBeClickable(tendercreationlocators.Approvebutton_tender);
                 click(tendercreationlocators.Approvebutton_tender, "sanctionNoteEvaluationApprove");
                if( isElementDisplayed_Updated(tendercreationlocators.warningYes, 3)==true)
                {
              JSClick(tendercreationlocators.warningYes, "warning Ok");
                }
                click(tendercreationlocators.EndWF_tender, "Close_Workflow_button");
				click(tendercreationlocators.approveConfirm, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "confirmButton");

                 waitForElementToBeClickable(tendercreationlocators.btnok);
                 click(tendercreationlocators.btnok, "approveOk");
                 
                 waitForElementToBeClickable(tendercreationlocators.NoBtn_IndentApproval);
                 click(tendercreationlocators.NoBtn_IndentApproval, "NoBtn_IndentApproval");
			}
             
             else if (decision=="final Cancel Indent") {
           	  waitForElementToBeClickable(tendercreationlocators.Approvebutton_tender);
                 click(tendercreationlocators.Approvebutton_tender, "sanctionNoteEvaluationApprove");
                if( isElementDisplayed_Updated(tendercreationlocators.warningYes, 3)==true)
                {
              JSClick(tendercreationlocators.warningYes, "warning Ok");
                }
                click(tendercreationlocators.EndWF_tender, "Close_Workflow_button");
				click(tendercreationlocators.approveConfirm, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "confirmButton");

                 waitForElementToBeClickable(tendercreationlocators.btnok);
                 click(tendercreationlocators.btnok, "approveOk");
                 
			}
             
             else if (decision=="final approve Tender") {
           	  waitForElementToBeClickable(tendercreationlocators.Approvebutton_tender);
                 click(tendercreationlocators.Approvebutton_tender, "sanctionNoteEvaluationApprove");
                if( isElementDisplayed_Updated(tendercreationlocators.warningYes, 3)==true)
                {
              JSClick(tendercreationlocators.warningYes, "warning Ok");
                }
                click(tendercreationlocators.EndWF_tender, "Close_Workflow_button");
				click(tendercreationlocators.approveConfirm, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "Confirmation_Workflow_yesbutton");
				click(tendercreationlocators.confirmButton, "confirmButton");
                
                
                 waitForElementToBeClickable(tendercreationlocators.btnok);
                 click(tendercreationlocators.btnok, "approveOk");
			}
             
            
             pdfResultReport.addStepDetails("sanctionNoteEvaluationApprove",
                          "sanction Note Evaluation must be approve sucessfully ",
                          "Successfully approved sanction Note Evaluation" + " ", "Pass", "Y");
             log.info("completed executing the method:: sanctionNoteEvaluationApprove");

      } catch (Exception e) {
             log.fatal("Unable to approve sanction Note Evaluation" + e.getMessage());
             pdfResultReport.addStepDetails("sanctionNoteEvaluationApprove",
                          "sanction Note Evaluation must be approve sucessfully ",
                          "Unable to approve sanction Note Evaluation" + e.getMessage(), "Fail", "N");
      }
		
	}
public void provideApproverCommentforTenderApprover() throws Exception {
		
		try {
			log.info("started executing the method:: provideApproverCommentforTenderApprover");
			String comment = "Tender Process Is Approved";
			click(tendercreationlocators.approverComment, "approverComment");
			
			dynamic_Loader(tendercreationlocators.loadingLocator, 1);
			
			//scrollToElement(tendercreationlocators.Approvercomment_tender);
			clear(tendercreationlocators.Approvercomment_tender, "comment");
			set(tendercreationlocators.Approvercomment_tender, comment,"comment");


			pdfResultReport.addStepDetails("provideApproverCommentforTenderApprover",
					"provideApproverCommentforTenderApprover should pass",
					"Successfully validated provideApproverCommentforTenderApprover" + " ", "Pass", "Y");
			log.info("completed executing the method:: provideApproverCommentforTenderApprover");

		} catch (Exception e) {
			log.fatal("Unable to validate sanction Note Evaluation" + e.getMessage());
			pdfResultReport.addStepDetails("provideApproverCommentforTenderApprover",
					"provideApproverCommentforTenderApprover should pass",
					"provideApproverCommentforTenderApprover fail" + e.getMessage(), "Fail", "N");
		}
	}
	public void provideApproverCommentforNotesheetApprover() throws Exception {
		
		try {
			log.info("started executing the method:: provideApproverCommentforTenderApprover");
			String comment = "Indent Process Is Approved";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.AppComments);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments, comment,"AppComments_Indent");

			pdfResultReport.addStepDetails("provideApproverCommentforTenderApprover",
					"provideApproverCommentforTenderApprover should pass",
					"Successfully validated provideApproverCommentforTenderApprover" + " ", "Pass", "Y");
			log.info("completed executing the method:: provideApproverCommentforTenderApprover");

		} catch (Exception e) {
			log.fatal("Unable to validate sanction Note Evaluation" + e.getMessage());
			pdfResultReport.addStepDetails("provideApproverCommentforTenderApprover",
					"provideApproverCommentforTenderApprover should pass",
					"provideApproverCommentforTenderApprover fail" + e.getMessage(), "Fail", "N");
		}
	}

	public void sendForForwardSequentialNoteSheetApprovalProcess() throws Exception {
		try {
			  log.info("started executing the method:: sendForForwardSequentialTenderApprovalProcess");
			  //add approver
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
			  
			  //add approver
			  waitForElementToBeVisible(tendercreationlocators.userAdd_tender);
			  click(tendercreationlocators.userAdd_tender, "add user SN");
			  waitForElementToBeVisible(tendercreationlocators.POuseradd);
			 
			  
			//=========Role Activity and other Details===========================
		
				if(fielddisplay==true) {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover8")), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					set(tendercreationlocators.POuseradd, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover8")), "user1");
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
				}
			  				
				//send for approval
				scrollToElement(tendercreationlocators.Btn_Forward_Indent);
				waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
				click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
				waitForElementToBeClickable(tendercreationlocators.BtnOk);
				click(tendercreationlocators.BtnOk, "Send for approval");			
				
				
			  pdfResultReport.addStepDetails("sendForForwardSequentialTenderApprovalProcess",
	                  "sendForForwardSequentialTenderApprovalProcess should pass",
	                  "sendForForwardSequentialTenderApprovalProcess passed" + " ", "Pass", "Y");
	     log.info("completed executing the method:: sendForForwardSequentialTenderApprovalProcess");
			
		} catch (Exception e) {
			log.fatal("Unable to perform sendForForwardSequentialTenderApprovalProcess" + e.getMessage());
	        pdfResultReport.addStepDetails("sendForForwardSequentialTenderApprovalProcess",
	                     "sendForForwardSequentialTenderApprovalProcess should pass",
	                     "sendForForwardSequentialTenderApprovalProcess not passed " + e.getMessage(), "Fail", "N");
		}
			  
		
	}

	public void editNotesheet() throws Exception {

		try {
			log.info("started executing the method:: editDraftTender");
			waitForElementToBeClickable(tendercreationlocators.pendingForEvaluationApproval);
			click(tendercreationlocators.pendingForEvaluationApproval, "edit Tender");
			scrollToTopOfThePage();
			
			pdfResultReport.addStepDetails("editDraft_Notesheet_",
					"should able to click on edit/draft _Notesheet_",
					"Successfully edit draft _Notesheet_" + " ", "Pass", "Y");
			log.info("completed executing the method:: editDraft_Notesheet_");

		} catch (Exception e) {
			log.fatal("Unable to validate editDraft_Notesheet_" + e.getMessage());
			pdfResultReport.addStepDetails("editDraft_Notesheet_",
					"should able to click on edit/draft _Notesheet_",
					"Unable to edit draft _Notesheet_" + e.getMessage(), "Fail", "N");
		}
		
	}
	public void editLOA() throws Exception {

		try {
			log.info("started executing the method:: editDraftTender");
			waitForElementToBeClickable(tendercreationlocators.pendingForEvaluationApproval);
			click(tendercreationlocators.pendingForEvaluationApproval, "edit LOA");
			waitForObj(3000);
			scrollToTopOfThePage();
			
			pdfResultReport.addStepDetails("editDraft_Notesheet_",
					"should able to click on edit/draft _Notesheet_",
					"Successfully edit draft _Notesheet_" + " ", "Pass", "Y");
			log.info("completed executing the method:: editDraft_Notesheet_");

		} catch (Exception e) {
			log.fatal("Unable to validate editDraft_Notesheet_" + e.getMessage());
			pdfResultReport.addStepDetails("editDraft_Notesheet_",
					"should able to click on edit/draft _Notesheet_",
					"Unable to edit draft _Notesheet_" + e.getMessage(), "Fail", "N");
		}
		
	}
	
	public void AddMultipleUsersForSequentialParallelApproval_Notesheet_WF() throws Throwable {
		try {
			log.info("started executing the method:: AddMultipleUsersForSequentialParallelApproval_Tender_WF");
			waitForElementToBeClickable(tendercreationlocators.Userdefined_tender);
			click(tendercreationlocators.Userdefined_tender, "Userdefined");

			waitForElementToBeClickable(tendercreationlocators.CommentsArea_Notesheet);
			set(tendercreationlocators.CommentsArea_Notesheet, "need approvals",
					"comments");
			
			List<WebElement> iRows = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.canceluserinApprover);
			int iRowCount = iRows.size();
			
			
				while(iRowCount!= 0)
				{
					click(tendercreationlocators.canceluserinApprover, "cancelUser1_tender");
					iRowCount = ThreadLocalWebdriver.getDriver().findElements(tendercreationlocators.canceluserinApprover).size();
					}
			//approver 1 parallel
				waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				click(tendercreationlocators.userAdd_tender, "userAdd");
			  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
			  
				//=========Role Activity and other Details===========================
				String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					
				}
				else {
					set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
				}
			 
			//approver 2 parallel
				waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				click(tendercreationlocators.userAdd_tender, "userAdd");
				  waitForElementToBeVisible(tendercreationlocators.approverNotesheet);
				  
				  
				//=========Role Activity and other Details===========================
					
					if(fielddisplay==true) {
						set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user1");
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						selectbyIndex(tendercreationlocators.approverTypePO, 1);
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
						
					}
					else {
						set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user1");
						select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
					}
				//approver 3 parallel
					waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
					click(tendercreationlocators.userAdd_tender, "userAdd");
					  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
					  
					//=========Role Activity and other Details===========================
						
						if(fielddisplay==true) {
							set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover3")), "user1");
							selectbyIndex(tendercreationlocators.approverTypePO, 1);
							selectbyIndex(tendercreationlocators.approverTypePO, 1);
							select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
							
						}
						else {
							set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover3")), "user1");
							select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType1"));
						}

					  //co-ordinator , min approver					
					  waitForElementToBeClickable(tendercreationlocators.parallelApprovermin);
						set(tendercreationlocators.parallelApprovermin, pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
					   waitForElementToBeClickable(tendercreationlocators.cordinatorSNclick);
						click(tendercreationlocators.cordinatorSNclick, "parallel_Coordinator_Flag");
					  
						//approver 4 sequential
						waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
						click(tendercreationlocators.userAdd_tender, "userAdd");
						  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
						  
						//=========Role Activity and other Details===========================
							
							if(fielddisplay==true) {
								set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover4")), "user1");
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								selectbyIndex(tendercreationlocators.approverTypePO, 1);
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								
							}
							else {
								set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover4")), "user1");
								select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
							}
						  
  
					  
					  
						//approver 5 sequential
							waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
							click(tendercreationlocators.userAdd_tender, "userAdd");
							  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
							  
							//=========Role Activity and other Details===========================
								
								if(fielddisplay==true) {
									set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
									selectbyIndex(tendercreationlocators.approverTypePO, 1);
									selectbyIndex(tendercreationlocators.approverTypePO, 1);
									select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
									
								}
								else {
									set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover5")), "user1");
									select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
								}
							  	  
	
							//approver 6 sequential
								waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
								click(tendercreationlocators.userAdd_tender, "userAdd");
								  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
								  
								//=========Role Activity and other Details===========================
									
									if(fielddisplay==true) {
										set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover6")), "user1");
										selectbyIndex(tendercreationlocators.approverTypePO, 1);
										selectbyIndex(tendercreationlocators.approverTypePO, 1);
										select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
										
									}
									else {
										set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover6")), "user1");
										select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
									}
								  	 
				
								//approver 7 sequential
									waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
									click(tendercreationlocators.userAdd_tender, "userAdd");
									  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
									  
									//=========Role Activity and other Details===========================
										
										if(fielddisplay==true) {
											set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover7")), "user1");
											selectbyIndex(tendercreationlocators.approverTypePO, 1);
											selectbyIndex(tendercreationlocators.approverTypePO, 1);
											select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
											
										}
										else {
											set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover7")), "user1");
											select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
										}
									     

									//approver 8 sequential
										waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
										click(tendercreationlocators.userAdd_tender, "userAdd");
										  waitForElementToBeVisible(tendercreationlocators.approverNotesheet); 
										  
										//=========Role Activity and other Details===========================
											
											if(fielddisplay==true) {
												set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover8")), "user1");
												selectbyIndex(tendercreationlocators.approverTypePO, 1);
												selectbyIndex(tendercreationlocators.approverTypePO, 1);
												select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
												
											}
											else {
												set(tendercreationlocators.approverNotesheet, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover8")), "user1");
												select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
											}
										  
										
											
											waitForElementToBeClickable(tendercreationlocators.sendForApprovalNotesheet);
										  JSClick(tendercreationlocators.sendForApprovalNotesheet, "sendForApproval");
										  
										  dynamic_Loader(tendercreationlocators.loadingLocator, 2);
					  
			pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_Tender_WF",
					"should able to send for wf tender",
					"Successfully send for wf tender" + " ", "Pass", "Y");
			log.info("completed executing the method:: AddMultipleUsersForSequentialParallelApproval_Tender_WF");

		} catch (Exception e) {
			log.fatal("Unable to validate AddMultipleUsersForSequentialParallelApproval_Tender_WF" + e.getMessage());
			pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_Tender_WF",
					"should able send for wf tender",
					"Unable to send for wf tender" + e.getMessage(), "Fail", "N");
		}
		
	}

	
	public void recallNotesheet() throws Exception {
		try {	
			log.info("started executing the method:: recallNotesheet");
			
			
			waitForElementToBeClickable(tendercreationlocators.ActionButton);
			click(tendercreationlocators.ActionButton, "notesheet list action button");
			waitForElementToBeClickable(tendercreationlocators.RecallNotesheet);
			click(tendercreationlocators.RecallNotesheet, "recall button");
			
			
			waitForElementToBeClickable(tendercreationlocators.recallComment);
			
			
			
			set(tendercreationlocators.recallComment, "recall", "recommendationComment");
		pdfResultReport.addStepDetails("recallButtonValidation", "Recall button must be validate successfully",
				"Successfully validated recall button" + " ", "Pass", "Y");
		click(tendercreationlocators.recallreasonSubmit, "recallReasonSubmit");
		
		if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2)==true)
		{
			waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
		}	
		
		
		pdfResultReport.addStepDetails("recallTender",
				"should able to recall tender",
				"Successfully recalled tender" + " ", "Pass", "Y");
		log.info("completed executing the method:: AddMultipleUsersForSequentialParallelApproval_Tender_WF");
	}
		catch (Exception e) {
			log.fatal("Unable to validate recallTender" + e.getMessage());
			pdfResultReport.addStepDetails("recallTender",
					"should able recall tender",
					"Unable to recall tender" + e.getMessage(), "Fail", "N");
		}
	
		
	}
	public void recallLOA() throws Exception {
		try {	
			log.info("started executing the method:: recallLOA");
			
			
			waitForElementToBeClickable(tendercreationlocators.ActionButton);
			click(tendercreationlocators.ActionButton, "notesheet list action button");
			waitForElementToBeClickable(tendercreationlocators.RecallNotesheet);
			click(tendercreationlocators.RecallNotesheet, "recall button");
			
			
			waitForElementToBeClickable(tendercreationlocators.recallComment);
			
			
			
set(tendercreationlocators.recallComment, "recall", "recommendationComment");
		pdfResultReport.addStepDetails("recallLOA", "Recall button must be validate successfully",
				"Successfully validated recall button" + " ", "Pass", "Y");
		click(tendercreationlocators.SubmitUserName, "recallReasonSubmit");
		
		dynamic_Loader(tendercreationlocators.loadingLocator, 2);
		
		
		pdfResultReport.addStepDetails("recallLOA",
				"should able to recallLOA",
				"Successfully recallLOA" + " ", "Pass", "Y");
		log.info("completed executing the method:: recallLOA");
	}
		catch (Exception e) {
			log.fatal("Unable to validate recallLOA" + e.getMessage());
			pdfResultReport.addStepDetails("recallLOA",
					"should able recallLOA",
					"Unable to recallLOA" + e.getMessage(), "Fail", "N");
		}
	
		
	}

	public void sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(String user) throws Exception {
		try {
			  log.info("started executing the method:: sendForForwardSequential_Single_User_Notesheet_ApprovalProcess");
		
				waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				  scrollToElement(tendercreationlocators.userAdd_tender);
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
				waitForElementToBeClickable(tendercreationlocators.BtnOk);
				click(tendercreationlocators.BtnOk, "BtnOk");
			  pdfResultReport.addStepDetails("sendForForwardSequential_Single_User_Tender_ApprovalProcess",
	                  "sendForForwardSequential_Single_User_Tender_ApprovalProcess should pass",
	                  "sendForForwardSequential_Single_User_Tender_ApprovalProcess passed" + " ", "Pass", "Y");
	     log.info("completed executing the method:: sendForForwardSequential_Single_User_Tender_ApprovalProcess");
			
		} catch (Exception e) {
			log.fatal("Unable to perform sendForForwardSequential_Single_User_Tender_ApprovalProcess" + e.getMessage());
	        pdfResultReport.addStepDetails("sendForForwardSequential_Single_User_Tender_ApprovalProcess",
	                     "sendForForwardSequential_Single_User_Tender_ApprovalProcess should pass",
	                     "sendForForwardSequential_Single_User_Tender_ApprovalProcess not passed " + e.getMessage(), "Fail", "N");
		}
		
	}

	public void AddTwoUsersForSequentialApproval() throws Exception {
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
					click(tendercreationlocators.canceluserinApprover, "cancelUserNotesheet");
				}
			}
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			
			 String xpath_AP = "//table[@id='approver']/tbody[1]/ tr[1]/td[3]/div[1]/select";
				String xpath_Role = "//table[@id='approver']/tbody[1]/ tr[1]/td[4]/div[1]/select";
				
				String AP= "//*[@id='approver']/thead/tr/th[contains(normalize-space(text()),'Activity/Process')]";
				boolean fielddisplay=isElementDisplayed_Updated(By.xpath(AP), 1);
				if(fielddisplay==true) {
					set(tendercreationlocators.user1_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					set(tendercreationlocators.user1_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover1")), "user1");
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
				}
				waitForElementToBeClickable(tendercreationlocators.userAdd_tender);
				click(tendercreationlocators.userAdd_tender, "userAdd");
				
				if(fielddisplay==true) {
					waitForElementToBeClickable(tendercreationlocators.user2_tender);
					set(tendercreationlocators.user2_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user2");
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					selectbyIndex(tendercreationlocators.approverTypePO, 1);
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
					
				}
				else {
					waitForElementToBeClickable(tendercreationlocators.user2_tender);
					set(tendercreationlocators.user2_tender, DatabaseComponent_UnderComponentPakage.formatUserInfo(pdfResultReport.testData.get("UserTenderApprover2")), "user2");
					waitForElementToBeClickable(tendercreationlocators.approverTypePO);
					select(tendercreationlocators.approverTypePO, pdfResultReport.testData.get("ApprovalType2"));
				}
				

			set(tendercreationlocators.CommentsArea_Notesheet,"need approval",
					"CommentsArea_notesheet");
			
			
			
			pdfResultReport.addStepDetails("AddSingleUsersForSequentialApproval_IndentWF",
					"Sequential Approval Must Be selected",
					"Sequential Approval selected Sucessfully"
							+ " ",
					"Pass", "Y");
			scrollToElement(tendercreationlocators.sendForApprovalNotesheet);
			click(tendercreationlocators.sendForApprovalNotesheet, "Btn_SendforApproval_Indent");
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
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

	public void searchNotesheet() throws Exception {
		try {	
			log.info("started executing the method:: recallNotesheet");
			scrollToElement(tendercreationlocators.typeAnyKeyword_Pending);
			clear(tendercreationlocators.typeAnyKeyword_Pending, "search");
			set(tendercreationlocators.typeAnyKeyword_Pending, NoteSheetNo, "notesheetno");
		pdfResultReport.addStepDetails("recallTender",
				"should able to recall tender",
				"Successfully recalled tender" + " ", "Pass", "Y");
		log.info("completed executing the method:: AddMultipleUsersForSequentialParallelApproval_Tender_WF");
	}
		catch (Exception e) {
			log.fatal("Unable to validate recallTender" + e.getMessage());
			pdfResultReport.addStepDetails("recallTender",
					"should able recall tender",
					"Unable to recall tender" + e.getMessage(), "Fail", "N");
		}
	
		
	}

	public void cancelNotesheet() throws Exception {
		try {	
			log.info("started executing the method:: cancelNotesheet");
			click(tendercreationlocators.new_action_button, "new_action_button");
			waitForElementToBeClickable(tendercreationlocators.cancelNotesheet);
			click(tendercreationlocators.cancelNotesheet, "cancelNotesheet");
			waitForElementToBeVisible(tendercreationlocators.cancellationReason_notesheet);
			set(tendercreationlocators.cancellationReason_notesheet, "cancel-not required", "cancellationReason_notesheet");
			click(tendercreationlocators.Submit, "submit");
		
			
			
			
		pdfResultReport.addStepDetails("cancelNotesheet",
				"should able to cancelNotesheet",
				"Successfully cancelNotesheet" + " ", "Pass", "Y");
		log.info("completed executing the method:: cancelNotesheet");
	}
		catch (Exception e) {
			log.fatal("Unable to cancelNotesheet" + e.getMessage());
			pdfResultReport.addStepDetails("cancelNotesheet",
					"should able cancelNotesheet",
					"Unable to cancelNotesheet" + e.getMessage(), "Fail", "N");
		}
	
		
	}

	public void cancelDeletedNotesheetStatus(String status) throws Exception {
		try {	
			log.info("started executing the method:: cancelDeletedNotesheetStatus");
			
			waitForElementToBeClickable(tendercreationlocators.cancelledIndentTab);
			click(tendercreationlocators.cancelledIndentTab, "cancelledIndentTab");
			waitForElementToBeVisible(tendercreationlocators.cancelDeletedNotesheetStatus);
			
			if(text(tendercreationlocators.cancelDeletedNotesheetStatus).equals(status))
			{
				log.info("Status matched:: Cancelled");
			}
			else {
				log.fatal("status mismatched with :: Cancelled");
			}
			
			
		pdfResultReport.addStepDetails("cancelDeletedNotesheetStatus",
				"should able to cancelDeletedNotesheetStatus",
				"Successfully cancelDeletedNotesheetStatus" + " ", "Pass", "Y");
		log.info("completed executing the method:: cancelDeletedNotesheetStatus");
	}
		catch (Exception e) {
			log.fatal("Unable to cancelDeletedNotesheetStatus" + e.getMessage());
			pdfResultReport.addStepDetails("cancelDeletedNotesheetStatus",
					"should able cancelDeletedNotesheetStatus",
					"Unable to cancelDeletedNotesheetStatus" + e.getMessage(), "Fail", "N");
		}
		
	}

	public void deleteNotesheet() throws Exception {
		try {	
			log.info("started executing the method:: deleteNotesheet");
			click(tendercreationlocators.new_action_button, "new_action_button");
			waitForElementToBeClickable(tendercreationlocators.deleteIndentLocator);
			click(tendercreationlocators.deleteIndentLocator, "deleteIndentLocator");
			waitForElementToBeVisible(tendercreationlocators.deleteReason_notesheet);
			set(tendercreationlocators.deleteReason_notesheet, "delete-not required", "deleteReason_notesheet");
			click(tendercreationlocators.Submit, "submit");
		
			
			
			
		pdfResultReport.addStepDetails("deleteNotesheet",
				"should able to deleteNotesheet",
				"Successfully deleteNotesheet" + " ", "Pass", "Y");
		log.info("completed executing the method:: deleteNotesheet");
	}
		catch (Exception e) {
			log.fatal("Unable to deleteNotesheet" + e.getMessage());
			pdfResultReport.addStepDetails("deleteNotesheet",
					"should able deleteNotesheet",
					"Unable to deleteNotesheet" + e.getMessage(), "Fail", "N");
		}
	
		
	}

	public void saveAndDraftState() throws Exception {
		try {	
			log.info("started executing the method:: deleteNotesheet");
			waitForElementToBeClickable(tendercreationlocators.saveNotesheet);
			click(tendercreationlocators.saveNotesheet, "saveNotesheet");
			String s="//*[@id='accordionPanelsStayOpenExample']/div/div[1]/span[1]";
			
			String notesheettext = text(By.xpath(s));
			String[] splittedWord=notesheettext.split(":");
			NoteSheetNo=splittedWord[1].trim();
			System.out.println(NoteSheetNo);
			eTenderComponent.updateDataIntoPropertyFile("NoteSheetNo", NoteSheetNo);
			
		
			
		pdfResultReport.addStepDetails("deleteNotesheet",
				"should able to deleteNotesheet",
				"Successfully deleteNotesheet" + " ", "Pass", "Y");
		log.info("completed executing the method:: deleteNotesheet");
	}
		catch (Exception e) {
			log.fatal("Unable to deleteNotesheet" + e.getMessage());
			pdfResultReport.addStepDetails("deleteNotesheet",
					"should able deleteNotesheet",
					"Unable to deleteNotesheet" + e.getMessage(), "Fail", "N");
		}
	
		
	}
	
	public void aproverBranching(String string1,String string2) throws Exception {
		try {
			log.info("started executing the method:: branching");
		
			String branchingComment = "Need your inputs";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
		scrollToElement(tendercreationlocators.discussionButton);
		click(tendercreationlocators.discussionButton, "Discussion");
		waitForElementToBeVisible(tendercreationlocators.usernameatDiscussion);
			
			for (int i = 2; i <= Integer.parseInt(string1)+1; i++) {
			String	UserTenderApprover="UserTenderApprover"+i;
				set(tendercreationlocators.discussionSearchUser_notesheet, DatabaseComponent_UnderComponentPakage.userFullName(pdfResultReport.testData.get(UserTenderApprover)), "b1");				
				click(tendercreationlocators.arrowIcon, "Arrow ICon");
					set(tendercreationlocators.b1usercomment, branchingComment, "Remarks");

					clear(tendercreationlocators.discussionSearchUser, "search user");

			}
			
			click(tendercreationlocators.Submitbtn_AssignUsermodal_Indent,"Submit Button");

			waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
			click(tendercreationlocators.success_Ok_button, "success_Ok_button");
			scrollToTopOfThePage();
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

	public void nevigateToAllSanctions() throws Throwable {
		try {
			log.info("started executing the method:: nevigateToAllSanctions");
			JSClick(tendercreationlocators.mainMenuIcon, "MenuIcon");
			mouseOver(tendercreationlocators.order);
			JSClick(tendercreationlocators.AllSanctions, "AllSanctions");
			
			if(isElementDisplayed_Updated(By.xpath("//div[contains(@class,'ngx-overlay')]"), 2))
			{
				waitForElementToBeVisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
				waitForElementToBeInvisible(By.xpath("//div[contains(@class,'ngx-overlay')]"));
			}	
			
			waitForElementToBeClickable(tendercreationlocators.mysanctionsTab);
			click(By.xpath("//label[contains(text(),'Completed')]"), "visit completed List");
			
			
			pdfResultReport.addStepDetails("Navigate to allsanction List", "Completed allsanction list must be navigated successfully",
					"Successfully navigated to completed allsanction list" + " ", "Pass", "Y");
			log.info("completed executing the method:: nevigateToAllSanctions");

		} catch (Exception e) {
			log.fatal("Unable to navigate to the completed allsanction list" + e.getMessage());
			pdfResultReport.addStepDetails("Navigate to allsanction List", "Not able to navigate to the completed allsanction list",
					"Unable to navigate to the completed allsanction list" + e.getMessage(), "Fail", "N");
		}
		
	}

	public void searchCompletedSN() throws Throwable {
		try {
			log.info("started executing the method:: searchCompletedSN");
			waitForElementToBeClickable(tendercreationlocators.typeAnyKeyword_Pending);
			clear(tendercreationlocators.typeAnyKeyword_Pending, "typeAnyKeyword"); 
			
			set(tendercreationlocators.typeAnyKeyword_Pending, Dynamicity.getDataFromPropertiesFile("CompletedSN", filePath_4), "CompletedSN");
			SN_No=Dynamicity.getDataFromPropertiesFile("CompletedSN", filePath_4);

			
			pdfResultReport.addStepDetails("searchCompletedSN", "Completed searchCompletedSN successfully",
					"Successfully searchCompletedSN" + " ", "Pass", "Y");
			log.info("completed executing the method:: searchCompletedSN");

		} catch (Exception e) {
			log.fatal("Unable to searchCompletedSN" + e.getMessage());
			pdfResultReport.addStepDetails("searchCompletedSN", "Not able to searchCompletedSN",
					"Unable to searchCompletedSN" + e.getMessage(), "Fail", "N");
		}
		
		
	}
	
	public void searchLOA() throws Throwable {
		try {
			log.info("started executing the method:: searchLOA");
			waitForElementToBeClickable(tendercreationlocators.typeAnyKeyword_Pending);
			clear(tendercreationlocators.typeAnyKeyword_Pending, "typeAnyKeyword"); 
			
			set(tendercreationlocators.typeAnyKeyword_Pending, LOA_No, "LOA_No");

			
			pdfResultReport.addStepDetails("searchLOA", "Completed searchLOA successfully",
					"Successfully searchLOA" + " ", "Pass", "Y");
			log.info("completed executing the method:: searchLOA");

		} catch (Exception e) {
			log.fatal("Unable to searchLOA" + e.getMessage());
			pdfResultReport.addStepDetails("searchLOA", "Not able to searchLOA",
					"Unable to searchLOA" + e.getMessage(), "Fail", "N");
		}
		
		
	}

	public void issueLOA() throws Exception {
		try {
			log.info("started executing the method:: InitiateLOA");
			waitForElementToBeClickable(tendercreationlocators.tenderlistingPageAction);
			click(tendercreationlocators.tenderlistingPageAction, "tenderlistingPageAction");
			waitForElementToBeClickable(tendercreationlocators.issueLOA);
			click(tendercreationlocators.issueLOA, "issueLOA");
			dynamic_Loader(tendercreationlocators.loadingLocator, 1);
			waitForElementToBeVisible(tendercreationlocators.loa_ReferenceNo);
			supOrgID=ThreadLocalWebdriver.getDriver().findElement(By.xpath("//*[@id='vendor_id']")).getAttribute("value");
			DatabaseComponent.uc();Dynamicity.updateDataIntoPropertyFile("Supplier",supOrgID, filePath_4);
			set(tendercreationlocators.loa_ReferenceNo, "RN001", "loa_ReferenceNo");
			set(tendercreationlocators.loa_subject, "S001", "loa_subject");
			set(tendercreationlocators.loa_comment, "loa creation Test", "loa_comment");
			waitForElementToBeClickable(tendercreationlocators.loa_attachment);
			click(tendercreationlocators.loa_attachment, "loa_attachment");
			
			String uploadString="//*[@id='fileInput']";
			scrollToElement(By.xpath(uploadString));
			
					set(By.xpath(uploadString), System.getProperty("user.dir") + "\\MediaFiles\\rfqCreation.xlsx",
							"fileName");
			
		/*	
			File f = new File("text.xlsx");
			String absolute = f.getAbsolutePath();

			StringSelection sel = new StringSelection(absolute);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			System.out.println("selection" + sel);
			ThreadLocalWebdriver.getDriver()
					.findElement(By.xpath("//*[@for='fileInput']/fa-icon"))
					.click();
			Thread.sleep(5000);

			Robot robot = new Robot();
			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
	*/
			
			
			
			scrollToTopOfThePage();
			
			
			pdfResultReport.addStepDetails("InitiateLOA", "Completed InitiateLOA successfully",
					"Successfully InitiateLOA" + " ", "Pass", "Y");
			log.info("completed executing the method:: InitiateLOA");
			
		} catch (Exception e) {
			log.fatal("Unable to InitiateLOA" + e.getMessage());
			pdfResultReport.addStepDetails("InitiateLOA", "Not able to InitiateLOA",
					"Unable to InitiateLOA" + e.getMessage(), "Fail", "N");
		}
	}

	public void submitLOA() throws Exception {
		try {
			log.info("started executing the method:: submitLOA");
			waitForElementToBeClickable(tendercreationlocators.notesheetSubmit);
			click(tendercreationlocators.notesheetSubmit, "notesheetSubmit");
			waitForElementToBeClickable(tendercreationlocators.sendForApprovalNotRequired);
			
			pdfResultReport.addStepDetails("submitLOA", "Completed submitLOA successfully",
					"Successfully submitLOA" + " ", "Pass", "Y");
			log.info("completed executing the method:: submitLOA");
		} catch (Exception e) {
			log.fatal("Unable to submitLOA" + e.getMessage());
			pdfResultReport.addStepDetails("submitLOA", "Not able to submitLOA",
					"Unable to submitLOA" + e.getMessage(), "Fail", "N");
		}
		
	}

	public void approverNotRequired() throws Exception {
		try {
			log.info("started executing the method:: approverNotRequired");
			waitForElementToBeClickable(tendercreationlocators.sendForApprovalNotRequired);
			click(tendercreationlocators.sendForApprovalNotRequired, "sendForApprovalNotRequired");
			waitForElementToBeClickable(tendercreationlocators.Submit);
			click(tendercreationlocators.Submit, "Submit");
			
			pdfResultReport.addStepDetails("approverNotRequired", "Completed approverNotRequired successfully",
					"Successfully approverNotRequired" + " ", "Pass", "Y");
			log.info("completed executing the method:: approverNotRequired");
		} catch (Exception e) {
			log.fatal("Unable to approverNotRequired" + e.getMessage());
			pdfResultReport.addStepDetails("approverNotRequired", "Not able to approverNotRequired",
					"Unable to approverNotRequired" + e.getMessage(), "Fail", "N");
		}
		
		
	}

	
	public void submit() throws Exception {
		try {
			log.info("started executing the method:: submit");
	waitForElementToBeClickable(tendercreationlocators.Submit);
	click(tendercreationlocators.Submit, "Submit");
	
	pdfResultReport.addStepDetails("submit", "Completed submit successfully",
			"Successfully submit" + " ", "Pass", "Y");
	log.info("completed executing the method:: submit");

} catch (Exception e) {
	log.fatal("Unable to submit" + e.getMessage());
	pdfResultReport.addStepDetails("approverNotRequired", "Not able to submit",
			"Unable to submit" + e.getMessage(), "Fail", "N");
}

}
}
	

