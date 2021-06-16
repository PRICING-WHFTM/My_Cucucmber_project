package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dropdowns {

    public Dropdowns(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }
    @FindBy(xpath = "// h3[contains(text(),'Dropdown List')]")
    public WebElement dropdownListText;
    @FindBy(id = "dropdown")
    public WebElement dropdownContainer;



}
