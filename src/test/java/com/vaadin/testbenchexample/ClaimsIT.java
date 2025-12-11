package com.vaadin.testbenchexample;

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
        getPolicy.searchByPolicy().sendKeys("08D7117196");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("08D7117196").click();
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
        payment.getPayee().selectByText("Michael Golden");
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
        reason.getDenialClaimReason().selectByText("Other");
        reason.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());

    }
}
