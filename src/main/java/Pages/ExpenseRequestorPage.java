package Pages;
import Locators.ExpenseRequestorLocators;
import Locators.TimerWidgetLocators;
import Locators.TimesheetLocators;
import Utils.SupportMethods;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ExpenseRequestorPage {

    SupportMethods sm = new SupportMethods();
    ExpenseRequestorLocators erl = new ExpenseRequestorLocators();

    public ExpenseRequestorPage() throws MalformedURLException {
    }
    public void navigateToExpenseTab()
    {
        sm.clickByPath(erl.btnNavigateToExpenseTab);
    }
    public void userPresentOnExpensePage()
    {
        sm.verifyElement(erl.txtUserPresentOnExpense, "Expenses");
    }
    public void createNewExpense()
    {
        sm.clickByPath(erl.btnNavigateToCreateNewExpense);
    }
    public void enterExpenseTitle()
    {
        sm.sendKeysByPath(erl.txtExpenseTitle, "Automation Expense");
    }
    public void clickSaveAndContinue()
    {
        sm.clickByPath(erl.btnSaveandContinue);
    }
    public void selectDateIncurred()
    {
        sm.clickByPath(erl.btnOpenCalendar);
        sm.selectDateFromCalendar(erl.selectDate);
        sm.clickByPath(erl.btnConfirmDate);
    }
    public void selectCategory()
    {
        sm.clickByPath(erl.openCategoryList);
        sm.clickByPath(erl.searchForCategory);
        sm.sendKeysByPath(erl.txtSearchCategory,"Conference");
        sm.clickByPath(erl.selectCategory);
        sm.clickByPath(erl.btnConfirmCategory);
    }
    public void enterAmount()
    {
        sm.sendKeysByPath(erl.txtExpenseAmount,"2300");
    }
    public void enterVAT()
    {
        sm.sendKeysByPath(erl.txtVAT, "100");
    }
    public void selectAttachment()
    {
        sm.clickByPath(erl.btnOpenAttachmentSelection);
        sm.clickByPath(erl.btnSelectUploadOption);
        sm.clickByPath(erl.selectAttachment);
    }
    public void enterComments()
    {
        sm.sendKeysByPath(erl.txtComments,"Automation Comments");
    }
    public void submitExpense()
    {
        sm.clickByPath(erl.btnSubmitExepnseClaim);
    }
}

