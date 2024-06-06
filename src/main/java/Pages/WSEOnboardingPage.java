package Pages;

import Locators.OnboardingLocators;
import Utils.SupportMethods;

import java.net.MalformedURLException;

public class WSEOnboardingPage {
    OnboardingLocators ol = new OnboardingLocators();
    SupportMethods sm = new SupportMethods();

    public WSEOnboardingPage() throws MalformedURLException {
    }

    public void verifyUserIsPresentOnOnboardingLandingPage()
    {
        sm.verifyElement(ol.txtContinuetoProfile,"Complete your profile");
    }
    public void continueToOnboarding()
    {
        sm.clickByPath(ol.btnContinuetoProfile);
    }
    public void skipProfilePic()
    {
        sm.clickByPath(ol.btnSkipProfielPic);
    }
    public void userPresentOnProfile(String pageTitle)
    {
        sm.verifyElement(ol.profilePageTItle,pageTitle);
    }
    public void selectTitle(String title)
    {
        System.out.println("Lets select the title now");
        sm.Tap(ol.dropdownTtile);
        System.out.println("Dropdown Open, now get the list");
        sm.SelectListElementsbyPath(ol.listTitle,title);
    }
    public void selectDateOfBirth(int expectedYear, int expectedMonth, int expectedDate) throws InterruptedException {
        System.out.println("Open Calendar");
        sm.clickByPath(ol.openCalendar);
        sm.clickByPath(ol.openYearList);
        sm.selectYearFromCalendar(expectedYear, ol.listofYears,ol.scrollYearList);
        sm.selectDateFromCalendar(expectedYear,expectedMonth,expectedDate,ol.listofDays);
        sm.clickByPath(ol.btnSelectYear);
    }
    public void selectMaritalStatus(String maritalStatus)
    {
        System.out.println("Lets select the Marital Status now");
        sm.Tap(ol.dropdownMaritalStatus);
        System.out.println("Dropdown Open, now get the list");
        sm.SelectListElementsbyPath(ol.listMaritalStatus,maritalStatus);
        System.out.println("Marital Status is selected");
    }
    public void selectGender(String gender)
    {
        sm.ScrollToElement(ol.scrollPersonalInfoTab);
        System.out.println("Lets select the gender now");
        sm.Tap(ol.dropdownGender);
        System.out.println("Dropdown Open, now get the list");
        sm.SelectListElementsbyPath(ol.listGender,gender);
        System.out.println("Gender is Selected");
    }
    public void ContinueToCitizenshipTab()
    {
        sm.clickByPath(ol.btnContinue);
    }
    public void selectCitizenship(String expectedCitizenshipValue)
    {
        sm.Tap(ol.dropdownCountry);
        sm.SelectListElementsbyPath(ol.listOfCountries,expectedCitizenshipValue);
    }
    public void enterNationalId(String expectedNationalIdValue)
    {
        sm.sendKeysByPath(ol.txtNationalId,expectedNationalIdValue);
    }
    public void ContinueToHomeAddressTab()
    {
        sm.clickByPath(ol.btnContinue);
    }
    public void selectHomeCountry(String expectedCitizenshipValue)
    {
        sm.Tap(ol.dropdownCountry);
        sm.SelectListElementsbyPath(ol.listOfCountries,expectedCitizenshipValue);
    }
    public void enterCity(String expectedCityValue)
    {
        sm.sendKeysByPath(ol.txtCity,expectedCityValue);
    }
    public void enterProvince(String expectedProvinceValue)
    {
        sm.sendKeysByPath(ol.txtState,expectedProvinceValue);
    }
    public void enterZipcode(String expectedZipcodeValue)
    {
        sm.sendKeysByPath(ol.txtPostalCode,expectedZipcodeValue);
    }  public void enterAddress1(String expectedAddress1Value)
    {
        sm.sendKeysByPath(ol.txtAddress1,expectedAddress1Value);
    }  public void enterAddress2(String expectedAddress2Value)
    {
        sm.sendKeysByPath(ol.txtAddress2, expectedAddress2Value);
    }
    public void enterPhoneNumber(String expectedPhoneNumberValue, String expeectedCountryCodeValue)
    {
        sm.Tap(ol.dropdownCountry);
        sm.SelectListElementsbyPath(ol.listOfCountries,expeectedCountryCodeValue);
        sm.sendKeysByPath(ol.txtPhoneNumber,expectedPhoneNumberValue);
    }
}
