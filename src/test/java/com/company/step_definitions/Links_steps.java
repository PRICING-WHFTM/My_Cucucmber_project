package com.company.step_definitions;

import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Links_steps {

    private List<WebElement> bolmelerLinks;


    @Given("I am in lentaz homepage")
    public void i_am_in_lentaz_homepage() {
        DriverUtil.getDriver().get("https://lent.az/");
        Assert.assertTrue(DriverUtil.getDriver().getTitle().toLowerCase().contains("lent.az"));
    }

    @Then("I should see all links in the entire page")
    public void i_should_see_all_links_in_the_entire_page() {
        List<WebElement> allLinks = DriverUtil.getDriver().findElements(By.tagName("a"));
        System.out.println(" All links count in a whole page is " + allLinks.size());
//        for (WebElement link : allLinks) {
//            System.out.println(link.getText());
//        }
    }

    @Then("I should see {int} links there")
    public void i_should_see_links_there(int int1) {
        bolmelerLinks = DriverUtil.getDriver().findElements(By.cssSelector(".footer_main>:nth-child(1)>li>a"));
        Assert.assertEquals(bolmelerLinks.size(), int1);
        for (int i = 0; i < bolmelerLinks.size(); i++) {
            System.out.println(bolmelerLinks.get(i).getText());
        }
    }

    @Then("Following links should exist there")
    public void following_links_should_exist_there(List<String> dataTable) {
        // Creating another List which contains only names of Links but not WebElements.
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        List<String> footerLinkNames = new ArrayList<>();
        for (WebElement link : bolmelerLinks) {
            footerLinkNames.add(link.getText());
        }
        Assert.assertTrue(footerLinkNames.containsAll(dataTable));
    }
}