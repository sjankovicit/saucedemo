package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.Cart_PO;

public class Cart extends Base_PO{
    private Cart_PO cart_po;

    public Cart(Cart_PO cart_po) {this.cart_po = cart_po;}

    @When("User clicks on Shopping cart icon")
    public void userClicksOnShoppingCartIcon(){
        cart_po.clickCartIcon();
    }

    @Then("User will be presented with Cart elements")
    public void userWillBePresentedWithCartElements() {
        cart_po.checkShoppingCartElements();
    }

    @And("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        cart_po.clickCheckoutButton();
    }

    @And("User populates Your Information input fields")
    public void userPopulatesYourInformationInputFields() {
        cart_po.populateYourInformationData();
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        cart_po.clickCartContinueButton();
    }

    @And("User clicks on Finish button")
    public void userClicksOnFinishButton() {
        cart_po.clickCartFinishButton();
    }

    @Then("User will be presented with text {string}")
    public void userWillBePresentedWithText(String textMessage) {
        cart_po.checkSuccessfulPurchaseMessage(textMessage);
    }
}
