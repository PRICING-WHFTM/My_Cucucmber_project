package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElements {

    public DisappearingElements() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(linkText = "About")
    public WebElement about;

}
