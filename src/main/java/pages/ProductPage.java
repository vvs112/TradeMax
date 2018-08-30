package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage implements Page {

    private SelenideElement addToCart = $x("//div[@class='productItem--addToCart']/button"),
                            confirmationPopUp = $x("//div[@id='confirmationPopup']//a"),
                            addressLink = $x("//div[@id='checkout']//form[@id='sveaSsnFormPrivate']/a");


    public ProductPage addItemToCart(){
        addToCart.waitUntil(appear, waitTimeout()).click();
        confirmationPopUp.waitUntil(appear, waitTimeout()).click();
        return this;
    }

    public CheckOutPage goToCheckOut(){
        addressLink.scrollIntoView(false);
        addressLink.waitUntil(appear, waitTimeout()).click();
        return new CheckOutPage();
    }
}
