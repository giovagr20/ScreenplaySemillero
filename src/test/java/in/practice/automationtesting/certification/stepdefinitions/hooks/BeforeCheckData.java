package in.practice.automationtesting.certification.stepdefinitions.hooks;

import cucumber.api.java.Before;
import in.practice.automationtesting.certification.exceptions.InternetConnectionException;
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

public class BeforeCheckData {

    @Managed(driver="chrome")
    private WebDriver webDriver;
    private Actor userAutomation = Actor.named("userAutomation");

    @Before
    public void setUp() {
        try {
            OnStage.setTheStage(new OnlineCast());
            userAutomation.can(BrowseTheWeb.with(webDriver));
            URL url = new URL(String.valueOf(URLBase.getValue()));
            CheckInternetConnection checkInternetConnection = new CheckInternetConnection(url);
            checkInternetConnection.checkConnection();
        } catch (InternetConnectionException | MalformedURLException e) {
            throw new InternetConnectionException(InternetConnectionException.INTERNET_FAILED);
        }

    }

}
