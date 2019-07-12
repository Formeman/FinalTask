package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*='product-container'] a[class*='product-name']")
    List<WebElement> productName;

    @FindBy(css = "a[class*='button ajax']")
    List<WebElement> addButton;

    @FindBy(css = "div[class*='button-container'] a")
    WebElement checkout;



    public String getProductName(){return productName.get(0).getText();}

    public void addProduct(){addButton.get(0).click();}

    public void clictToCheckout(){checkout.click();}
}
