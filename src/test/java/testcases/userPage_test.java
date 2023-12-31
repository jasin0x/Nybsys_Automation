package testcases;

import jdk.jfr.Description;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;
import utilities.DriverSetup;

public class userPage_test extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    UserPage userPage = new UserPage();
    @BeforeClass
    public void doLogin(){
        getDriver().get(loginPage.loginUrl);
        loginPage.login();
    }

    @Test(priority = 1)
    @Description("Visiting the user page")
    public void goToUserPage() throws InterruptedException {
        userPage.visitUserPage();
        Thread.sleep(10000);
        userPage.addScreenShot("Visiting user page");
        Assert.assertEquals(getDriver().getCurrentUrl(),userPage.userpageUrl);
    }

    @Test(priority = 2)
    @Description("Checking the presence of +Add new button")
    public void addNewButtonPresence(){
        boolean buttonPresence = userPage.isElementVisible(userPage.addNewButton);
        userPage.addScreenShot("Checking the presence of Add New button");
        Assert.assertTrue(buttonPresence);
    }

    @Test(priority = 3)
    @Description("Searching user by user name who is present in the system")
    public void searchRealUser() throws InterruptedException {
        userPage.writeOnElement(userPage.nameSearchField,"Abdul Karim");
        Select selectDropdown = new Select(userPage.getElement(userPage.selectRoleDropdown));
        selectDropdown.selectByVisibleText("Participant");
        userPage.clickOnElement(userPage.searchButton);
        Thread.sleep(5000);
        userPage.addScreenShot("Result after searching with valid Name");
        String rowNumber = userPage.getElementText(userPage.rowNumber);
        Assert.assertEquals(rowNumber,"1");
    }

    @Test(priority = 4)
    @Description("Searching user by user name who is Not Present in the system")
    public void searchUnrealUser() throws InterruptedException {
        userPage.writeOnElement(userPage.nameSearchField,"HHJJ KKII");
        Select selectDropdown = new Select(userPage.getElement(userPage.selectRoleDropdown));
        selectDropdown.selectByVisibleText("Participant");
        userPage.clickOnElement(userPage.searchButton);
        Thread.sleep(5000);
        userPage.addScreenShot("Result after searching with Invalid Name");
        boolean found = userPage.isElementVisible(userPage.rowNumber);
        userPage.writeOnElement(userPage.nameSearchField,"");
        Assert.assertFalse(found);
        userPage.writeOnElement(userPage.nameSearchField,"");
    }

    @Test(priority = 5)
    @Description("Searching user by Personal ID who is present in the system")
    public void searchByRealdID() throws InterruptedException {
        userPage.writeOnElement(userPage.personalIdSeachField,"88554");
        Select selectDropdown = new Select(userPage.getElement(userPage.selectRoleDropdown));
        selectDropdown.selectByVisibleText("Participant");
        userPage.clickOnElement(userPage.searchButton);
        userPage.addScreenShot("Result after searching with Personal ID");
        Thread.sleep(5000);
        String rowNumber = userPage.getElementText(userPage.rowNumber);
        Assert.assertEquals(rowNumber,"1");
    }



}
