package by.yvesRocher.ui.pages.basketPage;

import by.yvesRocher.ui.utils.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BasketPage(WebDriver driver) {
        this.driver = Driver.getDriver();
    }

    public BasketPage clickDeleteProduct(){
        getDriver().findElement(By.xpath(BasketPageXpath.DELETE_PRODUCT_FROM_BASKET_LOCATOR_XPATH));
        return this;
    }

    public BasketPage clickContinueButton(){
        getDriver().findElement(By.xpath(BasketPageXpath.CONTINUE_BUTTON_LOCATOR_XPATH));
        return this;
    }
}
