package StepDefinition;

import Hooks.Hook;
import Pages.LoginPage;
import Pages.TimeOffPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;

public class StepDefinition {

    //Hook hook;
    //public AndroidDriver driver = hook.getDriver();
    TimeOffPage tp = new TimeOffPage();
    LoginPage lp = new LoginPage();

    public StepDefinition() throws MalformedURLException {
    }

    @Given("user is present on {string} page")
    public void user_is_present_on_page(String keyword) {
        System.out.println(keyword);
        if(keyword.equals("login") )
        {
            lp.userIsPresentOnLoginPage();
        }
        else if (keyword .equals("splash") )
        {
            lp.userIsPresentOnSplashScreen();
        }
        else if(keyword.equals("request timeoff"))
        {
            //tp.UserIsPresentOnPTOPage();
        }
    }

    @Given("user enters value in {string} field")
    public void user_enters_value_in_field(String keyword) throws IOException {
        if(keyword.equals("email"))
        {
            lp.setUserName("Email");
        }
        else if (keyword.equals("password"))
        {
            lp.setPassword("Password");
        }
        else if(keyword.equals("add hours"))
        {
           // tp.EnterHours();
        }
        else if(keyword.equals("comments"))
        {
            //tp.enterCommentsForPTO();
        }
    }
    @When("user clicks the {string} button")
    public void user_clicks_the_button(String keyword) {
        if(keyword.equals("login") )
        {
            lp.loginToApp();
        }
        else if(keyword.equals("loginSplash") )
        {
            lp.SplashScreenLogin();
        }
        else if(keyword.equals("request timeoff")){
           tp.UserNavigateToPTOPage();
        }
        else if(keyword.equals("add hours")){
            //tp.UserVisitAddHoursPage();
        }
        else if(keyword.equals("save")){
           // tp.UserSavesHours();
        }
        else if(keyword.equals("submit")){
         //   tp.UserSubmitsPTO();
        }
    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        lp.verifyUserLoggedIn();
    }

    @And("user selects option for {string}")
    public void userSelectsOptionFor(String keyword) {
        if(keyword.equals("PTO"))
        {
            //tp.UserSelectsTimeOffType();
        }
        else if(keyword.equals("FromDate"))
        {
           // tp.UserSelectsFromDate();
        }
        else if(keyword.equals("ToDate"))
        {
            //tp.UserSelectsToDate();
        }
    }

    @Then("PTO should be submitted successfully")
    public void ptoShouldBeSubmittedSuccessfully() {

    }
}
