package com.vaadin.testbenchexample;

import com.vaadin.testbench.TestBenchElement;
import org.checkerframework.checker.units.qual.N;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.time.LocalDate;

public class ClaimsIT extends BaseLoginTest{
    @Test
    public void deathClaim() throws InterruptedException, IOException {

        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("08D5371370");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("08D5371370").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getAddClaimsButton().click();
        EntryDialogContent createClaim = $(EntryDialogContent.class).first();
 //       createClaim.addRundomCaseNumber();
        createClaim.getClaimType().selectByText("Death");
        LocalDate currentDate = createClaim.getReceivedDate().getDate();
        LocalDate newDate = currentDate.minusMonths(1);
        createClaim.getIncurredDate().setDate(newDate);
 //       createClaim.getClaimCause().selectByText("Colon Cancer - C18.9");
        createClaim.saveAndOpenButton().click();
        menu.processClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Decision");
        event.okButton().click();


        NaviMenuView claimPayment = $(NaviMenuView.class).first();
        claimPayment.makePayment().click();
        EntryDialogContent payment = $(EntryDialogContent.class).first();
        payment.getPayee().selectItemByIndex(0);
        payment.okButton().click();
        NaviMenuView policyTransactions=$(NaviMenuView.class).first();
        policyTransactions.claimPolicy().click();
        policyTransactions.policyTransactions().click();
        ScenarioView transactions = $(ScenarioView.class).first();

        transactions.reverseThirdTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirmDelete = $(VaadinConfirmDialogView.class).first();
        confirmDelete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);


        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
        delete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView remove = $(VaadinConfirmDialogView.class).first();
        remove.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        NaviMenuView getClaim=$(NaviMenuView.class).first();
        getClaim.claims().click();
        ScenarioView getClaims = $(ScenarioView.class).first();
        getClaims.getClaim().getCell("Approved").click();
        getClaim.processClaim().click();
        EntryDialogContent change = $(EntryDialogContent.class).first();
        change.getEventType().selectByText("Decision");
        EntryDialogContent denyClaim = $(EntryDialogContent.class).first();
        denyClaim.editDecision().click();
        EntryDialogContent decision = $(EntryDialogContent.class).last();
        decision.getClaimDecision().selectByText("Deny");
        decision.okButton().click();
        EntryDialogContent reason = $(EntryDialogContent.class).first();
        reason.getDenialClaimReason().selectByText("Marked Up In Error");
        reason.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());





    }
    @Test
    public void criticalIllnessClaim() throws InterruptedException, IOException {

        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("08F8812332");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("08F8812332").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claimsCI().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getAddClaimsButton().click();
        EntryDialogContent createClaim = $(EntryDialogContent.class).first();
        //       createClaim.addRundomCaseNumber();
        createClaim.getClaimType().selectByText("Critical Illness");
        LocalDate currentDate = createClaim.getReceivedDate().getDate();
        LocalDate newDate = currentDate.minusMonths(2);
        createClaim.getIncurredDate().setDate(newDate);
        //       createClaim.getClaimCause().selectByText("Colon Cancer - C18.9");
        createClaim.saveAndOpenButton().click();




        NaviMenuView menu2 = $(NaviMenuView.class).first();
        menu2.processCIClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Approve");
        event.okButton().click();


        NaviMenuView claimPayment = $(NaviMenuView.class).first();
        claimPayment.makeCIPayment().click();
 //       waitUntil(driver -> $(TestBenchElement.class)
 //               .attributeContains("id", "PaymentLinesTable")
 //               .exists(), 10);
        EntryDialogContent payment = $(EntryDialogContent.class).last();
        payment.addButton().click();
        EntryDialogContent benefit = $(EntryDialogContent.class).last();
        benefit.getClaimBenefit().selectItemByIndex(2);
        benefit.okButton().click();
        EntryDialogContent payment2 = $(EntryDialogContent.class).first();
        payment2.getPayee().selectItemByIndex(0);
        payment.okButton().click();
        NaviMenuView policyTransactions=$(NaviMenuView.class).first();
        policyTransactions.claimCIPolicy().click();
        policyTransactions.policyTransactionsCI().click();
        ScenarioView transactions = $(ScenarioView.class).first();

        transactions.reverseSecondTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirmDelete = $(VaadinConfirmDialogView.class).first();
        confirmDelete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

/*
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
        delete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
*/
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView remove = $(VaadinConfirmDialogView.class).first();
        remove.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        NaviMenuView getClaim1=$(NaviMenuView.class).first();
        getClaim1.claimsCI().click();
        ScenarioView getClaims2 = $(ScenarioView.class).first();
        getClaims2.getClaim().getCell("Pending").click();
        getClaim1.processCIClaim().click();
        EntryDialogContent change = $(EntryDialogContent.class).first();
        change.getEventType().selectByText("Denial");
  /*
        EntryDialogContent denyClaim = $(EntryDialogContent.class).first();
        denyClaim.editDecision().click();
        EntryDialogContent decision = $(EntryDialogContent.class).last();
        decision.getClaimDecision().selectByText("Deny");
        decision.okButton().click();
        EntryDialogContent reason = $(EntryDialogContent.class).first();

   */
        change.getDenialClaimReason().selectByText("Marked Up In Error");
        change.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());








    }
    @Test
    public void accidentClaim() throws InterruptedException, IOException {

        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("08F8805873");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("08F8805873").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claimsCI().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getAddClaimsButton().click();
        EntryDialogContent createClaim = $(EntryDialogContent.class).first();
        //       createClaim.addRundomCaseNumber();
    //    createClaim.getClaimType().selectByText("Terminal Illness");
        LocalDate currentDate = createClaim.getReceivedDate().getDate();
        LocalDate newDate = currentDate.minusMonths(1);
        createClaim.getIncurredDate().setDate(newDate);
        //       createClaim.getClaimCause().selectByText("Colon Cancer - C18.9");
        createClaim.saveAndOpenButton().click();




        NaviMenuView menu2 = $(NaviMenuView.class).first();
        menu2.processCIClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Approve");
        event.okButton().click();


        NaviMenuView claimPayment = $(NaviMenuView.class).first();
        claimPayment.makeCIPayment().click();
        EntryDialogContent payment = $(EntryDialogContent.class).first();
        payment.addButton().click();
        EntryDialogContent benefit = $(EntryDialogContent.class).last();
        benefit.getClaimBenefit().selectItemByIndex(7);
        benefit.okButton().click();
        EntryDialogContent payment2 = $(EntryDialogContent.class).first();
        payment2.getPayee().selectItemByIndex(0);
        payment.okButton().click();
        NaviMenuView policyTransactions=$(NaviMenuView.class).first();
        policyTransactions.claimCIPolicy().click();
        policyTransactions.policyTransactionsCI().click();
        ScenarioView transactions = $(ScenarioView.class).first();

        transactions.reverseSecondTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirmDelete = $(VaadinConfirmDialogView.class).first();
        confirmDelete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

/*
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
        delete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
*/
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView remove = $(VaadinConfirmDialogView.class).first();
        remove.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        NaviMenuView getClaim1=$(NaviMenuView.class).first();
        getClaim1.claimsCI().click();
        ScenarioView getClaims2 = $(ScenarioView.class).first();
        getClaims2.getClaim().getCell("Pending").click();
        getClaim1.processCIClaim().click();
        EntryDialogContent change = $(EntryDialogContent.class).first();
        change.getEventType().selectByText("Denial");
  /*
        EntryDialogContent denyClaim = $(EntryDialogContent.class).first();
        denyClaim.editDecision().click();
        EntryDialogContent decision = $(EntryDialogContent.class).last();
        decision.getClaimDecision().selectByText("Deny");
        decision.okButton().click();
        EntryDialogContent reason = $(EntryDialogContent.class).first();

   */
        change.getDenialClaimReason().selectByText("Marked Up In Error");
        change.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());
    }
}
