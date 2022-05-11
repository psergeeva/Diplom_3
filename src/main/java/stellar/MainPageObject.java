package stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPageObject {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalProfileButton;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement createBurgerTitle;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsSign;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesSign;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsSign;

    @FindBy(how = How.XPATH, using = "//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement lastIngredient;

    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__list__l9dp_")
    private SelenideElement orderBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Флюоресцентная булка R2-D3 (верх)']")
    private SelenideElement bunInBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Соус Spicy-X']")
    private SelenideElement sauceForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соус Spicy-X']")
    private SelenideElement sauceInBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingInBasket;

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click ();
    }

    @Step("Click account entry button")
    public void clickPersonalAccountButton() {
        personalProfileButton.click ();
    }

    @Step("Click the fillings button and check the sign")
    public boolean clickFillingButtonAndCheckTheSign() {
        fillingsButton.click ();
        fillingForDrop.dragAndDropTo (orderBasket);
        return fillingInBasket.isDisplayed ();
    }

    @Step("Click the sauces button and check the sign")
    public boolean clickSaucesButtonAndCheckTheSign() {
        lastIngredient.scrollIntoView (true);
        saucesButton.click ();
        sauceForDrop.dragAndDropTo (orderBasket);
        return sauceInBasket.isDisplayed ();
    }

    @Step("Click the buns button and check the sign")
    public boolean clickBunsButtonCheckTheSign() {
        lastIngredient.scrollIntoView (true);
        bunsButton.click ();
        bunForDrop.dragAndDropTo (orderBasket);
        return bunInBasket.isDisplayed ();
    }

    @Step("Wait after transition to the main page")
    public void waitAfterTransitionToMainPage() {
        createBurgerTitle.shouldBe (Condition.visible, Duration.ofSeconds (5000));
    }
}
