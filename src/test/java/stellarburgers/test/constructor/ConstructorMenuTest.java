package stellarburgers.test.constructor;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pom.HomePage;
import stellarburgers.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertNotEquals;
import static stellarburgers.pom.BasePage.HOME_PAGE_URL;

public class ConstructorMenuTest extends BaseTest {
    private HomePage page;
    private String expectedSectionClass;
    private String actualSectionClass;

    @Before
    public void setUpPage(){
        page = open(HOME_PAGE_URL, HomePage.class);
    }

    @Test
    @DisplayName("Метод открытия секции с Начинкой")
    @Description("Метод сравнивает класс секции до нажатия выбора самой секции и после")
    public void checkFillingSectionClick(){
        expectedSectionClass = page.getFillingSectionClass();

        actualSectionClass = page.clickOnFillingSectionButton()
                .getFillingSectionClass();

        assertNotEquals("Секция начинок не выбрана",
                expectedSectionClass,
                actualSectionClass
        );
    }
    @Test
    @DisplayName("Метод открытия секции с Соусами")
    @Description("Метод сравнивает класс секции до нажатия выбора самой секции и после")
    public void checkSauceSectionClick(){
        expectedSectionClass = page.getSauceSectionClass();

        actualSectionClass = page.clickOnSauceSectionButton()
                .getSauceSectionClass();

        assertNotEquals("Секция соусов не выбрана",
                expectedSectionClass,
                actualSectionClass
        );
    }
    @Test
    @DisplayName("Метод открытия секции с Булочками")
    @Description("Метод сравнивает класс секции до нажатия выбора самой секции и после")
    public void checkBunSectionClick(){
        expectedSectionClass = page.clickOnFillingSectionButton()
                .getBunSectionClass();

        actualSectionClass = page.clickOnBunSectionButton()
                .getBunSectionClass();

        assertNotEquals("Секция соусов не выбрана",
                expectedSectionClass,
                actualSectionClass
        );
    }

}
