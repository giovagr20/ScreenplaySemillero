package in.reqres.certification.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.stepdefinitions.hooks.BeforeCheckData;
import in.practice.automationtesting.certification.tasks.rest.GetUsersTask;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URL_API_BASE;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.USER_API_EMAIL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetUsersStepDefinition {


    @Before
    public void setUp(Scenario scenario) {
        BeforeCheckData beforeCheckData = new BeforeCheckData();
        beforeCheckData.theAbilities(scenario);
    }

    @Given("^the user \"([^\"]*)\" calls an api$")
    public void theUserCallsAnApi(String actorName) {
        theActorCalled(actorName).whoCan(CallAnApi.at(URL_API_BASE.getValue()));
    }

    @When("^the user request to single user$")
    public void theUserRequestToSingleUser() {
        theActorInTheSpotlight().attemptsTo(GetUsersTask.getUsers());
    }

    @Then("^validate response status (\\d+)$")
    public void validateResponseStatus(int statusCode) {
        theActorInTheSpotlight()
                .should(seeThatResponse("User single must be correct",
                response -> response.statusCode(statusCode)
                        .body("data.email", Matchers.equalTo(USER_API_EMAIL.getValue()))));
    }
}
