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

    public WebSteps() throws Exception {
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
    public void admin_clicks_the_peoples_tab() {
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

    }

    @Given("user is present on WSE Personal Information page")
    public void user_is_present_on_wse_personal_information_page() {

    }

}
