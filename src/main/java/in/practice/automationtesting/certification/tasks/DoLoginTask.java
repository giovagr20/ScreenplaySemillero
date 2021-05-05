package in.practice.automationtesting.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static in.practice.automationtesting.certification.userinterfaces.AutomationTestingPage.*;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_EMAIL;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_PASSWORD;

public class DoLoginTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(BTN_MY_ACCOUNT));
        actor.wasAbleTo(
                Enter.theValue(USER_EMAIL.getValue()).into(INP_EMAIL_LOGIN),
                Enter.theValue(USER_PASSWORD.getValue()).into(INP_PASSWORD_LOGIN),
                Click.on(BTN_LOGIN)
        );
        /*actor.attemptsTo(Click.on(BTN_LOGIN));
        actor.attemptsTo(Enter.theValue(jdjdjd));*/
    }

    public static Performable doLogin() {
        return Tasks.instrumented(DoLoginTask.class);
    }
}
