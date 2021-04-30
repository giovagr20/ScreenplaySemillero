package in.practice.automationtesting.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_NAME;
import static in.practice.automationtesting.certification.userinterfaces.AutomationTestingPage.LBL_WELCOME;

public class VerifyRegisterQuestion implements Question<String>{

    public static Question<String> verifyRegisterQuestion() {
        return actor ->  LBL_WELCOME.resolveFor(actor).getTextValue();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LBL_WELCOME.resolveFor(actor).getTextValue();
    }
}
