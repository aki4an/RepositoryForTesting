package rubberDucksShopWebsite.helpers;

import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;

    public String getTitle() {
        return driver.getTitle();
    }
}
