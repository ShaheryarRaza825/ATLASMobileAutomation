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
    public InviteWSEtoAtlasPage() throws Exception {
    }
    public void userIsPresentOnWebLoginPage()
    {
        sm.VerifyImageDisplayed(webLoginLocators.imgAtlasLogo, "Image not displayed");
    }
    public void enterLoginEmail(String adminEmail) throws IOException, InterruptedException {
        Thread.sleep(2300);
        String email = sm.getvaluesfromconfigfile(adminEmail);
        System.out.println(email);
        sm.sendKeysByPath(webLoginLocators.txtWebLoginEmail,email);
    }
    public void enterLoginPassword(String adminPassword) throws IOException, InterruptedException {
        Thread.sleep(1800);
        String password = sm.getvaluesfromconfigfile(adminPassword);
        System.out.println(password);
        sm.sendKeysByPath(webLoginLocators.txtWebLoginPassword,password);
    }
    public void clickLoginBtn() throws InterruptedException {
        Thread.sleep(3500);
        sm.clickByPath(webLoginLocators.btnloginToWeb);
    }
    public void userLoggedinSuccessfully() throws InterruptedException {
        Thread.sleep(2200);
        sm.verifyElement(webLoginLocators.userLoggedInSuccessfully,"Welcome to Atlas");
    }
    public void visitPeopleTab()
    {
        sm.clickByPath(webAddWSELocators.btnGoToPeopleTab);
    }
    public void openAddEmployeePopup()
    {
        sm.clickByPath(webAddWSELocators.btnAddEmployee);
    }
    public void selectCustomer()
    {
        sm.clickByPath(webAddWSELocators.openCustomerList);
        sm.getListElementsbyClass(webAddWSELocators.allList,"Travelmate Limited");
    }
    public void selectWorkCountry()
    {
        sm.clickByPath(webAddWSELocators.openWorkCountryList);
        sm.getListElementsbyClass(webAddWSELocators.allList,"Canada");
    }
    public void enterFirstName(String firstName) throws IOException {
        String firstname = sm.getvaluesfromconfigfile(firstName);
        System.out.println(firstname);
        sm.sendKeysByPath(webAddWSELocators.txtFirstName, firstname);

    }
    public void enterLastName(String lastName) throws IOException {
        String lastname = sm.getvaluesfromconfigfile(lastName);
        System.out.println(lastname);
        sm.sendKeysByPath(webAddWSELocators.txtFirstName, lastname);

    }
    public void enterWSEEmail(String userEmail) throws IOException {
        String email = sm.getvaluesfromconfigfile(userEmail);
        System.out.println(email);
        sm.sendKeysByPath(webLoginLocators.txtWebLoginEmail,email);
    }
    public void selectResidenceCountry()
    {
        sm.clickByPath(webAddWSELocators.openWorkCountryList);
        sm.getListElementsbyClass(webAddWSELocators.allList,"Austria");
    }
}
