package rubberDucksShopWebsite;

import org.testng.annotations.Test;
import rubberDucksShopWebsite.helpers.TestBase;
import rubberDucksShopWebsite.pages.CatalogPage;

import static org.testng.Assert.assertEquals;

public class HeaderTest extends TestBase {
    @Test
    public void shouldGoToRubberDucksPage() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.headerMenu.clickRubberDucksPageButton();

        assertEquals(catalogPage.getTitle(), "Rubber Ducks | My Store");
    }

    @Test
    public void shouldGoToOnlineStorePage() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.headerMenu.clickHomePageButton();

        assertEquals(catalogPage.getTitle(), "Online Store | My Store");
    }

    @Test
    public void shouldGoToSubcategoryPage() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.headerMenu.clickSubcategoryPageButton();

        assertEquals(catalogPage.getTitle(), "Subcategory | My Store");
    }
}
