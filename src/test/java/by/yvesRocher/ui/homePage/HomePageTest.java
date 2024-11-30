package by.yvesRocher.ui.homePage;

import by.yvesRocher.BaseTest;
import by.yvesRocher.ui.pages.homePage.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage = new HomePage();

    @Test
    @DisplayName("Input email and password")
    public void test1(){
        homePage.clickLoginButton()
                .inputEmail()
                .inputPassword()
                .clickAuthorizationButton();
    }
}
