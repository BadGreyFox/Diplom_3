package stellarburgers.pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPasswordPage {
    private final SelenideElement enterButton = $(byText("Войти"));

    @Step("Нажатие кнопки 'Войти' на странице восстановления пароля")
    public LoginPage clickEnterButton(){
        enterButton.click();
        return new LoginPage();
    }
}
