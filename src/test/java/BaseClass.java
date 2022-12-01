import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    WebDriver driver;
    public String baseURL = "https://www.amazon.in/";

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
