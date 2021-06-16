package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
    public ForgotPassword() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(id = "content")
    public WebElement contentTestField;

    public String contentMessage() {
        return contentTestField.getText();
    }
}
