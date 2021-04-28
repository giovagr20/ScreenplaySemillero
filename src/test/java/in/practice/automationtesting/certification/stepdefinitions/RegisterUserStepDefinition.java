package in.practice.automationtesting.certification.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.tasks.OpenBrowserTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.Stage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterUserStepDefinition {

    @Managed
    private WebDriver webDriver;
    private Actor userAutomation = Actor.named("userAutomation");

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
        userAutomation.can(BrowseTheWeb.with(webDriver));
    }

    @Given("^the user opens navigator$")
    public void theUserOpensNavigator() {
        userAutomation.attemptsTo(OpenBrowserTask.openBrowser());
    }

    @When("^the user enters data for register user$")
    public void theUserEntersDataForRegisterUser() {
    }

    @Then("^validate creation user$")
    public void validateCreationUser() {
    }



}
