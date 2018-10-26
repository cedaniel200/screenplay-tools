package com.cedaniel200.screenplay.tools.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.apache.tools.ant.taskdefs.Tar;

public class EnterWithoutShowingInTheReportIntoTarget extends EnterValue {

    private Target target;

    public EnterWithoutShowingInTheReportIntoTarget(String theText, Target target) {
        super(theText);
        this.target = target;
    }

    @Step("{0} enters any text into #target")
    public <T extends Actor> void performAs(T theUser) {
        target.resolveFor(theUser).type(theText);
        if (getFollowedByKeys().length > 0) {
            target.resolveFor(theUser).sendKeys(getFollowedByKeys());
        }
    }
}
