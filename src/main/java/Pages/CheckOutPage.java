package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.UtilityComponent;

import java.util.List;

public class CheckOutPage extends UtilityComponent {
    WebDriver driver;


    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


    By ShippingInfo =By.cssSelector(".payment");
    By CountriesList= By.cssSelector(".ta-item.list-group-item.ng-star-inserted");
    By PlaceOrder=By.cssSelector(".action__submit");
    By CountryInput =By.cssSelector("input[placeholder='Select Country']");



    public List<WebElement> getCountriesList()
    {
        waitElementToBeVisisble(CountriesList);
        return driver.findElements(CountriesList);
    }





    public  void SelectCountry(String Country){
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(CountryInput),"india").build().perform();
        waitElementToBeVisisble(CountriesList);
        for(int x=0;x<getCountriesList().size();x++)
        {
            if(getCountriesList().get(x).getText().equalsIgnoreCase(Country))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,900)");
                System.out.println(getCountriesList().get(x).getText());
                getCountriesList().get(x).click();
                break;
            }


        }




    }
    public  void SelectCountryName(String Country)
    {

        waitElementToBeVisisble(CountriesList);
        //SelectCountry(Country).click();

    }


    public void clickOnPlaceOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        driver.findElement(PlaceOrder).click();
    }
}

