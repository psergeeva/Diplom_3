package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stellar.LoginPageObject.URL_LOGIN;

public class ExitTest {

    public final String EMAIL = "test_polina@test.com";
    public final String PASSWORD = "Test1234";

    @Before
    public void login() {
        LoginPageObject loginPageObject = open (URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();}

    @Test
    @DisplayName("Check log out")
    public void checkLogOut() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        profilePageObject.waitAfterTransition ();
        profilePageObject.clickLogOutButton ();
        profilePageObject.waitAfterTransition ();
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        MatcherAssert.assertThat(loginPageObject.isEntryButtonExists (), notNullValue());

    }
}
