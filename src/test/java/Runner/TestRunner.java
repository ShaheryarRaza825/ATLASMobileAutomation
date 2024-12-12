package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =
        {
                "src/test/resources/Features/001b-LoginFeature.feature",
                //"src/test/resources/Features/006-MoreTab.feature"
                "src/test/resources/Features/002-ClockIn.feature",
        /*"src/test/resources/Features/003-TimeoffFeature.feature",
                "src/test/resources/Features/004-Timesheet.feature",
                "src/test/resources/Features/005-ExpenseRequestorFeature.feature",
                "src/test/resources/Features/007-Clockout.feature",*/
                //"src/test/resources/Features/OnboardingUser.feature"
                },
        glue ={"Hooks","StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true)

public class TestRunner {
}
