package StepDefinition;

import Pages.InviteWSEtoAtlasPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;

public class WebSteps {
    InviteWSEtoAtlasPage iwap = new InviteWSEtoAtlasPage();

    public WebSteps() throws MalformedURLException {
    }

    @Given("Admin is present on Atlas login page")
    public void admin_is_present_on_atlas_login_page() {
        iwap.userIsPresentOnWebLoginPage();
    }

    @Then("Admin enters value in email field on Atlas login page")
    public void admin_enters_value_in_email_field_on_atlas_login_page() throws IOException, InterruptedException {
        iwap.enterLoginEmail("adminEmail");
    }

    @Then("Admin enters value in password field on Atlas login page")
    public void admin_enters_value_in_password_field_on_atlas_login_page() throws IOException, InterruptedException {
        iwap.enterLoginPassword("adminPassword");
    }

    @When("Admin clicks the next button")
    public void admin_clicks_the_next_button() throws InterruptedException {
        iwap.clickLoginBtn();
    }

    @Then("Admin should be logged in successfully to Atlas portal")
    public void admin_should_be_logged_in_successfully_to_atlas_portal() throws InterruptedException {
        iwap.userLoggedinSuccessfully();
    }

    @Given("Admin is present on dashboard")
    public void admin_is_present_on_dashboard() throws InterruptedException {
        iwap.userLoggedinSuccessfully();
    }

    @When("Admin clicks the peoples tab")
    public void admin_clicks_the_peoples_tab() throws InterruptedException {
        iwap.visitPeopleTab();
    }

    @Then("Admin clicks the Add Employee button")
    public void admin_clicks_the_add_employee_button() {
        iwap.openAddEmployeePopup();
    }

    @Then("user should enter all details of WSE")
    public void user_should_enter_all_details_of_wse() throws IOException {
        iwap.selectCustomer();
        iwap.selectWorkCountry();
        iwap.enterFirstName("FirstName");
        iwap.enterLastName("LastName");
        iwap.enterWSEEmail("WSEMail");
        iwap.selectResidenceCountry();
    }

    @Then("user should click the Continue button")
    public void user_should_click_the_continue_button() {
        iwap.cotninueToProfile();
    }

    @Given("user is present on Profile page")
    public void user_is_present_on_wse_personal_information_page() {
        iwap.userPresentOnProfilePage();
    }

    @Then("user should click the Next button to move to Job Details page")
    public void userShouldClickTheNextButtonToMoveToJobDetailsPage() throws InterruptedException {
        iwap.continueToJobDetails();
    }

    @Then("user should click the Next button to move to Documents page")
    public void userShouldClickTheNextButtonToMoveToDocumentsPage() throws InterruptedException {
        iwap.continueToDocuments();
    }

    @Then("user should click the Next button to move to Pay Details page")
    public void userShouldClickTheNextButtonToMoveToPayDetailsPage() throws InterruptedException {
        iwap.continueToPayDetails();
    }

    @Then("user should click the Next button to move to Time off page")
    public void userShouldClickTheNextButtonToMoveToTimeOffPage() throws InterruptedException {
        iwap.continueToTimeOff();
    }

    @Then("user should click the Next button to move to Invite WSE page")
    public void userShouldClickTheNextButtonToMoveToInviteWSEPage() throws InterruptedException {
        iwap.continueToInvitePage();
    }

    @Then("user should click the Invite button to Invite the user to ATLAS")
    public void userShouldClickTheInviteButtonToInviteTheUserToATLAS() {
        iwap.inviteUserToAtlas();
    }

    @And("WSE should be invited successfully")
    public void wseShouldBeInvitedSuccessfully() {
    }
}
