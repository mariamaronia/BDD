package ge.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ge.automation.stepDefinitions","ge.automation.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html"}
)

public class RunnerClass extends AbstractTestNGCucumberTests {
}
