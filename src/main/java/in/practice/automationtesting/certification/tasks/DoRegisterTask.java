package in.practice.automationtesting.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;

import static in.practice.automationtesting.certification.userinterfaces.AutomationTestingPage.*;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_PASSWORD;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_EMAIL;

public class DoRegisterTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MY_ACCOUNT));
        actor.should(GivenWhenThen.seeThat(the(LBL_REGISTER), isVisible()));
        actor.wasAbleTo(
                Enter.theValue(USER_EMAIL.getValue()).into(INP_EMAIL),
                Enter.theValue(USER_PASSWORD.getValue()).into(INP_PASSWORD),
                Click.on(BTN_REGISTER_USER)
        );
    }

    public static DoRegisterTask doRegister() {
        return Tasks.instrumented(DoRegisterTask.class);
    }
}
