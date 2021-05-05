package in.practice.automationtesting.certification.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.exceptions.InternetConnectionException;
import in.practice.automationtesting.certification.questions.VerifyRegisterQuestion;
import in.practice.automationtesting.certification.stepdefinitions.hooks.BeforeCheckData;
import in.practice.automationtesting.certification.tasks.DoLoginTask;
import in.practice.automationtesting.certification.utils.CheckInternetConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URLBase;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinition {

    @Before
    public void setUp(Scenario scenario) {
        BeforeCheckData beforeCheckData = new BeforeCheckData();
        beforeCheckData.theAbilities(scenario);
    }


    @When("^the user enters data for login$")
    public void theUserEntersDataForLogin() {

        OnStage.theActorInTheSpotlight().wasAbleTo(DoLoginTask.doLogin());
    }

    @Then("^validate main page$")
    public void validateMainPage() {
        String textValid = "Hello " + USER_NAME.getValue() + " (not "+USER_NAME.getValue()+ "? Sign out)";

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifyRegisterQuestion.verifyRegisterQuestion(), Matchers.equalTo(textValid)));
    }
}
