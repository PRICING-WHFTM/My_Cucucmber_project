package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames {
    public Frames() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(linkText = "Nested Frames")
    public WebElement nestedFrames;
    @FindBy(linkText = "iFrame")
    public WebElement iFrame;
    @FindBy(tagName = "p")
    public WebElement iFrameTextField;
    @FindBy(tagName = "iframe")
    public WebElement frame;


    public String textIFrame() {
        String text = iFrameTextField.getText();
        return text;
    }

}
