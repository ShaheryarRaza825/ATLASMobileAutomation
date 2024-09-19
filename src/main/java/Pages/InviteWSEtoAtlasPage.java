package Pages;

import Locators.WebAddWSELocators;
import Locators.WebLoginLocators;
import Utils.SupportMethods;

import java.io.IOException;
import java.net.MalformedURLException;

public class InviteWSEtoAtlasPage {

    WebLoginLocators webLoginLocators = new WebLoginLocators();
    WebAddWSELocators webAddWSELocators = new WebAddWSELocators();
    SupportMethods sm = new SupportMethods();
    String[] userName;
    public InviteWSEtoAtlasPage() throws MalformedURLException {
    }
    public void userIsPresentOnWebLoginPage()
    {
        sm.VerifyImageDisplayed(webLoginLocators.imgAtlasLogo, "Image not displayed");
    }
    public void enterLoginEmail(String adminEmail) throws IOException, InterruptedException {
        String email = sm.getvaluesfromconfigfile(adminEmail);
        System.out.println(email);
        sm.sendKeysByPath(webLoginLocators.txtWebLoginEmail,email);
    }
    public void enterLoginPassword(String adminPassword) throws IOException, InterruptedException {
        String password = sm.getvaluesfromconfigfile(adminPassword);
        System.out.println(password);
        sm.sendKeysByPath(webLoginLocators.txtWebLoginPassword,password);
    }
    public void clickLoginBtn() throws InterruptedException {
        sm.clickByPath(webLoginLocators.btnloginToWeb);
    }
    public void userLoggedinSuccessfully() throws InterruptedException {
        sm.verifyElement(webLoginLocators.userLoggedInSuccessfully,"Welcome to Atlas, HRSD!");
    }
    public void visitPeopleTab() throws InterruptedException {
        sm.clickByPath(webAddWSELocators.btnGoToPeopleTab);
        System.out.println("wait for list to visible");
    }
    public void openAddEmployeePopup()
    {
        sm.waitForElementToAppear(webAddWSELocators.btnAddEmployee);
        sm.clickByPath(webAddWSELocators.btnAddEmployee);
        /*sm.waitForElementToAppear(webAddWSELocators.alternateRoute);
        sm.clickByPath(webAddWSELocators.alternateRoute);*/
    }
    public void selectCustomer()
    {
        sm.clickByPath(webAddWSELocators.openCustomerList);
        sm.getListElementsbyPath(webAddWSELocators.allList,"Travelmate Limited");
    }
    public void selectWorkCountry()
    {
        sm.clickByPath(webAddWSELocators.openWorkCountryList);
        sm.waitForElementToAppear(webAddWSELocators.allList);
        sm.getListElementsbyPath(webAddWSELocators.allList,"Canada");
    }
    public void enterFirstName(String firstName) throws IOException {
        String firstname = sm.getvaluesfromconfigfile(firstName);
        System.out.println(firstname);
        sm.sendKeysByPath(webAddWSELocators.txtFirstName, firstname);

    }
    public void enterLastName(String lastName) throws IOException {
        String lastname = sm.getvaluesfromconfigfile(lastName);
        System.out.println(lastname);
        sm.sendKeysByPath(webAddWSELocators.txtLastName, lastname);

    }
    public void enterWSEEmail(String userEmail) throws IOException {
        String email = sm.getvaluesfromconfigfile(userEmail);
        System.out.println(email);
        sm.sendKeysByPath(webAddWSELocators.txtEmail,email);
    }
    public void selectResidenceCountry()
    {
        sm.clickByPath(webAddWSELocators.openResidenceCountryList);
        sm.getListElementsbyPath(webAddWSELocators.allList,"Austria");
    }

    public void cotninueToProfile() {
        sm.clickByPath(webAddWSELocators.btnContinueToProfile);
    }

    public void userPresentOnProfilePage() {
        sm.verifyElement(webAddWSELocators.userPresentoOnProfilePage,"Complete Employee Profile");
    }
    public void continueToJobDetails() throws InterruptedException {
        sm.ScrollWebPage(webAddWSELocators.btnProfileNext);
        System.out.println("waiting for next button");
        sm.ScrollToEnd();
        sm.waitForElementToAppear(webAddWSELocators.btnProfileNext);
        System.out.println("next button found");
        sm.clickByPath(webAddWSELocators.btnProfileNext);
        System.out.println("button clicked");
    }
    public void continueToDocuments() throws InterruptedException {
        sm.ScrollWebPage(webAddWSELocators.openFrequencyList);
        System.out.println("Scrolled down");
        sm.clickByPath(webAddWSELocators.openFrequencyList);
        System.out.println("Frequency Opened");
        sm.ScrollWebPage(webAddWSELocators.allList);
        sm.getListElementsbyPath(webAddWSELocators.allList, "Weekly");
        System.out.println("Frequency Selected");
        //sm.ScrollWebPage(webAddWSELocators.scrollDownLocation);
        sm.ScrollToEnd();
        System.out.println("Scrolled Down to Next");
        sm.clickByPath(webAddWSELocators.btnJobDetailsNext);
        System.out.println("Moving Next from Job Details");
    }
    public void continueToPayDetails() throws InterruptedException {
        System.out.println("Scroll Continue to Pay tab");
        sm.ScrollToEnd();
        System.out.println("Scrolled Down");
        sm.clickByPath(webAddWSELocators.btnDocumentsNext);
        System.out.println("Next button clicked");
        sm.clickByPath(webAddWSELocators.btnWarningPopup);
        System.out.println("Warning popup clicked");
    }
    public void continueToTimeOff() throws InterruptedException {
        System.out.println("Scroll Continue to Timeoff tab");
        sm.ScrollToEnd();
        System.out.println("Scrolled Down");
        sm.clickByPath(webAddWSELocators.btnPayDetailsNext);
    }
    public void continueToInvitePage() throws InterruptedException {
       sm.ScrollToEnd();
        sm.clickByPath(webAddWSELocators.btnTimeOffNext);
    }
    public void inviteUserToAtlas()
    {
        sm.clickByPath(webAddWSELocators.btnInviteEmployee);
        sm.clickByPath(webAddWSELocators.btnGoToPeopleTab);
        sm.verifyElement(webAddWSELocators.verifyInviteSent, "Invite Sent");
    }
}
