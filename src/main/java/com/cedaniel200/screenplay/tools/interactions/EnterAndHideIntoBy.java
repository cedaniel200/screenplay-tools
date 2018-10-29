package com.cedaniel200.screenplay.tools.interactions;

import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.WebElementLocator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EnterAndHideIntoBy extends EnterValue {

    private final List<By> locators;
    private String mask;

    protected WebElement resolveFor(Actor theUser) {
        return WebElementLocator.forLocators(locators).andActor(theUser);
    }

    public EnterAndHideIntoBy(String theText, String mask, By... locators) {
        super(theText);
        this.mask = mask;
        this.locators = NewList.copyOf(locators);
    }

    @Step("{0} enters #mask into #element")
    public <T extends Actor> void performAs(T theUser) {
        resolveFor(theUser).sendKeys(theText);
        resolveFor(theUser).sendKeys(getFollowedByKeys());
    }
}
