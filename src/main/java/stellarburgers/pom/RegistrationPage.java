package stellarburgers.pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import stellarburgers.pojo.User;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final SelenideElement nameInput = $x(".//fieldset[1]//input");

    private final SelenideElement emailInput = $x(".//fieldset[2]//input");

    private final SelenideElement passInput = $x(".//fieldset[3]//input");

    private final SelenideElement regButton = $(byText("Зарегистрироваться"));

    private final SelenideElement enterButton = $(byText("Войти"));

    private final SelenideElement passHidesButton = $(byClassName("input__icon"));

    private final SelenideElement passLengthError = $(byClassName("input__error"));

    @Step("Внесение значения в поле 'Имя'")
    private RegistrationPage setName(String name){
        nameInput.click();
        nameInput.setValue(name);
        return this;
    }
    @Step("Внесение значения в поле 'Email'")
    private RegistrationPage setEmail(String email){
        emailInput.click();
        emailInput.setValue(email);
        return this;
    }
    @Step("Внесение значения в поле 'Пароль'")
    private void setPass(String pass){
        passInput.click();
        passInput.setValue(pass);
    }
    @Step("Шаг внесения данных пользователя для регистрации")
    public RegistrationPage setRegistrationData(User user){
        setName(user.getName())
                .setEmail(user.getEmail())
                .setPass(user.getPassword());
        return this;
    }
    @Step("Нажатие кнопки 'Регистрация'")
    public LoginPage clickRegistrationButton(){
        regButton.click();
        return new LoginPage();
    }
    @Step("Нажатие кнопки открытия пароля")
    public RegistrationPage clickPasswordHidesButton(){
        passHidesButton.click();
        return this;
    }
    @Step("Проверка на скрытие пароля")
    public boolean isPasswordHidden(){
        String type = passInput.getAttribute("type");
        return Objects.equals(type, "password");
    }
    @Step("Проверка отображения ошибки длинны пароля")
    public boolean isPasswordErrorDisplayed(){
        return passLengthError.isDisplayed();
    }
    @Step("Нажатие кнопки 'Войти' на странице регистрации")
    public LoginPage clickEnterButton(){
        enterButton.click();
        return new LoginPage();
    }
}
