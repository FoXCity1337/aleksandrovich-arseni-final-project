package by.yvesRocher;

import by.yvesRocher.ui.utils.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.y-r.by/");
    }

//    @AfterEach
//    public void tearDown(){
//        Driver.quitDriver();
//    }
}
