package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleTranslator {

    public GoogleTranslator() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='source-language']")
    public WebElement fromLanguage;
    @FindBy(xpath = "//span[@class='target-language']")
    public WebElement toLanguage;
    @FindBy(id = "tw-source-text-ta")
    public WebElement fromTextArea;
    @FindBy(xpath = "//div[@id='tw-target-text-container']//pre//span")
    public WebElement outputText;
    @FindBy(className = "language_list_item")
    public List<WebElement> allLanguages;


    public void selectLanguage(String language) {
        for (WebElement lang : allLanguages) {
            if (lang.getText().equals(language)) {
                lang.click();
            }
        }
    }


}

