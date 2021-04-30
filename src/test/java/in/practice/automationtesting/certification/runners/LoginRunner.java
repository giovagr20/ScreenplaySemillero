package in.practice.automationtesting.certification.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/in.practice.automationtesting.certification.features/login.feature"},
        glue="in.practice.automationtesting.certification.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class LoginRunner {}
