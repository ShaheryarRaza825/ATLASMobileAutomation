package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/001-LoginFeature.feature","src/test/resources/Features/005-ExpenseRequestorFeature.feature"},
        glue ={"Hooks","StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true)

public class Runner {
}
