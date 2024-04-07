package stellarburgers.test.registration;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pojo.User;
import stellarburgers.pojo.UserAuth;

import static org.junit.Assert.assertTrue;
import static stellarburgers.api.UserApi.authUser;
import static stellarburgers.api.UserApi.deleteUser;

public class RegistrationPositiveTest extends RegistrationTest {
    @Before
    public void setUpUser(){
        user = User.create(6);
    }

    @Test
    @DisplayName("Метод проверки регистрации пользователя")
    @Description("Метод проверяет корректность завершения регистрации пользователя при указании требуемых данных регистрации")
    public void checkRegistration(){
        assertTrue("Страница авторизации не открылась",
                page.setRegistrationData(user)
                        .clickRegistrationButton()
                        .isLoginPageOpen()
        );
    }

    @After
    public void cleanUser(){
        deleteUser(authUser(user).as(UserAuth.class));
    }
}
