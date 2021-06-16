package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hovers {

    public Hovers() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']//div[1]//img[1]")
    public WebElement image1;
    @FindBy(xpath = "//div[@class='row']//div[2]//img[1]")
    public WebElement image2;
    @FindBy(xpath = "//div[3]//img[1]")
    public WebElement image3;

    public String user1Text () {
        WebElement element=DriverUtil.getDriver().
                findElement(By.xpath("//div[@class='example']//div[1]//div[1]//h5[1]"));
        return  element.getText();
    }
    public String user2Text () {
        WebElement element=DriverUtil.getDriver().
                findElement(By.xpath("//div[@class='row']//div[2]//div[1]//h5[1]"));
        return  element.getText();
    }
    public String user3Text () {
        WebElement element=DriverUtil.getDriver().
                findElement(By.xpath("//div[3]//div[1]//h5[1]"));
        return  element.getText();
    }



}