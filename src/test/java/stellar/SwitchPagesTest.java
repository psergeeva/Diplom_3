package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.notNullValue;
import static stellar.MainPageObject.URL;
import static org.junit.Assert.assertEquals;


public class SwitchPagesTest {

    public final String EMAIL = "test_polina@test.com";
    public final String PASSWORD = "Test1234";

    @Before
    public void login() {
        LoginPageObject loginPageObject = open (LoginPageObject.URL_LOGIN, LoginPageObject.class);
        loginPageObject.login (EMAIL, PASSWORD);
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
            ProfilePageObject profilePageObject = page (ProfilePageObject.class);
        MatcherAssert.assertThat (profilePageObject.isLogOutButtonExists (), notNullValue());
    }


}