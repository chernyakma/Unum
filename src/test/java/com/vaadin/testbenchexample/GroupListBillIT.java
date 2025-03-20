package com.vaadin.testbenchexample;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

public class GroupListBillIT extends BaseLoginTest {

	@Test
	public void suspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Group");;
		SearchComponentView getGroup = $( SearchComponentView.class ).first();
		getGroup.searchByGroup().sendKeys( "34090" );
		getGroup.searchButton().click();
		getGroup.family().getCell( "34090" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.groupSuspense().click();
		ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
		addSuspenseButton.addSuspenceButton().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().setValue( "59.00" );
		Assertions.assertEquals( "59.00",suspenseSource.suspenseAmount().getValue() );
		suspenseSource.suspenseSource().selectByText( "Check" );
		Assertions.assertEquals( "Check",suspenseSource.suspenseSource().getSelectedText() );
		suspenseSource.depositAccount().selectByText( "General Premium" );
		suspenseSource.processButton().click();
		ScenarioView checkSuspence=$(ScenarioView.class).first();
//				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

		checkSuspence.transferSuspenceButton().click();
		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccount().selectByText( "General Premium" );
		//	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
		//	transferSuspence.note().sendKeys( "123" );
		//	transferSuspence.toAccount().focus();
		transferSuspence.toAccount().selectByText( "Group" );
		transferSuspence.searchFamily().sendKeys( "34090" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "34090" ).click();
		transferSuspence.toAccount().selectByText( "List Bill" );
		transferSuspence.transferAmount().setValue( "59.00" );
		Assertions.assertEquals( "59.00",transferSuspence.transferAmount().getValue() );
		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
//		transferSuspence.note().sendKeys( "transfer" );
		transferSuspence.okButton().click();
//		ScenarioView suspenceAmount=$(ScenarioView.class).first();

	}

	@Test
	public void payListBill()throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Group");;
		SearchComponentView getGroup = $( SearchComponentView.class ).first();
		getGroup.searchByGroup().sendKeys( "37098" );
		getGroup.searchButton().click();
		getGroup.family().getCell( "37098" ).click();
		NaviMenuView groupBills = $( NaviMenuView.class ).first();
		groupBills.groupBills().click();
		ScenarioView bills=$(ScenarioView.class).first();
		bills.bill().getCell("Unpaid").click();
		bills.receivedAsBilled().click();
		bills.reconcile().click();
		Thread.sleep(3_000);
		bills.suspenseFunding().click();

		EntryDialogContent suspenseFunding = $(EntryDialogContent.class).first();
		suspenseFunding.autoFund().click();

		suspenseFunding.okFundButton().click();
		ScenarioView payBill = $(ScenarioView.class).first();
		payBill.processBill().click();

		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getConfirmButton().click();

	}

	@Test
	public void addLoan() throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");;
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "08D7444033" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "08D7444033" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsLoan().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
//		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Loan" );
		EntryDialogContent loan = $(EntryDialogContent.class).first();
		loan.loanAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "300" );
		loan.loanAmount().sendKeys("300");
		loan.specialHandling().click();
		loan.specialHandling().selectByText("None");
//		loan.disbursementMethod().selectByText( "Check Disbursement" );
//		Assertions.assertEquals( "1,000.00",loan.loanAmount().getValue() );
		Thread.sleep( 5_000 );
		loan.approved().click();
		loan.okButton().click();
//		NaviMenuView seeTransaction = $(NaviMenuView.class).first();
//		seeTransaction.getResult().click();

		ScenarioView processLoanTransaction = $(ScenarioView.class).first();
		processLoanTransaction.processInitialPremiumTransactionButton().click();
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getConfirmButton().click();
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
		policy.getPolicy().click();
		ScenarioView policyPage = $(ScenarioView.class).first();
		Assertions.assertEquals( "300.00",policyPage.loanBalance().getValue());
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactionsLoan().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getConfirmButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinDialogView confirmation = $(VaadinDialogView.class).first();
		confirmation.getConfirmButton().click();

	}


	@Test
	public void addRider() throws InterruptedException, IOException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");;
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys("08D9229851" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "08D9229851" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactions().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
	//	TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Add Rider" );
		EntryDialogContent addRider = $(EntryDialogContent.class).first();
		addRider.coverageName().selectByText("Children's Term");
		addRider.faceAmount().setValue("5000");
	//	addRider.faceAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "5000" );
		Assertions.assertEquals("5,000.00",addRider.faceAmount().getValue());
	//	TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
	//	addRider.notes().sendKeys( "123" );
		addRider.issueAge().click();
		addRider.okButton().click();
		ScenarioView processTransaction = $(ScenarioView.class).first();
		processTransaction.processInitialPremiumTransactionButton().click();
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getConfirmButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 60);

		Assertions.assertEquals( "$ 16.90",transactionsPage.modalPremium().getText() );

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
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getConfirmButton().click();
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);

//		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinDialogView confirmation = $(VaadinDialogView.class).first();
		confirmation.getConfirmButton().click();


	}

}
