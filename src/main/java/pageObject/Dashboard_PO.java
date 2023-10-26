package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Dashboard_PO extends Base_PO{

    @FindBy(css = "div[class='app_logo']")
    public WebElement logo;
    @FindBy(css ="[data-test='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartBackpackButton;

    @FindBy(css = "span[class='shopping_cart_badge']")
    public WebElement cartCounter;

    @FindBy(css = "[data-test='product_sort_container']")
    public WebElement dropDownFilter;

    @FindBy(css = "option[value='lohi']")
    public WebElement optionLowHigh;

    @FindBy(css = "option[value='hilo']")
    public WebElement optionHighLow;

    @FindBy(css = "div[class='inventory_item_price']")
    public WebElement priceDiv;

    @FindBy(css = "a[class='shopping_cart_link']")
    public WebElement cartIcon;

    @FindBy(css = "div[class='bm-burger-button']")
    public WebElement burgerMenu;

    @FindBy(xpath = "//*[contains(text(), 'All Items')]")
    public WebElement burgerMenuOptionsInventory;

    @FindBy(xpath = "//*[contains(text(), 'About')]")
    public WebElement burgerMenuOptionsAbout;

    @FindBy(xpath = "//*[contains(text(), 'Logout')]")
    public WebElement burgerMenuOptionsLogout;

    @FindBy(xpath = "//*[contains(text(), 'Reset App State')]")
    public WebElement burgerMenuOptionsReset;

    public void checkDashboardLogo(){
        textToBePresentInElement(logo, "Swag Labs");
    }

    public void addToCartBackpack(){
        waitForWebElementAndClick(addToCartBackpackButton);
    }

    public void checkCartCounter(){
        String cartCounterNumber = cartCounter.getText();
        Assert.assertEquals(cartCounterNumber, "1");
    }

    public void clickFilterDropdown(){
        waitForWebElementAndClick(dropDownFilter);
    }

    public void clickOptionLowHighPrice(){
        waitForWebElementAndClick(optionLowHigh);
    }

    public void clickOptionHighLowPrice(){
        waitForWebElementAndClick(optionHighLow);
    }

    public void checkFilteredListByPriceLowHigh(){
        Assert.assertEquals(priceDiv.getText(), "$7.99");
    }

    public void checkFilteredListByPriceHighLow(){
        Assert.assertEquals(priceDiv.getText(), "$49.99");
    }

    public void checkCartVisibility(){
        waitForVisibilityOf(cartIcon);
    }

    public void checkBurgerMenuVisibility(){
        waitForVisibilityOf(burgerMenu);
    }

    public void clickBurgerMenu(){
        waitForWebElementAndClick(burgerMenu);
    }

    public void checkBurgerMenuOptions(){
        waitForVisibilityOf(burgerMenuOptionsInventory);
        waitForVisibilityOf(burgerMenuOptionsAbout);
        waitForVisibilityOf(burgerMenuOptionsLogout);
        waitForVisibilityOf(burgerMenuOptionsReset);
    }
}
