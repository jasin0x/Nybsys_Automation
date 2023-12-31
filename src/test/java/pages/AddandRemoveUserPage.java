package pages;

import org.openqa.selenium.By;

public class AddandRemoveUserPage extends basePage{

    public String addUserPageUrl = "http://13.58.91.85/#/user-e/add";
    public By personalIdField = By.xpath("//input[@id='phoneNo']");
    public By nameField = By.xpath("//input[@id='fullName']");
    public By department = By.xpath("//select[@name='departmentID']");
    public By designation = By.xpath("//input[@name='designation']");
    public By channel = By.cssSelector("#chkUser0");
    public By chancelButton = By.cssSelector(".btn.btn-outline-primary");
    public By saveButton = By.cssSelector("#btnSave");
    public By threeDot = By.xpath("//tbody/tr[1]/td[7]/button[1]/span[1]/span[1]");
    public By removeButton = By.xpath("//span[normalize-space()='Remove']");
}
