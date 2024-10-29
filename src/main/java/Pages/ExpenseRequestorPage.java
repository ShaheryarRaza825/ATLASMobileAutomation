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
        String date[] = sm.generateDatesForCalendar(erl.selectDateIncurred,null);
        sm.clickByPath(date[0]);
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
        sm.ScrollToElementUp(erl.scrollExpenseTab);
        sm.clickByPath(erl.btnOpenAttachmentSelection);
        sm.clickByPath(erl.btnSelectUploadOption);
        sm.clickByPath(erl.selectAttachment);
        sm.ScrollToElementUp(erl.scrollExpenseTab);
        sm.waitForElementToDisappear(erl.progressBar);
    }
    public void enterComments()
    {
        sm.sendKeysByPath(erl.txtComments,"Automation Comments");
        sm.ScrollToElementUp(erl.btnSubmitExepnseClaim);
    }
    public void submitExpense()
    {
        sm.clickByPath(erl.btnSubmitExepnseClaim);
    }
    public void expenseSubmittedSuccessfully()
    {
        sm.verifyElement(erl.confirmSubmission,"submitted Successfully");
        sm.clickByPath(erl.btnBackToExpenseList);
    }
}

