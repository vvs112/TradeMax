package tests;


import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ReportGeneratorListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//@Listeners({ReportGeneratorListener.class})
public class TradeMaxTest {

//    private HomePage homePage;
//    private ProductPage productPage;
//    private CheckOutPage checkOutPage;
//    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().fullscreen();
//        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void searchForItemAndAddToCart(){
        Selenide.open("http://google.com");
        Selenide.$(By.name("q")).val("selenide").pressEnter();
        Selenide.$$("#ires li.g").shouldHave(CollectionCondition.size(0));
        Selenide.$("#ires").find(By.linkText("selenide.org")).shouldBe(Condition.visible);
    }

//    @Test(dependsOnMethods = "searchForItemAndAddToCart")
//    public void proceedToCheckOutPage(){
//        checkOutPage = productPage.goToCheckOut();
//    }
//
//    @Test(dependsOnMethods = "proceedToCheckOutPage")
//    public void fillAndValidateZipCode(){
//        checkOutPage.fillAddress("41110");
//        assertEquals(checkOutPage.cityFieldValue, "Göteborg");
//    }
//
//    @Test(dependsOnMethods = "fillAndValidateZipCode")
//    public void validateIfCheckBoxSelected(){
//        checkOutPage.checkDeliveryOptions();
//        assertTrue(checkOutPage.deliveryFieldMessage.contains("Vänligen välj önskad leveransdag nedan!"));
//    }
//
//    @Test(dependsOnMethods = "validateIfCheckBoxSelected")
//    public void checkForFastestDeliveryDate(){
//        checkOutPage.checkFastestDeliveryOption();
//        assertTrue(!checkOutPage.dateValue.isEmpty());
//        assertEquals(checkOutPage.fastestOptionMessage,"Snabbast möjliga leverans");
//    }
}
