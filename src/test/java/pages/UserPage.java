package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class UserPage extends basePage{

    public By userManagementDropdown = By.xpath("//span[normalize-space()='User Management']");
    public By user = By.cssSelector("a[title='User']");
    public String userpageUrl = "http://13.58.91.85/#/user-e";
    public By addNewButton = By.xpath("//button[normalize-space()='Add New']");
    public By nameSearchField = By.cssSelector("input[placeholder='Name']");
    public By personalIdSeachField = By.xpath("//input[@placeholder='Personal ID']");
    public By selectRoleDropdown = By.cssSelector("select[name='srcUserRoleId']");
    public By searchButton = By.xpath("//button[normalize-space()='Search']");
    public By rowNumber = By.xpath("//td[normalize-space()='1']");


    public void visitUserPage() throws InterruptedException {
        clickOnElement(userManagementDropdown);
        Thread.sleep(4000);
        clickOnElement(user);

    }

}
