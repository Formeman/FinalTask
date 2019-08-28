import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.util.UUID;
public class My {

//    @Test(alwaysRun = true)
//    public void beforeMethod() throws InterruptedException {
//        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//
//    }

    @Test
    public void demo(){
        System.out.println("AfterMethod");
    }

    @Test
    public void first(){
        System.out.println("test");
    }


}
