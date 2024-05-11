package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//span[text()='Continuar /']")
    private WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='document']")
    private WebElement idField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneField;
    @CacheLookup
    @FindBy(xpath = "//article[@class='exito-checkout-io-0-x-termsContainer false']//input")
    private WebElement termsButton;
    @CacheLookup
    @FindBy(css = "svg.exito-checkout-io-0-x-profileInputSelectContainer .exito-checkout-io-0-x-profileDocumentTypeSelect ")
    private WebElement arrowDown;
    @CacheLookup
    @FindBy(xpath = "//li[text()='Cédula ciudadanía']")
    private WebElement idSelection;
    @CacheLookup
    @FindBy(xpath = "(//article[@class='exito-checkout-io-0-x-privacyPolicyContainer false']//input)[1]")
    private WebElement privacyPolicyButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void fillCheckoutForm(String firstName, String lastName, String id, String phone) {
        waitToBeVisible(firstNameField);

        click(termsButton);
        click(privacyPolicyButton);

        waitToBeClickable(firstNameField);
        waitToBeClickable(lastNameField);
        waitToBeVisible(idField);
        waitToBeVisible(phoneField);

        waitToBeClickable(firstNameField);
        click(firstNameField);
        clear(firstNameField);
        clear(firstNameField);
        typeIntoAndTab(firstNameField, firstName);

        waitToBeClickable(lastNameField);
        click(lastNameField);
        clear(lastNameField);
        typeIntoAndTab(lastNameField, lastName);

        waitToBeVisible(idField);
        click(idField);
        clear(idField);
        typeIntoAndTab(idField, id);

        waitToBeVisible(phoneField);
        click(phoneField);
        clear(phoneField);
        typeIntoAndTab(phoneField, phone);

        /*
        click(arrowDown);
        waitToBeClickable(idSelection);
        click(idSelection);
         */

        clickContinueButton();
    }
    public void clickContinueButton() {
        waitToBeVisible(continueButton);
        click(continueButton);
    }
}
