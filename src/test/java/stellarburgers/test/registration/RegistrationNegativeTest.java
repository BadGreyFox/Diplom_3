package stellarburgers.test.registration;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pojo.User;

import static org.junit.Assert.assertTrue;

public class RegistrationNegativeTest extends RegistrationTest{
    @Before
    public void setUpUser(){
        user = User.create(5);
    }

    @Test
    @DisplayName("Метод проверки отображения ошибки длины пароля при регистрации")
    @Description("Метод проверяет отображается ли ошибка длины пароля, когда он указан меньше 6-и символов")
    public void checkRegistration(){
        page.setRegistrationData(user)
                .clickRegistrationButton();

        assertTrue("Ошибка некорректного пароля не отобразилась",
                page.isPasswordErrorDisplayed()
        );
    }
}
