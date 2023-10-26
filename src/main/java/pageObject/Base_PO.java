package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import driver.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public void navigateToUrl(String url){
        getDriver().get(url);
    }

    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void textToBePresentInElement(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWait(int timeMilliseconds){
        try
        {
            Thread.sleep(timeMilliseconds);
        }
        catch(InterruptedException e)
        {
            System.out.println("ENTERED CATCH: " + e);
        }
    }
}
