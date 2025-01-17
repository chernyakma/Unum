package com.vaadin.testbenchexample;
import com.vaadin.flow.component.grid.CellFocusEvent;
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

	protected ButtonElement getAddButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "S1" ).$( TestBenchElement.class ).id( "FamilyAddressTable" ).$( ButtonElement.class ).first();

	}
    protected TestBenchElement getName (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$(TestBenchElement.class).id( "crumbs" ).$("breadcrumb-component").first().$(TestBenchElement.class).get( 8 );
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

	protected ButtonElement getDeleteSpouseButton() {


		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( ButtonElement.class ).get( 3 );

	}

	protected ButtonElement getDeleteButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "saveable-page" ).first().$( TestBenchElement.class ).id( "S1" ).$( TestBenchElement.class ).id( "FamilyAddressTable" ).$( ButtonElement.class ).get( 2 );
	}

	protected ButtonElement getDeleteBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("BeneficiaryTable").$(TestBenchElement.class).id("grid").$(ButtonElement.class).get(7);
	}

	protected ButtonElement getDeleteFamilyBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("family-member-page").first().$(TestBenchElement.class).id("membersDiv").$(TestBenchElement.class).id("Members").$(TestBenchElement.class).id("section").$("search-component").first().$(ButtonElement.class).get(3);
	}
		protected ButtonElement addMemberButton() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "Members" ).$( ButtonElement.class ).first();
	}
	protected ButtonElement getAddBeneButton() {

		return $(TestBenchElement.class).id("viewContent").$("scenario-component").first().$(TestBenchElement.class).id("fieldLayout").$("saveable-page").first().$(TestBenchElement.class).id("S0").$(TestBenchElement.class).id("BeneficiaryTable").$(ButtonElement.class).get(1);

	}

	protected GridElement applicationNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "applicationsDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}
	protected GridElement illustrationNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "illustrationsDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}

	protected GridElement policyNumber() {

		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "policiesDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$( GridElement.class ).first();
	}

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

	protected WebElement policyStatus() { return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "titleLayout").$( TestBenchElement.class).id( "summaryTable").$( TestBenchElement.class).id( "componentContent" ).findElements( By.className( "summary-column-value" )).get( 3 );}

	protected WebElement modalPremium() { return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "titleLayout").$( TestBenchElement.class).id( "summaryTable").$( TestBenchElement.class).id( "componentContent" ).findElements( By.className( "summary-column-value" )).get( 7 );}
	protected ButtonElement addSuspenceButton(){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(ButtonElement.class).first();}
	protected TestBenchElement suspenceBalance(){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(TestBenchElement.class).id( "topContent").$("VAADIN-GRID-CELL-CONTENT").get( 9 );}
	protected ButtonElement transferSuspenceButton(){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "suspense-page").first().$(ButtonElement.class).last();}

	protected ButtonElement addTransactionButton(){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "transactions-view-page").first().$(TestBenchElement.class).id( "toolbar" ).$(ButtonElement.class).first();
	}

	protected TextFieldElement loanBalance (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$(TestBenchElement.class).id( "ValuesSection" ).$(TextFieldElement.class).id( "LoanBalance" );}
	protected GridElement cltrCoverage (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( TestBenchElement.class ).id( "CoveragesSection" ).$(TestBenchElement.class).id( "Coverages" ).$(TestBenchElement.class).id("componentContent").$(TestBenchElement.class).id("grid").$(GridElement.class).hasAttribute("vertical-borders").first();
	}
	protected TestBenchElement transactionStatus (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$("transactions-view-page").first().$( TestBenchElement.class ).id( "content" ).$( "search-component" ).first().$(GridElement.class).first().$(TestBenchElement.class).id("scroller").$(TestBenchElement.class).id("table").$(TestBenchElement.class).id("sizer").$(TestBenchElement.class).id("vaadin-grid-cell-32");
	}

	protected GridElement family (){
		return $( TestBenchElement.class ).id( "viewContent" ).$( "scenario-component" ).first().$( TestBenchElement.class ).id( "fieldLayout" ).$( "family-member-page" ).first().$( TestBenchElement.class ).id( "membersDiv" ).$( TestBenchElement.class ).id( "Members" ).$( TestBenchElement.class ).id( "section" ).$( "search-component" ).first().$(GridElement.class).first();
	}


}





