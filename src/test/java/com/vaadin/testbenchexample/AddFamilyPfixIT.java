package com.vaadin.testbenchexample;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AddFamilyPfixIT extends BaseLoginTest {


	@Test

	public void addFamily() throws InterruptedException {

	//	getDriver().get("http://localhost:8080/unum_webui/familyInsured");
		//	getDriver().get( "http://" + IPAddress.findSiteLocalAddress() + ":8080/unum_webui/familyInsured");
		getDriver().get("https://unum5Life70.testbed.calcfocus.net/achieve/familyInsured");
		AddFamilyView family = $(AddFamilyView.class).first();

		family.groupID().openPopup();
		family.groupID().selectByText("41426");
		family.addFamily();
		family.getGender().selectByText("Male");
		family.getDateOfBirth().setDate(LocalDate.of(1960, 10, 15));
		family.getTobaccoUse().doubleClick();

		family.getMarriageStatus().selectByText("Married");
		family.getHealthStatus().selectByText("Exceptional");
		family.getPhoneType1().selectByText("Mobile");
		family.getPhoneType2().selectByText("Home");
		family.getFullTimePartTime().selectByText("Full Time");
		Assertions.assertEquals("David", family.getFirstName().getValue());
		Assertions.assertEquals("Palmer", family.getLastName().getValue());
		Assertions.assertEquals("Male", family.getGender().getSelectedText());
//		Assertions.assertEquals("1960-10-15", family.getDateOfBirth().getInputValue());
		       family.getSaveButton().click();
	}

	@Test
	public void addSpouse() {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Family");
		SearchComponentView getFamily = $(SearchComponentView.class).first();
		getFamily.searchBySSN().sendKeys("511377914");
		getFamily.searchButton().click();
		getFamily.family().getCell("Palmer").click();

		ScenarioView addMember = $(ScenarioView.class).first();
		addMember.addMemberButton().click();
		AddFamilyView family = $(AddFamilyView.class).first();
		family.getRelationship().selectByText("Spouse/Partner");
		family.addSpouse();
		family.getSpouseGender().selectByText("Female");
		family.getDateOfBirth().setDate(LocalDate.of(1965, 01, 05));
		family.getNonTobacco().doubleClick();
		family.getMarriageStatus().selectByText("Married");
		family.getHealthStatus().selectByText("Exceptional");
		family.getPhoneType1().selectByText("Mobile");
		family.getPhoneType2().selectByText("Home");

		Assertions.assertEquals("Emma", family.getFirstName().getValue());
		Assertions.assertEquals("Spouse", family.getLastName().getValue());
		Assertions.assertEquals("Female", family.getSpouseGender().getSelectedText());
//		Assertions.assertEquals("1/5/1965", family.getDateOfBirth().getInputValue());
		family.getSaveButton().click();
		family.FamilyButton().click();
		ScenarioView deleteMember = $(ScenarioView.class).first();
		deleteMember.getDeleteSpouseButton().click();
		VaadinDialogView deleteSpouse = $(VaadinDialogView.class).first();
		deleteSpouse.getDeleteButton().click();

	}

	@Test
	public void addFamilyMemberFromPolicy() {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("08D8376320");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("08D8376320").click();
		NaviMenuView getFamily = $(NaviMenuView.class).first();
		getFamily.getFamily().click();
		ScenarioView addMember = $(ScenarioView.class).first();
		addMember.addMemberButton().click();
		AddFamilyView family = $(AddFamilyView.class).first();
		family.getRelationship().selectByText("Spouse/Partner");
		family.addSpouse();
		family.getSpouseGender().selectByText("Female");
		family.getDateOfBirth().setDate(LocalDate.of(1970, 01, 05));
		family.getNonTobacco().doubleClick();
		family.getMarriageStatus().selectByText("Married");
		family.getHealthStatus().selectByText("Exceptional");
		family.getPhoneType1().selectByText("Mobile");
		family.getPhoneType2().selectByText("Home");

		Assertions.assertEquals("Emma", family.getFirstName().getValue());
		Assertions.assertEquals("Spouse", family.getLastName().getValue());
		Assertions.assertEquals("Female", family.getSpouseGender().getSelectedText());
//		Assertions.assertEquals("1/5/1970", family.getDateOfBirth().getInputValue());
		family.getSaveButton().click();
		family.FamilyButton().click();
		ScenarioView deleteMember = $(ScenarioView.class).first();
		deleteMember.getDeleteSpouseButton().click();
		VaadinDialogView deleteSpouse = $(VaadinDialogView.class).first();
		deleteSpouse.getDeleteButton().click();

	}

	@Test
	public void addBank() throws InterruptedException {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Family");
		SearchComponentView getFamily = $(SearchComponentView.class).first();
		getFamily.searchBySSN().sendKeys("511377914");
		getFamily.searchButton().click();
		getFamily.family().getCell("Palmer").click();
		ScenarioView editMember = $(ScenarioView.class).first();
		editMember.getEditFamilyButton().click();
		NaviMenuView getBank = $(NaviMenuView.class).first();
		getBank.getBankInformation().click();
		AddFamilyView addBankAccount = $(AddFamilyView.class).first();
		addBankAccount.addBankButton().click();
		EntryDialogContent bankAccount = $(EntryDialogContent.class).first();
		bankAccount.addAccount("1234566789", "Norfolk", "051000017","Bank of America");
		bankAccount.getAccountNumber().doubleClick();
		bankAccount.getAccountType().selectByText( "Savings" );
		bankAccount.getBankState().selectByText("VA");
		bankAccount.accountNumberEye().doubleClick();
		Assertions.assertEquals("Bank of America", bankAccount.getFinancialInstitutionName().getValue());
		Assertions.assertEquals("051000017", bankAccount.getRoutingNumber().getValue());
		//	Assertions.assertEquals( "Checking",bankAccount.getAccountType().getSelectedText() );
		//	Assertions.assertEquals( "****566789",bankAccount.getAccountNumber() );

		bankAccount.okButton().click();
		AddFamilyView saveButton = $(AddFamilyView.class).first();
		saveButton.getSaveButton().click();
		addBankAccount.deleteBankButton().click();
		saveButton.getSaveButton().click();


	}

	@Test

	public void familyAddress() throws InterruptedException {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Family");
		SearchComponentView getFamily = $(SearchComponentView.class).first();
		getFamily.searchBySSN().sendKeys("511377914");
		getFamily.searchButton().click();
		getFamily.family().getCell("Palmer").click();
		NaviMenuView getAddress = $(NaviMenuView.class).first();
		getAddress.getAddresses().click();
		ScenarioView addAddress = $(ScenarioView.class).first();
		addAddress.getAddButton().click();
		AddressView setAddress = $(AddressView.class).first();
		setAddress.getCountry().selectByText("USA");
		setAddress.address("74 River Street", "25 Main Street", "Norfolk", "23503");
		setAddress.getState().selectByText("VA");
		setAddress.getAddressType().selectByText("Mailing");
		Assertions.assertEquals("Mailing", setAddress.getAddressType().getSelectedText());
//	    setAddress.getDefaultMailing().click();
//	    setAddress.getDefaultBilling().click();
//		setAddress.getDefaultResidence().click();
		Assertions.assertEquals("VA", setAddress.getState().getSelectedText());
		Assertions.assertEquals("74 River Street", setAddress.getLine1().getValue());
		Assertions.assertEquals("25 Main Street", setAddress.getLine2().getValue());
//	    Assertions.assertTrue( setAddress.getDefaultMailing().isChecked() );
//	    Assertions.assertTrue(setAddress.getDefaultResidence().isChecked());
//	    Assertions.assertTrue( setAddress.getDefaultResidence().isChecked() );
		setAddress.getOkButton().click();
//		addAddress.getSaveButton().click();
/*
    	EntryDialogContent ok = $(EntryDialogContent.class).first();
    	waitUntil(driver -> ok.okButton().isDisplayed(), 80);
    	ok.okButton().click();
 		addAddress.getDeleteButton().click();
		addAddress.getSaveButton().click();
    	EntryDialogContent confirm = $(EntryDialogContent.class).first();
    	waitUntil(driver -> confirm.okButton().isDisplayed(), 80);
    	confirm.okButton().click();
*/
	}

	@Test

	public void editAddress() throws InterruptedException {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Family");
		SearchComponentView getFamily = $(SearchComponentView.class).first();
		getFamily.searchBySSN().sendKeys("511377914");
		getFamily.searchButton().click();
		getFamily.family().getCell("Palmer").click();
		NaviMenuView getAddress = $(NaviMenuView.class).first();
		getAddress.getAddresses().click();
		ScenarioView edit = $(ScenarioView.class).first();
		edit.getEditAddressButton().click();
		AddressView setAddress = $(AddressView.class).first();
		setAddress.clearAddress();
		setAddress.address("111 Main Street", "234 Street", "Norfolk", "23503");
		setAddress.getState().selectByText("VA");
		//	setAddress.getDefaultBilling().click();
		//	setAddress.getDefaultResidence().click();
//		setAddress.getDefaultMailing().click();
		Assertions.assertEquals("VA", setAddress.getState().getSelectedText());
		Assertions.assertEquals("111 Main Street", setAddress.getLine1().getValue());
		Assertions.assertEquals("234 Street", setAddress.getLine2().getValue());
//		Assertions.assertTrue(setAddress.getDefaultMailing().isChecked());
		Assertions.assertEquals("23503", setAddress.getZip().getValue());
		setAddress.getCancelButton().click();
		setAddress.getEditOkButton().click();
		edit.getSaveButton().click();

	}

	@Test
	public void addBeneficiary() throws InterruptedException {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("08D6497665");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("08D6497665").click();
		NaviMenuView getBeneficiaries = $(NaviMenuView.class).first();
		getBeneficiaries.beneficiaries().click();
		Thread.sleep(3_000);
		ScenarioView addBeneficiary = $(ScenarioView.class).first();
		addBeneficiary.getAddBeneButton().click();
		EntryDialogContent bene = $(EntryDialogContent.class).first();
		bene.selectBene().selectByText("Add New");
		bene.okButton().click();
		Thread.sleep(3_000);
		EntryDialogContent newBeneficiary = $(EntryDialogContent.class).first();
		newBeneficiary.addBeneficiary("Harry", "Potter", "253-44-6453", "chernyakma@yahoo.com", "1234567890");
		newBeneficiary.dob().setDate(LocalDate.of(1980, 8, 25));
//		newBeneficiary.gender().selectByText("Male");
		Assertions.assertEquals("Potter", newBeneficiary.lastName().getValue());
//		Assertions.assertEquals("8/25/1980", newBeneficiary.dob().getInputValue());
		Assertions.assertEquals("253-44-6453", newBeneficiary.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com", newBeneficiary.email().getValue());
		newBeneficiary.okButton().click();
		ScenarioView beneficiary = $(ScenarioView.class).first();
		beneficiary.getSaveButton().click();
		Thread.sleep(5_000);
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getOkButton().click();
		NaviMenuView family = $(NaviMenuView.class).first();
		family.getFamily().click();
		ScenarioView getBeneficiary = $(ScenarioView.class).first();
		Assertions.assertTrue(getBeneficiary.family().getCell("Potter").isDisplayed());
		getBeneficiary.policyNumber().getCell("08D6497665").click();
		family.beneficiaries().click();
		ScenarioView deleteBene = $(ScenarioView.class).first();
		deleteBene.getDeleteBeneButton().click();
		deleteBene.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getOkButton().click();
		NaviMenuView deleteFamily = $(NaviMenuView.class).first();
		deleteFamily.getFamily().click();
		ScenarioView deleteBeneficiary = $(ScenarioView.class).first();
		deleteBeneficiary.getDeleteFamilyBeneButton().click();
		VaadinDialogView delete = $(VaadinDialogView.class).first();
		delete.getDeleteButton().click();

	}

	@Test
	public void addNewOwner() throws InterruptedException {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("08D7444030");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("08D7444030").click();
		NaviMenuView getOwner = $(NaviMenuView.class).first();
		getOwner.payorAndOwner().click();
		Thread.sleep(3_000);
		ScenarioView newOwner = $(ScenarioView.class).first();
		newOwner.newOwner().click();
		EntryDialogContent addNewOwner = $(EntryDialogContent.class).first();
		addNewOwner.addBeneficiary("Harry", "Potter", "253446453", "chernyakma@yahoo.com", "1234567890");
		addNewOwner.dob().setDate(LocalDate.of(1980, 8, 25));
//		addNewOwner.gender().selectByText("Male");
//		addNewOwner.relationship().selectByText("Spouse");
		Assertions.assertEquals("Potter", addNewOwner.lastName().getValue());
//		Assertions.assertEquals("8/25/1980", addNewOwner.dob().getInputValue());
		Assertions.assertEquals("253-44-6453", addNewOwner.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com", addNewOwner.email().getValue());
		addNewOwner.okButton().click();
		ScenarioView owner = $(ScenarioView.class).first();
		owner.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getOkButton().click();
		NaviMenuView family = $(NaviMenuView.class).first();
		family.getFamily().click();
		ScenarioView checkOwner = $(ScenarioView.class).first();
		Assertions.assertTrue(checkOwner.family().getCell("Potter").isDisplayed());
		checkOwner.policyNumber().getCell("08D7444030").click();
		NaviMenuView ownerAndPayor = $(NaviMenuView.class).first();
		ownerAndPayor.payorAndOwner().click();
		ScenarioView changeOwner = $(ScenarioView.class).first();
		changeOwner.ownerGUID().selectByText("EDWARD P MORRIS");

		changeOwner.getSaveButton().click();
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getOkButton().click();
		NaviMenuView removeNewOwner = $(NaviMenuView.class).first();
		removeNewOwner.getFamily().click();
		ScenarioView deleteOwner = $(ScenarioView.class).first();
		deleteOwner.getDeleteFamilyOwner().click();
		VaadinDialogView delete = $(VaadinDialogView.class).first();
		delete.getDeleteButton().click();

	}

	@Test
	public void addOtherRoles() throws InterruptedException {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");;
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("08D6143421");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("08D6143421").click();
		NaviMenuView getOther = $(NaviMenuView.class).first();
		getOther.otherRoles().click();
		Thread.sleep(3_000);
		ScenarioView addOtherRole = $(ScenarioView.class).first();
		addOtherRole.getAddOtherRolesButton().click();
		EntryDialogContent newRole = $(EntryDialogContent.class).first();
		newRole.roleType().selectByText("Power of Attorney");
		newRole.relation().selectByText("Other");
		newRole.effectiveDate().setDate( LocalDate.now() );
		newRole.okButton().click();
		Thread.sleep(3_000);
		EntryDialogContent addNewRole = $(EntryDialogContent.class).first();
		addNewRole.addBeneficiary("Harry", "Potter", "253446453", "chernyakma@yahoo.com", "1234567890");
		addNewRole.dob().setDate(LocalDate.of(1980, 8, 25));
//		addNewRole.gender().selectByText("Male");
		addNewRole.relationship().selectByText("Other");
		Assertions.assertEquals("Potter", addNewRole.lastName().getValue());
//		Assertions.assertEquals("8/25/1980", addNewRole.dob().getInputValue());
		Assertions.assertEquals("253-44-6453", addNewRole.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com", addNewRole.email().getValue());
		addNewRole.okButton().click();
		Thread.sleep(3_000);
		AddressView address = $(AddressView.class).first();
		address.address("4 Liberty Street", "23 Forest Street", "Norfolk", "23503");
		address.getState().selectByText("VA");
		address.getAddressType().selectByText("Mailing");
		Assertions.assertEquals("Mailing", address.getAddressType().getSelectedText());
		address.getOkButton().click();
		ScenarioView roles = $(ScenarioView.class).first();
		roles.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getOkButton().click();
		NaviMenuView family = $(NaviMenuView.class).first();
		family.getFamily().click();
		ScenarioView checkOwner = $(ScenarioView.class).first();
		Assertions.assertTrue(checkOwner.family().getCell("Potter").isDisplayed());
		checkOwner.policyNumber().getCell("08D6143421").click();
		NaviMenuView deleteOther = $(NaviMenuView.class).first();
		deleteOther.otherRoles().click();
		Thread.sleep(3_000);
		ScenarioView removeRole = $(ScenarioView.class).first();
		removeRole.getDeleteRoleButton().click();
		removeRole.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getOkButton().click();
		NaviMenuView deleteFamilyRole = $(NaviMenuView.class).first();
		deleteFamilyRole.getFamily().click();
		ScenarioView deleteRole = $(ScenarioView.class).first();
		deleteRole.getDeleteFamilyOther().click();
		VaadinDialogView save = $(VaadinDialogView.class).first();
		save.getDeleteButton().click();
	}


}
