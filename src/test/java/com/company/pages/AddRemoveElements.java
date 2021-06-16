package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElements {

    public AddRemoveElements() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Element')]")
    public WebElement addElement;

    @FindBy(xpath = "//button[@class='added-manually']")
    public WebElement deleteElement;


}
