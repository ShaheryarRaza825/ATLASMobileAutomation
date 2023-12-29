package Pages;

import Hooks.Hook;
import Locators.LoginLocators;
import Utils.SupportMethods;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginPage {
    Hook hook;
    public AndroidDriver driver = hook.getDriver();
    SupportMethods sm = new SupportMethods(driver);
    LoginLocators loginLocators = new LoginLocators();

    public LoginPage(AndroidDriver driver) throws MalformedURLException {
        this.driver = driver;
    }
    public void userIsPresentOnLoginPage() throws Exception {
        sm.verifyElement
                (loginLocators.userPresentOnLogin,"Please enter your email and password to log in.");
        //utils.TakeScreenshot("C:\\Users\\FaizanJunani\\Desktop\\AutomationTraining\\TrainingProject-2\\TrainingProject\\TEST.png");
    }
    public void setUserName(String userName) throws IOException {
        String email = sm.getvaluesfromconfigfile(userName);
        sm.sendKeysByPath(loginLocators.userName,email);
    }
    public void setPassword(String password) throws IOException {
        String pass = sm.getvaluesfromconfigfile(password);
        sm.sendKeysByPath(loginLocators.password,pass);
    }
    public void loginToApp()
    {
        sm.clickByPath(loginLocators.loginBtn);
    }

}
