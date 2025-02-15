package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UtilityComponent;

public class LandingPage extends UtilityComponent {
    WebDriver driver;
    By userName =By.id("userEmail");
    By Password = By.id("userPassword");
    By Login = By.id("login");

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void navigateToWeb(String url)
    {
        driver.get(url);
    }

    public void login(String username, String password)
    {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(Login).click();
    }

}
