package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryAd {

    public EntryAd(){
        PageFactory.initElements(DriverUtil.getDriver() , this);
    }

    @FindBy(xpath = "//p[contains(text(),'Close')]")
    public WebElement close;
   @FindBy(xpath = "//a[@id='restart-ad']")
    public WebElement clickHere;


}
