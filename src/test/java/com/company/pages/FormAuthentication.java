package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthentication {
    public FormAuthentication() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(css = "input[id='username']")
    public WebElement username;
    @FindBy(css = "input[name='password']")
    public WebElement password;
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    public WebElement login;
    @FindBy(xpath = "//i[contains(text(),'Logout')]")
    public WebElement logout;


}
