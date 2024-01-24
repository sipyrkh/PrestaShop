package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {

    public MainPage() {
        switchToFrameLive();
    }

    @Step("Open random product from '{0}' category")
    public void openRandomProduct(Products product) {
        ElementsCollection popularProductsElements = $$x("//section[contains(@class, 'products') and not(contains(@class, 'mt'))]//article[contains(@class, 'product')]");
        ElementsCollection onSaleProductsElements = $$x("//section[contains(@class, 'products') and contains(@class, 'mt')]//article[contains(@class, 'product')]");
        ElementsCollection elements = Products.POPULAR.equals(product) ? popularProductsElements : onSaleProductsElements;
        elements.get(new Random().nextInt(elements.size())).click();
    }

    @Step("Switch to frame on 'Main' page")
    private void switchToFrameLive() {
        switchTo().frame("framelive");
    }

    public enum Products {
        POPULAR, ON_SALE
    }
}
