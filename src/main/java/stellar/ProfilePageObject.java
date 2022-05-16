package stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import static com.codeborne.selenide.Condition.enabled;

public class ProfilePageObject {

    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    @Step("Click constructor button")
    public void clickConstructorButton() {
        constructorButton.click ();
    }

    @Step("Click logo")
    public void clickLogo() {
        logo.click ();
    }

    @Step("Click log out button")
    public void clickLogOutButton() {
        logOutButton.click ();
    }

    @Step("If Lo out button exists")
    public boolean isLogOutButtonExists() {
        return logOutButton.shouldBe(enabled).exists();}

    @Step("Wait after transition to the profile page")
    public void waitAfterTransition () {
        logOutButton.shouldBe (Condition.visible, Duration.ofSeconds (5000));
    }
}
