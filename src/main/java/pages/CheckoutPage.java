package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.forms.Header;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {

    @Step("Get product count value in shopping cart on 'Checkout' page")
    public Integer getProductCount() {
        return Integer.valueOf($x("//div[contains(@class, 'summary')]//span[contains(@class, 'label')]").getText().replaceAll("[^-?0-9]+", ""));
    }

    @Step("Click 'Proceed To Checkout' button on 'Checkout' page")
    public void proceedToCheckout() {
        $x("//div[contains(@class, 'checkout')]//a").click();
    }

    @Step("Fill personal information with values: [{0}, {1}, {2}] on 'Checkout' page")
    public void fillPersonalInformation(String firstname, String lastname, String email) {
        $x("//input[contains(@id, 'gender')]").click();
        $(By.id("field-firstname")).setValue(firstname);
        $(By.id("field-lastname")).setValue(lastname);
        $(By.id("field-email")).setValue(email);
        $(By.name("psgdpr")).click();
        $(By.name("customer_privacy")).click();
        $x("//button[contains(@class, 'continue')]").click();
    }

    @Step("Fill address information with values: [{0}, {1}, {2}, {3}] on 'Checkout' page")
    public void fillAddressInformation(String address, String city, String postcode, String state) {
        $(By.id("field-address1")).setValue(address);
        $(By.id("field-city")).setValue(city);
        $(By.id("field-id_state")).selectOptionContainingText(state);
        $(By.id("field-postcode")).setValue(postcode);
        $(By.name("confirm-addresses")).click();
    }

    @Step("Confirm default delivery option on 'Checkout' page")
    public void confirmShippingMethod() {
        $(By.name("confirmDeliveryOption")).click();
    }

    @Step("Confirm payment method on 'Checkout' page")
    public void confirmPaymentMethod() {
        $x("//input[contains(@id, 'approve')]").click();
        SelenideElement placeOrderBtn = $x("//div[contains(@id, 'confirmation')]//button");
        placeOrderBtn.shouldBe(Condition.enabled);
        placeOrderBtn.click();
    }

    public Header getHeader() {
        return new Header();
    }
}
