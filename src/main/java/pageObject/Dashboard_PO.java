package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public List<WebElement> priceDivList;

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

    public void filterLogicCheckingMinMax(){
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        for (int j = 0; j < getPricesFromWebAppList().size(); j++){
            float priceNumbers = Float.parseFloat(getPricesFromWebAppList().get(j).toString());
            if (priceNumbers > max) {
                max = priceNumbers;
            }
            if (priceNumbers < min) {
                min = priceNumbers;
            }
        }
        System.out.println("The maximum Price is: " + max);
        System.out.println("The minimum Price is: " + min);
        Object lastPriceElementPosition = getPricesFromWebAppList().size();
        int number = Integer.parseInt(lastPriceElementPosition.toString());
        int neededNumberForList = number - 1;
        float firstElement = Float.parseFloat(getPricesFromWebAppList().get(0).toString());
        float lastElement = Float.parseFloat(getPricesFromWebAppList().get(neededNumberForList).toString());

        Assert.assertTrue(
                (firstElement == min && lastElement == max) || (firstElement == max && lastElement == min),
                "FILTER LOGIC IS FAILING"
        );
        //PROBATI SA UPOREDJIVANJEM NIZOVA (OVAJ NACIN NIJE DOBAR, SAMO VEZBANJE!)
    }

    public void checkSortArrayAscending(){
        List<Float> originalList = getPricesFromWebAppList();
        List<Float> sortedListAscending = new ArrayList<>(originalList);

        Collections.sort(sortedListAscending);

        System.out.println("ORIGINAL LIST IS: " + originalList);
        System.out.println("SORTED LIST BY ASCENDING IS: " + sortedListAscending);

        Assert.assertEquals(originalList, sortedListAscending);
    }

    public void checkSortArrayDescending(){
        List<Float> originalList = getPricesFromWebAppList();

        List<Float> sortedListDescending = new ArrayList<>(originalList);

        Collections.sort(sortedListDescending, Collections.reverseOrder());

        System.out.println("ORIGINAL LIST IS: " + originalList);
        System.out.println("SORTED LIST BY DESCENDING IS: " + sortedListDescending);

        Assert.assertEquals(originalList, sortedListDescending);
    }

    public List getPricesFromWebAppList() {
        List<Float> priceTextList = new ArrayList<>();
        for (WebElement priceElement : priceDivList) {
            String priceText = priceElement.getText().replace("$", "");
            Float priceTextToFloat = Float.parseFloat(priceText);
            priceTextList.add(priceTextToFloat);
        }
        return priceTextList;
    }
}
