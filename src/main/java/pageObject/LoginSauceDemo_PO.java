package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class LoginSauceDemo_PO extends Base_PO{
    @FindBy(css ="[data-test='username']")
    public WebElement usernameInput;

    @FindBy(css ="[data-test='password']")
    public WebElement passwordInput;

    @FindBy(css ="[data-test='login-button']")
    public WebElement loginButton;

    @FindBy(css ="[data-test='error']")
    public WebElement errorMessageText;

    public void navigateToSauceDemoLoginPage(){
        navigateToUrl(Global_Vars.SAUCE_DEMO_URL);
    }

    public void enterUsername(String username){
        sendKeys(usernameInput, username);
    }

    public void enterPassword(String password){
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton(){
        waitForWebElementAndClick(loginButton);
    }

    public void userLandedOnDashboard(){
        String dashboardUrl = Global_Vars.SAUCE_DEMO_URL + "inventory.html";

        if(getDriver().getCurrentUrl().equals(dashboardUrl)){
            System.out.println("Login Test has passed!");
        }
        else{
            System.out.println("It appears that the user was not able to login properly");
            Assert.assertEquals(getDriver().getCurrentUrl(), dashboardUrl);
        }
    }

    public void lockedUserCheck(String errorMessage){
        Assert.assertEquals(errorMessageText.getText(), errorMessage);
    }

    public void loginToDashboardWithStandardUser(String userType){
        navigateToUrl(Global_Vars.SAUCE_DEMO_URL);
        sendKeys(usernameInput, userType);
        sendKeys(passwordInput, "secret_sauce");
        waitForWebElementAndClick(loginButton);
    }
}
