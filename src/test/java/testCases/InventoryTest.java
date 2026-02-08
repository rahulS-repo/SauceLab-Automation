package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import java.util.List;

public class InventoryTest extends BaseTest{
    @Test(priority = 1)
    public void verifyNameATOZSortOrder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        InventoryPage inventoryPage = new InventoryPage(this.driver);
        List<String> expectedOrder = inventoryPage.getAllProductName();
        expectedOrder = expectedOrder.stream().sorted().toList();
        inventoryPage.setSelectSort("Name (A to Z)");
        List<String> actualOrder = inventoryPage.getAllProductName();
        Assert.assertEquals(actualOrder,expectedOrder);

    }
    @Test(priority = 2)
    public void verifyPriceLowToHighSortOrder() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(this.driver);
//        loginPage.setUsername("standard_user");
//        loginPage.setPassword("secret_sauce");
//        loginPage.clickLogin();
        InventoryPage inventoryPage = new InventoryPage(this.driver);
        List<Double> expectedOrder = inventoryPage.getAllProductPrice();
        expectedOrder = expectedOrder.stream().sorted().toList();
        inventoryPage.setSelectSort("Price (low to high)");
        List<Double> actualOrder = inventoryPage.getAllProductPrice();
        Assert.assertEquals(actualOrder,expectedOrder);

    }
}
