package com.company.pages;

import com.company.utilities.DriverUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_Register {
    Faker faker;
    public String name;
    public String lastName;
    public String email;
    public String password;

    public Mercury_Register() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='register']")
    public WebElement submitBtn;

    public void accountDetails() {
        faker = new Faker();
        name = faker.name().firstName();
        lastName = faker.name().lastName();
        email = name + lastName + "@gmail.com";
        password = name + "123";
        DriverUtil.getDriver().findElement(By.id("email")).sendKeys(email);
        DriverUtil.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        DriverUtil.getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(password);
    }


}
