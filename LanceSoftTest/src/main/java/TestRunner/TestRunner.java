package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"features"},
        glue = "StepDefinition",
        tags = {"@Subtraction, @Division, @CE"})


public class TestRunner extends AbstractTestNGCucumberTests{}
