package Pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.UtilityComponent;

import java.util.List;

public class CataloguePage extends UtilityComponent {
    WebDriver driver;
    public CataloguePage (WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    By Products =By.cssSelector(".mb-3");
    By ProductNames = By.xpath("//b[text()='ADIDAS ORIGINAL']");
    By addToCartButton =By.cssSelector(".btn.w-10.rounded");
    By ToastMessage = By.id("toast-container");
    By SpinerLoader = By.cssSelector("div.ngx-spinner-overlay");



    public List<WebElement> getProductList(){
        waitElementToBeDisplayed(Products);
        return driver.findElements(Products);
    }

    public WebElement getProductName(String ProductName){

        for(int i=0; i<getProductList().size() ;i++)
        {
            String ProductNames = getProductList().get(i).getText();
            if(ProductNames.contains(ProductName)){
                return getProductList().get(i);
            }
        }
        /*
        waitElementToBeDisplayed(ProductNames);
        WebElement productsNeeded= getProductList().stream()
                .filter(x ->x.findElement(ProductNames).getText().contains(ProductName))
                .findFirst().orElse(null);
        System.out.println(productsNeeded.getText());
        return productsNeeded;

         */
        return null;

    }
    public void addToCart(String ProductName)
    {
        getProductName(ProductName).findElement(addToCartButton).click();
        waitElementToBeDisplayed(ToastMessage);
        waitElementToBeInvisible(SpinerLoader);



    }



}
