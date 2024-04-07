package stellarburgers.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {

    private final SelenideElement constructButton = $x(".//nav/*[1]//*[@href='/']");

    private final SelenideElement logoButton = $x(".//nav/*[2]//*[@href='/']");

    private final SelenideElement logoutButton = $(byText("Выход"));

    public boolean isProfileButtonDisplayed(){
       return logoutButton.shouldBe(Condition.enabled, Duration.ofSeconds(3)).isDisplayed();
    }
    public HomePage clickConstructButton(){
        constructButton.click();
        return new HomePage();
    }
    public HomePage clickLogoButton(){
        logoButton.click();
        return new HomePage();
    }
    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }
}
