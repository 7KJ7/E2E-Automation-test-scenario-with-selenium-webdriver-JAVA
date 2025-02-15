package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.UtilityComponent;

import java.util.List;

public class CartPage extends UtilityComponent {
    WebDriver driver;

    By CartProduct =By.cssSelector(".cartSection h3");
    By CheckoutButton =By.cssSelector(".totalRow button");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;

    }
    public List<WebElement> getListProduct()
        {
         waitElementToBeVisisble(CartProduct);
         return driver.findElements(CartProduct );

        }
    public Boolean checkProductInserted(String Product)
    {
        waitElementToBeDisplayed(CartProduct);
        for (int i =0;i<getListProduct().size();i++)

        {

            if(getListProduct().get(i).getText().contains(Product))
            {

                return true;

            }
        }

        return false;


    }
    public void ClickOnCheckout()
    {
        driver.findElement(CheckoutButton).click();
    }


}
