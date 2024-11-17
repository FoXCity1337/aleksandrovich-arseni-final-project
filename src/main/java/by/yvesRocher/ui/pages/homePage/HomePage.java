package by.yvesRocher.ui.pages.homePage;

import by.yvesRocher.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage(WebDriver driver) {
        this.driver = Driver.getDriver();
    }

    public HomePage clickBasketButton(){
        getDriver().findElement(By.xpath(HomePageXpath.BASKET_LOCATOR_XPATH)).click();
        return this;
    }

    public HomePage clickLoginButton(){
        getDriver().findElement(By.xpath(HomePageXpath.LOGIN_LOCATOR_XPATH)).click();
        return this;
    }
}
