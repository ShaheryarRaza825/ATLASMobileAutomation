package Pages;

import Locators.TimeoffLocators;
import Utils.SupportMethods;

import java.io.IOException;
import java.net.MalformedURLException;

public class TimeOffPage {

    SupportMethods sm = new SupportMethods();
    TimeoffLocators timeoffLocators = new TimeoffLocators();

    public TimeOffPage() throws MalformedURLException {

    }
    public void UserIsPresentOnPTOPage()
    {
        System.out.println("User accesses TimeoffPage");
        sm.verifyElement(timeoffLocators.timeOffPageTitle, "Time Off");
    }
    public void UserNavigateToPTOPage() throws InterruptedException {
        System.out.println("Navigate to Timeoff");
        sm.clickByPath(timeoffLocators.btnRequestTimeoff);
    }
    public void UserSelectsTimeOffType()
    {
        sm.clickByPath(timeoffLocators.dropdownTimeOffType);
        sm.SelectListElementsbyPath(timeoffLocators.optionTimeOffType, "Vacation");
        //sm.clickByPath(timeoffLocators.optionTimeOffType);
    }
    public void UserSelectsFromDate()
    {
        sm.clickByPath(timeoffLocators.openFromCalendar);
        sm.clickByPath(timeoffLocators.selectFromDate);
        sm.clickByPath(timeoffLocators.confirmDate);
    }
    public void UserSelectsToDate()
    {
        sm.clickByPath(timeoffLocators.openToCalendar);
        sm.clickByPath(timeoffLocators.selectToDate);
        sm.clickByPath(timeoffLocators.confirmDate);
    }
    public void UserVisitAddHoursPage()
    {
        sm.clickByPath(timeoffLocators.btnAddHours);
    }
    public void EnterHours(String Hours1,String Hours2) throws IOException {
        String hour1 = sm.getvaluesfromconfigfile(Hours1);
        String hour2 = sm.getvaluesfromconfigfile(Hours2);
        System.out.println("Hour 1:"+hour1+ "Hour 2:"+hour2+"");
        sm.sendKeysByPath(timeoffLocators.txtAddHours1,hour1);
        sm.sendKeysByPath(timeoffLocators.txtAddHours2,hour2);
    }
    public void UserSavesHours()
    {
        sm.clickByPath(timeoffLocators.btnSaveHours);
    }
    public void enterCommentsForPTO()
    {
        sm.sendKeysByPath(timeoffLocators.commentBox, "Comments for Timeoff Automation");
    }
    public void UserSubmitsPTO()
    {
        sm.clickByPath(timeoffLocators.btnSubmitPTO);
        sm.verifyElement(timeoffLocators.confirmPopupTitle,"Confirm Submission" );
        sm.clickByPath(timeoffLocators.btnConfirmPTO);
    }
    public void ConfirmSubmissionOfPTO()
    {
        sm.verifyElement(timeoffLocators.verifyPTOMessage, "Request sent to manager for approval.");
        sm.clickByPath(timeoffLocators.backToHomePage);
    }

}
