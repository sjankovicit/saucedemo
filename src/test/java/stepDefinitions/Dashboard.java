package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.Dashboard_PO;

public class Dashboard extends Base_PO {
    private Dashboard_PO dashboard_po;

    public Dashboard(Dashboard_PO dashboard_po){
        this.dashboard_po = dashboard_po;
    }

    @When("User clicks on Sauce Lab Backpack Add to cart button")
    public void userClicksOnSauceLabBackpackAddToCartButton() {
        dashboard_po.addToCartBackpack();
    }

    @Then("User will be able to see counter on cart icon")
    public void userWillBeAbleToSeeCounterOnCartIcon() {
        dashboard_po.checkCartCounter();
    }

    @When("User clicks on filter dropdown")
    public void userClicksOnFilterDropdown() {
        dashboard_po.clickFilterDropdown();
    }

    @And("User clicks on option Price low to high")
    public void userClicksOnOptionPriceLowToHigh() {
        dashboard_po.clickOptionLowHighPrice();
    }

    @Then("User will be able to see filtered Products by Price low to high")
    public void userWillBeAbleToSeeFilteredProducts() {
        dashboard_po.checkFilteredListByPriceLowHigh();
    }

    @And("User clicks on option Price high to low")
    public void userClicksOnOptionPriceHighToLow() {
        dashboard_po.clickOptionHighLowPrice();
    }

    @Then("User will be able to see filtered Products by Price high to low")
    public void userWillBeAbleToSeeFilteredProductsByPriceHighToLow() {
        dashboard_po.checkFilteredListByPriceHighLow();
    }

    @Then("User will be able to see application Logo")
    public void userWillBeAbleToSeeApplicationLogo() {
        dashboard_po.checkDashboardLogo();
    }

    @And("User will be able to see Cart icon")
    public void userWillBeAbleToSeeCartIcon() {
        dashboard_po.checkCartVisibility();
    }

    @And("User will be able to see Burger menu")
    public void userWillBeAbleToSeeBurgerMenu() {
        dashboard_po.checkBurgerMenuVisibility();
    }

    @When("User clicks on Burger menu")
    public void userClicksOnBurgerMenu() {
        dashboard_po.clickBurgerMenu();
    }

    @Then("User will be presented with Burger menu options")
    public void userWillBePresentedWithBurgerMenuOptions() {
        dashboard_po.checkBurgerMenuOptions();
    }

    @Then("Check if Ascending logic if functional")
    public void filterLogicAscending() {
        dashboard_po.filterLogicCheckingMinMax();
    }

    @Then("Check if Descending logic if functional")
    public void checkIfDescendingLogicIfFunctional() {
        dashboard_po.filterLogicCheckingMinMax();
    }

    @Then("Check Filter Logic by Ascending")
    public void checkFilterLogicByAscending() {
        dashboard_po.checkSortArrayAscending();
    }

    @Then("Check Filter Logic by Descending")
    public void checkFilterLogicByDescending() {
        dashboard_po.checkSortArrayDescending();
    }
}
