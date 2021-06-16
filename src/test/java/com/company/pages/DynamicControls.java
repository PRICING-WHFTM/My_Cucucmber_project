package com.company.pages;

import com.company.utilities.DriverUtil;
import io.cucumber.java.bs.I;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControls {

    public DynamicControls() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Enable')]  ")
    public WebElement enableBtn;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement editBox;

    @FindBy(id = "message")
    public WebElement message;

    public String enableText() {
        String text = message.getText();
        return text;
    }

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement addBtn;
    @FindBy(id = "checkbox")
    public WebElement checkBox;

}
