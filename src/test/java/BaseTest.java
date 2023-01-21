import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        //запуск Chrome
        //WebDriverManager.chromedriver().setup();
        //webDriver = new ChromeDriver();

        //запуск Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\bin\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + "\\driver\\");
        webDriver = new FirefoxDriver();

        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @After
    public void clearData() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
