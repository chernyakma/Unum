package com.vaadin.testbenchexample;
import com.vaadin.flow.component.checkbox.testbench.CheckboxElement;
import com.vaadin.flow.component.checkbox.testbench.CheckboxGroupElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.html.testbench.InputTextElement;
import com.vaadin.flow.component.listbox.testbench.ListBoxElement;
import com.vaadin.flow.component.radiobutton.testbench.RadioButtonGroupElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.datepicker.testbench.DatePickerElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.flow.component.textfield.testbench.TextAreaElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.flow.component.upload.testbench.UploadElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

import java.util.Random;

@Element( "entry-dialog-content" )
public class EntryDialogContent extends TestBenchElement {
    // main buttons
	protected ButtonElement saveAndOpenButton (){
		return $(ButtonElement.class).get(1);
	}
	//bank
	protected InputTextElement getFinancialInstitutionName() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "FinancialInstitutionName" ).$(InputTextElement.class).first();

	}
	protected InputTextElement getBankCity() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "BankCity" ).$(InputTextElement.class).first();

    }

	protected SelectElement getBankStateAccept() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( SelectElement.class ).id( "BankState" );

	}
	protected InputTextElement getAccountNumber() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "AccountNumberUnmasked" ).$(InputTextElement.class).first();

	}
	protected ButtonElement accountNumberEye() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "AccountNumberUnmasked" ).$(ButtonElement.class).first();

	}
	protected TextFieldElement getRoutingNumber() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "RoutingNumber" );

	}

	protected SelectElement getPartyType() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$(SelectElement.class).id( "PartyType" );
	}

	protected SelectElement getAccountTypeAccept() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$(SelectElement.class).id( "AccountType" );
	}


	//buttons

	protected ButtonElement okButton (){

		return $(ButtonElement.class).first();
	}
	protected ButtonElement closeButton (){

		return $(ButtonElement.class).last();}

	protected ButtonElement processButton (){

		return $(ButtonElement.class).first();
	}

	// notes

	protected ButtonElement addNoteButton(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(ButtonElement.class).first();
	}
	protected ButtonElement DeleteNoteButton(){

		return $(ButtonElement.class).get( 2 );
	}
	protected TextAreaElement noteText(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TextAreaElement.class).first();
	}
	protected ButtonElement attachButton(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "viewContent" ).$(ButtonElement.class).id( "addButton" );
	}
	protected DatePickerElement expiresDate(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "timesDiv" ).$(DatePickerElement.class).first();
	}
	protected SelectElement attachmentType(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "attachmentTypeDiv" ).$(SelectElement.class).first();
	}
	protected UploadElement uploadFileButton(){

		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "uploadDiv" ).$(UploadElement.class).first();
	}

	//suspense


	protected SelectElement suspenseSourceAccept(){

		return $(TestBenchElement.class).id( "mainContent" ).$(SelectElement.class).first();
	}


	protected SelectElement depositAccountAccept(){

		return $(TestBenchElement.class).id( "mainContent" ).$(SelectElement.class).last();
	}

	protected InputTextElement suspenseAmountAccept(){

		return $(TestBenchElement.class).id( "mainContent" ).$(TextFieldElement.class).first().$(InputTextElement.class).first();
	}


	protected SelectElement fromAccountAccept () {

		return $( TestBenchElement.class ).id( "mainContent" ).$( "transfer-suspense-component" ).first().$( TestBenchElement.class ).id( "fromContent" ).$( "select-transfer-financial-account-component" ).first().$( SelectElement.class ).first();
	}

	protected SelectElement toAccountAccept (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(SelectElement.class).first();

	}
		protected InputTextElement searchFamily (){

			return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$(TextFieldElement.class).first().$(InputTextElement.class).first();
		}

	protected GridElement family(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$("search-component").first().$(GridElement.class).first();
	}

	protected ButtonElement search (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$(ButtonElement.class).last();
	}
	protected TextAreaElement note (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent" ).$(TextAreaElement.class).first();
	}

	protected InputTextElement transferAmountAccept(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent" ).$(TextFieldElement.class).first().$(InputTextElement.class).first();
	}
	protected DatePickerElement transferEffectveDate(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent").$(DatePickerElement.class).first();
	}

	//loan


	protected TextFieldElement loanAmountAccept (){

		return $(TestBenchElement.class).id( "InputsSection" ).$(TextFieldElement.class).id( "AmountRequested" );
	}
	protected TextFieldElement premiumAmount (){

		return $(TestBenchElement.class).id( "PremiumSection" ).$(TextFieldElement.class).id( "AmountRequested" );
	}
	protected TextAreaElement transactionNotes (){

		return $(TestBenchElement.class).id("pageContent").$(TestBenchElement.class).id( "transactionNotes" ).$(TextAreaElement.class).first();
	}
	protected TextFieldElement billingMonths (){

		return $(TestBenchElement.class).id( "PremiumSection" ).$(TextFieldElement.class).id( "BillingMonths" );
	}


	protected CheckboxElement approvedAccept (){

		return $(TestBenchElement.class).id( "InputsSection" ).$(TestBenchElement.class).id("sectionComponent").$(CheckboxGroupElement.class).id("Approved").$(CheckboxElement.class).first();
	}

	protected SelectElement specialHandlingAccept (){

		return $(TestBenchElement.class).id( "InputsSection" ).$(SelectElement.class).id("SpecialHandling");
	}
	protected TextFieldElement disbursedAmount (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transaction-popup-page").first().$(TestBenchElement.class).id( "InputsSection" ).$( TextFieldElement.class).id( "AmountDisbursed" );
	}
	protected ListBoxElement disbursementMethod (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transaction-popup-page").first().$(TestBenchElement.class).id( "InputsSection" ).$( SelectElement.class).id( "DisbursementMethod" ).$(ListBoxElement.class).first();
	}

	//rider


	protected SelectElement coverageNameAccept (){

		return $(TestBenchElement.class).id( "BenefitsChangeSection" ).$( SelectElement.class).id( "CoverageProductCodeBeingUpdated" );
	}

	protected TextFieldElement faceAmountAccept(){

		return $ (TestBenchElement.class).id( "BenefitsChangeSection" ).$(FormLayoutElement.class).last().$(TextFieldElement.class).id( "FaceAmount" );
	}

	protected InputTextElement issueAgeAccept(){

		return $ (TestBenchElement.class).id( "BenefitsChangeSection" ).$(TextFieldElement.class).id("IssueAge").$(InputTextElement.class).first();
	}
	protected InputTextElement notes(){

		return $ (TestBenchElement.class).id( "transactionNotes" ).$("VAADIN-TEXT-AREA").first().$(InputTextElement.class).id("vaadin-text-area-input-61");
	}

	//Beneficiary

	protected SelectElement selectBeneAccept (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("PartyGUID");
	}
	protected InputTextElement firstName (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TestBenchElement.class).id("sectionComponent").$(TextFieldElement.class).id("FirstName").$(InputTextElement.class).first();
	}
	protected InputTextElement lastName (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("LastName").$(InputTextElement.class).first();
	}
	protected SelectElement gender (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("Gender");
	}
	protected DatePickerElement dob (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("DateOfBirth");
	}
	protected InputTextElement ssn (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("SsnOrTaxID").$(InputTextElement.class).first();
	}
	protected InputTextElement email (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("Email").$(InputTextElement.class).first();
	}
	protected TextFieldElement pnoneNumber (){
		return $(TestBenchElement.class).id("FldSec_1" ).$( FormLayoutElement.class ).first().$(TextFieldElement.class).id("Phone1");
	}
	protected RadioButtonGroupElement defaultAddress (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(RadioButtonGroupElement.class).first();
	}

	//Owner


	protected SelectElement relationshipAccept(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationshipType");
	}

    //Other Roles

	protected SelectElement roleTypeAccept(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RoleType");
	}

	protected SelectElement relationAccept(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationToPrimaryInsured");
	}
	protected DatePickerElement effectiveDate (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("EffectiveDate");
	}

	protected DatePickerElement endDate (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("EndDate");
	}
	//ListBill
	protected CheckboxElement autoFund(){
		return $(TestBenchElement.class).id( "mainContent" ).$("group-bill-payment-deposit-selection-component").first().$(CheckboxElement.class).first();
	}
	protected ButtonElement okFundButton (){

		return $(TestBenchElement.class).id( "mainContent" ).$("group-bill-payment-deposit-selection-component").first().$(ButtonElement.class).first();
	}

	protected ListBoxElement transactionType()
	{return $(TestBenchElement.class).id( "mainContent" ).$("transaction-popup-page").first().$( SelectElement.class ).id( "typeSelect" ).$(ListBoxElement.class).first();}

	//Claims
	protected InputTextElement getClaimNumber() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( TextFieldElement.class ).id( "ClaimNumber" ).$(InputTextElement.class).first();
	}

	protected SelectElement getClaimType() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Type");
	}
	protected DatePickerElement getIncurredDate() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( DatePickerElement.class ).id( "IncurredDate");
	}
	protected DatePickerElement getReceivedDate() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( DatePickerElement.class ).id( "ReceivedDate");
	}
	protected ListBoxElement getClaimCause() {

		return $( TestBenchElement.class ).id( "S1").$( SelectElement.class ).id( "CauseType").$(ListBoxElement.class).first();
	}
	protected SelectElement getEventType() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Type");
	}
	protected SelectElement getPayee() {

		return $( TestBenchElement.class ).id( "S1").$( SelectElement.class ).id( "PayeeGUID");
	}
	protected ButtonElement editDecision (){

		return $( TestBenchElement.class ).id( "S1").$( TestBenchElement.class ).id( "PaymentLinesTable").$(ButtonElement.class).get(1);
	}
	protected SelectElement getClaimDecision() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Decision");
	}
	protected SelectElement getDenialClaimReason() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id("DenialReason");
	}


	public void addRundomCaseNumber() {

		Random random = new Random();
		int randomNumber = 10000 + random.nextInt( 90000 );  // Generate a random number between 100000000 and 900000000
		getClaimNumber().sendKeys( String.valueOf( randomNumber ) );
	}

	public void addBeneficiary (String firstName,String lastName,String ssn,String email,String phoneNumber){
		firstName().sendKeys(firstName);
		lastName().sendKeys(lastName);
		ssn().setValue(ssn);
		email().sendKeys(email);
		pnoneNumber().setValue(phoneNumber);
	}



	public void addAccount(String accountNumber,String city,String routingNumber,String bankName ){
		getFinancialInstitutionName().sendKeys( bankName );
		getBankCity().sendKeys( city );
		getAccountNumber().sendKeys( accountNumber );
		getRoutingNumber().setValue( routingNumber );




	}

}
