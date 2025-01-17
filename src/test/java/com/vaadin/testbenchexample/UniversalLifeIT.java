package com.vaadin.testbenchexample;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.screenshot.ImageFileUtil;

public class UniversalLifeIT extends BaseLoginTest {
/*
	@Test
	public void addSuspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "01N1506575" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "01N1506575" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.suspense().click();
		ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
		addSuspenseButton.addSuspenceButton().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",suspenseSource.suspenseAmount().getValue() );
		suspenseSource.suspenseSource().selectByText( "Check" );
		Assertions.assertEquals( "Check",suspenseSource.suspenseSource().getSelectedText() );
		suspenseSource.depositAccount().selectByText( "General Premium" );
		suspenseSource.processButton().click();
		ScenarioView checkSuspence=$(ScenarioView.class).first();
	//	Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

		checkSuspence.transferSuspenceButton().click();
		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccount().selectByText( "General Premium" );
	//	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
	//	transferSuspence.note().sendKeys( "123" );
	//	transferSuspence.toAccount().focus();
		transferSuspence.toAccount().selectByText( "Family" );
		transferSuspence.searchFamily().sendKeys( "Palmer" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "Palmer" ).click();
		transferSuspence.toAccount().selectByText( "General Premium" );
		transferSuspence.transferAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",transferSuspence.transferAmount().getValue() );
		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
		transferSuspence.note().sendKeys( "transfer to David Palmer" );
		transferSuspence.okButton().click();
		ScenarioView suspenceAmount=$(ScenarioView.class).first();
	//	Assertions.assertEquals( "$0.00",suspenceAmount.suspenceBalance().getText() );


	}


	@Test
	public void addLoan() throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "01N1081285" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "01N1081285" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsWL().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
//		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Loan" );
		EntryDialogContent loan = $(EntryDialogContent.class).first();
		loan.loanAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "1000" );
		loan.disbursementMethod().selectByText( "Check Disbursement" );
		Assertions.assertEquals( "1,000.00",loan.loanAmount().getValue() );
		loan.okButton().click();
		ScenarioView processLoanTransaction = $(ScenarioView.class).first();
		processLoanTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
        ScenarioView transactionsPage = $(ScenarioView.class).first();
        waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
		transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
				"Screenshot 2024-05-31 165800.png" ) ) );
		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();
		NaviMenuView policy = $(NaviMenuView.class).first();
		policy.getPolicy().click();
		ScenarioView policyPage = $(ScenarioView.class).first();
		Assertions.assertEquals( "1,000.00",policyPage.loanBalance().getValue() );
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactionsWL().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
        ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();

	}

*/
}




