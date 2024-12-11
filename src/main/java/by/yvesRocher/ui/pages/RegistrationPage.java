package by.yvesRocher.ui.pages;

import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.pages.loginPage.LoginPage;
import by.yvesRocher.ui.utils.random.RandomData;
import org.openqa.selenium.By;
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

    public RegistrationPage fillOutForm(){
        maleLabel.click();
        lastnameField.sendKeys(RandomData.generateLastname());
        nameField.sendKeys(RandomData.generateName());
        patronymicField.sendKeys(RandomData.generateName());
        passwordField.sendKeys(RandomData.generatePassword(6,30));
        return this;
    }

    public RegistrationPage selectDay(){
        selectInnerDay.click();
        String randomDay = "//ul[@class='select-inner day opened']/li[3]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDay)));
        getDriver().findElement(By.xpath(randomDay)).click();
        return this;
    }

    public RegistrationPage selectMonth(){
        selectInnerMonth.click();
        String month = "//ul[@class='select-inner month opened']/li[1]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(month)));
        getDriver().findElement(By.xpath(month)).click();
        return this;
    }

    public RegistrationPage selectYear(){
        selectInnerYear.click();
        String year = "//ul[@class='select-inner year opened']/li[3]";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(year)));
        getDriver().findElement(By.xpath(year)).click();
        return this;
    }
}
