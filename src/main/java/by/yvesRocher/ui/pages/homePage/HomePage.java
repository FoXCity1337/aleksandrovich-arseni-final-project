package by.yvesRocher.ui.pages.homePage;

import by.yvesRocher.ui.pages.basketPage.BasketPage;
import by.yvesRocher.ui.pages.loginPage.LoginPage;
import by.yvesRocher.ui.utils.driver.Driver;
import by.yvesRocher.ui.utils.driver.Wait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li/a[@href='/auth/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//li/a[@href='/basket']")
    private WebElement basketButton;

    @FindBy(xpath = "//button[@class='btn cookie-actions-button'][2]")
    private WebElement cookieAccept;

    @FindBy(css = "#nav-home div > div:nth-child(2) > app-goods-card > a > div.rating-and-price > button")
    private WebElement firstProduct;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closeButton;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.wait = Wait.getWait();
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

    public HomePage addFirstProductInBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
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
