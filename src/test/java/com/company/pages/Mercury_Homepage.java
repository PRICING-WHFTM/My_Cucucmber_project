package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_Homepage {

    public Mercury_Homepage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(linkText = "SIGN-ON")
    public WebElement signOn;
    @FindBy(linkText = "REGISTER")
    public WebElement register;




}
