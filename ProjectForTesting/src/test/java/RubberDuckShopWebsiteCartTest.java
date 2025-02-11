import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class RubberDuckShopWebsiteCartTest {
    @Test
    public void duckShouldBeAddedToTheCart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        Select sizeSelect = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelect.selectByVisibleText("Small");

        WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        WebElement sumValue = driver.findElement(By.cssSelector(".footer>:last-child"));
        assertEquals(sumValue.getText(), "$18.00");

        driver.quit();
    }

    @Test
    public void totalPriceShouldChangeInTheCart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        Select sizeSelect = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelect.selectByVisibleText("Small");

        WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        WebElement quantityValue = driver.findElement(By.name("quantity"));
        quantityValue.clear();
        quantityValue.sendKeys("2");

        WebElement updateButton = driver.findElement(By.name("update_cart_item"));
        updateButton.click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector(".header+tr>:first-child"), "2"));
        WebElement sumValue = driver.findElement(By.cssSelector(".footer>:last-child"));
        assertEquals(sumValue.getText(), "$36.00");

        driver.quit();
    }

    @Test
    public void cartShouldBeCleared() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        Select sizeSelect = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelect.selectByVisibleText("Small");

        WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        WebElement removeButton = driver.findElement(By.name("remove_cart_item"));
        removeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-cart-wrapper>p")));
        WebElement text = driver.findElement(By.cssSelector("#checkout-cart-wrapper>p:first-child"));
        assertEquals(text.getText(), "There are no items in your cart.");

        driver.quit();
    }

    @Test
    public void shouldAppearMessageInCartAboutQuantityLimit() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duckButton = driver.findElement(By.cssSelector("#box-most-popular [alt='Yellow Duck']"));
        duckButton.click();

        Select sizeSelect = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelect.selectByVisibleText("Small");

        WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        WebElement quantityValue = driver.findElement(By.name("quantity"));
        quantityValue.clear();
        quantityValue.sendKeys("11");

        WebElement updateButton = driver.findElement(By.name("update_cart_item"));
        updateButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notices-wrapper")));
        WebElement errorMessage = driver.findElement(By.cssSelector(".notice.errors"));
        assertEquals(errorMessage.getText(), "There are not enough products of the selected option in stock. (10)");

        driver.quit();
    }
}

