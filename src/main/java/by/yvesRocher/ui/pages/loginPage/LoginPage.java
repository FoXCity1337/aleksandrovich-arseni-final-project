package by.yvesRocher.ui.pages.loginPage;

import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.utils.random.RandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement authorizationButton;

    @FindBy(xpath = "//div[@class='ng-star-inserted']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage inputEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(RandomData.generateEmail());
        return this;
    }

    public LoginPage inputEmail(String invalidEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(invalidEmail);
        return this;
    }

    public LoginPage inputPassword(int min, int max) {
        passwordField.sendKeys(RandomData.generatePassword(min, max));
        return this;
    }

    public LoginPage clickAuthorizationButton() {
        authorizationButton.click();
        return this;
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
