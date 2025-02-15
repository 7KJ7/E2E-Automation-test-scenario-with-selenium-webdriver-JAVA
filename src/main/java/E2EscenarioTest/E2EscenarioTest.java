package E2EscenarioTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import utilities.Constantes;

public class E2EscenarioTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //initialize the LandingPage object
        LandingPage LandingPage = new LandingPage(driver);
        LandingPage.navigateToWeb(Constantes.url);
        LandingPage.login(Constantes.LoginUsr,Constantes.UserPassword);
        //select the product in Catalogue page
        CataloguePage CataloguePage = new CataloguePage(driver);
        CataloguePage.getProductList();
        CataloguePage.addToCart(Constantes.ProductName);
        CataloguePage.clickOnCartButton();
        //Go to payment process
        CartPage CartPage =new CartPage(driver);
        Boolean match=CartPage.checkProductInserted(Constantes.ProductName);
        //with assert if it is true the test will continue if it is fail the test will fails
        Assert.assertTrue(match);
        CartPage.ClickOnCheckout();
        CheckOutPage CheckOutPage =new CheckOutPage(driver);
        CheckOutPage.SelectCountry(Constantes.CountryName);
        CheckOutPage.clickOnPlaceOrder();
        //Checking the confirmation Message
        OrderConfirmationPage OrderConfirmationPage=new OrderConfirmationPage(driver);
        Assert.assertTrue(OrderConfirmationPage.checkMessageDisplayed(Constantes.Message));

    }

}
