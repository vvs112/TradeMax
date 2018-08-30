package pages;

import com.codeborne.selenide.SelenideElement;
import utils.FileWriterUtil;
import java.util.StringJoiner;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class CheckOutPage implements Page {

     public  String cityFieldValue;
     public  String deliveryFieldMessage;
     public  String dateValue;
     public  String fastestOptionMessage;
     private String itemToBuyDetails;

     private SelenideElement zipCodeField = $x("//input[@id='postcode']"),
                              emailField = $x("//input[@id='email']"),
                              cityField = $x("//input[@id='city']"),
                              deliveryOptionsField = $x("//*[@id='deliveryServicesForm']/div[2]/div[1]/div[1]/div[1]/div[2]"),
                              fastestDeliveryOption = $x("//input[@id='DeliveryVariantOption_1']"),
                              fastestDeliveryOptionDate = $x("//input[@id='DeliveryVariantOption_1']/following::span[1]"),
                              fastestDeliveryOptionMessage = $x("//input[@id='DeliveryVariantOption_1']/following::span[2]"),
                              itemToBuy = $x("//div[@class='productItemShort']/a/span");



      public CheckOutPage fillAddress(String zipNumber){
          emailField.scrollIntoView(false);
          zipCodeField.waitUntil(appear, waitTimeout()).setValue(zipNumber);
          cityField.waitUntil(appear, 5000).doubleClick();
          sleep(5000);
          cityFieldValue = cityField.getValue();
          return this;
      }

      public CheckOutPage checkDeliveryOptions(){
          deliveryOptionsField.waitUntil(appear, waitTimeout()).scrollIntoView(false);
          deliveryFieldMessage = deliveryOptionsField.getText();
          return this;
      }

      public CheckOutPage checkFastestDeliveryOption(){
          fastestDeliveryOption.waitUntil(appear, 6000).scrollIntoView(false);
          dateValue = fastestDeliveryOptionDate.getText();
          itemToBuyDetails = itemToBuy.getText();
          fastestOptionMessage = fastestDeliveryOptionMessage.getText();
          FileWriterUtil.writeFile(userItemToBuyDetails(itemToBuyDetails, dateValue, "User"));
          return this;
      }

      private String userItemToBuyDetails(String details, String date, String userName){
          StringJoiner sj = new StringJoiner("\n", "Hi, "+userName+"\n", "\n"+"Regards, TradeMax Customer Service");
          sj.add("Your purchase "+details);
          sj.add("Will be delivered "+date);
          return sj.toString();
      }


}
