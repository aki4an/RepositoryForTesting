import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RubberDuckShopWebsiteCatalogTest {
    @Test
    public void yellowDuckShouldHaveAChoiceOfSize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        WebElement sizeSelect = driver.findElement(By.cssSelector(".options"));
        assertTrue(sizeSelect.isDisplayed(), "The yellow rubber duck should have a choice of size");

        driver.quit();
    }

    @Test
    public void yellowDuckShouldBeOnSale() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        WebElement stickerSale = driver.findElement(By.cssSelector(".sticker.sale"));
        assertTrue(stickerSale.isDisplayed(), "The yellow rubber ducky should be on sale");

        driver.quit();
    }
}
