package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "icon-list-ol")
    WebElement historyButton;

    @FindBy(css = "tr[class*='first_item'] span[class*='footable-toggle']")
    WebElement plusButton;

    @FindBy(css = "tr[class*='footable-row-detail'] a[class*='btn']")
    WebElement detailsButton;

    @FindBy(css = "div[id*='order-detail-content'] td[class*='bold']")
    WebElement productLabel;

    public void clickToHistoryButton(){historyButton.click();}

    public void clickToPlusButton(){plusButton.click();}

    public void clickToDetailsButton(){detailsButton.click();}

    public String getProductLabel(){return productLabel.getText();}
}
