package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUpload {

    public FileUpload() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(css = "input[id='file-upload']")
    public WebElement chooseFile;

    @FindBy(css = "input[class='button']")
    public WebElement uploadButton;

    public String confirmationMessage() {
        String text = DriverUtil.getDriver().
                findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText();
        return text;
    }


}
