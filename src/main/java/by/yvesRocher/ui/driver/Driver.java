package by.yvesRocher.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public Driver() {
    }

    private static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static void quidDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
