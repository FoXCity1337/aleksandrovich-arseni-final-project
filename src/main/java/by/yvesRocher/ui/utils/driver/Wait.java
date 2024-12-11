package by.yvesRocher.ui.utils.driver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private static WebDriverWait wait;

    public static WebDriverWait getWait(){
        return wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }
}
