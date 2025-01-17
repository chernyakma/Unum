package com.vaadin.testbenchexample;

import com.vaadin.flow.component.datepicker.testbench.DatePickerElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.flow.component.textfield.testbench.TextAreaElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element( "transaction-popup-page" )
public class TransactionPopUpPageView extends TestBenchElement {

		protected SelectElement transactionType()
		{return $( SelectElement.class ).id( "typeSelect" );}

	    protected DatePickerElement effectiveDate(){
			return $(DatePickerElement.class).first();
		}
	protected TextAreaElement note(){
		return $(TextAreaElement.class).first();
	}
	}




