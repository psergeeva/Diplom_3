package stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverRunner.url;

public class RegistrationPageObject {

    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//input[@type = 'text' and @name = 'name']")
    private SelenideElement nameFieldForRegistration;

    @FindBy(how = How.XPATH, using = "//label[text() ='Email']//following::input[1]")
    private SelenideElement emailFieldForRegistration;

    @FindBy(how = How.XPATH, using = "//input[@class='text input__textfield text_type_main-default' and @type='password']")
    private SelenideElement passwordFieldForRegistration;

    @FindBy(how = How.XPATH, using = "//button[starts-with(@class, 'button_button') and text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement passwordErrorText;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement entryButton;

    public final String NAME = RandomStringUtils.randomAlphabetic (10);
    public final String EMAIL = RandomStringUtils.randomAlphabetic (10) + "@test.com";
    public final String PASSWORD = "123456";
    public final String INVALID_PASSWORD = "12345";

    @Step("Set name")
    public void setName(String name) {
        nameFieldForRegistration.setValue (name);
    }

    @Step("Set email")
    public void setEmail(String email) {
        emailFieldForRegistration.setValue (email);
    }

    @Step("Set password")
    public void setPassword(String password) {
        passwordFieldForRegistration.setValue (password);
    }

    @Step("Click registry button")
    public void clickRegistrationButton() {
        registrationButton.click ();
    }

    @Step("Register new user")
    public void registerUser(String name, String email, String password) {
        setName (name);
        setEmail (email);
        setPassword (password);
        clickRegistrationButton ();

    }

    @Step("Wait after registration")
    public void waitAfterRegistration() {
        registrationButton.shouldBe (Condition.hidden);
    }

    @Step("Check if login page is shown")
    public boolean isOpenLoginPage() {
        return url ().equals ("https://stellarburgers.nomoreparties.site/login");
    }

    @Step("Check if password error is shown")
    public boolean isPasswordErrorShown() {
        return passwordErrorText.isDisplayed ();
    }

    @Step("Click entry button")
    public void clickEntryButton() {
        entryButton.click ();
    }

}
