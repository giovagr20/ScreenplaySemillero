package in.practice.automationtesting.certification.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.questions.VerifyRegisterQuestion;
import in.practice.automationtesting.certification.stepdefinitions.hooks.BeforeCheckData;
import in.practice.automationtesting.certification.tasks.DoRegisterTask;
import in.practice.automationtesting.certification.tasks.OpenBrowserTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterUserStepDefinition {


    /*@Managed(driver="chrome")
    private WebDriver webDriver;
    private Actor userAutomation = Actor.named("userAutomation");*/

    @Before
    public void setUp(Scenario scenario) {
        BeforeCheckData beforeCheckData = new BeforeCheckData();
        beforeCheckData.theAbilities(scenario);
    }

    @Given("^the user \"([^\"]*)\" opens navigator$")
    public void theUserOpensNavigator(String actorName) {
        theActorCalled(actorName).attemptsTo(OpenBrowserTask.openBrowser());
    }

    @When("^the user enters data for register user$")
    public void theUserEntersDataForRegisterUser() {
        theActorInTheSpotlight().attemptsTo(DoRegisterTask.doRegister());
    }

    @Then("^validate creation user$")
    public void validateCreationUser() {
        String textValid = "Hello " + USER_NAME.getValue() + " (not "+USER_NAME.getValue()+ "? Sign out)";
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifyRegisterQuestion.verifyRegisterQuestion(), Matchers.equalTo(textValid)));
    }



}
