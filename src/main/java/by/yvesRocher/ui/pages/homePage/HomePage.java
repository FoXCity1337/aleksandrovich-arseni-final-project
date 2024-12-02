package by.yvesRocher.ui.pages.homePage;

import by.yvesRocher.ui.pages.basketPage.BasketPage;
import by.yvesRocher.ui.pages.loginPage.LoginPage;
import by.yvesRocher.ui.utils.driver.Driver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li/a[@href='/auth/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//li/a[@href='/basket']")
    private WebElement basketButton;

    @FindBy(xpath = "//button[@class='btn cookie-actions-button'][2]")
    private WebElement cookieAccept;

    @FindBy(xpath = "//owl-stage[contains(@class, 'c62-3')]//a[contains(@href, 'kalendar-2024')]//button[@type='button']")
    private WebElement adventCalendar;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closeButton;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public BasketPage clickBasketButton() {
        basketButton.click();
        return new BasketPage(getDriver(), getWait());
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver(), getWait());
    }

    public HomePage addAdventCalendarToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(adventCalendar));
        adventCalendar.click();
        closeButton.click();
        return this;
    }

    public HomePage closeCookie() {
        for (int i = 0; i < 3; i++) {
            try {
                cookieAccept.click();
                break;
            } catch (StaleElementReferenceException e) {
                if (i == 3 - 1) throw e;
            }
        }
        return this;
    }
}
