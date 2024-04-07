package stellarburgers.test.account;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pojo.User;
import stellarburgers.pojo.UserAuth;
import stellarburgers.pom.HomePage;
import stellarburgers.pom.LoginPage;
import stellarburgers.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static stellarburgers.api.UserApi.*;
import static stellarburgers.pom.BasePage.LOGIN_PAGE_URL;

public class AccountTest extends BaseTest {
    private User user;

    private HomePage page;

    @Before
    public void setUpUserAndAuth(){
        user = User.create(6);
        createUser(user);

        page = open(LOGIN_PAGE_URL, LoginPage.class)
                .setUserData(user)
                .clickLoginButton();
    }
    @Test
    @DisplayName("Метод проверки открытия личного кабинета")
    @Description("Метод проверяет открылась ли страница с личным кабинетом после авторизации и нажатия кнопки")
    public void checkGoToAccountByClickingOnPersonalAccount(){
        assertTrue("Страница личного кабинета не открылась",
                page.clickAccountUpperAuthUser()
                        .isProfileButtonDisplayed()
        );
    }
    @Test
    @DisplayName("Метод проверки открытия конструктора по кнопке 'Конструктор'")
    @Description("Метод проверяет открылась ли страница с конструктором после нажатия кнопки 'Конструктор'")
    public void checkTransitionFromAccountToConstructorOnConstructorButton(){
        assertTrue("Страница с конструктором не открылась",
                page.clickAccountUpperAuthUser()
                        .clickConstructButton()
                        .isHomePageOpen()
        );
    }
    @Test
    @DisplayName("Метод проверки открытия конструктора по кнопке Логотипа со Stellar Burgers")
    @Description("Метод проверяет открылась ли страница с конструктором после нажатия кнопки 'Конструктор'")
    public void checkTransitionFromAccountToConstructorOnLogoButton(){
        assertTrue("Страница с конструктором не открылась",
                page.clickAccountUpperAuthUser()
                        .clickLogoButton()
                        .isHomePageOpen()
        );
    }
    @Test
    @DisplayName("Метод проверки кнопки выхода из Личного кабинета")
    @Description("Метод проверяет срабатывает ли выход из Личного кабинета после нажатия кнопки 'Выход'")
    public void checkLogoutButton(){
        assertTrue("Страница с окном авторизации не открылась",
                page.clickAccountUpperAuthUser()
                        .clickLogoutButton()
                        .isLoginPageOpen()
        );
    }

    @After
    public void cleanUser(){
        deleteUser(authUser(user).as(UserAuth.class));
    }
}
