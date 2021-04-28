package in.practice.automationtesting.certification.tasks;

import in.practice.automationtesting.certification.exceptions.ElementNotFoundException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.apache.commons.logging.Log;


import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static in.practice.automationtesting.certification.exceptions.ElementNotFoundException.ELEMENT_NOT_FOUND_ALERT;

public class OpenBrowserTask implements Task {

    public static Logger LOGGER = LogManager.getLogManager().getLogger(OpenBrowserTask.class.getName());
    @Override
    public <T extends Actor> void performAs(T actor) {
        Properties prop = new Properties();
        prop.getProperty("");
        try {

        } catch (ElementNotFoundException e) {
            LOGGER.info(ELEMENT_NOT_FOUND_ALERT);
        }
        actor.attemptsTo(Open.url("http://practice.automationtesting.in/"));
    }

    public static OpenBrowserTask openBrowser() {
        return Tasks.instrumented(OpenBrowserTask.class);
    }
}
