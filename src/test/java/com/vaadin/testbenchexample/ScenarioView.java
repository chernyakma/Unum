package com.vaadin.testbenchexample;
import com.vaadin.flow.component.datepicker.testbench.DatePickerElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.grid.CellFocusEvent;
import com.vaadin.flow.component.html.testbench.InputTextElement;
import com.vaadin.flow.component.listbox.testbench.ListBoxElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.flow.component.tabs.testbench.TabElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLTableSectionElement;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.grid.testbench.GridColumnElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.progressbar.testbench.ProgressBarElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

import javassist.bytecode.stackmap.TypeData;

@Element( "scenario-view" )
//@Element( "scenario-component" )
public class ScenarioView extends TestBenchElement {

	//family

	protected GridElement family (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "membersDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$(GridElement.class).first();
	}

	// add/get/save buttons

	protected ButtonElement getAddButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "S1" ).$( TestBenchElement.class ).id( "FamilyAddressTable" ).$( ButtonElement.class ).first();

	}
	protected ButtonElement addMemberButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( ButtonElement.class ).first();
	}
	protected ButtonElement getAddBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("BeneficiaryTable").$(ButtonElement.class).get(1);

	}
	protected ButtonElement getAddBeneButtonAccept() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("BeneficiaryTable").$(ButtonElement.class).get(1);

	}
    protected TestBenchElement getName (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$(TestBenchElement.class).id( "crumbs" ).$("breadcrumb-component").first().$(TestBenchElement.class).get( 8 );
	}
	protected TestBenchElement getFamily (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$(TestBenchElement.class).id( "crumbs" ).$("breadcrumb-component").first().$(TestBenchElement.class).last();
	}
	protected ButtonElement getSaveButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( ButtonElement.class ).first();

	}
	protected ButtonElement getEditAddressButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "S1" ).$( TestBenchElement.class ).id( "FamilyAddressTable" ).$( ButtonElement.class ).get( 1 );
	}

	protected ButtonElement getEditFamilyButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( ButtonElement.class ).first();
	}


	// delete buttons

	protected ButtonElement getDeleteSpouseButtonAccept() {


		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( ButtonElement.class ).get(3 );

	}
	protected ButtonElement getDeleteSpouseButton() {


		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( ButtonElement.class ).get(2 );

	}
	protected ButtonElement getDeleteButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "S1" ).$( TestBenchElement.class ).id( "FamilyAddressTable" ).$( ButtonElement.class ).get( 2 );
	}
	protected ButtonElement getDeleteBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("BeneficiaryTable").$(TestBenchElement.class).id("grid").$(ButtonElement.class).get(3);
	}
	protected ButtonElement getDeleteRoleButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("RoleTable").$(TestBenchElement.class).id("grid").$(ButtonElement.class).get(2);
	}
	protected ButtonElement getDeleteFamilyBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(4);
	}
	protected ButtonElement getDeleteFamilyBeneButtonAccept() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(5);
	}
	protected ButtonElement getDeleteFamilyOwner() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(3);
	}
	protected ButtonElement getDeleteFamilyOther() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(4);
	}
	protected ButtonElement getDeleteFamilyOtherAccept() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(5);
	}


	//policy


	protected GridElement applicationNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "applicationsDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}
	protected GridElement illustrationNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "illustrationsDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}
	protected GridElement policyNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "policiesDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}
	protected ButtonElement newOwner(){
		return $(TestBenchElement.class).id("viewContent").$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "OwnerSection" ).$( TestBenchElement.class ).id( "OwnerDialog" ).$(ButtonElement.class).first();
	}

	protected ListBoxElement ownerGUID(){
		return $(TestBenchElement.class).id("viewContent").$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "OwnerSection" ).$(SelectElement.class).id("OwnerGUID").$(ListBoxElement.class).first();
	}
	protected SelectElement ownerGUIDAccept(){
		return $(TestBenchElement.class).id("viewContent").$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "OwnerSection" ).$(SelectElement.class).id("OwnerGUID");
	}

	protected ButtonElement getAddOtherRolesButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("RoleTable").$(ButtonElement.class).first();

	}

	// transactions

	protected ButtonElement processActivateTransactionButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 6 );
	}

	protected ButtonElement processSuspenseTransactionButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 6 );
	}

	protected ButtonElement processInitialPremiumTransactionButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 2 );
	}

	protected  ProgressBarElement progressBar() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( ProgressBarElement.class ).first();
	}
	protected ButtonElement deleteLoanTransactionButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 3 );
	}

	protected ButtonElement reverseLoanTransactionButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 1 );
	}

	protected ButtonElement reverseAddRiderTransactionButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 1 );
	}
	protected ButtonElement viewLoanTransactionButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page" ).first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$( ButtonElement.class ).get( 2 );
	}
	protected WebElement policyStatus() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "titleLayout").$( TestBenchElement.class).id( "summaryTable").$( TestBenchElement.class).id( "componentContent" ).findElements( By.className( "summary-column-value" )).get( 3 );
	}

	protected WebElement modalPremium() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "titleLayout").$( TestBenchElement.class).id( "summaryTable").$( TestBenchElement.class).id( "componentContent" ).findElements( By.className( "summary-column-value" )).get( 8 );
	}

	protected WebElement policyPaidToDate() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "titleLayout").$( TestBenchElement.class).id( "summaryTable").$( TestBenchElement.class).id( "componentContent" ).findElements( By.className( "summary-column-value" )).get( 9 );
	}


	// suspense

	protected ButtonElement addSuspenceButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(ButtonElement.class).first();
	}

	protected TestBenchElement suspenceBalance(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(TestBenchElement.class).id( "topContent").$("VAADIN-GRID-CELL-CONTENT").get( 9 );
	}

	protected ButtonElement transferSuspenceButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(ButtonElement.class).last();
	}
	protected ButtonElement addTransactionButton(){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page").first().$(TestBenchElement.class).id( "toolbar" ).$(ButtonElement.class).get(1);
	}
	protected TextFieldElement loanBalance (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$(TestBenchElement.class).id( "ValuesSection" ).$(FormLayoutElement.class).last().$("CURRENCY-FIELD").id( "LoanBalance" ).$(TextFieldElement.class).first();}

	protected TextFieldElement loanBalanceAccept (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$(TestBenchElement.class).id( "ValuesSection" ).$(TextFieldElement.class).id( "LoanBalance" );
	}
	protected GridElement cltrCoverage (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( TestBenchElement.class ).id( "CoveragesSection" ).$(TestBenchElement.class).id( "Coverages" ).$(TestBenchElement.class).id("componentContent").$(TestBenchElement.class).id("grid").$(GridElement.class).hasAttribute("vertical-borders").first();
	}
	protected TestBenchElement transactionStatus (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$("transactions-view-page").first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$(GridElement.class).first().$(TestBenchElement.class).id("scroller").$(TestBenchElement.class).id("table").$(TestBenchElement.class).id("sizer").$(TestBenchElement.class).id("vaadin-grid-cell-32");
	}
	protected DatePickerElement date (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$("transactions-view-page").first().$(DatePickerElement.class).first();
	}
	protected ButtonElement cycle (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$("transactions-view-page").first().$(ButtonElement.class).last();
	}



	// list bill

	protected GridElement bill (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "search-component" ).first().$(GridElement.class).first();
	}
	protected ButtonElement receivedAsBilled (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(3);
	}
	protected ButtonElement receivedAsBilledAccept (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(2);
	}
	protected ButtonElement reconcile (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(5);
	}
	protected ButtonElement reconcileAccept (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(4);
	}
	protected ButtonElement processBill (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(6);
	}
	protected ProgressBarElement billProgressBar (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(TestBenchElement.class).id("topComponentContent").$("process-timer").first().$(ProgressBarElement.class).first();
	}
	protected ButtonElement processBillAccept (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).get(5);
	}
	protected ButtonElement suspenseFunding (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(ButtonElement.class).first();
	}
	protected TestBenchElement paidToDate() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("TableSection").$(TestBenchElement.class).id("DivisionsTable").$(GridElement.class).first().$("vaadin-grid-cell-content").get(38);
	}
	protected ButtonElement suspenseFundingAccept (){

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "group-bill-payment-component" ).first().$(TestBenchElement.class).id("GroupBillSection").$(ButtonElement.class).first();
	}
	protected TestBenchElement billInfo(){

	return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "group-billing-payment-page" ).first().$( TestBenchElement.class ).id( "pageContent" ).$( "search-component" ).first().$(TestBenchElement.class).id("BillInfo");
	}

}








