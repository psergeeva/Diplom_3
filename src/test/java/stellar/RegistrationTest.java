package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    public final String NAME = RandomStringUtils.randomAlphabetic (10);
    public final String EMAIL = RandomStringUtils.randomAlphabetic (10) + "@test.com";
    public final String PASSWORD = "123456";
    public final String INVALID_PASSWORD = "12345";

    @Before
    public void setUp(){
        RegistrationPageObject registrationPageObject = open (RegistrationPageObject.URL, RegistrationPageObject.class);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();}

    @Test
    @DisplayName("Check registration with valid data")
    public void checkCorrectRegistration() {
        RegistrationPageObject registrationPageObject = page (RegistrationPageObject.class);
        registrationPageObject.registerUser (NAME, EMAIL, PASSWORD);
        registrationPageObject.waitAfterRegistration ();
        assertTrue (registrationPageObject.isOpenLoginPage ());
    }

    @Test
    @DisplayName("Check registration with invalid password")
    public void checkRegistrationWithFiveSymbolsInPassword() {
        RegistrationPageObject registrationPageObject = page (RegistrationPageObject.class);
        registrationPageObject.registerUser (NAME, EMAIL, INVALID_PASSWORD);
        assertTrue (registrationPageObject.isPasswordErrorShown ());
    }
}
