package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ExitTest {

    @Before
    public void login() {
        MainPageObject mainPageObject = open (MainPageObject.URL,MainPageObject.class);
        mainPageObject.clickLoginButton ();
        LoginPageObject loginPageObject = open (LoginPageObject.URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (loginPageObject.EMAIL, loginPageObject.PASSWORD);
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
        LoginPageObject loginPageObject = page (LoginPageObject.class);
        loginPageObject.loginPageIsShown ();

    }
}
