package stellarburgers.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage{
    private final SelenideElement accountButton = $x(".//*[@href='/account']");

    private final SelenideElement authButton = $(byText("Войти в аккаунт"));

    private final ElementsCollection constructorSections = $$x(".//*[@class='text text_type_main-default']/parent::div");


    @Step("Нажатие кнопки 'Личный кабинет' на домашней странице (неавторизованный пользователь)")
    public LoginPage clickAccountUpper(){
        accountButton.click();
        return new LoginPage();
    }
    @Step("Нажатие кнопки 'Личный кабинет' на домашней странице (авторизованный пользователь)")
    public AccountPage clickAccountUpperAuthUser(){
        accountButton.click();
        return new AccountPage();
    }
    @Step("Нажатие кнопки 'Войти в аккаунт' на домашней странице")
    public LoginPage clickAccountBottom(){
        authButton.click();
        return new LoginPage();
    }
    @Step("Проверка нахождения на домашней странице")
    public boolean isHomePageOpen(){
        try{
            return constructorSections.get(0)
                    .shouldBe(Condition.enabled)
                    .isEnabled();
        } catch(NoSuchElementException e){
            return false;
        }
    }
    private String getSectionClass(int i){
        return constructorSections.get(i).getAttribute("class");
    }
    @Step("Получение статуса секции Булочек")
    public String getBunSectionClass(){
        return getSectionClass(0);
    }
    @Step("Получение статуса секции Соусов")
    public String getSauceSectionClass(){
        return getSectionClass(1);
    }
    @Step("Получение статуса секции Начинки")
    public String getFillingSectionClass(){
        return getSectionClass(2);
    }

    private HomePage clickOnSection(int i){
        constructorSections.get(i).click();
        return this;
    }
    @Step("Нажатие на кнопку меню 'Булочки'")
    public HomePage clickOnBunSectionButton(){
        return clickOnSection(0);
    }
    @Step("Нажатие на кнопку меню 'Соусы'")
    public HomePage clickOnSauceSectionButton(){
        return clickOnSection(1);
    }
    @Step("Нажатие на кнопку меню 'Начинка'")
    public HomePage clickOnFillingSectionButton(){
        return clickOnSection(2);
    }
}
