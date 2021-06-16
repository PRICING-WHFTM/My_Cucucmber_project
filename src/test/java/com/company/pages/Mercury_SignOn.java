package com.company.pages;

import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_SignOn {

    public Mercury_SignOn() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='login']")
    public WebElement submitBtn;
    @FindBy(xpath = "//input[@name='userName']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    public void logIn(){
        userName.sendKeys(ConfigReader.getProperty("mercurylogin"));
        password.sendKeys(ConfigReader.getProperty("mercurypassword"));
    }

}
