package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser){
        switch (browser.toLowerCase()){
            case "chrome": this.driver = new ChromeDriver(); break;
            case "edge": this.driver = new EdgeDriver(); break;
            default:
                System.out.println("Invalid browser requested"); return;
        }


    }
}
