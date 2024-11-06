package Pages;

import Locators.MoreTabLocators;
import Utils.SupportMethods;

import java.net.MalformedURLException;

public class MorePage {

    SupportMethods sm = new SupportMethods();
    MoreTabLocators mtl = new MoreTabLocators();

    public MorePage() throws MalformedURLException {
    }

    public void navigateToMoreTab()
    {
        sm.clickByPath(mtl.navigateToMoreTab);
    }
    public void navigateToMoreMyAccount()
    {
        sm.clickByPath(mtl.navigateToMyAccount);
    }
    public void navigateToProfile()
    {
        sm.clickByPath(mtl.navigateToProfile);
    }
    public void navigateToContactDetails()
    {
        sm.clickByPath(mtl.navigateToContactDetails);
    }
    public void navigateToSocialMediaDetails()
    {
        sm.clickByPath(mtl.navigateToSocialMediaDetails);
    }
    public void editContactDetails()
    {
        sm.clickByPath(mtl.btnEditContactDetails);
    }
    public void updateContactDetails(String txtPrimaryEmail)
    {
        sm.sendKeysByPath(mtl.txtEditDetails,txtPrimaryEmail);
        sm.clickByPath(mtl.btnNextContactEmail);
        sm.clickByPath(mtl.btnCalendarEffectiveChangeDate);
    }
}
