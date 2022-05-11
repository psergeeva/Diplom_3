package stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPageObject {

    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    public final String EMAIL = "test_polina@test.com";
    public final String PASSWORD = "Test1234";

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement entryButton;

    @Step("Set email")
    public void setEmail(String email) {
        emailField.setValue (email);
    }

    @Step("Set password")
    public void setPassword(String password) {
        passwordField.setValue (password);
    }

    @Step("Click entry button")
    public void clickEntryButton() {
        entryButton.click ();
    }

    @Step("Login")
    public void login(String email, String password) {
        setEmail (email);
        setPassword (password);
        clickEntryButton ();
    }

    public boolean loginPageIsShown() {
        return url ().equals ("https://stellarburgers.nomoreparties.site/login");
    }

    @Step("Wait after login")
    public void waitAfterEntry() {
        entryButton.shouldBe (Condition.hidden);
    }


}
