package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Base_PO;
import pageObject.LoginSauceDemo_PO;

public class LoginSauceDemo extends Base_PO {
    private LoginSauceDemo_PO loginSauceDemo_po;
    public LoginSauceDemo(LoginSauceDemo_PO loginSauceDemo_po){
        this.loginSauceDemo_po = loginSauceDemo_po;
    }

    @Given("User is on Sauce Demo Login page")
    public void user_is_on_sauce_demo_login_page() {
        loginSauceDemo_po.navigateToSauceDemoLoginPage();
    }

    @And("User types in {string} into Username input field")
    public void user_types_in_into_username_input_field(String username) {
        loginSauceDemo_po.enterUsername(username);
    }

    @And("User types in {string} into Password input field")
    public void user_types_in_into_password_input_field(String password) {
        loginSauceDemo_po.enterPassword(password);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginSauceDemo_po.clickLoginButton();
    }

    @Then("User will be redirected to Dashboard page")
    public void user_will_be_redirected_to_dashboard_page() {
        loginSauceDemo_po.userLandedOnDashboard();
    }

    @Then("User will be presented with login {string}")
    public void userWillBePresentedWithErrorLoginMessage(String errorMessage) {
        loginSauceDemo_po.lockedUserCheck(errorMessage);
    }

    @Given("User is on Dashboard page with {string}")
    public void userIsOnDashboardPage(String userType) {
        loginSauceDemo_po.loginToDashboardWithStandardUser(userType);
    }
}
