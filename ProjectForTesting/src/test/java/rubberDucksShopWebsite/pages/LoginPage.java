package rubberDucksShopWebsite.pages;

import org.openqa.selenium.WebDriver;
import rubberDucksShopWebsite.helpers.PageBase;
import rubberDucksShopWebsite.elements.HeaderMenu;

import static rubberDucksShopWebsite.helpers.Locators.getLocator;

public class LoginPage extends PageBase {
    public HeaderMenu headerMenu;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
    }

    public void attemptLogin(String email, String password) {
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    public String getMessage() {
        return driver.findElement(getLocator("LoginPage.message")).getText();
    }
}
