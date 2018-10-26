package com.cedaniel200.screenplay.tools.interactions;

import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterWithoutShowingInTheReport {

    private final String theText;

    public EnterWithoutShowingInTheReport(String text) {
        this.theText = text;
    }

    public static EnterWithoutShowingInTheReport theValue(String text) {
        return new EnterWithoutShowingInTheReport(text);
    }

    public EnterValue into(String cssOrXpathForElement) {
        return instrumented(EnterWithoutShowingInTheReportIntoTarget.class, theText, Target.the(cssOrXpathForElement).locatedBy(cssOrXpathForElement));
    }

    public EnterValue into(Target target) {
        return instrumented(EnterWithoutShowingInTheReportIntoTarget.class, theText, target);
    }

}
