package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlerts {

    public JavaScriptAlerts() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    public WebElement clickForJsAlert;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    public WebElement clickForJsConfirm;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    public WebElement clickForJsPrompt;
    @FindBy(id = "result")
    public WebElement result;


}
