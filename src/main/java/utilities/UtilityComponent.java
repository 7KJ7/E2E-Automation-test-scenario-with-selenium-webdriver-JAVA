package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import utilities.Constantes;

public class UtilityComponent  {


    WebDriver driver;

    By CartButton = By.cssSelector("button[routerlink ='/dashboard/cart']");

    public UtilityComponent(WebDriver driver) {
        this.driver= driver;
    }

    public void waitElementToBeDisplayed( By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constantes.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToBeInvisible( By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constantes.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitElementToBeClickable( By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constantes.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitElementToBeVisisble( By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constantes.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnCartButton(){
        waitElementToBeClickable(CartButton);
        driver.findElement(CartButton).click();
    }
}
