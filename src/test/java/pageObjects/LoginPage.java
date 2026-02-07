package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement buttonLogin;

    public void setUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void setPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void clickLogin(){
        buttonLogin.click();
    }
}
