package by.yvesRocher.ui.homePage;

import by.yvesRocher.BaseTest;
import by.yvesRocher.ui.pages.homePage.HomePage;
import by.yvesRocher.ui.pages.loginPage.LoginPageMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage = new HomePage();

    @Test
    @DisplayName("Input wrong email or password")
    public void test1() {
        Assertions.assertEquals(LoginPageMessages.WRONG_DATA_MESSAGE, homePage.closeCookie()
                .clickLoginButton()
                .inputEmail()
                .inputPassword(6, 30)
                .clickAuthorizationButton()
                .getErrorMessage());
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
        Assertions.assertEquals(LoginPageMessages.INVALID_EMAIL_MESSAGE, homePage.closeCookie()
                .clickLoginButton()
                .inputEmail("123@")
                .inputPassword(6, 30)
                .clickAuthorizationButton()
                .getErrorMessage());
    }
}
