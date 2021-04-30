package in.practice.automationtesting.certification.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.exceptions.InternetConnectionException;
import in.practice.automationtesting.certification.questions.VerifyRegisterQuestion;
import in.practice.automationtesting.certification.stepdefinitions.hooks.BeforeCheckData;
import in.practice.automationtesting.certification.tasks.DoRegisterTask;
import in.practice.automationtesting.certification.tasks.OpenBrowserTask;
import in.practice.automationtesting.certification.utils.CheckInternetConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.Stage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URLBase;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_EMAIL;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterUserStepDefinition {


    @Managed(driver="chrome")
    private WebDriver webDriver;

    @Before
    public void setUp() {
        try {
            OnStage.setTheStage(new OnlineCast());
            URL url = new URL(String.valueOf(URLBase.getValue()));
            CheckInternetConnection checkInternetConnection = new CheckInternetConnection(url);
            checkInternetConnection.checkConnection();
        } catch (InternetConnectionException | MalformedURLException e) {
            throw new InternetConnectionException(InternetConnectionException.INTERNET_FAILED);
        }
    }

    @Given("^the user opens navigator$")
    public void theUserOpensNavigator() {
        theActorCalled("userAutomation").attemptsTo(OpenBrowserTask.openBrowser());
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
