package com.objectRepository;

import org.openqa.selenium.By;

public class TenderCreation_Locators {

	public By login = By.xpath("//img[contains(@src,'icon-login')]");
	public By userName = By.xpath("//h5[contains(text(), 'Username')]/following-sibling::input");
//	public By userName = By.xpath("//input[@name='userCode'][@type='text']");
	public By password = By.xpath("//h5[contains(text(), 'Password')]/following-sibling::input");
//	public By password = By.xpath("//input[@name='passcode']");
	public By Captcha_Login = By.xpath("//input[@name='captcha' and @ng-model = 'login.captcha']");
	public By okButton = By.xpath("//button[normalize-space(text()) = 'LOGIN']");
	public By okButton_HMEL = By.xpath("//button[text()=' LOGIN ']");
	//public By dashboardIcon = By.xpath("//h3[contains(@class, 'page-header box_shadow page-header-ex ng-binding')]");
	public By Myprofile = By.xpath("//ul[@aria-labelledby='dropdownUser1']/li[1]");
	public By dashboardIcon = By.xpath("/html/body/app-root/div/div/div/div/app-dashboard");
	public By dashboardIconnew = By.xpath("//*[text()[contains(.,'Dashboard')]]");
	public By UserIconnew = By.xpath("//div[@id='user-profile-img-dashbord']");
	public By mysanctionsTab = By.xpath("//*[@id='nav-my-loa-tab']");
	public By TenderListIcon = By.xpath("//*[contains(normalize-space(text()),'Live Tender')]");
	//public By createNewTender = By.xpath("(//a[normalize-space()='Create New'])[1]");
	public By createNewTender = By.xpath("//button[@class='btn add']");
	public By tendersIcon = By.xpath("//span[contains(text(),'Tender(s)')]//parent::a//i[@class='fa fa-tasks']");
	public By tenderList = By.xpath("//a[contains(@ng-click,'tender/listTender')]");
	public By PendingTab_MyTender_tenderlistpage = By.xpath("//li[contains(text(),'Tender List')]");
	public By tendercreationPlusicon = By.xpath("//button[@data-original-title='Tender Creation']");
	public By templateGroupdropdown = By.xpath("//select[@name='templateGroup']");
	public By bitPartdropdown = By.xpath("//select[@name='bidPartNo']");
	public By bitPartRadio = By.xpath("//*[@id='generalInfoTab']/div/form/div[1]/div[3]/div/label/input");
	public By bitPartRadio2 = By.xpath("//input[@value='1&2,3']");
	public By tenderReferenceNumber = By.xpath("//input[@name='referenceNo']");
	public By procurementCategory = By.xpath("//select[@name='procat']");
	public By tenderCurrency = By.xpath("//select[@name='currency']");
	public By probabaleAmountContract = By.xpath("//input[@name='pacamt']");
	public By biddingCurrency = By.xpath("//select[@name='bcurrency']");
	public By tenderType = By.xpath("//select[@name='tenderType']");
	public By Min_bid_no = By.xpath("//input[@name = 'minbidno']");
	public By offerValidity = By.xpath("//input[@name='offerValidity']");
	public By detailedDescription = By.xpath("//textarea[@name='description']");
	public By savebutton = By.xpath("//a/button[@class='roundActionBtn m-r-15 btn-primary animate_btn']");
	public By savebutton_Supplier = By.xpath("//*[@id='bidsave']");
	public By savebuttonNew = By.xpath("//section[@class='contentSection']/div/div/button[2]");
	public By editTenderTitle = By.xpath("//span[text()=' Edit Tender']");
	public By otherAttachements = By.xpath("//a[text()='Other Attachments']");
	public By orderListPage = By.xpath("//*[text()='Order List']");
	public By addtenderattachmenticon = By.xpath("//button[@data-original-title='Add']");
	public By supportingdocument = By.xpath("//input[@placeholder='Supporting Document']");
	public By buyerattachemntOK = By.xpath("//button[@id='add-author3']");
	public By projectDetailsTab = By.xpath("//a[text()='Project Details']");
	public By projectName = By.xpath("//input[@placeholder='Project Name']");
	public By projectLocation = By.xpath("//input[@placeholder='Project Location']");
	public By product = By.xpath("//input[@placeholder='Product']");
	public By contactPerson = By.xpath("//input[@placeholder='Contact Person']");
	public By attachementsTab = By.xpath("//a[text()='Attachments']");
	public By attachment_subtab = By.xpath("//a[text()='Attachment']");
	public By fileName = By.xpath("//input[@file-model='tenderAttachments']");
	public By openattachementsTab = By
			.xpath("//button[@data-original-title='Add'][@ng-click='openAttachmentModal(templateIndex)']");
	public By label = By.xpath("//input[@placeholder='Label']");
	public By uploadatachementIcon = By.xpath("//input[@file-model='tenderAttachments']//parent::a");
	public By VisibleTo = By.xpath("//select[@name='visible']");
	public By attachmentOKbutton = By.xpath("//button[@id='add-authorRow']");
	public By dateschedule = By.xpath("//span[text()='Date Schedule']");
	public By bidsubmissionStartDate = By.xpath("(//*[@aria-haspopup='dialog' and @aria-required='true'])[1]");
	public By bidsubmissionDueDate = By.xpath("(//*[@aria-haspopup='dialog' and @aria-required='true'])[2]");
	public By bidsubmissionDueDate_Old = By.xpath("//*[@id='rfqdate.bid_end_date.0']");
	public By bidsubmissionOpenDate = By.xpath("(//*[@aria-haspopup='dialog' and @aria-required='true'])[3]");
	public By bidsubmissionOpenDate_Old = By.xpath("//*[@id='rfqdate.bid_open_date.0']");
	public By BOQOptionalTab = By.xpath("//a[text()='BOQ (Optional)']");
	public By addNonSORItem = By.xpath("//button[@data-original-title='Add NON SOR Item']");
	public By BOQOptionItemCode = By.xpath("//input[@id='ri_boq_optional.item_code.0']");
	public By BOQOptionItemDescription = By.xpath("//input[@id='ri_boq_optional.item_name.0']");
	public By BOQOptionUOM = By.xpath("//select[@id='ri_boq_optional.uom.0']");
	public By projectquantity = By.xpath("//input[@placeholder='Project Quantity']");
	public By preferedmake = By.xpath("//input[@placeholder='Prefered Make']");
	public By budgetedrate = By.xpath("//input[@placeholder='Budgeted Rate']");
	public By remarks = By.xpath("//textarea[@placeholder='Remarks']");
	public By termsConditionsTab = By.xpath("//a[text()='Terms and Conditions']");
	public By termsconditionsAdd = By.xpath("//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By termsconditionClause = By.xpath("//input[@placeholder='Clause']");
	public By termsconditionDetails_WithOptionalItemsAndQtyEditable = By.xpath("//textarea[@name='details']");

	public By termsconditionDetails = By.xpath("//input[@name='Details']");
	public By technical = By.xpath("//a[text()='Technical']");
	public By technicalAdd = By
			.xpath("//div[@id='tech_sourav']//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By technicalAdd_WithOptionalItemsAndQtyEditable = By
			.xpath("//div[@id='rh_techcompl']//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By technicalclause = By.xpath("//input[@id='rh_techcompl.clause.0']");
	public By BOQmandatoryTab = By.xpath("//a[text()='BOQ (Mandatory)']");
	public By addnonSORBOQMandatoryTab = By.xpath(
			"//a[@data-target='#myModalalRfqNonSorItem-ri_boq']//button[@data-original-title='Add NON SOR Item']");
	public By BOQMadatoryItemCode = By.xpath("//input[@id='ri_boq.item_code.0']");
	public By BOQMadatoryItemdescription = By.xpath("//input[@id='ri_boq.item_name.0']");
	public By submitbutton = By.xpath("//a/button[@data-original-title='Submit']");
	public By negotiationCommentBuyerRemarks = By.xpath("//textarea[@name='buyerRemarks']");
	public By technicaldetails = By.xpath("//input[@id='tech_sourav.Details.0']");
	public By boqSummary = By.xpath("//a[text()='BOQ Summary']");
	public By next = By.xpath("//a[text()='Next']");
	public By commercial_biddetails = By.xpath("//a[contains(@href,'qh_commercial_v1')]");
	public By boqSummaryItemCode = By.xpath("//input[@name='item_code']");
	public By boqSummaryItemDescription = By.xpath("//input[@name='item_name']");
	public By boqSummaryQuantity = By.xpath("//input[@name='item_qty']");
	public By boqSummaryUom = By.xpath("//select[@name='uom']");
	public By boqSummarySorRate = By.xpath("//input[@name='sor_rate']");
	public By boqSummaryMandatoryItem = By.xpath("//select[@name='mandatory_item']");
	public By Userdefined = By.xpath("//input[@id='appYes'][@value='U']");
	public By sectionWiseComments = By.xpath("//input[@value='Y'][@required='required']");
	// public By comments = By.xpath("//textarea[@class='form-control marg_tp15
	// ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
	public By sendForApproval = By.xpath("//button[contains(@ng-click,'sendForApproval(approvalObj.workflowType)')]");
	public By sendForApprovalEvaluation = By.xpath("//*[@id='appsYes']");
	public By physicalDocSubmissionEndDate = By.xpath("//input[@id='rfqdate.doc_sub_date.0']");
	public By previousTenderNo = By.xpath("//select[@ng-model='generalInfo.parentid']");
	public By preferredCountryofOrigin = By.xpath("//input[@name='Preferred_C_o_O']");
	public By projectBrief = By.xpath("//input[@name='Project_Brief']");
	public By instructionToTheSuppliers = By.xpath("//input[@name='Instruction_to_the_S']");
	public By technicalclause_tender2creationbydutta = By.xpath("//input[@id='tech_sourav.Clause.0']");
	public By BOQMadatoryItemCode_tender2creationbydutta = By.xpath("//input[@id='boq.item_code.0']");
	public By BOQMadatoryItemdescription_tender2creationbydutta = By.xpath("//input[@id='boq.item_name.0']");

	public By previewButton = By.xpath("//button[@data-original-title='Preview']");
	public By indentByPreviewComment = By.xpath("(//span[@class='comments'])[1]");
	public By previewAllTittle = By.xpath("//*[contains(text(),' Preview All')]");
	public By previewAllpage = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]");
	public By previewoteOpenTender = By.xpath("//label[contains(text(),'OTE-Open Tender')]");
	public By previewAllOkButton = By.xpath("//*[contains(text(),' Ok')]");
	public By itemdeleteokcorrigendum = By.xpath("//button[@data-bb-handler='confirm']");
	public By corrigendumSendForApprovalNotRequired = By
			.xpath("//input[@id='appNo'][@ng-model='approvalObj.workflowType']");
	public By sendForApprovalSubmit = By.xpath("//button[contains(text(),'Submit')]");
	public By SubmitSN_sendforapproval = By.xpath("//*[@id='cm']");
	
	public By sendForApprovalSubmit_CancelPO = By.xpath("(//button[@id='cm' and contains(text(),'Submit')])[1]");
	public By sendForApprovalSubmit_ReleasePO = By.xpath("(//button[@id='cm' and contains(text(),'Submit')])[1]");
	public By tenderReferenceNoLocator = By.xpath("//*[@id='staticBackdropLabel']/span/strong");
	public By tenderCreation = By.xpath("//span[text()='Tender Creation']");
	public By createNewRfq = By.xpath("//a[contains(string(),'Create New RFQ')]");
	public By tenderListSearch = By.xpath("//input[contains(@ng-model,'tenderFilter')]");
	public By tenderListStatus = By.xpath("//table[@id='myTablebyrTl00']/tbody/tr[1]/td[7]/span");
	public By notesheetNO = By.xpath("(//div[@class='lthpTitle']/div/div)[1]");
	// Vamshi
	// Send for Approval
	public By Add = By.xpath("(//button[@id='addApprovertc'])[2]");
	public By userselection = By.xpath("(//input[@list='approvaerList'])[2]");
	public By approvalType = By
			.xpath("//table[@id='approver']//tr[2]//select[@id='filterTest']/option[text()='SEQUENTIAL']");
	public By comments = By.xpath("//div[@id='menusndApprovl'][contains(@class,'active')]//following-sibling::div//textarea[@name='approvalComment']");
	public By poComments = By.xpath("//div[@role='presentation']/div[1]/p[1]");
	public By poCancelReason = By.xpath("//div[@role='presentation']/div[1]/p[1]");
	public By poCommentsforCancel = By.xpath("(//div[@role='presentation']/div[1]/p[1])[2]");
	// Approval Page Validation
	public By logoutOption = By.xpath("//a[@class='d-block text-decoration-none dropdown-toggle position-relative topUserImg']");
	public By logoutOptionOld = By.xpath("//div[@id='notificationModal']//following-sibling::li/a/span");
	public By logout = By.xpath("//button[@role='menuitem']//*[contains(text(),'Log')]");
	//public By logoutOld = By.xpath("//ul[contains(@class, 'dropdown-menu extended logout')]/li[6]");
	public By logoutOld = By.xpath("//ul[contains(@class, 'dropdown-menu extended logout')]//../a[contains(text(), ' Log Out')]");
	public By logoutConfirmation = By.xpath("//div[@id='staticBackdrop']/div/div[2]/div/div[2]/div/button[1]");
	public By logoutConfirmationOld = By.xpath("//div[@id='logoutConfirm']/div/div/div[3]/ button[1]");
	public By cancelIndentOrderTab = By.xpath("//*[@id='cancelPurchaseOrderTab']");
	public By organizationEmpanelment = By.xpath("//a[@href='#_6_DEPARTMENT_EMPANELMENT']");
	// Tender Approval Validation
	public By workFlow = By.xpath("//i[@class='fa fa-building-o notific']");
	public By pending = By.xpath("//span[contains(text(), 'Pending WF Approvals')]");
	public By completedTender = By.xpath("//*[@id='mat-button-toggle-3-button']");
	public By completed_List = By.xpath("//body/section[@id='main-content-nw']/section[1]/div[1]/div[1]/form[1]/div[1]/div[3]/select[1]");
	public By search = By.xpath("//input[@id='tenderFilter']");
	public By documentId = By.xpath("(//td[@class='ng-binding'])[2]");
	public By workFlowStatus = By.xpath("//table[@id='myTable']/tbody/tr/td[6]");
	public By details = By.xpath("//a[contains(text(),'Respond')]");
	public By detailsSN = By.xpath("//a[contains(text(),'Respond')]");  //need to update while testing CR
	public By sanctionTab = By.xpath("//span[contains(text(), 'Sanction') and contains(@class, 'tab-name')]");
	
	public By reverseBackToCreator = By.xpath("//button[contains(text(),'Reverse back to creator')]");
	public By reverseBackToCreator1 = By.xpath("//button[contains(text(),'Creator')]");
	public By reverseBackToNotesheetCreator = By.xpath("//button[contains(text(),'Notesheet Creator')]");
	public By BackToCreator = By.xpath("(//a[contains(text(), 'Review Back to Creator')])[2]");
	public By reverseBackToCreator(String buttonName) {

		return By.xpath("//button[contains(text(),'"+buttonName+"')]");
	}
	public By editDraftTender = By.xpath("//*[@class='dropdown-item']//*[@data-icon='edit']");
	public By poTab = By.xpath("//span[text()=' Order ']");
	public By CancelPOTab = By.xpath("//span[contains(text(),'Cancel Order')]");
	// Details page of Tender Approval Validation
	// public By approverComment_GeneralInfromation =
	// By.xpath("//a[contains(text(),'Details')]");
	public By dateScheduleTab = By.xpath("//a[text()='Date Schedule']");
	public By approverComment = By.xpath("//a[text()='Comment']");
	public By projectDetailsTemplate = By.xpath("//a[text()='Project Details']");
	public By termsAndConditionsTemplate = By.xpath("//a[text()='Terms and Conditions']");
	public By technicalTab = By.xpath("//a[text()='Technical']");
	public By boqMandatoryTab = By.xpath("//a[text()='BOQ (Mandatory)']");
	// tenderApproval_ProvidingComment
	public By commentBoqMandatory = By.xpath("//div[@id='boq']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_BoqMandatory = By
			.xpath("//button[contains(text(),'Save Tab Comment')][@id='saveComment6']");
	public By alertTab = By.xpath("//div[@class='bootbox-body']");
	public By alertTabOk = By.xpath("//button[@data-bb-handler='ok']");
	public By commentTechnical = By
			.xpath("//div[@id='tech_sourav']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_Technical = By
			.xpath("//div[@id='tech_sourav']//button[contains(text(),'Save Tab Comment')]");
	public By commentTermsAndConditions = By
			.xpath("//div[@id='tandc']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_TermsAndConditions = By
			.xpath("//div[@id='tandc']//button[contains(text(),'Save Tab Comment')]");
	public By commentProjectDetails = By
			.xpath("//div[@id='proj_details']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_ProjectDetails = By
			.xpath("//button[contains(text(),'Save Tab Comment')][@id='saveComment7']");
	public By commentDateSchedule = By
			.xpath("//div[@id='rfqdate']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_DateSchedule = By
			.xpath("//button[contains(text(),'Save Tab Comment')][@id='saveComment2']");
	public By generalInformationTab = By.xpath("//span[text()='General Information']");
	// public By approverComment = By.xpath("//strong[text()='Approver
	// Comment']");
	public By comment = By.xpath("//div[@id='collapse1']//textarea[@ng-model='approvalComment.approvalComment']");
	public By approve = By.xpath("//button[@id='savePayment1_0']");
	public By tenderListKeyword = By.xpath("(//input[@placeholder='Type any keyword'])[1]");
	public By acceptedorrejectedMSN = By.xpath("//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 yellowBtn redBtn']");
	
	//added by pavel 05-02-2024
	public By tenderListPage = By.xpath("/html/body/app-root/div/div/div/app-tender-listing/section/div/div[1]/input");
	public By tendersearchbox = By.xpath("//div[@class='row searchnmenu']/div[1]/div[1]/input[1]");
	public By rowclarificationorDiscussionList = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr");
	public By tenderCreatedStatus = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr[1]/td[8]");
	public By addBidders = By.xpath("//button[@type='button'][@ng-click='addVendor(generalInfo.tendertypeid)']");
	public By bidderCompany_TechMahindra = By.xpath("//table[@id='vendorLst']/tbody/tr[2]/td[1]");
	public By bidderCompany_TCS = By.xpath("//table[@id='vendorLst']/tbody/tr[3]/td[1]");
	public By bidderCompany_CTS = By.xpath("//table[@id='vendorLst']/tbody/tr[ td[2] and td/span[text()='CTS']]/td[1]");
	public By addBidderCompany = By.xpath("//button[@id='addVendor']");
	public By technicalclause_TenderTwoCreationByDutta = By.xpath("//input[@id='tech_sourav.Clause.0']");
	public By bidpreview = By.xpath("//a[contains(text(),'Bid Preview')]");
	public By approveCommentReview = By.xpath("//button[contains(text(),'Review')]");
	public By reverseBackToApprover = By.xpath("//button[text()=' Reverse back to approver']");
	public By minApprover1 = By.xpath("//table[@id='approver']/tbody/tr[1]/td[6]//input");
	public By minApprover2 = By.xpath("//table[@id='approver']/tbody/tr[2]/td[6]//input");
	public By coordinatorFlag = By.xpath("//table[@id='approver']/tbody/tr[1]/td[5]//input");
	public By cancelUser1 = By.xpath("//table[@id='approver']/tbody/tr[1]/td[7]/button[@ng-click='cancelUser(row)']");
	// public By cancelUser2 =
	// By.xpath("//table[@id='approver']/tbody/tr[2]/td[7]/button[@ng-click='cancelUser(row)']");
	public By userAdd = By.xpath("//button[@id='addApprovertc']");
	public By user1 = By.xpath("//table[@id='approver']/tbody/tr[1]/td[2]/input");
	public By SNuseradd = By.xpath("//input[@class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
	public By tenderApproverUser = By.xpath("//*[@id='approver']/tbody/tr//input[@class='ng-pristine ng-untouched ng-valid ng-empty']");
	public By evaluatorUser = By.xpath("//*[@id='approver']/tbody/tr//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']");
	public By POuseradd = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
	public By adduserSN = By.xpath("//th/a/fa-icon[@class='ng-fa-icon']");
	public By newAdduserSN = By.xpath("//*[@id='newAddApprovertc']");
	public By user2 = By.xpath("//table[@id='approver']/tbody/tr[2]/td[2]/input");
	public By approverType1 = By.xpath("//table[@id='approver']/tbody/tr[1]/td[3]/label/select[@id='filterTest']");
	public By approverType2 = By.xpath("//table[@id='approver']/tbody/tr[2]/td[3]/label/select[@id='filterTest']");
	public By approverNotesheet = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid' and @list='approvaerList']");
	// Arka

	public By addSorItemBy = By.xpath("//button[@data-original-title='Add SOR Item']");
	public By selectSorItemMaterialBy = By.xpath(
			"//*[@id='collapse1']//child::div[1]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[1]]");
	public By selectSorItemLocationBy = By.xpath(
			"//*[@id='collapse1']//child::div[2]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[2]]");
	public By selectSorItemMaterialWeightBy = By.xpath(
			"//*[@id='collapse1']//child::div[3]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[3]]");
	public By sorItemSearchBy = By.xpath("//button[@data-original-title='Search']");
	public By newBy = By.xpath("//table[@id='rfqpopupTAble']/tbody/tr/td[position()=1 or position ()=6]/child::*[1]");

	public By sorItemCodeCheckBoxBy = By.xpath("//table[@id='rfqpopupTAble']/tbody/tr/td/input[@type='checkbox']");
	public By sorItemQuantityBy = By.xpath("//table[@id='rfqpopupTAble']/tbody/tr/td/input[@ng-model='item.quantity']");
	public By sorItemSaveBy = By.xpath("//button[@id='saveRFQItemToTab']");
	public By noOfRecordsBy = By.xpath("//*[contains(text(),'More...')]/parent::div/child::span");
	public By mandotatoryItemSelectBoxBy = By.xpath("//select[@name='mandatory_item']");
	public By alertForCreateSNfromPO = By.xpath("//*[contains(text(), 'Do you want to proceed to item selection')]");
	public By confirmationOkBy = By.xpath("//button[text()='OK']");
	public By previewPopOkBy = By.xpath("//div[@id='myModalprev']//button[contains(text(),'Ok')]");
	public By tG_Supplier_Selection = By.xpath("//h2[contains(text(),'Template Group & Supplier Selection')]");
	public By addSORItem = By.xpath("//button[@data-original-title='Add SOR Item']");
	public By selectSORItemMaterialBy = By.xpath(
			"//*[@id='collapse1']//child::div[1]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[1]]");
	public By selectSORItemLocationBy = By.xpath(
			"//*[@id='collapse1']//child::div[2]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[2]]");
	public By selectSORItemMaterialWeightBy = By.xpath(
			"//*[@id='collapse1']//child::div[3]/select[@name='itemSelectBox'] [(//select[@name='itemSelectBox'])[3]]");
	public By addSORItemSearch = By.xpath("//button[@data-original-title='Search']");
	public By addSORItemCodeCheckBoxBy = By.xpath("//table[@id='rfqpopupTAble']/tbody/tr/td/input[@type='checkbox']");
	public By addSORItemQuantity = By
			.xpath("//table[@id='rfqpopupTAble']/tbody/tr/td/input[@ng-model='item.quantity'] ");
	public By addSORItemSave = By.xpath("//button[@id='saveRFQItemToTab']");
	public By action = By.xpath("//*[@id='menu1']");
	public By action_bid_list = By.xpath("//*[@id='nav-live']/div/table/tbody/tr/td[7]/div/button");
	public By action_New = By.xpath("//tbody/tr[1]/td[8]/div[1]/div[2]/button[1]");
	public By actionSanction = By.xpath("//*[@id='_ctd_sn_pending']/div/table/tbody/tr/td[7]/div/button");
	public By tenderlistingPageAction = By.xpath("//button[@class='dropdown-toggle customToggle']");
	public By viewTender = By.xpath("//*[contains(text(),' View Tender')]");
	public By issueLOA = By.xpath("//*[contains(text(),'Issue LOA')]");
	public By loa_ReferenceNo = By.xpath("//*[@id='loa_info.reference_no']");
	public By loa_subject = By.xpath("//*[@id='loa_info.subject']");
	public By loa_comment = By.xpath("//*[@id='rtfEditor']/div[2]/div[2]/div");
	public By loa_attachment = By.xpath("//*[@data-icon='plus']");
	public By buyerSideTenderPreview = By.xpath("//*[contains(text(),'Buyer side Tender Preview')]");
	public By consolidatedview = By.xpath("//*[@class='mdc-switch__icons']");
	public By bomservice1stItem = By.xpath("//*[@id='collapse11']/app-n-col-preview/div/div/table/tbody/tr[1]/td/div/div[1]/div[2]");
	public By genInfoPage = By.xpath("//*[@id='collapsetendergeninfo']/div/div");
	public By action_SubmittedBid = By.xpath("//div[@class='dropdown action_sec row-1-0']//button[@id='menu1']");
	public By corrigendumLink = By.xpath("//a[contains(text(),'Corrigendum')]");
	public By recallTender = By.xpath("//a[contains(text(),'Recall')]");
	public By cancelTender = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr[1]/td[10]/div/ul/li[4]");
	public By NotesheetAction = By.xpath("//*[@id='nav-my-indent']/div/table/tbody/tr/td[8]/div/button");
	public By corrigendumReferenceNumber = By.xpath("//input[@name='corrRefNo']");
	public By corrigendumDescription = By.xpath("//textarea[@name='corrDesc']");
	public By corrigendumSelect = By.xpath("//mat-select[@name= 'templategroupids']");
	public By corrigendumSelect_RFQItem = By.xpath("//span[text()='RFQ Item']");
	public By corrigendumSelect_Technical = By.xpath("//span[text()='Technical']");
	public By corrigendumSelect_Attachment = By.xpath("//span[text()='Attachments']");
	public By corrigendumSelect_DateSchedule = By.xpath("//span[text()='Date Schedule']");
	public By corrigendumSelect(String tem) { return By.xpath("//span[contains(text(), '"+tem+"')]");}
	public By corrigendumXButton = By.xpath("//button[contains(@data-original-title,'Close')]");
	public By corrigendumDiscardButton = By.xpath("//button[contains(@data-original-title,'Discard')]");
	public By corrigendumAlertTabOk = By.xpath("//button[@data-bb-handler='confirm']");
	public By userSelectionDropdown2 = By.xpath("(//table[@id='approver']/tbody/tr[2]/td[2]");
	public By noApproverAdded = By.xpath("//table[@id='approver']/tfoot/tr/td/strong");
	public By closeSelection = By.xpath("//button[@ng-click='cancelUser(row)']");
	public By corrigendumTab = By.xpath("//span[contains(text(),'Corrigendum')]");
	public By dateScheduleComment = By.xpath("//textarea[@ng-model='template.tabWiseApproverComment']");
	//public By corrigendumStatus = By.xpath("//table[@id='myTablebyrTl00']//td[@ng-if=\"(tender.isCorrigendum.toLowerCase()=='yes')\"]//a[contains(text(), 'Yes')]");
	public By corrigendumStatus = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr[1]/td[6]/a");
	public By corrigendumStatusNo = By.xpath("//table[@id='myTablebyrTl00']/tbody/tr[1]/td[6]");
	public By corrigendumCoparison = By.xpath("//*[@tooltip='View Comparison']");
	public By corrigendumNumber = By.xpath("//a[@class='textDecorator']");
	public By corrigendumHistory = By.xpath("//*[@id='staticBackdropLabel']");
	public By gridView = By.xpath("//*[@tooltip='Grid View']/button");
	public By listView = By.xpath("//*[@tooltip='List View']/button");
	public By corrigendumNumberClose = By.xpath("//*[@id='mat-dialog-15']/app-corrigendum-history-details-modal/div/mat-dialog-actions/div/button");
	public By corrigendumNewDateSchedule = By.xpath("//*[contains(text(),'New Date Schedule')]");
	public By corrigendumOldDateSchedule = By.xpath("//*[contains(text(),'Old Date Schedule')]");
	public By corrigendumHistoryApprovalSection = By.xpath(
			"//table[@class='table table-striped table-advance table-bordered']/tbody/tr/th[text()='Approval Section']");
	public By corrigendumHistoryTenderNo = By
			.xpath("//table[@class='table table-advance borderless']/tbody/tr[1]/td[4]");
	public By corrigendumHistoryCorrigendumNumber = By
			.xpath("//table[@class='table table-advance borderless']/tbody/tr[1]/td[2]");

	//added for static test script(21/12/2020)
	public By Userdefined_tender = By.xpath("//input[@id='appYes']//../span[@class='checkmark']");
	public By Userdefined_tender_old = By.xpath("(//*[@id='appYes'])[3]");
	public By sectionWiseComments_tender = By.xpath("//div[@id='tenderApprovalModal']//div[contains(@class,'row midSecpop')]//input[@id='secCmntYes' and @value = 'Y']");
	public By cancelUser1_tender = By.xpath("//*[@id='approver']/tbody//*[@class='tblCirBtnSm tblCross blu ng-star-inserted']");
	public By userAdd_tender = By.xpath("//a[@class='tblCirBtnSm blu']");
	public By user1_tender = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
	public By user2_tender = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
	public By approverType1_p_tender = By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-invalid']");
	public By approverType3 = By.xpath("//table[@id='approver']/tbody[1]/ tr[1]/td[5]/div[1]/select");
	public By approverType2_p_tender = By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-invalid']");
	public By comments_tender = By.xpath("//div[@role='textbox']/p");
	public By selectTenderStatus = By.xpath("//*[@id='tenderStatus']");
	public By attachmentCanceltender = By.xpath("//*[@id='cancelIndentAttachfile']");
	public By attachmentClarification = By.xpath("//input[@type='file']");
	public By sendForApproval_tender = By.xpath("//span[@class='ng-star-inserted' and text()='Send For Approval']");
	public By ActionButton_approver_tender = By.xpath("//tbody/tr[1]/td[4]/div[1]/button[1]");
	public By actionButtonotesheet = By.xpath("//*[@id='nav-my-indent']/div/table/tbody/tr/td[8]/div/button");
	public By reinitiated = By.xpath("//a[contains(text(),' Reinitiate ')]");
	public By Approvercomment_tender = By.xpath("//*[@id='floatingTextarea']//p");
	public By Approvebutton_tender = By.xpath("//button[normalize-space()='Approve'] | //button[normalize-space()='Send']");
	public By Tenderlink_approver_tender = By.xpath("//div/span[normalize-space()='Tender']");
	public By CancelTenderlink_approver_tender = By.xpath("//span[normalize-space()='Cancel Tender']");
	public By tender_corrigendum_Tab = By.xpath("//span[normalize-space()='Corrigendum']");
	public By new_action_button = By.xpath("//button[@class='dropdown-toggle customToggle']");
	public By viewSN = By.xpath("//ul[@class='dropdown-menu list-inline customActionDrop show']/li//a[normalize-space()='View']");
	public By ApprovalStatusEvaluation = By.xpath("//select[@ng-model='searchApprovalStatus']");
	public By TenderOpeninglink_approver_tender = By.xpath("//*[normalize-space()='Tender Opening']");
	public By CloseWF_tender = By.xpath("//button[normalize-space()='Close Workflow']");
	public By EndWF_tender = By.xpath("//button[normalize-space()='End Workflow']");
	public By Conf_YesbuttonWF_tender = By.xpath("//button[@class='btn btn-primary'][normalize-space()='Yes']");
	public By Conf_YesbuttonWF_tenderNew = By.xpath("//div[@id='AnnotateExtensionToastDiv']//following-sibling::div[contains(@class,'bootbox modal fade in')]//div[contains(@class, 'modal-footer')]/button[2]");
	public By Reviewbutton_tender = By.xpath("//button[normalize-space()='Review']");
	public By Conf_Ok_button = By.xpath("//button[normalize-space()='OK']");
	public By AlertYesbtn_Corrigendum = By.xpath("//button[normalize-space()='Yes']//i[@class='fa fa-check']");
	public By BidNo_bidsubmission = By.xpath("(//tr[contains(@ng-repeat,'bid in submittedBidList')]/td[5])[1]");
	public By BidNo_Draftbid_bidsubmission = By.xpath("//tr[contains(@ng-repeat,\"bid in draftBidList\")]/td[5]");
	public By BidNo_Withdrawbid_bidsubmission = By.xpath("//tr[contains(@ng-repeat,\"bid in withdrawBidList\")]/td[4]");
	public By Geninfotab_bidsubmission = By.xpath("//a[@id='quot_gen_info']");
	public By Quot_ref_code_afterRebidPreview = By.xpath("(//label[contains(text(),'EditedQuotRefCode')])[1]");
	public By Livetab_bidsubmission = By.xpath("//a[@id = 'liveTab']");
	public By Alertmsg_bidsubmission = By.xpath("//div[@class='bootbox-body']");
	public By Alertmsg_OK_btn_bidsubmission = By.xpath("//button[normalize-space()='OK']");
	public By selectStatusMSN = By.xpath("//select[@ng-model='filter.status']");
	public By ApproverSelectYES_Evaluation = By.xpath("(//label[text()='Yes ']/span)[2]");
	public By Workflowtype_Evaluation = By.xpath("//input[@id='appYes' and @value='U']");
	public By Workflowtype_Userdefined = By.xpath("//label[text()='User defined ']/span");
	public By Workflowtype_Userdefined4EvaluationIfOpeningworkflowSelected = By.xpath("(//label[text()='User defined ']/span)[2]");
	public By Comment4EvaluationIfOpeningworkflowSelected = By.xpath("(//textarea[@id='floatingInputGrid'])[2]");
	public By Comment4Evaluation= By.xpath("//textarea[@id='floatingInputGrid']");
	public By approveNegotiationAlert= By.xpath("//p[contains(text(),'Once confirmed,Suppliers who are selected as manda')]");
	public By AddApprover_Evaluation = By.xpath("//button[@id = 'addApprovertc']");
	public By AddApprover_Button = By.xpath("//a[@title='Add']/fa-icon");
	public By AddApprover_Button_evaluation_if_opening_workflowIsSelected = By.xpath("(//a[@title='Add']/fa-icon)[2]");
	public By OpeningUser1_Evaluation = By.xpath("//table[@id='approver']/tbody/tr[1]/td[2]/input");
	public By User1_EvaluationIfOpeningWFisSelected = By.xpath("(//table[@id='approver']/tbody/tr[1]/td[2]/input)[2]");
	public By activityOrProcess = By.xpath("(//*[@id='approver']/tbody/tr/td[3]/div/select)[2]");
	public By ApproverRole = By.xpath("//*[@id='approver']/tbody/tr/td[4]/div/select");
	
	
	public By OpeningApprovalType1_Evaluation = By.xpath("//tr[contains(@ng-repeat,'row in global.evaluationSettings.approval.approvalDetails  track by $index')]//select[@id='filterTest']");
	public By OpeningApprovalType = By.xpath("//tr[@class='ng-star-inserted']/td[3]/div/select");
	public By EvluationApprovalTypeIfOpeningWFselected = By.xpath("(//tr[@class='ng-star-inserted']/td[3]/div/select)[2]");
	public By approvalTypeBidEvaluation = By.xpath("//*[@id='approver']/tbody/tr/td[5]/div/select");
	public By Partnership_Applicable_STG  = By.xpath("//input[@name='optradio1' and @value='N']");
	//public By OpeningApprovalWFType_Evaluation = By.xpath("//td[normalize-space()='Pending for opening Approval (Cover 1)']");
	public By OpeningApprovalWFType_Evaluation(String coverNo) {
		return By.xpath("//td[normalize-space()='Pending for opening Approval ("+coverNo+")']");
	}
	//public By ScheduleOpening_Evaluation = By.xpath("//div[contains(@ng-model,'scheduleOpenDateField')]//input[@class='form-control']");
	public By ScheduleOpening_Evaluation = By.xpath("//input[@id='mat-input-0']");
	public By OpeningApprovalWFStatus_Evaluation = By.xpath("//td[normalize-space()='WIP']");
	public By OpeningApprovalComment_Evaluation = By.xpath("//label[text()='Approver Comment']//following-sibling::textarea");
	public By OpeningApprovalAlert_Evaluation = By.xpath("//div[@class='bootbox-body']");
	public By OpeningApprovalAlertConfirmbtn_Evaluation = By.xpath("//button[normalize-space()='Confirm']");
	public By OpeningApprovalDetailsbtn_Evaluation = By.xpath("//div[@id='tenderOpening']//a[contains(text(),'Details')]");
	public By BidEvaluationtab_Evaluation = By.xpath("//button[@id='nav-bidEvaluation-tab']"); 
	public By WorkflowtypeEvalapp_Evaluation = By.xpath("//div[@id='menu1Bid']//input[@id='appYes' and @value='U']");
	public By AddApproverEvalapp_Evaluation = By.xpath("//div[@id='menu1Bid']//button[@id = 'addApprovertc']");
	public By EvalUser1_Evaluation = By.xpath("//div[@id='menu1Bid']//table[@id='approver']/tbody/tr[1]/td[2]/input");
	public By EvalApprovalType1_Evaluation = By.xpath("//div[@id='menu1Bid']//select[@id='filterTest']");
	public By EvalcommentSection_Evaluation = By.xpath("//div[@id='menu1Bid']//label[contains(text(),'Comments')]/following::textarea");
	public By OpeningcommentSection_Evaluation = By.xpath("//div[@id='homeBid']//label[contains(text(),'Comments')]/following::textarea[contains(@ng-model,'openingcomment')]");
	public By TenEvalTab_Evaluation = By.xpath("//*[normalize-space()='Tender Evaluation']");
	public By IndentListTab = By.xpath("//div/span[normalize-space()='Indent']");
	public By submitbutton_EvalUser = By.xpath("//button[@data-original-title='Submit']");
	public By Alert_Nobtn_EvalUser = By.xpath("//button[@data-bb-handler='no']");
	public By Alert_Yesbtn_EvalUser = By.xpath("//button[@data-bb-handler='yes']");
	public By LblBidDetails_Evaluation = By.xpath("//h3[normalize-space()='Bid Details']");
	public By LblBiddername_Evaluation = By.xpath("//input[@id='allCheckID']/parent::th//following-sibling::th[1]");
	public By LblSuppliername_Evaluation = By.xpath("(//th[contains(text(),'Supplier Name')])[1]");
	public String NegotiatedStatus_Negotiation = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td//*[normalize-space(text())='Negotiated']";
	public By Negotiation_detail = By.xpath("//h3[normalize-space()='Negotiation Detail']");
	
	// p
	public By approverType1_p = By.xpath("//select[@id='filterTest']");
	public By activity_process_MSN1 = By.xpath("//*[@id='approver']/tbody/tr/td[3]/label/select");
	public By role_MSN1 = By.xpath("//*[@id='approver']/tbody/tr/td[4]/label/select");
	public By activity_process_MSN2 = By.xpath("//*[@id='approver']/tbody/tr[2]/td[3]/label/select");
	public By role_MSN2 = By.xpath("//*[@id='approver']/tbody/tr[2]/td[4]/label/select");
	// public By approverType2_p =
	// By.xpath("//table[@id='approver']//tr[2]//td[3]//select[@id='filterTest']");
	public By previewAllOkButton_p = By.xpath("//div[@class='modal-footer']//button[text()='Ok']");
	public By close_history = By
			.xpath("(//div[@class='modal-footer']//button[@id='btn-prev']//following-sibling::button)[1]");
	public By corrigendumStatus_No = By.xpath("//table[@id='myTablebyrTl00']/tbody/tr[1]/td[6]");
	public By corrigendumNewboqMandatory = By.xpath("//div[contains(text(),'new BOQ (Mandatory)')]");
	public By corrigendumOldboqMandatory = By.xpath("//div[contains(text(),'old BOQ (Mandatory)')]");
	public By BOQMadatoryItemCode2_tender2creationbydutta = By.xpath("//input[@id='boq.item_code.1']");
	public By BOQMadatoryItemdescription2_tender2creationbydutta = By.xpath("//input[@id='boq.item_name.1']");
	public By corrigendumSelect_NonSORItem = By.xpath("//span[text()='BOQ (Mandatory)']");
	public By corrigendumSelectAttachments = By.xpath("//span[text()='Attachments']");
	public By corrigendumNewAttachments = By.xpath("//div[contains(text(),'new Attachments')]");
	public By corrigendumOldAttachments = By.xpath("//div[contains(text(),'old Attachments')]");
	public By boqProjectQuantityBy = By.xpath(
			"//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[position()=6]//input[@placeholder='Project Quantity']");

	public By boqpreferedMakeBy = By.xpath(
			"//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[position()=8]//input[@placeholder='Prefered Make']");

	public By boqBudgetrateBy = By.xpath(
			"//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[position()=9]//input[@placeholder='Budgeted Rate']");

	public By boqRemarksBy = By.xpath(
			"//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[position()=11]//textarea[@placeholder='Remarks']");

	public By boqTableActionmenuBy = By.xpath("//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[13]");
	public By childNonSORItemfirstBy = By.xpath(
			"//div[@id='rfqItemtabl2-ri_boq']/table/tbody/tr[1]/td[position()=13]//li/a[contains(@ng-click,'addChildNonSORItem')]");
	public By mandatoryitemBy = By.xpath("//*[@id=\"ri_boq.mandatory_item.0\"]");
	public By projectQtysItemsBy = By.xpath("//*[@name='projectquantity']");
	public By boqUimBy = By.xpath("//div/table/tbody/tr[2]/td[position()=4]//following::select[@name='uom']");
	public By mandatoryitem1By = By.xpath("//*[@id='ri_boq.mandatory_item.1']");
	public By checkBoxTechMahindraBy = By
			.xpath("//table[@id='vendorLst']/tbody/tr[ td[2] and td/span[text()='Tech Mahindra']]/td[1]");
	public By checkBoxTcsBy = By.xpath("//table[@id='vendorLst']/tbody/tr[ td[2] and td/span[text()='TCS']]/td[1]");

	public By tenderListStatus_Draft = By.xpath("//span[text()='Draft  ']");
	public By coordinatorFlag2 = By.xpath("//table[@id='approver']/tbody/tr[2]/td[5]//input");
	public By label1 = By.xpath("(//input[@placeholder='Label'])[1]");
	public By closeButton = By.xpath("//div[@class='text-center mb-4']/button");
	public By bidSubmissionTransaction = By.xpath("//i[@class='fa fa-users']");
	public By bidSubmissionTenderListing = By.xpath("//a[contains(text(),'Tender Listing')]");
	public By bidsubmissionSearchByKeyword = By.xpath("//form[contains(@class,'form-horizontal')]//div[@class='row']//input[@placeholder='Search By Keywords']");
	public By corrigendumClose = By.xpath("//*[@class='modal-footer']/div/button");
	public By corrigendumNumberCloseButton = By.xpath("//button[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0' and text()='Close' ]");
	public By bidSubmission_Bid = By.xpath("//*[@id='openModalButton' and contains(text(),'Bid')]");
	
	//added on 190124
	public By draftBid = By.xpath("//a[@id='draftBid']");
	public By submitFromDraftBid = By.xpath("(//button[contains(text(),'Edit')])[1]");
	public By lastSubmittedBid = By.xpath("//a[@id='LastSubmittedBid']");
	public By revisebidSubmission = By.xpath("//button[contains(text(),'Revise Bid')]");
	public By freshBid = By.xpath("//a[@id='freshBid']");
	public By freshBidsubmissionOnceanotherbidIsSubmittedOrInDraft = By.xpath("//button[contains(text(),'Go')]");
	
	
	public By acceptOrDeclineTitle = By
			.xpath("//h3[@class='page-header box_shadow' and contains(text(),' Accept Or Decline')]");
	public By newTermsAndServices_CheckBox = By.xpath("//input[contains(@ng-model,'tenderRes.interestFlag')]");
	public By newTermsAndServices_Accept = By
			.xpath("//button[contains(text(),'Accept')]");
	public By tenderId_generalInformation_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Tender ID')]");
	public By tenderDescription_generalInformation_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Tender Description')]");
	public By tenderCategory_generalInformation_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Tender Category')]");
	public By quotationReferenceCode_generalInformation_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Quotation Reference Code')]");
	public By quotationCurrency_generalInformation_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Quotation Currency')]");
	public By quotationReferenceCodeInput_generalInformation_bidSubmission = By
			.xpath("//input[@id='quot_gen_info.quote_ref_no.0' or placeholder='Quotation Reference Code' ]");
	public By alertPopUp_QRC_bidSubmission = By.xpath("//h2[@class='modal-title' and contains(text(),'Alert')]");
	public By errorMessage_QRC_bidSubmission = By
			.xpath("//h3[@class='ng-binding' and contains(text(),'Errors in General Information')]");
	//public By alertClose_QRC_bidSubmission = By.xpath("//body/section[@id='container']/section[@id='main-content-nw']/div[@id='alertMessageModal']/div[1]/div[1]/div[3]/button[2]");
	public By alertClose_QRC_bidSubmission = By.xpath("//body/section[@id='container']/section[@id='main-content-nw']/div[@id='alertMessageModal']/div[1]/div[1]/div[3]/button[1]");
	
	// mandatory field validation
	public By technicalAlertTab_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Technical Tab was saved successfully!')]");
	public By termsAndCondition_bidSubmission = By.xpath("//a[@id='qh_termsnconditons']");
	public By termsAndConditionAlertTab_bidSubmission = By.xpath(
			"//strong[@class='ng-binding' and contains(text(),'Terms and Conditions Tab was saved successfully!')]");

	public By attachmentsAlertTab_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Attachments Tab was saved successfully!')]");

	public By commercial_bidSubmission = By.xpath("//a[@id='qh_commercial_v1']");
	public By commercialAlertTab_bidSubmission = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'Commercial Tab was saved successfully!')]");

	public By quotationSummary_bidSubmission = By.xpath("//a[@id='uvoltasdemoqi']");
	public By quotationSummaryAlertTab_bidSubmission = By.xpath(
			"//strong[@class='ng-binding' and contains(text(),'Quotation Summary Tab was saved successfully!')]");

	public By technical_priviewAll = By.xpath("(//table//tr//following::h2[contains(text(),'Technical')])[1]");
	public By termsAndCondition_priviewAll = By
			.xpath("(//table//tr//following::h2[contains(text(),'Terms and Conditions')])[1]");
	public By generalInformation_priviewAll = By
			.xpath("(//table//tr//following::h2[contains(text(),'General Information')])[1]");
	public By quotationAttachments_priviewAll = By
			.xpath("//table//tr//following::h2[contains(text(),'Quotation Attachment')]");
	public By bidderSpecificAttachments_priviewAll = By
			.xpath("(//table//tr//following::h2[contains(text(),'Bidder Specific Attachment')])[1]");
	public By commercial_priviewAll = By.xpath("(//table//tr//following::h2[contains(text(),'Commercial')])[1]");
	public By quotationSummary_priviewAll = By
			.xpath("(//table//tr//following::h2[contains(text(),'Quotation Summary')])[1]");
	public By submitbid = By.xpath("//button[@id='btn-prev_bidsb' and contains(text(),'Submit Bid')]");
	public By bidSuccessfulMessage = By.xpath("//strong[text()='Your bid has been submitted successfully']");
	public By bidSuccessfulMessage_Ok = By.xpath("//button[@class='btn btn-primary closeBtn']");
	public By bidListing = By.xpath("//a[contains(text(),'Bid Listing')]");
	public By draftBidTab = By.xpath("//a[contains(text(), 'Draft Bid')]");
	public By submittedBidTab = By.xpath("//a[contains(text(), 'Submitted Bid')]");
	public By negotiationBidTab = By.xpath("//a[text()='Negotiation']");
	public By withdrawBidTab = By.xpath("//a[contains(text(), 'Withdrawn Bid')]");
	public By submittedOn_bidList = By.xpath("//table[@id='myTable']//tbody//tr[1]//td[8]");
	public By tenderPreview = By.xpath("//a[@ng-click='previewTender(bid.tenderId)']");
	public By bidPreviewbtn(String tenderNo) { return By.xpath("//div[@id='SubmittedBid']//td[text()='"+tenderNo+"']/following-sibling::td[10]/div[1]/ul[1]/li[2]/a[contains(text(), 'Bid Preview')]"); }
	public By attachmenttabbidderpreview = By.xpath("//a[@data-toggle='tab' and contains(text(),'Attachments')]");
	public By attachmentpreview = By.xpath("(//div[@class='mat-tab-label-content'])[5]");
	public By bidPreview = By.xpath("(//a[@class='dlt_tr'])[2]");
	public By boq_mandetory_bidpreviewTab = By.xpath("//a[@data-toggle='tab' and contains(text(),'BOQ (Mandatory)')]");
	// tenderpreview
	public By generalInformation_tenderPreview = By.xpath("//div[text()='General Information']");
	public By otherAttachments_tenderPreview = By.xpath("//div[text()='Other Attachments']");
	public By attachments_tenderPreview = By.xpath("//div[text()='Attachments']");
	public By dateSchedule_tenderPreview = By.xpath("//div[text()='Date Schedule']");
	public By termsAndConditions_tenderPreview = By.xpath("//div[text()='Terms and Conditions']");
	public By technical_tenderPreview = By.xpath("//div[text()='Technical']");
	public By boqSummary_tenderPreview = By.xpath("//div[text()='BOQ Summary']");
	public By previewAll_close = By.xpath("(//button[@class='btn btn-primary succes_msgsnd' and text()='Close'])[1]");
	public By bidderPreviewClose = By.xpath("//button[@class='btn btn-default ng-scope' and text()='Close' ]");
	public By closetenderpreview = By.xpath("//button[@class='btn modalBtnBlue' and text()='Close']");
	public By closemaildetails= By.xpath("//*[@id='viewMailDetails']/div/div/div[3]/button");
	public By upload = By.xpath("//input[@filename-model='row']");
	public By withdraw_bidlist = By.xpath("//a[@data-bs-target='#myModalview']");
	public By acceptOrDecline_withdraw = By.xpath("//h3[text()='Accept Or Decline']");
	public By popUpMessage_withdraw = By.xpath("//p[text()=' Your bid will be withdrawn from the tender ']");
	public By newTermsAndServices_CheckBox_withdraw = By
			.xpath("//input[contains(@ng-model,'withdrawBidRes.acceptFlag')]");
	public By newTermsAndServices_Accept_withdraw = By
			.xpath("(//button[@class='btn btn-icon btn-primary' and contains(text(),'Accept')])[1]");
	public By confirmation_withdraw_bidlist = By.xpath("//h4[text()='Are you sure you want to withdraw the Bid']");
	public By ok_confirmation_withdraw_bidlist = By.xpath("//button[@ng-click='withdrawQuotation()']");
	public By successPopUp_withdraw_bidlist = By.xpath("//div[@class='bootbox-body']");
	public By successPopUpOk_withdraw_bidlist = By.xpath("//button[@data-bb-handler='ok']");
	public By tenderNo_withdrawnOn = By.xpath("//tr[contains(@ng-repeat,'bid in withdrawBidList')]//td[1]");

	public By selectSORItemMaterialBy2(int i) {
		return By.xpath("((//div[@id='rfqpoptab1'])[2]//select[1])[" + i + "]");
	}

	public By addSORItemSearch2 = By.xpath("(//button[@data-original-title='Search'])[2]");
	public By previewoteLimitedTender = By.xpath("//label[contains(text(),'Limited Tender')]");
	public By otherAttachmentsTab = By.xpath("//a[text()='Other Attachments']");
	public By attachmentsTab = By.xpath("//a[text()='Attachments']");
	public By boqSummaryTab = By.xpath("//a[text()='BOQ Summary']");
	public By boqSummaryTabComment = By
			.xpath("//div[@id='uvoltasdemori']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By commentAttachments = By
			.xpath("//div[@id='rfqattachment']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_Attachments = By
			.xpath("//button[contains(text(),'Save Tab Comment')][@id='saveComment4']");
	public By saveTabComment_OtherAttachments = By
			.xpath("//button[contains(text(),'Save Tab Comment')][@id='saveComment5']");
	public By commentTechnical1 = By
			.xpath("//div[@id='rh_techcompl']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_Technical1 = By
			.xpath("//div[@id='rh_techcompl']//button[contains(text(),'Save Tab Comment')]");
	public By commentTermsAndConditions1 = By
			.xpath("//div[@id='rh_termsnconditions']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By saveTabComment_TermsAndConditions1 = By
			.xpath("//div[@id='rh_termsnconditions']//button[contains(text(),'Save Tab Comment')]");
	public By dateScheduleTemplate = By.xpath("//a[text()='Date Schedule']");
	public By commentOtherAttachments = By
			.xpath("//div[@id='requiredbidderattachment']//textarea[@ng-model='template.tabWiseApproverComment']");
	public By corrigendumSelect_NonSORItemSummary = By.xpath("//span[text()='BOQ Summary']");
	public By BOQSummaryItemCode2_tender2creationbydutta = By.xpath("//input[@id='uvoltasdemori.item_code.1']");
	public By BOQSummaryItemdescription2_tender2creationbydutta = By.xpath("//input[@id='uvoltasdemori.item_name.1']");
	public By boqSummaryQuantity2 = By.xpath("//input[@id='uvoltasdemori.item_qty.1']");
	public By corrigendumNewboqSummary = By.xpath("//div[contains(text(),'new BOQ Summary')]");
	public By corrigendumOldboqSummary = By.xpath("//div[contains(text(),'old BOQ Summary')]");
	public By sendForApprovalNotRequired_corrigendum = By
			.xpath("//form[contains(@class,'ng-valid')]//input[@id='appNo']/parent::label");
	public By tenderListStatus_Published = By.xpath("//span[text()='Published  ']");
	public By boqSummarySorRate2 = By.xpath("//input[@id='uvoltasdemori.sor_rate.1']");
	public By itemNamesInItemMenutableBy = By
			.xpath("//table/tbody[@id='rfqItemtabl-uvoltasdemori itmtbl-custom']/tr/td[3]/span/child::span");
	public By addOptionalBy = By.xpath(" //button[@data-target='#addOptionalItemModal_uvoltasdemoqi']");
	public By addOptionalPopUpBy = By
			.xpath("//div[@id='addOptionalItemModal_uvoltasdemoqi']//child::*[text()=' Add Optional Item']");
	public By allOptionalItemsCheckedBy = By
			.xpath("//table/thead/tr/th/input[@type='checkbox' and contains(@ng-model ,'allOptionalItemsChecked')]");
	public By allOptionalItemsOkBy = By
			.xpath("//button[@ng-click='calculateVisibleItems()' and contains(text(),'OK')]");
	public By reBid_Old = By.xpath("(//a[@class='dlt_tr'])[3]");
	public By reBid = By.xpath("//a[contains(text(), 'ReBid')]");
	public By tenderNo_draftBid = By.xpath("//tr[contains(@ng-repeat,'bid in draftBidList')]//td[1]");
	public By editBid = By.xpath("(//a[@class='dlt_tr'])[3]");
	public By previewAllBy = By.xpath("//div[@id='myModalprev']//following::h3[contains(text(),'Preview All')]");

	public By SendforApprovalTextBy = By
			.xpath("//div[@id='tenderApprovalModal']//following::h3[contains(text(),'Send For Approval')]");
	public By SendforApprovalTextBy_SN = By
			.xpath("//h3[contains(text(),'Send For Approval')]");
	
	public By actionMenuDropDownBy = By
			.xpath("//button[@class='btn btn-primary dropdown-toggle' and @data-btn-row='BidPart1']");
	public By actionMenuDropDownBy_PO = By
			.xpath("//button[@class='btn btn-primary dropdown-toggle' and @id='menu1']");

	public By bidpublishStage = By.xpath("//button[@id='bidPublish']");

	public By showingRecordsBy = By.xpath("//div[@id='myTender']/div");
	public By excludingVATFieldBy = By.xpath("//input[@id='qi_boqoptional.basicunit.0']");

	public By boqOptionalAlertTab_BidSubmissionBy = By
			.xpath("//strong[@class='ng-binding' and contains(text(),'BOQ (Optional) Tab was saved successfully!')]");

	public By boqaddOptionItemButtonBy = By.xpath("//button[@data-target='#addOptionalItemModal_qi_boq']");

	public By boqaddOptionItemPopupBy = By
			.xpath("//div[@id='addOptionalItemModal_qi_boq']//child::*[text()=' Add Optional Item']");

	public By boqallOptionalItemsCheckedBy = By.xpath(
			"//div[@id='addOptionalItemModal_qi_boq']//table/thead/tr/th/input[@type='checkbox' and contains(@ng-model ,'allOptionalItemsChecked')]");

	public By boqallOptionalItemsPopOkBy = By.xpath(
			"//div[@id='addOptionalItemModal_qi_boq']//button[@ng-click='calculateVisibleItems()' and contains(text(),'OK')]");

	public By boqproposedMakeBy = By.xpath("//*[starts-with(@class,'form-control qi_boq.proposed_make')]");

	public By boqBasicUnitVatBy = By.xpath("//*[starts-with(@class,'form-control qi_boq.basicunit')]");

	public By boqShowrecordsBy = By
			.xpath("//form[@name='forms.form_qi_boq']//*[contains(text(),'More...')]/parent::div/child::span");

	public By boqoptionalpreviewAllpageBy = By.xpath(
			"(//*[@id='myModalprev_bid']//following::div//table//tr/th/h2[contains(text(),'BOQ (Optional)')])[1]");

	public By boqMandatorypreviewAllpageBy = By.xpath(
			"(//*[@id='myModalprev_bid']//following::div//table//tr/th/h2[contains(text(),'BOQ (Mandatory)')])[1]");

	public By TenderPreviewBoQOptionalBy = By
			.xpath("//*[@id='myModalprev']//following::div/child::div[contains(text(),'BOQ (Optional)')]");
	public By myTenderTab = By.xpath("//*[@id='nav-my-tender-tab']");
	public By TenderPreviewBidBoQmandatoryBy = By
			.xpath("//*[@id='myModalprev']//following::div/child::div[contains(text(),'BOQ (Mandatory)')]");
	public By savebutton1 = By.xpath("//button[@id='bidsave']");
	public By alertPopUp_QRC_bidSubmission1 = By.xpath("//h2[text()='Alert']");
	public By technicalAlertTab_bidSubmission2 = By.xpath("//strong[text()='Technical Tab was saved successfully!']");

	public By selectTenderTypeBy = By.xpath("//select[@ng-model='tenderF.typeId']");

	public By totalSubmittedBidsBy = By.xpath("//li[starts-with(@ng-click,'totalSubmitBidClick')]/a");

	public By bidDetailsPopUpBy = By
			.xpath("//*[@id='totalSubmitBid']//following::div[contains(text(),'Bidder Detail')]");

	public By bidDetailsStatusBy = By.xpath("//*[@id='submitBidTable']/tbody/tr/td[2]");

	public By bidPreviewLinkBy = By.xpath("//*[starts-with(@ng-click,'previewBid')]");

	public By evaluationStatus = By.xpath(
			"//div[@class='col-md-12']//strong[contains(text(),'Evaluation Status : 	 Pending for opening Approval (Cover 1)')]");
	public By evaluation_tenderId = By.xpath("//div[@class='text-right col-md-6']");
	public By evaluation_noOfLiveBids = By.xpath("//div[@class='col-md-6 text-left']");

	public By evaluationStatus2 = By.xpath("//strong[contains(text(),'Evaluation Status : 	 Cover 1 Evaluated')]");
	public By tenderId = By.xpath("//strong[contains(text(),'Tender Id : ')]");
	public By numberOfLiveBids = By.xpath("//strong[contains(text(),' No of Live Bids :')]");
	public By openAndEvaluateBid = By.xpath("//label[contains(text(),' Open & Evaluate Bid  ')]");
	public By scheduleOpening = By.xpath("//label[contains(text(),'Schedule Opening ')]");
	public By approverOrEvaluatorRequired = By.xpath("//label[contains(text(),' Approver/Evaluator required ')]");

	public By evaluationTenderStatus_Evalutation = By.xpath("//span[text()='Evaluation  ']");

	public By noOfEligibleBid = By.xpath("//span[contains(text(),'No of Eligible Bid :')]");

	public By bidderCompany = By.xpath("//table[@id]/tbody/tr[2]/td[3]");

	public By bidderOverAllComment = By.xpath("//table[@id]/tbody/tr[2]/td[8]");
	public By bidderAttachment = By.xpath("//table[@id]/tbody/tr[2]/td[9]");
	public By bidderActionDropDown = By.xpath("//table[@id]/tbody/tr[2]/td[10]//button");
	public By submittedbidActionDropDown = By.xpath("//div[@class='dropdown action_sec row-1-0']//button[@id='menu1']");
	public By bidderSelection = By.xpath("//table[@id]/tbody/tr[2]/td[1]");
	public By attachmentDetails = By.xpath("//*[@id='_qout_attachment']/div/div[1]/table/tbody");
	public By technical_Clause = By.xpath("(//th[text()='Clause'])[1]");
	public By technical_Details = By.xpath("(//th[text()='Clause'])[1]");
	public By technical_Attachment = By.xpath("(//th[text()='Attachment'])[1]");
	public By technical_Complaince = By.xpath("(//th[text()='Technical Compliance'])[1]");
	public By technical_AttachFile = By.xpath("(//th[text()='Attach File (if any)'])[1]");
	public By technical_Remarks = By.xpath("(//th[text()='Remarks'])[1]");
	public By technical_EvaluatorRemarks = By.xpath("(//th[text()='Evaluator Remarks'])[1]");
	public By termsNConditions = By.xpath("//a[text()='Terms and Conditions']");
	public By tnc_EvaluatorRemarks = By.xpath("(//th[text()='Evaluator Remarks'])[2]");
	public By tnc_Clause = By.xpath("(//th[text()='Clause'])[2]");
	public By tnc_Details = By.xpath("(//th[text()='Details'])[2]");
	public By tnc_Attachment = By.xpath("(//th[text()='Attachment'])[2]");
	public By tnc_Complaince = By.xpath("//th[text()='Compliance']");
	public By tnc_AttachFile = By.xpath("(//th[text()='Attach File (if any)'])[2]");
	public By tnc_Remarks = By.xpath("(//th[text()='Remarks'])[2]");
	public By tenderIdBidDetails = By.xpath("//div[@id='_quot_gen_info']//strong[contains(text(),'Tender ID')]");
	public By tenderDescription = By.xpath("//strong[contains(text(),'Tender Description')]");
	public By proableAmountOfContract = By.xpath("//strong[contains(text(),'Probable Amount of the Contract')]");
	public By tenderCategory = By.xpath("//strong[contains(text(),'Tender Category')]");
	public By referenceCode = By.xpath("//strong[contains(text(),'Quotation Reference Code')]");
	public By quotationCurrency = By.xpath("//strong[contains(text(),'Quotation Currency')]");
	public By bidderAttachment1 = By.xpath("//a[contains(text(),'Bidder Attachment')]");
	public By bidSpecificAttachment = By.xpath("//a[contains(text(),'Bid Specific Attachment')]");
	public By tenderAttachment = By.xpath("//a[contains(text(),'Tender Attachment')]");
	public By close = By.xpath("//button[@ng-click='closePreview()']");
	public By approveOrRejectEditableLink = By.xpath("//i[@class='fa fa-pencil']");
	public By approveRadioButton = By.xpath("//input[@type='radio']/following::strong[text()='Approve']");
	public By rejectRadioButton = By.xpath("//input[@type='radio']/following::strong[text()='Reject']");
	public By save = By.xpath("//button[contains(text(),'Save')]");
	public By commentText = By.xpath("//textarea[@ng-model='bidderStatusModel.comment']");
	public By alertPopUp = By.xpath("//strong[text()='TCS test (TCS_AUTO_01) is successfully Approved']");
	public By alertCloseButton = By.xpath("//button[@ng-click='clearAlertMessages()'][normalize-space()='Close']");
	public By bidderStatusApprove = By.xpath("//label[text()='Approved']");
	public By submitbutton1 = By.xpath("//a[@data-original-title='Submit']");
	public By notesheetSubmit = By.xpath("//*[@data-icon='paper-plane']");
	public By overallComment_currentPart = By.xpath("//iframe[@id='uiTinymce1_ifr']");
	public By upload_editable = By.xpath("//input[@class='ng-isolate-scope']");
	public By pendingForEvaluationApproval = By.xpath("(//*[@id='clrcookie'])[1]");
	public By cancelOkSuccess = By.xpath("//button[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0']");
	public By repeatOrdersuccessMsg = By.xpath("//*[@id='toast-container']/div/div");
	public By recallsubmit = By.xpath("(//button[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0'])[1]");
	public By bidDetailstenderId = By.xpath("(//strong[@class='ng-binding'])[1]");
	public By bidDetailstenderStatus = By.xpath("(//strong[@class='ng-binding'])[2]");
	public By TotalNoOfSubmittedBid = By.xpath("(//span[@class='ng-binding'])[2]");
	public By bidderName = By.xpath("//table[@class='table']//tbody//tr[2]//td[2]");
	public By bidder_bidSubmissionDate = By.xpath("//table[@class='table']//tbody//tr[2]//td[4]");
	public By bidder_decryptionStatus = By.xpath("//table[@class='table']//tbody//tr[2]//td[5]");
	public By bidder_status = By.xpath("//table[@class='table']//tbody//tr[2]//td[6]");
	public By bidder_approveOrReject = By.xpath("//table[@class='table']//tbody//tr[2]//td[7]");
	public By bidder_overallComment = By.xpath("//table[@class='table']//tbody//tr[2]//td[8]");
	public By bidder_attachment = By.xpath("//table[@class='table']//tbody//tr[2]//td[9]");
	public By bidder_actiondropdown = By.xpath("//table[@class='table']//tbody//tr[2]//td[10]");
	public By bidder_checkbox = By.xpath("//input[@ng-click='checkAllBidderForDecryption()']");
	public By decryptSelected = By.xpath("//button[@ng-click='decryptBidderData()']");
	public By bidDetails = By.xpath("(//li[@class='eborder-top'])[3]");
	public By termsAndCondition_bidDetails = By.xpath("//a[text()='Terms and Conditions']");
	public By generalInformation_bidDetails = By.xpath("//a[text()='General Information']");
	public By attachments_bidDetails = By.xpath("//a[text()='Attachments']");
	public By commercial_bidDetails = By.xpath("//a[text()='Commercial']");
	public By quotationSummary_bidDetails = By.xpath("//a[text()='Quotation Summary']");
	public By close_bidDetails = By.xpath("//button[@ng-click='closePreview()']");
	public By approveOrReject_editable = By.xpath("//button[@ng-click='editBidderStatus($index)']");
	public By approve_editable = By.xpath("(//label[@class='radio-inline'])[1]");
	public By comment_editable = By.xpath("//textarea[@ng-model='bidderStatusModel.comment']");
	public By save_editable = By.xpath("//button[@ng-click='saveBidderStatus()']");
	public By alertPopUp_editable = By.xpath(
			"//strong[@class='ng-binding' and contains(text(),'CTS test (CTS_AUTO_01) is successfully Approved')]");
	public By submit_biddetails = By.xpath("//button[@ng-click='validateDecryptedData();']");
	public By tenderStatus_completed = By.xpath("//span[contains(text(),'Completed')]");
	public By tenderStage_completed = By.xpath("//button[@data-original-title='Completed']");
	public By completedtablnk = By.xpath("//a[normalize-space()='Completed']");
	public By completedTab = By.xpath("//*[@value='completed']");
	public By tabBody = By.xpath("/html/body/app-root/div/div/div/app-pending-wf-approval/div/div[4]/div/div/table/tbody");
	public By tenderEvalTab = By.xpath("//*[contains(normalize-space(text()),'Tender Evaluation')]");
	public By tenderListingCompletedTab = By.xpath("//label[@for='completetender']");
	//public By evaluation_sendForApproval = By.xpath("//button[@data-original-title='Send For Approval']");
	public By evaluation_sendForApproval = By.xpath("(//button[@id='evaluStng'])[1]");
	public By approvalByHistorypage = By.xpath("//section[@class='shadowBox width95P mb-4 customCollapse whiteTheme']//div[@class='table-responsive']");
	public By evaluation_approval1_comment_area = By.xpath("//*[@id='printEvaluationApproverCommentArea_1']");
	public By approvalHistoryContentAtTenderCreator = By.xpath("//section[@class='shadowBox width95P mb-4 customCollapse whiteTheme']/div");
	public By evaluation_approval2_comment_area = By.xpath("//*[@id='printEvaluationApproverCommentArea_2']");
	public By part1HistoryTab = By.xpath("(//li[@ng-repeat='bidPart in previousBidPartList'])[2]");
	public By approverhistorytabcontent = By.xpath("//*[@id='_approvalTab']");
	public By tenderStatus_evaluation = By
			.xpath("//span[contains(text(),'Evaluation ')]");

	public By selectYesBy = By.xpath("//*[@type='radio' and @value='Y']");

	public By bidOpenBy = By.xpath("//label[@id='bidOpen']");
	public By bidOpeningCBox = By.xpath("//label[text()='Bid Opening ']");
	public By bidEvalCBox = By.xpath("//label[contains(text(), 'Bid Evaluation')]/span");
	
	public By bidValBy = By.xpath("//label[@id='bidVal']");

	public By dropDownNothingselectedBy = By.xpath("//span[text()='Nothing selected']");

	public By tender_Approver_01By = By.xpath(
			"//*[@class='dropdown-menu open']//li/a/span[contains(text(),'Tender Approver (TENDER_APPROVER_01)')]");

	public By commentSectionBy = By.xpath("//label[contains(text(),'Comments')]/following::textarea");

	public By bidEvaluationTabBy = By.xpath("//*[@id='menuBidmn1' and text()='Bid Evaluation']");

	public By evaluator_01By = By
			.xpath("//*[@class='dropdown-menu open']//li/a/span[contains(text(),'Evaluator Test (EVALUATOR_01)')]");

	public By tenderStatusInOpeningBy = By
			.xpath("//span[contains(text(),'Opening')]");

	public By tenderStageApprovalCover1By = By
			.xpath("//*[@data-original-title='Pending for opening Approval (Cover 1)']");

	public By workFlowTypeApprovalCover1By = By.xpath("//td[text()='Pending for opening Approval (Cover 1)']");

	public By workFlowStatusPendingBy = By.xpath("//td[text()='Pending']");

	public By tenderOpeningTabDetailsLinkBy = By
			.xpath("//a[contains(text(),'Section Wise View')]");
	public By tenderOpeningCommentTab = By.xpath("//a[contains(text(),'Section Wise View')]");
	public By viewIndent = By.xpath("//a[contains(normalize-space(text()),'View Indent')]");
	public By myCommentSection = By.xpath("//a[contains(text(),'My Comment')]");
	public By bidOpeningCommentTab = By.xpath("//a[contains(text(),'Bid Opening Comment')]");
	public By bidOpeningcommentBy = By.xpath("//*[text()='Bid Opening Comment']");

	public By workFlowTypeFinalApprovalCover1By = By
			.xpath("//td[text()='Pending for Approval for Final Evaluation (Cover 1)']");

	public By sequentialBy = By.xpath("//label[@class='sequanLab']");

	public By evaluationSettingspageEvaluationCommentBy = By.xpath("//*[@name='evaluationcomment']");

	public By defaultCatBy = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr[1]/td[7]/span");
	public By MyTenderTab = By.xpath("//a[@id='myTab']");
	public By supplier_standing = By.xpath("//section[contains(@class,'fixedHeader-table-section')]//table//th[contains(text(),'Suppliers Standing')]");

	public By tenderopeningTabBy = By.xpath("//*[text()='Tender Opening']");

	public By approveBtn = By.xpath("//button[@data-original-title='Approve']");
	public By evaluation_openAndEvaluationBid = By.xpath("//label[contains(text(),'Open & Evaluate Bid')]");
	public By evaluation_approverOrEvaluatorRequired = By
			.xpath("//label[contains(text(),'Approver/Evaluator required')]");
	public By evaluation_scheduleOpening = By.xpath("//label[contains(text(),'Schedule Opening')]");
	public By evaluationSettings = By.xpath("//a[contains(text(),' Evaluation Settings')]");
	public By deleteTender = By.xpath("//a[contains(text(),' Delete')]");
	public By deleteTenderFromAction = By.xpath("(//a[contains(text(),' Delete')])[2]");
	public By deleteComment = By.xpath("//textarea[@name='tenderDeleteComment']");
	public By cancelledorDeletedTenderTab = By.xpath("//*[@id='nav-cancelled-tender-tab']");
	public By deletedorcanceltenderstatus = By.xpath("//*[@id='nav-cancelled-tender']/div/table/tbody/tr/td[9]/span");
	public By tenderStatus_closed = By
			.xpath("//span[@class='ng-binding ng-isolate-scope' and contains(text(),'Closed')]");
	public By evaluationTenderStatus_Completd = By.xpath("//span[text()='Completed  ']");
	public By evaluationTenderStage_completd = By.xpath("//button[@data-original-title='Completed']");

	public By bidopeningcommentTabBy = By.xpath("//a[text()='Bid Opening Comment']");
	public By bidEvaluationCommentTabBy = By.xpath("//a[text()='Bid Evaluation Comment']");
	public By tenderStageApprovalCover2By = By
			.xpath("//*[@data-original-title='Pending for Opening Approval (Cover 2)']");
	public By tenderStageCover1Evaluated = By.xpath("//*[@data-original-title='Cover 1 Evaluated']");
	public By alertPopUp_CTS_AUTO_01 = By.xpath("//strong[text()='CTS test (CTS_AUTO_01) is successfully Approved']");
	public By closeXButton = By.xpath("//button[@ng-click='loadValidationInfoByBidder()']");
	public By alertPopUp_CTS = By.xpath("//strong[text()='CTS test (CTS_AUTO_01) is successfully Approved']");
	public By workFlowTypeApprovalCover2By = By.xpath("//td[text()='Pending for Opening Approval (Cover 2)']");

	public By workFlowTypeFinalApprovalCover2By = By
			.xpath("//td[text()='Pending for Approval for Final Evaluation (Cover 2)']");
	public By selectNoBy = By.xpath("(//*[@type='radio' and @value='N']//following-sibling::span)[2]");
	public By savepopup = By.xpath("//button[@ng-click='saveOrUpdateEvaluation()']");
	public By saveNotesheet = By.xpath("//*[@data-icon='save']");
	public By documentId_Evaluation = By.xpath("(//td[@class='ng-binding'])[2]");
	public By workFlowType_Evaluation = By.xpath("(//td[@class='ng-binding'])[4]");
	public By workFlowStatus_Evaluation = By.xpath("//td[text()='Pending']");
	public By EvaluationStatus_Evaluation = By.xpath("(//strong[@class='ng-binding'])[1]");
	public By tenderId_Evaluation = By.xpath("(//strong[@class='ng-binding'])[2]");
	public By noOfLiveBids_Evaluation = By.xpath("(//strong[@class='ng-binding'])[3]");
	public By openAndEvaluateBid_Evaluation = By.xpath("//label[contains(text(),'Open & Evaluate Bid')]");
	public By scheduleOpening_Evaluation = By.xpath("//label[contains(text(),'Schedule Opening')]");
	public By openingApprovalCover1 = By.xpath("//*[@id='inner-nav-01']/div/table/tbody/tr[1]/td[8]/span/span");
	public By approve0rReject_AlertMessage = By.xpath("//strong[text()='Please approve or reject CTS test']");
	public By viewDetailsOfBidder_AlertMessage = By.xpath("//strong[contains(text(),'Please View Details of Bidder')]");
	public String editablelinkpendingStatus = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td//*[normalize-space(text())='Pending']/../following-sibling::button";

	public String approvedStatus = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td//*[normalize-space(text())='Approved']";

	public String overallCommentAdded = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td[3]";

	public String attachmentAdded = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td[4]";

	public String rejectStatus = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td//*[normalize-space(text())='Rejected']";
	public By alertPopUp_CTSreject = By.xpath("//div[@id='alertMessageModal']//strong[@class='ng-binding']");
	public By bidderStatusRejected = By.xpath("//strong[contains(text(),'Rejected')]");
	public By bidderOverAllComment2 = By.xpath("//table[@id]/tbody/tr[2]/td[4]");
	public By bidderAttachment2 = By.xpath("//table[@id]/tbody/tr[2]/td[5]");

	public By approveAll = By.xpath("//button[@data-original-title='Approve All']");
	public By rejectBtn = By.xpath("//button[@data-original-title='Reject']");
	public By bidDetails1 = By.xpath("//i[@class='fa fa-eye']");

	public By approveAllOkButton = By.xpath("//button[text()='OK']");
	public By approveOrRejectEditableLink1 = By.xpath("(//i[@class='fa fa-pencil'])[1]");
	public By approveOrRejectEditableLink2 = By.xpath("(//i[@class='fa fa-pencil'])[2]");
	public By alertPopUp_TCS_AUTO_01 = By.xpath("//strong[text()='TCS test (TCS_AUTO_01) is successfully Rejected']");
	public By downloadDecryptBtnBy = By.xpath("//button[@data-original-title='Download Decrypted Data']");
	public By downloadDecryptLinkDropdownBy = By.xpath("//ul[@class='dropdown-menu extended logout widauto']//li/a");
	public By initiateNegotiation = By.xpath("//a[contains(text(),'Initiate Negotiation')]");

	public By negotiationBidSubmissionStartDate = By.xpath("//input[@id='negotiation-start-date-input']");
	public By negotiationBidSubmissionEndDate = By.xpath("//input[@id='negotiation-end-date-input']");
	public By tenderID_Negotiation = By.xpath("//strong[@class='ng-binding' and contains(text(),'Tender ID')]");
	public By evaluatorName = By.xpath("//input[@ng-model='evaluatorName']");
	public By bidPartOrCoverNumber = By.xpath("//input[@ng-model='bidPartName']");
	public By subProcessName = By.xpath("//select[@class='table table-striped table-advance']");

	public By bidderCode = By.xpath("//th[text()='Bidder Code']");
	public By supplierCode = By.xpath("//th[contains(text(),'Supplier Code')]");
	public By bidderCode_CTS = By.xpath("//label[text()='CTS_AUTO_01']");
	public By bidderCode_TCS = By.xpath("//label[text()='TCS_AUTO_01']");
	public By bidderCode_TECH = By.xpath("//label[text()='TECH_AUTO_01']");

	public By bidder_Name = By.xpath("//th[text()='Bidder Name']");
	public By supplier_Name = By.xpath("//th[contains(text(),'Supplier Name')]");
	public By bidder_Name_CTS = By.xpath("//td[text()='CTS  test']");
	public By bidder_Name_TCS = By.xpath("//td[text()='TCS  test']");
	public By bidder_Name_TECH = By.xpath("//td[text()='Tech Mahindra  test']");

	public By company = By.xpath("//th[text()='Company']");
	public By company_CTS = By.xpath("//td[text()='CTS']");
	public By company_TCS = By.xpath("//td[text()='TCS']");
	public By company_TECH = By.xpath("//td[text()='Tech Mahindra']");

	public By biddercomment = By.xpath("//th[text()='Comment']");

	public By status = By.xpath("//th[text()='Last Evaluation Decision']");
	public By status_Rejected = By.xpath("//label[@class='ng-scope' and contains(text(),'Rejected')]");
	public By status_Approved = By.xpath("//label[@class='ng-scope' and contains(text(),'Approved')]");
	public By status_Negotiation = By.xpath("//label[@class='ng-scope' and contains(text(),'Negotiation')]");
	public By tenderStatus = By.xpath("//span[@class='ng-binding ng-isolate-scope']");
	public By cover1Negotiation = By.xpath("//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn ng-scope ng-isolate-scope']");
	public By negotiation = By.xpath("//body[1]/section[2]/section[1]/div[1]/div[1]/form[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/ul[1]/li[3]/a[@class='dlt_tr']");
	public By generalInformation_Tab = By.xpath("//a[text()='General Information']");
	public By negotiationWindowerrorPopup = By.xpath("/html/body/div[10]/div/div/div[1]/div");
	public By negotaiationFromNegotiationTab = By.xpath("//*[@id='myTable']/tbody/tr/td[9]/div/ul/li[3]/a");
	public By bidEvaluationComment = By.xpath("//textarea[@ng-model='global.evaluationSettings.evaluationcomment']");
	public By confirmationPopUp = By.xpath(
			"//div[text()='Once confirmed,bidders who are selected as mandatory but did not submit the negotiated bids, will be automatically rejected. Do you wish to continue?']");
	public By confirmationPopUp_YES = By.xpath("//button[@class='btn btn-primary' and contains(text(),'Yes')]");
	// Vamshi
	public By approveOrRejectEditableLink_CTS = By.xpath("//table[@id]//td[text()='CTS']/following-sibling::td/button");
	public By approveOrRejectEditableLink_TCS = By.xpath("//table[@id]//td[text()='TCS']/following-sibling::td/button");
	public By approveOrRejectEditableLink_TechMahindra = By
			.xpath("//table[@id]//td[text()='Tech Mahindra']/following-sibling::td/button");
	public By alertPopUp_CTS_AUTO_01_Reject = By
			.xpath("//strong[text()='CTS test (CTS_AUTO_01) is successfully Rejected']");
	public By alertPopUp_Tech_AUTO_01 = By
			.xpath("//strong[text()='Tech Mahindra test (TECH_AUTO_01) is successfully Negotiated']");
	public By negotiateRadioButton = By.xpath("//input[@type='radio']/following::strong[text()='Negotiate']");
	public By negotiateMandatoryRadioButton = By.xpath("//input[@type='radio']/following::strong[text()='Mandatory']");
	public By alertPopUp_Tech_AUTO_01_Approved = By
			.xpath("//strong[text()='Tech Mahindra test (TECH_AUTO_01) is successfully Approved']");
	public By bidder_Allcheckbox = By.xpath("//input[@ng-click='checkAllBidderForDecryption()']");
	public By notrequired = By.xpath("//label[contains(text(),'Not Required')]");
	public By bidderStatus_Rejected = By.xpath("//strong[@class='ng-binding' and contains(text(),'Rejected')]");
	public By bidderStatus_Approved = By.xpath("//strong[@class='ng-binding' and contains(text(),'Approved')]");
	public By bidderStatus_Negotiated = By.xpath("//strong[@class='ng-binding' and contains(text(),'Negotiated')]");
	public By OverAllComment_CTS = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[2]//td[4]");
	public By OverAllComment_TCS = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[3]//td[4]");
	public By OverAllComment_TECH = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[4]//td[4]");
	public By attachment_CTS = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[2]//td[5]");
	public By attachment_TCS = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[3]//td[5]");
	public By attachment_TECH = By.xpath("//table[@class='table table-advance table-hover']//tbody//tr[4]//td[5]");
	public By bidderStatus_Approved_TECH = By
			.xpath("(//strong[@class='ng-binding' and contains(text(),'Approved')])[2]");
	public By bidderStatus_Rejected_TECH = By
			.xpath("(//strong[@class='ng-binding' and contains(text(),'Rejected')])[2]");
	public By previousBy = By.xpath("//a[text()='Prev']");
	public By negotiationTimeOverPopup = By.xpath("//div[contains(text(),'Negotiated Bid can be placed between')]");
	public By postTenderProcessBy = By.xpath("//*[contains(normalize-space(text()),'Post Tender Process')]");
	public By totalNegotiatedBid = By.xpath("//*[contains(normalize-space(text()),'Total Negotiated Bid')]");
	public By AllSanctionsFromRFx = By.xpath("//span[normalize-space()='All Sanctions from RFx']"); 
	public By AllSanctions = By.xpath("//span[normalize-space()='All Sanctions']");
	public By TypeYourKeywordSN = By.xpath("//input[contains(@placeholder, 'Search by')]"); 
	

	public By SN_stage = By.xpath("(//button[@id='clrcookie'])[1]");
	public By draftMSN_stage = By.xpath("//*[@id='clrcookie']/i");
	public By draftSN_stage = By.xpath("//tbody/tr[1]/td[5]/ul[1]/li[1]/a[1]/button[1]");
	public By checkSupplier = By.xpath("//*[@id='approvedSupplier']/div[1]/div/div/table/tbody/tr[1]/td[1]/input");
	public By createSanctionNote = By.xpath("//a[@mattooltip='Create Sanction Note']");
	public By createSanctionNote_New = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-completed-tender-details[1]/section[1]/div[1]/div[1]/a[4]");
	public By createNotesheetIcon = By.xpath("//*[@data-icon='plus']");
	public By addfile = By.xpath("(//button[@class='btn modalBtnBlue ms-sm-2'])[2]");
	public By subject = By.xpath("//*[@id='new_notesheet.notesheet_subject.1']");
	public By notesheetRefNo = By.xpath("//*[@id='new_notesheet.notesheet_ref_no.2']");
	public By notesheetdocupload = By.xpath("//*[@data-icon='upload']");
	public By notesheetdocupload1 = By.xpath("//input[@id='fileInput']");
	public By notesheetcreateDeatils = By.xpath("//*[@id='accordionPanelsStayOpenExample']/div/div[2]/div/div[5]/div[2]/div[2]/ckeditor/div[2]/div[2]/div/p");
	public By briefcaseNotesheet = By.xpath("//*[@class='svg-inline--fa fa-box fa-w-16']");
	
	public By sanctionReferenceNumber = By.xpath("//input[@id='sanctionRef']");
	public By sanctionReferenceNumber_msn = By.xpath("//input[@name='sanctionRef']");
	public By sn_ref_note_text = By.xpath("//*[@id='sanctionRefModal']/div/div/div[1]/h3");
	public By select_source = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-empty'])[2]");
	public By sanctionRefNo_Submit = By.xpath("(//button[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0'])[3]");
	public By supplierSelectionCheckBox = By.xpath("//input[@ng-click='selectAllQuotation(checkAllBidder)']");
	public By plusIcon_CTS = By.xpath("//a[contains(text(),'CTS')]");
	public By plusIcon_TCS = By.xpath("//a[contains(text(),'TCS')]");
	
	public By order_list_action_button = By.xpath("//div[@class='dropstart']/button");
	public By cancelOrder = By.xpath("//*[@id='nav-my-indent']//*[text()=' Cancel Order']");
	public By deleteOrder = By.xpath("(//*[@id='nav-my-indent']//*[text()=' Delete Order'])[1]");
	public By deleteOrderRemarks = By.xpath("//*[@name='desc']");
	public By deleteUploadButton = By.xpath("//span[@class='uploadButtonText']");
	public By deleteButton = By.xpath("//button[text()='Delete']");
	public By cancelIndentComment = By.xpath("//div[@class='ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline']/p");
	public By recommendationTab = By.xpath("//a[contains(text(),'Recommendation')]");
	public By recommendationComment = By.xpath("//*[@id='tinymce' and @data-id='txtArea']");
	public By submit = By.xpath("//button[@ng-click='submitSanction()']");
	
	public By editOrder = By.xpath("//*[@id='nav-my-indent']//*[text()=' Edit Order']");
	public By actionDropdown = By.xpath("//button[@id='menu1']");
	public By view = By.xpath("//a[@ng-click='viewModal(sanction)']");
	public By viewDetails_TCS = By.xpath("//div[contains(text(),'TCS')]");
	public By viewDetails_CTS = By.xpath("//div[contains(text(),'CTS')]");
	public By viewDetails_close = By.xpath("(//button[contains(text(),'Close')])[5]");
	public By approvalDetails = By.xpath("//a[@ng-click='showApprovalDetails(sanction)']");
	public By noRecordsFound = By.xpath("//strong[text()='No Records Found']");
	public By approvalDetails_close = By.xpath("(//button[contains(text(),'Close')])[8]");
	public By issuePO = By.xpath("//button[contains(text(),'Issue PO')]");
	public By documentNumber = By.xpath("//form[@name='approvalForm']/table//tr/td[2]");
	public By typeAnyKeyword = By.xpath("(//input[@ng-model='obj.snSearchText'])[2]");
	public By typeAnyKeyword_Pending = By.xpath("//input[contains(@placeholder, 'Search by')]");
	public By typeAnyKeyword_DeletedCancelledSN = By.xpath("(//input[@ng-model='obj.snSearchText'])[3]");
	public By SNpendingList = By.xpath("//button[contains(text(),'Pending')]");
	public By corrigendumApprovalAtHomepage = By.xpath("//*[contains(text(),'Corrigendum Approval')]");
	public By nevigateToApproverPage = By.xpath("//*[@id='nav-tabContent']/div/div/div/div/div/div/div/div/div[1]/p[1]/span[2]");
	public By SNcompletedList = By.xpath("//*[text()='Completed']");
	public By CompletedSNTab = By.xpath("//*[contains(text(),'Completed') and @type='button']");
	public By downloadSanctionReport = By.xpath("//a[@ng-click='downloadSnReportModal(sanction.sanctionId)']");
	public By saveSanction = By.xpath("//button[@ng-click='saveSanction(false)']");
	public By downloadReoprtFormat = By.xpath("//select[@ng-model='downLoadReportSupportingData.type']");
	public By goButton = By.xpath("//button[@ng-click='generateReport()']");
	public By downloadSanctionReportClose = By.xpath("(//button[contains(text(),'x')])[7]");
	public By attachmentdownloadiconPOPreview = By.xpath("//td[@class='display-l ng-star-inserted']//fa-icon[@class='ng-fa-icon']//*[name()='svg']");
	public By ClosedownloadSanctionReport = By.xpath("//div[@id='downloadReportModal']//button[@type='button'][normalize-space()='x']");
	public By username = By.xpath("//th[contains(text(),'User Name')]");
	public By approval_Type = By.xpath("//th[contains(text(),'Approval Type')]");
	public By approvalDetailsStatus = By.xpath("(//th[contains(text(),'Status')])[5]");
	public By recallButton = By.xpath("//a[@ng-click='openRecallModal(sanction.sanctionId)']");
	public By recallReasonComment = By.xpath("//textarea[@ng-model='recallObj.comment']");
	public By recallReasonComment_BySNCreator = By.xpath("//textarea[@name='desc']");
	public By recallComment = By.xpath("//textarea[@name='recallReason']");
	public By recallReasonSubmit = By.xpath("//button[@ng-click='recallFn()']");
	public By recallReasonSubmit_BySNCreator = By.xpath("//mat-dialog-actions/div//button[text()='Submit']");
	public By recallbuttonEvaluation = By.xpath("//*[@data-target='#recallModalForTenderEval']");
	public By cancel_User1 = By.xpath("(//button[@ng-click='cancelUser(row)'])[1]");
	public By typeAnyKeyword1 = By.xpath("//input[@id='tenderFilter']");
	public By sanctionNoteEvaluationCommentTab = By.xpath("//a[contains(text(),'Comment')]");
	public By sanctionNoteEvaluationApprove = By.xpath("//button[@data-original-title='Approve']");
	public By recallReasonEvaluation = By.xpath("//textarea[@ng-model='recalReasonTenderEval']");
	
	
	public By approveConfirm = By.xpath("//*[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0' and text()='Yes']");
	public By revertbackToApprover = By.xpath("//button[contains(text(),'Reverse back to approver')]");
	public By revertbackToIC = By.xpath("//a[contains(text(),'Revert Back To IC')]");
	public By revertbackToApprover(String buttonName) {

		return By.xpath("//button[contains(text(),'"+buttonName+"')]");
	}
    public By sanctionNoteEvaluationReview = By.xpath("(//button[contains(@ng-click, 'approve')])[2]");
    public By ForwardTheSNWorkflow = By.xpath("//button[contains(text(),'Forward to Next Person')]");
	public By snEndWorkflow = By.xpath("//*[@class='btn modalBtnBlueBorder mx-2 mb-2 mb-sm-0' and text()='End Workflow']");
	public By confirm_snEndWorkflow = By.xpath("//*[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0' and text()='Yes']");
	public By edit = By.xpath("//a[@ng-click='editSanctionNote(sanction)']");
	public By completedRFQId = By.xpath("//table[@id='myTablebyrTl00']/tbody/tr/td[2]");
	public By noRecords = By.xpath("//span[contains(@style,'position: absolute;right:')]/b");
	public By purchaseOrder = By.xpath("//span[contains(text(),'Purchase Order (PO)')]");
	public By poListing = By.xpath("//a[contains(text(),'PO Listing')]");
	public By createPO = By.xpath("//button[@data-original-title='Create PO']");
	public By selectSource = By.xpath("//select[@ng-model='selectedSource']");
	public By POstage = By.xpath("//button[@id='bidPublish']");
	public By sanctionTemplateGroupAlert = By.xpath(
			"//div[contains(text(),'Sanction template group does not exist.Please create sanction template group!')]");
	public By predefine = By.xpath("//input[@id='appPre'][@value='P']");
	public By issuePOTemplateAlert = By.xpath(
			"//div[contains(text(),'Sanction template not mapping with any PO template! Do you want to move to PO mapping?')]");
	public By sanctionTemplate = By.xpath("//span[contains(text(),'Sanction Template')]");
	public By templateGroupCreation = By.xpath("//a[contains(text(),'Template Group Creation')]");
	public By evaluationstage = By.xpath("//button[@id='evaluation123']");
	public By dopMenuLinkBy = By.xpath("//*[@class='fa fa-user']");

	public By createDopLinkBy = By.xpath("//*[contains(normalize-space(text()),'Create DOP')]");
	public By ViewOrder = By.xpath("//*[contains(normalize-space(text()),'View Order')]");
	public By selectModuleBy = By.xpath("//*[@ng-model='dop.moduleId']");

	public By selectProcurementCategoryBy = By.xpath("//*[@ng-model='dop.procCatId']");

	public By addOrg_HierarchyBy = By.xpath("//*[contains(@data-target,'organisationHierarchy')]/i");

	public By addBtn_HierarchyBy = By
			.xpath("//*[contains(@ng-click,'setTempOrgHierachy')][contains(normalize-space(text()),'Add')]");

	public By dopValueFromBy = By.xpath("//*[@ng-model='dop.minValue']");

	public By dopValueToBy = By.xpath("//*[@ng-model='dop.maxValue']");

	public By dopNameBy = By.xpath("//*[@ng-model='dop.dopName']");

	public By DopSucessMsgBy = By.xpath("//*[contains(text(),'DOP has been saved successfully')]");

	public By dop_ListLinkBy = By.xpath("//*[contains(normalize-space(text()),'DOP List')]");

	public By addUserBy = By.xpath("//*[contains(@ng-click,'addUser')]");

	public By deleteDopBy = By.xpath("//*[contains(@ng-click,'removeChildRow')]");

	public By addUserToTableBy = By.xpath("//*[contains(@ng-click,'addUser2Table')]");

	public By approvalTypeDropdownBy = By.xpath("//*[@ng-model='user.approvalType']");

	public By saveUserBy = By.xpath("//*[@ng-click='saveUser()']");

	public By activeTabLinkBy = By.xpath("//*[contains(normalize-space(text()),'Activate')]");

	public By confirmBtn = By.xpath("//*[@data-bb-handler='confirm']");
	public By sendback = By.xpath("//*[@id='main-content-nw']/section/div/div/div[1]/h3/div/a[3]/button");
	public By dopListStatusActiveBy = By
			.xpath("//*[@id='myTablebyrTl00']/tbody/tr/td[position()=9 and text()='Active']");

	public By doplistPageColumnNames = By.xpath("//*[@id='myTablebyrTl00']/thead/tr/th");

	public By deActiveTabLinkBy = By.xpath("//*[contains(normalize-space(text()),'De-Activate')]");
	public By cancelMSNBtn = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[4]");
	public By deleteMSNBtn = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[4]/a");
	public By cancellationHistory = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[8]/a");
	public By deletionHistory = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[8]/a");
	public By cancelRemarks_MSN = By.xpath("//*[@id='reasonModal']/div/div/div[2]/div/table/tbody/tr[2]/td[1]");
	public By dopListStatusInActiveBy = By
			.xpath("//*[@id='myTablebyrTl00']/tbody/tr/td[position()=9 and text()='Inactive']");

	public By dopListEditBy = By.xpath("//*[contains(normalize-space(text()),'Edit')]");

	public By dopListPreviewBy = By.xpath("//li/a[contains(normalize-space(text()),'DOP Preview')]");

	public By dopPreviewOkBy = By.xpath("//*[contains(text(),' Ok')]");

	public By dopPreviewVerifySanctionModuleBy = By.xpath(
			"//table/tbody/tr/td[label[text()='Module'] ]/following-sibling::td/label[contains(normalize-space(text()),'Sanction')]");

	public By dopClonelinkBy = By.xpath("//*[contains(normalize-space(text()),'Clone DOP')]");
	public By cloneIndent = By.xpath("//a[contains(text(), 'Clone')]");
	public By cloneIndentPreview = By.xpath("//button[contains(text(), 'Clone')]");
	public By Confirm = By.xpath("//button[normalize-space(text())='Confirm']");
	public By dopListSactionRowTextBy = By.xpath("//table/tbody/tr[1]/td[position()=3 and text()='Default_cat']");

	public By activeStateActionMenuBy = By.xpath(
			"(//*[@id='myTablebyrTl00']/tbody/tr/td[position()=9 and text()='Active']/following-sibling::td//button)[1]");

	public By draftStatActionMenuBy = By.xpath(
			"(//*[@id='myTablebyrTl00']/tbody/tr/td[position()=9 and text()='Draft']/following-sibling::td//button)[1]");
	public By sanctionNoteStage = By.xpath("//button[@id='clrcookie']");

	public By sanctionReferenceNo = By.xpath("//input[@id='sanctionRef']");
	public By sanctionSubmit = By.xpath("//button[@ng-click='saveSanctionRef()']");
	public By itemAllotment1 = By.xpath("(//input[@ng-model='x.info.sanctionFlag'])[1]");
	public By itemAllotmentSelect = By.xpath("(//div[@ng-click='toggleCollapse($index)']/h5)[1]");
	public By itemAllotmentRow = By
			.xpath("(//div[text()='BOQ (Mandatory)']/following-sibling::div/table/tbody/tr[1]/td[1]/input)[1]");

	public By recommendationOverAllComment = By.xpath("//body[@id='tinymce']");
	public By recommendationOverAllComment_frame = By.xpath("//iframe[@id='txtArea_ifr']");
	public By recommendationOverAllCommentButton = By.xpath("//body[@id='tinymce']");
	public By closeLifeCyclePopup = By.xpath("(//button[@aria-label='Close'])[2]");
	public By closeButtonApproval = By.xpath("//button[@ng-click='closeApprovalModal()'][contains(text(),'Close')]");
	public By cancelUser = By.xpath("//button[@ng-click='cancelUser(row)']");
	public By pendingForApproval = By.xpath(
			"//button[@data-original-title='Pending for approval'][@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn']");

	public By acceptOrReject = By.xpath(
			"//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 yellowBtn grnBtn'][@data-original-title='Accepted/Rejected']");
	public By coordinatorFlag_2 = By.xpath("//table[@id='approver']/tbody/tr[2]/td[5]//input");
	public By itemSelectionAlert = By
			.xpath("//li[contains(text(),'Please select quation item template for organization')]");
	public By suppliercheckboxCTS = By.xpath("(//input[@ng-model='x.info.sanctionFlag'])[1]");
	public By addAttachment = By.xpath("//button[@ng-click='addAttachment()']");
	public By uploadAttachment = By.xpath("//input[@clari-file='data']");
	public By recall = By.xpath("//a[@ng-click='openRecallModal(sanction.sanctionId)']");
	public By recallReason = By.xpath("//textarea[@name='recallReason']");
	public By submitRecall = By.xpath("//button[contains(text(),'Submit')][@data-dismiss='modal']");
	public By draftStage = By.xpath(
			"//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn'][@data-original-title='Draft']");
	public By reviewButton = By.xpath("//i[@class='fa fa-arrow-left']");
	public By confirm = By.xpath("//button[@data-bb-handler='confirm']");
	public By rejectedSupplier = By.xpath("//a[text()='Rejected and Not-participated supplier']");
	public By orgName = By.xpath("//div[@id='rejectedSupplier']//table/tbody/tr/td[1]");
	public By wipApprover = By.xpath("//table[@id='myTable']/tbody/tr/td[7]");
	public By supplierStanding = By.xpath("//table[@id='myTable']/tbody/tr/td[7]");

	// public By coordinator = By.xpath("//input[@type='radio' and
	// @ng-value='rad_999']");
	public By SearchIdInSanction = By.xpath("//input[@ng-model='obj.snSearchText']");

	public By ALLsupplierSelectionCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
	public By MSNSupllier_ItemAllotment = By.xpath("//*[@id='accordion']/div/div[3]/div[1]");
	public By L1supplierSelectionCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
	public By supplierWiseSelection(String orgName) {
		return By.xpath("//td[normalize-space(text())='" + orgName + "']//preceding-sibling::td/input[@type='checkbox']");
	}
	public By canceluser = By.xpath("//button[@class='btn btn-default btn-sm']/i");

	public By termsAndConditioncheckBox_TCS = By
			.xpath("((//a[contains(text(),'TCS')])[1]/../../..//div[text()='Terms and Conditions']/..//input)[1]");
	public By termsAndConditioncheckBox = By.xpath("//div[contains(normalize-space(text()),'Terms and Conditions')])[1]");
	
	public By boqCheckbox_TCS = By
			.xpath("((//a[contains(text(),'TCS')])[1]/../../..//div[text()='BOQ (Mandatory)']/..//input)[1]");
	public By boqCheckbox = By.xpath("(//div[contains(normalize-space(text()),'BOQ (Mandatory)')])[1]");
	public By Exceptions = By.xpath("//thead/tr/th[10]");
	public By boqQty = By.xpath("//*[@placeholder='Qty']");
	

	public By EditTagtext_supplierQuotedQuantity1_TCS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[1]/../span");

	public By EditTagtext_supplierQuotedQuantity2_TCS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[2]/../span");

	public By EditTagtext_supplierQuotedQuantity3_TCS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[3]/../span");

	public By termsAndConditioncheckBox_CTS = By
			.xpath("((//a[contains(text(),'CTS')])[1]/../../..//div[text()='Terms and Conditions']/..//input)[1]");
	public By boqCheckbox_CTS = By
			.xpath("((//a[contains(text(),'CTS')])[1]/../../..//div[text()='BOQ (Mandatory)']/..//input)[1]");

	public By EditTagtextsupplierQuotedQuantity1_CTS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[4]/../span");

	public By EditTagtextsupplierQuotedQuantity2_CTS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[5]/../span");

	public By EditTagtextsupplierQuotedQuantity3_CTS = By
			.xpath("(//input[@placeholder='Supplier Quoted Quantity'])[6]/../span");
	public By deleteUser = By.xpath("//button[@ng-click='cancelUser(row)']");

	public By sanctionDetails = By.xpath("//a[normalize-space(text())='Details']");
	public By approvesanction = By.xpath("//button[@data-original-title='Approve']");
	public By reviewsanction = By.xpath("//button[@data-original-title='Review']/i");
	public By commenttab = By.xpath("//a[normalize-space(text())='Comment']");
	public By summarytab = By.xpath("//a[normalize-space(text())='Summary']");
	public By confirmsanction = By.xpath("//button[normalize-space(text())='Confirm']");
	public By cancelsanction = By.xpath("//button[normalize-space(text())='Cancel']");
	public By mousehoverreview = By.xpath("//button[@data-original-title='Approve']/../../a[4]");
	public By TenderApproverReview = By.xpath("//*[@id='review']");
	public By btnTenderPO = By.xpath("//button[normalize-space(text())='PO']");
	public By btnIssuePO = By.xpath("//button[normalize-space(text())='Issue PO']");
	public By SelectTemplateGroup = By.xpath("//select/option[text()='PO Template Group V1.13']");
	public By SelectBidderPOCTS = By.xpath("//select/option[text()='CTS']");
	public By SelectBidderPOTCS = By.xpath("//select/option[text()='TCS']");
	public By BOQAllItemChecklist = By.xpath("(//p[text()='BOQ (Mandatory)']/../..//input)[1]");
	public By BOQAllItemsChecklist(int count) {

		return By.xpath("(//div[@class='tabular-container']/table[1]/thead[1]/tr[1]/th[1]/input[1])[" + count + "]");
	}
	public By supplierPOSelect = By.xpath("//*[@id='venderView']");
	public By BOQAllItemsChecklist_T1 = By.xpath("(//div[@class='tabular-container']/table[1]/thead[1]/tr[1]/th[1]/input[1])[1]");
	public By BOQAllItemsChecklist_T2 = By.xpath("(//div[@class='tabular-container']/table[1]/thead[1]/tr[1]/th[1]/input[1])[2]");
	//public By BOQAllItemsChecklist_T2 = By.xpath("//body[1]/app-root[1]/div[1]/div[1]/div[1]/app-po-item-and-vendor-selection[1]/section[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/input[1]");
	public By addAllSNItems = By.xpath("//div[@id='collapseTwo']/div[1]/div[1]/button[1]");
	public By btnAddfinalItems = By.xpath("(//button[@title='Add'])[1]");
	public By addItemQantity1 = By.xpath("(//input[@type='textbox'])[1]");
	public By addItemQantity2 = By.xpath("(//input[@type='textbox'])[2]");
	public By addItemQantity3 = By.xpath("(//input[@type='textbox'])[3]");
	public By btnProceedToCreatePO = By.xpath("//button[@data-original-title='Proceed to Create PO']");
	public By COnfirmationYESforScantionInFuture = By
			.xpath("//span[text()='Do you want to use the sanction in future?']/../../../..//button[text()='Yes']");
	public By POReferenceNo= By.xpath("//label[text()='PO Reference No:']/../input");
	//public By BtnCreatePO = By.xpath("//button[text()='Create PO']");
	public By BtnCreatePO = By.xpath("//button[contains(text(),'Create Order')]");
	public By saveButton_PO = By.xpath("//h2[contains(text(), 'Order Creation')]//following-sibling::div/button[1]");
	public By submitButton_PO = By.xpath("//h2[contains(text(), 'Order Creation')]//following-sibling::div/button[2]");
	public By POExpiryDate = By.xpath("//input[@id='po_header_temp_u_po_expiry_date']");
	public By poDocNo(String val) {

		return By.xpath("//span[contains(text(),'" + val + "')]");
	}

	public By POAmendmentflagOption(String val) {

		return By.xpath("//select[@name='po_amendment_flag']/option[text()='" + val + "']");
	}
	//=========PO Template Group(RDCIS supply and service template)
	//General Information
	public By poGIT = By.xpath("//div[contains(text(),'General Information')]");
	public By orderNo = By.xpath("//input[@id='po_header_temp_u.po_no.0']");
	public By POAmendmentflag = By.xpath("//select[@name='po_header_temp_u_po_amendment_flag']");
	public By shipTo = By.xpath("//input[@id='po_header_temp_u.ship_to.0']");
	public By bilTo = By.xpath("//input[@id='po_header_temp_u.bill_to.0']");
	public By LD_Applicable = By.xpath("//select[@name='po_header_temp_u_ld_cl_applicable']");
	public By LD_ApplicablePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[25]/fieldset/div");
	public By LD_Applicable_For_Delay = By.xpath("//input[@id='po_header_temp_u.LD_Percentage_Delay.0']");
	public By LD_Applicable_For_DelayPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[26]/fieldset/div");
	public By LD_Applicable_For_Non_Performance = By.xpath("//input[@id='po_header_temp_u.LD_Percentage_NonPer.0']");
	public By LD_Applicable_For_Non_PerformancePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[27]/fieldset/div");
	public By Frequency_of_LD_Calculated_For_Delay = By.xpath("//select[@name='po_header_temp_u_LD_Dur_Delay']");
	public By Frequency_of_LD_Calculated_For_DelayPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[28]/fieldset/div");
	public By Frequency_of_LD_Calculated_For_Non_Performance = By.xpath("//select[@name='po_header_temp_u_LD_Dur_nonperfo']");
	public By Frequency_of_LD_Calculated_For_Non_PerformancePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[29]/fieldset/div");
	public By Maximum_LD_Applicable_for_This_Case = By.xpath("//input[@id='po_header_temp_u.Max_LD_Applicavle.0']");
	public By Maximum_LD_Applicable_for_This_CasePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[30]/fieldset/div");
	public By Performance_Security_Applicable = By.xpath("//select[@name='po_header_temp_u_PBG_Applicable']");
	public By Performance_Security_ApplicablePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[31]/fieldset/div");
	public By Performance_Security_Applicable_Percentage = By.xpath("//input[@id='po_header_temp_u.Percentage_of_PBG.0']");
	public By Performance_Security_Applicable_PercentagePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[32]/fieldset/div");
	public By MSME_Claimed_Status = By.xpath("//select[@name='po_header_temp_u_MSME_Claimed_Status']");
	public By MSME_Claimed_StatusPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[35]/fieldset/div");
	public By Type_Enterprise = By.xpath("//select[@name='po_header_temp_u_Type_of_Enterprise']");
	public By Type_EnterprisePreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[36]/fieldset/div");
	public By Social_Ownership_Category = By.xpath("//select[@name='po_header_temp_u_Ownership_Category']");
	public By Social_Ownership_CategoryPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[37]/fieldset/div");
	public By MII_Claimed_Status = By.xpath("//select[@name='po_header_temp_u_MII_Claimed_Status']");
	public By MII_Claimed_StatusPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[38]/fieldset/div");
	public By Type_Supplier = By.xpath("//select[@name='po_header_temp_u_Local_Content']");
	public By Type_SupplierPreview = By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[39]/fieldset/div");
	public By download_attachmentIcon = By.xpath("//*[@id='_qout_attachment']/div/div[1]/table/tbody/tr[1]/td[3]/label/span/i");
	public By boqMandetorydata = By.xpath("//*[@id='target']");
	public By attachmentdetails = By.xpath("(//*[@id='_rfqattachment']//tbody)[1]");
	public By rfqdetailsPreview = By.xpath("(//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview//..//tbody)[1]");
	public By tenderAttachment_label = By.xpath("//div[@id='_qout_attachment']/..//table/..//h2[text()='Tender Attachment']/../../parent::thead//following-sibling::tbody/tr[1]/td[2]");
	//Details of Items
	public By DetailsOfItems = By.xpath("//div[contains(text(),'Details of Items')]");
	
	//Details of Service
	public By DetailsOfService = By.xpath("//div[contains(text(),'Details of Services')]");
	
	//Other price Attribute
	public By OtherPriceAttribute = By.xpath("//div[contains(text(),'Other Price Attribute')]");
	
	//Vendor Information
	public By VendorInformation = By.xpath("//div[contains(text(),'Vendor Information')]");
	public By Supplier_GSTIN = By.xpath("//input[@id='po_vendor_temp.vendor_gstin.0']");
	public By Supplier_GSTINPreview = By.xpath("//*[@id='_po_vendor_temp']/app-tab-preview/div/div/div/div/div[6]/fieldset/div");
	public By termsandconditionDescriptionPreview = By.xpath("//*[@id='_po_terms_condi']/app-tab-preview/div/div[2]/table/tbody/tr/td[4]/div/span");
	
	//Terms & Conditions
	public By TermsConditions = By.xpath("//div[contains(text(),'Terms & Conditions')]");
	public By TermsConditions_Description = By.xpath("//input[@id='po_terms_condi.clause_details.0']");
	public By TechnicalSpecification_DescriptionPreview = By.xpath("//*[@id='_rdcis_po_cmpl_tech_speci']/app-tab-preview/div/div[2]/table/tbody/tr/td[4]/div/span");
	
	//Technical Specification
	public By TechnicalSpecification = By.xpath("//div[contains(text(),'Technical Specification')]");
	public By TechnicalSpecification_Description = By.xpath("//input[@id='rdcis_po_cmpl_tech_speci.clause_details.0']");
	
	//Extention of Order Completion/Delivery Schedule
	public By ExtentionOfOrderCompletionDeliverySchedule = By.xpath("//div[contains(text(),'Extention of Order Completion/Delivery Schedule')]");
	
	//Attachments
	public By Attachments = By.xpath("//div[contains(text(),'Attachments')]");
	public By PO_Attachment_Add_Button = By.xpath("//div[@id='_po_attachment_temp']/div[1]/div[1]/div[2]/button[1]");
	public By PO_Label = By.xpath("//input[@id='po_attachment_temp.label.0']");
	public By PO_Upload_Attachment = By.xpath("//input[@name='po_attachment_temp_attach_file']");
	public By AttachmentsLabelPreview = By.xpath("//*[@id='_po_attachment_temp']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	
	
	//Template Traverse button
	public By ttB = By.xpath("//mat-tab-header/button[2]");
	public By ttR = By.xpath("//mat-tab-header/button[1]");
	
	//Send for approval
	public By sendForApprovalText = By.xpath("//span[contains(text(),'Send For Approval')]");
	public By sendForApprovalNotesheet = By.xpath("(//span[contains(text(),'Send For Approval')])[2]");
	
	//===================================
	public By PODetailsAttachmentTab = By.xpath("//a[text()='Attachments']");
	public By addattachments = By.xpath("(//button[@data-original-title='Add']/i)[3]");
	public By addlabelsattachment = By.xpath("//input[@name='label']");
	public By addnamesattachment = By.xpath("//input[@name='file_name']");
	public By addfileattachment = By.xpath("//input[@type='file']");
	public By POBidderDetails = By.xpath("//a[text()='Bidder Details']");
	public By POItemDetails = By.xpath("//a[text()='Item Details']");
	public By VLegacyCodeItem1 = By.xpath("(//input[@name='v_legacy_code'])[1]");
	public By VLegacyCodeItem2 = By.xpath("(//input[@name='v_legacy_code'])[2]");
	public By VLegacyCodeItem3 = By.xpath("(//input[@name='v_legacy_code'])[3]");
	public By POTermsandCond = By.xpath("//a[text()='Terms & Conditions']");
	public By POclauseNo = By.xpath("//input[@name='clause_no']");
	public By POclauseName = By.xpath("//input[@name='clause_name']");
	public By POclauseDetails = By.xpath("//input[@name='clause_details']");
	public By POSave = By.xpath("//button[@data-original-title='Save']/i");
	public By POSUccessMsg = By.xpath("//button[text()='OK']");
	//*[@id="appNo"]
	public By ApprovalNotReqd = By.xpath("(//input[@id='appNo'])[2]");
	public By ApprovalNotReqd_ReleasePO = By.xpath("(//input[@id='appNo'])[1]");
	public By ApprovalNotReqd_CancelPO = By.xpath("(//input[@id='appNo'])[1]");
	public By SubmitApproval = By.xpath("//div[@class='modal-footer']/div[1]/button[2]/span[contains(text(), 'Submit')]");

	// Arka
	public By poListingLinkBy = By.xpath("//a[contains(normalize-space(text()),'PO Listing')]");

	public By poListPageRowBy = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]");
	public By myPOTab = By.xpath("//*[@id='nav-my-indent-tab']");

	public By acceptPOLinkBy = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td/div/ul/li/a/i[@class='fa fa-check']");

	public By poDeatailsTabBy = By.xpath("//*[contains(text(),'PO Details')]");

	public By aacceptPOCommentTabBy = By
			.xpath("//*[@aria-controls='profile' and contains(normalize-space(text()),'Comment')]");

	public By poObjCommentBy = By.xpath("//*[@ng-model='poObj.comment']");

	public By poAcceptBtnBy = By.xpath("//*[@ng-click='acceptPo()']/i");

	public By acceptPurchaseOrderConfirmPopYesBtnBy = By.xpath("//button[@data-bb-handler='confirm']");

	public By acceptPurchaseOrderConfirmPopOKBtnBy = By.xpath("//*[@data-bb-handler='ok']");

	public By poStatusAcceptedBy = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td[normalize-space(text())='Accepted']");

	// Arka
	public By supplierQuotedQuantity1_TCS = By
			.xpath("(//a[contains(text(),'TCS')])[1]/../../..//input[@id='qi_boq.supquotequant.0']");
	public By supplierQuotedQuantity2_TCS = By
			.xpath("(//a[contains(text(),'TCS')])[1]/../../..//input[@id='qi_boq.supquotequant.1']");
	public By supplierQuotedQuantity3_TCS = By
			.xpath("(//a[contains(text(),'TCS')])[1]/../../..//input[@id='qi_boq.supquotequant.2']");
	public By supplierQuotedQuantity1_CTS = By
			.xpath("(//a[contains(text(),'CTS')])[1]/../../..//input[@id='qi_boq.supquotequant.0']");
	public By supplierQuotedQuantity2_CTS = By
			.xpath("(//a[contains(text(),'CTS')])[1]/../../..//input[@id='qi_boq.supquotequant.1']");
	public By supplierQuotedQuantity3_CTS = By
			.xpath("(//a[contains(text(),'CTS')])[1]/../../..//input[@id='qi_boq.supquotequant.2']");

	public By dashboard = By.xpath("//i[@class='fa fa-laptop']");
	public By purchase_Order = By.xpath("//i[@class='fa fa-pencil-square-o title_icon']");
	public By createPOLink = By.xpath(
			"//a[@ng-click='redirectToItemVendorSelectionPage(sn.sanctionId, selectedSource, sn.sanctionGroupId)']");
	public By selectTemplateGroup = By.xpath("//select[@ng-model='selectedTemplateGroupId']");
	public By selectBidder = By.xpath("//select[@ng-model='selectedVendorForSnObj.selectedVendorForSn']");
	public By bidderOrganisationName = By.xpath("//th[contains(text(),'Bidder Organization Name')]");
	public By vendorName = By.xpath("//th[contains(text(),'Vendor Name')]");
	public By createPOButton = By.xpath("//button[@data-original-title='Create PO']");
	public By columnVisibility = By.xpath("//button[contains(@data-original-title,'Column Visibility')]");
	public By myPO = By.xpath("//a[text()='My PO']");
	public By purchaseOrderNavigtion = By.xpath("//span[text()='Purchase Order (PO)']");
	public By poListingNavigation = By.xpath("//a[contains(text(),'PO Listing')]");
	public By poSNo = By.xpath("(//table[@id='usrmntbLst']/tbody/tr/th[text()='S.No'])[1]");
	public By poNoRefNo = By.xpath("(//th[contains(text(),'PO No (Ref No)')])[1]");
	public By prRfqSn = By
			.xpath("(//th[contains(text(),'PR') or contains(text(),'RFQ') or contains(text(),'SN No')])[1]");
	public By poType = By.xpath("(//th[contains(text(),'PO Type')])[1]");
	public By poCategory = By.xpath("(//th[contains(text(),'PO Category')])[1]");
	public By items = By.xpath("(//th[contains(text(),'Item(s)')])[1]");
	public By vendorOrSupplierName = By.xpath("(//th[contains(text(),'Vendor/Supplier Name')])[1]");
	public By poValue = By.xpath("(//th[contains(text(),'PO Value')])[1]");
	public By creationDate = By.xpath("(//th[contains(text(),'Creation Date')])[1]");
	public By validity = By.xpath("(//th[contains(text(),'Validity')])[1]");
	public By source = By.xpath("(//th[contains(text(),'Source')])[1]");
	public By catalogue = By.xpath("(//th[contains(text(),'Used in Catalogue')])[1]");
	public By status1 = By.xpath("(//th[contains(text(),'Status')])[1]");
	public By editSNIcon = By.xpath("(//*[@data-icon='edit'])[1]");
	public By action1 = By.xpath("(//th[contains(text(),'Action')])[1]");
	public By purchaseOrderNavigtionIcon = By.xpath("//i[@class='fa fa-cart-arrow-down']");
	public By editPO = By.xpath("//a[text()=' Edit PO']");
	public By listDropdown = By.xpath("(//ul[@class='dropdown-menu extended logout big_actv'])[1]");
	public By cancelledPO = By.xpath("//a[text()='Cancelled/Deleted PO']");
	public By action27 = By.xpath("(//button[@id='menu1'])[27]");
	public By poNoRefNo1 = By.xpath("//table[@id='usrmntbLst']/tbody/tr[2]/td[2]");
	public By poNoRefNo2 = By.xpath("(//table[@id='usrmntbLst']/tbody/tr[2]/td[2])[2]");
	public By poNoRefNo3 = By.xpath("(//table[@id='usrmntbLst']/tbody/tr[2]/td[2])[3]");
	public By othersPO = By.xpath("//a[contains(text(),'Other')]");
	public By releasePODropDown = By.xpath("//span[contains(text(),'Release PO')]");
	public By releasePOButton = By.xpath("//button[contains(text(),'Release PO')]");

	public By POclauseNo(int i) {
		return By.xpath("(//input[@name='clause_no'])[" + i + "]");
	}

	public By POclauseName(int i) {
		return By.xpath("(//input[@name='clause_name'])[" + i + "]");
	}

	public By POclauseDetails(int i) {
		return By.xpath("(//input[@name='clause_details'])[" + i + "]");
	}

	public By poNum(String num) {
		return By.xpath("//span[text()='(" + num + ")']");
	}

	public By downloadbtndateschedule = By.xpath("//button[@data-original-title='Download']");
	public By downloadbtntermsandcond = By.xpath("(//button[@data-original-title='Download'])[2]");
	public By downloadbtntechnical = By.xpath("(//button[@data-original-title='Download'])[3]");
	public By downloadbtnboqsummary = By.xpath("(//button[@data-original-title='Download'])[4]");
	// public By uploadbtn = By.xpath("//a[@data-original-title='Upload']");
	public By uploadbtn = By.xpath("//input[@upload-event='uploadTabData']");
	public By Okbtn = By.xpath("//button[text()='OK']");
	public By uploadbtntermsandcond = By.xpath("(//input[@upload-event='uploadTabData'])[2]");
	public By uploadbtntechnical = By.xpath("(//input[@upload-event='uploadTabData'])[3]");
	public By uploadbtnboqsummary = By.xpath("(//input[@upload-event='uploadTabData'])[4]");
	public By biddingcomp = By.xpath("//span[text()='TCS']/../../td/span/label/span");
	public By addbtnvendor = By.xpath("//button[@id='addVendor']");
	public By UploadExcelSheet = By.xpath("//a[@data-original-title='Upload Tender Document']/input");

	public By previewtendertype(String option) {
		return By.xpath("//label[contains(text(),'" + option + "')]");

	}

	public By sectionsdownloadinExcel = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	public By DownloadExcelFormat = By.xpath("//button[@data-original-title='Download Template Format']");
	public By tenderPreviewEnd = By.xpath("//a[contains(text(),'View Tender')]");
	public By excelBidding = By.xpath("(//button[@class='btn btn-default dropdown-toggle'])[1]");
	public By biddownloadinExcel = By.xpath("(//button[@class='btn btn-primary'])[3]");
	public By bidSubmissionUpload = By.xpath(".//input[@id='excel-bidding-upload']");
	public By valBidStartDate = By.xpath("//*[@id='myTable']/tbody/tr/td[6]");
	public By valBidDueDate = By.xpath("//*[@id='myTable']/tbody/tr/td[7]");
	public By selectallBidder = By.xpath("//*[@id='vendorLst']/tbody/tr[1]/th[1]/span/label/span");
	public By cancelPO = By.xpath("//a[@ng-click='cancelPo(data)']");
	public By cancellationReasonBycreator = By.xpath("//textarea[@name='approvalComment']");
	public By Userdefined_po1 = By.xpath("(//input[@id='appYes'][@value='U'])[1]");
	public By pendingForCancellationApproval = By.xpath("//td[contains(text(),'Pending For Cancellation Approval')]");
	public By viewPO = By.xpath("//li[@ng-click='viewPoPreview(data)']");
	public By poDetails = By.xpath("//h3[contains(text(),'PO Detail')]");
	public By poNo = By.xpath("//b[contains(text(),'PO No')]");
	public By poRefNo = By.xpath("//b[contains(text(),'PO Ref No')]");
	public By dashboardIcon1 = By.xpath("//i[@class='fa fa-laptop']");
	public By statusFilter = By.xpath("//select[@ng-model='poStatusFilter']");
	public By editPOLink = By.xpath("//li[@ng-click='viewPo(data.epspoId,data.poGroupId)']");
	public By mandatoryFieldAlert = By.xpath("//div[contains(text(),'All Mandatory fields are required')]");
	public By AlertpopupPO = By.xpath("//div[contains(@class,'alert in')]");
	public By OtherPOBy = By
			.xpath("//*[@active='active']/child::ul/li/a[contains(text(), 'My PO')]/../following-sibling::li/a");
	public By biddersideAttachmentpreview = By.xpath("//A[contains(text(),'Attachments')]");
	public By PredifinedApprovalTypeBy = By
			.xpath("//*[@id='approvalModal']//child::div//form/child::div//input[@id='appPre'][@value='P']");

	public By commentFieldBy = By.xpath("//*[@name='approvalComment']");

	public By poSaveSuucessMsgPopUpBy = By.xpath("//*[contains(text(),'PO saved successfully.')]");

	public By poDocumentNoBy = By
			.xpath("//strong[contains(text(),'Document No :')]/following-sibling::span");

	public By poAcceptMsgPopUpBy = By.xpath("//*[text()='Purchase order successfully accepted.']");

	public By closeBtnBy = By.xpath("//div[contains(@id,'tenderApprovalModal')]//div[@class='modal-footer']/button[@ng-click='closeApprovalModal()']");
	public By closeBtnBy_PO = By.xpath("//div[contains(@id,'approvalModal')]//div[@class='modal-footer']/button[@ng-click='closeApprovalModal()']");

	public By editPOLinkBy = By.xpath("//li[@ng-click='viewPo(data.epspoId,data.poGroupId)']");

	public By poNoFieldBy = By.xpath("//*[@placeholder='PO No' and @disabled='disabled']");

	public By poCreatorNameFieldBy = By.xpath("//*[@placeholder='PO Creator Name' and @disabled='disabled']");

	public By uiTypeFieldBy = By.xpath("//*[@id='po_vendor_temp.uid_type.0']");

	public By unitPriceFieldBy = By.xpath("//*[@placeholder='Unit Price/Rate']");

	public By bidderDetailTabBy = By.xpath("//a[text()='Bidder Details']");
	public By Userdefined_po = By.xpath("//input[@id='appYes']/following-sibling::span");
	public By notRequired_po = By.xpath("//input[@id='appNo']/following-sibling::span");
	public By approvalType_Sequential = By.xpath("//input[@id='dvDes'][@value='S']");
	public By addButton = By.xpath("//button[@ng-click='addRowForApproverAppend()']");
	public By approvalConfirmPopUp = By.xpath("//div[contains(text(),'Status updated successfully!')]");
	public By confirmOk = By.xpath("//button[contains(text(),'OK')]");
	public By poStatus = By.xpath("//tbody/tr[1]/td[9]");
	public By poStatusforCanceledOrDeleted = By.xpath("//tbody/tr[1]/td[9]");
	public By deleteSN = By.xpath("//a[contains(text(),'Delete')]");
	public By cancelSN = By.xpath("//tbody/tr[1]/td[8]/div[1]/div[2]/ul[1]/li[5]/a[1]");
	public By DeleteSNReason = By.xpath("//textarea[@name='deletionRemarks']");
	public By AttachmentforSNCancellation = By.xpath("//input[@id='deleteAttachfile']");
	public By snSearch = By.xpath("(//input[@placeholder='Type any keyword'])[1]");
	public By cancelMSNReason = By.xpath("//textarea[@name='deleteReason']");
	public By poStatusFilter = By.xpath("//*[@ng-model='poStatusFilter']");
	public By poCategoryBy = By.xpath("//*[@ng-model='poCategoryFilter']");
	public By poSource = By.xpath("//*[@ng-model='filter.poSourceFilter']");
	public By msnStatus = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[6]");
	public By snStatus = By.xpath("//*[@id='_ctd_sn_completed']/div/table/tbody/tr/td[7]");
	public By draftStateStatus = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td[contains(text(),'Draft')]");
	public By AcceptedStateStatus = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td[contains(text(),'Accepted')]");
	public By PendingForAcceptanceStateStatus = By
			.xpath("//*[@id='usrmntbLst']/tbody/tr/td[contains(normalize-space(text()),'Pending for Acceptance')]");
	public By PendingForApprovalStateStatus = By
			.xpath("//*[@id='usrmntbLst']/tbody/tr/td[contains(normalize-space(text()),'Pending For Approval')]");
	public By cancelledPoSucessesPopUp = By.xpath("//div[contains(text(),'PO cancelled successfully!')]");
	public By cancelledPoTab = By.xpath("//a[contains(text(),'Cancelled PO')]");
	public By PendingForCancellationApprovalBy = By
			.xpath("//tbody/tr[2]/td[contains(text(),'Pending For Cancellation Approval')]");

	public By cancelPurchaseOrderTabBy = By.xpath("//*[contains(text(),'Cancel Purchase Order')]");

	public By PurchaseOrderTabBy = By.xpath("//*[@aria-controls='contact' and text()='Purchase Order']");

	public By PoSearchBy = By.xpath("//input[@ng-model='obj.poSearchText']");
	public By CancelledStatusBy = By.xpath("//*[@id='contact']/div/table/tbody/tr/td[contains(text(),'CANCELLED')]");
	public By selectStatus = By.xpath("//select[@ng-model='poStatusFilter']");
	public By repeatOrder = By.xpath("//a[text()='Repeat Order']");
	public By refText = By
			.xpath("//div[contains(text(),'Repeat Order has been successfully completed with Purchase Order Number')]");
	public By alertCancel = By.xpath("//div[text()='Please provide cancellation Reason first.']");
	public By poNoRefNo1Span = By.xpath("//table[@id='usrmntbLst']/tbody/tr[2]/td[2]/span");
	public By cancellationComment = By.xpath("//table[@id='usrmntbLst']/tbody/tr[2]/td[7]");
	public By searchsactionIdinPOPOButton = By.xpath("//input[@ng-model='searchFilter']");
	public By ViewPO = By.xpath("//a[text()='View PO']");
	public By View_PO_ref_NUm = By.xpath("//b[text()='PO Ref No']/../../..//span");
	public By View_PO_NUm = By.xpath("//b[text()='PO No']/../../..//span");
	public By View_PO_Value = By.xpath("//b[text()='PO Value']/../../..//span");
	public By View_PO_Amendment_flag = By.xpath("//b[text()='PO Amendment flag']/../../..//span");
	public By View_PO_Start_Date = By.xpath("(//b[text()='PO start date']/../../..//label)[2]");
	public By View_PO_Expiry_Date = By.xpath("(//b[text()='PO Expiry date']/../../..//label)[2]");
	public By View_Sanction_Note_Num = By.xpath("(//b[text()='Sanction Note No']/../../..//label)[2]");
	public By View_PO_Quotation_Code = By.xpath("(//b[text()='Quotation Reference Code']/../../..//label)[2]");
	public By View_PO_Supplier_Organization_Name = By
			.xpath("(//b[text()='Supplier Organization Name']/../../..//label)[2]");
	public By View_PO_CloseBtn = By.xpath("//button[@id='btn-po-print']/../button[text()='Close']");

	public By EditPO = By.xpath("//a[text()=' Edit PO']");
	public By Cancelbtn = By.xpath("//button[@data-original-title='Cancel']");
	public By PODeailspage = By.xpath("//i[@class='fa fa-cubes icon_document_alt']");
	public By POListingpage = By.xpath("//i[@class='fa fa-pencil-square-o title_icon']");

	public By btnReleasePO = By.xpath("//button[text()='Release PO']");

	public By ApprovalPreDefined = By.xpath("(//input[@id='appPre'])[2]");
	public By UserDefined = By.xpath("(//input[@id='appYes'])[2]");

	public By SearchPO = By.xpath("//input[@ng-model='poFilter']");

	public By AmendPo = By.xpath("//a[@data-target='#amendModal']");
	public By AmendPoComment = By.xpath("//textarea[@ng-model='amendComment']");
	public By AmendPoSubmitbtn = By.xpath("(//button[text()='Submit'])[2]");
	public By AmendSuccessmsg = By.xpath("//div[@class='bootbox-body']");
	public By AmendMsgOKbutton = By.xpath("//button[text()='OK']");

	public By ReleasePO = By.xpath("//span[text()='Release PO']");
	public By btnReleasePo = By.xpath("//button[text()='Release PO']");
	public By approvnotreq = By.xpath("(//input[@id='appNo'])[1]");
	public By approvYesreq = By.xpath("(//input[@id='appYes'])[1]");
	public By subapproval = By.xpath("//div[@id='approvalModal' and contains(@class,'scope in')]//button[normalize-space(text())='Submit']");

	public By POCancel = By.xpath("//a[@ng-click='cancelPo(data)']");
	public By PoCancelMsg = By.xpath("//textarea[@name='approvalComment']");
	public By Cancelsubmitbtn = By.xpath("//button[@ng-click='submit()']");
	public By CancelledPOTab = By.xpath("//a[text()='Cancelled PO']");
	public By recallreasonSubmit = By.xpath("//button[text()='Submit']");
	public By Recall = By.xpath("//a[@data-target='#recallModal']");
	public By RecallNotesheet = By.xpath("//a[contains(text(),'Recall')]");
	public By RecallReason = By.xpath("//textarea[@name='recallReason']");
	public By cancellationReason = By.xpath("//*[@name='cancelReasonComment']/div[2]/div[2]/div/p");
	public By cancellationReason_notesheet = By.xpath("//*[@name='cancelReason']");
	public By deleteReason_notesheet = By.xpath("//*[@name='deleteReason']");
	public By cancellationReasonComment = By.xpath("//*[@id='mytextarea']");
	public By RecallSubmit = By.xpath("//button[@ng-click='recallFn()']");
	public By recallPo = By.xpath("//*[contains(normalize-space(text()),'Recall')]");
	public By recallPoCloseButton = By.xpath("//button[contains(text(),'x')]");
	public By rejectPOLinkBy = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td/div/ul/li/a/i[@class='fa fa-ban']");
	public By poRejectBtnBy = By.xpath("//*[@ng-click='rejectPo()']/i");
	public By poStatusRejectedBy = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td[normalize-space(text())='Rejected']");
	public By btnSendforapproval = By.xpath("//button[@data-original-title='Send For Approval']");
	public By approvalType_Parallel = By.xpath("//input[@id='dvEnb'][@value='P']");
	public By minimumApproval = By.xpath("//input[@id='sequanTxt']");
	public By user3 = By.xpath("//table[@id='approver']/tbody/tr[3]/td[2]/input");
	public By coordinator3 = By.xpath("(//input[@ng-click='setCoordinator($index)'])[3]");
	public By cancelledPoSucessesPopUpApprover = By
			.xpath("//div[contains(text(),'PO Cancellation WF sent successfully!')]");
	public By cancelPurchaseOrder = By.xpath("//a[contains(text(),'Cancel Purchase Order')]");
	public By podetails = By.xpath("//div[contains(text(),'PO Details')]");
	public By Review = By.xpath("//i[@class='fa fa-arrow-left']");
	public By SelectSource = By.xpath("//select/option[text()='--Select Source--']");
	public By SelectRQF = By
			.xpath("//select/option[text()='--Select Source--']/following-sibling::option[text()='RFQ']");
	public By SelectPR = By.xpath("//select/option[text()='--Select Source--']/following-sibling::option[text()='PR']");
	public By btnApprove = By.xpath("//button[@data-original-title='Approve']");
	public By btnReview = By.xpath("(//button[@data-original-title='Approve']/../following-sibling::a)[1]");
	public By btnAbranch = By.xpath("(//button[@data-original-title='Approve']/../following-sibling::a)[2]");
	public By btndownload = By.xpath("(//button[@data-original-title='Download'])[1]");
	public By headbtns = By.xpath("//div[@class='marg_neg_round pull-right']");
	public By BranchClosebtn = By.xpath("//button[normalize-space(text())='Submit']/../button[text()='Close']");
	public By PrintPreview = By.xpath("(//a[text()='Print Preview'])[1]");
	public By MYPO = By.xpath("//a[text()='My PO']");
	public By LoadingBy_New = By.xpath("//ngx-ui-loader/div[2] //div[contains(@class, 'ngx-foreground-spinner center-center')]");
	public By LoadingBy = By.xpath("//div[@id='loading']");
	public By SummaryTab = By.xpath("//a[text()='Summary']");
	public By View_PO_Num = By.xpath("(//b[text()='PO No']/../../..//span)[1]");
	public By View_PO_VAlue = By.xpath("(//b[text()='PO Value']/../../..//span)[1]");
	public By View_PO_Amendment_Flag = By.xpath("(//b[text()='PO Amendment flag']/../../..//span)[1]");
	public By View_PO_ref_NUM = By.xpath("(//b[text()='PO Ref No']/../../..//span)[1]");
	// Arka1
	public By SNo = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[1]");
	public By PRRFQSNNo = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[2]");
	public By PONo = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[3]");
	public By POCreationDate = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[5]");
	public By CancelledPOValue = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[6]");
	public By CancelledAction = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[10]");
	public By cancellationDate = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[9]");
	public By usedInCatalogue = By.xpath("//table[@id='usrmntbLst']/tbody/tr[1]/th[8]");
	public By viewPoPreview = By.xpath("//*[@ng-click='viewPoPreview(data)']");
	public By viewPoForprint = By.xpath("//*[@ng-click='viewPoForprint(data)']");
	public By ApprovalHistory = By.xpath("//*[@ng-click='loadApproversComments(data.epspoId,data.poStatus)']");
	public By poTypeFilter = By.xpath("//*[@ng-model='poTypeFilter']");
	public By usedCatalogueFilter = By.xpath("//*[@ng-model='usedCatalogueFilter']");
	public By fullyUsed = By.xpath("//select[@ng-model='usedCatalogueFilter']/option[@label='Fully Used']");
	public By notUsed = By.xpath("//select[@ng-model='usedCatalogueFilter']/option[@label='Not Used']");
	public By partiallyUsed = By.xpath("//select[@ng-model='usedCatalogueFilter']/option[@label='Partially Used']");
	public By approvalTypeDropdownBy1 = By.xpath("(//*[@ng-model='user.approvalType'])[2]");
	public By approvalTypeDropdownBy2 = By.xpath("(//*[@ng-model='user.approvalType'])[3]");
	public By coordinatorFlagParallel = By
			.xpath("//table[@class='table table-striped table-advance table-hover']/tbody/tr[1]/td[3]//input");
	public By minApprover1Parallel = By
			.xpath("//table[@class='table table-striped table-advance table-hover']/tbody/tr[1]/td[4]//input");
	public By minApprover1Parallel2 = By
			.xpath("//table[@class='table table-striped table-advance table-hover']/tbody/tr[2]/td[4]//input");
	public By minApprover1Parallel3 = By
			.xpath("//table[@class='table table-striped table-advance table-hover']/tbody/tr[3]/td[4]//input");

	public By PoApproveDetails(int i) {
		return By.xpath("(//table[@id='myTable']//tr[@class='ng-scope']/td)[" + i + "]");
	}

	public By sendForApprovalClose = By.xpath("(//button[@ng-click='closeApprovalModal()'])[4]");
	public By preview = By.xpath("(//*[@id='usrmntbLst']/tbody/tr/td/div/ul/li/a/i[@class='fa fa-eye'])[1]");
	public By printPreview = By.xpath("(//*[@id='usrmntbLst']/tbody/tr/td/div/ul/li/a/i[@class='fa fa-eye'])[2]");
	public By poExpiryDateAlert = By
			.xpath("//div[contains(text(),'PO Expiry Date should be greater than or equal to current date!')]");
	public By PreDefinedApproversListBy = By.xpath("//*[@id='menusndApprovl']/div/table/tbody/tr");

	public By PoCancelleddateValueBy = By.xpath("(//table[@id='usrmntbLst'])[3]//tbody/tr/td[9]");
	public By predefined = By.xpath("//input[@id='appPre']");
	public By documentNumber1 = By.xpath("//form[@name='approvalForm']/table//tr/td[2]/text()");
	public By POApprovalAlertForExpiredPO = By.xpath(
			"//div[contains(text(),'PO validity is expired. Hence PO can not be approved. Please send back the PO to the initiator')]");
	public By settings = By.xpath("//span[contains(text(),'Settings')]");
	public By configurationManagement = By.xpath("//a[contains(text(),'Configuration Management')]");
	public By otherConfiguration = By.xpath("//*[contains(text(),'Other Configurations')]");
	public By itemManagementTab = By.xpath("(//*[@class='mdc-tab__content'])[2]");
	public By plusbranchIcon = By.xpath("//*[@data-icon='plus-square']");
	public By closebranchUser = By.xpath("//*[@data-icon='times']");
	public By purchaseOrderManagement = By.xpath("//a[contains(text(),'Purchase Order Management')]");
	public By defaultPOType = By.xpath("//strong[contains(text(),'Default PO Type')]");
	public By defaultPOTypeDropdown = By.xpath("//select[@ng-model='defaultPoType']");
	public By rateContractDropdown = By.xpath("(//select[@ng-change='selectPoChange()'])[1]");
	public By blanketDropdown = By.xpath("(//select[@ng-change='selectPoChange()'])[2]");
	public By plannedDropdown = By.xpath("(//select[@ng-change='selectPoChange()'])[3]");
	public By standardDropdown = By.xpath("(//select[@ng-change='selectPoChange()'])[4]");
	public By configurationManagementSave = By.xpath("(//a[@data-original-title='Save'])[8]");
	public By purchaseOrderConfigurationSucessesMessage = By
			.xpath("//div[text()='Purchase Order configuration has been successfully updated']");
	public By po_Type = By.xpath("//select[@name='po_type']");
	public By selectPOType = By.xpath("//select[@ng-model='poTypeFilter']");
	public By bidder = By.xpath("//table[@id='usrmntbLst']/tbody/tr[2]/td[7]");
	public By poStatusCancelled = By.xpath("//*[@id='usrmntbLst']/tbody/tr/td[text()='Cancelled ']");
	// public By details1 = By.xpath("(//a[contains(text(),'Details')])[2]");
	public By comment1 = By.xpath("//a[text()='Comment']");
	public By poDetails1 = By.xpath("//div[text()='PO Details']");
	public By negotiatedStatus = By.xpath("//label[contains(text(),'Negotiated')]");

	public By POTemplateGroup = By.xpath("//select[@ng-model='selectedTemplateGroupId']");
	public By Snipper = By.xpath("//div[@style='display: block;']/..//div[@class='spinner']");
	public By coordinator = By
			.xpath("//input[@type='radio' and @ng-click='radioCheckUncheck(row, $event)' and not(@checked='checked')]");
	public By approverType2_p = By.xpath("(//select[@id='filterTest'])[2]");
	public By approverTypeSN = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'])[2]");
	public By approverTypeTender = By.xpath("//*[@id='approver']/tbody//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
	public By approverTypePO = By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-invalid']");
	public By approverTypeSN_old = By.xpath("//table[@id='approver']/tbody[1]/tr//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
	public By cordinatorSN = By.xpath("//*[@id='4']/following-sibling::span");
	public By cordinatorPO = By.xpath("//*[@id='3']/following-sibling::span");
	
	public By cordinatorSN_old = By.xpath("//*[@id='4']");
		
	public By cordinatorSNclick = By.xpath("//*[@id='2']//following-sibling::span");
	public By cordinatorSN_OLD= By.xpath("//*[@id='2']");
	public By cordinatorTenderclick = By.xpath("(//*[@id='2'])[2]");
	public By cordinatorPOclick = By.xpath("//*[@id='approver']/tbody/tr[3]/td[5]/label/span");
	public By drpdwn(String id) {
		//return By.xpath("(//td[text()='" + id + "']/following-sibling::td)[6]//button[@id='menu1']");
		return By.xpath("//span[contains(text(),'" + id + "')]/parent::td//following-sibling::td[6]/div[1]/button[1]");
	}
	
	public By actionPendingSN = By.xpath("//*[@id='_ctd_sn_pending']/div/table/tbody/tr/td[7]/div/button");
	
	public By assignItem1 = By.xpath("//*[@id='approver']/tbody/tr[2]/td[7]/button[1]");
	public By assignItem2 = By.xpath("//*[@id='approver']/tbody/tr[3]/td[7]/button[1]");
	public By assignItem3 = By.xpath("//*[@id='approver']/tbody/tr[4]/td[7]/button[1]");
	
	//public By select_assign_item = By.xpath("(//*[@id='submitBidTable'])[1]/tbody/tr/td/input[@class='ng-valid ng-dirty ng-valid-parse ng-touched ng-empty']");
	public By select_assign_item(int count) {
		return By.xpath("(//table[@id='submitBidTable']/tbody[1]/tr["+count+"]//td[normalize-space()='"+count+"']//preceding-sibling::td)[1]/input");
	}
	public By saveandclose = By.xpath("//*[@id='tenderItemAssignModal']/div/div/div[2]/div/div/div[2]/button[3]");
	
	
	public By min_approverNotesheet = By.xpath("//*[@id='approver']/tbody/tr[4]/td[8]/span/input");
	public By corrdiantorNotesheet = By.xpath("//*[@id='approver']/tbody/tr[4]/td[7]/label/span");
	public By VIEW(String id) {
		return By.xpath("(//td[text()='" + id + "']/following-sibling::td)[6]//a[@ng-click='viewModal(sanction)']");
	}

	public By dwnloadSanctionReport(String id) {
		return By.xpath("(//td[text()='" + id
				+ "']/following-sibling::td)[6]//a[@ng-click='downloadSnReportModal(sanction.sanctionId)']");
	}

	public By btnRecall(String id) {
		//return By.xpath("(//td[text()='" + id+ "']/following-sibling::td)[6]//a[@ng-click='openRecallModal(sanction.sanctionId)']");
		return By.xpath("//span[contains(text(),'" + id + "')]/parent::td/following-sibling::td[6]/div[1]/ul[1]/li[4]");
	}

	public By approvdetailsvalidation(String id) {
		return By.xpath(
				"(//td[text()='" + id + "']/following-sibling::td)[6]//a[@ng-click='showApprovalDetails(sanction)']");
	}
	
	//added on 160124
	public By supplierNameBeforeSavingBidDetails(String sn) {
			return By.xpath("//td[@class='bidviewBackgroundgrey']//following-sibling::td//a[contains(text(),'" + sn + "')]");
	}
	
	public By bidviewBackgroundgrey(String sn) {
		return By.xpath("//td[@class='bidviewBackgroundgrey']//following-sibling::td//a[contains(text(),'" + sn + "')]");
	}
	
	public By supplierName(String sn) {
		return By.xpath("//a[contains(text(),'" + sn + "')]");
}
	
	//added on 160124
	public By menuSupplierBidDetails(String sn) {
			return By.xpath("//a[contains(text(),'" + sn + "')]/parent::td//following-sibling::td/div//*[@id='menu1']");
	}
	
	//added on 160124
	public By supplierBidDetails(String sn) {
			return By.xpath("(//a[contains(text(),'" + sn + "')]/parent::td//following-sibling::td/div//*[@id='menu1']//following-sibling::ul/li/a)[1]");
	}
	
	//added on 160124
	public By supplierWiseStatus(String sn) {
			return By.xpath("//a[contains(text(),'" + sn + "')]/parent::td//following-sibling::td/button");
	}
	
	//added on 160124
	public By supplierWiseDecison(String decision) {
			return By.xpath("//label[@class='radio-inline']//strong[contains(text(), '" + decision + "')]/preceding-sibling::input");
	}
	
	//TG_1 Bid details Locators
	public By copyBidText = By.xpath("//h4[contains(text(),'Please save the Bid copy')]");
	public By saveCopyBid = By.xpath("//button[@class='btn btn-primary succes_msgsnd' and contains(normalize-space(text()),'Save')]");
	public By DetailsofItemPOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Details of Items')]");
	public By DetailsofServicePOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Details of Services')]");
	public By otherPriceAttributePOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Other Price Attribute')]");
	public By VendorInformationPOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Vendor Information')]");
	public By TermsandconditionPOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Terms & Conditions')]");
	public By TechnicalSpecificationPOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Technical Specification')]");
	public By attachmentPOPreviewTab = By.xpath("//div[@class='mat-tab-label-content' and contains(normalize-space(text()),'Attachments')]");
	public By nextButtonBidDetails = By.xpath("//a[contains(text(),'Next')]");
	public By nextButtonpoPreview= By.xpath("//*[@id='nav-tab']/mat-tab-group/mat-tab-header/button[2]");
	public By nextButtonBidDetails2 = By.xpath("(//a[contains(text(),'Next')])[2]");
	public By nextarrowforTenderPreview = By.xpath("(//*[@class='mat-tab-header-pagination-chevron'])[2]");
	public By rfqItemTenderPreview = By.xpath("(//div[@class='mat-tab-label-content'])[11]");
	public By term_Condition_BidDetails = By.xpath("//li[@ng-repeat='tab in tabList']//a[contains(text(), 'Terms and Conditions')]");
	public By term_Condition_BidDetails_STG = By.xpath("//li[@ng-repeat='tab in tabList']//a[contains(text(), 'Terms And Conditions')]");
	public By evaluatorComments_term_Condition_BidDetails = By.xpath("//textarea[@id='rdcis_quotatn_trms_cnditn.Evaluator_Remarks.0']");
	public By technical_compliance_Table_BidDetails = By.xpath("//li[@ng-repeat='tab in tabList']//a[contains(text(), 'Technical Compliance Table')]");
	public By evaluatorCommentstechnical_compliance_Table_BidDetails  = By.xpath("//textarea[@id='rdcis_quotaton_tech_speci.Evaluator_Remarks.0']");
	public By RFQItem_BidDetails = By.xpath("(//a[contains(text(),'RFQ Item')])[1]");
	public By RFQItem_BidDetails_STG = By.xpath("(//a[contains(text(),'Rfq Item')])[1]");
	public By evaluatorComments_RFQItem_BidDetails  = By.xpath("//textarea[@id='rdcis_quotaton_bom_servce.Evaluator_Remarks.0']");
	public By BOQMandatory_BidDetails  = By.xpath("(//a[contains(text(),'BOQ (Mandatory)')])[1]");
	public By BOQMandatory_BidDetails_STG  = By.xpath("(//a[contains(text(),'Boq (Mandatory)')])[1]");
	public By evaluatorComments_BOQMandatory_BidDetails  = By.xpath("//textarea[@id='rdcis_quotaton_bom_supply.Evaluator_Remarks.0']");
	
	public By supplierWiseComment = By.xpath("//div[@class='form-group']/label//strong[contains(text(), 'Comment')]/parent::label//following-sibling::textarea");
	public By decisionSave = By.xpath("(//div[@class='modal-footer']//button[contains(text(), 'Save')])[1]");
	public By decisionSaveAlert = By.xpath("//strong[contains(text(),'Decision successfully saved.')]");
	public By decisionSaveAlertClose = By.xpath("//body/section[@id='container']/strong[1]/div[3]/div[1]/div[1]/div[3]/button[1]");
	public By clickSaveButton = By.xpath("//body/section[@id='container']/strong[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[4]");
	public By clickSaveButton_New = By.xpath("//button[contains(@ng-click, 'saveOrUpdateEvaluation')]");
	public By clickCloseAlertButton = By.xpath("//button[@ng-click='clearAlertMessages()'][normalize-space()='Close']");
	public By closeBidDetails = By.xpath("//body/section[@id='container']/strong[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[5]");
	public By closeBidDetails_New = By.xpath("//button[contains(@ng-click, 'OrUpdateEvaluation')]/following-sibling::button[contains(@ng-click, 'loadValidationInfoByBidder')]");
	
	public By negotiationAction = By.xpath("//*[@id='menu6']");
	
	public By SubmitFromPreview = By.xpath("//button[@ng-if='submitForApproval']");
	public By SubmitFromPreview_Backup = By.xpath("//*[@class='btn modalBtnBlue' and text()='Submit']");
	public By sendForApprovalNotRequired = By.xpath("//input[@id='appNo']/parent::label/span");
	public By sendForApprovalNotRequired_SN = By.xpath("//form[contains(@class,'ng-valid')]//input[@id='appNo']/parent::label/input");
	public By DOPstatus = By.xpath("//td[text()='pooja']/following-sibling::td[2]");

	public By AcceptedorRejected(String id) {
		return By.xpath("(//td[text()='" + id
				+ "']/following-sibling::td)[5]//button[@data-original-title='Accepted/Rejected']");
	}

	public By ApprovalPendingSN(String id) {
		return By.xpath("(//td[text()='" + id
				+ "']/following-sibling::td)[5]//button[@data-original-title='Pending for approval']");
	}

	public By DraftStatus(String id) {
		return By.xpath("(//td[text()='" + id + "']/following-sibling::td)[5]//button[@data-original-title='Draft']");
	}
	// precondition locators for SN
	// Arka

	public By TenderClauseField(int i) {
		return By.xpath("(//input[@placeholder='Clause'])[" + i + "]");
	}

	public By TenderClauseDetailsField(int i) {
		return By.xpath("(//textarea[@name='details'])[" + i + "]");
	}

	public By TenderTechnicalClauseField(int i) {
		return By.xpath("(//*[starts-with(@id, 'rh_techcompl.clause')])[" + i + "]");
	}

	public By TenderTechnicalDetailsField(int i) {
		return By.xpath("(//*[contains(@class, 'rh_techcompl.details')])[" + i + "]");
	}

	public By boqOptionalSupQuoteQuantBy = By.xpath("//*[@id='qi_boqoptional.supquotequant.0']");

	public By bidderSpecAttachmentBy = By.xpath("//*[text()='Bidder Specific Attachment']");

	public By bidderSpecAttachmentUploadBy = By.xpath(
			"//button[@class='btn btn-primary dropdown-toggle' and @data-btn-row='BidPart1']/following-sibling::ul/li/a");

	public By tenderAttachmentBy = By.xpath("//*[text()='Tender Attachment']");

	public By attachmentLabelFieldBy = By.xpath("//*[@id='authorsList']/tbody/tr[2]/td[1]/input");

	public By boqSuppQuoteQtyBy = By.xpath("//*[starts-with(@class,'form-control qi_boq.supquotequant')]");

	public By LiveTenderRecordsBy = By.xpath("(//*[@id='Live']//child::table//tbody/tr)[1]");

	public By technicalTabFileuploadEleBy = By.xpath("//*[@id='qh_techcompl-attach_file-0-download-icon']");

	public By termsAndConditionsClauseBy = By.xpath("//*[@id='_qh_termsnconditons']//table/thead/tr/th[2]");

	public By boqOptionalAddOptionalBy = By.xpath("//button[@data-target='#addOptionalItemModal_qi_boqoptional']");

	public By SpinnerHolderBy = By.xpath("//div[@id='spinnerholder']");
	public By SpinnerHolderByNegotiation = By.xpath("//*[@id='spinnerholder']/div[1]");

	public By disabledDecryptBidderDataBtnBy = By
			.xpath("//button[@ng-click='decryptBidderData()'][@disabled='disabled']");

	public By SpinnerHolderContainerIdTextBy = By
			.xpath("//*[@id='container']//div[@class='spinner-text ng-binding' and text()='Please Wait...']");

	public By excelBiddingFieldEleBy = By.xpath("//*[contains(text(),'Excel Bidding')]");

	public String editpencilIconEleBy = "//*[contains(normalize-space(text()),'{0}')]//following-sibling::td/button[contains(@ng-click,'editBidderStatus')]";

	public By itemCodeElement(int i) {
		return By.xpath("(//*[text()='Item Code'])[" + i + "]");
	}

	public By documentChargeFieldEleBy = By.xpath("//strong[contains(text(),'Packing & Documentation Charge ')]");

	public By body_overallcomment = By.xpath("//body[@id='tinymce']");
	public By Biddername = By.xpath("(//h5[@class='panel-title'])[1]/a");
	public By l1RankEleBy = By.xpath("//*[@id='approvedSupplier']/div//table/tbody/tr[1]/td/span[contains(text(),'L 1')]");

	public By ApproversupplierTabBy = By.xpath("//*[@aria-controls='approvedSupplier' or text()='Approved Supplier']");

	public By rejectedsupplierTabBy = By
			.xpath("//*[@aria-controls='rejectedSupplier' or text()='Rejected and Not-participated supplier']");

	public By rejectedsupplierBy = By.xpath("//*[@id='rejectedSupplier']/div/div/div/table/tbody/tr");

	public By sanctionNoteSummaryTabBy = By.xpath("//a[text()='Summary']");

	public By sanctionNotePrintViewTabBy = By.xpath("//a[text()='Print Preview']");

	public By sanctionAcceptedStageEleBy = By
			.xpath("//*[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 yellowBtn grnBtn']");

	public By SummaryTabCtsBy = By.xpath(
			"//span[contains(text(),'Bidder Wise List')]/../following-sibling::div/child::div//a[contains(text(),'CTS')]");

	public By SummaryTabTcsBy = By.xpath(
			"//span[contains(text(),'Bidder Wise List')]/../following-sibling::div/child::div//a[contains(text(),'TCS')]");
	public By approvalDetailsValidation = By
			.xpath("//table[@id]/tbody/tr[3][contains(@ng-repeat,'approval.approvalDetails')]");
	public By approvalDetailsWindow = By.xpath("//h3[text()='Approval Details']");
	public By sendForApproval_Close = By.xpath("(//button[@ng-click='closeApprovalModal()'])[2]");

	public By itemQuantity1 = By.xpath("(//input[@name='item_qty'])[1]");
	public By itemQuantity2 = By.xpath("(//input[@name='item_qty'])[2]");
	public By itemQuantity3 = By.xpath("(//input[@name='item_qty'])[3]");

	public By OPOSNO = By.xpath("(//table[@id='usrmntbLst']/tbody/tr[1]/th[text()='S.No'])[2]");
	public By OpoNoRefNo = By.xpath("(//th[contains(text(),'PO No (Ref No)')])[2]");
	public By OprRfqSn = By
			.xpath("(//th[contains(text(),'PR') or contains(text(),'RFQ') or contains(text(),'SN No')])[2]");
	public By OpoType = By.xpath("(//th[contains(text(),'PO Type')])[2]");
	public By OpoCategory = By.xpath("(//th[contains(text(),'PO Category')])[2]");
	public By Oitems = By.xpath("(//th[contains(text(),'Item(s)')])[2]");
	public By OvendorOrSupplierName = By.xpath("(//th[contains(text(),'Vendor/Supplier Name')])[2]");
	public By OpoValue = By.xpath("(//th[contains(text(),'PO Value')])[2]");
	public By OcreationDate = By.xpath("(//th[contains(text(),'Creation Date')])[2]");
	public By Ovalidity = By.xpath("(//th[contains(text(),'Validity')])[2]");
	public By Osource = By.xpath("(//th[contains(text(),'Source')])[2]");
	public By Ocatalogue = By.xpath("(//th[contains(text(),'Used in Catalogue')])[2]");
	public By Ostatus = By.xpath("(//th[contains(text(),'Status')])[2]");
	public By Oaction = By.xpath("(//th[contains(text(),'Action')])[2]");

	public By DOPstatusPO(String DOP) {
		return By.xpath("//td[text()='" + DOP + "']/following-sibling::td[2]");
	}

	public By selectDopStatusBy = By.xpath("//*[@ng-model='dop.status']");

	public By headerInformation = By.xpath("(//span[@class='ng-binding'])[2]");
	public By shippingInformation = By.xpath("(//span[@class='ng-binding'])[3]");

	public By Warningmsg = By.xpath("//div[@class='bootbox-body']");
	public By Acceptwarinigmsg = By.xpath("//button[@data-bb-handler='ok']");
	public By cancelledPOAction = By.xpath(
			"//li[contains(@class,'ng-isolate-scope active')]/..//following-sibling::div//*[@id='usrmntbLst']/tbody/tr[2]/td[10]/div/button");

	public By cancelledPOActionDropdownElementsBy = By.xpath(
			"//li[contains(@class,'ng-isolate-scope active')]/..//following-sibling::div//*[@id='usrmntbLst']/tbody/tr[2]/td[10]/div/button/following-sibling::ul");

	public By otherPoActionMenuBy = By.xpath(
			"//li[contains(@class,'ng-isolate-scope active')]/..//following-sibling::div//*[@id='usrmntbLst']/tbody/tr[2]/td[14]/div/button");

	public By otherPoActionMenuElementsBy = By.xpath(
			"//li[contains(@class,'ng-isolate-scope active')]/..//following-sibling::div//*[@id='usrmntbLst']/tbody/tr[2]/td[14]/div/button/following-sibling::ul");
	public By addTermsAndCondition = By
			.xpath("(//button[@ng-click='addRowForDynamicTabularTemplate(templateShortName)'])[2]");
	public By SummaryTabBidderDetailsBy = By.xpath("//div[contains(text(),'Bidder Details')]");

	public By SummaryTabItemDetailsBy = By.xpath("//div[contains(text(),'Item Details')]");

	public By SummaryTabTermsAndCondDetailsBy = By.xpath("//div[contains(text(),'Terms and Conditions')]");

	public By itemcodeQty(int no) {
		return By.xpath("//*[@id='preview']/div/div[4]/table/tbody/tr[" + no + "]/td[4]");
	}

	public By termsClauseNames(int no) {
		return By.xpath("//*[@id='preview']/div/div[5]/table/tbody/tr[" + no + "]/td[2]");
	}

	public By ApprovalCommentHistoryBtnBy = By.xpath("//*[@ng-show='approvalCollapse']/child::i");

	public By userNameColumnSeqBy = By.xpath("//*[@id='reloadMe']/table/tbody/tr/td[position()=1]/span");

	public By userNameStatusSeqBy = By.xpath("//*[@id='reloadMe']/table/tbody/tr/td[4]");
	public By allNotesheet = By.xpath("//*[contains(text(),'All Notesheets')]");
	public By notesheetListPage = By.xpath("//h2[contains(text(),'Notesheet List ')]");
	public By LOAListPage = By.xpath("//li[contains(text(),'LOA List')]");
	public By viewSanction = By.xpath("//*[contains(normalize-space(text()),'View Sanction')]");
	public By repeatOrderPO = By.xpath("//*[contains(normalize-space(text()),'Repeat Order')]");
	public By amendItemSNPreview = By.xpath("//*[@id='collapse2']/app-n-column-template-sanction/div/div/table/tbody/tr[1]/td/div/div[6]/div[2]/span");
	public By amendSN = By.xpath("//*[contains(normalize-space(text()),'Amend SN')]");
	public By amendMSN = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[6]");
	public By amendPO = By.xpath("//*[contains(normalize-space(text()),'Amend Order')]");
	public By amendqtyInPo = By.xpath("//*[@id='_po_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr[1]/td[6]/div/span");
	public By amendReason = By.xpath("//*[@id='amendmentReason']");
	public By amendReasonMSN = By.xpath("//textarea[@ng-model='amendmentReason']");
	public By POamendReason = By.xpath("//textarea[@name='desc']");
	public By amendattachment = By.xpath("//*[@id='amendAttachfile']");
	public By tenderIdInSanctionPreview = By.xpath("//*[@id='collapse1']/app-n-column-template-sanction/div/div/div/div/div[1]/fieldset/div");
	public By suppierNameSNPreview = By.xpath("(//div[@data-bs-toggle='collapse' and @class='collapseTitle d-flex justify-content-between align-items-center parent_class'])[1]");
	public By TenderDescriptionSNPreview = By.xpath("//*[@id='collapse1']/app-n-column-template-sanction/div/div/div/div/div[2]/fieldset/div");
	public By pacSNPreview = By.xpath("//*[@id='collapse1']/app-n-column-template-sanction/div/div/div/div/div[3]/fieldset/div");
	public By boqQty1SNPreview = By.xpath("//*[@id='collapse2']/app-n-column-template-sanction/div/div/table/tbody/tr[1]/td/div/div[5]/div[2]/span");
	public By boqQty2SNPreview = By.xpath("//*[@id='collapse2']/app-n-column-template-sanction/div/div/table/tbody/tr[2]/td/div/div[5]/div[2]/span");
	public By rfqQty1SNPreview = By.xpath("//*[@id='collapse3']/app-n-column-template-sanction/div/div/table/tbody/tr[1]/td/div/div[5]/div[2]/span");
	public By rfqQty2SNPreview = By.xpath("//*[@id='collapse3']/app-n-column-template-sanction/div/div/table/tbody/tr[2]/td/div/div[5]/div[2]/span");

	public By ClauseSubClauseNoSNPreview = By.xpath("//*[@id='collapse4']/app-n-column-template-sanction/div/div/table/tbody/tr/td/div/div[2]/div[2]/span");
	public By ClauseSubClauseTitleSNPreview = By.xpath("//*[@id='collapse4']/app-n-column-template-sanction/div/div/table/tbody/tr/td/div/div[3]/div[2]/span");
	
	public By TCClauseSubClauseNoSNPreview = By.xpath("//*[@id='collapse5']/app-n-column-template-sanction/div/div/table/tbody/tr/td/div/div[2]/div[2]/span");
	public By TCClauseSubClauseTitleSNPreview = By.xpath("//*[@id='collapse5']/app-n-column-template-sanction/div/div/table/tbody/tr/td/div/div[3]/div[2]/span");
	

	public By ameendSNSubmit = By.xpath("(//button[@type='button' and @class='btn modalBtnBlue mx-2 mb-2 mb-sm-0'])[3]");
	public By ameendPOSubmit = By.xpath("(//button[@type='button' and @class='btn modalBtnBlue mx-2 mb-2 mb-sm-0'])[1]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public By CommentColumnSeqBy = By.xpath("//*[@id='reloadMe']/table/tbody/tr/td[5]");
	public By POStatus = By
			.xpath("//*[@id='usrmntbLst']/tbody/tr/td[contains(normalize-space(text()),'Pending For Approval')]");
	public By repeatordernotexpired = By.xpath(
			"//span[contains(@time-countdown,'data.poExpiryDt') and (contains(text(),'days'))]/..//following-sibling::td//button[@data-toggle='dropdown']");
	public By btnrepeatorder = By.xpath(
			"(//span[contains(@time-countdown,'data.poExpiryDt') and (contains(text(),'days'))]/..//following-sibling::td//button[@data-toggle='dropdown'])[1]/following-sibling::ul//li//a[text()='Repeat Order']");
	public By btnBranch = By.xpath("(//button[@data-original-title='Approve']/../following-sibling::a)[2]/button");

	public By BranchUSer1Btn(String username) {
		return By.xpath("//span[text()='" + username + "']/../following-sibling::td//i");
	}

	public By BranchUser1Remarks = By.xpath("//textarea[@ng-model='user.comment']");
	public By BranchBtnSubmit = By.xpath("//button[@id='btn-prevOk']");
	public By BranchSuccessMsg = By.xpath("//div[@class='bootbox-body']");
	public By BranchSuccesMsgClose = By.xpath("//button[text()='OK']");
	public By cancellationReasonAlert = By.xpath("//div[contains(text(),'Please provide cancellation Reason first')]");
	public By sendForApproval1 = By.xpath("//button[@ng-click='sendForApproval(approvalObj.workflowType)']");
	public By POCancelSuccesMsg = By.xpath("//div[contains(text(),'PO Cancellation WF sent successfully!')]");
	public By notRequiredClose = By.xpath("//button[@ng-click='submit()']");
	public By confirmDOPMSG = By.xpath("//button[text()='OK']");
	public By confirmDOP = By.xpath("//button[@data-bb-handler='confirm']");

	public By approvuserdefin = By.xpath("(//input[@name='chkApproval'])[2]");
	public By sequentialCancelorder = By.xpath("(//input[@name='sequanLabrd'])[1]");
	public By adduserapprove = By.xpath("//button[@id='addApprovertc']");
	public By approverList1 = By.xpath("//input[@list='approvaerList']");
	public By approverList2 = By.xpath("(//input[@list='approvaerList'])[2]");
	public By SendForAptovalbtn = By.xpath("//button[@id='dyantc']");
	public By branchUser = By.xpath("//h3[contains(text(),'Branch User')]");
	public By branchUpload = By.xpath("//input[@upload-event='branchUploadEvent']");
	public By sendBackButton = By
			.xpath("//button[@class='btn btn-icon btn-primary btn-circle btn-lg' or @data-original-title='Send Back']");
	public By sendBackSucessMsg = By.xpath("//div[contains(text(),'Send Back successfully completed.')]");
	public By branchSectionApproverComment = By.xpath("//strong[contains(text(),'Branch Section Approver Comment')]");
	public By sendBackToApproverStatus = By.xpath("//td[contains(text(),'Send Back To Approver')]");
	public By sendBackToApproverStatus1 = By.xpath("//button[contains(text(),'Approver')]");
	public By notRequired = By.xpath("//div[@class='radio-group workflowType']//label/input[@id='appNo']");
	public By itemQuantity01 = By.xpath("//input[@id='po_temp_v1.item_qty.0']");
	public By itemQuantity02 = By.xpath("//input[@id='po_temp_v1.item_qty.1']");
	public By itemQuantityalertMsgPopUp = By.xpath("//div[text()='Quantity not more than main quantity!']");
	public By removeBranchUser = By.xpath("//button[@class='btn btn-default btn-sm']");
	public By removeBranchUserSuccessfulMessage = By
			.xpath("//div[contains(text(),'Assigned user successfully removed.')]");
	public By minApproverRequired = By.xpath("//input[@id='sequanTxt']");
	public By parallelCoordinatorFlag = By.xpath("//table[@id='approver']/tbody/tr[2]//input[@name='coordinator']");
	public By minApproverAlert = By
			.xpath("//div[text()='Please enter minimum 2 approver for parallel type approval.']");
	public By approver1Comment = By.xpath("//*[@id='reloadMe']/table/tbody/tr[2]/td[position()=5]");
	public By POapproverComment = By.xpath("//*[@id='reloadMe']/table/tbody/tr[4]/td[position()=5]");
	public By approvalStatusPending = By.xpath("//option[text()='Pending']");
	public By approvalStatusCompleted = By.xpath("//option[text()='Completed']");
	public By StatusDraft = By.xpath("//td[normalize-space(text())='Draft']");
	public By StatusRejectedByapprover = By.xpath("//a[text()='(Rejected by approver)']");
	public By PrintPreviewClose = By.xpath("//div[@id='poPrintPrevModal']//button[text()='Close']");
	public By ItemQtyPopUpValidationBy = By.xpath("//*[text()='Quantity not more than main quantity!']");
	public By backToPreviousApprover = By.xpath("(//a[contains(text(), 'Review Back to Previous Approver')])[2]");
	public By reverseBackApproverBy = By.xpath(" //*[contains(text(),' Reverse back to approver')]");
	public By coordinatorFlagParallel_vamshi = By
			.xpath("//table[@class='table table-striped table-advance table-hover']/tbody/tr[3]/td[3]//input");

	// ****************************Auction
	// locators********************************
	public By btnParticipate = By.xpath("//a[normalize-space(text())='Participate']");
	public By btnAuction = By.xpath("//span[text()='Auction']");
	public By tabPARTICiPATE = By.xpath("//a[normalize-space(text())='PARTICIPATE']");
	public By tabLIVE = By.xpath("//a[normalize-space(text())='LIVE']");

	public By BidSubmission = By.xpath("(//input[@type='text'])[1]");
	public By MarketPrice = By.xpath("//div[contains(text(),'Market Price')]/..");
	public By StartPrice = By.xpath("//div[contains(text(),'Start Price')]/..");
	public By Currency = By.xpath("//div[contains(text(),'Currency')]/..");
	public By Quantity = By.xpath("//div[contains(text(),'Quantity')]/..");
	public By MyLastBid = By.xpath("//div[contains(text(),'My Last Bid')]/..");
	public By Decrement = By.xpath("//div[contains(text(),'Decrement')]/..");
	public By auction = By.xpath("//span[contains(text(),'Auction')]");
	public By home = By.xpath("//a[contains(text(),'Home')]");
	public By postAuction = By.xpath("//span[contains(text(),'Post Auction')]");
	public By action_Dropdown = By.xpath("//div[@id='appId']//table//tbody//tr[1]//td[10]");
	public By releaseLink = By.xpath("//a[contains(text(),'Release')]");
	public By releasedAuction = By.xpath("//a[contains(text(),'RELEASED AUCTION')]");
	public By auctionSummaryReport = By.xpath("//a[contains(text(),'Auction Summary Report (PDF)')]");
	public By releaseConfirmYes = By.xpath("//button[contains(text(),'Yes')]");
	public By releaseConfirmSucessesMsgOk = By.xpath("//button[contains(text(),'OK')]");
	public By filter = By.xpath("//label[contains(text(),'FILTER')]");
	public By auctionSearch = By.xpath("//input[@id='generalSearch']");
	public By intiateAuctionMenuLinkBy = By.xpath("//*[contains(text(),'Initiate Auction')]");

	public By popupInitiateAuctonBtnBy = By
			.xpath("//*[@id='initiateAuction']//button[contains(text(),'Initiate auction')]");

	public By AuctionTypeSelectBy = By.xpath("//*[@name='auctionTypeId0']");

	public By AuctionTypeBiddingSelectBy = By.xpath("//*[@name='auctionBiddingTypeId0']");

	public By templateFieldSelectBy = By.xpath("//*[@name='templateField0']");

	public By itemCodeSelectBy = By.xpath("//*[@name='itemCode0']");

	public By itemCodeDescSelectBy = By.xpath("//*[@name='itemDescription0']");

	public By uomSelectBy = By.xpath("//*[@name='uom0']");

	public By QuantitySelectBy = By.xpath("//*[@name='qty0']");

	public By startBidPriceSelectBy = By.xpath("//*[@name='startBidPrice0']");

	public By viewEventBy = By.xpath("//button[text()='View Event']");

	public By setUpAction(int no) {
		return By.xpath("(//span[text()='Draft']/../following-sibling::td/child::button[text()='SET UP AUCTION '])["
				+ no + "]");
	}

	public By reserverevePriceFiledBy = By.xpath("//input[@id='reservePrice']");

	public By changePriceFiledBy = By.xpath("//input[@name='changePrice']");

	public By priceMultipleFiledBy = By.xpath("//select[@name='priceMultiple']");

	public By observersAddFiledBy = By.xpath("//*[@ng-click='openObserverModal();']/span/i[@class='la la-plus']");

	public By ObserversBy = By.xpath("//*[contains(text(),'TEST_AUTOMATION_SUPER_ADMIN')]");

	public By selectObserverAddBy = By.xpath("//*[@ng-click='selectObservers();']");

	public By saveScheduleBy = By.xpath("//*[contains(text(),'SAVE AND SCHEDULE')]");

	public By AuctionSavedSucessMsgBy = By.xpath("//*[text()='Auction has been saved successfully!']");

	public By publishEventBtnBy = By.xpath("//*[@id='publishEventId']");

	public By confirmationPublishEventYesBy = By.xpath(
			"//*[text()='Are you sure you want to publish the event?']/../following-sibling::div/child::button[text()='Yes']");

	public By sucessMsgForPublishEventByBy = By.xpath("//*[text()='Event has been published successfully!']");

	public By eventstartDate = By.xpath(
			"//span[text()='Draft']/..//preceding-sibling::td/child::div/child::input[@placeholder='Select start date & time']");

	public By eventEndDate = By.xpath(
			"//span[text()='Draft']/..//preceding-sibling::td/child::div/child::input[@placeholder='Select end date & time']");

	public By saveScheduleActivateBtnBy = By.xpath("//*[normalize-space(text())='SAVE SCHEDULE & ACTIVATE']");

	public By auctionactivatedSucessmsgBy = By
			.xpath("//*[normalize-space(text())='All Auctions have been activated successfully!']");

	public By AcivateStatusBy = By.xpath("//*[@id='scheduleListId']/tr/td[8]/span[text()='Active']");

	public By startDateTime = By.xpath(
			"//*[@id='scheduleListId']/tr/td[8]/span[text()='Active']/../preceding-sibling::td/input[@placeholder='Select start date & time']");

	public By endDateTime = By.xpath(
			"//*[@id='scheduleListId']/tr/td[8]/span[text()='Active']/../preceding-sibling::td/input[@placeholder='Select end date & time']");

	public By userpicBy = By.xpath("//*[@id='m_header_topbar']//span[@class='m-topbar__userpic']");

	public By LogoutBy = By.xpath("//*[@id='m_header_topbar']//ul/li/a[contains(text(),'Logout')]");

	public By yesForLogoutBy = By.xpath(
			"//*[text()='Are you sure you want to logout?']/../following-sibling::div/child::button[text()='Yes']");

	public By saveEventDetailsBy = By
			.xpath("//*[contains(text(),'SAVE AND SCHEDULE')]/following-sibling::button[contains(text(),'SAVE')]");

	public By backToEpsBy = By.xpath("//*[@id='m_ver_menu']//span[contains(text(),'Back to EPS')]");

	public By ConfirmYesForBackToEpsBy = By.xpath(
			"//*[text()='Are you sure you want to back to EPS?']/../following-sibling::div/child::button[text()='Yes']");

	public By EventMsgAlreadyExistBy = By.xpath("//*[text()='Event already exist!']");

	public By auctionRuleFiledBy = By.xpath("//select[@ng-model='auctionRule']");

	public By selectDraftCheckBox(int no) {
		return By.xpath("(//span[text()='Draft']/../preceding-sibling::td/child::input[@type='checkbox'])[" + no + "]");
	}

	public By ClickonStartDateField = By.xpath("//div[@id='m_datetimepicker_1_1']");
	public By todayStartdate = By.xpath("(//td[@class='day today active'])[1]");

	public By Currency(String price) {
		return By.xpath(" (//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../preceding-sibling::div)[1]//div[text()='Currency:']/..");
	}

	public By BtnBackToEPS = By.xpath("(//span[normalize-space(text())='Back to EPS'])[2]");
	public By ConfirmBackYes = By.xpath("//button[text()='Yes']");

	public By Quantity(String price) {
		return By.xpath(" (//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../preceding-sibling::div)[1]//div[text()='Quantity:']/..");
	}

	public By MyLastBid(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//span/input");
	}

	public By Decrement(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price + "']");
	}

	public By Submit(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//button[text()='Submit']");
	}

	public By SubsVal(String price) {
		return By.xpath("(//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//a)[2]");
	}

	public By startDate(String date) {
		return By.xpath("//div[text()='Start Time:']/../../div[text()='" + date + "']");
	}

	public By ActiveAuction(String date) {
		return By.xpath("//div[text()='Start Time:']/../../div[text()='" + date
				+ "']/following-sibling::div/button[text()='Accept']");

	}

	public By BidSubmission(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//span/input");
	}

	public By MarketPrice(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price + "']/following-sibling::div");
	}

	public By details(String price) {
		return By.xpath("(//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//button[contains(text(),'Detail')])");
	}

	public By price1 = By.xpath("//tbody[@id='auctionItemListId']//tr[1]//td[5]//input");
	public By price2 = By.xpath("//tbody[@id='auctionItemListId']//tr[2]//td[5]//input");
	public By price3 = By.xpath("//tbody[@id='auctionItemListId']//tr[3]//td[5]//input");
	public By calculateTotal = By.xpath("//button[@id='calculateBidValue']");
	public By submitBidValue = By.xpath("//button[@id='submitBidValue']");
	public By reservePriceValidationBy = By.xpath("//*[@ng-show='isReverseAuctionReservePriceValidation']");

	public By startPriceFiledBy = By.xpath("//*[@id='startPriceId']");

	public By user1auctionBy = By.xpath("//*[@id='auctionUserCheck_1']");

	public By user2auctionBy = By.xpath("//*[@id='auctionUserCheck_0']");
	public By viewButton = By.xpath("//button[contains(text(),'View')]");
	public By termsAndConditions = By
			.xpath("//div[@id='defaultTextAttchment']//span[text()='General Terms and Conditions']");
	public By closeTNC = By.xpath("//button[@id='closeDefaultTextViewModal']");

	public By actionMenuintiateAuctionlinkBy(String id) {
		return By.xpath("//td[contains(@title,'" + id
				+ "')]//parent::tr//td[7]//a[normalize-space(text())='Initiate auction']");
	}

	public By BidPrice(String price) {
		return By.xpath("(//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//span/input)[2]");
	}

	public By customizedTermsCondtionRadio = By.xpath("//input[@id='materialChecked2']");
	public By file_Name = By.xpath("//input[@id='fileName']");
	public By browseFile = By.xpath("//input[@id='file2']");
	public By uploadFile = By.xpath("//button[contains(text(),'Upload')]");
	public By uploadFileConfirmOk = By.xpath("//button[contains(text(),'OK')]");
	public By auctionListForController = By.xpath("//span[contains(text(),'Auction List for Controller')]");
	public By auctionList = By.xpath("//h3[contains(text(),'AUCTION LIST')]");
	public By observer = By.xpath("//a[contains(text(),'Observe')]");

	public By startPrice(String price) {
		return By.xpath("(//div[contains(text(),'Decrement')]/../../div[text()='" + price + "']/../div)[1]");
	}

	public By AuctionListForController = By.xpath(" //span[normalize-space(text())='Auction List for Controller']");

	public By StopAuction(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div[2]//a[normalize-space(text())='Stop']");
	}

	public By Confirmationmessagepopup = By.xpath("//h2[@id='swal2-title']");

	public By YesToStop = By.xpath("//button[text()='Yes']");

	public By SuccessConfirmation = By.xpath("//div[@id='swal2-content']");

	public By OKMessagebtn = By.xpath("//button[text()='OK']");

	public By AuctionListPage = By.xpath("//*[normalize-space(text())='AUCTION LIST']");

	public By Actionbtn(String price) {
		return By.xpath("//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div[2]//a[@data-toggle='dropdown']");
	}

	public By ActionDrpdwn = By.xpath("//a[@data-toggle='dropdown']");

	public By TenderRefNum(String refnum) {
		return By.xpath("//span[text()='" + refnum + "']");
	}

	public By HArdStoptext(String refNum) {
		return By.xpath("//span[text()='" + refNum + "']/..//following-sibling::td[7]/span");
	}

	public By ReleaseTab = By.xpath("//a[normalize-space(text())='RELEASED AUCTION']");

	public By Relaunch = By.xpath("//a[normalize-space(text())='Relaunch']");

	public By RemarksForRelaunch = By.xpath("//textarea[@id='relaunchRemarks']");

	public By RelaunchBtn = By.xpath("//button[normalize-space(text())='Relaunch']");

	public By Startminutes(String i) {
		return By
				.xpath("//html/body/div[3]/div[1]/table/tbody/tr/td/span[contains(@class,'minute') and contains(text(),'"
						+ i + "')]");
	}

	public By Endminutes(String i) {
		return By
				.xpath("//html/body/div[4]/div[1]/table/tbody/tr/td/span[contains(@class,'minute') and contains(text(),'"
						+ i + "')]");
	}

	public By BidTrailReport = By.xpath("//a[normalize-space(text())='Bid Trail Report (PDF)']");

	public By RejectedBidTrailReport = By.xpath("//a[normalize-space(text())='Rejected Bid Trail Report (PDF)']");

	public By lead(String price) {
		return By.xpath(
				"(//div[contains(text(),'Decrement')]/../../div[text()='" + price + "']/following-sibling::div)[2]");
	}

	public By rank(String Decrement) {
		return By.xpath("//div[text()='" + Decrement + "']/../div[text()='Rank: 1']");
	}

	public By observe = By.xpath("//a[contains(text(),'Observe')]");

	public By SNstage(String Id) {
		return By.xpath("//td[text()='" + Id + "']/../td//button[@id='clrcookie']");
	}

	public By pauseTimeFieldBy = By.xpath("//*[@id='pauseTime']");

	public By resumeTimeFieldBy = By.xpath("//*[@id='resumeTime']");

	public By extendedTimeFieldBy = By.xpath("//*[@id='extendedDate']");

	public By eventPagedropDownBy = By.xpath("//*[@data-toggle='dropdown']");

	public By eventPagedropDownField = By.xpath("(//*[@data-toggle='dropdown'])[1]");

	public By saveAndActivateFieldBy = By.xpath("//a[contains(text(),'Save & Activate')]");

	public By startPriceValidationBy = By.xpath("//span[@id='startPriceValidationRA']");

	public By auctionactivatedSuccessmsgBy = By
			.xpath("//*[normalize-space(text())='Auction has been activated successfully!']");

	public By DutchRuleMarketPrice(String price) {
		return By.xpath("//div[contains(text(),'Price Change')]/../../div[text()='" + price
				+ "']//following-sibling::div/child::div[contains(text(),'Market Price')]");
	}

	public By DutchRuleStartPrice(String price) {
		return By.xpath("//div[contains(text(),'Price Change')]/../../div[text()='" + price
				+ "']/../../preceding-sibling::div//child::div[contains(text(),'Start Price:')]");
	}

	public By DutchRuleSubmitBidPrice(String price) {
		return By.xpath("//div[contains(text(),'Price Change')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//button[text()='Submit']");
	}

	public By DutchRuleNewBidPrice(String price) {
		return By.xpath("//div[contains(text(),'Price Change')]/../../div[text()='" + price
				+ "']/../../../following-sibling::div//child::span/input[starts-with(@id,'newBid')]");
	}

	public By DutchAcivateStatusBy = By.xpath("//*[@id='scheduleListId']/tr/td[9]/span[text()='Active']");

	public By DutchstartDateTime = By.xpath(
			"//*[@id='scheduleListId']/tr/td[9]/span[text()='Active']/../preceding-sibling::td/input[@placeholder='Select start date & time']");

	public By DutchendDateTime = By.xpath(
			"//*[@id='scheduleListId']/tr/td[9]/span[text()='Active']/../preceding-sibling::td/input[@placeholder='Select end date & time']");

	public By Starthour(String i) {
		return By.xpath("((//span[contains(@class,'hour') and starts-with(text(),'" + i + "')]))[1]");
	}

	public By Endhour(String i) {
		return By.xpath("((//span[contains(@class,'hour') and starts-with(text(),'" + i + "')]))[2]");
	}

	public By ClickonEndDateField = By.xpath("//div[@id='m_datetimepicker_2_1']");
	public By todayEnddate = By.xpath("(//td[@class='day today active'])[2]");

	public By StartPrice(String price) {
		return By.xpath("(//div[contains(text(),'Decrement')]/../../div[text()='" + price
				+ "']/../../preceding-sibling::div)[1]//div[text()='Start Price:']/..");
	}

	public By approveASN = By.xpath("//a[contains(text(),'Approve ASN')]");
	public By actionDropdownASN = By.xpath("(//button[contains(@data-toggle,'dropdown')])[1]");
	public By approveOrReject = By.xpath("(//a[contains(text(),'Approve/Reject')])[1]");
	public By selectPONo = By.xpath("//strong[contains(text(),'Select PO Number:')]");

	public By approveOrHold = By.xpath("//button[@data-original-title='Approve / Hold']");
	public By approverCommentSection = By.xpath("//textarea[@ng-model='objData.comment']");
	public By attachFile = By.xpath("//input[@class='ng-isolate-scope']");
	public By approveButton = By.xpath("//button[contains(text(),'Approve')]");
	public By supplierInformation = By.xpath("//a[contains(text(),'Supplier Information')]");
	public By superLegancyCode = By.xpath("//strong[contains(text(),'Supplier Legacy Code')]");
	public By shipmentInformation = By.xpath("//a[contains(text(),'Shipment Information')]");
	public By bolNumber = By.xpath("//strong[contains(text(),'BOL Number')]");
	public By whatTheyAreShippingToUs = By.xpath("//a[contains(text(),'What They are Shipping to Us')]");
	public By boxNumber = By.xpath("//label[contains(text(),'Box Number :')]");
	public By ASNDeliveryChallan = By.xpath("//a[contains(text(),'ASN / Delivery Challan Checklist')]");
	public By buyerAcceptance = By.xpath("//select[@name='buyer_acceptance']");
	public By invoice = By.xpath("//a[contains(text(),'Invoice')]");
	public By poNumber = By.xpath("//label[contains(text(),'PO Number')]");
	public By ASNApproverSave = By.xpath("//button[@data-original-title='Save']");
	public By ASN = By.xpath("//span[text()='ASN']");

	public By ASNList = By
			.xpath("//span[text()='ASN']/../following-sibling::ul//a[normalize-space(text())='ASN List']");

	public By CreateASN = By
			.xpath("//span[text()='ASN']/../following-sibling::ul//a[normalize-space(text())='Create ASN']");

	public By SelectPONum = By.xpath("//select[@ng-model='asn.singleSelectPoId']");

	public By ASNDate = By.xpath("//input[@id='0.asn_date.0']");

	public By ASNReference = By.xpath("//input[@id='0.asn_reference_no.0']");

	public By ASNCarrier = By.xpath("//input[@id='0.carrier.0']");

	public By ASNShippingMethod = By.xpath("//input[@id='0.shipping_method.0']");
	public By modeOfDelivery = By.xpath("//select[@id='0.shipping_method.0']");

	public By ASNShippertracking = By.xpath("//input[@id='0.shipper_tracking.0']");

	public By ASNEstimatedDeliveryTime = By.xpath("//input[@id='0.estimated_delivery_time.0']");

	public By ASNAdditionalNote = By.xpath("//input[@id='0.additional_note.0']");

	public By ASNShipmentnumber = By.xpath("//input[@id='0.shipment_number.0']");

	public By ChkbxInspectionReq = By.xpath("//input[@id='exampleCheck1']");

	public By ASNInspectionDetails = By.xpath("//textarea[@id='exampleFormControlTextarea1']");

	public By ASNSave = By.xpath("//button[@data-original-title='Save']");

	public By TabMyInformation = By.xpath("//a[normalize-space(text())='My Information']");

	public By TabShipmentInformation = By.xpath("//a[normalize-space(text())='Shipment Information']");

	public By TabWhatIamShipping = By.xpath("//a[normalize-space(text())='What I am Shipping']");

	public By TabDeliveryChallanChecklist = By.xpath("//a[normalize-space(text())='ASN / Delivery Challan Checklist']");

	public By TabInvoice = By.xpath("//a[normalize-space(text())='Invoice']");

	public By purchaserAccount = By.xpath("//input[@id='1.budget_head.0']");

	public By SupplierState = By.xpath("//input[@id='1.state.0']");

	public By SupplierZip = By.xpath("//input[@id='1.zip.0']");

	public By SupplierContact = By.xpath("//input[@id='1.contact_no.0']");

	public By SupplierOrgName = By.xpath("//input[@id='1.vendor_company_name.0']");

	public By SelctWareHouse = By.xpath("//strong[text()='Select Warehouse: ']/../following-sibling::select");

	public By BolNumber = By.xpath("//input[@id='2.bol_no.0']");

	public By DeliverToContactName = By.xpath("//input[@id='2.contact_name.0']");

	public By PalletsandBoxes = By.xpath("//label[normalize-space(text())='Pallets & Boxes']");

	public By BoxesOnly = By.xpath("//label[normalize-space(text())='Boxes Only']");

	public By AddPallets = By.xpath("//label[normalize-space(text())='Add Pallet']");

	public By AddBoxe = By.xpath("//label[normalize-space(text())='Add Box']");

	public By PalletDescription1 = By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[1]");

	public By PalletDescription2 = By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]");

	public By PalletDescription3 = By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[3]");

	public By Boxe1 = By.xpath("(//input[@placeholder='Enter Box Number'])[1]");

	public By Boxe2 = By.xpath("(//input[@placeholder='Enter Box Number'])[2]");

	public By Boxe3 = By.xpath("(//input[@placeholder='Enter Box Number'])[3]");

	public By ItemDescription1 = By.xpath("(//i[@class='fa fa-list tooltipClass'])[1]");

	public By ItemDescription2 = By.xpath("(//i[@class='fa fa-list tooltipClass'])[2]");

	public By ItemDescription3 = By.xpath("(//i[@class='fa fa-list tooltipClass'])[3]");

	public By radiobtnItemDescription1 = By.xpath("(//tr[@class='ng-scope']//input)[1]");

	public By radiobtnItemDescription2 = By.xpath("(//tr[@class='ng-scope']//input)[2]");

	public By radiobtnItemDescription3 = By.xpath("(//tr[@class='ng-scope']//input)[3]");

	public By BtnOk = By.xpath("//button[normalize-space(text())='Ok']");
	public By btnok = By.xpath("//button[normalize-space(text())='Ok' and @class='btn btn-primary']");
	public By ASNQuantity1 = By.xpath("(//input[@placeholder='ASN Quantity'])[1]");

	public By clarificationChatBox = By.xpath("//*[@id='chatBox']");
	public By ASNQuantity2 = By.xpath("(//input[@placeholder='ASN Quantity'])[2]");

	public By ASNQuantity3 = By.xpath("(//input[@placeholder='ASN Quantity'])[3]");

	public By Weight1 = By.xpath("(//input[@placeholder='Weight'])[1]");

	public By Weight2 = By.xpath("(//input[@placeholder='Weight'])[2]");

	public By Weight3 = By.xpath("(//input[@placeholder='Weight'])[3]");

	public By UOMWeight1 = By.xpath("(//select[@id='3.uom_weight.14'])[1]");

	public By UOMWeight2 = By.xpath("(//select[@id='3.uom_weight.14'])[2]");

	public By UOMWeight3 = By.xpath("(//select[@id='3.uom_weight.14'])[3]");

	public By UploadDocument = By.xpath("//input[@title='Select file' and @id ='4_upload_path_0']");

	public By DocumentName = By.xpath("//input[@placeholder='Document Name']");

	public By InvoiceType = By.xpath("//select[@id='5.invoice_type.0']");

	public By SellerInvoiceNum = By.xpath("//input[@placeholder='Seller Invoice No']");

	public By InvoiceDate = By.xpath("//input[@id='5.invoice_date.0']");

	public By Freight = By.xpath("//input[@placeholder='Freight']");

	public By Tax = By.xpath("//input[@placeholder='Tax']");

	public By InvoiceAttachment = By.xpath("//input[@id='5_invoice_attachment_0']");

	public By BankAccountNumber = By.xpath("//input[@placeholder='Bank Account Number']");

	public By BillingAddress = By.xpath("//textarea[@name='billing_address']");

	public By cashDiscount = By.xpath("//input[@ng-model='row.cashDiscount']");

	public By cashPercentage = By.xpath("//input[@ng-model='row.cashPercentage']");

	public By NumberOfDays = By.xpath("//input[@ng-model='row.numberOfDays']");

	public By btnSendforApproval = By.xpath("//button[@data-original-title='Send for approval']");

	//ASN locator for New angular (Added by AD on 100224)
	public By orderFulfillment = By.xpath("//a[contains(text(),'Order Fulfillment')]");
	public By createNewASN = By.xpath("//span[contains(text(),'Create new')]");
	public By referenceNumbertext = By.xpath("//h3[contains(text(),'Reference Number')]");
	public By selectReferenceNumberTextBox = By.xpath("//input[@id='answer']");
	public By selectButtonASN = By.xpath("//button[contains(text(),'Select')]");
	public By asnInitialAlert = By.xpath("//body/div[@id='alerts']/div[1]");
	public By DespatchNumber = By.xpath("//input[@id='0.org_asn_id.0']");
	//====ASN Information
	public By supplierContactNumber = By.xpath("//input[@id='1.contact_no.0']");
	//====WhatIamShipping
	public By addASNItemRow = By.xpath("//div[contains(@class, 'col-lg-12 text-right')]/button");
	public By itemSelectionButton = By.xpath("(//div[@id='scrollable-dropdown-menu'])[2]/parent::div/preceding-sibling::a/i");
	public By itemSelectionButton(String itemC) {
		return By.xpath("(//div[@box-id='outerIndex']/preceding-sibling::a/i)["+itemC+"]");
	}
	public By itemSelection = By.xpath("//input[@ng-model='item.radioValue']");
	public By itemSelection(String itemC) {
		return By.xpath("(//input[@ng-model='item.radioValue'])["+itemC+"]");
	}
	public By deletemItemRow = By.xpath("(//div[@box-id='outerIndex'])[2]/parent::span/parent::td/following-sibling::td[7]/button");
	public By deletemItemRowConfirm = By.xpath("//div[@class='modal-content']/div[3]/button[@data-bb-handler='confirm']");
	public By selectASNItemOKButton = By.xpath("//button[@ng-click='selectedItem()']");
	public By selectASNItemCancelButton = By.xpath("//button[@ng-click='selectedItem()']/preceding-sibling::button");
	public By shipmentQuantity = By.xpath("//span[@class='posRel']/div[1]/div[1]/div[1]/div[1]//input[@name='asn_qty']");
	public By shipmentQuantity(String itemC) {
		return By.xpath("(//span[@class='posRel']/div[1]/div[1]/div[1]/div[1]//input[@name='asn_qty'])["+itemC+"]");
	}
	public By shipmentWeight = By.xpath("//span[@class='posRel']/div[1]/div[1]/div[1]/div[1]//input[@name='weight']");
	public By shipmentWeight(String itemC) {
		return By.xpath("(//span[@class='posRel']/div[1]/div[1]/div[1]/div[1]//input[@name='weight'])["+itemC+"]");
	}
	public By saveASN = By.xpath("//button[@data-original-title='Save']");
	public By submitASN = By.xpath("//button[@data-original-title='Submit']");
	public By totalFreightChargeP  = By.xpath("//input[@id='5.freight.0']");
	
	

	
	public By BtnYes = By.xpath("//button[@data-bb-handler='confirm']");
	public By GRN = By.xpath("//span[text()='GRN']");

	public By approvedASN = By.xpath("//a[contains(text(),'Approved ASN')]");
	public By TCS = By.xpath("//strong[contains(text(),'TCS')]");
	public By enterVendorName = By.xpath("//input[@placeholder='Enter Vendor Name']");
	public By enterShipmentNumber = By.xpath("//input[@placeholder='Enter shipment number']");

	public By SearchPOINASN = By.xpath("//input[@ng-model='searchString']");

	public By Status(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum
				+ "'])[1]/../../following-sibling::td[8]//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn']");
	}
	public By asnStatus(String status) {
		return By.xpath("//button[@data-original-title='"+status+"']");
	}

	public By DeleteBox = By
			.xpath("//label[normalize-space(text())='Add Box']/../../following-sibling::div[2]//button/i");

	public By BoXDeleteConfirm = By.xpath("//button[@data-bb-handler='confirm']");

	public By ASNListInBidderLogin = By.xpath("//a[contains(text(),'ASN List')]");

	public By ASNListPage = By.xpath("//li[text()='ASN List']");

	public By ASNNo = By.xpath("//strong[text()='ASN No.']/../following-sibling::div//input");

	public By draftStatus = By.xpath(
			"//button[@data-original-title='Draft'][@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn']");

	public By records = By.xpath("//div[text()='Showing ']/b");

	public By GRNMenuLinkBy = By.xpath("//*[@id='mCSB_1_container']/li/a/span[text()='GRN']");

	public By ApprovedASNLinkBy = By.xpath("//a[contains(text(),'Approved ASN')]");

	public By vendorNameFieldBy = By.xpath("//*[@placeholder='Enter Vendor Name']");

	public By entershipmentFieldBy = By.xpath("//*[@placeholder='Enter shipment number']");

	public By MaterialDetailsBy = By.xpath("//*[contains(normalize-space(text()),'Material Details')]");

	public By SaveGrnDetailsBy = By.xpath("//*[@data-original-title='Save']");

	public By GrnSubmitBy = By.xpath("//*[@data-original-title='Submit']");

	public By GrnSubmitConfirmPopUpMsgBy = By
			.xpath("//*[text()='Do you really want to submit? Once submit you can not reverse it back. ']");

	public By GrnSubmitConfirmYesBy = By.xpath(
			"//*[text()='Do you really want to submit? Once submit you can not reverse it back. ']/../following-sibling::div/button[@data-bb-handler='confirm']");

	public By GrnSubmitConfirmNoBy = By.xpath(
			"//*[text()='Do you really want to submit? Once submit you can not reverse it back. ']/../following-sibling::div/button[@data-bb-handler='cancel']");

	public By GrnListMenuLinkBy = By.xpath("//a[contains(text(),'GRN List')]");

	public By GrnListDraftEleBy = By.xpath("//*[@id='myTab']/li[contains(@class,'ng-scope active')]/a");

	public By AsnListShipmentThBy = By.xpath("//th[contains(text(),'Shipment No.')]");

	public By EnterRejectedQtyBy(int no) {
		return By.xpath("(//*[@name='grn_rejected_quantity'])[" + no + "]");
	}

	public By EnterExcessQtyBy(int no) {
		return By.xpath("(//*[@name='excess_qty'])[" + no + "]");
	}

	public By EnterShortQtyBy(int no) {
		return By.xpath("(//*[@name='short_qty'])[" + no + "]");
	}

	public By EnterDamageQtyBy(int no) {
		return By.xpath("(//*[@name='damage_qty'])[" + no + "]");
	}

	public By AcceptedQtyBy(int no) {
		return By.xpath("(//*[contains(text(),'Accepted Quantity:')]/../../../following-sibling::div//b)[" + no + "]");
	}

	public By grnIDBy = By.xpath("//*[@id='bodyPrint']//table/tbody/tr[1]/th[text()='GRN ID']");

	public By GrnPreviewCloseBtn = By.xpath("//*[contains(@ng-click,'GRN_MODAL')  and text()='Close']");
	

	public By AsnPreviewCloseBtn = By.xpath("//*[contains(@ng-click,'ASN_MODAL')  and text()='Close']");

	public By asnNoBy = By.xpath(
			"//*[@id='asnPreviewModal']//table/tbody/tr[1]/td[2]/asn-preview-field/div/label[1]/b[text()='ASN No. :']");

	public By GrnCancelAlertMsgBy = By.xpath("//*[text()='Do you really want to cancel?']");

	public By GrnCancelConfirmBtnBy = By.xpath(
			"//*[text()='Do you really want to cancel?']/../following-sibling::div[@class='modal-footer']/button[contains(text(),'Confirm')]");

	public By GrnCreatedTabBy = By.xpath("//*[@class='row']//child::ul[@id='myTab']/li/a[contains(text(),'Created')]");

	public By GrnCreatedTabRecBy = By.xpath(
			"//*[@class='row']//child::ul/li/a[contains(text(),'Created')]/../..//following-sibling::div/child::div[@class='tab-pane fade ng-scope active in']//table/tbody/tr[1]");

	public By GrnCancelTabBy = By.xpath("//*[@class='row']//child::ul[@id='myTab']/li/a[contains(text(),'Cancel')]");

	public By GrnCancelTabRecBy = By.xpath(
			"//*[@class='row']//child::ul/li/a[contains(text(),'Cancel')]/../..//following-sibling::div/child::div[@class='tab-pane fade ng-scope active in']//table/tbody/tr[1]");

	public By GrnDraftRecBy = By.xpath(
			"//*[@class='row']//child::ul/li/a[contains(text(),'Draft')]/../..//following-sibling::div/child::div[@class='tab-pane fade ng-scope active in']//table/tbody/tr[1]");
	public By createASNButton = By.xpath("//button[contains(@data-original-title,'Create ASN')]");

	public By viewASN = By.xpath("//a[text()='View']");

	public By previewASN = By.xpath("//h3[text()='Preview ASN']");

	public By ASNNo(String ASNno) {
		return By.xpath("//b[text()='ASN No. :']/../following-sibling::label/span/span[text()='" + ASNno + "']");
	}
	
	public By actionDropDown (String ASNno) {
		return By.xpath("//*[contains(text(),'" + ASNno + "')]/../following-sibling::td//child::button[@data-toggle='dropdown']");
	}
	
	public By asnInformation = By.xpath("//div[normalize-space(text())='ASN Information']");

	public By myInformation = By.xpath("//div[normalize-space(text())='My Information']");

	public By shipmentInfo = By.xpath("//div[normalize-space(text())='Shipment Information']");

	public By shipping = By.xpath("//div[normalize-space(text())='What I am Shipping']");
	public By deliveryChallan = By.xpath("//div[normalize-space(text())='ASN / Delivery Challan Checklist']");

	public By invoiceCheck = By.xpath("//div[normalize-space(text())='Invoice']");

	public By preparedStatus = By
			.xpath("//button[contains(@class,'btn-lg btn-lg-sub2 grnBtn doneBtn')][@data-original-title='Prepared']");

	public By StatusPendingforInspection(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum
				+ "'])[1]/../../following-sibling::td[8]//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub2 grnBtn doneBtn']");
	}

	public By Inspection = By.xpath("//a[normalize-space(text())='Inspection']");
	public By Pending = By.xpath("//a[normalize-space(text())='Pending']");

	public By InspectionActionBtn(String ASNNum) {
		return By.xpath("//td[text()='" + ASNNum + "']/../td[9]//button");
	}

	public By Claim(String ASNNum) {
		return By.xpath("//td[text()='" + ASNNum + "']/../td[9]//button/following-sibling::ul//a[text()='Claim']");
	}

	public By ViewASN(String ASNNum) {
		return By.xpath("//td[text()='" + ASNNum + "']/../td[9]//button/following-sibling::ul//a[text()='View Asn']");
	}

	public By claimAssigned(String ASNNum) {
		return By.xpath("//td[text()='" + ASNNum + "']/../td[6]/span[text()='Assigned']");
	}

	public By ApproveOrReview(String ASNNum) {
		return By.xpath(
				"//td[text()='" + ASNNum + "']/../td[9]//button/following-sibling::ul//a[text()='Approve/Review']");
	}

	public By ActionBtnBidder(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum + "'])[1]/../../following-sibling::td[9]//button");
	}

	public By EditASN(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum
				+ "'])[1]/../../following-sibling::td[9]//ul//a[text()='Edit']");
	}

	public By POItemRemaining = By.xpath("(//b[text()='Remaining PO Quantity : ']/..)[1]");
	public By ASNInformation = By.xpath("//b[contains(text(),'ASN Information')]");

	public By DeleteASN(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum
				+ "'])[1]/../../following-sibling::td[9]//ul//a[normalize-space(text())='Delete']");
	}

	public By BidderWarehouse(String ponum) {
		return By.xpath("(//a[normalize-space(text())='" + ponum + "'])[1]/../../following-sibling::td[6]");
	}

	public By ApproverWarehouse(String asnnum) {
		return By.xpath("//td[text()='" + asnnum + "']/../td[7]");
	}

	public By approveOrReject(String ASNno) {
		return By.xpath("//td[text()='" + ASNno
				+ "']/../td//button[@id='menu1']/following-sibling::ul/li/a[text()='Approve/Reject']");
	}

	public By ASNStatus(String currentStatus) {
		return By.xpath("//button[contains(@class,'btn-lg btn-lg-sub2 grnBtn')][contains(@data-original-title,'"
				+ currentStatus + "')]");
	}

	public By buyerAcceptence = By.xpath("//select[@id='4.buyer_acceptance.0']");

	public By revert = By.xpath("//button[contains(text(),'Revert')]");

	public By actionDropDowns(String asnNo, String dropDowns) {
		return By.xpath("//td[text()='" + asnNo
				+ "']/../td//button[@id='menu1']/following-sibling::ul/li/a[contains(text(),'" + dropDowns + "')]");
	}

	public By ASNNum(String ponum) {
		return By.xpath("(//*[normalize-space(text())='" + ponum + "'])[1]//../following-sibling::td[1]");
	}

	public By hold = By.xpath("//button[contains(text(),'Hold')]");

	public By inspectionButton = By.xpath("//button[@data-original-title='Send for Inspection']");

	public By requestForInspectionButton = By.xpath("//button[contains(text(),'Request for Inspection')]");

	public By inspectionASNDocNo(String asnNo) {
		return By.xpath("//tbody[@id='tbody1']/tr/td[text()='" + asnNo + "']");
	}

	public By approveOrReview(String ASNno) {
		return By.xpath("//td[text()='" + ASNno
				+ "']/../td//button[@id='menu1']/following-sibling::ul/li/a[text()='Approve/Review']");
	}

	public By actionBtn(String ASNno) {
		return By.xpath("//td[text()='" + ASNno + "']/../td//button[@id='menu1']");
	}

	public By poValueCV = By.xpath("(//label[@class='bigcheck ng-binding'])[3]");
	public By netASNValueCV = By.xpath("(//label[@class='bigcheck ng-binding'])[4]");
	public By closeFilter = By.xpath("//button[@id='closeFilter' and contains(text(),'Close')]");
	public By selectAllBidFieldBy = By.xpath("//*[@id='allBid']");

	public By hardStopTimeFieldBy = By.xpath("//*[@id='hardStopTime']");

	public By ViewShipmentDetailsPage(String ShipTrackno) {
		return By.xpath("(//td[text()='" + ShipTrackno + "']/../td[10]//a[text()='View Shipment Details'])[1]");
	}

	public By CancelGRN(String ShipTrackno) {
		return By.xpath("(//td[text()='" + ShipTrackno + "']/../td[10]//a[text()='Cancel GRN'])[1]");
	}

	public By TabCreated = By.xpath("(//a[normalize-space(text())='Created'])[1]");

	public By TabCancel = By.xpath("(//a[normalize-space(text())='Cancel'])[1]");
	public By cancelNotesheet = By.xpath("//*[normalize-space(text())='Cancel']");
	public By ASNPONum = By.xpath("(//b[text()='PO Number :'])[1]/../following-sibling::label//a");
	public By ASNVal = By.xpath("((//b[text()='ASN No. :'])[1]/../following-sibling::label//span)[2]");
	public By ASN_reference = By.xpath("((//b[text()='Reference :'])[1]/../following-sibling::label//span)[2]");
	public By ASN_Shippingmethod = By
			.xpath("((//b[text()='Shipping Method :'])[1]/../following-sibling::label//span)[2]");
	public By ASN_carrier = By.xpath("((//b[text()='Carrier :'])[1]/../following-sibling::label//span)[2]");
	public By ASNAdditionalNoteVal = By
			.xpath("((//b[text()='Additional Note :'])[1]/../following-sibling::label//span)[2]");
	public By ASN_Shipment_Num = By.xpath("(//b[text()='Shipment Number :'])[1]/../following-sibling::label//b");
	public By SellerORGName = By.xpath("((//b[text()='Supplier Org Name :'])[1]/../following-sibling::label//span)[2]");
	public By budgetHead = By
			.xpath("((//b[text()='Purchaser Account ID/Budget Head :'])[1]/../following-sibling::label//span)[2]");
	public By SupplierAddress = By
			.xpath("((//b[text()='Supplier Address :'])[1]/../following-sibling::label//span)[2]");
	public By Suppliercountry = By
			.xpath("((//b[text()='Supplier Country :'])[1]/../following-sibling::label//span)[2]");
	public By Supplierzip = By.xpath("((//b[text()='Supplier zip :'])[1]/../following-sibling::label//span)[2]");
	public By Suppiercontact = By.xpath("((//b[text()='Supplier Contact :'])[1]/../following-sibling::label//span)[2]");
	public By SellerInvoiceNumber = By
			.xpath("((//b[text()='Seller Invoice No :'])[1]/../following-sibling::label//span)[2]");
	public By Billingaddress = By.xpath("((//b[text()='Billing Address :'])[1]/../following-sibling::label//span)[2]");
	public By DiscountbeforNoofDAYS = By
			.xpath("((//b[text()='Discount before no of Days :'])[1]/../following-sibling::label//span)[2]");
	public By InvoiceTypeVal = By.xpath("((//b[text()='Invoice Type :'])[1]/../following-sibling::label//span)[2]");
	public By acceptedQtyAlert = By.xpath("//li[contains(text(),'can not be less than')]");

	public By invalidQuantity(int invalidQtyRow) {
		return By.xpath("(//label[text()='Invalid quantity']/.)[" + invalidQtyRow + "]");
	}

	public By asnQtyFieldvalue(int asnQtyValueRow) {
		return By.xpath("(//b[text()='ASN Quantity: ']/..)[" + asnQtyValueRow + "]");
	}

	public By grnQtyShouldBeEditable(int ItemCodeRow) {
		return By.xpath(
				"//*[contains(text(),'Material Details')]/../..//following-sibling::div//child::div//*[contains(@class,'ng-touched')]");
	}

	public By grnDataSavedMsgBy = By.xpath("//*[contains(text(),'All Data Saved')]");

	public By RejectedQtyvalue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'Rejected Quantity : ')]/..");
	}

	public By ExcessQtyvalue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'Excess Quantity: ')]/..");
	}

	public By DamageQtyvalue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'Damage Quantity: ')]/..");
	}

	public By ShortQtyvalue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'Short Quantity: ')]/..");
	}

	public By ASNQuantity = By.xpath("//label/b[text()='ASN Quantity: ']/parent::label");
	public By shortQtyPopUp = By.xpath("//h4[text()='Confirm']");
	public By popUpText = By.xpath("//div[contains(text(),'You have added excess quantity already')]");

	public By yesOrNoButton(String yesOrNo) {
		return By.xpath("//button[@data-bb-handler][contains(text(),'" + yesOrNo + "')]");
	}

	public By draft = By.xpath("//a[contains(text(),'Draft')]");
	public By viewGRN = By.xpath("//a[text()='View GRN']");
	public By viewShipmentDetails = By.xpath("//a[text()='View Shipment Details']");
	public By cancelGRN = By.xpath("//a[text()='Cancel GRN']");
	public By previewGRN = By.xpath("//h3[text()='Preview GRN']");
	public By previewAll_close1 = By.xpath("(//button[@class='btn btn-primary succes_msgsnd' and text()='Close'])[2]");

	public By ViewlGRN(String ShipTrackno) {
		return By.xpath("(//td[text()='" + ShipTrackno + "']/../td[10]//a[text()='View GRN'])[1]");
	}

	public By ItemCodeUi = By.xpath("(//b[text()='Item Code: ']//../span)[1]");
	public By ItemDescriptionUi = By.xpath("(//b[text()='Item Description: ']//../span)[1]");
	public By UOMUi = By.xpath("(//b[text()='UOM (Qty): ']//../span)[1]");
	public By POQuantityUi = By.xpath("(//b[text()='PO Quantity: ']//..)[1]");
	public By ASNQuantityUi = By.xpath("(//b[text()='ASN Quantity: ']//..)[1]");
	public By RejectedQuantityUi = By.xpath("(//b[text()='Rejected Quantity : ']//..)[1]");
	public By ExcessQuantityUi = By.xpath("(//b[text()='Excess Quantity: ']//..)[1]");
	public By ShortQuantityUi = By.xpath("(//b[text()='Short Quantity: ']//..)[1]");
	public By DamageQuantity = By.xpath("(//b[text()='Damage Quantity: ']//..)[1]");
	public By AcceptedQuantityUi = By
			.xpath("(//b[text()='Accepted Quantity : ']//../../../following-sibling::div//b)[1]");
	public By GrnIDBy = By.xpath("(//table/tbody/tr[1]/th[text()='GRN ID']/../td/span)[1]");
	// InVoice

	public By InVoiceMenuLinkBy = By.xpath("//*[@id='mCSB_1_container']/li/a/span[text()='Invoice']");

	public By InVoiceProcessingLinkBy = By.xpath("//a[contains(text(),'Invoice Processing')]");

	public By invoiceNestedTableRowsBy = By.xpath("(//*[@class='nestedTableLevel1']//div[@class='panel-heading'])[1]");

	public By serchInvoiceOrPoNumBy = By.xpath("//input[@placeholder='Enter PO Number / invoice number']");

	public By InvoiceSellerHeaderBy = By.xpath(
			"//*[@class='panel-heading']//a[contains(normalize-space(text()),'Invoice Number / Seller Invoice Number :')]");

	public By GRNHeaderBy = By.xpath("//*[@class='panel-heading']//a[contains(normalize-space(text()),'GRN ID :')]");

	public By GRNHeaderMinusIconBy = By.xpath("//*[contains(@ng-click,'clickOnGRN')][@class='fa fa-minus-circle']");

	public By shippingTrackingData(String ShipTrackno) {
		return By.xpath("//*[contains(text(),'" + ShipTrackno + "')]");
	}

	public By Invoice = By.xpath("//span[contains(text(),'Invoice')]");
	public By GRListToRaiseInvoice = By.xpath("//a[contains(text(),'GRN List To Raise Invoice')]");
	public By enterPONumber = By.xpath("//input[@placeholder='Enter PO Number / invoice number']");
	public By poNumberplusIcon = By.xpath("//a[contains(@ng-click,'clickOnPo')]");
	public By view_GRN = By.xpath("//a[contains(text(),'View GRN')]");
	public By GRNId = By.xpath("//a[contains(@ng-click,'clickOnGRN')]");

	public By itemDetailsTab = By.xpath("//a[contains(text(),'Item Details')]");
	public By invoiceDate = By.xpath("//input[@id='.invoice_date.']");
	public By btnPayment = By.xpath("//span[text()='Payment']");
	public By btnInvoiceListPayment = By.xpath("//a[normalize-space(text())='Invoice List For Payment']");

	public By chkboxinvoice(String invoice) {
		return By.xpath("//td[text()='" + invoice + "']/preceding-sibling::td/input");
	}

	public By HomeInvoicepage = By.xpath("//li[normalize-space(text())='Invoice List For Payment']");

	public By invoiceActiondrpdwn(String invoice) {
		return By.xpath("//td[text()='" + invoice + "']/..//button[@data-toggle='dropdown']");

	}

	public By ViewInvoiceASN(String invoice) {
		return By.xpath("(//td[text()='" + invoice + "']/..//a)[1]");
	}

	public By ViewInvoiceGRN(String invoice) {
		return By.xpath("(//td[text()='" + invoice + "']/..//a)[2]");
	}

	public By ViewInvoicePO(String invoice) {
		return By.xpath("(//td[text()='" + invoice + "']/..//a)[3]");
	}

	public By GRNidUi = By.xpath("//th[text()='GRN ID']/following-sibling::td[1]");
	public By SupplierCode = By.xpath("//b[text()='Supplier Code']/../../following-sibling::td//span");

	public By SupplierorgName = By.xpath("//b[text()='Supplier Organization Name']/../../following-sibling::td//span");
	public By Address = By.xpath("//b[text()='Address']/../../following-sibling::td//span");
	public By Country = By.xpath("//b[text()='Country']/../../following-sibling::td//span");

	public By SellerInvoiceapprove(String sellerInvoiceNo) {
		return By.xpath("//*[contains(text(),'" + sellerInvoiceNo + "')]/..//span/i[@title='Approve Invoice']");
	}

	public By poValueNumberBy = By.xpath("//*[@placeholder='PO Number']");

	public By approvedAmountBy = By.xpath("//*[@name='approved_amount']");

	public By penaltyDeductionAmountBy = By.xpath("//*[@name='penalty_deduction']");

	public By inVoiceAcceptBy = By.xpath("//*[@ng-click='acceptInvoice()']");

	public By sendBackToSupplierBy = By.xpath("//*[@ng-click='sendBackToSupplier()']");

	public By inVoiceErrorValidationBy = By
			.xpath("//*[@class='error-msg-list']//b[text()='Invoice']/../../following-sibling::li");

	public By inVoiceErrorMsgOkBy = By.xpath("//button[contains(text(),'OK')]");

	public By inVoiceHeaderBarBy = By.xpath("//*[@class='panel-heading']//a[contains(@ng-click,'clickOnInvoice')]");

	public By viewGrnBy = By.xpath("//*[@ng-click='viewGrnData(grnObj)']");

	public By poQuantityValue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'PO Quantity: ')]/..");
	}

	public By AsnQuantityValue(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'ASN Quantity: ')]/..");
	}

	public By viewASN_InoviceNumber = By.xpath("//span[@ng-click='viewAsn(invObj)']");
	public By view_PO = By.xpath("//span[contains(@ng-click,'poViewModal')]");
	public By reviewedReason = By.xpath("//textarea[@name='reviewedReason']");
	public By invoice_Date = By.xpath("//*[contains(text(),'Invoice Date :')]/../..");
	public By dueDate = By.xpath("//*[contains(text(),'Due Date :')]/../..");
	public By invoiceAmount = By.xpath("//*[contains(text(),'Invoice Amount :')]/../..");
	public By paidAmount = By.xpath("(//*[contains(text(),'Paid Amount :')]/../..)[2]");
	public By overDueAmount = By.xpath("//*[contains(text(),'Due/Overdue Amt')]/../..");
	public By invoiceStatus = By.xpath("//*[contains(text(),'Invoice Status :')]/../..");

	public By AcceptedGrnQuantity(String ItemCode) {
		return By.xpath("//span[contains(text(),'" + ItemCode
				+ "')]/../../../../../following-sibling::div//b[contains(text(),'Accepted Quantity : ')]/../../../following-sibling::div//b");
	}

	public By ClosePoDetails = By.xpath("(//button[text()='Close'])[3]");
	public By disputeInvoiceList = By.xpath("//a[contains(text(),'Disputed Invoice List')]");
	public By disputedInvoicePaymentListTitle = By
			.xpath("//h3//span[contains(text(),'Disputed Invoice Payment List')]");
	public By poNumberHeader = By.xpath("//h4/a[contains(@ng-click,'clickOnPo')]");
	public By alterInvoiceIcon = By.xpath("//span[contains(@ng-click,'alterInvoiceAction')]/i");
	public By alterDisputedInvoice = By.xpath("//h3/span[text()='Alter/Modify Disputed Invoice']");

	public By itemCodeList(int i) {
		return By.xpath(
				"(//div[@role='rowgroup']/following-sibling::div//div[@ui-grid-row='row']/div/div/span)[" + i + "]");
	}

	public By acceptedQuantity(int i) {
		return By.xpath(
				"(//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000A text-right']/div[@title])[" + i + "]");
	}

	public By invoiceQuantityToBeRaised(int i) {
		return By.xpath("(//input[@ng-model='row.entity.invoiceQuantity'])[" + i + "]");
	}

	public By grnActionBtn(String trackingNumber) {
		return By.xpath("//td[text()='" + trackingNumber + "']/..//button[@id='menu1']");
	}

	public By disputedStatusBy = By.xpath("//*[text()='Disputed']");

	public By InvoiceNuUI(String InvoiceNum) {
		return By.xpath("//td[@class='ng-binding ng-scope' and text()='" + InvoiceNum + "']");
	}

	public By SupplierUI = By.xpath("//td[@class='ng-binding ng-scope' and text()='TCS']");

	public By InvoiceDateUI(String InvoiceDate) {
		return By.xpath("//td[@class='ng-binding ng-scope' and text()='" + InvoiceDate + "']");
	}

	public By InvoiceAmtUI(String InvoiceAmtUI) {
		return By.xpath("//span[@class='ng-binding ng-scope' and text()='" + InvoiceAmtUI + "']");
	}

	public By BalanceInvoiceAmtUI(String InvoiceAmtUI) {
		return By.xpath("//td[@class='ng-binding ng-scope' and text()='" + InvoiceAmtUI + "']");
	}

	public By InvoiceStatusUI(String Status) {
		return By.xpath("//td[@class='ng-binding ng-scope' and text()='" + Status + "']");
	}

	public By btnPay = By.xpath("//button[text()='Pay']");

	public By AmtToBePaid = By.xpath("//input[@ng-model='paymentItem.paidAmount']");

	public By Balance = By.xpath("//input[@ng-model='paymentItem.paidAmount']/../following-sibling::td[1]");

	public By Total = By.xpath("//button[text()='Total']/../following-sibling::div[1]/button");

	public By BeneficiaryName = By
			.xpath("//div[normalize-space(text())='Beneficiary Name']/following-sibling::div/input");

	public By BeneficiaryAccountNumber = By
			.xpath("//div[normalize-space(text())='Beneficiary Account No']/following-sibling::div/input");

	public By IFSCCode = By.xpath("//div[normalize-space(text())='IFSC Code']/following-sibling::div/input");

	public By TransactionNumber = By
			.xpath("//div[normalize-space(text())='Enter Transaction Number']/following-sibling::div/input");

	public By Amount = By.xpath("//div[normalize-space(text())='Amount']/following-sibling::div/input");

	public By radiobtnCheque = By.xpath("//span[text()='Cheque']/preceding-sibling::input");

	public By radiobtnChallan = By.xpath("//span[text()='Challan']/preceding-sibling::input");

	public By chqAccount = By.xpath("//div[normalize-space(text())='Account']/following-sibling::div/input");

	public By ChqNumber = By.xpath("//div[normalize-space(text())='Cheque No']/following-sibling::div/input");

	public By ChqDate = By.xpath("//div[normalize-space(text())='Date']/following-sibling::div//input");

	public By PayeeNameOnCheque = By
			.xpath("//div[normalize-space(text())='Payee Name On Cheque']/following-sibling::div/input");

	public By VoucherNumber = By.xpath("//div[normalize-space(text())='Voucher Number']/following-sibling::div/input");

	public By ProcessedBy = By.xpath("//div[normalize-space(text())='Processed By']/following-sibling::div/input");
	public By notRequiredCheckmark = By.xpath("(//span[@class='checkmark'])[6]");
	public By Submit = By.xpath("//button[normalize-space(text())='Submit']");
	public By submitByDeleteSN = By.xpath("//*[@id='CommonModal']/div/div/div[3]/div/label");
	public By deleteorCancelledTab = By.xpath("//*[@id='nav-my-indent-tab' and text()='Cancelled/Deleted']");
	public By snDeletestatus = By.xpath("//*[@id='_ctd_sn_cancelled']/div/table/tbody/tr[1]/td[6]/span");
	public By ShowList(String InvoiceAmtUI) {
		return By.xpath("//span[@class='ng-binding ng-scope' and text()='" + InvoiceAmtUI
				+ "']/../following-sibling::td//span//i");
	}

	public By PaidAmt(String InvoiceAmtUI) {
		return By.xpath("(//span[@class='ng-binding ng-scope' and text()='" + InvoiceAmtUI
				+ "']/../following-sibling::td//span)[1]");
	}

	public By btnOk = By.xpath("(//button[normalize-space(text())='Ok'])[1]");

	public By itemCodeActionBtn(int indexNo) {
		return By.xpath("(//button[@class='btn btn-primary dropdown-toggle'])[" + indexNo + "]");
	}

	public By itemCodeViewPO = By.xpath("//a[contains(@ng-click,'grid.appScope.poViewModal')]");
	public By PODetail = By.xpath("//h3[text()='PO Detail']");
	public By closePOView = By.xpath("//div[@id='poView']//button[text()='Close']");

	//
	public By closePreviewASN = By.xpath("(//*[contains(@ng-click,'ASN_MODAL')  and text()='Close'])[1]");
	public By closePreviewGRN = By.xpath("(//*[contains(@ng-click,'GRN_MODAL')  and text()='Close'])[2]");

	public By itemCodeViewASN(int i) {
		return By.xpath("(//a[contains(@ng-click,'grid.appScope.asnPreviewFn')])[" + i + "]");
	}

	public By itemCodeViewGRN(int i) {
		return By.xpath("(//a[contains(@ng-click,'grid.appScope.viewGrn')])[" + i + "]");
	}

	public By StatusFilter = By.xpath("//select[@ng-model='statusObj.statusFilter']");
	public By raiseInovice = By.xpath("//span[contains(@ng-click,'raiseInvoiceAction')]");
	public By disputedInvoiceTotalAmt = By.xpath("//h2[contains(@ng-if,'data.totalInvoiceAmount')]/b");
	//public By showList = By.xpath("//a[@data-original-title='Show  List']/i");
	public By penalityDeduction = By
			.xpath("//label[contains(text(),'Penalty Deduction')]/following-sibling::div//input");
	public By approvedAmount = By.xpath("//label[contains(text(),'Approved Amount')]/following-sibling::div//input");
	public By invoiceValidationMessage = By.xpath("//b[text()='Invoice']/../../following-sibling::li");
	public By BidderRegistration = By.xpath("//a[text()='Bidder Registration']");

	public By FreshRegistration = By.xpath("//input[@value='Fresh']");

	public By btnContinue = By.xpath("//button[@id='save']");

	public By SelectCountry = By.xpath("//select[@name='country']");

	public By Pannum = By.xpath("//input[@name='pan']");

	public By Companyname = By.xpath("//input[@name='companyname']");

	public By BuisnessType = By.xpath("//select[@name='naturecompany']");

	public By OfficeAddress = By.xpath("//textarea[@ng-model='vendor.officeaddress']");

	public By City = By.xpath("//input[@name='city']");

	public By State = By.xpath("//select[@name='state']");

	public By Postalcode = By.xpath("//input[@name='postalcode']");

	public By Phoneno = By.xpath("//input[@name='phoneno']");

	public By Faxno = By.xpath("//input[@name='faxno']");

	public By Title = By.xpath("//select[@name='salutation']");

	public By FirstName = By.xpath("//input[@name='firstname']");

	public By LastName = By.xpath("//input[@name='lastname']");

	public By MobileNum = By.xpath("//input[@name='otpMobile']");

	public By Email = By.xpath("//input[@name='otpEmail']");

	public By createRFQFromIndentBy = By.xpath("//span[normalize-space()='Create from Indent']");

	public By IndenttableDataRowsBy = By.xpath("//tbody/tr[1][contains(@ng-repeat,'indent in filterAllTenderData')]");

	public By selectIndentBy = By.xpath("//*[@ng-model='assignmentF.type']");

	public By viewIndentBy = By.xpath("//*[contains(@ng-click,'previewIndentTemplate')][@name='viewWork']");

	public By createRfqDropDownBy = By.xpath("//*[contains(@ng-click,'previewIndentTemplate')][@name='createRFQ']");

	public By revertBy = By.xpath("//*[contains(@ng-click,'setIndentIdForReviewed')]");

	public By systemIntendNoBy = By.xpath("//strong[@class='ng-binding'][text()='System Indent No']");

	public By indentpreviewOkBy = By.xpath("//*[@id='btn-prevOk']/child::span[text()='Ok']");

	public By printBy = By.xpath("//*[@id='myModalprev']//child::button[@id='btn-prev'][contains(text(),'Print')]");

	public By reasonForRevertBy = By.xpath("//*[@id='reviededBack']//textarea[@name='reviewedReason']");

	public By indentRevertSubmitBtnBy = By.xpath("//*[@ng-click='reviewed(reviewed.reviewedReason)']");

	public By sucessMsgIndertRevertedBy = By.xpath("//*[text()='Indent has been reverted successfully.']");

	public By reversalHistoryBy = By.xpath("//*[contains(@ng-click,'fetchAssignmentHistory')]");

	public By revertedStatusBy = By.xpath("//*[@id='assignmentList']//td[text()='Reverted  Back']");

	public By reversalHistoryViewPopUpBy = By.xpath("//*[@id='reversalHistViewModal']//h3");

	public By reversalHistoryViewPopUpOkBtnBy = By
			.xpath("//*[@id='reversalHistViewModal']//h3/../following-sibling::div/button[contains(text(),'Ok')]");

	public By indentAssignmentLinkBy = By.xpath("//a[contains(text(),'Indent Assignment')]");
	public By zeroValueItem = By.xpath("//a[contains(@ng-click,'openZeroValueModal')]");
	public By declarationOfFreeItem = By.xpath("//h3[contains(text(),'Declaration of free Items')]");
	public By clarificationDiscussion = By.xpath("//*[@id='usrmntbLst']/tbody/tr[2]/td[8]/div/ul/li[4]/a");
	public By createGeneralClarificationBtn = By.xpath("//*[@id='main-content-nw']/section/div/div/div[1]/h3/div/a[1]/button");
	public By whyExtra = By.xpath("//th[contains(text(),'Why Extra')]");
	public By quantity = By.xpath("//th/span[contains(text(),'Quantity')]");
	public By addZeroValueItem = By.xpath("//button[@ng-click='saveZeroValueItem()']");
	public By whyExtraTextBox = By.xpath("//input[@ng-model='obj.extraReason']");
	public By quantityTextBox = By.xpath("//input[@ng-model='obj.excessQty']");
	public By addErrorMessage = By.xpath("//div[contains(text(),'Extra Reason is mandatory')]");

	public By excessQuantity(int i) {
		return By.xpath(
				"(//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000C text-right']/div[@title])[" + i + "]");
	}

	public By createFRQBtnBy = By.xpath("//*[@id='myModalprev']//*[contains(text(),'Create RFQ')]");

	public By selectTemplateGroupBy = By.xpath("//*[@ng-model='templategroupId']");

	public By createRFQFromIndentSubmitBtn = By
			.xpath("//*[contains(@ng-click,'createRFQFromIndent')][text()='Submit']");

	public By EmailOTP = By.xpath("//input[@name='validOtpEmail']");

	public By OtpValidity = By.xpath("//div[@ng-show='showOtpValidStatus']");

	public By savevendor = By.xpath("//a[@data-original-title='Save']");

	public By ValidateSubmit = By.xpath("//button[@ng-click='verifyOtp()']");

	public By btnOK = By.xpath("//button[text()='OK']");

	public By TabItemCategory = By.xpath("//a[normalize-space(text())='Item Category']");

	public By TabOrganization = By.xpath("//a[normalize-space(text())='Organization']");

	public By btnGetOTP = By.xpath("//button[@ng-click='getOtp()']");
	public By mobileNoField = By.xpath("//label[contains(text(),'Mobile number is invalid!')]");
	public By showList = By.xpath("//span[@class='ng-binding ng-scope']/../following-sibling::td//span//i");
public By Accommodationandfoodserviceactivities = By.xpath("//span[text()='Accommodation and food service activities']/preceding-sibling::span//span");
	
	public By btnSubmit = By.xpath("//a[@data-original-title='Submit']/button");
	public By brachSubmitButton = By.xpath("(//*[@id='btn-prevOk'])[3]");
	public By UserName = By.xpath("//input[@name='userid']");
	
	public By AcceptDisclaimer = By.xpath("//a[text()='Disclaimer']/../preceding-sibling::span");
	
	public By MasterOrgList = By.xpath("//h3[text()='Master Organization List']/../following-sibling::div/input");
	
	public By addorg = By.xpath("//a[@name='addToOrg']");
	
	public By usercodeunavailable =  By.xpath("//li[text()='Usercode not available']");
	
	public By SubmitUserName = By.xpath("(//button[text()='Submit'])[2]");
	
	public By CharLimit = By.xpath("//input[@name='userid']/../preceding-sibling::label[2]");
	public By OTPValidity = By.xpath("//div[contains(text(),'Resend button will be active in 15 sec(s)')]");
	public By continueWithTRN = By.xpath("//input[@value='UAN']");
	public By TRNNumber = By.xpath("//input[@name='verifyUan']");
	public By verifiedEmailAddress = By.xpath("//input[@name='verifyEmail']");
	public By verifiedMobileNumber = By.xpath("//input[@name='verifyMobile']");
	public By bidderRegsuccessMesg = By.xpath("//div[contains(text(),'Bidder Registration Data Is Submitted Successfully.')]");
	public By editTemplate = By.xpath("//button[contains(@ng-click,'editOrgTemplate')]");
	public By GSTIN = By.xpath("//select[@ng-model='field.value']");
	public By GSTINUpload = By.xpath("//input[@type='file']");
	
	public By OrganizationItemCategory = By.xpath("//a[text()='Organization Item Category']");
	public By OrgDatasuccessMesg = By.xpath("//div[contains(text(),'Organization Data Saved Successfully')]");
	public By saveOrgTabData = By.xpath("//button[contains(@ng-click,'saveOrgTabData')]");
	public By closeOrgDetail = By.xpath("//button[@ng-click='closeEditModal()']");
	public By actionPONum(String PoNum) {
		return By.xpath("//span[text()='"+PoNum+"']/../..//button[@class='btn btn-primary dropdown-toggle' and @data-toggle='dropdown']");
		}
	public By viewAcceptedQuantity(int index) {
		return By.xpath("(//b[text()='Accepted Quantity : ']//../../../following-sibling::div//b)["+index+"]");
		}
	public By MarketPriceVal = By.xpath("(//div[contains(text(),'Decrement')]/../../div)[3]");
	
	//Indent locator
	public By mainMenuIcon = By.xpath("//button[@class='menuBtn']");
	public By indentItemsAddIcon = By.xpath("//*[@class='roundActionBtn m-r-15 cursorCls']");
	public By mainMenuIconSub = By.xpath("//button[@class='menuBtn']");
	public By Requisition = By.xpath("//a[contains(text(),'Requisition')]");
	public By prList = By.xpath("//span[contains(text(),'All PRs')]");
	public By Enquiry = By.xpath("//a[normalize-space()='Enquiry']");
	public By OthersMenu = By.xpath("//a[normalize-space()='Others']");
	public By AllEnquiry = By.xpath("//a[normalize-space()='All Enquires']");
	public By allClarificationOrDiscussion = By.xpath("//a[normalize-space()='All Clarification/Discussion']");
	public By AllEnquiry_Supplier = By.xpath("//span[normalize-space()='All Enquires']");
	public By AllQuotation = By.xpath("//span[contains(text(),'All Quotations')]");
	public By actionEnabled = By.xpath("//select[@name='actionEnabled']");
	public By MyTask= By.xpath("//a[contains(text(), 'My Task')]");
	public By IndentIcon = By.xpath("//span[contains(text(),'All Indents')]");   
	public By IndentCreation = By.xpath("//a[normalize-space()='Indent Creation']");
	public By CreateIndent = By.xpath("//button[@id='automation_indent_list_add']");
	public By quickIndnet = By.xpath("//div[@class='d-flex justify-content-start justify-content-md-end align-items-center'] //a[3]");
	public By estimatedPrice = By.xpath("//*[@id='floatingInputGrid']");
	public By indent_desc = By.xpath("//*[@id='floatingTextarea']");
	public By add_indent_items = By.xpath("//button[text()='Add Indent Items']");
	public By GIindent = By.xpath("//button[@id='GeneralInformation-tab']");
	public By Loader_Indent = By.xpath("//div[@class='spinner']");
	public By Lbl_IndentCreation = By.xpath("//h3[normalize-space()='Indent Creation']");
	public By Indent_TG_select = By.xpath("//select[@name='templateGroup']");
	public By Indent_TG_View = By.xpath("//button[normalize-space()='View']");
	public By Admin = By.xpath("//a[normalize-space()='Admin']");
	public By mailHistory = By.xpath("//*[@id='subMenuBox3']/div/div/ul/li[2]/a");
	public By Others = By.xpath("(//*[contains(text(),'Others')])[2]");
	public By uploadPO = By.xpath("//input[@class='uploadBtncls tabWiseUploadBtn']");
	public By poattachmentTab = By.xpath("//*[@class='mdc-tab__content']/span[text()='Attachments']");
	public By addIconPoAttachments = By.xpath("//*[@id='_po_attachments']/div/div/div[2]/button");
	public By labelAttachmentPO = By.xpath("//*[@id='po_attachments.label.0']");
	public By fileNamePO = By.xpath("//*[@id='po_attachments.file_name.0']");
	public By attachmentPO = By.xpath("//input[@name='po_attachments_attach_file']");
	
	
	public By Code = By.xpath("(//input[@type='text'])[1]");
	public By Name = By.xpath("(//input[@type='text'])[2]");
	public By Unit = By.xpath("(//Select[@class='form-control ng-untouched ng-pristine ng-valid'])[4]");
	public By Rate = By.xpath("(//input[@type='text'])[3]");
	public By qty =  By.xpath("(//input[@type='text'])[4]");
	public By predefinedUserAdd =  By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']");
	public By predefinedApprovalType =  By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-invalid']");
	
	//Supplier PO
	public By order = By.xpath("//a[normalize-space()='Order']");
	public By allOrders = By.xpath("//span[contains(text(),'All Orders')]");
	public By allLOA = By.xpath("//span[contains(text(),'All LOA')]");
	public By poColumn = By.xpath("//thead/tr[1]/th[2]");
	public By poSearchKeyword = By.xpath("//div[@class='tableWrap']/div[1]/input[@placeholder='Type Your Keyword']");
	public By poAction = By.xpath("//div[@class='dropstart']/button");
	public By acceptPO = By.xpath("//a[contains(text(), 'Accept Order')]");
	public By poSummary = By.xpath("//a[contains(text(),'Summary')]");
	public By poCommentTab = By.xpath("//a[contains(text(),'Comment')]");
	public By poCommentTextArea = By.xpath("//textarea[@id='AcceptComment']");
	public By poAcceptButton = By.xpath("//div[@aria-label='First group']/button[2]");
	public By poSaveButton = By.xpath("//button[@id='svact_tb1']");
	public By poRejectButton = By.xpath("//button[@ng-click='goListPage()']");
	public By poAcceptenceConfirm = By.xpath("//button[@data-bb-handler='confirm']");
	public By poPuchaseOrderAcceptedMSG = By.xpath("//div[contains(text(),'Order successfully accepted.')]");
	public By poAcceptFinally = By.xpath("//button[contains(text(),'Ok')]");
	public By poAccetpedStatus = By.xpath("//td[contains(text(), 'Accepted')]");
	public By poDraftStatus = By.xpath("//td[contains(text(), 'Draft')]");
	//Approved ASN list
	public By ApprovedShipments = By.xpath("//span[contains(text(),'Approved shipments')]");
	public By EnterDespatchASNNumber = By.xpath("//input[@placeholder='Enter Despatch/ASN Number']");
	public By completedASN(String ASNno) {
		return By.xpath("//strong[contains(text(),'"+ASNno+"')]");
		}
	public By SupplierName(String SupplierName) {
		return By.xpath("//td[contains(text(),'"+SupplierName+"')]");
		}
	public By ASNactionButton(int ASNno) {
		return By.xpath("//b[contains(text(),'"+ASNno+"')]/../parent::tr/td[9]/div[1]//button[@id='menu1']");
		}
	
	//GRN Creation page
	//Attachment tab
	public By GRNattachment = By.xpath("//a[contains(text(),'Attachment')]");
	public By attachmentLabel = By.xpath("//input[@id='2.label.0']");
	public By uploadGRNattachment = By.xpath("//input[@id='2_attach_file_0']");
	public By AddButtonForGRNcreatorForNotication = By.xpath("//button[@id='addApprovertc']");
	public By selectGRNcreatorForNotication = By.xpath("//input[@list='notificationUsersList']");
	public By UploadAmendAttachment = By.xpath("//input[@file-data='amendSanction']");
	public By CrossButtonForGRNcreatorForNotication = By.xpath("//tr[contains(@ng-repeat, 'row in notificationUsers track')]/td[5]");
	public By ProceedButtonForGRNcreatorForNotication = By.xpath("//span[contains(text(),'Proceed')]");
	
	//GRN Send for Approval Modal
	public By grnSaveButton = By.xpath("//div[@class='pull-right marg_neg_round']/span[1]/button[1]");
	public By grnSubmitButton = By.xpath("//div[@class='pull-right marg_neg_round']/span[1]/button[2]");
	public By storeGRNNumber = By.xpath("//form[@name='approvalFormforGRN']/table[1]/tbody[1]/tr[1]/td[2]");
	public By submitGRNFinally = By.xpath("(//button[@id='cm'])[1]");
	public By sendForApprovalGRN = By.xpath("//button[@id='dyantc']");
	public By sendForApprovalGRN(int loc) {
		return By.xpath("(//button[@id='dyantc'])["+loc+"]");
		}
	public By grnHeaderGRNListPage = By.xpath("//h2[contains(text(), 'GRN List')]");
	public By completedGRNList = By.xpath("//button[contains(text(),'Created')]");
	public By searchBoxGRN = By.xpath("//input[@placeholder]");
	public By reinitiatedmsg = By.xpath("//*[@id='nav-my-indent']/div/table/tbody/tr/td[1]");
	public By notesheetStatus = By.xpath("//*[@id='nav-my-indent']/div/table/tbody/tr[1]/td[6]");
	public By grnExpectedStatus(String status) {
		return By.xpath("//td[contains(text(), '"+status+"')]");
		}
	public By grnInspectionDetails = By.xpath("//strong[contains(text(),'Inspection Details')]");
	public By addButton_GRN = By.xpath("//button[@id='newAddApprovertc']");
	public By user1_GRN = By.xpath("(//input[@ng-model='row.approverIdWithName'])[1]");
	public By user2_GRN = By.xpath("(//input[@ng-model='row.approverIdWithName'])[2]");
	public By user3_GRN = By.xpath("(//input[@ng-model='row.approverIdWithName'])[3]");
	public By user4_GRN = By.xpath("(//input[@ng-model='row.approverIdWithName'])[4]");
	public By approval_type_GRN = By.xpath("(//select[@id='filterTest'])[1]");
	public By approval_type_GRN_WF = By.xpath("(//select[@id='filterTest'])[4]");
	public By CommentsArea_GRN = By.xpath("//textarea[contains(text(),'Please your comment')]");
	public By PendingGRN_Approval = By.xpath("//span[contains(text(),'GRN')]");
	public By grnApproverCommentSection = By.xpath("//textarea[@ng-model='comment']");
	public By grnSuccessMSG = By.xpath("//div[contains(text(),'GRN has been forwarded to next person successfully')]");
	public By grnEND_SuccessMSG = By.xpath("//div[contains(text(),'If you close the workflow,no further modification ')]");
	public By grnEND_SuccessMSG_2 = By.xpath("//div[contains(text(),'Are you really sure that you want to close the wor')]");
	public By grnEND_SuccessMSG_3 = By.xpath("//div[contains(text(),'GRN has been approved successfully')]");
	public By WorkflowInbox = By.xpath("//li[contains(text(),'Workflow Inbox')]");
	
	
	
	//Buyer PO listus
	public By orderFromMenu = By.xpath("//a[contains(text(),'Order')]");
	//Lbl_IndentList (same locator as Indent)
	
	//Indent General information page
	public By IndentRefNo= By.xpath("//input[@id='indent_general_info.indent_ref_no.0']");
	public By IndentCategory = By.xpath("//select[@name='indent_general_info_indent_category']");
	public By IndentCurrency = By.xpath("//select[@name='indent_general_info_indent_currency']");
	public By EstimatedPrice_Indent = By.xpath("//input[@id='indent_general_info.estimat_price.0']");
	public By ProcMode_Indent = By.xpath("//select[@name='indent_general_info_sugg_mode_of_proc']");
	public By GenDesc_Indent = By.xpath("//textarea[@id='indent_general_info.indent_desc.0']");
	public By GenInfo_Remarks_Indent = By.xpath("//textarea[@name='indent_general_info_Remarks']");
	public By GenInfo_NormalEmergency_Indent = By.xpath("//select[@name='indent_general_info_Normal_Emergency']");

	public By Savebtn_Indent = By.xpath("//button[@data-original-title='Save']");
	public By Savebtn_IndentNew = By.xpath("//fa-icon[@class='ng-fa-icon']/parent::button[@theme='light']");
	public By Savebtn_IndentNew1 = By.xpath("//section[@class='contentSection']/div/div/button[2]/fa-icon");
	public By IndentSuccessMessage = By.xpath("//div[@class='customCls']");
	public By IndentSuccessOK = By.xpath("(//button[normalize-space()='Ok'])[2]");
	public By recallSuccessOk = By.xpath("/html/body/div[12]/div/div/div[3]/button");
	public By recallSuccessSNPopup = By.xpath("//button[@data-bb-handler='ok']");
	public By Submitbtn_Indent = By.xpath("//button[@ng-click=\"isIndentApprovable('submit')\"]");
	public By Submitbtn_IndentNew = By.xpath("//section[@class='contentSection']/div/div/button[3]");
	public By Indent_Preview_Btn = By.xpath("//section[@class='contentSection']/div/div/button[1]");
	//Indent Details tab for TG1
	public By IndentDetailsTab = By.xpath("//button[@id='rdcis_indnt_dtls_final_mm-tab']");
	public By TypeOfService_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Type_of_Service_Work']");
	public By Capital_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Nature_of_Indent']");
	public By ModeOfDespatch_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Mode_of_Dispatch']");
	public By PlaceOfDelivery_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Place_of_Delivery']");
	public By DeiveryPeriod_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Contrct_dlivry_priod']");
	public By NoOfYear_TG1IndentDetailsTab = By.xpath("//input[@id='rdcis_indnt_dtls_final_mm.dys_Month_Year.0']");
	public By BasisOfPriceEstimation_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Basis_f_Prce_Estimtn']");
	public By PreBidMeeting_TG1IndentDetailsTab = By.xpath("//select[@name='rdcis_indnt_dtls_final_mm_Pre_Bid_Meeting']");
	
	//Indent Details tab for TG10
	public By IndentDetailsTab_TG10 = By.xpath("//button[@id='rdcis_indnt_dtls_final_cc-tab']");
	public By TypeOfService_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Type_of_Service_Work']");
	public By Capital_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Nature_of_Indent']");
	public By ModeOfDespatch_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Mode_of_Dispatch']");
	public By ModeOfDespatchIfOther_TG1IndentDetailsTab_TG10 = By.xpath("//*[@id='rdcis_indnt_dtls_final_mm.Mode_Disp_Other.0']");
	public By PlaceOfDelivery_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Place_of_Delivery']");
	public By DeiveryPeriod_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Contrct_dlivry_priod']");
	public By NoOfYear_TG1IndentDetailsTab_TG10 = By.xpath("//input[@id='rdcis_indnt_dtls_final_cc.dys_Month_Year.0']");
	public By BasisOfPriceEstimation_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Basis_f_Prce_Estimtn']");
	public By PreBidMeeting_TG1IndentDetailsTab_TG10 = By.xpath("//select[@name='rdcis_indnt_dtls_final_cc_Pre_Bid_Meeting']");
	//Indent Other Information tab for TG1
	public By TG1OtherinformationTab = By.xpath("//button[@id='rdcis_other_info_final-tab']");
	public By WorkofContract_TG1OtherinformationTab = By.xpath("//select[@name='rdcis_other_info_final_Works_Contract']");
	public By PartySite_TG1OtherinformationTab = By.xpath("//select[@name='rdcis_other_info_final_Partys_Site']");
	//Indent Other Information tab for TG10
	public By TG10OtherinformationTab = By.xpath("//button[@id='rdcis_other_info_final_cc-tab']");
	public By WorkofContract_TG10OtherinformationTab = By.xpath("//select[@name='rdcis_other_info_final_cc_Works_Contract']");
	public By PartySite_TG10OtherinformationTab = By.xpath("//select[@name='rdcis_other_info_final_cc_Works_Contract']");
	//Indent BOM Item tab for TG1
	public By TG1IndentBOMItemTab = By.xpath("//button[@id='rdcis_bom_supply_final-tab']"); //modified on 130722
	public By AddNonSORItemBtn_TG1BOMItemTab = By.xpath("//div[@id='rfqItemtabl2-rdcis_bom_supply_final']/div/button[1]"); //modified on 130722
	public By bom_item_action = By.xpath("//*[@id='rfqItemtabl-rdcis_bom_supply_final']/tr[1]/td[18]/div/button");
	public By add_non_sor_child = By.xpath("//*[@id='rfqItemtabl-rdcis_bom_supply_final']/tr[1]/td[18]/div/ul/li[2]/a");
	public By AddInputAlert = By.xpath("(//button[contains(text(), 'Ok')])[2]"); //modified on 201222
	public By ItemCode_TG1BOMItemTab = By.xpath("//input[@id='rdcis_bom_supply_final.item_code.0']"); //Commented on 040123 for 100 items
	public By ItemCode_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_supply_final.item_code."+lineNumber+"']");} 
	public By ItemName_TG1BOMItemTab = By.xpath("//input[@id='rdcis_bom_supply_final.item_name.0']");
	public By ItemName_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_supply_final.item_name."+lineNumber+"']");}
	public By UOM_TG1BOMItemTab = By.xpath("//select[@name='rdcis_bom_supply_final_uom']");
	public By total_amount_parent = By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr[1]/td[10]/div");
	public By gst_value_parent = By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr[1]/td[12]/div");
	public By grandTotal_parent = By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr[1]/td[13]/div");
	public By totalItem_for_items (int lineNumber) { return	 By.xpath("(//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr/td[10]/div)["+lineNumber+"]");}
	public By total_gstValue_for_items (int lineNumber) { return	 By.xpath("(//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr/td[12]/div)["+lineNumber+"]");}
	public By total_grandTotal_for_items (int lineNumber) { return	 By.xpath("(//*[@id=\"_rdcis_bom_supply_final\"]/app-tab-preview/div/div[2]/table/tbody/tr/td[13]/div)["+lineNumber+"]");}
	public By total_amt_sum_section = By.xpath("(//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr/td[10]/div)[7]");
	public By total_amt_gstValue_section = By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr[7]/td[12]/div/div/span");
	public By total_grandtotal_section = By.xpath("//*[@id=\"_rdcis_bom_supply_final\"]/app-tab-preview/div/div[2]/table/tbody/tr[7]/td[13]/div/div/span");
	public By UOM_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//tbody/tr["+lineNumber+"]/td[8]/span[1]/span[1]/app-custom-input[1]/div[1]/div[1]/select[1]");}
	public By Qty_TG1BOMItemTab = By.xpath("//input[@id='rdcis_bom_supply_final.item_qty.0']");
	public By Qty_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_supply_final.item_qty."+lineNumber+"']");}
	public By UnitRate_TG1BOMItemTab = By.xpath("//input[@id='rdcis_bom_supply_final.sor_rate.0']");
	public By UnitRate_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_supply_final.sor_rate."+lineNumber+"']");}
	public By GSTPercent_TG1BOMItemTab = By.xpath("//input[@id='rdcis_bom_supply_final.gst.0']");
	public By GSTPercent_TG1BOMItemTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_supply_final.gst."+lineNumber+"']");}
	//Indent BOM Services Tab for TG1
	public By TG1IndentBOMServicesTab = By.xpath("//button[@id='rdcis_bom_servce_cc_final-tab']");
	public By AddNonSORItemBtn_TG1BOMServicesTab = By.xpath("//div[@id='rfqItemtabl2-rdcis_bom_servce_cc_final']/div[2]/button[1]"); // updated on 201222
	public By ItemCode_TG1BOMServicesTab = By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_code.0']");
	public By ItemCode_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_code."+lineNumber+"']");}
	public By ItemName_TG1BOMServicesTab = By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_name.0']");
	public By ItemName_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_name."+lineNumber+"']");}
	public By UOM_TG1BOMServicesTab = By.xpath("//select[@name='rdcis_bom_servce_cc_final_uom']");
	public By UOM_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//tbody/tr["+lineNumber+"]/td[7]/span[1]/span[1]/app-custom-input[1]/div[1]/div[1]/select[1]");}
	public By Qty_TG1BOMServicesTab = By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_qty.0']");
	public By Qty_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_servce_cc_final.item_qty."+lineNumber+"']");}
	public By UnitRate_TG1BOMServicesTab = By.xpath("//input[@id='rdcis_bom_servce_cc_final.sor_rate.0']");
	public By UnitRate_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_servce_cc_final.sor_rate."+lineNumber+"']");}
	public By GSTPercent_TG1BOMServicesTab = By.xpath("//input[@id='rdcis_bom_servce_cc_final.gst.0']");
	public By GSTPercent_TG1BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='rdcis_bom_servce_cc_final.gst."+lineNumber+"']");}

	public By NextTabLink_Indent = By.xpath("//a[normalize-space()='Next']");
	
	//Indent BOM Services Tab for TG10
	public By TG10IndentBOMServicesTab = By.xpath("//button[@id='bom_car_hiring-tab']");
	public By AddNonSORItemBtn_TG10BOMServicesTab = By.xpath("//div[@id='rfqItemtabl2-bom_car_hiring']/div[2]/button[1]"); // updated on 201222
	public By ItemCode_TG10BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='bom_car_hiring.item_code."+lineNumber+"']");}
	public By ItemName_TG10BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='bom_car_hiring.item_name."+lineNumber+"']");}
	public By Qty_TG10BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='bom_car_hiring.item_qty."+lineNumber+"']");}
	public By Per_Month_TG10Expected_Movement (int lineNumber) { return	 By.xpath("//input[@id='bom_car_hiring.Expected_Movement."+lineNumber+"']");}
	public By UOM_TG10BOMServicesTab (int lineNumber) { return	 By.xpath("//tbody/tr["+lineNumber+"]/td[8]/span[1]/span[1]/app-custom-input[1]/div[1]/div[1]/select[1]");}
	public By NatureOfDuty_TG10 (int lineNumber) { return	 By.xpath("//tbody/tr["+lineNumber+"]/td[5]/span[1]/span[1]/app-custom-input[1]/div[1]/div[1]/select[1]");}
	public By SORRate_TG10BOMServicesTab (int lineNumber) { return	 By.xpath("//input[@id='bom_car_hiring.sor_rate."+lineNumber+"']");}
	//Indent Estimation sheet tab for TG1
	public By TG1IndentEstimationSheetTab = By.xpath("//button[@id='indent_estmtn_sheet_final-tab']");
	//Indent Estimation sheet tab for TG10
	public By TG10IndentEstimationSheetTab = By.xpath("//button[@id='car_hiring_cost_estimate-tab']");
	public By TG10GST = By.xpath("//input[@id='car_hiring_cost_estimate.Sub_Total_GST_persnt.0']");
	public By TG10Parking_Toll_Tax = By.xpath("//input[@id='car_hiring_cost_estimate.Parking_n_TollTax.0']");
	//Indent Technical Specification tab for TG1
	public By TG1IndentTechnicalSpecificationTab = By.xpath("//button[@id='rdcis_cmpl_tech_spe_final-tab']");
	public By Addbtn_TG1TechnicalSpecificationTab = By.xpath("//div[@class='table-responsive ng-star-inserted']/div/button[1]");
	public By ClauseNo_TG1TechnicalSpecificationTab = By.xpath("//input[@id='rdcis_cmpl_tech_spe_final.Clause_subcla_No.0']");
	public By ClauseHeaderTitle_TG1TechnicalSpecificationTab = By.xpath("//input[@id='rdcis_cmpl_tech_spe_final.Clause_Header_Title.0']");
	//Indent Eligibility Criteria tab for TG10
	public By TG10IndentTechnicalSpecificationTab = By.xpath("//button[@id='compln_tech_spec_cc_final-tab']");
	public By Addbtn_TG10TechnicalSpecificationTab = By.xpath("//div[@class='table-responsive ng-star-inserted']/div/button[1]");
	public By ClauseNo_TG10TechnicalSpecificationTab = By.xpath("//input[@id='compln_tech_spec_cc_final.Clause_subcla_No.0']");
	public By ClauseHeaderTitle_TG10TechnicalSpecificationTab = By.xpath("//input[@id='compln_tech_spec_cc_final.Clause_Header_Title.0']");
	//Indent Annexures tab for TG1
	public By TG1IndentAnnexuresTab = By.xpath("//button[@id='indent_attachment-tab']");
	public By Addbtn_TG1AnnexuresTab = By.xpath("//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub pull-right margadj']");
	public By AddAtachmentLbl_TG1AnnexuresTab = By.xpath("//div[contains(@class,'modal fade in')]//h3[normalize-space()='Add Attachment']");
	public By AnnexuresType_TG1AnnexuresTab = By.xpath("//div[contains(@class,'modal fade in')]//select[@id='indent_attachment.label.0']");
	public By InpuFilename_TG1AnnexuresTab = By.xpath("//div[contains(@class,'modal fade in')]//input[@id='indent_attachment.file_name.0']");
	public By AttachFile_TG1AnnexuresTab = By.xpath("//input[contains(@ng-click,'aaaa()')]");
	public By OKBtn_TG1AnnexuresTab = By.xpath("//button[@id='add-authorRow']");
	public By AnnexuresType = By.xpath("//*[@id='indent_attachment.label.0']");
	//Indent workflow page
	public By Lbl_SendforApproval_Indent = By.xpath("//app-workflowmodal[@class='ng-star-inserted']/div/div/h5"); //modified on 140722
	public By SystemIndentNo = By.xpath("//div[@class='lthpTitle']/div[1]/div[1]");
	public By UserDefinedWFchkbox_Indent = By.xpath("//div[@class='d-sm-flex justify-content-sm-start align-items-center']/label[2]/span"); //modified on 140722
	public By UserDefinedWFchkbox_Notesheet = By.xpath("//div[@class='d-sm-flex justify-content-sm-start align-items-center']/label[1]/span");
	public By NotReqdWFchkbox_Indent = By.xpath("//input[@id='appNo']/following-sibling::span");
	public By CompleteIndentbtn = By.xpath("//button[contains(text(),'Submit')]");
	public By NoOfIndentRowinApproval = By.xpath("//table[@id='approver']/tbody/tr"); //modified on 140722
	public By cancelUser1_Indent = By.xpath("//a[@class='tblCirBtnSm tblCross blu ng-star-inserted']"); //modified on 140722
	public By cancelUserNotesheet = By.xpath("//a[@class='tblCirBtnSm tblCross blu ng-star-inserted']");
	
	//Indent preview page locator  @pavel 
	public By generalTabPreviewData = By.xpath("//*[@class='col-xl-6 ng-star-inserted']/fieldset/div");
	public By arrowIcon = By.xpath("//a[@name='add2Group']");
	public By discussionSearchUser = By.xpath("//input[@name='userFilter']");
	public By discussionSearchUser_notesheet = By.xpath("//input[@placeholder='Type any keyword']");
	public By b1usercomment = By.xpath("//textarea[@class='form-control ng-untouched ng-pristine ng-invalid']");
	public By b1EvaluationUserComment = By.xpath("//textarea[@ng-model='user.comment']");
	public By b2EvaluationUserComment = By.xpath("(//textarea[@ng-model='user.comment'])[2]");
	public By coordinatorCheckbox = By.xpath("//*[@id='approver']/tbody/tr[6]/td[5]/label/span");
	public By minApprover = By.xpath("//*[@id='approver']/tbody/tr[6]/td[6]/span/input");
	public By b2usercommnet = By.xpath("(//*[@id='buttonHolder']/tr/td[2]/div/textarea)[2]");
	public By b3usercommnet = By.xpath("(//*[@id='buttonHolder']/tr/td[2]/div/textarea)[3]");
	public By remarksforDiscussion = By.xpath("//textarea[@class='form-control ng-pristine ng-valid ng-touched']");
	public By usernameatDiscussion = By.xpath("//*[contains(text(),'Username')]");
	public By generalTab = By.xpath("(//div[@class='mat-tab-labels']/div/div)[1]");
	public By templategroupnameInIndentPreview = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[1]/fieldset/div[1]/span");
	public By Indent_description_001 = By.xpath("//*[@class='col-xl-6 ng-star-inserted'][5]/fieldset/div");
	public By toggleView = By.xpath("//*[@id='toggleOverRide']/label/span[1]");
	public By itemCheckbox = By.xpath("//*[@id='rfqItemtabl-rdcis_bom_supply_final']/tr/td[1]/input");
	public By deleteItemIndent = By.xpath("//*[@id='rfqItemtabl2-rdcis_bom_supply_final']/div[2]/button[5]");
	public By templategroupName = By.xpath("//*[@id='collapse1']/app-n-col-preview/div/div/div/div/div[1]/fieldset/div");
	public By NormalEmergency = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[8]/fieldset/div");
	public By indentCategory = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[9]/fieldset/div");
	public By indentCurrency = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[11]/fieldset/div");
	public By suggestedModeofTendering = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[15]/fieldset/div");
	public By remarkss = By.xpath("//*[@id='_indent_general_info']/app-tab-preview/div/div/div/div/div[17]/fieldset/div");
	
	
	public By tenderIDinBidPreview = By.xpath("//*[@id='_quot_gen_info']/div[2]/div/table/tbody/tr[1]/td[1]/div/div[2]/span/div/span");
	public By qRcBidPreview = By.xpath("//*[@id='_quot_gen_info']/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/span/div/span");
	public By TermsandConditionBidPreview = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[2]/a");
	public By clauseSubClauseNoBidPreview = By.xpath("//*[@id='_rdcis_quotatn_trms_cnditn']/div[2]/table[2]/tbody/tr/td[2]/label/span/span");
	public By ClauseSubClauseHeaderTitleBidPreview = By.xpath("//*[@id='_rdcis_quotatn_trms_cnditn']/div[2]/table[2]/tbody/tr/td[3]/label/span/span");
	public By TechnicalComplienceTabBidPreview = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[3]/a");
	public By RemarksBidPreview = By.xpath("//*[@id='_rdcis_quotatn_trms_cnditn']/div[2]/table[2]/tbody/tr/td[7]/label/span/span");
	public By ClauseSubClauseNoTechnicalComplienceBidPreview = By.xpath("//*[@id='_rdcis_quotaton_tech_speci']/div[2]/table[2]/tbody/tr/td[2]/label/span/span");
	public By ClauseSubClauseHeaderTitleTechnicalComplienceBidPreview = By.xpath("//*[@id='_rdcis_quotaton_tech_speci']/div[2]/table[2]/tbody/tr/td[3]/label/span/span");
	public By remarksTechnicalComplienceBidPreview = By.xpath("//*[@id='_rdcis_quotaton_tech_speci']/div[2]/table[2]/tbody/tr/td[7]/label/span/span");
	public By attachmentsBidPreviewTab = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[4]/a");
	public By supplierspecificattacment = By.xpath("//*[@id='_qout_attachment']/div/div[2]/table[2]/tbody/tr[2]/td[8]/label/span/i");
	public By technicalBidPreviewTab = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[5]/a");
	public By ItemCodeTechnicalTabBidPreview (int lineNumber) { return	 By.xpath("//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div");}
	public By itemNameTechnicalBidPreview (int lineNumber) { return	 By.xpath("//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[3]/div");}
	public By unitTechnicalBidPreview (int lineNumber) { return	 By.xpath("//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[3]/div/span/span/span");}
	public By qtyTechnicalBidPreview (int lineNumber) { return	 By.xpath("//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[4]/div/span/span/span[2]");}
	public By specificationandtechnicalComplianceTab = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[6]/a");
	
	public By ItemCodestrTabBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[2]");}
	public By itemNamestrBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[3]/div)[2]");}
	public By unitstrBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[4]/div)[2]");}
	public By qtystrBidPreview (int lineNumber) { return	 By.xpath("//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[5]/div/span/span/span[2]/span[1]");}
	
//	public By ItemCoderfqTabBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[3]");}
	public By itemNamerfqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[3]");}
	public By unitrfqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[3]/div)[3]");}
	public By qtyrfqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[4]/div)[3]");}
	public By unitRaterfqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[5]/div)[2]");}

	
	
	
//	public By ItemCodeboqTabBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[4]");}
	public By itemNameboqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[4]");}
	public By unitboqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[4]/div)[2]");}
	public By qtyboqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[5]/div)[3]");}
	public By unitRateboqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[6]/div)[2]");}
	
	
	
	public By itemcodespecandtechReqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div)[4])");}
	public By itemNamespecandtechReqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[2]/table/tbody/tr["+lineNumber+"]/td[3]/div)[4])");}
	public By unitspecandtechReqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[4]/div)[4]");}
	public By qtyspecandtechReqBidPreview (int lineNumber) { return	 By.xpath("(//*[@id='target']/div/div[1]/div[4]/table/tbody/tr["+lineNumber+"]/td[5]/div)[4]");}
	
	public By commertialParametersComplanceTabbidPreview = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[7]/a");
	public By generalReqEquipDetailsBidPrev = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[8]/a");
	public By nameandAddofVendorBidPrev = By.xpath("//*[@id='_ordr_placement_details']/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/span/div/span");
	
	public By otherClauseBidPrev = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[9]/a");
	
	public By registeredinGemBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[1]/td[1]/div/div[2]/span/div/span");
	public By gemVendorCodeBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/span/div/span");
	public By startupBidderBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[1]/td[3]/div/div[2]/span/div/span");
	public By psuorGovtOrganizationBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[2]/td[1]/div/div[2]/span/div/span");
	public By represntingOtherFirmBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[2]/td[2]/div/div[2]/span/div/span");
	public By detailOfFirmBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[2]/td[3]/div/div[2]/span/div/span");
	public By Section6CompaniesBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[3]/td[1]/div/div[2]/span/div/span");
	public By detailsOfRelationshipBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[3]/td[2]/div/div[2]/span/div/span");
	public By MSMESSINSICBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[3]/td[3]/div/div[2]/span/div/span");
	public By UANNumberBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[4]/td[2]/div/div[2]/span/div/span");
	public By EntrepreneursMemorandumNoBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[4]/td[3]/div/div[2]/span/div/span");
	public By typeofEnterpriseBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[5]/td[1]/div/div[2]/span/div/span");
	public By majorActivityBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[5]/td[2]/div/div[2]/span/div/span");
	public By typeofOrganizationBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[5]/td[3]/div/div[2]/span/div/span");
	public By WomenOwnedMSMEBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[6]/td[1]/div/div[2]/span/div/span");
	public By genderBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[6]/td[2]/div/div[2]/span/div/span");
	public By PhysicallyHandicappedBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[6]/td[3]/div/div[2]/span/div/span");
	public By SocialOwnershipCategoryBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[7]/td[1]/div/div[2]/span/div/span");
	public By LocationofPlantBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[7]/td[2]/div/div[2]/span/div/span");
	public By TypeofYourFirmForTheTenderedItemBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[7]/td[3]/div/div[2]/span/div/span");
	public By ifselectedAnyOtherBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[8]/td[1]/div/div[2]/span/div/span");
	public By registeredinMSMEDatabankBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[8]/td[2]/div/div[2]/span/div/span");
	public By TenderedItemServiceCategoryBidPrev = By.xpath("//*[@id='_gem_msme_certifcte_detail']/div[2]/div/table/tbody/tr[8]/td[3]/div/div[2]/span/div/span");

	public By PaymentTabBidPreview = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[10]/a");
	public By bankNameBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[2]/td[1]/label");
	public By branchNameBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[2]/td[2]/label");
	public By InstrumentNumberBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[3]/td[1]/label");
	public By InstrumentDateBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[4]/td[1]/label");
	public By commentBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[4]/td[2]/label");
	public By InstrumentExpiryDateBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[5]/td[1]/label");
	public By uploadFileDownloadBtnBidPrev = By.xpath("//*[@id='_quotation_payment']/table[2]/tbody/tr[5]/td[2]/label/span/i");
	
	public By rfqItemBidPrev = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[11]/a");
	
	public By BoqMandetoryBidPrev = By.xpath("//*[@id='bidPreviewTabWiseModal']/div/div/div[2]/div/div/div/div[1]/div/div[1]/ul/li[12]/a");

	
	
	
	
	
	public By bidPartsPreview = By.xpath("//*[@id='collapsetendergeninfo']/div/div/div/div[2]/div[1]/fieldset/div");
	public By tenderRefPreview = By.xpath("//*[@id='collapsetendergeninfo']/div/div/div/div[2]/div[6]/fieldset/div");
	public By minNoOfBidsPreview = By.xpath("//*[@id='collapsetendergeninfo']/div/div/div/div[5]/div[1]/fieldset/div");
	
	public By TermsandConditionPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='Terms and Conditions']");
	public By clauseNoPreview = By.xpath("//*[@id='_rdcis_rfq_terms_cnditions']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	public By clauseHeaderTitlePreview = By.xpath("//*[@id='_rdcis_rfq_terms_cnditions']/app-tab-preview/div/div[2]/table/tbody/tr/td[3]/div/span");
	
	public By GeneralRequirementEquiptmentDetailsPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='General Requirement Equiptment Details']");
	
	public By GeneralInformationClausesPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='General Information Clauses']");
	
	public By attachmentTenderPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='Attachments']");
	public By annextureTypePreview = By.xpath("//*[@id='_rfqattachment']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	public By annexturedownloadIconPreview = By.xpath("//*[@id='_rfqattachment']/app-tab-preview//..//*[@data-icon='download']");
	
	public By RequredattachmentPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='Required Attachment']");
	public By supportingDocPreview = By.xpath("//*[@id='_requiredbidderattachment']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	
	public By PrebidDiscussionPreview = By.xpath("//*[@class='mat-tab-label-content' and text()='Pre-bid Discussion']");
	
	public By PaymentPreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='Payment']");
	public By PaymentCurrencyPreview = By.xpath("//*[@id='_rfqpayment']/app-tab-preview/div/div[2]/table/tbody/tr/td[4]/div/span");
	public By paymentAmmountPreview = By.xpath("//*[@id='_rfqpayment']/app-tab-preview/div/div[2]/table/tbody/tr/td[5]/div/span");
	
	public By ProectDetailsPreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='Project Details']");
	
	public By TechnicalPreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='Technical']");
	public By ClauseSubClauseNoPreview = By.xpath("//*[@id='_rdcis_rfq_cmpl_tech_speci']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	public By ClauseSubClauseHeaderTitle_preview = By.xpath("//*[@id='_rdcis_rfq_cmpl_tech_speci']/app-tab-preview/div/div[2]/table/tbody/tr/td[3]/div/span");
	
	public By RfqItemPreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='RFQ Item']");
	public By RFQItemCodePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div/span");}
	public By RFQItemNamePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[5]/div/span");}
	public By RFQItemUnitPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[7]/div/span");}
	public By RFQItemQtyPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[8]/div/span");}
	public By RFQItemUnitRatePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[9]/div/span");}
	public By RFQItemGstPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_supply']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[11]/div/span");}
	
	public By boqMandetoryPreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='BOQ (Mandatory)']");
	public By BOQ_ItemCodePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div/span");}
	public By BOQ_ItemNamePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[5]/div/span");}
	public By BOQ_ItemUnitPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[6]/div/span");}
	public By BOQ_ItemQtyPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[7]/div/span");}
	public By BOQ_ItemUnitRatePreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[8]/div/span");}
	public By BOQ_ItemGstPreviewDetails (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_rfq_bom_services']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[10]/div/span");}
	
	public By dateSchedulePreviewTab = By.xpath("//*[@class='mat-tab-label-content' and text()='Date Schedule']");
	public By BidSubmissionStartDateTimePreview  = By.xpath("//*[@id='_rfqdate']/app-tab-preview/div/div/div/div/div[1]/fieldset/div");
	public By BidSubmissionClosingDateTimePreview = By.xpath("//*[@id='_rfqdate']/app-tab-preview/div/div/div/div/div[2]/fieldset/div");
	public By BidOpeningDateTimePreview = By.xpath("//*[@id='_rfqdate']/app-tab-preview/div/div/div/div/div[3]/fieldset/div");
	
	public By BOMitemcode_preview (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div/span");} 
	public By BOMitemname_preview (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[5]/div/span");} 
	public By BOMUnit (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[7]/div/span");}
	public By BOMQty (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[8]/div/span");}
	public By BOMUnitRate (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[9]/div/span");}
	public By BOMGST (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_supply_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[11]/div/span");}
	
	public By BOMServicescode_preview (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[2]/div/span");} 
	public By BOMServicesname_preview (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[5]/div/span");} 
	public By BOMServicesUnit (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[6]/div/span");}
	public By BOMServicesQty (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[7]/div/span");}
	public By BOMServicesUnitRate (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[8]/div/span");}
	public By BOMServicesGST (int lineNumber) { return	 By.xpath("//*[@id='_rdcis_bom_servce_cc_final']/app-tab-preview/div/div[2]/table/tbody/tr["+lineNumber+"]/td[10]/div/span");}
	
	public By indentDetailsPreviewTab = By.xpath("(//div[@class='mat-tab-labels']/div/div)[2]");
	public By TypeofServiceWorkpreview = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[1]/fieldset/div");
	public By CapitalRevenuepreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[3]/fieldset/div");
	public By ModeofDispatchpreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[5]/fieldset/div");
	public By PlaceofDeliverypreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[7]/fieldset/div");
	public By ContractCompletionDeliveryPeriodpreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[9]/fieldset/div");
	public By NumberofYearMonthDaypreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[10]/fieldset/div");
	public By BasisofPriceEstimationpreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[21]/fieldset/div");
	public By PreBidMeetingpreview  = By.xpath("//*[@id='_rdcis_indnt_dtls_final_mm']/app-tab-preview/div/div/div/div/div[22]/fieldset/div");
	
	public By otherInformationpreviewTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[3]");
	public By worksContractPreview  = By.xpath("//*[@id='_rdcis_other_info_final']/app-tab-preview/div/div/div/div/div[7]/fieldset/div");
	public By partysitepreview  = By.xpath("//*[@id='_rdcis_other_info_final']/app-tab-preview/div/div/div/div/div[16]/fieldset/div");
	
	public By bomItempreviewTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[4]");
	public By bomServicespreviewTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[5]");
	public By estimationsheetprevireTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[6]");
	
	public By technicalSpecificationPreviewTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[7]");
	
	public By clauseSubClauseNoPreview  = By.xpath("//*[@id='_rdcis_cmpl_tech_spe_final']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	public By ClauseSubClauseHeaderTitlePreview  = By.xpath("//*[@id='_rdcis_cmpl_tech_spe_final']/app-tab-preview/div/div[2]/table/tbody/tr/td[3]/div/span");
	
	public By indentPreviewnextarrowbutton  = By.xpath("//*[@id='nav-tab']/mat-tab-group/mat-tab-header/button[2]");
	
	public By annexturetabpreview  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[8]");
	public By AnnexureTypepreview= By.xpath("//*[@id='_indent_attachment']/app-tab-preview/div/div[2]/table/tbody/tr/td[2]/div/span");
	public By AnnexureAttachFilepreview= By.xpath("//*[@id='_indent_attachment']/app-tab-preview/div/div[2]/table/tbody/tr/td[3]/div/span[1]");
	public By annextureDownloadButtonPreview= By.xpath("//*[@id='_indent_attachment']/app-tab-preview/div/div[2]/table/tbody/tr/td[3]/div/span[2]");
	
	public By indentByPreviewclosebutton= By.xpath("//button[@class='btn-close ms-sm-2']");
	
	public By approvalHistoryPreviewTab  = By.xpath("(//div[@class='mat-tab-labels']/div/div)[9]");
	
	public By allcommentsINPreviewByPage  = By.xpath("//span[@class='comments']");
	
	public By loadingOverlay  = By.xpath("//div[@id='overlay']");
	
	public By tabContent  = By.xpath("//div[@class='tab-content']");
	
	//delete Indent feature @pavel
	public By indentlist  = By.xpath("//li[@class='breadcrumb-item']//following-sibling::li[1]/a");
	public By deleteIndentLocator  = By.xpath("//a[normalize-space()='Delete']");
	public By deleteRemarks  = By.xpath("//*[@id='deletionRemarks']");
	public By deleteindentAttachment  = By.xpath("//*[@class='customFile']");
	public By submitbuttonIndentCancel  = By.xpath("//button[text()='Submit']");
	public By submit_delete_sn  = By.xpath("//button[contains(text(),'Submit')]");
	public By submitBybuttonRecallEvaluation  = By.xpath("//button[@ng-click='recallTenderEvalApprover(recalReasonTenderEval)']");
	public By indesntCancelSuccessMessageOkButton  = By.xpath("//button[@class='btn btn-primary']");
	public By sendBack  = By.xpath("//button[contains(text(),'Send Back')]");
	public By cancelIndent  = By.xpath("//a[normalize-space()='Cancel Indent']");
	public By cancelIndentAttachFile  = By.xpath("//input[@id='cancelIndentAttachfile']");
	public By cancelIndentReason  = By.xpath("//*[@id='cancellationReason']");
	public By userdefineApprovalcancelindent  = By.xpath("//*[@id='staticBackdrop']/div/div/div[2]/div/div[2]/form/fieldset/div/div/div/div[2]/label/span");
	public By sectionWiseCommentNoRadio = By.xpath("//*[@id='staticBackdrop']/div/div/div[2]/div/div[2]/form/div[3]/fieldset/div/div/label[2]/span");
	public By canceluserinApprover = By.xpath("//a[contains(@class,'tblCirBtnSm tblCross blu')]");
	public By adduserIcon = By.xpath("//*[@class='mat-icon notranslate material-icons mat-ligature-font mat-icon-no-color']");
	public By sendForCancellationApproval = By.xpath("//*[@id='dyantc']");
	public By cancelledIndentTab = By.xpath("//*[@id='nav-cancelled-indent-tab']");
	public By cancelledIndentTabSN = By.xpath("//*[@id='nav-cancelled-loa-tab']");
	public By cancelIndentTabAtApproverEnd = By.xpath("//span[normalize-space()='Cancel Indent']");
	public By actionButtonCancelIndent = By.xpath("//*[@id='cancelIndent']/div/div/table/tbody/tr/td/div/button");
	public By sectionWiseViewCancelIndent = By.xpath("//*[@id='myTable']/tbody/tr/td[9]/div/ul/li[1]/a");
	public By cancelIndentStatus = By.xpath("//*[@id='nav-cancelled-indent']/div/table/tbody/tr[1]/td[7]");
	public By cancelDeletedNotesheetStatus = By.xpath("//*[@id='nav-cancelled-indent']/div/table/tbody/tr/td[5]");
	public By indentTabs = By.xpath("//nav[@class='customTableTab']/div/button");
	public By ASN_status = By.xpath("//*[@id='v-tabContent']/div/table/tbody/tr/td[8]");
	public By searchMail = By.xpath("//input[@placeholder='Subject/Event/To/Cc/Bcc']");
	public By selectOrganization = By.xpath("//select[@name='templateGroup']");
	public By preDefinedWorkflow = By.xpath("//div[@class='d-sm-flex justify-content-sm-start align-items-center']/label[1]/span");

	public By mailTableBody = By.xpath("//*[@id='main-content-nw']/section/div[1]/div/div[2]/div/div[2]/table/tbody");
	public By ActionForBidderCommentMail = By.xpath("//p[contains(text(),'152')]/parent::td//following-sibling::td/div//*[@id='menu1']");
	public By viewMessagebutton = By.xpath("//p[contains(text(),'152')]/parent::td//following-sibling::td/div//*[@id='menu1']//following-sibling::ul");
	public By discussionButton = By.xpath("//button[normalize-space()='Discussion']");
	public By viewmailBody = By.xpath("//*[@id='viewMailDetails']/div/div/div[2]/div[2]/div/div");
	public By branchingButton = By.xpath("//*[@id='main-content-nw']/section/div/div/div[1]/h3/div/a[1]/button/i");
	//public By userAdd_Indent = By.xpath("//table[@id='approver']/thead/tr[1]/th[7]/div/button[@id='addApprovertc']");
	public By userAdd_Indent = By.xpath("//th/a/fa-icon[@class='ng-fa-icon']"); //added on 220722
	public By user1_Indent = By.xpath("//table[@id='approver']/tbody/tr[1]/td[2]/input");
	public By user2_Indent = By.xpath("//table[@id='approver']/tbody/tr[2]/td[2]/input");
	public By user3_Indent = By.xpath("//table[@id='approver']/tbody/tr[3]/td[2]/input");
	public By user4_Indent = By.xpath("//table[@id='approver']/tbody/tr[4]/td[2]/input");
	public By user5_Indent = By.xpath("//table[@id='approver']/tbody/tr[5]/td[2]/input");
	public By user6_Indent = By.xpath("//table[@id='approver']/tbody/tr[6]/td[2]/input");
	public By user7_Indent = By.xpath("//table[@id='approver']/tbody/tr[7]/td[2]/input");
	public By user8_Indent = By.xpath("//table[@id='approver']/tbody/tr[8]/td[2]/input");
	public By user9_Indent = By.xpath("//table[@id='approver']/tbody/tr[9]/td[2]/input");
	public By user10_Indent = By.xpath("//table[@id='approver']/tbody/tr[10]/td[2]/input");
	public By user11_Indent = By.xpath("//table[@id='approver']/tbody/tr[11]/td[2]/input");
	public By user12_Indent = By.xpath("//table[@id='approver']/tbody/tr[12]/td[2]/input");
	public By user13_Indent = By.xpath("//table[@id='approver']/tbody/tr[13]/td[2]/input");
	public By parallelCoordinator = By.xpath("//*[@id='approver']/tbody/tr[4]/td[5]/label/span");
	public By parallelCoordinatorindent = By.xpath("//*[@id='approver']/tbody/tr[3]/td[5]/label/span");
	public By minimumApprover = By.xpath("(//span[contains(@class, 'ng-star-inserted')]/input)[3]");
	public By minimumApproverSN = By.xpath("//*[@id='approver']/tbody/tr[5]/td[6]/span/input");
	public By minimumApprovertenderApproval = By.xpath("//*[@id='addapprover']/tbody/tr[5]/td[6]/label/input");
	public By minimumApproverPO = By.xpath("//*[@id='approver']/tbody/tr[4]/td[6]/span/input");
	public By minimumApproverPO1 = By.xpath("//*[@id='approver']/tbody/tr[3]/td[8]/span/input");
	public By parallelApprovermin = By.xpath("//input[@placeholder='-Enter Min Approver-']");
	public By parallelApproverminPO = By.xpath("//*[@id='approver']/tbody/tr[3]/td[6]/span/input");
	public By parallelApproverminNotesheet = By.xpath("//*[@id='approver']/tbody/tr[3]/td[8]/span/input");
	public By parallelappNotesheetCoordinator = By.xpath("//*[@id='approver']/tbody/tr[3]/td[7]/label/span");
	public By Coordinator3User = By.xpath("//*[@id='2']/following-sibling::span");
	public By confirmButton = By.xpath("//div[contains(@class, 'd-sm-flex')]//button[contains(text(), 'Yes')]");
	public By success_text = By.xpath("//h5[contains(text(),'Success')]");
	public By warningYes = By.xpath("//*[@class='mainInfotxt' and text()='Warning']//..//*[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0' and text()='Yes']");
	public By success_msg = By.xpath("//div[contains(text(),'The indent has been forwarded to next person succe')]");
	public By review_success_msg = By.xpath("//div[contains(text(),'The indent has been reviewed successfully.')]");
	public By approval_success_msg = By.xpath("//div[contains(text(),'The indent has been approved successfully.')]");
	public By success_Ok_button = By.xpath("//div[contains(@class, 'modal-footer')] //button[contains(text(), 'Ok')]");
	
	//public By approverType1_Indent = By.xpath("(//div[contains(@class,'modalsnd-main fade in')]//select[@id='filterTest'])[1]");
	public By approverType1_Indent = By.xpath("//select[contains(@class, 'form-select ng-untouched ng-pristine ng-invalid')]");
	public By activity_process =By.xpath("(//select[contains(@class, 'form-select ng-untouched ng-pristine ng-invalid')])[1]");
	public By role =By.xpath("(//select[contains(@class, 'form-select ng-untouched ng-pristine ng-invalid')])[2]");
	public By approvalTypeNotesheet =By.xpath("(//select[contains(@class, 'form-select ng-untouched ng-pristine ng-invalid')])[3]");
	//public By CommentsArea_Indent = By.xpath("//div[contains(@class,'modalsnd-main fade in')]//textarea[@name='approvalComment']");
	public By CommentsArea_Indent = By.xpath("//textarea[@id='mytextarea']"); //added on 220723
	public By CommentsArea_IndentRTF = By.xpath("//div[@role='presentation'][2]/div/p"); //added on 200322
	public By CommentsArea_Notesheet = By.xpath("(//div[@role='presentation'][2]/div/p)[2]");
	public By Btn_Forward_Indent = By.xpath("//button[@id='dyantc']");
	public By notesheet_status = By.xpath("//div[@class='mdc-tooltip__surface mdc-tooltip__surface-animation']");
	public By LOA_status = By.xpath("//*[@id='nav-my-loa']/div/table/tbody/tr[1]/td[7]");
	public By statusIcon = By.xpath("//*[@id='clrcookie']");
	public By send_for_approval = By.xpath("(//span[@class='ng-star-inserted' and text()='Send For Approval'])[2]");
	public By sendforApprovalSubmitCorrigendum = By.xpath("(//button[@id='dyantc'])[2]");
	//public By Btn_SendforApproval_Indent = By.xpath("//*[@id='mat-dialog-2']/app-workflowmodal/div/mat-dialog-actions/div/button[2]");
	public By Btn_SendforApproval_Indent = By.xpath("//button[contains(@class, 'btn modalBtnBlue mx-2 mb-2 mb-sm-0 ng-star-inserted')]//span[contains(text(), 'Send For Approval')]");
	public By CancelOrderSendForApproval = By.xpath("//span[text()='Cancel Order']");
	public By selectIndentStatus = By.xpath("//*[@id='indentFstatus']");
	public By LifeCycle = By.xpath("//a[@class='dropdown-item' and text()='Life Cycle']");
	public By indentHyperLink = By.xpath("//*[@id='staticBackdropLabel']/a");
	public By identPreviewPageText = By.xpath("//strong[contains(text(),'Tab Wise Indent Preview')]");
	public By coordinatorSeq = By.xpath("//*[@id='approver']/tbody/tr[8]/td[7]/label/span");
	public By IndentListLink = By.xpath("//a[normalize-space()='Indent List']");
	public By Lbl_IndentList = By.xpath("//li[contains(text(),'Indent List')]");
	public By myindent= By.xpath("//li[contains(text(),'Indent List')]");
	public By tenderID= By.xpath("//*[@id='tenderNo']");
	public By IndentRowResult= By.xpath("//table[contains(@class, 'table customTable listTable')]/tbody/tr/td[1]");
	public By IndentRowResult (String indentno) {return By.xpath("//table[contains(@id,'myTablebyrTl00')]//tr[@class='ng-scope']//td[contains(@title,'"+indentno+"')]");}
	public By IndentRowResultFromIndent (String indentno) {return By.xpath("//td[contains(@title,'"+indentno+"')]");}
	public By IndentRowResultFromTender (String indentno) {return By.xpath("//a[contains(@data-content,'"+indentno+"')]");}
	public By IndentStatus_ListPage = By.xpath("//table[contains(@class,'table customTable listTable')]//tr/td[6]");
	public By IndentStatus_Delete_CancelledTab = By.xpath("//*[@id='nav-cancelled-indent']/div/table/tbody/tr[1]/td[7]");
	public By SNStatus_Delete_CancelledTab = By.xpath("//*[@id='nav-cancelled-loa']/div/table/tbody/tr[1]/td[9]");
	public By ActionButton=By.xpath("//div[@class='dropstart']/button");
	public By processedPRTab=By.xpath("//*[@id='_pr_tab-tab' and text()= ' Processed']");
	public By downloadCS=By.xpath("//*[contains(text(),'Download CS')]");
	public By XLSX_Select=By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-valid']");
	public By bidpartcheckbox=By.xpath("//input[@type='checkbox' and @name='nonCheck']");
	public By downloadWFReport=By.xpath("//a[contains(text(), 'Download Workflow Report')]");
	public By clarification_discussion=By.xpath("//a[contains(text(), 'Clarification/Discussion')]");
	public By lifeCycle=By.xpath("//a[contains(text(), 'Life Cycle')]");
	public By selectDocType=By.xpath("//div[@class='row customForm']/div/select");
	public By desc=By.xpath("//*[@id='desc']");
	public By create=By.xpath("//*[@id='creatChannelModal']/div/div/div[3]/button[2]");
	public By adduser=By.xpath("//*[@data-bs-title='Add User']");
	public By supplier=By.xpath("//*[@id='supplierUserType']");
	public By typeText=By.xpath("//input[@placeholder='Type text to filter']");
	public By checkbox=By.xpath("(//input[@name='check'])[1]");
	public By addvendor=By.xpath("//button[text()='Add']");
	public By confirmYes=By.xpath("//button[@data-bb-handler='confirm']");
	public By typeMessage=By.xpath("//*[@id='floatingTextarea']");
	public By sendMessage=By.xpath("//*[@id='msgBox']/div[1]/div[4]/div/div[2]/div[2]/button[1]/i");
	public By plusIcon=By.xpath("//*[@data-icon='plus']");
	public By createChannel=By.xpath("//*[@id='msgBox']/div[1]/div[1]/div/div[2]/a/i");
	public By tagName=By.xpath("//select[@name='tagname']");
	public By submitrecallMSN=By.xpath("(//button[normalize-space()='Submit'])[2]");
	public By ActionButton_Backup=By.xpath("(//div[@class='dropstart']/button)[1]");
	public By ViewIndent=By.xpath("//a[@id='openModalButton']");
	public By printBtn=By.xpath("//a[@tooltip='Print']");
	public By EditIndent=By.xpath("(//a[contains(text(), ' Edit Indent')])[1]");
	public By RecallIndent=By.xpath("(//a[contains(text(), ' Recall')])[1]");
	public By RecallIndentText=By.xpath("//h5[@id='staticBackdropLabel1']");
	public By Remarks_recall=By.xpath("//textarea[contains(text(),'Remarks for recall')]");
	public By Recall_Submit=By.xpath("//div[@class='modal-footer']//button[contains(text(), 'Submit')]");
	public By SystemIndentNOHeader=By.xpath("//legend[contains(text(), 'System Indent No')]");
	public By SystemIndentNO=By.xpath("//legend[contains(text(), 'System Indent No')]//following-sibling::div");
	public By poOrder=By.xpath("//h5[@id='staticBackdropLabel']");
	public By poOrderNoPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[2]/fieldset/div");
	public By OrderRefNoPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[3]/fieldset/div");
	public By OrderValue=By.xpath("//*[@id='po_header_temp.po_value.0']");
	public By OrderValuePreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[4]/fieldset/div");
	public By TenderIDPOPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[6]/fieldset/div");
	public By AmendedPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[12]/fieldset/div");
	public By shipToPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[19]/fieldset/div");
	public By billToPreview=By.xpath("//*[@id='_po_header_temp_u']/app-tab-preview/div/div/div/div/div[20]/fieldset/div");
	
	
	
	public By submitQuickIndent=By.xpath("//button[@title='Complete']");
	public By poSaveMSG=By.xpath("//h5[@id='staticBackdropLabel']");
	public By cancelOrDeletedPOTab=By.xpath("//*[@id='nav-cancelled-indent-tab']");
	public By confirmPOSaveMsg=By.xpath("//app-general-dialog[@class='ng-star-inserted']/div/div[3]/div//button[contains(text(),'Ok')]");
	public By poSaveMsg=By.xpath("//mat-dialog-container[@id='mat-dialog-4']/app-general-dialog/div/div[2]//div[contains(text(),'Order has been saved successfully.')]");
	public By poSubmitMsg=By.xpath("//mat-dialog-container[@id='mat-dialog-2']/app-general-dialog/div/div[2]//div[contains(text(),'Order has been submitted successfully.')]");
	public By poReferenceNo=By.xpath("//label[contains(text(),'Reference No:')]//following-sibling::input");
	public By PreviewCrossButton=By.xpath("//h5[@id='staticBackdropLabel']//following-sibling::div[1]/button");
	public By lifeCyclePreviewClose=By.xpath("(//h5[@id='staticBackdropLabel']//following-sibling::div[1]/button)[2]");
	public By Txt_TypeanyKeyword_Indent = By.xpath("//input[@placeholder]");
	public By ActionBtn_Listpage_Indent = By.xpath("//button[@id='menu1']");
	public By DropdownmenuListpage_Indent = By.xpath("//ul[contains(@class,'dropdown-menu extended logout big_actv')]");
	public By IndentPreview = By.xpath("//h5[@id='staticBackdropLabel']/strong");
	public By MarkForRFQBtn_Indent = By.xpath("//a[normalize-space()='Mark For RFQ']");
	public By ConfBox_Indent = By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-content']");
	public By Confbtn_Indent = By.xpath("//button[normalize-space()='Confirm']");
	public By Alertbox_Indent = By.xpath("//p[normalize-space()='Alert']");
	public By Okbtn_Indent = By.xpath("//button[normalize-space()='Ok']");
	public By Yesbtn_Indent = By.xpath("//button[normalize-space()='Yes']");
	public By IndentAssignmentlnk_Indent = By.xpath("//a[normalize-space()='Assignment']");
	public By approvalHistory_IndentCreator = By.xpath("//a[normalize-space()='Publication Approval History']");
	public By approvalHistory_approverend = By.xpath("//*[normalize-space()='Approval History']");
	public By IndentAssignmentListLbl_Indent = By.xpath("//li[normalize-space()='Indent Assignment List']");
	public By DropdownmenuAssignmentListpage_Indent = By.xpath("//div[contains(@class,'open')]//ul[contains(@class,'dropdown-menu extended logout big_actv')]");
	public By ClaimLnkAssignmentListpage_Indent = By.xpath("//a[normalize-space()='Claim']");
	public By AssignUserLnkAssignmentListpage_Indent = By.xpath("//a[normalize-space()='Assign User']");
	public By AssignUsermodal_Indent = By.xpath("//button[contains(@class, 'btn roundActionBtn')]/mat-icon");
	public By TypeanyKeyword_AssignUsermodal_Indent = By.xpath("//input[@placeholder='Search by username & designation']");
	public By AddUser_AssignUsermodal_Indent = By.xpath("//a[@name='add2Group']");
	public By Remarks_AssignUsermodal_Indent = By.xpath("//textarea[@name='comment']");
	public By Submitbtn_AssignUsermodal_Indent = By.xpath("//button[@id='btn-prevOk']");
	
	public By RevertToICLnkAssignmentListpage_Indent = By.xpath("//a[normalize-space()='Revert Back To IC']");
	public By RevertToICbox_Indent = By.xpath("//h5[contains(text(), 'Revert Back To Indent Creator')]");
	public By ReasonofRevertTxtbox_Indent = By.xpath("//div[contains(@class, 'col-md-10')]/textarea");
	public By Revertbox_Submitbtn_Indent = By.xpath("//div[contains(@class, 'text-center mb-4')]/button[2]");
	public By CreateRFQfromIndentLbl_Indent = By.xpath("//li[normalize-space()='Create RFQ From Indent']");
	public By IndentStatus_AssignmentListPage = By.xpath("//table[contains(@class,'table customTable listTable')]//tr/td[6]");
	public By Txt_TypeanyKeyword_RFQfromIndent = By.xpath("//input[@ng-model='assignmentFilter']");
	public By CreateRFQLnk_RFQfromIndent = By.xpath("//a[normalize-space()='Create RFQ']");
	public By IndentPreviewPage_RFQfromIndent = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]");
	public By CreateRFQbtn_IndentPreview = By.xpath("//button[normalize-space()='Create RFQ']");
	public By TGselectionmodal_RFQfromIndent = By.xpath("//*[@id='sequenSec']/div/div/select");
	public By SelectTG_RFQfromIndent = By.xpath("//select[@ng-model='templategroupId']");
	public By Submitbtn_RFQfromIndent = By.xpath("//div[contains(@class,'text-center mb-4')]/button[2]");
	public By CreateChannel = By.xpath("//button[normalize-space()='Create']");
//Publish tender with RFQ TG1 from indent TG1
	//Terms and Conditions tab
	public By TermsandConditionstabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'Terms and Conditions')]");
	public By AddBtnTermsandConditionstab_Tender_TG1 = By.xpath("//div[@id='rdcis_rfq_terms_cnditions']//button[@class='roundCirBtnTbl ms-2 m-r-15 mb-10 ng-star-inserted']");
	public By AddBtnTermsandConditionstab_Tender_TG8 = By.xpath("//div[@id='cet_rfq_terms_conditions']//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By ClauseTxtTermsandConditionstab_Tender_TG1 = By.xpath("//input[@id='rdcis_rfq_terms_cnditions.clause_no.0']");
	public By ClauseTxtTermsandConditionstab_Tender_TG8 = By.xpath("//input[@id='cet_rfq_terms_conditions.Clause_No.0']");
	public By ClauseHeaderTxtTermsandConditionstab_Tender_TG1 = By.xpath("//input[@id='rdcis_rfq_terms_cnditions.Header.0']");
	public By ClauseHeaderTxtTermsandConditionstab_Tender_TG8 = By.xpath("//textarea[@id='cet_rfq_terms_conditions.Description.0']");
	//General Requirement Equipment details
	public By GeneralReqEquiptabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'General Requirement Equiptment Details')]");
	//General information Clauses
	public By GeneralInfoClausestabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'General Information Clauses')]");
	//Attachments tab
	public By AttachmentstabLnk_Tender_TG1 = By.xpath("//span[normalize-space()='Attachments']");
	public By attachmentAddButton = By.xpath("//button[@ng-click='openAttachmentModal(templateIndex)']");
	public By AttachmentsRowLbl_Tender_TG1 = By.xpath("//div[@id='rfqattachment']//tbody//tr[contains(@class,'ng-star-inserted')]");
	//Required Attachment tab
	public By ReqAttachmenttabLnk_Tender_TG1 = By.xpath("//span[normalize-space()='Required Attachment']");
	public By AddBtnReqAttachmenttab_Tender_TG1 = By.xpath("//*[@id='requiredbidderattachment']/div/div/div[1]/a/button");
	public By AttachmentModal_ReqAttachmenttab_Tender_TG1 = By.xpath("//div[@id='myModaladdrqr' and contains(@class,'fade in')]");
	public By ReqAttachmenttab_attchmentGroup = By.xpath("//select[@name='requiredbidderattachment_agattachment_group']");
	public By SupportingdocTxt_ReqAttachmenttab_Tender_TG1 = By.xpath("//input[@id='requiredbidderattachment.supporting_doc.0']");
	public By ReqAttachmenttab_attachment_group_if_other = By.xpath("//input[@id='requiredbidderattachment.cmnts_or_spcl_inst.0']");
	public By Okbtn_ReqAttachmenttab_Tender_TG1 = By.xpath("//button[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0']");
	public By NextLnk_Tender_TG1 = By.xpath("//*[@class='mat-ripple mat-mdc-tab-header-pagination mat-mdc-tab-header-pagination-after']");
	//Pre-bid Discussion tab
	public By PreBidDiscussiontabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'Pre-bid Discussion')]");
	public By PreBidDiscussiontabLnk_Tender_STG_TG1 = By.xpath("//a[contains(text(),'Pre-Bid Discussion')]");
	//Payment tab
	public By PaymentabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'Payment') and @class='tab-name rfqpayment-tab']");
	public By PaymentType_Paymentab_Tender_TG1 = By.xpath("//select[@id='rfqpayment.payment_type.0']");
	public By PaymentCurrency_Paymentab_Tender_TG1 = By.xpath("//select[@name='rfqpayment_payment_currency']");
	public By PaymentAmount_Paymentab_Tender_TG1 = By.xpath("//input[@id='rfqpayment.amount.0']");
	public By OfflineNEFT_Paymentab_Tender_TG1 = By.xpath("//input[@value='NEFT']");
	public By AddPayment_Paymentab_Tender_TG1 = By.xpath("//button[normalize-space()='Add Payment']");
	public By PaymentRow_Paymentab_Tender_TG1 = By.xpath("//div[@id='rfqpayment']//tr[contains(@class,'ng-star-inserted')]");
	
	//Project Details tab
	public By ProjectDetailstabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'Project Details')]");
	//Prequalification Details tab
	public By PrequalificationDetailstabLnk_Tender_TG1 = By.xpath("//a[contains(text(),'Prequalification')]");
	//Technical tab
	public By TechnicaltabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'Technical')]");
	public By ClauseTxt_Technicaltab_Tender_TG1 = By.xpath("//input[@id='rdcis_rfq_cmpl_tech_speci.Clause_subcla_No.0']");
	//RFQ Item tab
	public By RFQItemtabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'RFQ Item')]");
	public By itemCode = By.xpath("//*[@name='item_code']");
	public By ItemCodeTxt_RFQItemtab_Tender_TG1 = By.xpath("//input[@id='rdcis_rfq_bom_supply.item_code.0']");
	public By ItemCodeTxt_RFQItemtab_Tender_TG8 = By.xpath("//input[@id='cet_rfq_bom_supply_pur.item_code.0']");
	//BOQ Mandatory tab
	public By BOQMandatorytabLnk_Tender_TG1 = By.xpath("//span[contains(text(),'BOQ (Mandatory)')]");
	public By BOQMandatorytabLnk_Tender_STG_TG1 = By.xpath("//a[contains(text(),'Boq (Mandatory)')]");
	public By ItemCodeTxt_BOQMandatorytab_Tender_TG1 = By.xpath("//input[@id='rdcis_rfq_bom_services.item_code.0']");
	
//Bid submission for tender with RFQ TG1 from indent TG1
	//Terms and Conditions tab
	public By TermsandConditionstabLnk_BidSubmission_TG1 = By.xpath("//a[@id='rdcis_quotatn_trms_cnditn']");
	public By ClauseTxtTermsandConditionstab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotatn_trms_cnditn.clause_no.0']");
	public By RemarksTxtTermsandConditionstab_BidSubmission_TG1 = By.xpath("//textarea[@id='rdcis_quotatn_trms_cnditn.Remarks.0']");
	public By BidderRemarks = By.xpath("//textarea[@id='rdcis_quotatn_trms_cnditn.Bidder_Remarks.0']");
	//Technical Compliance tab
	public By TechnicalCompliancetabLnk_BidSubmission_TG1 = By.xpath("//a[@id='rdcis_quotaton_tech_speci']");
	public By ClauseTxtTechnicalCompliancetab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_tech_speci.Clause_subcla_No.0']");
	public By RemarksTxtTechnicalCompliancetab_BidSubmission_TG1 = By.xpath("//textarea[@id='rdcis_quotaton_tech_speci.Remarks.0']");
	//Attachments tab
	public By AttachmentstabLnk_BidSubmission_TG1 = By.xpath("//a[@id='qout_attachment']");
	public By Attachment_subtabLnk_BidSubmission_TG1 = By.xpath("//a[normalize-space()='Attachment']");
	public By TenderAttachment_subtabLnk_BidSubmission_TG1 = By.xpath("//a[normalize-space()='Tender Attachment']");
	public By ActionbtnBidderspecificAttachment_BidSubmission_TG1 = By.xpath("//td[@class='ng-scope']//button[@type='button']");
	public By UploadBidderspecificAttachment_BidSubmission_TG1 = By.xpath("//input[@id='bidderInput_0']");
	public By UploadFromEbriefcase_TG1 = By.xpath("//a[@id='ebriefcase_attachment_0']");
	public By AddEbriefcaseFile_TG1 = By.xpath("//button[@id='add-authorRow']");
	//Technical Tab
	public By TechnicaltabLnk_BidSubmission_TG1 = By.xpath("//a[@id='tech_quotaton_bom_service']");
	//Specifications and Technical Requirements Compliance tab
	public By TechnicalReqComptabLnk_BidSubmission_TG1 = By.xpath("//a[@id='tech_quotaton_bom_supply']");
	//Commercial Parameters Compliance tab
	public By CommercialComptabLnk_BidSubmission_TG1 = By.xpath("//a[@id='rdcis_quotatn_estimtn_sht']");
	//General Requirement Equipment Details tab
	public By GeneralReqEqiptabLnk_BidSubmission_TG1 = By.xpath("//a[@id='ordr_placement_details']");
	public By Address_GeneralReqEqiptab_BidSubmission_TG1 = By.xpath("//textarea[@id='ordr_placement_details.name_address.0']");
	//Other Clauses Tab
	public By OtherClausestabLnk_BidSubmission_TG1 = By.xpath("//a[@id='gem_msme_certifcte_detail']");
	public By RegisteredGEM_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Registered_in_GeM.0']");
	public By VendorCode_OtherClausestab_BidSubmission_TG1 = By.xpath("//input[@id='gem_msme_certifcte_detail.GeM_vendor_code.0']");
	public By Startupbidder_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.start_up_bidder.0']");
	public By GovtOrg_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.govt_PSU.0']");
	public By RepresentingFirm_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Section_six.0']");
	public By RepresentingFirmDetail_OtherClausestab_BidSubmission_TG1 = By.xpath("//textarea[@id='gem_msme_certifcte_detail.Section_six_details.0']");
	public By RepresentingFirmRelationship_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.representing_firm.0']");
	public By RepresentingFirmRelationshipDetail_OtherClausestab_BidSubmission_TG1 = By.xpath("//textarea[@id='gem_msme_certifcte_detail.representing_firm_de.0']");
	public By MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.r_u_msme_bidder.0']");
	public By UAN_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//input[@id='gem_msme_certifcte_detail.uan_number.0']");
	public By EMNo_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//input[@id='gem_msme_certifcte_detail.em_no.0']");
	public By Type_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Type_of_Enterprise.0']");
	public By ActivityType_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Type_of_Activity.0']");
	public By OrgType_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Type_of_Organization.0']");
	public By WomenOwned_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.WOMEN_Entrepreneur.0']");
	public By Gender_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Gender.0']");
	public By PhyHand_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Physicaly_Handicaped.0']");
	public By SocialCat_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Social_Category.0']");
	public By LocationPlant_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//input[@id='gem_msme_certifcte_detail.Location_of_Plant.0']");
	public By FirmType_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Type_of_Your_Firm.0']");
	public By AnyotherFirmType_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//input[@id='gem_msme_certifcte_detail.tender_item_any_othe.0']");
	public By ScopeOfProc_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Scope_Job_Procuremnt.0']");
	public By Certification_MSME_OtherClausestab_BidSubmission_TG1 = By.xpath("//select[@id='gem_msme_certifcte_detail.Firm_MSE_Certficatin.0']");
	//Payment tab
	public By PaymenttabLnk_BidSubmission_TG1 = By.xpath("//a[@id='quotation_payment']");
	public By Paymentbtn_Paymenttab_BidSubmission_TG1 = By.xpath("//button[@name='payment']");
	public By PaymentType_Paymenttab_BidSubmission_TG1 = By.xpath("//input[@name='paymentType']");
	public By BankNametxt_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='bankName']");
	public By BranchNametxt_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='branchName']");
	public By InstruNotxt_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='instrumentNo']");
	public By InstruDatetxt_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='instrumentDate']");
	public By Commenttxt_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='comment']");
	public By InstruExpiryDate_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='paySection']//input[@name='expiryDate']");
	public By Uploadfile_Paymenttab_BidSubmission_TG1 = By.xpath("//input[@file-model='fileModel.offlinePaymentFile']");

	//public By SavePaymentBtn_Paymenttab_BidSubmission_TG1 = By.xpath("//button[normalize-space()='Save Payment']");
	public By Payment_amountField_TG1 = By.xpath("//input[@ng-model='quotationFees.tranamount']");
	public By SavePaymentBtn_Paymenttab_BidSubmission_TG1 = By.xpath("//div[@id='offline']/form/div[4]//button[contains(text(),'Save Payment')]");
	
	//RFQ Item tab
	public By RFQItemtabLnk_BidSubmission_TG1 = By.xpath("//a[@id='rdcis_quotaton_bom_servce']");
	public By RFQItemRowCount_TG1 = By.xpath("//input[contains(@id, 'rdcis_quotaton_bom_servce.Unit_Rate')]");
	public By UnitRateTxt_RFQItemtab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_servce.Unit_Rate.0']");
	public By UnitRateTxt_RFQItemtab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_servce.Unit_Rate."+lineitem+"']");}
	public By CGSTTxt_RFQItemtab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_servce.cgst_per.0']");
	public By CGSTTxt_RFQItemtab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_servce.cgst_per."+lineitem+"']");}
	public By SGSTTxt_RFQItemtab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_servce.sgst_per.0']");
	public By SGSTTxt_RFQItemtab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_servce.sgst_per."+lineitem+"']");}
	//BOQ Mandatory tab
	public By BOQMandatorytabLnk_BidSubmission_TG1 = By.xpath("//a[@id='rdcis_quotaton_bom_supply']");
	public By BOMMandatoryRowCount_TG1 = By.xpath("//input[contains(@id,'rdcis_quotaton_bom_supply.Unit_Rate')]");
	public By UnitRateTxt_BOQMandatorytab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.Unit_Rate.0']");
	public By UnitRateTxt_BOQMandatorytab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_supply.Unit_Rate."+lineitem+"']");}
	public By CGSTTxt_BOQMandatorytab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.cgst_per.0']");
	public By CGSTTxt_BOQMandatorytab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_supply.cgst_per."+lineitem+"']");}
	public By SGSTTxt_BOQMandatorytab_BidSubmission_TG1 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.sgst_per.0']");
	public By SGSTTxt_BOQMandatorytab_BidSubmission_TG1(int lineitem) {return By.xpath("//input[@id='rdcis_quotaton_bom_supply.sgst_per."+lineitem+"']");}
	//Preview All page
	
	public By GeneralInfo_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='General Information']");
	public By Terms_Conditions_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Terms and Conditions'])[2]");
	public By Technical_ComplianceTable_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Technical Compliance Table'])[2]");
	public By Tender_Attachment_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Tender Attachment']");
	public By BidderSpecAttachment_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Supplier Specific Attachment']");
	public By Technical_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Technical'])[2]");
	public By SpecTechReq_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[contains(text(),'Specifications and Technical Requirements Complian')])[2]");
	public By CommercialParam_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Commercial Parameters Compliance']");
	public By GeneralReq_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='General Requirement Equiptment Details']");
	public By OtherClauses_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Other Clauses']");
	public By PaymentDetails_PreviwAllPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Payment Details']");
	public By RFQItem_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='RFQ Item'])[2]");
	public By BOQMan_PreviwAllPage_TG1 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='BOQ (Mandatory)'])[2]");
	//Tender Preview bid list page
	//public By PreviewAll_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]");
	public By PreviewAll_TenderPreviewBidListPage_TG1 = By.xpath("//body/section[@id='main-content-nw']/section[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/h3[1]");
	public By GeneralInfo_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Information']");
	public By Terms_Conditions_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Terms and Conditions']");
	public By GeneralReq_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Requirement Equiptment Details']");
	public By GeneralInfoClauses_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Information Clauses']");
	public By Attachments_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Attachments']");
	public By ReqAttachment_TenderPreviewBidListPage_TG1 = By.xpath("//div[normalize-space()='Required Attachment']");
	public By Payment_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Payment']");
	public By RFQItem_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='RFQ Item']");
	public By BOQMandatory_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='BOQ (Mandatory)']");
	public By DateSchedule_TenderPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Date Schedule']");
	//Bid Preview bid list page
	public By PreviewAll_BidPreviewBidListPage_TG1 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]");
	//Bid details in evaluation for cover1 for TG1
	public By TG1_generalInformation_bidDetails = By.xpath("//a[text()='General Information']");
	public By TG1_TermsAndConditions_bidDetails = By.xpath("//a[text()='Terms and Conditions']");
	public By TG1_TechnicalComp_bidDetails = By.xpath("//a[text()='Technical Compliance Table']");
	public By TG1_Attachments_bidDetails = By.xpath("//a[text()='Attachments']");
	public By TG1_Technical_bidDetails = By.xpath("//a[text()='Technical']");
	public By TG1_SpecificationAndTechnicalReq_bidDetails = By.xpath("//a[text()='Specifications and Technical Requirements Compliance']");
	public By TG1_OtherClauses_bidDetails = By.xpath("//a[text()='Other Clauses']");
	//Bid details in evaluation for cover2 for TG1
	public By TG1_CommercialParam_bidDetails = By.xpath("//a[text()='Commercial Parameters Compliance']");
	public By TG1_GeneralReqEquip_bidDetails = By.xpath("//a[text()='General Requirement Equiptment Details']");
	public By TG1_Payment_bidDetails = By.xpath("//a[text()='Payment']");
	public By TG1_RFQItem_bidDetails = By.xpath("//a[text()='RFQ Item']");
	public By TG1_BOQMandatory_bidDetails = By.xpath("//a[text()='BOQ (Mandatory)']");
	
	//Indent Approver
	public By Lbl_workflowinbox = By.xpath("//h3[normalize-space()='Workflow Inbox (Pending & complete list)']");
	public By notesheetTab = By.xpath("//div/span[normalize-space()='Notesheet']");
	public By LOATab = By.xpath("//div/span[normalize-space()='LOA']");
	public By notesheetTab_Updated = By.xpath("//div[@id='mat-tab-label-0-10']//span[contains(text(),'Notesheet')]");
	public By IndentRowResult_Approver (String indentno) { return By.xpath("//span[contains(text(),'"+indentno+"')]");}
	public By Actionbtn_IndentApprover = By.xpath("//button[@id='menu1']");
	public By Actionbtn_IndentApprover_Backup = By.xpath("(//button[@id='menu1'])[1]");
	public By Detailbtn_IndentApprover = By.xpath("//a[normalize-space()='Details']");
	public By deleteItem = By.xpath("(//*[@class='dlt_tr'])[2]");
	public By approverendSystemIndentNo = By.xpath("//*[@id='indent_general_info.system_indent_no.0']");
	public By loadingScreen = By.xpath("//div[@class='ngx-overlay loading-foreground']");
	public By sectionWiseView_IndentApprover = By.xpath("//ul[@class='dropdown-menu extended logout big_actv']/li[1]/a");
	public By IndentCreatorCommentInApprover = By.xpath("//span[@class='comments']");
	public By sectionWiseView_IndentApprover_Backup = By.xpath("(//ul[@class='dropdown-menu extended logout big_actv']/li[1]/a)[1]");
	public By recallByPreviousApprover = By.xpath("(//a[@data-target='#recallModal'])[1]");
	public By recallCommentSection = By.xpath("//body/section[@id='main-content-nw']/section[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/textarea[1]");
	public By recall_submitButton = By.xpath("//button[@ng-click='recallIndent(recalReason)']");
	public By recall_ApproverIndent = By.xpath("//textarea[@name='recalReason']");
	public By recall_success_msg = By.xpath("//div[contains(text(), 'The Indent has been recalled successfully')]");
	public By recall_ok_msg = By.xpath("//button[contains(text(),'Ok')]");
	public By LblAppCmnt_IndentApprover = By.xpath("//a[text()='Comment']");
	public By AppComments = By.xpath("//*[@id='floatingTextarea']/div[2]/div[2]/div");
	public By SendBtn_Indent = By.xpath("//div[contains(@class, 'd-flex justify-content-between align-items-start')]/div[1]/span[1]/button");
	public By ApproveBtn = By.xpath("//button[contains(text(), 'Approve')]");
	public By SendBtn = By.xpath("//button[contains(text(), 'Send')]");
	public By commonNameofApprove = By.xpath("//div[@class='buttonsfortextarea']//*[contains(text(),'Approve') or contains(text(),'Send') or contains(text(),'Forward')]"); //This element is verified in SN and added by @AD
	public By SendBaackBtn = By.xpath("//button[contains(text(), 'Review')]");
	public By ReviewBackWF_to_previousApprover = By.xpath("(//a[contains(text(), 'Review Back to Previous Approver')])[2]");
	public By ReviewBackWF_to_Creator = By.xpath("(//a[contains(text(), 'Review Back to Creator')])[2]");
	public By ForwardWF_Indent = By.xpath("//button[contains(text(),'Forward to Next Person')]");
	public By sentBackToPreviousApproverStatus = By.xpath("//*[contains(text(),'Sent Back ...')]");
	public By CloseWFBtn_Indent = By.xpath("//button[text()='End Workflow']");
	public By CloseWFBtn = By.xpath("//*[@class='btn modalBtnBlueBorder mx-2 mb-2 mb-sm-0' and text()='End Workflow']");
	public By ConfirmYESBtn_PO = By.xpath("//*[@class='btn modalBtnBlue mx-2 mb-2 mb-sm-0' and text()='Yes']");
	public By ConfirmYESBtn_Indent = By.xpath("//mat-dialog-container[@id='mat-dialog-1'] //p[@class='subInfotxt'] //following-sibling::div/button[2]");
	public By ConfirmYESBtnNext_Indent = By.xpath("//p[text()='Are you really sure that you want to close the workflow?'] //following-sibling::div/button[2]");
	public By ConfirmYESBtnFinal_Indent = By.xpath("//p[text()='Are you sure, you want to continue?'] //following-sibling::div/button[2]");
	public By SuccessMsg_IndentApproval = By.xpath("//h5[text()='Success']");
	public By ConfirmMsg_IndentSendBack = By.xpath("//p[text()='Confirm']");
	public By OKBtn_IndentApproval = By.xpath("//div[@class='modal-footer'] //button");
	public By okButton_approval = By.xpath("//*[@id='staticBackdrop']/div/div/div[3]/button");
	public By OKBtn_IndentSendBack = By.xpath("//div[contains(@class, 'd-sm-flex justify-content-center justify-content-sm-start align-items-center ng-star-inserted')] /button[2]");
	public By NoBtn_IndentApproval = By.xpath("//div[contains(@class, 'ms-sm-4 text-center text-sm-start')]/div[1]/button[1]");
	public By MarkForRFQ_Yes_Btn_IndentApproval = By.xpath("//div[contains(@class, 'ms-sm-4 text-center text-sm-start')]/div[1]/button[2]");
	//Publish tender with RFQ TG3
	//Terms and Conditions tab
	public By TermsandConditionstabLnk_Tender_TG3 = By.xpath("//a[contains(text(),'Terms and Conditions')]");
	public By TermsandConditionstabLnk_Tender_STG_TG3 = By.xpath("//a[contains(text(),'Terms And Conditions')]");
	public By AddBtnTermsandConditionstab_Tender_TG3 = By.xpath("//div[@id='rh_terms']//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub ng-scope']");
	public By ClauseNoTxtTermsandConditionstab_Tender_TG3 = By.xpath("//input[@id='rh_terms.Clause_No.0']");
	public By ClauseTxtTermsandConditionstab_Tender_TG3 = By.xpath("//textarea[@id='rh_terms.RH_terms_Clause.0']");
	public By DetailsTxtTermsandConditionstab_Tender_TG3 = By.xpath("//textarea[@id='rh_terms.RH_terms_Details.0']");
	//Commercial Terms and Conditions tab
	public By CommercialTermsandConditionstabLnk_Tender_TG3 = By.xpath("//a[contains(text(),'Commercial Terms & Conditions')]");
	public By AddBtnCommercialTermsandConditionstab_Tender_TG3 = By.xpath("//div[@id='rh_man_terms']//button[@class='btn btn-primary btn-circle btn-lg btn-lg-sub ng-scope']");
	public By ClauseNoTxtCommercialTermsandConditionstab_Tender_TG3 = By.xpath("//input[@id='rh_man_terms.Clause_No.0']");
	public By ClauseTxtCommercialTermsandConditionstab_Tender_TG3 = By.xpath("//textarea[@id='rh_man_terms.RH_terms_Clause.0']");
	public By DetailsTxtCommercialTermsandConditionstab_Tender_TG3 = By.xpath("//textarea[@id='rh_man_terms.RH_terms_Details.0']");
	//Attachments tab
	public By AttachmentstabLnk_Tender_TG3 = By.xpath("//a[normalize-space()='Attachments']");
	public By AddBtnAttachmenttab_Tender_TG3 = By.xpath("//div[@id='rfqattachment']//button[contains(@ng-click,'openAttachmentModal')]");
	public By AddAttachmentLbl_Attachments_Tender_TG3 = By.xpath("//div[@id='myModaladd' and contains(@class,'fade in')]//h3[normalize-space()='Add Attachment']");
	public By LblTxtAttachmenttab_Tender_TG3 = By.xpath("//div[@id='myModaladd' and contains(@class,'fade in')]//input[@id='rfqattachment.label.0']");
	public By FileNameinputAttachmenttab_Tender_TG3 = By.xpath("//div[@id='myModaladd' and contains(@class,'fade in')]//input[@type='file']");
	public By OKBtnAttachmenttab_Tender_TG3 = By.xpath("//button[@id='add-authorRow']");
	public By annextureTypeSelect = By.xpath("//*[@id='rfqattachment.label.0']");
	public By attachfile = By.xpath("//input[@file-model='tenderAttachments']");
	public By okButtonAttachment = By.xpath("//*[@id='add-authorRow']");
	//Price Format tab
	public By PriceFormattabLnk_Tender_TG3 = By.xpath("//a[contains(text(),'Price Format')]");
	public By AddBtnPriceFormattab_Tender_TG3 = By.xpath("//div[@id='ri_mro']//button[contains(@ng-click,'addNonSORItem')]");
	public By PRnoTxtPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.pr_no.0']");
	public By PRDatePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.PR_Date.0']");
	public By PRLineitemPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.PR_Line_Itemno.0']");
	public By EPSMatCodePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.item_code.0']");
	public By SAPMatCodePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.SAP_Matl_Code.0']");
	public By ShortDescPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.Short_desc.0']");
	public By QtyPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.item_qty.0']");
	public By UOMPriceFormattab_Tender_TG3 = By.xpath("//select[@id='ri_mro.uom.0']");
	public By PRValPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.sor_rate.0']");
	public By DeliveryDatePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.del_date.0']");
	public By OrganizationPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.Purchase_org.0']");
	public By CompanyNamePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.company_name.0']");
	public By PlantCodePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.Plant_Code.0']");
	public By PlantNamePriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.Plant_Name.0']");
	public By PurchaseGroupPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.Purchase_group.0']");
	public By UserEmailPriceFormattab_Tender_TG3 = By.xpath("//input[@id='ri_mro.user_emilid.0']");
	//Pre-bid discussion tab
	public By PreBidDiscussiontabLnk_Tender_TG3 = By.xpath("//a[contains(text(),'Pre-bid Discussion')]");
	public By Type_PreBidDiscussiontab_Tender_TG3 = By.xpath("//select[@id='prebiddiscussion.discussion_type.0']");
//Bid Submission for RFQ TG3
	//Date schedule tab
	public By DateScheduletabLnk_BidSubmission_TG3 = By.xpath("//a[@id='qout_attachment']");
	public By AttachmentSubtabLnk_BidSubmission_TG3 = By.xpath("//a[normalize-space()='Attachment']");
	public By AddAttachmentBtn_BidSubmission_TG3 = By.xpath("//div[contains(@id,'attchmentTab')]//button[@id='addAttach']");
	public By LabelTxt_AttachmentSubtab_BidSubmission_TG3 = By.xpath("//div[contains(@id,'attchmentTab')]//input[@ng-model='row.label']");
	public By Actionbtn_AttachmentSubtab_BidSubmission_TG3 = By.xpath("//div[contains(@id,'attchmentTab')]//button[@class='btn btn-primary dropdown-toggle']");
	public By FileInput_AttachmentSubtab_BidSubmission_TG3 = By.xpath("//div[contains(@id,'attchmentTab')]//input[@id='attachment_0']");
	public By TenderattachmentSubtabLnk_BidSubmission_TG3 = By.xpath("//a[normalize-space()='Tender Attachment']");
	//Commercial Terms and Conditions tab
	public By CommercialTermsConditionstabLnk_BidSubmission_TG3 = By.xpath("//a[@id='qh_term']");
	public By ClauseTxt_CommercialTermsConditionstab_BidSubmission_TG3 = By.xpath("//textarea[@id='qh_term.RH_terms_Clause.0']");
	public By ClauseTxt_CommercialTermsConditionstab_BidSubmission_TG7 = By.xpath("//textarea[@id='qh_term.RH_terms_Clause.0']");
	//Terms and conditions tab
	public By TermsConditionstabLnk_BidSubmission_TG3 = By.xpath("//a[@id='qh_man_terms']");
	public By ClauseTxt_TermsConditionstab_BidSubmission_TG3 = By.xpath("//textarea[@id='qh_man_terms.RH_terms_Clause.0']");
	//General Information Clauses tab
	public By GeneralinfoClausestabLnk_BidSubmission_TG3 = By.xpath("//a[@id='unpriced_mro_domestic']");
	public By Mandatoryitemlbl_GeneralinfoClausestab_BidSubmission_TG3 = By.xpath("//div[@id='_unpriced_mro_domestic']//h3[contains(text(),'Mandatory Item')]");
	public By SupplirOfferedTxt_GeneralinfoClausestab_BidSubmission_TG3 = By.xpath("//input[@id='unpriced_mro_domestic.Supplier_offer_make.0']");
	public By HSNCodeTxt_GeneralinfoClausestab_BidSubmission_TG3 = By.xpath("//input[@id='unpriced_mro_domestic.hsn_sac.0']");
	public By OfferValidityTxt_GeneralinfoClausestab_BidSubmission_TG3 = By.xpath("//input[@id='unpriced_mro_domestic.offervalidity.0']");
	public By OfferDeliverPeriodTxt_GeneralinfoClausestab_BidSubmission_TG3 = By.xpath("//input[@id='unpriced_mro_domestic.del_period.0']");
	
	public By Nexttab_BidSubmission_TG3 = By.xpath("//a[@class='bx-next']");
	//Price Format tab
	public By PriceFormattabLnk_BidSubmission_TG3 = By.xpath("//a[@id='qi_mro']");
	public By Mandatoryitemlbl_PriceFormattab_BidSubmission_TG3 = By.xpath("//div[@id='_qi_mro']//h3[contains(text(),'Mandatory Item')]");
	public By QuotedPriceTxt_PriceFormattab_BidSubmission_TG3 = By.xpath("//input[@id='qi_mro.qtd_price.0']");
	public By OverallDiscountTxt_PriceFormattab_BidSubmission_TG3 = By.xpath("//input[@id='qi_mro.Disc_percentage.0']");
	public By GSTPercentageTxt_PriceFormattab_BidSubmission_TG3 = By.xpath("//input[@id='qi_mro.gst_perc.0']");
	//Price summary tab
	public By PriceSummarytabLnk_BidSubmission_TG3 = By.xpath("//a[@id='mro_price_summary']");
	public By IncotermsSelect_PriceSummarytab_BidSubmission_TG3 = By.xpath("//select[@id='mro_price_summary.Incoterms.0']");
	//Preview All page
	public By QuotationAttachment_PreviwAllPage_TG3 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Quotation Attachment']");
	public By TenderAttachment_PreviwAllPage_TG3 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Tender Attachment']");
	public By CommercialTermsCond_PreviwAllPage_TG3 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Commercial Terms & Conditions'])[1]");
	public By TermsCond_PreviwAllPage_TG3 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Terms and Conditions'])[1]");
	public By GeneralInfoClauses_PreviwAllPage_TG3 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='General Information Clauses'])[1]");
	public By PriceFormat_PreviwAllPage_TG3 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Price Format'])[1]");
	public By PriceSummary_PreviwAllPage_TG3 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Price Summary'])[1]");
	// Tender Preview bid list page
	public By PreviewAll_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]");
	public By GeneralInfo_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Information']");
	public By Terms_Conditions_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Terms and Conditions']");
	public By CommercialTermsCond_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Commercial Terms & Conditions']");
	public By Attachments_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Attachments']");
	public By PriceFormat_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Price Format']");
	public By DateSchedule_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Date Schedule']");
	public By PrebidDiscussion_TenderPreviewBidListPage_TG3 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Pre-bid Discussion']");
	//Bid details in evaluation for cover1 for TG3
	public By TG3_generalInformation_bidDetails = By.xpath("//a[text()='General Information']");
	public By TG3_DateSchedule_bidDetails = By.xpath("//a[text()='Date Schedule']");
	public By TG3_GeneralInfoClauses_bidDetails = By.xpath("//a[text()='General Information Clauses']");
	//Bid details in evaluation for cover2 for TG3
	public By TG3_CommercialTermsAndCond_bidDetails = By.xpath("//a[text()='Commercial Terms & Conditions']");
	public By TG3_TermsAndCond_bidDetails = By.xpath("//a[text()='Terms and Conditions']");
	public By TG3_PriceFormat_bidDetails = By.xpath("//a[text()='Price Format']");
	public By TG3_PriceSummary_bidDetails = By.xpath("//a[text()='Price Summary']");
	public By Savebtn_BidDetailspage_Evaluation= By.xpath("//button[@ng-click='saveOrUpdateEvaluation()']");
	public By Savebtn_BidDetailspage_TCUser_Evaluation= By.xpath("//button[@ng-click='saveInitiatorComments()']");
	public By AlertMsgmodal_BidDetailspage_Evaluation= By.xpath("//div[@id='alertMessageModal' and contains(@class,' in')]");
	public By closeEval= By.xpath("//button[@ng-click='clearAlertMessages()'][normalize-space()='Close']");
	public By ClosebtnAlertMsgmodal_BidDetailspage_Evaluation= By.xpath("//div[@id='alertMessageModal' and contains(@class,' in')]//button[normalize-space()='Close']");
//Publish tender with RFQ TG4
	//PreBid Discussion tab
	public By PreBidDiscussiontabLnk_Tender_TG4 = By.xpath("//a[contains(text(),'Pre-bid Discussion')]");
	public By PreBidstartdatePreBidDiscussiontab_Tender_TG4 = By.xpath("//input[@id='prebiddiscussion2.meeting_start_date.0']");
	public By PreBidenddatePreBidDiscussiontab_Tender_TG4 = By.xpath("//input[@id='prebiddiscussion2.meeting_end_date.0']");
	public By PreBiddiscussiontype_PreBidDiscussiontab_Tender_TG4 = By.xpath("//select[@id='prebiddiscussion2.discussion_type.0']");
	//NIT Terms and Conditions tab
	public By NITTermsCondtabLnk_Tender_TG4 = By.xpath("//a[contains(text(),'NIT Terms and Conditions')]");
	public By Location_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.location.0']");
	public By Matgroup_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.material_group.0']");
	public By DeliverySchedule_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.Delivery_Schedule.0']");
	public By PriceBasis_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.Price_Basis.0']");
	public By DeliveryAt_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.Delivery_At.0']");
	public By PaymentTerms_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.Payment_Terms.0']");
	public By ValidityOffer_NITTermsCondtab_Tender_TG4 = By.xpath("//input[@id='term_conditions.Validity_Offer.0']");
	//Specifications and Technical Requirements Compliance tab
	public By SpecAndTechComptabLnk_Tender_TG4 = By.xpath("//a[contains(text(),'Specifications and Technical Requirements Compliance')]");
	public By Addbtn_SpecAndTechComptab_Tender_TG4 = By.xpath("//div[@id='technical_specification']//button[contains(@ng-click,'addRowForDynamicTabularTemplate')]");
	public By ItemNo_SpecAndTechComptab_Tender_TG4 = By.xpath("//input[@id='technical_specification.Item_No.0']");
	public By SapMatCode_SpecAndTechComptab_Tender_TG4 = By.xpath("//input[@id='technical_specification.SAPMC.0']");
	public By ItemSpec_SpecAndTechComptab_Tender_TG4 = By.xpath("//input[@id='technical_specification.ITEM_SPECIFICATION.0']");
	public By ItemQty_SpecAndTechComptab_Tender_TG4 = By.xpath("//input[@id='technical_specification.ITEM_QTY.0']");
	//RFQ Item tab
	public By RFQItemtabLnk_Tender_TG4 = By.xpath("//a[contains(text(),'RFQ Item')]");
	public By Addbtn_RFQItemtab_Tender_TG4 = By.xpath("//div[@id='rfq_item_rg20']//button[contains(@ng-click,'addNonSORItem')]");
	public By ItemCode_RFQItemtab_Tender_TG4 = By.xpath("//input[@id='rfq_item_rg20.item_code.0']");
	public By ERPMatCode_RFQItemtab_Tender_TG4 = By.xpath("//input[@id='rfq_item_rg20.ERPMC.0']");
	public By ItemDesc_RFQItemtab_Tender_TG4 = By.xpath("//input[@id='rfq_item_rg20.item_name.0']");
	public By UOM_RFQItemtab_Tender_TG4 = By.xpath("//select[@id='rfq_item_rg20.uom.0']");
	public By ItemQty_RFQItemtab_Tender_TG4 = By.xpath("//input[@id='rfq_item_rg20.item_qty.0']");
//Bid Submission for RFQ TG4
	//Attachments tab
	public By AttachmentstabLnk_BidSubmission_TG4 = By.xpath("//a[@id='qout_attachment']");
	public By AttachmentSubtabLnk_BidSubmission_TG4 = By.xpath("//a[normalize-space()='Attachment']");
	public By AddAttachmentBtn_BidSubmission_TG4 = By.xpath("//div[contains(@id,'attchmentTab')]//button[@id='addAttach']");
	public By LabelTxt_AttachmentSubtab_BidSubmission_TG4 = By.xpath("//div[contains(@id,'attchmentTab')]//input[@ng-model='row.label']");
	public By Actionbtn_AttachmentSubtab_BidSubmission_TG4 = By.xpath("//div[contains(@id,'attchmentTab')]//button[@class='btn btn-primary dropdown-toggle']");
	public By FileInput_AttachmentSubtab_BidSubmission_TG4 = By.xpath("//div[contains(@id,'attchmentTab')]//input[@id='attachment_0']");
	public By TenderattachmentSubtabLnk_BidSubmission_TG4 = By.xpath("//a[normalize-space()='Tender Attachment']");
	//Terms and conditions tab
	public By TermsConditionstabLnk_BidSubmission_TG4 = By.xpath("//a[@id='tril_quotation_headerrg']");
	public By UnloadingTxt_TermsConditionstab_BidSubmission_TG4 = By.xpath("//input[@id='tril_quotation_headerrg.UNLOADING.0']");
	public By DispatchLocTxt_TermsConditionstab_BidSubmission_TG4 = By.xpath("//input[@id='tril_quotation_headerrg.DISPATCH_LOCATION.0']");
	public By DeliveryTimeTxt_TermsConditionstab_BidSubmission_TG4 = By.xpath("//input[@id='tril_quotation_headerrg.DELIVERY_TIME.0']");
	public By WarrantyTxt_TermsConditionstab_BidSubmission_TG4 = By.xpath("//input[@id='tril_quotation_headerrg.Warranty_Guarantee.0']");
	public By RemarksTxt_TermsConditionstab_BidSubmission_TG4 = By.xpath("//input[@id='tril_quotation_headerrg.Remark.0']");
	//Technical Compliance Table tab
	public By TechnicalCompliancetabLnk_BidSubmission_TG4 = By.xpath("//a[@id='qt_technical_specifi']");
	public By Remarks_TechnicalCompliancetab_BidSubmission_TG4 = By.xpath("//input[@id='qt_technical_specifi.RESPONSE.0']");
	//RFQ Item tab
	public By RfqItemtabLnk_BidSubmission_TG4 = By.xpath("//a[@id='qi_supply19']");
	public By Rate_RfqItemtabtab_BidSubmission_TG4 = By.xpath("//input[@id='qi_supply19.QI_Basic_rate.0']");
	public By FreightUnitValue_RfqItemtabtab_BidSubmission_TG4 = By.xpath("//input[@id='qi_supply19.FPUV.0']");
	public By GSTPercentage_RfqItemtabtab_BidSubmission_TG4 = By.xpath("//input[@id='qi_supply19.gstp.0']");
	//Preview All page
	public By QuotationAttachment_PreviwAllPage_TG4 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Quotation Attachment']");
	public By TenderAttachment_PreviwAllPage_TG4 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Tender Attachment']");
	public By TermsCond_PreviwAllPage_TG4 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Terms and Conditions'])[1]");
	public By TechnicalComplianceTable_PreviwAllPage_TG4 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Technical Compliance Table'])[1]");
	public By RFQItem_PreviwAllPage_TG4 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='RFQ Item'])[1]");
	//Tender Preview bid list page
	public By DateSchedule_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='Date Schedule']");
	public By PrebidDiscussion_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='Pre-bid Discussion']");
	public By Attachments_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='Attachments']");
	public By NITTermscond_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='NIT Terms and Conditions']");
	public By Specifications_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='Specifications and Technical Requirements Compliance']");
	public By RFQItem_TenderPreviewBidListPage_TG4 = By.xpath("//div[normalize-space()='RFQ Item']");
	
//Publish tender with RFQ TG5
	//Specifications and Technical Requirements Compliance tab
	public By SpecAndTechComptabLnk_Tender_TG5 = By.xpath("//a[@class='ng-binding'][normalize-space()='Specifications and Technical Requirements Compliance']");
	public By ClauseTxt_SpecAndTechComptab_Tender_TG5 = By.xpath("//input[@id='rdcis_rfq_cmpl_tech_speci.Clause_subcla_No.0']");
	//Price Summary tab
	public By PriceSummarytabLnk_Tender_TG5 = By.xpath("//a[contains(text(),'Price Summary')]");
	public By CalculationMode_PriceSummarytab_Tender_TG5 = By.xpath("//select[@id='rdcis_rfq_estimtion_sheet.Calculation_Mode.0']");
	public By NextLnk_Bidsubmission_TG5 = By.xpath("//a[@class='bx-next']");
//Bid submission for RFQ TG5
	//RFQ Item tab
	public By RFQItemtabLnk_BidSubmission_TG5 = By.xpath("//a[@id='rdcis_quotaton_bom_supply']");
	public By UnitRateTxt_RFQItemtab_BidSubmission_TG5 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.Unit_Rate.0']");
	public By CGSTTxt_RFQItemtab_BidSubmission_TG5 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.cgst_per.0']");
	public By SGSTTxt_RFQItemtab_BidSubmission_TG5 = By.xpath("//input[@id='rdcis_quotaton_bom_supply.sgst_per.0']");
	//Price Summary tab
	public By PriceSummarytabLnk_BidSubmission_TG5 = By.xpath("//a[@id='rdcis_quotatn_estimtn_sht']");
	public By Calculationmode_PriceSummarytab_BidSubmission_TG5 = By.xpath("//select[@id='rdcis_quotatn_estimtn_sht.Calculation_Mode.0']");
	//Preview All page
	public By GeneralInfo_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='General Information']");
	public By Terms_Conditions_PreviwAllPage_TG5 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Terms and Conditions'])[1]");
	public By Technical_ComplianceTable_PreviwAllPage_TG5 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Technical Compliance Table'])[1]");
	public By Tender_Attachment_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Tender Attachment']");
	public By BidderSpecAttachment_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Bidder Specific Attachment']");
	public By SpecTechReq_PreviwAllPage_TG5 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[contains(text(),'Specifications and Technical Requirements Complian')])[1]");
	public By GeneralReq_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='General Requirement Equiptment Details']");
	public By BiddersInformation_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()=\"Bidder's Information\"]");
	public By PaymentDetails_PreviwAllPage_TG5 = By.xpath("//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Payment Details']");
	public By RFQItem_PreviwAllPage_TG5 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='RFQ Item'])[1]");
	public By PriceSummary_PreviwAllPage_TG5 = By.xpath("(//div[@id='myModalprev_bid' and contains(@class,'fade in')]//h2[normalize-space()='Price Summary'])[1]");
	//Tender Preview bid list page
	public By GeneralInfo_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Information']");
	public By ProjDetails_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Project Details']");
	public By GeneralReq_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='General Requirement Equiptment Details']");
	public By Terms_Conditions_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Terms and Conditions']");
	public By SpecTechReqComp_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Specifications and Technical Requirements Compliance']");
	public By RFQItem_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='RFQ Item']");
	public By PriceSummary_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Price Summary']");
	public By Attachments_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Attachments']");
	public By ReqAttachment_TenderPreviewBidListPage_TG5 = By.xpath("//div[normalize-space()='Required Attachment']");
	public By DateSchedule_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Date Schedule']");
	public By PrebidDiscussion_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Pre-bid Discussion']");
	public By Payment_TenderPreviewBidListPage_TG5 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='Payment']");
	
//Publish tender with RFQ TG6
	//RFQ Item tab
	public By RFQItemtabLnk_Tender_TG6 = By.xpath("//a[contains(text(),'RFQ Item')]");
	public By AddBtnRFQItemtab_Tender_TG6 = By.xpath("//div[@id='ri_raw_matls']//button[contains(@ng-click,'addNonSORItem')]");
	public By EPSMatCodeRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.item_code.0']");
	public By SAPMatCodeRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.SAP_Matl_Code.0']");
	public By HSNCodeRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.hsn_code.0']");
	public By ShortDescRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.Short_desc.0']");
	public By QtyRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.item_qty.0']");
	public By UOMRFQItemtab_Tender_TG6 = By.xpath("//select[@id='ri_raw_matls.uom.0']");
	public By DeliveryDateRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.del_date.0']");
	public By IncotermsRFQItemtab_Tender_TG6 = By.xpath("//select[@id='ri_raw_matls.incoterms.0']");
	public By CurrentStocksRFQItemtab_Tender_TG6 = By.xpath("//input[@id='ri_raw_matls.current_stock.0']");
//Bid submission for RFQ TG6
	//Price Summary tab	
	public By PriceSummarytabLnk_BidSubmission_TG6 = By.xpath("//a[@id='qi_raw_materials']");
	public By Mandatoryitemlbl_PriceSummarytab_BidSubmission_TG6 = By.xpath("//div[@id='_qi_raw_materials']//h3[contains(text(),'Mandatory Item')]");
	public By Make_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.make.0']");
	public By OfferValidity_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.offervalidity.0']");
	public By OfferDeliveryPeriod_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.del_period.0']");
	public By PlaceDespatch_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.despatch_place.0']");
	public By Manufacturer_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.Source_Make.0']");
	public By QuotedPrice_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.qtd_price.0']");
	public By GSTPercentage_PriceSummarytab_BidSubmission_TG6 = By.xpath("//input[@id='qi_raw_materials.gst_perc.0']");
	//Tender Preview bid list page
	public By RFQItem_TenderPreviewBidListPage_TG6 = By.xpath("//div[@id='myModalprev' and contains(@class,'fade in')]//div[normalize-space()='RFQ Item']");
	
	//RFQ TG7 Item template for Services_v1 (Temporary)
	public By RFQ_ITem_Tab_TG3 = By.xpath("//a[contains(text(),'RFQ Item')]");
	public By Add_NonSOR_Item_TG3 = By.xpath("//tbody/tr[1]/td[1]/div[2]/a[5]/button[1]/i[1]");
	public By PR_No_TG3 = By.xpath("//input[@id='ri_services.pr_no.0']");
	public By PR_Date_TG3 = By.xpath("//input[@id='ri_services.PR_Date.0']");
	public By PR_Line_Item_No_TG3 = By.xpath("//input[@id='ri_services.PR_Line_Itemno.0']");
	public By EPS_Material_Code_TG3 = By.xpath("//input[@id='ri_services.item_code.0']");
	public By SAP_Material_Code_TG3 = By.xpath("//input[@id='ri_services.SAP_Matl_Code.0']");
	public By Short_Description_TG3 = By.xpath("//input[@id='ri_services.Short_desc.0']");
	public By Qantity_TG3 = By.xpath("//input[@id='ri_services.item_qty.0']");
	public By UOM_TG3= By.xpath("//select[@id='ri_services.uom.0']");
	public By Estimated_Price_TG3 = By.xpath("//input[@id='ri_services.sor_rate.0']");
	public By Delivery_Date_TG3 = By.xpath("//input[@id='ri_services.del_date.0']");
	public By Purchase_Organisation_TG3 = By.xpath("//input[@id='ri_services.Purchase_org.0']");
	public By Company_Name_TG3 = By.xpath("//input[@id='ri_services.company_name.0']");
	public By Plant_Code_TG3 = By.xpath("//input[@id='ri_services.Plant_Code.0']");
	public By Plant_Name_TG3 = By.xpath("//input[@id='ri_services.Plant_Name.0']");
	public By Purchase_Group_TG3 = By.xpath("//input[@id='ri_services.Purchase_group.0']");
	public By User_Email_ID_TG3 = By.xpath("//input[@id='ri_services.user_emilid.0']");
	public By prebiddiscussion_venue_TG7 = By.xpath("//textarea[@id='prebiddiscussion.venue.0']");
	
	
	//RFQ TG7 Bid submission template locators--> Added by Arka on 20-05-2021
	//Template--> List of Spare parts and Equipments without price
	public By sparepartsEquipments_Tab_TG7 = By.xpath("//a[@id='unpriced_services']");
	public By offerValidity_TG7 = By.xpath("//input[@id='unpriced_services.Offer_validity.0']");
	public By jobCommencementDate_TG7 = By.xpath("//input[@id='unpriced_services.job_comm_date.0']");
	public By jobCompletionDate_TG7 = By.xpath("//input[@id='unpriced_services.Job_Comp_date.0']");
	// Price format
	public By priceFormat_Tab_TG7 = By.xpath("//a[@id='qi_services']");
	public By quotedPrice_TG7 = By.xpath("//input[@id='qi_services.qtd_price.0']");
	//previewAll
	public By sparepartsEquipments_preview_TG7 = By.xpath("//body[1]/section[2]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]/h2[1]");
	public By priceFormat_preview_TG7 = By.xpath("//body[1]/section[2]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[5]/div[1]/table[1]/thead[1]/tr[1]/th[1]/h2[1]");
	public By PriceSummary_preview_TG7 = By.xpath("//h2[contains(text(),'Price Summary')]");
	
	//TG7 Bid details verification extra locator--> added on 24-05-2021
	public By save_bidDetails_TG7 = By.xpath("//button[@ng-click='saveInitiatorComments()']");
	public By save_bidDetails_Evaluator_TG7 = By.xpath("//button[@ng-click='saveOrUpdateEvaluation()']");
	public By priceSummary_bidDtails_TG7 = By.xpath("//a[contains(text(),'Price Summary')]");
	public By getSetOff_bidDetails_TG7 = By.xpath("//select[@id='services_price_summary.GST_SetOff.0']");
	public By close_SavebidDetails_TG7 = By.xpath("//div[@class='modal-footer'] //button[@ng-click='clearAlertMessages()']");
	
	//TG7 negotiation
	public By negotiated_Unit_Rate = By.xpath("//input[@id='qi_services.Nego_unit_rate.0']");
	public By submittedOn_bidList_TG7 = By.xpath("//table[@id='myTable']//tbody //tr[@class=' fa-square-nego']/td[8]");
	
	//TG8 Indent creation, created on 31-05-21
	//Indent Details template
	public By indentDetailsTab_TG8 = By.xpath("//a[@id='cet_indent_details_purchs']");
	public By indentingDepartment_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Indenting_DEPT.0']");
	public By Justification4Purchase_TG8 = By.xpath("//textarea[@id='cet_indent_details_purchs.Just_Purchs.0']");
	public By justificationPurchase_TG8 = By.xpath("//textarea[@id='cet_indent_details_purchs.Just_Purchs.0']");
	public By basisPriceEstimation_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Basis_Price_Estimati.0']");
	public By executingAuthority_TG8 = By.xpath("//input[@id='cet_indent_details_purchs.Executing_Authority.0']");
	public By consignee_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Consignee.0']");
	public By placeDelivery_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Place_of_Delivery.0']");
	public By timePeriodDeliveryCompletionPeriod_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Time_Priod_of_Delvry.0']");
	public By numberYearMonthWeekDay_TG8 = By.xpath("//input[@id='cet_indent_details_purchs.Year_Month_Week_Day.0']");
	public By normalEmergency_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Norml_emm.0']");
	public By proprietaryItem_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Proprietary_Item.0']");
	public By splittingOrder_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Splitting_Of_Order.0']");
	public By basisforModeTendering_TG8 = By.xpath("//textarea[@id='cet_indent_details_purchs.Basis_mode_tender.0']");
	public By postWarrantyAMCRequirement_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Post_Wnty_AMC_req.0']");
	public By alternateBidRequired_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Altrnt_Bid_Required.0']");
	public By preBidMeeting_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Pre_bid_meeting.0']");
	public By specialConditionsInstructionstoTenderers_TG8 = By.xpath("//textarea[@id='cet_indent_details_purchs.Spec_Cond_Inst_Tendr.0']");
	public By anySpecialSelectionCriteria_TG8 = By.xpath("//select[@id='cet_indent_details_purchs.Spec_Selection_Crit.0']");
	public By inspectionGuidelines_TG8 = By.xpath("//textarea[@id='cet_indent_details_purchs.Inspec_Guidelines.0']");
	
	//Eligibility Criteria
	public By eligibilityCriteria_TG8 = By.xpath("//a[@id='cet_eligilty_critria_finl']");
	public By addButton_EligibilityCriteria_TG8 = By.xpath("//div[@id='_cet_eligilty_critria_finl']//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By textbox_EligibilityCriteria_TG8 = By.xpath("//textarea[@id='cet_eligilty_critria_finl.Eligibility_Criteria.0']");
	//public By attachment_EligibilityCriteria_TG8 = By.xpath("//span[@id='span-cet_eligilty_critria_finl-Attachment-0']");
	public By attachment_EligibilityCriteria_TG8 = By.xpath("//input[@id='cet_eligilty_critria_finl_Attachment_0']");

	//BOM Items
	public By bomItems_TG8 = By.xpath("//a[@id='cet_bom_supply_finl']");
	public By addNonSORitemsIndent_TG8 = By.xpath("//button[@ng-click='openNonSORItemModal(templateIndex,template.shortName)']");
	public By itemCodeIndet_TG8 = By.xpath("//input[@id='cet_bom_supply_finl.item_code.0']");
	public By mandatoryItemIndent_TG8 = By.xpath("//select[@id='cet_bom_supply_finl.mandatory_item.0']");
	public By itemNameIndent_TG8 = By.xpath("//input[@id='cet_bom_supply_finl.item_name.0']");
	public By unitIndent_TG8 = By.xpath("//select[@id='cet_bom_supply_finl.uom.0']");
	public By qtyIndent_TG8 = By.xpath("//input[@id='cet_bom_supply_finl.item_qty.0']");
	public By unitRateIndent_TG8 = By.xpath("//input[@id='cet_bom_supply_finl.sor_rate.0']");
	public By gstIndent_TG8 = By.xpath("//input[@id='cet_bom_supply_finl.GST.0']");
	public By consigneeIndent_TG8 = By.xpath("//select[@id='cet_bom_supply_finl.Consignee.0']");
	
	//Technical Specification
	public By tecnicalSpecication_TG8 = By.xpath("//a[@id='cet_tech_specif_final']");
	public By addTecnicalSpecicationButtonIndent_TG8 = By.xpath("//div[@id='_cet_tech_specif_final']//button[@ng-click='addRowForDynamicTabularTemplate(templateIndex)']");
	public By clauseNOindent_TG8 = By.xpath("//input[@id='cet_tech_specif_final.Clause_No.0']");
	public By caluseHeaderIndent_TG8 = By.xpath("//input[@id='cet_tech_specif_final.Clause_Header_Title.0']");
	public By decriptionIndent_TG8 = By.xpath("//textarea[@id='cet_tech_specif_final.Description.0']");
	public By attachmentTecnicalSpecicationButtonIndent_TG8 = By.xpath("//input[@id='cet_tech_specif_final_Attachment_0']");
	
	//Bid submission_Prequalification_TG8
	public By preQualification_TG8 = By.xpath("//a[@id='cet_quotatn_elig_criteria']");
	public By remarksPrequalification_TG8 = By.xpath("//textarea[@id='cet_quotatn_elig_criteria.Remarks.0']");
	
	//Bid Technical_TG8
	public By technical_TG8 = By.xpath("//a[@id='cet_quotation_tech_spec']");
	public By remarksTechnical_TG8 = By.xpath("//textarea[@id='cet_quotation_tech_spec.Remarks.0']");
	
	//Terms & conditions_TG8
	public By termsConditions_TG8 = By.xpath("//a[@id='cet_quotatn_trms_cndition']");
	public By remarksTermsConditions_TG8 = By.xpath("//textarea[@id='cet_quotatn_trms_cndition.Remarks.0']");
	
	//RFQ Item_TG8
	public By RFQItemtabLnk_BidSubmission_TG8 = By.xpath("//a[@id='cet_qutatn_bom_supply_pur']");
	public By unitRate_BidSubmission_TG8 = By.xpath("//input[@id='cet_qutatn_bom_supply_pur.Unit_Rate.0']");
	public By gst_BidSubmission_TG8 = By.xpath("//input[@id='cet_qutatn_bom_supply_pur.GST.0']");
	
	//Preview_TG8
	public By PreviewAll_TG8 = By.xpath("//h3[contains(text(),'Preview All')]");
	public By GeneralInformation_TG8 = By.xpath("//h2[contains(text(),'General Information')]");
	public By PaymentDetails_TG8 = By.xpath("//h2[contains(text(),'Payment Details')]");
	public By NEFT_TG8 = By.xpath("//h2[contains(text(),'NEFT')]");
	public By GeneralRequirementEquiptmentDetails_TG8 = By.xpath("//h2[contains(text(),'General Requirement Equiptment Details')]");
	public By QuotationAttachment_TG8 = By.xpath("//h2[contains(text(),'Quotation Attachment')]");
	public By TenderAttachment_TG8 = By.xpath("//h2[contains(text(),'Tender Attachment')]");
	public By SupplierSpecificAttachment_TG8 = By.xpath("//h2[contains(text(),'Supplier Specific Attachment')]");
	
	//Indent_attachment_TG9 added on 04-12-21 // modified on 120722
	public By IndentAttachmentTab=By.xpath("//button[@id='indent_attachment-tab']"); 
	public By AddAttachment= By.xpath("//button[@data-bs-target='#addAttachment']");
	public By IndentLabel= By.xpath("//div[@id='addAttachment'] //input[@id='indent_attachment.label.0']");
	public By IndentAttachments= By.xpath("//div[@id='addAttachment'] //input[@class='uploadBtncls']");
	public By OkAttach= By.xpath("//div[@id='addAttachment'] //button[contains(text(),'Save')]");
	
	//Indent Items_TG9 added on 041221 //modified on 120722
	public By IndentItemTab= By.xpath("//button[@id='ihb-tab']");
	public By AddIndentItems= By.xpath("//div[@id='_ihb']/div/div/div/button[1]");
	public By TG9_IndentNumber= By.xpath("//input[@id='ihb.Indentno.0']");
	public By DateOfRequirement= By.xpath("//input[@name='ihb_DOR']");
	public By Department= By.xpath("//input[@id='ihb.Dept.0']");
	public By IndentDate= By.xpath("//input[@name='ihb_Indent']");
	
	//BOM Items_TG9 added on 041221 //modified on 120722
	
	public By BOMitemsTab= By.xpath("//button[@id='bpplindent-tab']");
	public By addNonSORitemsIndent_TG9 = By.xpath("//div[@id='rfqItemtabl2-bpplindent']/div/button[1]");
	public By ItemCode= By.xpath("//input[@name='item_code']");
	public By BudgetHead= By.xpath("//input[@name='budget'] [@type='text']");
	public By ItemName= By.xpath("//input[@name='item_name']");
	public By ItemDescription= By.xpath("//textarea[@id='bpplindent.indent_desc.0']");
	public By brand= By.xpath("//input[@id='bpplindent.brand.0']");
	public By UOM= By.xpath("//select[@id='bpplindent.uom.0']");
	public By ItemQuantity= By.xpath("//input[@id='bpplindent.item_qty.0']");
	public By QuantityInStore= By.xpath("//input[@id='bpplindent.QIS.0']");
	public By QuantityRequire= By.xpath("//input[@id='bpplindent.QR.0']");
	public By LastPurchasePrice= By.xpath("//input[@id='bpplindent.LPP.0']");
	public By EstimatedPrice= By.xpath("//input[@id='bpplindent.estimat_price.0']");
	public By SORRate= By.xpath("//input[@id='bpplindent.sor_rate.0']");
	
	public By SanctionDocumentID(String val) {

		return By.xpath("//span[contains(text(),'" + val + "')]");
	}
	
	public By SanctionReferenceNumber(String val) {

		return By.xpath("//span[contains(text(),'" + val + "')]");
	}

	
	public By SanctionDocumentID_CompletedList(String val) {
		return By.xpath("//*[contains(text(),'" + val + "')]");
	}

	public By SanctionReferenceNumber_CompletedList(String val) {
		return By.xpath("//*[contains(text(),'" + val + "')]");
	}
	
	public By snDetailsLink= By.xpath("//tbody/tr[1]/td[10]/div[1]/ul[1]/li[1]/a[1]");
	public By snComment= By.xpath("//a[contains(text(),'Comment')]");
	public By poApproverComment= By.xpath("//strong[contains(text(),'Approver Comment')]");
	public By detailsofCorrigendumNumber= By.xpath("//*[@id='staticBackdropLabel']");

	//Throbber locators
	public By PleaseWait= By.xpath("//div[contains(text(),'Please Wait')]");
	
	//===============PR_Locator================
	
	public By allPRCheck= By.xpath("//thead/tr[1]/th[1]/label[1]/span[1]");
	public By allPRActionButton= By.xpath("//thead/tr[1]/th[6]/div[1]/button[1]");
	public By createTenderFromButton= By.xpath("//thead/tr[1]/th[6]/div[1]/ul[1]/li[3]/a[1]/span[1]");
	public By createSNFromPRButton= By.xpath("(//span[text()='Create SN'])[1]");
	public By confirmationPRtoRFQ= By.xpath("//button[contains(text(),'Confirm')]");
	public By actionItemPR= By.xpath("//*[@id='_pr_tab']/div/table/tbody/tr[1]/td[6]/div/button");
	public By documents= By.xpath("//*[contains(normalize-space(text()),'Document(s)')]");
	public By labelPRDoc= By.xpath("//input[@placeholder='Label']");
	public By addattachment= By.xpath("//button[@tooltip='Add Attachment']");
	public By fileUpload= By.xpath("//input[@name='fileUpload']");
	public By downloadAttachment= By.xpath("//*[@data-icon='download']");
	public By addToTender= By.xpath("(//span[contains(text(), 'Add to Tender')])[1]");
	public By downloadPRdoc= By.xpath("//*[@tooltip='Download']");
	//During Tender Creation
	//Limited Tender
	public By addSupplier= By.xpath("//button[@class='btn btn-icon btn-primary']");
	public By searchSupplier= By.xpath("//input[@name='userCodeOrVendorOrg']");
	public By searchSupplierButton= By.xpath("//input[@name='userCodeOrVendorOrg']/parent::div//following-sibling::div[2]/button[1]");
	public By selectAllSuppliers= By.xpath("//input[@id='check-all']");
	public By add_close= By.xpath("//button[contains(text(),'Add & Close')]");
	
	//=========================================
	
	//===============Fresh SN==================
	public By createFSN= By.xpath("//span[contains(text(),'Create fresh sanction')]");
	public By selectTG_msn= By.xpath("//select[@name='groupId']");
	public By allFSNList= By.xpath("//span[contains(text(),'All fresh sanctions')]");
	//==========supplierSelection_for_MSN=================
	public By clickONsupplierSelectionSearchBox= By.xpath("//span[contains(text(),'Nothing selected')]");
	public By enterSupplierName= By.xpath("//div[@class='bs-searchbox']/input");
	public By clickONsupplierName(String supplierCompanyName) { return By.xpath("//a[contains(text(), '"+supplierCompanyName+"')]");}
	public By omitSupplierSection= By.xpath("//ol[@ng-model='selctedVendorForManual.vendors']/button");
	public By verifySupplierName= By.xpath("//td[contains(text(),'MALHOTRA PVT. LTD.')]");
	
	//Locators of field of templates
	public By openTemplates= By.xpath("(//a[contains(text(), 'Sanction Note details of:')])[1]");
	//General Information
	public By tenderID_msn= By.xpath("(//textarea[@id='quot_gen_info.orgtenderid.0'])[1]");
	public By tenserDescription_msn= By.xpath("(//textarea[@id='quot_gen_info.tender_desc.0'])[1]");
	public By Qutotaion_reference_no_msn= By.xpath("(//input[@name='quote_ref_no'])[1]");
	public By Quotation_currency_msn= By.xpath("//button[@class='btn btn-default dropdown-toggle show-special-title']/span[2]");
	public By Select_Quotation_currency_msn= By.xpath("(//a[contains(text(), 'INR - INDIAN RUPEE')])[1]");
	public By Close_Quotation_currency_msn= By.xpath("(//span[contains(text(), 'INR - INDIAN RUPEE')])[1]");
	public By Exception_msn= By.xpath("(//textarea[@ng-model='template.validationMessage'])[1]");
	
	//BOM Item
	public By add_Row_BOM_Item= By.xpath("(//button[@data-original-title='Add Row'])[1]");
	public By ItemCode_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_code'])["+val+"]");
	}
	public By ItemName_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_name'])["+val+"]");
	}
	public By HSNCode_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='HSN_Code'])["+val+"]");
	}
	public By MakeofItem_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Make_of_Item'])["+val+"]");
	}
	public By Unit_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::select[@name='uom'])["+val+"]");
	}
	public By Qty_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_qty'])["+val+"]");
	}
	public By UnitRate_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Unit_Rate'])["+val+"]");
	}
	public By GSTType_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::select[@name='GST_TYPE'])["+val+"]");
	}
	public By CGST_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='cgst_per'])["+val+"]");
	}
	public By CGST_Value_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='CGST_Value'])["+val+"]");
	}
	public By SGST_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='sgst_per'])["+val+"]");
	}
	public By SGST_Value_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='SGST_Value'])["+val+"]");
	}
	public By IGST_BomItems_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='igst_per'])["+val+"]");
	}
	public By IGST_Value_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='IGST_Value'])["+val+"]");
	}
	public By Total_GST_Value_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Total_GST'])["+val+"]");
	}
	public By GrandTotal_IncludingGST_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Grand_Total_GST'])["+val+"]");
	}
	public By TotalBasicAmount_msn(int val) {

		return By.xpath("(//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Basic_Total'])["+val+"]");
	}
	public By BOMItemsTemplate= By.xpath("(//div[contains(text(), 'BOM Items')])[1]");
	public By ItemCode_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_code']");
	public By ItemName_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_name']");
	public By HSNCode_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='HSN_Code']");
	public By MakeofItem_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Make_of_Item']");
	public By Unit_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::select[@name='uom']");
	public By Qty_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='item_qty']");
	public By UnitRate_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='Unit_Rate']");
	public By GSTType_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::select[@name='GST_TYPE']");
	public By CGST_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='cgst_per']");
	public By SGST_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='sgst_per']");
	public By IGST_BomItems_msn= By.xpath("//div[contains(text(), 'BOM Items')]//following-sibling::div/descendant-or-self::input[@name='igst_per']");
	
	//Terms & Conditions
	public By TermsConditionsTemplate= By.xpath("(//div[contains(text(), 'Terms & Conditions')])[1]");
	public By ClauseSubClauseNo_TC_msn= By.xpath("(//input[@name='clause_no'])[1]");
	public By ClauseSubClauseHeaderTitle_TC_msn= By.xpath("(//input[@name='Header'])[1]");
	public By Description_TC_msn= By.xpath("(//textarea[@name='Description'])[1]");
	public By Attachment_TC_msn= By.xpath("(//input[@title='Select file'])[1]");
	public By Remarks_TC_msn= By.xpath("(//textarea[@name='Remarks'])[1]");
	public By Exceptions_TC_msn= By.xpath("(//textarea[@ng-model='template.validationMessage'])[3]");
	
	//Technical Specification
	public By TechnicalSpecificationTemplate= By.xpath("(//div[contains(text(), 'Technical Specification')])[1]");
	public By ClauseSubClauseNo_TS_msn= By.xpath("(//input[@name='Clause_subcla_No'])[1]");
	public By ClauseSubClauseHeaderTitle_TS_msn= By.xpath("(//input[@name='Clause_Header_Title'])[1]");
	public By Description_TS_msn= By.xpath("(//textarea[@name='Description'])[2]");
	public By Remarks_TS_msn= By.xpath("(//textarea[@name='Remarks'])[2]");
	
	//Details of Items
	public By DetailsItemsTemplate= By.xpath("(//div[contains(text(), 'Details of Items')])[1]");
	public By add_Row_BomDetails= By.xpath("(//button[@data-original-title='Add Row'])[4]");
	public By ItemCode_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='item_code'])["+val+"]");
	}
	public By ItemName_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='item_name'])["+val+"]");
	}
	public By HSNCode_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='HSN_Code'])["+val+"]");
	}
	public By MakeofItem_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='Make_of_Item'])["+val+"]");
	}
	public By Unit_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::select[@name='uom'])["+val+"]");
	}
	public By Qty_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='item_qty'])["+val+"]");
	}
	public By UnitRate_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='Unit_Rate'])["+val+"]");
	}
	public By GSTType_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::select[@name='GST_TYPE'])["+val+"]");
	}
	public By CGST_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='cgst_per'])["+val+"]");
	}
	public By SGST_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='sgst_per'])["+val+"]");
	}
	public By IGST_BomDetails_msn(int val) {

		return By.xpath("(//div[contains(text(), 'Details of Items')]//following-sibling::div/descendant-or-self::input[@name='igst_per'])["+val+"]");
	}
	//validate PD 134435
	public By BasicPrice_msn= By.xpath("(//label[contains(text(), 'Basic Price')]/parent::div//following-sibling::div/span)[1]");
	public By TotalBasicPrice= By.xpath("(//strong[contains(text(),'Total Basic Amount (Rs.)')])[1]");
	public By TotalGSTValue= By.xpath("(//strong[contains(text(),'Total GST Value (Rs.)')])[1]");
	public By grandtotal= By.xpath("(//strong[contains(text(),'Grand Total (Including GST)')])[1]");
	public By TotalGSTValue_msn= By.xpath("(//label[contains(text(), 'Total GST Value (Rs.)')]/parent::div//following-sibling::div/span)[1]");
	public By GrandTotal_msn= By.xpath("(//label[contains(text(), 'Grand Total (Including GST)')]/parent::div//following-sibling::div/span)[1]");
	// validate Other price attribute template
	public By InputTaxCreditValue_msn= By.xpath("(//th[contains(text(), 'Input Tax Credit Value (Rs.)')]//following-sibling::td/span)[1]");
	public By LandedCostNetofInputTaxCredit_msn= By.xpath("(//th[contains(text(), 'Landed Cost Net of Input Tax Credit')]//following-sibling::td/span)[1]");
	public By LANDEDCOSTTenderValue_msn= By.xpath("(//th[contains(text(), 'LANDED COST (Rounded Off) Tender Value')]//following-sibling::td/span)[1]");
	//Validate Manual SN list page
	public By Validate_msn_DocNo(String val) {

		return By.xpath("//td[contains(text(), '"+val+"')]");
	}
	public By Validate_msn_RefNo(String val) {

		return By.xpath("//span/a[contains(text(), '"+val+"')]");
	}

	public By Validate_msn_Status= By.xpath("//td[contains(text(),'Completed')]");
	public By Validate_msn_Stage= By.xpath("//button[@id='clsd']");
	public By Validate_msn_IssuePOIcon= By.xpath("//button[contains(text(),'Issue PO')]");
	
	public By msn_menu(String val) {

		return By.xpath("//td[contains(text(), '"+val+"')]//following-sibling::td[7]/div[1]/button[1]");
	}
	public By View_ManualSN(String val) {

		return By.xpath("//td[contains(text(), '"+val+"')]//following-sibling::td[7]/div[1]/button[1]//following-sibling::ul/li[1]");
	}
	public By close_MSNView= By.xpath("(//button[@class='btn-close ms-sm-2'])[1]");
	
	//suppiler registration
	//=========================================
	public By tenderAttachmentLocator= By.xpath("(//input[@file-model='tenderAttachments'])[1]");
	public By enrollmentBtn= By.xpath("//*[@id='nav']/li[2]/a");
	public By supplierRegistrationBtn= By.xpath("//a[@title='Supplier Registration']");
	public By freshRegistrationRadioBtn= By.xpath("//input[@value='Fresh']");
	public By registrationContinue= By.xpath("//button[contains(text(),'Continue')]");
	public By CountrySelect= By.xpath("//select[@name='country']");
	public By Pan= By.xpath("//input[@name='pan']");
	public By PanCardName= By.xpath("//input[@name='nameInPan']");
	public By companyName= By.xpath("//input[@name='companyname']");
	public By address= By.xpath("//*[@name='regofficeaddress']");
	public By BusinessType= By.xpath("//*[@name='naturecompany']");
	public By city= By.xpath("//*[@name='city']");
	public By firstName= By.xpath("//*[@name='firstname']");
	public By lastName= By.xpath("//*[@name='lastname']");
	public By title= By.xpath("//*[@name='salutation']");
	public By mobileNo= By.xpath("//*[@name='otpMobile']");
	public By email= By.xpath("//*[@name='otpEmail']");
	public By getOTPBtn= By.xpath("//button[contains(text(), 'Get OTP')]");
	public By successOK= By.xpath("//button[text()='OK']");
	public By emailOTP= By.xpath("//*[@name='validOtpEmail']");
	public By validateandSubmit= By.xpath("//button[contains(text(), 'Validate & Submit')]");
	public By viewMessage= By.xpath("//*[@id='main-content-nw']/section/div[1]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li/a");
	public By mailBody= By.xpath("//*[@id='viewMailDetails']/div/div/div[2]/div[2]/div/div/text()[5]");
	public By itemCategoryTab= By.xpath("//*[@data-bs-target='#nav-category']");
	public By itemCheck= By.xpath("//*[@id='accordion1']/div[1]/div[1]/h4/span[1]/label/span");
	public By organization= By.xpath("//*[@data-bs-target='#nav-organization']");
	public By hsnCategory= By.xpath("//label[@for='completetender']");
	public By doYouHaveGSTIN= By.xpath("//*[@name='br_gstin_gstin_applicable']");
	public By bidderGSTINfirstbox= By.xpath("//*[@id='input0']");
	public By bidderGSTINSecondbox= By.xpath("//*[@id='input1']");
	public By bidderGSTINthirdbox= By.xpath("//*[@id='input2']");
	public By bidderGSTINFourthbox= By.xpath("//*[@id='input3']");
	public By GSTINCopy = By.xpath("//*[@name='br_gstin_gstin_attachment']");
	public By CopyofPANcard = By.xpath("//*[@name='br_gstin_pan_attachment']");
	public By unitaddress = By.xpath("//*[@id='br_gstin.address.0']");
	public By bankName = By.xpath("//*[@id='br_gstin.bank_name.0']");
	public By branch = By.xpath("//*[@id='br_gstin.branch_name.0']");
	public By bankAccountByNo = By.xpath("//*[@id='br_gstin.acno.0']");
	public By IFSCcode = By.xpath("//*[@id='br_gstin.ifsc.0']");
	public By CancelledCheque = By.xpath("//*[@name='br_gstin_cancelled_cheque']");
	public By organizationItemCheckbox = By.xpath("//input[@type='checkbox' and @class='mdc-checkbox__native-control']");
	public By OrganizationItemCategoryTab = By.xpath("//*[contains(normalize-space(text()),'ORGANIZATION ITEM CATEGORY')]");
	public By innerSubmit = By.xpath("(//button[@tooltip='Submit'])[2]");
	
	
	public By organizationInfoArrowBtn= By.xpath("//*[@data-icon='angle-double-right']");
	public By searchBox= By.xpath("//*[@placeholder='Search By Organization Name']");
	public By submitVendor= By.xpath("//*[@tooltip='Submit']");
	public By USERNAME= By.xpath("//*[@name='userid']");
	public By agreeDisclamerCheckbox= By.xpath("//form[@name='userCode']/div/div/div/div[2]/label/section/mat-checkbox/div/div");
	public By setUserNmae_SubmitBtn= By.xpath("//*[@id='userCodeBox']/div/div/div[3]/button[1]");
	public By resetPasswordLink= By.xpath("//*[@id='viewMailDetails']/div/div/div[2]/div[2]/div/div/a");
	public By newPassword= By.xpath("//*[@name='newPassword']");
	public By confirmNewPassword= By.xpath("//*[@name='confirmNewPassword']");
	public By resetpasswordSubmit= By.xpath("//*[@id='orgAddlist']");
	public By sectionWiseView= By.xpath("//*[contains(normalize-space(text()),'Section Wise Comment')]");


	public By loadingLocator= By.xpath("//div[@class='ngx-overlay loading-foreground']");
	
}




