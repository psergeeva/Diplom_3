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

public class OpenMainPageTest {

    public final String EMAIL = "test_polina@test.com";
    public final String PASSWORD = "Test1234";

    @Before
    public void login() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        mainPageObject.clickLoginButton ();
        LoginPageObject loginPageObject = open (LoginPageObject.URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();
    }

    @Test
    @DisplayName("Check if main page is shown after constructor title is clicked")
    public void checkConstructorLink() {
        MainPageObject mainPageObject = page (MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        profilePageObject.waitAfterTransition ();
        profilePageObject.clickConstructorButton ();
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }

    @Test
    @DisplayName("Check if main page is shown after logo is clicked")
    public void checkLogoLink() {
        MainPageObject mainPageObject = page (MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        profilePageObject.waitAfterTransition ();
        profilePageObject.clickLogo ();
        MatcherAssert.assertThat (mainPageObject.checkCreateOrderButton(), notNullValue());
    }
}
