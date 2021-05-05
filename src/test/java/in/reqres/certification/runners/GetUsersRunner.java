package in.reqres.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/in.reqres.certification/get_users.feature"},
        glue = "in.reqres.certification.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class GetUsersRunner {
}
