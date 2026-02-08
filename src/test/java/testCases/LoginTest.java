package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseTest{

    @Test(groups = {"Sanity"}, dataProvider = "login_dp", dataProviderClass = DataProviders.class)
    public void verifyLogin(String username, String password, String credStatus) throws InterruptedException {
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        InventoryPage inventoryPage = new InventoryPage(this.driver);
        if(credStatus.equals("valid")){
            if(inventoryPage.getPageTitle().equals("Products")){
                inventoryPage.clickMenu();
                Thread.sleep(4000);
                inventoryPage.clickLogout();
                Assert.assertTrue(true);
            }else{
                Assert.fail("Login failed for valid credentials");
            }
        } else if (credStatus.equals("invalid")) {
            Assert.assertEquals(loginPage.getErrorText(),"Epic sadface: Sorry, this user has been locked out.");
        }
    }
}
