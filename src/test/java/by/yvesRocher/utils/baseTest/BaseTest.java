package by.yvesRocher.utils.baseTest;

import by.yvesRocher.ui.utils.driver.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
    }
}
