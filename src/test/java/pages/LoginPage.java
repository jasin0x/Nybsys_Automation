package pages;

import org.openqa.selenium.By;

public class LoginPage extends basePage{

    public String loginUrl = "http://13.58.91.85/#/login";
    public String homepageUrl = "http://13.58.91.85/#/home";
    public By homepageBanner = By.cssSelector("img[src='assets/image/admin-logo.png']");
    public By headingElement = By.xpath("//h5[normalize-space()='Sentra Enterprise Admin Panel']");
    public String heading = "Sentra Enterprise Admin Panel";
    public By userNameField = By.cssSelector("input[placeholder='user name']");
    public By passwordField = By.cssSelector("input[placeholder='password']");
    public By loginButton = By.cssSelector("#btnLogin");
    public By profileDropDown = By.cssSelector(".text-white.px-2");
    public By logoutButton = By.xpath("//a[normalize-space()='Logout']");

    public void login(){
        writeOnElement(userNameField,"admin@nq");
        writeOnElement(passwordField,"admin");
        clickOnElement(loginButton);
    }

}
