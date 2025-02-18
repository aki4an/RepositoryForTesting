package rubberDucksShopWebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rubberDucksShopWebsite.helpers.PageBase;
import rubberDucksShopWebsite.elements.HeaderMenu;

import java.time.Duration;

import static rubberDucksShopWebsite.helpers.Locators.getLocator;

public class CartPage extends PageBase {
    public HeaderMenu headerMenu;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
    }

    public void addDuckToCart() {
        driver.findElement(getLocator("CartPage.addToCartButton")).click();
    }

    public void goToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBe(getLocator("CartPage.quantityForAddToCart"), "1"));
        driver.findElement(getLocator("CartPage.cartButton")).click();
    }

    public String getSumValue() {
        return driver.findElement(getLocator("CartPage.sumValueInCart")).getText();
    }

    public void changeQuantity(Integer quantity) {
        driver.findElement(getLocator("CartPage.quantityInCart")).clear();
        driver.findElement(getLocator("CartPage.quantityInCart")).sendKeys(quantity.toString());
        driver.findElement(getLocator("CartPage.updateCartButton")).click();
    }

    public void waitUpdateForOrderQuantity() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBe(getLocator("CartPage.quantityInOrder"), "2"));
    }

    public String getMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(getLocator("CartPage.areaForMessage")));
        return driver.findElement(getLocator("CartPage.message")).getText();
    }

    public void clearCart() {
        driver.findElement(getLocator("CartPage.removeButton")).click();
    }

    public String getInfo() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(getLocator("CartPage.areaForInfo")));
        return driver.findElement(getLocator("CartPage.info")).getText();
    }
}
