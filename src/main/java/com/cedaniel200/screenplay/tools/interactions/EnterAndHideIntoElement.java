package com.cedaniel200.screenplay.tools.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.thucydides.core.annotations.Step;

public class EnterAndHideIntoElement extends EnterValue {

    private WebElementFacade element;
    private String mask;

    public EnterAndHideIntoElement(String theText, String mask, WebElementFacade element) {
        super(theText);
        this.mask = mask;
        this.element = element;
    }

    @Step("{0} enters #mask into #element")
    public <T extends Actor> void performAs(T theUser) {
        element.type(theText);
        if (getFollowedByKeys().length > 0) {
            element.sendKeys(getFollowedByKeys());
        }
    }

}
