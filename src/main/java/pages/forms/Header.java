package pages.forms;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Header {
    private final SelenideElement header = Selenide.$(By.id("header"));

    @Step("Click 'My Store' logo on Header")
    public void openMainPage() {
        header.$x(".//img[contains(@class, 'logo')]").click();
    }

    @Step("Get product count value in shopping cart on Header")
    public int getCartProductCount() {
        return Integer.parseInt(header.$x(".//span[contains(@class, 'count')]").getText().replaceAll("[()']+", ""));
    }
}
