import driverSingleton.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class FinalTask {
    WebDriver driver;
    MainPage mainPage;
    ContactUs contactUs;
    SearchPage searchPage;
    BasketPage basketPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = WebDriverSingleton.create();


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        mainPage = new MainPage(driver);
        contactUs = new ContactUs(driver);
        searchPage = new SearchPage(driver);
        basketPage = new BasketPage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(){
    WebDriverSingleton.kill();
    }

    @Test
    public void positiveContact() {
        String email = "email@mail.ru";
        String order = "12345678";
        String file = "C:/Users/qwerty/Desktop/Автоматизация/FinalTask/Text.txt";
        String message = "Message";

        mainPage.goToContactUs();
        contactUs.chooseContact();
        contactUs.inputEmail(email);
        contactUs.orderInput(order);
        contactUs.fileInput(file);
        contactUs.messageInput(message);
        contactUs.clickToSendButton();

        Assert.assertTrue(contactUs.alertSuccessIsDisplayed(),"Successful alert should be displayed");
    }

    @Test
    public void negativeContact(){
        String email = "email@mail.ru";
        String order = "12345678";
        String file = "C:/Users/qwerty/Desktop/Автоматизация/FinalTask/Text.txt";
        String error = "The message cannot be blank.";

        mainPage.goToContactUs();
        contactUs.chooseContact();
        contactUs.inputEmail(email);
        contactUs.orderInput(order);
        contactUs.fileInput(file);
        contactUs.clickToSendButton();

        Assert.assertEquals(contactUs.getErrorMessage(),error,"Error message should be visible");
    }

//    @Test
//    public void registration(){
    ////Randomizer
//        @FindBy(id = "login")
//        WebElement loginR;
////Registration
//        @FindBy(id = "email_create")
//        WebElement emailCreate;
//        @FindBy(id = "SubmitCreate")
//        WebElement SubmitCreate;

////        String currentWindow = driver.getWindowHandle();
////        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
////        driver.get("http://www.yopmail.com/ru/email-generator.php");
////        String loginName =driver.findElement(By.id("login")).getText();
//
//        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//        driver.findElement(By.linkText("http://www.yopmail.com/ru/email-generator.php")).sendKeys(selectLinkOpeninNewTab);
//        String loginName =driver.findElement(By.id("login")).getText();
//
//        driver.close();

//
////        login.click();
////        emailCreate.sendKeys(loginName);
////        SubmitCreate.click();
//
//        Assert.assertEquals(driver.getCurrentUrl(),"account-creation");
//    }

    @Test
    public void findBlouse(){
        String product = "Blouse";

        mainPage.searchRequest(product);

        Assert.assertEquals(searchPage.getProductName(),product,"Product should be displayed");
    }

    @Test
    public void addProductInBasket(){
        String product = "Blouse";

        mainPage.searchRequest(product);
        searchPage.addProduct();
        searchPage.clictToCheckout();

        Assert.assertTrue(basketPage.isProductIsDisplayed(),"Product should be displayed");

        basketPage.clickToDeleteButton();

        Assert.assertTrue(basketPage.isAlertIsDisplayed(),"Alert should be displayed");
    }

    @Test
    public void catalogTest(){
        String product = "T-shirts";

        mainPage.goToWomanTShirts();

        Assert.assertTrue(searchPage.getProductName().contains(product), "Searching results should contain T-Shirt");
    }

    @Test
    public void buyingTest(){
        String email = "test1@mail.ru";
        String password = "12345";

        mainPage.goToWomanTShirts();
        searchPage.addProduct();
        searchPage.clictToCheckout();

        String productName = basketPage.getProductName();

        basketPage.clickToCheckoutButton();
        basketPage.login(email,password);
        basketPage.clickToCheckoutButton();
        basketPage.clickTosgvButton();
        basketPage.clickToCheckoutButton();
        basketPage.clickToPayButton();
        basketPage.clickToCheckoutButton();
        basketPage.goToAccountButton();

        accountPage.clickToHistoryButton();
        accountPage.clickToPlusButton();
        accountPage.clickToDetailsButton();

        Assert.assertTrue(accountPage.getProductLabel().contains(productName),"Product names should be identical");
    }
}
