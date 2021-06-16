package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//div[@id='flash']")
    public WebElement textField;

    public String flashMessage() {
        return textField.getText();
    }


}
