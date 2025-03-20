package com.vaadin.testbenchexample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.time.LocalDate;

public class GrouplistBillAcceptIT extends BaseLoginTest {

    @Test
    public void suspense() throws InterruptedException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Group");;
        SearchComponentView getGroup = $( SearchComponentView.class ).first();
        getGroup.searchByGroup().sendKeys( "34090" );
        getGroup.searchButton().click();
        getGroup.family().getCell( "34090" ).click();
        NaviMenuView addSuspense = $( NaviMenuView.class ).first();
        addSuspense.groupSuspenseAccept().click();
        ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
        addSuspenseButton.addSuspenceButton().click();
        EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
        suspenseSource.suspenseAmountAccept().setValue( "59.00" );
        Assertions.assertEquals( "59.00",suspenseSource.suspenseAmountAccept().getValue() );
        suspenseSource.suspenseSourceAccept().selectByText( "Check" );
        Assertions.assertEquals( "Check",suspenseSource.suspenseSourceAccept().getSelectedText() );
        suspenseSource.depositAccountAccept().selectByText( "General Premium" );
        suspenseSource.processButton().click();
        ScenarioView checkSuspence=$(ScenarioView.class).first();
//				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

        checkSuspence.transferSuspenceButton().click();
        EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
        transferSuspence.fromAccountAccept().selectByText( "General Premium" );
        //	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
        //	transferSuspence.note().sendKeys( "123" );
        //	transferSuspence.toAccount().focus();
        transferSuspence.toAccountAccept().selectByText( "Group" );
        transferSuspence.searchFamily().sendKeys( "34090" );
        transferSuspence.search().doubleClick();
        transferSuspence.family().getCell( "34090" ).click();
        transferSuspence.toAccountAccept().selectByText( "List Bill" );
        transferSuspence.transferAmountAccept().setValue( "59.00" );
        Assertions.assertEquals( "59.00",transferSuspence.transferAmountAccept().getValue() );
        transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
//		transferSuspence.note().sendKeys( "transfer" );
        transferSuspence.okButton().click();
//		ScenarioView suspenceAmount=$(ScenarioView.class).first();

    }

    @Test
    public void payListBill()throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Group");;
        SearchComponentView getGroup = $( SearchComponentView.class ).first();
        getGroup.searchByGroup().sendKeys( "34090" );
        getGroup.searchButton().click();
        getGroup.family().getCell( "34090" ).click();
        NaviMenuView groupBills = $( NaviMenuView.class ).first();
        groupBills.groupBillsAccept().click();
        ScenarioView bills=$(ScenarioView.class).first();
        bills.bill().getCell("Unpaid").click();
        bills.receivedAsBilledAccept().click();

        bills.reconcileAccept().click();

        Thread.sleep(3_000);
        bills.suspenseFundingAccept().click();

        EntryDialogContent suspenseFunding = $(EntryDialogContent.class).first();
        suspenseFunding.autoFund().click();

        suspenseFunding.okFundButton().click();
        ScenarioView payBill = $(ScenarioView.class).first();
        payBill.processBillAccept().click();

        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();

    }

    @Test
    public void addLoan() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");;
        SearchComponentView getPolicy = $( SearchComponentView.class ).first();
        getPolicy.searchByPolicy().sendKeys( "08D6084896" );
        getPolicy.searchButton().click();
        getPolicy.family().getCell( "08D6084896" ).click();
        NaviMenuView transaction = $( NaviMenuView.class ).first();
        transaction.transactionsLoanAccept().click();
        ScenarioView loanTransaction = $(ScenarioView.class).first();
        loanTransaction.addTransactionButton().click();
//        EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
        selectTransaction.transactionType().selectByText( "Loan" );
        EntryDialogContent loan = $(EntryDialogContent.class).first();
        loan.loanAmountAccept().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "300" );
        loan.loanAmountAccept().sendKeys("300");
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
     /*   transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		System.err.println("Screenshot Directory: " + Parameters.getScreenshotReferenceDirectory());

		try {
			System.err.println("Starting addLoan test...");



			File referenceScreenshot = ImageFileUtil.getReferenceScreenshotFile("Screenshot 2024-05-31 165801.png");
			System.err.println("Reference screenshot path: " + referenceScreenshot.getAbsolutePath());
			System.err.println("Reference screenshot exists: " + referenceScreenshot.exists());

			boolean comparisonResult = testBench().compareScreen(referenceScreenshot);
			System.err.println("Screenshot comparison result: " + comparisonResult);

			Assert.assertTrue("Screenshot comparison failed", comparisonResult);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace(System.err);

			// Create error-screenshots directory if it doesn't exist
			File errorScreenshotDir = new File("error-screenshots");
			if (!errorScreenshotDir.exists()) {
				errorScreenshotDir.mkdirs();
			}

			// Save a failure screenshot with a timestamp
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			File actualScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("error-screenshots/failure-" + timestamp + "-Screenshot-2024-05-31-165801.png");
			FileUtils.copyFile(actualScreenshot, destination);
			System.err.println("Failure screenshot saved to: " + destination.getAbsolutePath());

			throw e; // Re-throw to fail the test
		}


		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();

      */
        NaviMenuView policy = $(NaviMenuView.class).first();
        policy.getPolicyAccept().click();
        ScenarioView policyPage = $(ScenarioView.class).first();
        Assertions.assertEquals( "300.00",policyPage.loanBalanceAccept().getValue());
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
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");;
        SearchComponentView getPolicy = $( SearchComponentView.class ).first();
        getPolicy.searchByPolicy().sendKeys("08D6639609" );
        getPolicy.searchButton().click();
        getPolicy.family().getCell( "08D6639609" ).click();
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

        Assertions.assertEquals( "$67.60",transactionsPage.modalPremium().getText() );

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

//		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
        deleteLoanTransaction.deleteLoanTransactionButton().click();
        VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
        confirmation.getSaveButton().click();


    }

}

