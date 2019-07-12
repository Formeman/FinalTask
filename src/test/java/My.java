import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class My {

    @Test(alwaysRun = true)
    public void beforeMethod(){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
        driver.get("http://www.yopmail.com/ru/email-generator.php");
    }

    @Test
    public void demo(){
        System.out.println("AfterMethod");
    }

    @Test
    public void first(){
        System.out.println("test");
    }
}
