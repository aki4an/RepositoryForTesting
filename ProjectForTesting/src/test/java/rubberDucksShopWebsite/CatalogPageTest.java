package rubberDucksShopWebsite;

import org.testng.annotations.Test;
import rubberDucksShopWebsite.helpers.TestBase;
import rubberDucksShopWebsite.pages.CatalogPage;
import rubberDucksShopWebsite.pages.DuckPage;

import static org.testng.Assert.assertTrue;

public class CatalogPageTest extends TestBase {
    @Test
    public void yellowDuckShouldHaveAChoiceOfSize() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);

        assertTrue(duckPage.visibilityOfSizeOptions(), "The yellow rubber duck should have a size selection option");
    }

    @Test
    public void yellowDuckShouldBeOnSale() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);

        assertTrue(duckPage.saleStickerVisibility(), "The yellow rubber ducky should be on sale");
    }
}
