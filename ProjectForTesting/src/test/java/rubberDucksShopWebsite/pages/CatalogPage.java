package rubberDucksShopWebsite.pages;

import org.openqa.selenium.WebDriver;
import rubberDucksShopWebsite.helpers.PageBase;
import rubberDucksShopWebsite.elements.HeaderMenu;

import static rubberDucksShopWebsite.helpers.Locators.getLocator;

public class CatalogPage extends PageBase {
    public HeaderMenu headerMenu;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
    }

    public void selectYellowDuck() {
        driver.findElement(getLocator("CatalogPage.yellowDuck")).click();
    }
}
