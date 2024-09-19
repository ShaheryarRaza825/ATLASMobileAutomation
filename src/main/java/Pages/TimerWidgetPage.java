package Pages;

import Locators.TimerWidgetLocators;
import Utils.SupportMethods;

import java.net.MalformedURLException;

public class TimerWidgetPage {
    SupportMethods sm = new SupportMethods();
    TimerWidgetLocators twl = new TimerWidgetLocators();

    public TimerWidgetPage() throws MalformedURLException {
    }
    public void userOnDashboard()
    {
        sm.getElementText(twl.dashboardPresence);
    }

    public void UserClocksIn()
    {
        sm.clickByPath(twl.clockIn);
    }
    public void UserClockedInSuccessfully()
    {
        sm.verifyElement(twl.successPopup, "Clocked in successfully");
    }
    public void UserClocksOut()
    {
        sm.clickByPath(twl.clockOut);
    }
    public void UserClockedOutSuccessfully()
    {
        sm.verifyElement(twl.successPopup, "Clocked out successfully");
    }
    public void navigateToHomePage()
    {
        sm.clickByPath(twl.goToHomeTab);
    }
}
