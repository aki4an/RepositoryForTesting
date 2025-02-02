import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class RubberDuckShopWebsiteHeaderTest {
    @Test
    public void shouldGoToRubberDucksPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksButton = driver.findElement(By.cssSelector
                ("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        rubberDucksButton.click();

        assertEquals(driver.getTitle(), "Rubber Ducks | My Store");

        driver.quit();
    }

    @Test
    public void shouldGoToOnlineStorePage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement onlineStoreButton = driver.findElement(By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/']"));
        onlineStoreButton.click();

        assertEquals(driver.getTitle(), "Online Store | My Store");

        driver.quit();
    }

    @Test
    public void shouldGoToSubcategoryPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksButton = driver.findElement(By.cssSelector
                ("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        WebElement subcategoryButton = driver.findElement(By.cssSelector
                ("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']"));

        Actions action = new Actions(driver);
        action.pause(Duration.ofMillis(500)).moveToElement(rubberDucksButton).click(subcategoryButton).perform();

        assertEquals(driver.getTitle(), "Subcategory | My Store");

        driver.quit();
    }
}
