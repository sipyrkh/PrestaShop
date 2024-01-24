import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MainPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.MainPage.Products.ON_SALE;
import static pages.MainPage.Products.POPULAR;

public class ShoppingCartTest extends BaseTest{

    @Test
    @Epic("Shopping Cart")
    @Description("The user can add more than one item to the shopping cart")
    public void addMultipleItemsToShoppingCartTest() {
        MainPage mainPage = new MainPage();
        mainPage.openRandomProduct(POPULAR);

        ProductPage productPage = new ProductPage();
        productPage.addToCart();
        assertThat(productPage.getCartModal().getModalTitleText()).containsIgnoringCase("Product successfully added to your shopping cart");
        productPage.getCartModal().continueShopping();
        assertThat(productPage.getHeader().getCartProductCount()).isEqualTo(1);
        productPage.getHeader().openMainPage();

        mainPage.openRandomProduct(ON_SALE);
        productPage.addToCart();
        assertThat(productPage.getCartModal().getModalTitleText()).containsIgnoringCase("Product successfully added to your shopping cart");
        productPage.getCartModal().proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();
        assertThat(checkoutPage.getHeader().getCartProductCount()).isEqualTo(2);
        assertThat(checkoutPage.getProductCount()).isEqualTo(2);
    }

    @Test
    @Epic("Shopping Cart")
    @Description("The user can place an order from the shopping cart")
    public void placeOrderFromShoppingCart() {
        MainPage mainPage = new MainPage();
        mainPage.openRandomProduct(POPULAR);

        ProductPage productPage = new ProductPage();
        productPage.addToCart();
        productPage.getCartModal().proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.proceedToCheckout();
        checkoutPage.fillPersonalInformation("Adam", "Thomas", "adam.thomas@gmail.com");
        checkoutPage.fillAddressInformation("Schorsa street 54", "Kobuk", "99611", "Alaska");
        checkoutPage.confirmShippingMethod();
        checkoutPage.confirmPaymentMethod();
    }
}
