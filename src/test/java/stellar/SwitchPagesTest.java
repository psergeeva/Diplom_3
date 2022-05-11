package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static stellar.MainPageObject.URL;
import static org.junit.Assert.assertEquals;


public class SwitchPagesTest {

    @Before
    public void login() {
        LoginPageObject loginPageObject = open (LoginPageObject.URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (loginPageObject.EMAIL, loginPageObject.PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();
    }

    @Test
    @DisplayName("Check if profile is shown after personal account button is clicked")
        public void checkLoginViaPersonalAccountButton(){
            MainPageObject mainPageObject = open (URL, MainPageObject.class);
            mainPageObject.clickPersonalAccountButton ();
            assertEquals(url(), LoginPageObject.URL_LOGIN);
    }


}