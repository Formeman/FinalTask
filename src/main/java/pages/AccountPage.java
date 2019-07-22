package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "icon-list-ol")
    WebElement historyButton;

    @FindBy(css = "tbody a[class*=' button-small']")
    List<WebElement> detailsButton;


    @FindBy(css = "div[id*='order-detail-content'] td[class*='bold']")
    WebElement productLabel;

    public void clickToHistoryButton(){historyButton.click();}

    public void clickToDetailsButton(){detailsButton.get(0).click();}

    public String getProductLabel(){return productLabel.getText();}
}
