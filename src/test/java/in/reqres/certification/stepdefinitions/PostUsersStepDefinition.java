package in.reqres.certification.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.practice.automationtesting.certification.tasks.PostUsersTask;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.isEmptyOrNullString;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class PostUsersStepDefinition {
    @When("^the user creates single user$")
    public void theUserCreatesSingleUser() {
        theActorInTheSpotlight().attemptsTo(PostUsersTask.postUser());
    }

    @Then("^must be validate response status (\\d+)$")
    public void mustBeValidateResponseStatus(int statusCode) {
        theActorInTheSpotlight().should(
                seeThatResponse(
                        response -> response.statusCode(statusCode)
                                    .body("createdAt", Matchers.not(isEmptyOrNullString()))               )
        );
    }



}
