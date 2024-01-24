import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        open("https://demo.prestashop.com/");
        WebDriverRunner.getWebDriver().manage().window().fullscreen();
        $(By.id("loadingMessage")).shouldHave(attribute("style", "display: none;"), Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
