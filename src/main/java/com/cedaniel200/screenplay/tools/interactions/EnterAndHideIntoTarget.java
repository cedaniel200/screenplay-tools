package com.cedaniel200.screenplay.tools.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class EnterAndHideIntoTarget extends EnterValue {

    private Target target;
    private String mask;

    public EnterAndHideIntoTarget(String theText, String mask, Target target) {
        super(theText);
        this.target = target;
        this.mask = mask;
    }

    @Step("{0} enters #mask into #target")
    public <T extends Actor> void performAs(T theUser) {
        target.resolveFor(theUser).type(theText);
        if (getFollowedByKeys().length > 0) {
            target.resolveFor(theUser).sendKeys(getFollowedByKeys());
        }
    }
}
