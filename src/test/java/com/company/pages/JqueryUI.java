package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JqueryUI {
    public JqueryUI() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(linkText = "Enabled")
    public WebElement enabled;
    @FindBy(linkText = "Downloads")
    public WebElement downloads;
}
