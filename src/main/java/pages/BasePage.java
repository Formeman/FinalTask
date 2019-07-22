package pages;

import driverSingleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class BasePage {
    protected WebDriver driver = WebDriverSingleton.create();

    public String getRandomEmail() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString()+"@gmail.com";
    }
}

