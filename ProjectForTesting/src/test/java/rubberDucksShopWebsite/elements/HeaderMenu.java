package rubberDucksShopWebsite.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import static rubberDucksShopWebsite.helpers.Locators.getLocator;

public class HeaderMenu {
    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomePageButton() {
        driver.findElement(getLocator("HeaderMenu.homePageButton")).click();
    }

    public void clickRubberDucksPageButton() {
        driver.findElement(getLocator("HeaderMenu.rubberDucksPageButton")).click();
    }

    public void clickSubcategoryPageButton() {
        new Actions(driver).pause(Duration.ofMillis(1000))
                .moveToElement(driver.findElement(getLocator("HeaderMenu.rubberDucksPageButton")))
                .click(driver.findElement(getLocator("HeaderMenu.subcategoryPageButton"))).perform();
    }
}
