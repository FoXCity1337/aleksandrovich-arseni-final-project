package by.yvesRocher.ui.pages.loginPage;

import by.yvesRocher.ui.utils.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
        getDriver().findElement(By.xpath(LoginPageXpath.EMAIL_FIELD_LOCATOR_XPATH)).sendKeys("123@mail.ru");
        return this;
    }

    public LoginPage inputPassword() {
        getDriver().findElement(By.xpath(LoginPageXpath.PASSWORD_FIELD_LOCATOR_XPATH)).sendKeys("qwerty");
        return this;
    }

    public LoginPage clickAuthorizationButton() {
        getDriver().findElement(By.xpath(LoginPageXpath.AUTHORIZATION_BUTTON_LOCATOR_XPATH)).click();
        return this;
    }
}
