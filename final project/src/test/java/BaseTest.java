import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

public class BaseTest {

    private static WebDriver driver;
    protected static BasePage mainPage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.careercenter.am/en");
        driver.manage().window().maximize();

        mainPage = new BasePage(driver);
    }

    @AfterClass
    public static void tearDown(){
//        driver.quit();
    }
}
