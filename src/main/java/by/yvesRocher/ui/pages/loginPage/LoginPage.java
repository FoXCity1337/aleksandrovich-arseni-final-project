package by.yvesRocher.ui.pages.loginPage;

import by.yvesRocher.ui.pages.registrationPage.RegistrationPage;
import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.utils.random.RandomData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement authorizationButton;

    @FindBy(xpath = "//div[@class='ng-star-inserted']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='authorization-header']")
    private WebElement registration;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//jdiv [@class=\"hoverArea__UN_UB\"]")
    private WebElement hoverArea;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage inputEmail() {
        for (int i = 0; i < 10; i++) {
            try {
                emailField.sendKeys(RandomData.generateEmail());
                break;
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                if (i == 10 - 1) throw e;
            }
        }
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
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,200)");
        authorizationButton.click();
        return this;
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public LoginPage clickRegistration(){
        wait.until(ExpectedConditions.visibilityOf(registration));
        registration.click();
        return this;
    }

    public RegistrationPage clickSubmitButton(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,200)");
        submitButton.click();
        js.executeScript("window.scrollBy(0,-200)");
        return new RegistrationPage(getDriver(),getWait());
    }
}
