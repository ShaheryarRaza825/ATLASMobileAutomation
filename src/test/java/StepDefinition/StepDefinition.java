package StepDefinition;

import Hooks.Hook;
import Pages.*;
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
    TimerWidgetPage twp = new TimerWidgetPage();
    TimesheetPage tsp = new TimesheetPage();
    ExpenseRequestorPage erp = new ExpenseRequestorPage();

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
        else if(keyword.equals("dashboard"))
        {
            twp.userOnDashboard();
        }
        else if(keyword.equals("request timeoff"))
        {
            tp.UserIsPresentOnPTOPage();
        }
        else if(keyword.equals("timesheet"))
        {
            tsp.userIsPresentOnTimesheet();
        }
        else if(keyword.equals("edit timesheet"))
        {
            tsp.userPresentOnEditTimesheet();
        }
        else if(keyword.equals("expense dashboard"))
        {
            erp.userPresentOnExpensePage();
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
        else if(keyword.equals("hours"))
        {
            tp.EnterHours("Hours1","Hours2");
        }
        else if(keyword.equals("PTOcomments"))
        {
            tp.enterCommentsForPTO();
        }
        else if(keyword.equals("expense title"))
        {
            erp.enterExpenseTitle();
        }
        else if(keyword.equals("amount"))
        {
            erp.enterAmount();
        }
        else if(keyword.equals("VAT"))
        {
            erp.enterVAT();
        }
        else if(keyword.equals("Exp comments"))
        {
            erp.enterComments();
        }
    }
    @When("user clicks the {string} button")
    public void user_clicks_the_button(String keyword) throws InterruptedException {
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
            tp.UserVisitAddHoursPage();
        }
        else if(keyword.equals("save")){
            tp.UserSavesHours();
        }
        else if(keyword.equals("submit")){
            tp.UserSubmitsPTO();
        }
        else if(keyword.equals("clockin"))
        {
            twp.UserClocksIn();
        }
        else if(keyword.equals("clockout"))
        {
            twp.UserClocksOut();
        }
        else if(keyword.equals("timesheet tab"))
        {
            tsp.navigateToTimesheetTab();
        }
        else if(keyword.equals("timesheet arrow"))
        {
            tsp.openTimeSheetList();
        }
        else if(keyword.equals("edit timesheet"))
        {
            tsp.editTimesheet();
        }
        else if(keyword.equals("update"))
        {
            tsp.updatTime();
        }
        else if(keyword.equals("expenses tab"))
        {
            erp.navigateToExpenseTab();
        }
        else if(keyword.equals("new expense claim"))
        {
            erp.createNewExpense();
        }
        else if(keyword.equals("save continue"))
        {
            erp.clickSaveAndContinue();
        }
        else if(keyword.equals("submit expense"))
        {
            erp.submitExpense();
        }

    }

    @And("user selects option for {string}")
    public void userSelectsOptionFor(String keyword) throws MalformedURLException {
        if (keyword.equals("PTO")) {
            tp.UserSelectsTimeOffType();
        } else if (keyword.equals("FromDate")) {
            tp.UserSelectsFromDate();
        } else if (keyword.equals("ToDate")) {
            tp.UserSelectsToDate();
        } else if (keyword.equals("start time")) {
            tsp.selectStartTime();
        } else if (keyword.equals("end time")) {
            tsp.selectEndTime();
        }
        else if(keyword.equals("date incurred")){
            erp.selectDateIncurred();
        }
        else if(keyword.equals("category")){
            erp.selectCategory();
        }
        else if(keyword.equals("attachment")){
            erp.selectAttachment();
        }
    }

    @Then("PTO should be submitted successfully")
    public void ptoShouldBeSubmittedSuccessfully() {
        tp.ConfirmSubmissionOfPTO();
    }
    @Then("user should be {string} successfully")
    public void userShouldBeSuccessfully(String keyword) throws InterruptedException {

        if(keyword.equals("logged in")){
            lp.verifyUserLoggedIn();
        }
        else if(keyword.equals("clocked in")){
            twp.UserClockedInSuccessfully();
        }
        else if(keyword.equals("clocked out")){
            twp.UserClockedOutSuccessfully();
        }

    }

    @Then("timesheet is submitted successfully")
    public void timesheetIsSubmittedSuccessfully() {
    }

    @And("Expense should be submitted")
    public void expenseShouldBeSubmitted() {
        erp.expenseSubmittedSuccessfully();
    }
}
