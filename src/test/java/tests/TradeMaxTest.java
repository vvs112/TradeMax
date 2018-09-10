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


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TradeMaxTest {

    WebDriver driver;

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
    }

}
