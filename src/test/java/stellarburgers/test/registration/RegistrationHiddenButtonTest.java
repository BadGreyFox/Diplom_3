package stellarburgers.test.registration;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationHiddenButtonTest extends RegistrationTest {
    @Test
    @DisplayName("Метод проверки скрытия пароля на странице регистрации")
    @Description("Метод проверяет закрыт ли пароль по-умолчанию")
    public void checkButtonHidesPassword(){
        assertTrue("Пароль не скрыт",
                page.isPasswordHidden()
        );
    }

    @Test
    @DisplayName("Метод проверки кнопки открытия пароля на странице регистрации")
    @Description("Метод проверяет открывается ли пароль после нажатия кнопки")
    public void checkButtonShowPassword(){
        assertFalse("Пароль не открыт",
                page.clickPasswordHidesButton()
                        .isPasswordHidden()
        );
    }
}
