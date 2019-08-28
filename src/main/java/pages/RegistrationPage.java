package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement createButton;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "phone_mobile")
    WebElement phone;


    @FindBy(id = "submitAccount")
    WebElement registrationButton;

    @FindBy(id = "my-account")
    WebElement myAccount;

    public void inputRandomEmail() {
        String email = getRandomEmail();
        emailCreate.sendKeys(email);
    }

    public void clickOnCreateButton() {
        createButton.click();
    }

    public void inputFirstName(String text) {
        firstName.sendKeys(text);
    }

    public void inputLastName(String text) {
        lastName.sendKeys(text);
    }

    public void inputPassword(String text) {
        password.sendKeys(text);
    }

    public void inputCity(String text) {
        city.sendKeys(text);
    }

    public void inputAddress(String text) {
        address.sendKeys(text);
    }

    public void inputPostCode(String text) {
        postCode.sendKeys(text);
    }

    public void inputPhone(String text) {
        phone.sendKeys(text);
    }

    public void inputRegistrationDate() {
        String text = "test";
        String zipCode = "00000";

        inputFirstName(text);
        inputLastName(text);
        inputPassword(zipCode);
        inputCity(text);
        inputAddress(text);
        inputPostCode(zipCode);
        inputPhone(zipCode);

        choiceStateSelect();
    }

    public void choiceStateSelect() {
        Select select = new Select(state);
        select.selectByValue("1");
    }

    public boolean isMyAccountActive() {
        return myAccount.isDisplayed();
    }

    public void clickOnRegistrationButton() {
        registrationButton.click();
    }
}
