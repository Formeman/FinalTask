package pages;

import driverSingleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver = WebDriverSingleton.create();
}
