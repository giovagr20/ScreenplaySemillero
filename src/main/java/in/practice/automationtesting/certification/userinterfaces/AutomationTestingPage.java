package in.practice.automationtesting.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AutomationTestingPage {

    public static final Target SPN_TITLE_PAGE = Target.the("TITLE TEXT")
            .located(By.id("site-logo"));
    //By spn = By.xpath("/*//");
    public static final Target SPN_TITLE_PAGE_WRONG = Target.the("TITLE TEXT WRONG")
            .located(By.id("site-logo-worng-ss-1"));
    public static final Target BTN_MY_ACCOUNT = Target.the("BUTTON MY ACCOUNT")
            .located(By.xpath("//a[contains(text(), 'My Account')]"));
    public static final Target LBL_REGISTER = Target.the("TEXT REGISTER IN FORM")
            .located(By.xpath("//h2[contains(text(), 'Register')]"));
    public static final Target INP_EMAIL = Target.the("ENTER A EMAIL")
            .located(By.id("reg_email"));
    public static final Target INP_PASSWORD = Target.the("ENTER A PASSWORD")
            .located(By.id("reg_password"));
    public static final Target BTN_REGISTER_USER = Target.the("BUTTON FOR REGISTER A NEW USER")
            .located(By.name("register"));
    public static final Target LBL_PASSWORD_WEAK = Target.the("TEXT WEAK PASSWORD FOR CHANGE")
            .located(By.xpath("//div[contains(text(), 'Weak - Please')]"));
    public static final Target LBL_WELCOME = Target.the("TEXT WELCOME FOR {0}")
            .located(By.xpath("//p[contains(text(),'Hello ' )]"));
    public static final Target INP_EMAIL_LOGIN = Target.the("LOGIN EMAIL")
            .located(By.id("username"));
    public static final Target INP_PASSWORD_LOGIN = Target.the("LOGIN PASSWORD")
            .located(By.id("password"));
    public static final Target BTN_LOGIN = Target.the("LOGIN PASSWORD")
            .located(By.name("login"));

}
