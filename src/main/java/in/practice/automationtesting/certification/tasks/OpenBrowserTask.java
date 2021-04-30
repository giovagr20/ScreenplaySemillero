package in.practice.automationtesting.certification.tasks;

import in.practice.automationtesting.certification.exceptions.ElementNotFoundException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static in.practice.automationtesting.certification.userinterfaces.AutomationTestingPage.SPN_TITLE_PAGE_WRONG;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static in.practice.automationtesting.certification.userinterfaces.AutomationTestingPage.SPN_TITLE_PAGE;
import static in.practice.automationtesting.certification.utils.enums.URLEnum.URLBase;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenBrowserTask implements Task {

    public static Logger LOGGER = LogManager.getLogger(OpenBrowserTask.class.getName());


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.url(URLBase.getValue()));

        actor.wasAbleTo(
                Check.whether(SPN_TITLE_PAGE.resolveFor(actor).isVisible()));

        actor.should(seeThat(the(SPN_TITLE_PAGE), isVisible()));


      /*try {

            if(!SPN_TITLE_PAGE_WRONG.resolveFor(actor).isVisible()) {
                throw new ElementNotFoundException(ElementNotFoundException.ELEMENT_NOT_FOUND);
            }
            actor.attemptsTo(
                    Click.on(SPN_TITLE_PAGE_WRONG));
        } catch (ElementNotFoundException e) {
            throw new ElementNotFoundException(ElementNotFoundException.ELEMENT_NOT_FOUND);
        }*/
    }

    public static OpenBrowserTask openBrowser() {
        return Tasks.instrumented(OpenBrowserTask.class);
    }
}
