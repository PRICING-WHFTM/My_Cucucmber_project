package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenu {

    public ContextMenu () {
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(css = "#hot-spot")
    public WebElement square;




}
