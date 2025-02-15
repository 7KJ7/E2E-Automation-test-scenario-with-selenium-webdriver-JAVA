package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UtilityComponent;

public class OrderConfirmationPage extends UtilityComponent {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    By MessageDisplay = By.cssSelector(".hero-primary");

    public String returnMessageDisplay()
    {
        waitElementToBeVisisble(MessageDisplay);
        String result=driver.findElement(MessageDisplay).getText();
        return result;
    }
    public Boolean checkMessageDisplayed(String message)
    {
        return returnMessageDisplay().equalsIgnoreCase(message);
    }


}
