package by.yvesRocher.ui.pages.basketPage;

import by.yvesRocher.ui.pages.homePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@href, 'kalendar-2024')]")
    private WebElement adventCalendar;

    @FindBy(xpath = "//span[contains(text(),'пуста')]")
    private WebElement emptyBasket;

    @FindBy(xpath = "//div[@class='delete-btn-and-price']/button[@type='button']")
    private WebElement deleteProduct;

    public WebDriver getDriver() {
        return driver;
    }

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String findAdventCalendar() {
        wait.until(ExpectedConditions.visibilityOf(adventCalendar));
        return adventCalendar.getText();
    }

    public String clickDeleteProduct() {
        wait.until(ExpectedConditions.visibilityOf(deleteProduct));
        deleteProduct.click();
        wait.until(ExpectedConditions.visibilityOf(emptyBasket));
        return emptyBasket.getText();
    }

    public BasketPage clickContinueButton() {
        getDriver().findElement(By.xpath(BasketPageXpath.CONTINUE_BUTTON_LOCATOR_XPATH));
        return this;
    }
}
