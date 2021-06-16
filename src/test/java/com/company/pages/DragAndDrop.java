package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class DragAndDrop {

    public DragAndDrop() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id ='column-a']")
    public WebElement columnA;

    @FindBy(xpath = "//div[@id ='column-b']")
    public WebElement columnB;


}
