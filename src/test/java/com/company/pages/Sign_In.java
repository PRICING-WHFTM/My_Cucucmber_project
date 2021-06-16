package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_In {


    public Sign_In() {
        PageFactory.initElements(DriverUtil.getDriver(), this);

    }

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement submitBtn;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submitBtn.click();
    }


}
