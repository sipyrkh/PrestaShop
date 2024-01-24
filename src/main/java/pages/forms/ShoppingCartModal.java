package pages.forms;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class ShoppingCartModal {
    private final SelenideElement modalCart = Selenide.$x("//div[contains(@id, 'blockcart')]");

    @Step("Click 'Continue Shopping' button on 'Shopping Cart' modal")
    public void continueShopping() {
        SelenideElement continueBtn = modalCart.$x(".//button[contains(@class, 'btn')]");
        continueBtn.shouldBe(visible);
        continueBtn.click();
    }

    @Step("Click 'Proceed To Checkout' button on 'Shopping Cart' modal")
    public void proceedToCheckout() {
        SelenideElement continueBtn = modalCart.$x(".//a[contains(@class, 'btn')]");
        continueBtn.shouldBe(visible);
        continueBtn.click();
    }

    @Step("Get title text on 'Shopping Cart' modal")
    public String getModalTitleText() {
        SelenideElement titleElement = modalCart.$(By.id("myModalLabel"));
        titleElement.shouldBe(visible);
        return titleElement.getText();
    }
}
