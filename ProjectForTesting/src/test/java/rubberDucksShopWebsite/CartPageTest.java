package rubberDucksShopWebsite;

import org.testng.annotations.Test;
import rubberDucksShopWebsite.helpers.TestBase;
import rubberDucksShopWebsite.pages.CartPage;
import rubberDucksShopWebsite.pages.CatalogPage;
import rubberDucksShopWebsite.pages.DuckPage;

import static org.testng.Assert.assertEquals;

public class CartPageTest extends TestBase {
    @Test
    public void duckShouldBeAddedToTheCart() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);
        duckPage.selectSmallSize();
        CartPage cartPage = new CartPage(driver);
        cartPage.addDuckToCart();
        cartPage.goToCart();

        assertEquals(cartPage.getSumValue(), "$18.00");
    }

    @Test
    public void totalPriceShouldChangeInTheCart() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);
        duckPage.selectSmallSize();
        CartPage cartPage = new CartPage(driver);
        cartPage.addDuckToCart();
        cartPage.goToCart();
        cartPage.changeQuantity(2);
        cartPage.waitUpdateForOrderQuantity();

        assertEquals(cartPage.getSumValue(), "$36.00");
    }

    @Test
    public void cartShouldBeCleared() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);
        duckPage.selectSmallSize();
        CartPage cartPage = new CartPage(driver);
        cartPage.addDuckToCart();
        cartPage.goToCart();
        cartPage.clearCart();

        assertEquals(cartPage.getInfo(), "There are no items in your cart.");
    }

    @Test
    public void shouldAppearMessageInCartAboutQuantityLimit() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectYellowDuck();
        DuckPage duckPage = new DuckPage(driver);
        duckPage.selectSmallSize();
        CartPage cartPage = new CartPage(driver);
        cartPage.addDuckToCart();
        cartPage.goToCart();
        cartPage.changeQuantity(11);

        assertEquals(cartPage.getMessage(), "There are not enough products of the selected option in stock. (10)");
    }
}

