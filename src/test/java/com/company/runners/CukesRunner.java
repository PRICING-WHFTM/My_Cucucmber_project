package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //path from repository root
        glue = "com/company/step_definitions",  //path from source root
        monochrome = true,
        strict = true,
        dryRun = false,
        tags = {"not @ignore"},    //always comment out after running by tags
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"})


public class CukesRunner {


}
