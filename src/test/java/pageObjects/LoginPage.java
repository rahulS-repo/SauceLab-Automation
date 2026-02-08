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
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement textError;

    public void setUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void setPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void clickLogin(){
        buttonLogin.click();
    }
    public String getErrorText(){
        return textError.getText();
    }
}
