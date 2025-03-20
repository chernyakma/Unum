package com.vaadin.testbenchexample;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element( "vaadin-dialog-overlay" )

public class VaadinDialogView extends TestBenchElement {


    protected ButtonElement getDeleteButton(){

        return  $(TestBenchElement.class).id("content").$(ButtonElement.class).last();
    }
    protected ButtonElement getOkButton(){

        return  $(TestBenchElement.class).id("content").$(ButtonElement.class).get(3);
    }
    protected ButtonElement getConfirmButton(){

        return  $(TestBenchElement.class).id("content").$(ButtonElement.class).id("confirm");
    }
}