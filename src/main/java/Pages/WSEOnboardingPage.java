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
        sm.getListElementsbyPath(ol.listTitle,title);
    }
    public void selectDateOfBirth(String year, String date) throws InterruptedException {
        System.out.println("Open Calendar");
        sm.clickByPath(ol.openCalendar);
        sm.clickByPath(ol.openYearList);
        sm.selectYearFromCalendar("2001", ol.listofYears,ol.scrollYearList);
        sm.selectDateFromCalendar("30 May 2001",ol.listofDays);
        sm.clickByPath(ol.btnSelectYear);

    }
}
