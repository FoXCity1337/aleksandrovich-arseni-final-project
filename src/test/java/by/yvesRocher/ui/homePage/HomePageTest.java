package by.yvesRocher.ui.homePage;

import by.yvesRocher.BaseTest;
import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.pages.loginPage.LoginPageMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomePageTest extends BaseTest {

    private HomePage homePage = new HomePage();

    @Test
    @DisplayName("Input wrong email or password")
    public void test1() {
        String actual = homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(6, 30)
                .clickAuthorizationButton()
                .getErrorMessage();
        Assertions.assertEquals(LoginPageMessages.WRONG_DATA_MESSAGE, actual);
    }

    @Test
    @DisplayName("Input short password")
    public void test2() {
        Assertions.assertEquals(LoginPageMessages.SHORT_PASSWORD_MESSAGE, homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(1, 5)
                .clickAuthorizationButton()
                .getErrorMessage());
    }

    @Test
    @DisplayName("Input long password")
    public void test3() {
        Assertions.assertEquals(LoginPageMessages.LONG_PASSWORD_MESSAGE, homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(31, 32)
                .clickAuthorizationButton()
                .getErrorMessage());
    }

    @Test
    @DisplayName("Input invalid email")
    public void test4() {
        String invalidEmail = "123@";
        Assertions.assertEquals(LoginPageMessages.INVALID_EMAIL_MESSAGE, homePage.closeCookie()
                .clickLoginButton()
                .inputEmail(invalidEmail)
                .inputPassword(6, 30)
                .clickAuthorizationButton()
                .getErrorMessage());
    }

    @Test
    @DisplayName(("Checking advent-calendar in basket"))
    public void test5() {
        String expected = "Адвент-Календарь - Лимитированная Коллекция";
        Assertions.assertEquals(expected, homePage.closeCookie()
                .addAdventCalendarToBasket()
                .clickBasketButton()
                .findAdventCalendar());
    }

    @Test
    @DisplayName(("Delete advent-calendar from basket"))
    public void test6() {
        String expected = "пуста";
        Assertions.assertEquals(expected, homePage.closeCookie()
                .addAdventCalendarToBasket()
                .clickBasketButton()
                .clickDeleteProduct());
    }
}
