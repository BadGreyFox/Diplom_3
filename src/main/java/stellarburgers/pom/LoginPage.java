package stellarburgers.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import stellarburgers.pojo.User;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailInput = $x(".//fieldset[1]//input");

    private final SelenideElement passInput = $x(".//fieldset[2]//input");;

    private final SelenideElement enterButton = $(byClassName("button_button__33qZ0"));

    private final SelenideElement recoveryPassButton = $(byText("Восстановить пароль"));

    @Step("Внесение значения в поле 'Email'")
    private LoginPage setEmail(String email){
        emailInput.click();
        emailInput.setValue(email);
        return this;
    }
    @Step("Внесение значения в поле 'Пароль'")
    private LoginPage setPass(String pass){
        passInput.click();
        passInput.setValue(pass);
        return this;
    }
    @Step("Шаг внесения данных пользователя для авторизации")
    public LoginPage setUserData(User user){
        return setEmail(user.getEmail())
                .setPass(user.getPassword());
    }
    @Step("Нажатие кнопки 'Войти' на странице авторизации")
    public HomePage clickLoginButton(){
        enterButton.click();
        return new HomePage();
    }
    @Step("Проверка нахождения на странице авторизации")
    public boolean isLoginPageOpen(){
        try{
            return recoveryPassButton
                    .shouldBe(Condition.enabled)
                    .isDisplayed();
        } catch(NoSuchElementException e){
            return false;
        }
    }
}
