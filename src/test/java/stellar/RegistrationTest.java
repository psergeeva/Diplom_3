package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();}

    @Test
    @DisplayName("Check registration with valid data")
    public void checkCorrectRegistration() {
        RegistrationPageObject registrationPageObject = open (RegistrationPageObject.URL, RegistrationPageObject.class);

        registrationPageObject.registerUser (registrationPageObject.NAME, registrationPageObject.EMAIL, registrationPageObject.PASSWORD);
        registrationPageObject.waitAfterRegistration ();
        assertTrue (registrationPageObject.isOpenLoginPage ());
    }

    @Test
    @DisplayName("Check registration with invalid password")
    public void checkRegistrationWithFiveSymbolsInPassword() {
        RegistrationPageObject registrationPageObject = open (RegistrationPageObject.URL, RegistrationPageObject.class);

        registrationPageObject.registerUser (registrationPageObject.NAME, registrationPageObject.EMAIL, registrationPageObject.INVALID_PASSWORD);
        assertTrue (registrationPageObject.isPasswordErrorShown ());
    }
}
