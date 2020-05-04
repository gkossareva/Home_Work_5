package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractBasePage{

    @FindBy(id = "prependedInput")
    private WebElement userName;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement loginBtn;

    public void login() {
        BrowserUtilities.wait(2);
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
       // loginBtn.click();
    }

    public void login(String usernameValue, String passwordValue) {
        BrowserUtilities.wait(2);
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        loginBtn.click();


    }

}
