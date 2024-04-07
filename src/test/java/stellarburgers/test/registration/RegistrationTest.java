package stellarburgers.test.registration;

import org.junit.Before;
import stellarburgers.pojo.User;
import stellarburgers.pom.RegistrationPage;
import stellarburgers.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static stellarburgers.pom.BasePage.REG_PAGE_PATH;

public abstract class RegistrationTest extends BaseTest {
    protected RegistrationPage page;
    protected User user;

    @Before
    public void setUpPage(){
        page = open(REG_PAGE_PATH, RegistrationPage.class);
    }
}
