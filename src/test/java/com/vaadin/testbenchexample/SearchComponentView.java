package com.vaadin.testbenchexample;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.grid.testbench.GridColumnElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.html.testbench.InputTextElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element( "search-component" )
public class SearchComponentView extends TestBenchElement {

	protected InputTextElement searchBySSN() {

		return $( TestBenchElement.class ).id( "Search" ).$( TextFieldElement.class ).id( "TaxID" ).$(InputTextElement.class).first();

	}
	protected InputTextElement searchByName() {

		return $( TestBenchElement.class ).id( "Search" ).$( TextFieldElement.class ).id( "LastName" ).$(InputTextElement.class).first();

	}

	protected InputTextElement searchByGroup() {

		return $( TestBenchElement.class ).id( "Search" ).$( TextFieldElement.class ).id( "Code" ).$(InputTextElement.class).first();

	}

	protected InputTextElement searchByPolicy(){
		return $( TestBenchElement.class ).id( "Search" ).$( TextFieldElement.class ).id( "PolicyNumber" ).$(InputTextElement.class).first();
	}

	protected ButtonElement searchButton (){
		return $(ButtonElement.class).first();
	}
	protected GridElement family (){
		return $(GridElement.class).first();
	}
	protected GridElement bill (){
		return $(GridElement.class).first();
	}

}


