package pages;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-link")
    WebElement contactUs;

    @FindBy(className = "header_user_info")
    WebElement login;

    @FindBy(name = "search_query")
    WebElement search;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(css = "ul[class*='sf-menu '] a[title*='Women']")
    WebElement woman;

    @FindBy(css = "ul[class*='submenu-container '] a[title*='T-shirts']")
    WebElement womanTShirts;

    public void searchRequest (String request){
        search.sendKeys(request);
        searchButton.click();
    }

    public void goToContactUs(){contactUs.click();}

    public void goToWomanTShirts(){
        Actions builder = new Actions(((Browser)driver).getDriver());

        builder.moveToElement(woman).perform();
        womanTShirts.click();
    }

    public void goToRegistrationPage (){login.click();}
}
