package com.vaadin.testbenchexample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GrouplistBillAcceptIT extends BaseLoginTest {
    protected LocalDate initialPaidToDate;
    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

    @Test
    public void suspense() throws InterruptedException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Group");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getGroup = $( SearchComponentView.class ).first();
        getGroup.searchByGroup().sendKeys( "09010" );
        getGroup.searchButton().click();
        getGroup.family().getCell( "09010" ).click();
        NaviMenuView addSuspense = $( NaviMenuView.class ).first();
        addSuspense.groupSuspenseAccept().click();
        ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
        addSuspenseButton.addSuspenceButton().click();
        EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
        suspenseSource.suspenseAmountAccept().setValue( "104.00" );
        Assertions.assertEquals( "104.00",suspenseSource.suspenseAmountAccept().getValue() );
        suspenseSource.suspenseSourceAccept().selectByText( "Check" );
        Assertions.assertEquals( "Check",suspenseSource.suspenseSourceAccept().getSelectedText() );
        suspenseSource.depositAccountAccept().selectByText( "General Premium" );
        suspenseSource.processButton().click();
        ScenarioView checkSuspence=$(ScenarioView.class).first();
//				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

        checkSuspence.transferSuspenceButton().click();
        Thread.sleep( 3_000 );
        EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
        transferSuspence.fromAccountAccept().selectByText( "General Premium" );
        //	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
        //	transferSuspence.note().sendKeys( "123" );
        //	transferSuspence.toAccount().focus();
        transferSuspence.toAccountAccept().selectByText( "Group" );
        transferSuspence.searchFamily().sendKeys( "09010" );
        transferSuspence.search().doubleClick();
        transferSuspence.family().getCell( "09010" ).click();
        transferSuspence.toAccountAccept().selectByText( "List Bill" );
        transferSuspence.transferAmountAccept().setValue( "104.00" );
        Assertions.assertEquals( "104.00",transferSuspence.transferAmountAccept().getValue() );
        transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
//		transferSuspence.note().sendKeys( "transfer" );
        transferSuspence.okButton().click();
//		ScenarioView suspenceAmount=$(ScenarioView.class).first();

    }
    @Test
    public void addManualGroupBill() throws InterruptedException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Group");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getGroup = $(SearchComponentView.class).first();
        getGroup.searchByGroup().sendKeys("09010");
        getGroup.searchButton().click();
        getGroup.family().getCell("09010").click();
        NaviMenuView transaction = $( NaviMenuView.class ).first();
        transaction.groupTransactionsAccept().click();
        ScenarioView groupTransaction = $(ScenarioView.class).first();
        groupTransaction.addGroupTransactionButton().click();
 //       EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
        selectTransaction.transactionType().selectByText( "Group Manual Bill" );
        EntryDialogContent confirmTransaction = $(EntryDialogContent.class).first();
        confirmTransaction.okButton().click();
        ScenarioView processManualBillTransaction = $(ScenarioView.class).first();
        processManualBillTransaction.processFirstTransactionButton().click();
        Thread.sleep( 3_000 );
  //      VaadinDialogView confirm = $(VaadinDialogView.class).first();
  //      confirm.getConfirmButton().click();
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        ScenarioView transactionsPage = $(ScenarioView.class).first();
        waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 100);
//		System.out.println(transactionsPage.transactionStatus().getCell("Active").getText());
//		Assertions.assertFalse(transactionsPage.transactionStatus().getCell("Pending").isDisplayed());
        Assertions.assertTrue(transactionsPage.manualBillTransactionStatus().getCell("Active").isDisplayed());

    }

    @Test
    public void payListBill()throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Group");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 150);
        SearchComponentView getGroup = $( SearchComponentView.class ).first();
        getGroup.searchByGroup().sendKeys( "09010" );
        getGroup.searchButton().click();
        getGroup.family().getCell( "09010" ).click();
        NaviMenuView getDevivsions=$(NaviMenuView.class).first();
        getDevivsions.getDivisions().click();
        ScenarioView getPaidToDate = $(ScenarioView.class).first();
        String originalDateText = getPaidToDate.paidToDate().getText();
        initialPaidToDate = LocalDate.parse(originalDateText, formatter);
        NaviMenuView groupBills = $( NaviMenuView.class ).first();
        groupBills.groupBillsAccept().click();
        ScenarioView bills=$(ScenarioView.class).first();
        bills.bill().getCell("Unpaid").click();
        bills.receivedAsBilledAccept().click();

  //      bills.reconcileAccept().click();

  //      Thread.sleep(7_000);
        bills.suspenseFundingAccept().click();
        waitUntil(driver -> $(EntryDialogContent.class).exists(), 160);
        EntryDialogContent suspenseFunding = $(EntryDialogContent.class).first();
        suspenseFunding.autoFund().click();

        suspenseFunding.okFundButton().click();
        ScenarioView payBill = $(ScenarioView.class).first();
        payBill.reconcileAccept().click();
        Thread.sleep(7_000);
        payBill.processBillAccept().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 80);
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        ScenarioView process = $(ScenarioView.class).first();
        waitUntil(driver -> process.billInfo().isDisplayed(),80);
        NaviMenuView devivsions=$(NaviMenuView.class).first();
        devivsions.getDivisions().click();
        ScenarioView paidToDate = $(ScenarioView.class).first();
        String updatedText = paidToDate.paidToDate().getText();
        LocalDate updatedDate = LocalDate.parse(updatedText, formatter);
        Assertions.assertEquals(initialPaidToDate.plusMonths(1), updatedDate);

    }

    @Test
    public void addLoan() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $( SearchComponentView.class ).first();
        getPolicy.searchByPolicy().sendKeys( "08D8621791" );
        getPolicy.searchButton().click();
        getPolicy.family().getCell( "08D8621791" ).click();
        NaviMenuView transaction = $( NaviMenuView.class ).first();
        transaction.transactionsLoanAccept().click();
        ScenarioView loanTransaction = $(ScenarioView.class).first();
        loanTransaction.addTransactionButton().click();
//        EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
        selectTransaction.transactionType().selectByText( "Loan" );
        EntryDialogContent loan = $(EntryDialogContent.class).first();
        loan.loanAmountAccept().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "500" );
        loan.loanAmountAccept().sendKeys("500");
        loan.specialHandlingAccept().click();
        loan.specialHandlingAccept().selectByText("None");
//		loan.disbursementMethod().selectByText( "Check Disbursement" );
//		Assertions.assertEquals( "1,000.00",loan.loanAmount().getValue() );
//        Thread.sleep( 5_000 );
        waitUntil(driver -> loan.approvedAccept().isDisplayed(), 80);
        loan.approvedAccept().click();
        loan.okButton().click();
//		NaviMenuView seeTransaction = $(NaviMenuView.class).first();
//		seeTransaction.getResult().click();

        ScenarioView processLoanTransaction = $(ScenarioView.class).first();
        processLoanTransaction.processInitialPremiumTransactionButton().click();
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        ScenarioView transactionsPage = $(ScenarioView.class).first();

        waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
        NaviMenuView policy = $(NaviMenuView.class).first();
        policy.getPolicyAccept().click();
        ScenarioView policyPage = $(ScenarioView.class).first();
        Assertions.assertEquals( "500.00",policyPage.loanBalanceAccept().getValue());
        NaviMenuView transactions = $(NaviMenuView.class).first();
        transactions.transactionsLoanAccept().click();
        ScenarioView deleteTransaction = $(ScenarioView.class).first();
        deleteTransaction.reverseLoanTransactionButton().click();
        VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
        ok.getSaveButton().click();
        waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
        ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
        deleteLoanTransaction.deleteLoanTransactionButton().click();
        VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
        confirmation.getSaveButton().click();

    }


    @Test
    public void addRider() throws InterruptedException, IOException {

        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $( SearchComponentView.class ).first();
        getPolicy.searchByPolicy().sendKeys("08D6791820" );
        getPolicy.searchButton().click();
        getPolicy.family().getCell( "08D6791820" ).click();
        NaviMenuView transaction = $( NaviMenuView.class ).first();
        transaction.transactionsAccept().click();
        ScenarioView loanTransaction = $(ScenarioView.class).first();
        loanTransaction.addTransactionButton().click();
    //    EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
        	TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
        selectTransaction.transactionType().selectByText( "Add Rider" );
        EntryDialogContent addRider = $(EntryDialogContent.class).first();
        addRider.coverageNameAccept().selectByText("Children's Term");
     //   addRider.faceAmountAccept().sendKeys("5000");
        	addRider.faceAmountAccept().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "5000" );
        Assertions.assertEquals("5000",addRider.faceAmountAccept().getValue());
       	TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
       	notes.note().sendKeys( "123" );
  
        addRider.issueAgeAccept().click();
        addRider.okButton().click();
        ScenarioView processTransaction = $(ScenarioView.class).first();
        processTransaction.processInitialPremiumTransactionButton().click();


        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();

        ScenarioView transactionsPage = $(ScenarioView.class).first();

        waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 60);

        Assertions.assertEquals( "$11.27",transactionsPage.modalPremium().getText() );

/*		ScenarioView transactionsPage = $(ScenarioView.class).first();
		transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
				"Screenshot 2024-05-31 165802.png" ) ) );
//		Assertions.assertEquals("Actual",processTransaction.transactionStatus().getText());
		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();
*/
        ScenarioView deleteTransaction = $(ScenarioView.class).first();
        deleteTransaction.reverseAddRiderTransactionButton().click();
        VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
        ok.getSaveButton().click();
        ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
        waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
        deleteLoanTransaction.deleteLoanTransactionButton().click();
        VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
        confirmation.getSaveButton().click();


    }

}

