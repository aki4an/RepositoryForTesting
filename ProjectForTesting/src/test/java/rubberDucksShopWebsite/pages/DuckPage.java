package rubberDucksShopWebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import rubberDucksShopWebsite.helpers.PageBase;
import rubberDucksShopWebsite.elements.HeaderMenu;

import static rubberDucksShopWebsite.helpers.Locators.getLocator;

public class DuckPage extends PageBase {
    public HeaderMenu headerMenu;

    public DuckPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
    }

    public Boolean visibilityOfSizeOptions() {
        return driver.findElement(getLocator("DuckPage.optionsSize")).isDisplayed();
    }

    public Boolean saleStickerVisibility() {
        return driver.findElement(getLocator("DuckPage.stickerSale")).isDisplayed();
    }

    public void selectSmallSize() {
        new Select(driver.findElement(getLocator("DuckPage.optionsSize"))).selectByVisibleText("Small");
    }
}
