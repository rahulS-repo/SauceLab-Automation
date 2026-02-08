package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement buttonMenu;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement linkLogout;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectSort;
    @FindBy(xpath="//*[@class='inventory_item_name ']")
    private List<WebElement> inventoryItemListName;
    @FindBy(xpath="//*[@class='inventory_item_price']")
    private List<WebElement> inventoryItemListPrice;
    public String getPageTitle(){
        return pageTitle.getText();
    }
    public void clickMenu(){
        buttonMenu.click();
    }
    public void clickLogout(){
        linkLogout.click();
    }
    public void setSelectSort(String sort) throws InterruptedException {
        selectSort.click();
        Thread.sleep(3000);
        Select selectSortOptions = new Select(selectSort);
//        selectSortOptions.getOptions().forEach(element->System.out.println(element.getText()));
        selectSortOptions.selectByVisibleText(sort);
    }
    public List<String> getAllProductName(){
        List<String> inventoryItem = new ArrayList<>();
        for(WebElement element: inventoryItemListName){
            inventoryItem.add(element.getText());
        }
        return inventoryItem;
    }
    public List<Double> getAllProductPrice(){
        List<Double> inventoryItem = new ArrayList<>();
        for(WebElement element: inventoryItemListPrice){
            inventoryItem.add(Double.valueOf(element.getText().replace("$","")));
        }
        return inventoryItem;
    }
}
