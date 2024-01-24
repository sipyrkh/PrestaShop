package pages;

import io.qameta.allure.Step;
import pages.forms.Header;
import pages.forms.ShoppingCartModal;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    @Step("Click 'Add To Cart' button on 'Product' page")
    public void addToCart() {
        $x("//button[contains(@class, 'add')]").click();
    }

    public ShoppingCartModal getCartModal() {
        return new ShoppingCartModal();
    }

    public Header getHeader() {
        return new Header();
    }
}
