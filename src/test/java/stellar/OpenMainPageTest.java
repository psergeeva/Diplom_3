package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class OpenMainPageTest {

    @Before
    public void login() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        mainPageObject.clickLoginButton ();
        LoginPageObject loginPageObject = open (LoginPageObject.URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (loginPageObject.EMAIL, loginPageObject.PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();
    }

    @Test
    @DisplayName("Check if main page is shown after constructor title is clicked")
    public void checkConstructorLink() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        profilePageObject.waitAfterTransition ();
        profilePageObject.clickConstructorButton ();
        assertEquals (url (), MainPageObject.URL);
    }

    @Test
    @DisplayName("Check if main page is shown after logo is clicked")
    public void checkLogoLink() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        mainPageObject.clickPersonalAccountButton ();
        ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        profilePageObject.waitAfterTransition ();
        profilePageObject.clickLogo ();
        assertEquals (url (), MainPageObject.URL);
    }
}
