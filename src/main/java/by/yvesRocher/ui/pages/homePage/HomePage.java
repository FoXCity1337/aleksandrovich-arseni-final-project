package by.yvesRocher.ui.pages.homePage;

import by.yvesRocher.ui.pages.basketPage.BasketPage;
import by.yvesRocher.ui.pages.loginPage.LoginPage;
import by.yvesRocher.ui.utils.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasketPage clickBasketButton() {
        getDriver().findElement(By.xpath(HomePageXpath.BASKET_LOCATOR_XPATH_LOCATOR)).click();
        return new BasketPage(getDriver());
    }

    public LoginPage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageXpath.LOGIN_LOCATOR_XPATH_LOCATOR)));
        getDriver().findElement(By.xpath(HomePageXpath.LOGIN_LOCATOR_XPATH_LOCATOR)).click();
        return new LoginPage(getDriver());
    }

    public HomePage addAdventCalendarToBasket() {
        getDriver().findElement(By.xpath(HomePageXpath.ADVENT_CALENDAR_XPATH_LOCATOR)).click();
        getDriver().findElement(By.xpath(HomePageXpath.CLOSE_BUTTON_XPATH_LOCATOR)).click();
        return this;
    }

    public HomePage clickCloseButton(){
        getDriver().findElement(By.xpath(HomePageXpath.CLOSE_BUTTON_XPATH_LOCATOR)).click();
        return this;
    }
}
