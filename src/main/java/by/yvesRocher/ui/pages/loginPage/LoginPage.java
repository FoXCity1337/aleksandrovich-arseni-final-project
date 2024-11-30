package by.yvesRocher.ui.pages.loginPage;

import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.pages.homePage.HomePageXpath;
import by.yvesRocher.ui.utils.driver.Driver;
import by.yvesRocher.ui.utils.random.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends HomePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage clickAuthorization() {
        getDriver().findElement(By.xpath(LoginPageXpath.AUTHORIZATION_MENU_LOCATOR_XPATH)).click();
        return this;
    }

    public LoginPage clickRegistration() {
        getDriver().findElement(By.xpath(LoginPageXpath.REGISTRATION_BUTTON_LOCATOR_XPATH)).click();
        return this;
    }

    public LoginPage inputEmail() {
        getDriver().findElement(By.xpath(LoginPageXpath.EMAIL_FIELD_LOCATOR_XPATH)).sendKeys(RandomData.generateEmail());
        return this;
    }

    public LoginPage inputPassword(int min, int max) {
        getDriver().findElement(By.xpath(LoginPageXpath.PASSWORD_FIELD_LOCATOR_XPATH))
                .sendKeys(RandomData.generatePassword(min, max));
        return this;
    }

    public LoginPage clickAuthorizationButton() {
        getDriver().findElement(By.xpath(LoginPageXpath.AUTHORIZATION_BUTTON_LOCATOR_XPATH)).click();
        return this;
    }

    public String getWrongDataMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageXpath.WRONG_DATA_MESSAGE_XPATH)));
        return getDriver().findElement(By.xpath(LoginPageXpath.WRONG_DATA_MESSAGE_XPATH)).getText();
    }
}
