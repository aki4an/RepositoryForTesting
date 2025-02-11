import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RubberDuckShopWebsiteLoginTest {
    @Test
    public void shouldLogInToAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement emailInputField = driver.findElement(By.name("email"));
        WebElement passwordInputField = driver.findElement(By.name("password"));
        emailInputField.sendKeys("testduckshop@mail.ru");
        passwordInputField.sendKeys("234");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector(".notice.success"));
        assertEquals(successMessage.getText(), "You are now logged in as Name Surname.");

        driver.quit();
    }

    @Test
    public void shouldAppearMessageAboutInvalidLoginDetails() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement emailInputField = driver.findElement(By.name("email"));
        WebElement passwordInputField = driver.findElement(By.name("password"));
        emailInputField.sendKeys("testduckshop@mail.ru");
        passwordInputField.sendKeys("24");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".notice.errors"));
        assertEquals(errorMessage.getText(), "Wrong password or the account is disabled, or does not exist");

        driver.quit();
    }

    @Test
    public void shouldAppearMessageAboutUnenteredLoginDetails() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.sendKeys("testduckshop@mail.ru");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".notice.errors"));
        assertEquals(errorMessage.getText(), "You must provide both email address and password.");

        driver.quit();
    }
}
