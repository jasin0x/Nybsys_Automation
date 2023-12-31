package testcases;

import jdk.jfr.Description;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddandRemoveUserPage;
import pages.LoginPage;
import pages.UserPage;
import utilities.DriverSetup;

public class addRemoveUser_test extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    UserPage userPage = new UserPage();
    AddandRemoveUserPage addandRemoveUserPage = new AddandRemoveUserPage();
    @BeforeClass
    public void gotToUserPage() throws InterruptedException {
        getDriver().get(loginPage.loginUrl);
        loginPage.login();
        userPage.visitUserPage();
    }

    @Test(priority = 1)
    @Description("Checking functionality off +Add User button")
    public void clickOnAddUser() throws InterruptedException {
        Thread.sleep(5000);
        addandRemoveUserPage.clickOnElement(userPage.addNewButton);
        addandRemoveUserPage.addScreenShot("After clicking on Add New button");
        Assert.assertEquals(getDriver().getCurrentUrl(), addandRemoveUserPage.addUserPageUrl);
    }

    @Test(priority = 2)
    @Description("System does not Create user without filling up the mandatory field")
    public void createUserWithoutInfo() throws InterruptedException {
        addandRemoveUserPage.scrolltoElement(addandRemoveUserPage.saveButton);
        addandRemoveUserPage.addScreenShot("Save button is clickable or not");
        boolean buttonClickable = addandRemoveUserPage.isElementClickable(addandRemoveUserPage.saveButton);
        Assert.assertFalse(buttonClickable);
    }

    @Test(priority = 3)
    @Description("Create user by filling up the mandatory fields")
    public void createUser() throws InterruptedException {
        addandRemoveUserPage.writeOnElement(addandRemoveUserPage.nameField,"Kabul");
        addandRemoveUserPage.writeOnElement(addandRemoveUserPage.personalIdField,"88554");
        Select selectDropdown = new Select(addandRemoveUserPage.getElement(addandRemoveUserPage.department));
        selectDropdown.selectByVisibleText("QA");
        addandRemoveUserPage.writeOnElement(addandRemoveUserPage.designation,"Junior QA");
        //addUserPage.clickOnElement(addUserPage.channel);
        addandRemoveUserPage.addScreenShot("Filling up the mandatory fields");
        addandRemoveUserPage.scrolltoElement(addandRemoveUserPage.saveButton);
        addandRemoveUserPage.clickOnElement(addandRemoveUserPage.saveButton);
        addandRemoveUserPage.addScreenShot("After Creating user");
        Thread.sleep(4000);
        Assert.assertEquals(getDriver().getCurrentUrl(),userPage.userpageUrl);
    }

    @Test(priority = 4)
    @Description("Remove the user")
    public void removeUser() throws InterruptedException {
        Thread.sleep(5000);
        addandRemoveUserPage.clickOnElement(addandRemoveUserPage.threeDot);
        addandRemoveUserPage.clickOnElement(addandRemoveUserPage.removeButton);
        addandRemoveUserPage.addScreenShot("After Removing user");

    }


}
