package by.yvesRocher.ui;

import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.pages.loginPage.LoginPageMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

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
        String actual = homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(1, 5)
                .clickAuthorizationButton()
                .getErrorMessage();
        Assertions.assertEquals(LoginPageMessages.SHORT_PASSWORD_MESSAGE, actual);
    }

    @Test
    @DisplayName("Input long password")
    public void test3() {
        String actual = homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(31, 32)
                .clickAuthorizationButton()
                .getErrorMessage();
        Assertions.assertEquals(LoginPageMessages.LONG_PASSWORD_MESSAGE, actual);
    }

    @Test
    @DisplayName("Input invalid email")
    public void test4() {
        String invalidEmail = "123@";
        String actual = homePage.closeCookie()
                .clickLoginButton()
                .inputEmail(invalidEmail)
                .inputPassword(6, 30)
                .clickAuthorizationButton()
                .getErrorMessage();
        Assertions.assertEquals(LoginPageMessages.INVALID_EMAIL_MESSAGE, actual);
    }

    @Test
    @DisplayName(("Checking first product in basket"))
    public void test5() {
        Assertions.assertTrue(homePage.closeCookie()
                .addFirstProductInBasket()
                .clickBasketButton()
                .findFirstProduct());
    }

    @Test
    @DisplayName(("Delete product from basket"))
    public void test6() {
        String expected = "пуста";
        String actual = homePage.closeCookie()
                .addFirstProductInBasket()
                .clickBasketButton()
                .clickDeleteProduct();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(("Registration form"))
    public void test7() {
        Assertions.assertTrue(homePage.closeCookie()
                .clickLoginButton()
                .clickRegistration()
                .inputEmail()
                .clickSubmitButton()
                .fillInfo());
    }
}
