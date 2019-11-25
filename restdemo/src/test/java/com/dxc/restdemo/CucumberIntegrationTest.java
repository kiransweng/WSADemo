package com.dxc.restdemo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by vkuma26 on 8/26/19.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"com.dxc.restdemo.stepdefinitions"},
    tags = {"not @ignore", "not @wip"},
    plugin = {
        "pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "rerun:target/cucumber-api-rerun.txt"
    })
public class CucumberIntegrationTest extends AbstractTestNGCucumberTests{

}
