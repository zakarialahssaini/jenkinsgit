package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue= {"StepDefinitions"},
        tags = "@search",
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-html-report", 
    			    "json:target/cucumber/report.json",
    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    			},
    dryRun = false, monochrome = true
)
public class TestRunner {
}