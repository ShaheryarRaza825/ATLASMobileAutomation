package Pages;
import Locators.TimerWidgetLocators;
import Locators.TimesheetLocators;
import Utils.SupportMethods;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class TimesheetPage {
    SupportMethods sm = new SupportMethods();
    TimesheetLocators tl = new TimesheetLocators();

    public TimesheetPage() throws MalformedURLException {
    }

    public void navigateToTimesheetTab()
    {
        sm.clickByPath(tl.goToTimesheetTab);
    }
    public void userIsPresentOnTimesheet()
    {
        sm.verifyElement(tl.timesheetHeading,"Timesheet");
    }
    public void openTimeSheetList()
    {
        sm.clickByPath(tl.openTimesheetList);
    }
    public void editTimesheet()
    {
        sm.clickByPath(tl.editTimesheet);
    }
    public void userPresentOnEditTimesheet()
    {
        sm.verifyElement(tl.editTimesheetHeading,"Edit Time for");
    }
    public void selectStartTime() throws MalformedURLException {
        sm.clickByPath(tl.openStartTimePicker);
        sm.ScrollTimePicker(tl.timeNumberPicker,"Backward");
        sm.clickByPath(tl.confirmStartEndTime);
    }
    public void selectEndTime()
    {
        sm.clickByPath(tl.openEndTimePicker);
        sm.ScrollTimePicker(tl.timeNumberPicker,"Forward");
        sm.clickByPath(tl.confirmStartEndTime);
    }
    public void updatTime()
    {
        sm.clickByPath(tl.updateTime);
    }

}
