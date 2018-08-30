package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;


public class HomePage implements Page {


    private SelenideElement searchField = $x("//div[@id='search']/descendant::input"),
                            cookieButton = $x("//div[@id='cookiesPolicy']/descendant::button"),
                            productTitle = $x("//h3/a");


    public ProductPage searchForItem(String itemID){
        open(url());
        if(cookieButton.isDisplayed()) cookieButton.shouldBe(visible).click();
        searchField.waitUntil(appear, waitTimeout()).click();
        searchField.setValue(itemID).pressEnter();
        productTitle.waitUntil(appear, waitTimeout()).click();
        return new ProductPage();
    }


}
