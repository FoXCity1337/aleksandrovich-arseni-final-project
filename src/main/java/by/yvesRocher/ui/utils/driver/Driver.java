package by.yvesRocher.ui.utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        return null;
    }
}
