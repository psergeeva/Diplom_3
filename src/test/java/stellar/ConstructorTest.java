package stellar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Name;
import org.junit.After;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies ();
        Selenide.clearBrowserLocalStorage ();}

    @Test
    @DisplayName("Check transition to buns")
    public void checkTransitionOfBunsButton() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        assertTrue (mainPageObject.clickBunsButtonCheckTheSign ());
    }

    @Test
    @DisplayName("Check transition to sauces")
    public void checkTransitionOfSaucesButton() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        assertTrue (mainPageObject.clickSaucesButtonAndCheckTheSign ());
    }

    @Test
    @DisplayName("Check transition oto fillings")
    public void checkTransitionOfFillingButton() {
        MainPageObject mainPageObject = open (MainPageObject.URL, MainPageObject.class);
        assertTrue (mainPageObject.clickFillingButtonAndCheckTheSign ());
    }

}
