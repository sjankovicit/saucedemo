package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Cart_PO extends Base_PO{
    @FindBy(css ="[data-test='checkout']")
    public WebElement checkoutButton;

    @FindBy(css ="[data-test='continue-shopping']")
    public WebElement continueShoppingButton;

    @FindBy(css = "a[class='shopping_cart_link']")
    public WebElement cartIcon;

    @FindBy(css = "div[class='header_secondary_container']")
    public WebElement cartContainer;

    @FindBy(css ="[data-test='firstName']")
    public WebElement cartFirstName;

    @FindBy(css ="[data-test='lastName']")
    public WebElement cartLastName;

    @FindBy(css ="[data-test='postalCode']")
    public WebElement cartPostalCode;

    @FindBy(css ="[data-test='continue']")
    public WebElement cartContinue;

    @FindBy(css ="[data-test='finish']")
    public WebElement cartFinish;

    @FindBy(css = "h2[class='complete-header']")
    public WebElement purchaseMessage;


    public void clickCartIcon(){
        waitForWebElementAndClick(cartIcon);
    }
    public void checkShoppingCartElements(){
        waitForVisibilityOf(continueShoppingButton);
        waitForVisibilityOf(checkoutButton);
        waitForVisibilityOf(cartContainer);
    }

    public void clickCheckoutButton(){
        waitForWebElementAndClick(checkoutButton);
    }

    public void populateYourInformationData(){
        sendKeys(cartFirstName, "Srdjan");
        sendKeys(cartLastName, "Jankovic");
        sendKeys(cartPostalCode, "12345");
    }

    public void clickCartContinueButton(){
        waitForWebElementAndClick(cartContinue);
    }

    public void clickCartFinishButton(){
        waitForWebElementAndClick(cartFinish);
    }

    public void checkSuccessfulPurchaseMessage(String textMessage){
        String getMessageFromApp = purchaseMessage.getText();
        Assert.assertEquals(textMessage, getMessageFromApp);
    }
}
