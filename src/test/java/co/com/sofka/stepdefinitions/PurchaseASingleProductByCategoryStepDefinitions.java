package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.exitopages.*;
import co.com.sofka.setup.ExitoWebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class PurchaseASingleProductByCategoryStepDefinitions extends ExitoWebSetUp {
    HomePage homePage;
    CellPhonesCategoryPage cellPhonesCategoryPage;
    ProductDetails productDetails;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("adds to cart by category {string} a cell phone {string} selecting {int} units")
    public void addsToCartByCategoryACellPhoneSelectingUnits(String categoryName, String cellPhoneName, Integer unitsQuantity) {
        try {
            homePage = new HomePage(driver);
            cellPhonesCategoryPage = new CellPhonesCategoryPage(driver);
            productDetails = new ProductDetails(driver);
            homePage.selectCategories(categoryName);
            cellPhonesCategoryPage.selectCellPhones(cellPhoneName);
            productDetails.addProducts(unitsQuantity);
            productDetails.goToCart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @When("goes to finalize the purchase with email {string} name {string} last name {string} id {string} number {string} cell phone {string}")
    public void goesToFinalizeThePurchaseWithEmailNameLastNameIdNumberCellPhone(String email, String name, String lastName, String idType, String idNumber, String cellPhoneNumber) {
        try {
            cartPage = new CartPage(driver);
            checkoutPage = new CheckoutPage(driver);
            cartPage.ClickPayButton();
            cartPage.typeEmail(email);
            checkoutPage.fillCheckoutForm(name, lastName, idNumber, cellPhoneNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

}
