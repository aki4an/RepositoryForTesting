import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FirstSeleniumTest {
    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(By.tagName("a")));
        elements.get(10).click();
        driver.quit();
    }
}
