package by.yvesRocher.ui.pages.registrationPage;

import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.utils.random.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//label[@for='male']")
    private WebElement maleLabel;

    @FindBy(xpath = "//label[@for='female']")
    private WebElement femaleLabel;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastnameField;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='patronymic']")
    private WebElement patronymicField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='select-wrapper'][1]")
    private WebElement selectInnerDay;

    @FindBy(xpath = "//div[@class='select-wrapper'][2]")
    private WebElement selectInnerMonth;

    @FindBy(xpath = "//div[@class='select-wrapper'][3]")
    private WebElement selectInnerYear;

    @FindBy(xpath = "//label[@for='is_agree_to_the_processing_of_personal_data']")
    private WebElement processingOfPersonalData;

    @FindBy(xpath = "//label[@for='get_marketing_newsletter_agreement']")
    private WebElement marketingNewsletterAgreement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='toast-container']")
    private WebElement errorMessage;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public boolean fillInfo() {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        maleLabel.click();
        lastnameField.sendKeys(RandomData.generateLastname());
        nameField.sendKeys(RandomData.generateName());
        patronymicField.sendKeys(RandomData.generateLastname());
        passwordField.sendKeys(RandomData.generatePassword(6, 30));
        js.executeScript("window.scrollBy(0,400)");
        selectDay();
        selectMonth();
        selectYear();
        processingOfPersonalData.click();
        marketingNewsletterAgreement.click();
        submitButton.click();
        getWait().until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    private void selectDay() {
        selectInnerDay.click();
        String randomDay = "//ul[@class='select-inner day opened']/li[3]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDay)));
        getDriver().findElement(By.xpath(randomDay)).click();
    }

    private void selectMonth() {
        selectInnerMonth.click();
        String month = "//ul[@class='select-inner month opened']/li[1]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(month)));
        getDriver().findElement(By.xpath(month)).click();
    }

    private void selectYear() {
        selectInnerYear.click();
        String year = "//ul[@class='select-inner year opened']/li[5]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(year)));
        getDriver().findElement(By.xpath(year)).click();
    }
}
