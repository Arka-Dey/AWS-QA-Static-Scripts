package com.components;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.baseClasses.ThreadLocalWebdriver;
import com.objectRepository.TenderCreation_Locators;

public class Change_request_Component extends BaseClass_Web {

//	String NoteSheetNo = null;
	String NoteSheetNo="1553";
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
			waitForObj(500);
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
	
	public void createNotesheet() throws Throwable {
		try {
			log.info("started executing the method:: createNotesheet");		
			
			waitForElementToBeClickable(tendercreationlocators.createNotesheetIcon);
			click(tendercreationlocators.createNotesheetIcon, "create notesheet");
			waitForElementToBeVisible(tendercreationlocators.subject);
			set(tendercreationlocators.subject, "NoteSheet for discussion", "subject");
			set(tendercreationlocators.notesheetRefNo, "NoteSheet ref. no", "ref no");
			waitForElementToBeClickable(tendercreationlocators.briefcaseNotesheet);
			click(tendercreationlocators.briefcaseNotesheet, "ebriefcase icon");
			waitForElementToBeClickable(tendercreationlocators.addfile);
			click(tendercreationlocators.addfile, "add file");
			
			
			
	//		click(tendercreationlocators.createNotesheetIcon, "add attachment icon");
		//	set(tendercreationlocators.notesheetdocupload, "\\MediaFiles\\Guidelines_Tnd_092110_176532.pdf", "attachment");
			waitForObj(1000);
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
			waitForObj(4000);
			NoteSheetNo=NotesheetNoSave();
			
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
			//waitForObj(2000);
			waitForElementToBeClickable(tendercreationlocators.CompleteIndentbtn);
			click(tendercreationlocators.CompleteIndentbtn, "CompleteIndentbtn");
			waitForElementToBeVisible(tendercreationlocators.Lbl_IndentList);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(2000);
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
		waitForObj(2500);
		clear(tendercreationlocators.searchBoxGRN, NoteSheetNo);
		set(tendercreationlocators.searchBoxGRN, NoteSheetNo, "search notesheet");

		Assert.assertEquals(text(tendercreationlocators.notesheetStatus), status);

				pdfResultReport.addStepDetails("verifyNoteSheetStatus",
						"NoteSheetStatus should matched",
						"Successfully mached notesheetstatus" + " ", "Pass", "Y");
			
			waitForObj(1000);
			
		} catch (Exception e) {
			log.fatal("Not able to verifyNoteSheetStatuse" + e.getMessage());
			pdfResultReport.addStepDetails("verifyNoteSheetStatus", "verifyNoteSheetStatus should matched",
					"Notesheet status not mached" + e.getMessage(), "Fail", "N");
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
			waitForObj(2500);

		if(text(tendercreationlocators.reinitiatedmsg).contains(status))
		{
		

					waitForObj(1000);
			
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
			waitForObj(2000);
			JSClick(tendercreationlocators.pending, "pending");
			waitForElementToBeVisible(tendercreationlocators.Lbl_workflowinbox);
			set(tendercreationlocators.search,NoteSheetNo, "search");
			waitForObj(1000);
			waitForElementToBeClickable(tendercreationlocators.notesheetTab);

			click(tendercreationlocators.notesheetTab, "notesheet tab");
			waitForElementToBeClickable(tendercreationlocators.Actionbtn_IndentApprover);
			
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
			scrollToElement(tendercreationlocators.AppComments_Indent);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments_Indent, comment,"AppComments_Indent");
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
			  waitForObj(1000);
			  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				scrollToElement(tendercreationlocators.POuseradd);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover3"), "user1");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
				
				waitForObj(1000);
				  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
					waitForObj(1000);
					scrollToElement(tendercreationlocators.POuseradd);
					set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover4"), "user2");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
					
					waitForObj(1000);
					  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.POuseradd);
						set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover5"), "user3");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
			  
			  //co-ordinator , min approver		  
			  waitForElementToBeClickable(tendercreationlocators.corrdiantorNotesheet);
				set(tendercreationlocators.min_approverNotesheet, pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
			   waitForElementToBeClickable(tendercreationlocators.corrdiantorNotesheet);
				click(tendercreationlocators.corrdiantorNotesheet, "parallel_Coordinator_Flag");
				//Select minimum approver
				
				
				//send for approval
				scrollToElement(tendercreationlocators.Btn_Forward_Indent);
				waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
				click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
				
				waitForElementToBeClickable(tendercreationlocators.indesntCancelSuccessMessageOkButton);
				click(tendercreationlocators.indesntCancelSuccessMessageOkButton, "forward message");
				
				
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
	
	public void appprovalDecision(String decision) throws Throwable {
		  try {
            log.info("started executing the method:: appprovalDecision");
            waitForObj(1000);
        	mouseOver(tendercreationlocators.SendBtn_Indent);
        	waitForObj(1000);
            if(decision=="approve") {
            	waitForObj(2000);
            	mouseOver(tendercreationlocators.SendBtn_Indent);
                click(tendercreationlocators.SendBtn_Indent, "click send button");
                waitForElementToBeClickable(tendercreationlocators.releaseConfirmYes);
                click(tendercreationlocators.releaseConfirmYes, "revert back to approver");
//                waitForElementToBeClickable(tendercreationlocators.releaseConfirmYes);
//                click(tendercreationlocators.releaseConfirmYes, "confirm yes");
                waitForElementToBeClickable(tendercreationlocators.BtnOk);
                click(tendercreationlocators.BtnOk, "ok button");
                
            }
            else if(decision=="revert back to approver") {
           
                  click(tendercreationlocators.Reviewbutton_tender, "sanctionNote review");
                  waitForElementToBeClickable(tendercreationlocators.ReviewBackWF_Indent_to_previousApprover);
                  click(tendercreationlocators.ReviewBackWF_Indent_to_previousApprover, "previous approver");
                  waitForElementToBeClickable(tendercreationlocators.releaseConfirmYes);
                click(tendercreationlocators.releaseConfirmYes, "confirm yes");
                waitForElementToBeClickable(tendercreationlocators.BtnOk);
                click(tendercreationlocators.BtnOk, "ok button");
                  
            }
            else if(decision=="forward") {
            	scrollToElement(tendercreationlocators.SendBtn_Indent);
                waitForObj(1500);
                  JSClick(tendercreationlocators.SendBtn_Indent, "approve");
                  waitForObj(3000);
                 
                  waitForElementToBeClickable(tendercreationlocators.ForwardWF_Indent);
                  click(tendercreationlocators.ForwardWF_Indent, "Forward_WF_Indent");
                  waitForObj(1000);
       /*         waitForElementToBeClickable(tendercreationlocators.releaseConfirmYes);
                click(tendercreationlocators.releaseConfirmYes, "confirm yes");
                waitForElementToBeClickable(tendercreationlocators.BtnOk);
                click(tendercreationlocators.BtnOk, "ok button");             */     // 1 approval forward
                  }
            else if (decision=="revert back to creator") {
            	  click(tendercreationlocators.Reviewbutton_tender, "sanctionNote review");
            	  waitForElementToBeClickable(tendercreationlocators.reverseBackToNotesheetCreator);
                  click(tendercreationlocators.reverseBackToNotesheetCreator, "revert back to creator");
                  waitForElementToBeClickable(tendercreationlocators.releaseConfirmYes);
                click(tendercreationlocators.releaseConfirmYes, "confirm yes");
                waitForElementToBeClickable(tendercreationlocators.BtnOk);
                click(tendercreationlocators.BtnOk, "ok button");
                
			}
            
            waitForObj(5000);
           
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

	public void provideApproverCommentforNotesheetApprover() throws Exception {
		
		try {
			log.info("started executing the method:: provideApproverCommentforTenderApprover");
			String comment = "Indent Process Is Approved";
			click(tendercreationlocators.LblAppCmnt_IndentApprover, "LblAppCmnt_IndentApprover");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.AppComments_Indent);
			//SSJSSend(tendercreationlocators.AppComments_Indent,"AppComments_Indent", comment);
			set(tendercreationlocators.AppComments_Indent, comment,"AppComments_Indent");

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
			  waitForObj(1000);
			  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				scrollToElement(tendercreationlocators.POuseradd);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover6"), "user1");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(1000);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
			  
			  //add approver
				  waitForObj(1000);
				  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
					waitForObj(1000);
					scrollToElement(tendercreationlocators.POuseradd);
					set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover7"), "user1");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
					waitForObj(1000);
					select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
			  
			  //add approver
					  waitForObj(1000);
					  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
						waitForObj(1000);
						scrollToElement(tendercreationlocators.POuseradd);
						set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover8"), "user1");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
						waitForObj(1000);
						select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
			  
				
						//send for approval
						scrollToElement(tendercreationlocators.Btn_Forward_Indent);
						waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
						click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");
						
						waitForElementToBeClickable(tendercreationlocators.indesntCancelSuccessMessageOkButton);
						click(tendercreationlocators.indesntCancelSuccessMessageOkButton, "forward message");
				
			
				
			  pdfResultReport.addStepDetails("sendForForwardSequential_Notesheet_ApprovalProcess",
	                  "sendForForwardSequential_Notesheet_ApprovalProcess should pass",
	                  "sendForForwardSequential_Notesheet_ApprovalProcess passed" + " ", "Pass", "Y");
	     log.info("completed executing the method:: sendForForwardSequential_Notesheet_ApprovalProcess");
			
		} catch (Exception e) {
			log.fatal("Unable to perform sendForForwardSequential_Notesheet_ApprovalProcess" + e.getMessage());
	        pdfResultReport.addStepDetails("sendForForwardSequential_Notesheet_ApprovalProcess",
	                     "sendForForwardSequential_Notesheet_ApprovalProcess should pass",
	                     "sendForForwardSequential_Notesheet_ApprovalProcess not passed " + e.getMessage(), "Fail", "N");
		}
			  
		
	}

	public void editNotesheet() throws Exception {

		try {
			log.info("started executing the method:: editDraftTender");
			waitForElementToBeClickable(tendercreationlocators.editDraftTender);
			click(tendercreationlocators.editDraftTender, "edit Tender");
			waitForObj(3000);
			
			
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

	public void AddMultipleUsersForSequentialParallelApproval_Notesheet_WF() throws Exception {
		try {
			log.info(
					"started executing the method:: AddMultipleUsersForSequentialParallelApproval_Notesheet_WF");
			click(tendercreationlocators.UserDefinedWFchkbox_Notesheet, "UserDefinedWFchkbox_Indent");

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
			//approver 1 parallel
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			waitForObj(1000);
			set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("notesheetApprover1Send"), "user1_Indent");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
			waitForObj(1000);
			
			//approver 2 parallel
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			waitForObj(1000);
			set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover2"), "user1_Indent");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
			waitForObj(1000);
			
			//approver 3 parallel
			click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			waitForObj(1000);
			set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover3"), "user1_Indent");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type2"));
			waitForObj(1000);
			
			

			  //co-ordinator , min approver
			  waitForElementToBeClickable(tendercreationlocators.parallelApproverminNotesheet);
				set(tendercreationlocators.parallelApproverminNotesheet, pdfResultReport.testData.get("Min_Approver"), "minimum_Approver");
			   waitForElementToBeClickable(tendercreationlocators.parallelappNotesheetCoordinator);
				click(tendercreationlocators.parallelappNotesheetCoordinator, "parallel_Coordinator_Flag");
			
				//approver 4 sequential
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover4"), "user1_Indent");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				waitForObj(1000);
				
				//approver 5 sequential
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover5"), "user1_Indent");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				waitForObj(1000);
				
				//approver 6 sequential
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover6"), "user1_Indent");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				waitForObj(1000);
				
				//approver 7 sequential
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover7"), "user1_Indent");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				waitForObj(1000);
			
				//approver 8 sequential
				click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
				waitForObj(1000);
				set(tendercreationlocators.POuseradd, pdfResultReport.testData.get("UserNotesheetApprover8"), "user1_Indent");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
				waitForObj(500);
				select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));
				waitForObj(1000);
				
				
			set(tendercreationlocators.CommentsArea_Notesheet, pdfResultReport.testData.get("UserDefined_Approver_CommentsIndent"),
					"CommentsArea_Indent");
			
			
			
			pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_Notesheet_WF",
					"Sequential-parallel Approval Must Be selected",
					"Sequential-parallel Approval selected Sucessfully"
							+ " ",
					"Pass", "Y");
			waitForObj(2000);
			scrollToElement(tendercreationlocators.Btn_SendforApproval_Indent);
			click(tendercreationlocators.Btn_SendforApproval_Indent, "Btn_SendforApproval_Indent");
			waitForElementToBeVisible(tendercreationlocators.notesheetListPage);
			//waitTillSpinnerDisable(ThreadLocalWebdriver.getDriver(), tendercreationlocators.LoadingBy);
			waitForObj(5000);
			pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_Notesheet_WF",
					"Must Submit the Indent With Seq Flow ",
					"Sucessfully Submitted Notesheet With Seq Flow "
							+ " ",
					"Pass", "Y");
			log.info(
					"completed executing the method:: AddMultipleUsersForSequentialParallelApproval_Notesheet_WF");
		} catch (Exception e) {
			log.fatal("Not able to Submit Indent" + e.getMessage());
			pdfResultReport.addStepDetails("AddMultipleUsersForSequentialParallelApproval_Notesheet_WF",
					"Must Submit the Notesheet With Seq-parallel Flow ",
					"Not able to Submit Notesheet"
							+ e.getMessage(),
					"Fail", "N");
                       Assert.fail("Failed Due to " + e.getMessage());
		}
		
	}

	public void recallNotesheet() throws Exception {
		try {	
			log.info("started executing the method:: recallNotesheet");
			
			
			waitForElementToBeClickable(tendercreationlocators.NotesheetAction);
			click(tendercreationlocators.NotesheetAction, "notesheet list action button");
			waitForElementToBeClickable(tendercreationlocators.RecallNotesheet);
			click(tendercreationlocators.RecallNotesheet, "recall button");
			
			
			waitForElementToBeClickable(tendercreationlocators.recallComment);
			
			
			
set(tendercreationlocators.recallComment, "recall", "recommendationComment");
		pdfResultReport.addStepDetails("recallButtonValidation", "Recall button must be validate successfully",
				"Successfully validated recall button" + " ", "Pass", "Y");
		click(tendercreationlocators.recallreasonSubmit, "recallReasonSubmit");
		waitForElementToBeClickable(tendercreationlocators.success_Ok_button);
		click(tendercreationlocators.success_Ok_button, "recall button");
		
		
		
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

	public void sendForForwardSequential_Single_User_Notesheet_ApprovalProcess(String string) throws Exception {
		try {
			  log.info("started executing the method:: sendForForwardSequential_Single_User_Notesheet_ApprovalProcess");
		  //add approver
		 waitForElementToBeClickable(tendercreationlocators.userAdd_Indent);
		  click(tendercreationlocators.userAdd_Indent, "userAdd_Indent");
			waitForObj(1000);
			scrollToElement(tendercreationlocators.POuseradd);
			set(tendercreationlocators.POuseradd,string, "user");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "For Administrative Approval");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, "Sectional In-charge");
			waitForObj(500);
			select(tendercreationlocators.approverType1_Indent, pdfResultReport.testData.get("Indent_Approver_Type1"));

	
			//send for approval
			scrollToElement(tendercreationlocators.Btn_Forward_Indent);
			waitForElementToBeClickable(tendercreationlocators.Btn_Forward_Indent);
			click(tendercreationlocators.Btn_Forward_Indent, "Send for approval");		
			waitForElementToBeClickable(tendercreationlocators.indesntCancelSuccessMessageOkButton);
			click(tendercreationlocators.indesntCancelSuccessMessageOkButton, "forward message");
		
			pdfResultReport.addStepDetails("sendForForwardSequential_Single_User_Notesheet_ApprovalProcess",
					"should able to sendForForwardSequential_Single_User_Notesheet_ApprovalProcess",
					"Successfully sendForForwardSequential_Single_User_Notesheet_ApprovalProcess" + " ", "Pass", "Y");
			log.info("completed executing the method:: sendForForwardSequential_Single_User_Notesheet_ApprovalProcess");
		}
		catch (Exception e) {
			log.fatal("Unable to validate sendForForwardSequential_Single_User_Notesheet_ApprovalProcess" + e.getMessage());
			pdfResultReport.addStepDetails("recallTender",
					"should able sendForForwardSequential_Single_User_Notesheet_ApprovalProcess",
					"Unable to sendForForwardSequential_Single_User_Notesheet_ApprovalProcess" + e.getMessage(), "Fail", "N");
		}



	}
}
	

