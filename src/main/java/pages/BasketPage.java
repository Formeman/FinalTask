package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div [id*='order-detail-content'] p")
    WebElement productName;

    @FindBy(className = "cart_quantity_delete")
    WebElement deletebutton;

    @FindBy(className = "alert alert-warning")
    WebElement alert;

    @FindBy(css = "[class*='button btn btn-default']")
    WebElement checkoutButton;

    @FindBy(name = "cgv")
    WebElement cgvButton;

    @FindBy(className = "account")
    WebElement accountButton;

    @FindBy(className = "bankwire")
    WebElement payButton;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(name = "SubmitLogin")
    WebElement loginButton;

    public String isProductIsDisplayed(){return productName.getText();}

    public void clickToDeleteButton(){deletebutton.click();}

    public boolean isAlertIsDisplayed(){return alert.isDisplayed();}

    public void clickToCheckoutButton(){checkoutButton.click();}

    public void clickTosgvButton(){cgvButton.click();}

    public void goToAccountButton(){accountButton.click();}

    public void clickToPayButton(){payButton.click();}

    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton(){loginButton.click();}

    public String getProductName(){return productName.getText();}
}
