package Pages;

import Hooks.Hook;
import Locators.LoginLocators;
import Utils.SupportMethods;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginPage {
    //Hook hook;
    //public AndroidDriver driver = hook.getDriver();
    SupportMethods sm = new SupportMethods();
    LoginLocators loginLocators = new LoginLocators();

    public LoginPage() throws MalformedURLException {

    }
    public void SplashScreenLogin()
    {
        sm.waitForVisibilityByPath(loginLocators.pathSplashScreenLoginBtn);
        sm.clickByPath(loginLocators.pathSplashScreenLoginBtn);
    }
    public void userIsPresentOnSplashScreen() {
        System.out.println("Checking for Splash Screen now");
        sm.verifyElement(loginLocators.pathSplashScreenLoginBtn, "Login");
        System.out.println("Splash Screen Page Verified");
    }
    public void userIsPresentOnLoginPage() {
        System.out.println("Checking for Login Page now");
        sm.verifyElement
                (loginLocators.userPresentOnLogin,"Please enter your email and password to log in.");
        //utils.TakeScreenshot("C:\\Users\\FaizanJunani\\Desktop\\AutomationTraining\\TrainingProject-2\\TrainingProject\\TEST.png");
        System.out.println("Login Page Verified");
    }
    public void setUserName(String userName) throws IOException {
        String email = sm.getvaluesfromconfigfile(userName);
        System.out.println(email);
        sm.sendKeysByPath(loginLocators.userName,email);
    }
    public void setPassword(String password) throws IOException {
        String pass = sm.getvaluesfromconfigfile(password);
        System.out.println(password);
        sm.sendKeysByPath(loginLocators.password,pass);
    }
    public void loginToApp()
    {
        sm.clickByPath(loginLocators.loginBtn);
    }
    public void verifyUserLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        sm.verifyElement(loginLocators.userOnDashboard, "Hi");
    }

}
