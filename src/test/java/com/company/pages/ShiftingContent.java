package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShiftingContent {

    public ShiftingContent (){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(linkText = "Example 1: Menu Element")
    public WebElement example1;



}
