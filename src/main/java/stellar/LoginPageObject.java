package stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.enabled;

public class LoginPageObject {

    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

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

    @Step("Wait after login")
    public void waitAfterEntry() {
        entryButton.shouldBe (Condition.hidden);
    }

    @Step("If entry button exists")
    public boolean isEntryButtonExists() {
        return entryButton.shouldBe(enabled).exists();
    }

}
