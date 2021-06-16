package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Heroku_Homepage {

    public Heroku_Homepage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(linkText = "Add/Remove Elements")
    public WebElement add_Remove_Elements;
    @FindBy(xpath = "//a[contains(text(),'Basic Auth')]")
    public WebElement basicAuth;
    @FindBy(linkText = "Checkboxes")
    public WebElement checkboxes;
    @FindBy(linkText = "Context Menu")
    public WebElement contextMenuModule;
    @FindBy(linkText = "Disappearing Elements")
    public WebElement disappearingElementsModule;
    @FindBy(linkText = "Drag and Drop")
    public WebElement dragAndDropModule;
    @FindBy(linkText = "Dropdown")
    public WebElement dropdownsModule;
    @FindBy(linkText = "Dynamic Controls")
    public WebElement dynamicControlsModule;
    @FindBy(linkText = "Entry Ad")
    public WebElement entryAd;
    @FindBy(linkText = "File Download")
    public WebElement downloadFile;
    @FindBy(linkText = "File Upload")
    public WebElement uploadFile;
    @FindBy(linkText = "Form Authentication")
    public WebElement formAuthentication;
    @FindBy(linkText = "Frames")
    public WebElement frames;
    @FindBy(linkText = "Hovers")
    public WebElement hovers;
    @FindBy(linkText = "JQuery UI Menus")
    public WebElement jQuery;
    @FindBy(linkText = "Inputs")
    public WebElement inputs;
    @FindBy(linkText = "Dynamic Loading")
    public WebElement dynamicLoad;
    @FindBy(linkText = "JavaScript Alerts")
    public WebElement javaScriptAlerts;
    @FindBy(linkText = "Forgot Password")
    public WebElement forgotPassword;
    @FindBy(linkText = "Shifting Content")
    public WebElement shiftingContent;
    @FindBy(linkText = "Shadow DOM")
    public WebElement shadowDOM;
}
