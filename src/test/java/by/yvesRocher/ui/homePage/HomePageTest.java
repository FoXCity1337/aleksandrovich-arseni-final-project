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
                .inputPassword(6,30)
                .clickAuthorizationButton()
                .getWrongDataMessage());
    }
}
