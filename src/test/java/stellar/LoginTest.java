package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.CoreMatchers.notNullValue;
import static stellar.MainPageObject.URL;

public class LoginTest {

    public final String EMAIL = "test_polina@test.com";
    public final String PASSWORD = "Test1234";

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();
    }

    @Test
    @DisplayName("Check login via entry button on main page")
    public void checkLoginFromMainPageViaEntryButton() {
        MainPageObject mainPageObject = open (URL, MainPageObject.class);
        mainPageObject.clickLoginButton ();
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
        loginPageObject.waitAfterEntry ();
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }

    @Test
    @DisplayName("Check login via personal account button")
    public void checkLoginViaPersonalAccountButton() {
        MainPageObject mainPageObject = open (URL, MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
        loginPageObject.waitAfterEntry ();
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }

    @Test
    @DisplayName("Check login via registration form")
    public void checkLoginViaRegistrationForm() {
        RegistrationPageObject registrationPageObject = open (RegistrationPageObject.URL, RegistrationPageObject.class);
        registrationPageObject.clickEntryButton ();
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
        loginPageObject.waitAfterEntry ();
        MainPageObject mainPageObject = page (MainPageObject.class);
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }

    @Test
    @DisplayName("Check login via forgot password button")
    public void checkLoginViaForgotPasswordButton() {
        ForgotPageObject forgotPageObject = open (ForgotPageObject.FORGOT_PASSWORD_URL, ForgotPageObject.class);
        forgotPageObject.clickEntryButton ();
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
        loginPageObject.waitAfterEntry ();
        MainPageObject mainPageObject = page (MainPageObject.class);
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }
}
