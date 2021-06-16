package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoading {

    public DynamicLoading() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Example 2: Element rendered after the fact']")
    public WebElement example2;
    @FindBy(xpath = "//button[contains(text(),'Start')]")
    public WebElement start;
    @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
    public WebElement helloWorld;

    public String helloWorldText() {
        return helloWorld.getText();
    }
}
