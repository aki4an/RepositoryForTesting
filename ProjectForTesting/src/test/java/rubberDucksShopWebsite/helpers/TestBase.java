package rubberDucksShopWebsite.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rubberDucksShopWebsite.enums.Browser;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    protected void methodSetup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));

        driver = switch (browser) {
            case chrome -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--start-maximized");
                yield new ChromeDriver(options);
            }
            case edge -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--start-maximized");
                yield new EdgeDriver(options);
            }
        };

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void methodTearDown() {
        driver.quit();
    }
}
