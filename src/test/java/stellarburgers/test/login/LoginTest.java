package stellarburgers.test.login;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pojo.User;
import stellarburgers.pojo.UserAuth;
import stellarburgers.pom.HomePage;
import stellarburgers.pom.RecoveryPasswordPage;
import stellarburgers.pom.RegistrationPage;
import stellarburgers.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static stellarburgers.api.UserApi.*;
import static stellarburgers.pom.BasePage.*;

public class LoginTest extends BaseTest {
    private User user;

    @Before
    public void setUpUser(){
        user = User.create(6);
        createUser(user);
    }

    @Test
    @DisplayName("Метод проверки авторизации через кнопку 'Личный кабинет' на домашней странице")
    @Description("Метод авторизует пользователя по сценарию через кнопку 'Личный кабинет' на домашней странице")
    public void checkLoginHomePageUpperButton(){
        HomePage page = open(HOME_PAGE_URL, HomePage.class);

        assertTrue("Авторизация не прошла",
                page.clickAccountUpper()
                        .setUserData(user)
                        .clickLoginButton()
                        .isHomePageOpen()
        );
    }

    @Test
    @DisplayName("Метод проверки авторизации через кнопку 'Войти в аккаунт' на домашней странице")
    @Description("Метод авторизует пользователя по сценарию через кнопку 'Войти в аккаунт' на домашней странице")
    public void checkLoginHomePageBottomButton(){
        HomePage page = open(HOME_PAGE_URL, HomePage.class);

        assertTrue("Авторизация не прошла",
                page.clickAccountBottom()
                        .setUserData(user)
                        .clickLoginButton()
                        .isHomePageOpen()
        );
    }

    @Test
    @DisplayName("Метод проверки авторизации через кнопку 'Войти' на странице регистрации")
    @Description("Метод авторизует пользователя по сценарию через кнопку 'Войти' на странице регистрации")
    public void checkLoginRegistrationPage(){
        RegistrationPage page = open(REG_PAGE_PATH, RegistrationPage.class);

        assertTrue("Авторизация не прошла",
                page.clickEnterButton()
                        .setUserData(user)
                        .clickLoginButton()
                        .isHomePageOpen()
        );
    }

    @Test
    @DisplayName("Метод проверки авторизации через кнопку 'Войти' на странице восстановления пароля")
    @Description("Метод авторизует пользователя по сценарию через кнопку 'Войти' на странице восстановления пароля")
    public void checkLoginRecoveryPasswordPage(){
        RecoveryPasswordPage page = open(RECOVERY_PASS_PAGE_URL, RecoveryPasswordPage.class);

        assertTrue("Авторизация не прошла",
                page.clickEnterButton()
                        .setUserData(user)
                        .clickLoginButton()
                        .isHomePageOpen()
        );
    }

    @After
    public void cleanUser(){
        deleteUser(authUser(user).as(UserAuth.class));
    }
}
