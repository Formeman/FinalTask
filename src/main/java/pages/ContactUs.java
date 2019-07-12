package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUs extends BasePage {

    public ContactUs(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "fileUpload")
    WebElement file;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(name = "id_order")
    WebElement order;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(name = "id_contact")
    WebElement idContact;

    @FindBy(css = "p[class*='alert alert-success'] ")
    WebElement alertSuccess;

    @FindBy(name = "submitMessage")
    WebElement sendButton;

    @FindBy(css = "div[class*='alert alert-danger'] ol")
    WebElement errorMessage;

    public void chooseContact(){
        Select select = new Select(idContact);
        select.selectByValue("1");
    }

    public void inputEmail(String emailValue){ email.sendKeys(emailValue);}

    public void orderInput(String orderValue){ order.sendKeys(orderValue);}

    public void fileInput(String fileLocation){file.sendKeys(fileLocation);}

    public void messageInput(String messageValue){message.sendKeys(messageValue);}

    public boolean alertSuccessIsDisplayed(){return alertSuccess.isDisplayed();}

    public void clickToSendButton(){sendButton.click();}

    public String getErrorMessage(){return errorMessage.getText();}

}
