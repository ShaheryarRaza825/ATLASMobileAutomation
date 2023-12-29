package StepDefinition;

import Hooks.Hook;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;

public class StepDefinition {

    Hook hook;
    public AndroidDriver driver = hook.getDriver();
    LoginPage lp = new LoginPage(driver);

    public StepDefinition() throws MalformedURLException {
    }

    @Given("user is present on {string} page")
    public void user_is_present_on(String keyword) throws Exception {
        if(keyword == "login")
        {
            lp.userIsPresentOnLoginPage();
        }
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("user enters value in {string} field")
    public void user_enters_value_in_field(String keyword) throws IOException {
        if(keyword == "email")
        {
            lp.setUserName("Email");
        }
        else if (keyword == "password")
        {
            lp.setPassword("Password");
        }
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks the {string} button")
    public void user_clicks_the_button(String keyword) {
        if(keyword == "login")
        {
            lp.loginToApp();
        }
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
