package testcases;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DataSet;
import utilities.DriverSetup;
import pages.LoginPage;

public class loginPage_test extends DriverSetup {

    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void getToTheUrl(){
        getDriver().get(loginPage.loginUrl);
    }

    @Test(priority = 1)
    @Description("Visiting the login page")
    public void checkHeading(){
        loginPage.addScreenShot("After visiting the admin panel URL");
        Assert.assertEquals(loginPage.getElementText(loginPage.headingElement),loginPage.heading);
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataSet.class,priority = 2)
    @Description("Login attempt with wrong credentials")
    public void loginWithWrongCredentials(String username, String password, String url){
        loginPage.writeOnElement(loginPage.userNameField,username);
        loginPage.writeOnElement(loginPage.passwordField,password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.addScreenShot("After invalid login attempt");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginUrl);
    }

    @Test(priority = 3)
    @Description("Testing login functionality with valid credentials")
    public void loginWithValidCredential() throws InterruptedException {
        loginPage.writeOnElement(loginPage.userNameField,"admin@nq");
        loginPage.writeOnElement(loginPage.passwordField,"admin");
        loginPage.clickOnElement(loginPage.loginButton);
        //loginPage.login();
        loginPage.waitforElementPresence(loginPage.homepageBanner);
        loginPage.addScreenShot("Home page after login");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.homepageUrl);
    }

    @Test(priority = 4)
    @Description("Testing logout functionality")
    public void logoutTest() throws InterruptedException {
        Thread.sleep(5000);
        loginPage.clickOnElement(loginPage.profileDropDown);
        loginPage.clickOnElement(loginPage.logoutButton);
        loginPage.addScreenShot("After clicking on logout");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginUrl);
    }


}
