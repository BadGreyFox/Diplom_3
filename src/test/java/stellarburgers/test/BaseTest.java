package stellarburgers.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        setWebDriver(driver);
    }
    @After
    public void tearDown(){
        driver.manage().deleteAllCookies(); //Чистим все куки перед выходом
        driver.quit();
    }
    //фектори-метод для добавления требуемого браузера
    private WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }
}
