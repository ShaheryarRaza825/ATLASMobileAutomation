package Pages;

import Locators.MoreTabLocators;
import Utils.SupportMethods;

import java.net.MalformedURLException;
import java.security.PublicKey;

public class MorePage {

    SupportMethods sm = new SupportMethods();
    MoreTabLocators mtl = new MoreTabLocators();

    public MorePage() throws MalformedURLException {
    }

    public void navigateToMoreTab()
    {
        sm.clickByPath(mtl.navigateToMoreTab);
    }
    public void userIsPresentOnMoreTab(String verifyText){
        sm.verifyElement(mtl.userPresentOnMoreTab,verifyText);
    }
    public void navigateToMoreMyAccount()
    {
        sm.clickByPath(mtl.navigateToMyAccount);
    }
    public void userIsPresentOnMyAccount(String verifyText){
        sm.verifyElement(mtl.userPresentOnMyAccount, verifyText);
    }
    public void navigateToProfile()
    {
        sm.clickByPath(mtl.navigateToProfile);
    }
    public void userIsPresentOnProfileTab(String verifyText)
    {
        sm.verifyElement(mtl.userPresentOnProfileTab,verifyText);
    }
    public void navigateToContactDetails()
    {
        sm.clickByPath(mtl.navigateToContactDetails);
        sm.checkElementSelected(mtl.navigateToContactDetails);
    }
    public void editContactDetails(String txtPrimaryEmail)
    {
        // sm.clickByPath(mtl.btnEditContactDetails);
        sm.sendKeysByPath(mtl.txtEditDetails,txtPrimaryEmail);

    }

    public void editInContactDetails(String txtPrimaryEmail)
    {
        sm.clickByPath(mtl.btnEditContactDetails);
        sm.sendKeysByPath(mtl.txtEditDetails,txtPrimaryEmail);

    }
    public void updateContactDetails() {
        sm.clickByPath(mtl.btnNext);
        sm.clickByPath(mtl.btnCalendarEffectiveChangeDate);
        sm.clickByPath(mtl.btnCalendarConfirmDate);
        sm.clickByPath(mtl.btnSaveChanges);

    }

    public void updateInContactDetails() {
        sm.clickByPath(mtl.btnNext);
        sm.verifyElement(MoreTabLocators.errortext, "addreffffss");
    }



    public void navigateToSocialMediaDetails()
    {
        sm.clickByPath(mtl.navigateToSocialMediaDetails);
    }
    public void editLinkedInDetails(String txtLinkedIn)
    {
        sm.clickByPath(mtl.btnEditLinkedIn);
        sm.sendKeysByPath(mtl.txtEditDetails,txtLinkedIn);
    }
    public void updateLinkedInDetails()
    {
        sm.clickByPath(mtl.btnNext);
        sm.clickByPath(mtl.btnCalendarEffectiveChangeDate);
        sm.clickByPath(mtl.btnCalendarConfirmDate);
        sm.clickByPath(mtl.btnSaveChanges);
    }
    public void editWebsiteDetails(String txtWebsite)
    {
        sm.clickByPath(mtl.btnEditWebsite);
        sm.sendKeysByPath(mtl.txtEditDetails,txtWebsite);
    }
    public void updateWebsiteDetails()
    {
        sm.clickByPath(mtl.btnNext);
        sm.clickByPath(mtl.btnCalendarEffectiveChangeDate);
        sm.clickByPath(mtl.btnCalendarConfirmDate);
        sm.clickByPath(mtl.btnSaveChanges);
    }
    public void navigateToMyAccount()
    {
        sm.clickByPath(mtl.navigateBackToMyAccount);
    }

}
