package by.yvesRocher.ui.utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    public Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.y-r.by/");
        return driver;
    }

    public static WebDriver quidDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        return null;
    }
}
