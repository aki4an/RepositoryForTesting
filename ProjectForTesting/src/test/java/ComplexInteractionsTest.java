import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ComplexInteractionsTest {
    @Test
    public void shouldRightClickOnTheButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one.btn"));
        WebElement rightClickMenu = driver.findElement(By.cssSelector(".context-menu-list"));

        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).perform();

        assertTrue(rightClickMenu.isDisplayed(), "After right-clicking the button, a menu should appear");

        driver.quit();
    }

    @Test
    public void shouldDoubleClickOnTheButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton = driver.findElement(By.cssSelector("button[ondblclick]"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        assertEquals(alertText, "You double clicked me.. Thank You..");

        driver.quit();
    }

    @Test
    public void theBallShouldMoveIntoTheGoal() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));

        Actions action = new Actions(driver);
        action.dragAndDrop(ball, goal).perform();

        String colorGoal = goal.getCssValue("background-color");
        assertEquals(colorGoal, "rgba(255, 192, 203, 1)");

        driver.quit();
    }
}
