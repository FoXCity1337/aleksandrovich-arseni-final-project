package by.yvesRocher.ui.homePage;

import by.yvesRocher.ui.pages.homePage.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest {

    private HomePage homePage = new HomePage();

    @Test
    public void test1(){
        homePage.clickLoginButton()
                .inputEmail()
                .inputPassword();
    }
}
