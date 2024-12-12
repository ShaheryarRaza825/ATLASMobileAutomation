package StepDefinition;

import Hooks.Hook;
import Locators.OnboardingLocators;
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
    WSEOnboardingPage wop = new WSEOnboardingPage();

    public StepDefinition() throws MalformedURLException {
    }

    @Given("user is present on {string} page")
    public void user_is_present_on_page(String keyword) {
      if(keyword.equals("expense dashboard"))
        {
            erp.userPresentOnExpensePage();
        }
    }

    @Given("user enters value in {string} field")
    public void user_enters_value_in_field(String keyword) throws IOException {
       if(keyword.equals("expense title"))
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
     if(keyword.equals("expenses tab"))
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
        if(keyword.equals("date incurred")){
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

    @Then("timesheet is submitted successfully")
    public void timesheetIsSubmittedSuccessfully() {
        twp.navigateToHomePage();
    }

    @And("Expense should be submitted")
    public void expenseShouldBeSubmitted() {
        erp.expenseSubmittedSuccessfully();
        twp.navigateToHomePage();

    }
    @Given("user is present on splash screen page")
    public void user_is_present_on_splash_screen_page() {
        lp.SplashScreenLogin();
    }

    @Then("user clicks the login button button on splash screen")
    public void user_clicks_the_login_button_button_on_splash_screen() {
        lp.ClickLoginOnSpalshScreen();
    }

    @Given("user is present on login page")
    public void user_is_present_on_login_page() {
        lp.userIsPresentOnLoginPage();
    }

    @Given("user enters value in email field")
    public void user_enters_value_in_email_field() throws IOException {
        lp.setUserName("Email");
    }

    @Given("user enters value in password field")
    public void user_enters_value_in_password_field() throws IOException {
        lp.setPassword("Password");
    }

    @Then("user clicks the login button")
    public void user_clicks_the_login_button() {
        lp.loginToApp();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws InterruptedException {
        lp.verifyUserLoggedIn();
    }
    @Given("user is present on dashboard page")
    public void user_is_present_on_dashboard_page() {
        twp.userOnDashboard();
    }

    @Given("user clicks the clockin button")
    public void user_clicks_the_clockin_button() {
        twp.UserClocksIn();
    }

    @Then("user should be clocked in successfully")
    public void user_should_be_clocked_in_successfully() {
        twp.UserClockedInSuccessfully();
    }
    @Given("user clicks the clockout button")
    public void user_clicks_the_clockout_button() {
        twp.UserClocksOut();
    }

    @Then("user should be clocked out successfully")
    public void user_should_be_clocked_out_successfully() {
        twp.UserClockedOutSuccessfully();
    }

    @When("user clicks the request timeoff button")
    public void user_clicks_the_request_timeoff_button() throws InterruptedException {
        tp.UserNavigateToPTOPage();

    }

    @When("user is present on request timeoff page")
    public void user_is_present_on_request_timeoff_page() {
        tp.UserIsPresentOnPTOPage();

    }

    @When("user selects option for PTO")
    public void user_selects_option_for_pto() {
        tp.UserSelectsTimeOffType();
    }

    @When("user selects option for PTODates")
    public void user_selects_option_for_PTODates() {
            tp.userSelectsPTODates();
    }

    @When("user clicks the add hours button")
    public void user_clicks_the_add_hours_button() {
       tp.UserVisitAddHoursPage();
    }

    @When("user enters value in hours field")
    public void user_enters_value_in_hours_field() throws IOException {
        tp.EnterHours("Hours1","Hours2");
    }

    @When("user clicks the save button")
    public void user_clicks_the_save_button() {
       tp.UserSavesHours();
    }

    @When("user enters value in PTOcomments field")
    public void user_enters_value_in_pt_ocomments_field() {
        tp.enterCommentsForPTO();
    }

    @When("user clicks the submit button")
    public void user_clicks_the_submit_button() {
        tp.UserSubmitsPTO();
    }


    @Then("user should be logged in successfully and present on onboarding landing page")
    public void userShouldBeLoggedInSuccessfullyAndPresentOnOnboardingLandingPage(){
        wop.verifyUserIsPresentOnOnboardingLandingPage();
    }

    @Then("user should click the Continue button below")
    public void userShouldClickTheContinueButtonBelow() {
        wop.continueToOnboarding();
    }

    @Then("user can skip uploading profile picture")
    public void userCanSkipUploadingProfilePicture() {
        wop.skipProfilePic();
    }

    @And("user will be present on Profile tab")
    public void userWillBePresentOnProfileTab() {
        wop.userPresentOnProfile("Profile");
    }

    @Then("user enters values for the fields on PersonalInformation tab")
    public void userEntersValuesForTheFieldsOnPersonalInformationTab() throws InterruptedException {
        wop.selectTitle("Mr.");
        wop.selectDateOfBirth("2004",9,2);
        wop.selectMaritalStatus("Single");
        wop.selectGender("Female");
    }

    @And("user clicks the profile continue button")
    public void userClicksTheProfileContinueButton() {
        wop.continueToCitizenshipTab();
    }

    @Then("user enters values for the fields on CitizenshipInformation tab")
    public void userEntersValuesForTheFieldsOnCitizenshipInformationTab() throws InterruptedException {
        wop.selectCitizenship("Canada") ;
        wop.enterNationalId("31314");
    }

    @Then("user enters the values for the fields on HomeAddress tab")
    public void userEntersTheValuesForTheFieldsOnHomeAddressTab() throws InterruptedException {
        wop.selectHomeCountry("Canada");
        wop.enterCity("Toronto");
        wop.enterProvince("Ontario");
        wop.enterZipcode("23435");
        wop.enterAddress1("House 10303");
        wop.enterAddress2("Street 4949");
        wop.enterPhoneNumber("34103040676","Canada");
    }

    @Then("user enters the values for the fields on Banking tab")
    public void userEntersTheValuesForTheFieldsOnBankingTab() throws InterruptedException {
        wop.selectBankCountry("Canada");
        wop.enterAccountHolderName("Test Onboarding");
    }

    @Then("user enters the values for the fields on Emergency tab")
    public void userEntersTheValuesForTheFieldsOnEmergencyTab() throws InterruptedException {
        wop.enterFirstName("Test");
        wop.enterLastName("Onbaord Emergency");
        wop.selectRelationship("Brother");
        wop.enterEmail("email@emergency.com");
        wop.enterEmergencyPhoneNumber("Colombia","2342325445");
    }

    @And("user clicks the Submit button")
    public void userClicksTheSubmitButton() {
        wop.submitOnboarding();
    }

    @And("user clicks the continue button on accounthodlderinfo tab")
    public void userClicksTheContinueButtonOnAccounthodlderinfoTab() {
        wop.continueAndSkipAccountHolderInfo();
    }

    @Then("user enters the values for the fields on General Information tab")
    public void userEntersTheValuesForTheFieldsOnGeneralInformationTab() {
        wop.selectSameAsHomeAddress();
    }


    @And("user clicks the continue button on general info tab")
    public void userClicksTheContinueButtonOnGeneralInfoTab() {
        wop.continueToEmergency();
    }

    @And("user clicks the citizenship continue button")
    public void userClicksTheCitizenshipContinueButton() {
        wop.continueToHomeAddressTab();
    }

    @And("user clicks the homeaddress continue button")
    public void userClicksTheHomeaddressContinueButton() {
            wop.continueToBankingTab();
        }

    @Then("user logsout of the application")
    public void userLogsoutOfTheApplication() {
        wop.logoutOfTheApp();
    }


    @Then("user selects option for start time")
    public void userSelectsOptionForStartTime() throws MalformedURLException {
        tsp.selectStartTime();
    }

    @Then("user selects option for end time")
    public void userSelectsOptionForEndTime() {
        tsp.selectEndTime();
    }

    @Then("user clicks the timesheet tab button")
    public void userClicksTheTimesheetTabButton() {
        tsp.navigateToTimesheetTab();
    }

    @And("user is present on timesheet page")
    public void userIsPresentOnTimesheetPage() {
        tsp.userIsPresentOnTimesheet();
    }

    @Then("user clicks the timesheet arrow button")
    public void userClicksTheTimesheetArrowButton() {
        tsp.openTimeSheetList();
    }

    @Then("user clicks the edit timesheet button")
    public void userClicksTheEditTimesheetButton() {
        tsp.editTimesheet();
    }

    @And("user is present on edit timesheet page")
    public void userIsPresentOnEditTimesheetPage() {
        tsp.userPresentOnEditTimesheet();
    }

    @And("user clicks the update timesheet button")
    public void userClicksTheUpdateTimesheetButton() {
        tsp.updatTime();
    }

    @When("user navigates to More Tab")
    public void user_navigates_to_more_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user is present on More Tab")
    public void user_is_present_on_more_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks the My Account option")
    public void user_clicks_the_my_account_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user is present on My Account page")
    public void user_is_present_on_my_account_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks the Profile option")
    public void user_clicks_the_profile_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user is present on My Account Profile page")
    public void user_is_present_on_my_account_profile_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks the Contact Details tab")
    public void user_clicks_the_contact_details_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks the edit icon to edit contact details")
    public void user_clicks_the_edit_icon_to_edit_contact_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user updates the contact details")
    public void user_updates_the_contact_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user saves the details updated contact details should be displayed")
    public void user_saves_the_details_updated_contact_details_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks the Social Media Details tab")
    public void userClicksTheSocialMediaDetailsTab() {
    }

    @Then("user clicks the edit icon to edit linkedin details")
    public void userClicksTheEditIconToEditLinkedinDetails() {
    }

    @Then("user updates the linkedin details")
    public void userUpdatesTheLinkedinDetails() {
    }

    @When("user saves the details updated linkedin details should be displayed")
    public void userSavesTheDetailsUpdatedLinkedinDetailsShouldBeDisplayed() {
    }

    @Then("user clicks the edit icon to edit website details")
    public void userClicksTheEditIconToEditWebsiteDetails() {
    }

    @Then("user updates the website details")
    public void userUpdatesTheWebsiteDetails() {
    }

    @When("user saves the details updated website details should be displayed")
    public void userSavesTheDetailsUpdatedWebsiteDetailsShouldBeDisplayed() {
    }

    @Then("user goes back to My Account page")
    public void userGoesBackToMyAccountPage() {
    }

    @Then("user clicks the Emergency Contact options")
    public void userClicksTheEmergencyContactOptions() {
    }

    @Given("user is present on My Account Emergency page")
    public void userIsPresentOnMyAccountEmergencyPage() {
    }

    @Then("user clicks the edit icon to edit emergency details")
    public void userClicksTheEditIconToEditEmergencyDetails() {
    }

    @Then("user updates the emergency details")
    public void userUpdatesTheEmergencyDetails() {
    }

    @When("user saves the details updated emergency details should be displayed")
    public void userSavesTheDetailsUpdatedEmergencyDetailsShouldBeDisplayed() {
    }

    @And("user enters email {string}")
    public void userEntersEmail(String Email) throws IOException {
        lp.setMangerUserName(Email);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String Password) throws IOException {
        lp.setManagerPassword(Password);
    }

    @Then("user should be not be logged in successfully")
    public void userShouldBeNotBeLoggedInSuccessfully() throws InterruptedException {
        lp.verifyUsernotLoggedIn();

    }

    @Then("user should be logged in successfully due to credentials")
    public void userShouldBeLoggedInSuccessfullyDueToCredentials() {
        lp.verifyUserInvalid();

    }
}

