package in.practice.automationtesting.certification.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.exceptions.InternetConnectionException;
import in.practice.automationtesting.certification.tasks.DoLoginTask;
import in.practice.automationtesting.certification.utils.CheckInternetConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URLBase;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinition {

    /*@Managed(driver = "chrome")
    private WebDriver webDriver;
    private Actor userAutomation = Actor.named("userAutomation");*/


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


    @When("^the user enters data for login$")
    public void theUserEntersDataForLogin() {
        theActorCalled("userAutomation").wasAbleTo(DoLoginTask.doLogin());
    }

    @Then("^validate main page$")
    public void validateMainPage() {
    }

}
