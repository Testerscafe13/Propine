import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class dataLocatos {


    public static By FilterSearch = By.xpath("//input[@id='filter']");
    public static String baseurl ="https://vast-dawn-73245.herokuapp.com/";
    //
    public static By verifyingText = By.xpath("//label[text()='Date']");
    public static By btnNewRequest = By.xpath("//a[@title='New']");
    public static By enterDate = By.cssSelector("input.form-control");
    public static By BtnSubmit=By.cssSelector("input[type='Submit']");




    public static void open_broswer() {
        WebDriver driver;
        Configuration.fastSetValue = true;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        System.out.println("Starting Chrome browser");
        ChromeDriverManager.chromedriver().version("80").setup();
        Configuration.browser = WebDriverRunner.CHROME;
        ChromeOptions chromeOptions = new ChromeOptions();

        //Disable Notification in chrome
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    public static void closeBrowser(){
        WebDriverRunner.getWebDriver().quit();
    }

}
