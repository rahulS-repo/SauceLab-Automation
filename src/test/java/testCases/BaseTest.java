package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser){
        switch (browser.toLowerCase()){
            case "chrome": {
                ChromeOptions options = getChromeOptions();
                this.driver = new ChromeDriver(options); break;
            }
            case "edge": this.driver = new EdgeDriver(); break;
            default:
                System.out.println("Invalid browser requested"); return;
        }
        this.driver.get("https://www.saucedemo.com/");
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
// 1. Create a map to store preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
// 2. Disable the password manager and the "leak detection" prompt
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
// 3. Add preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);
// 4. (Optional) Disable other browser-level popups/notifications
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
}
