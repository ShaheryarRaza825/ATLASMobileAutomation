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
    public void SplashScreenLogin() {
        sm.waitForVisibilityByPath(loginLocators.pathSplashScreenLoginBtn);
        System.out.println("Checking for Splash Screen now");
        sm.verifyElement(loginLocators.pathSplashScreenLoginBtn, "Log in");
    }
    public void ClickLoginOnSpalshScreen() {

        sm.clickByPath(loginLocators.pathSplashScreenLoginBtn);
        System.out.println("Splash Screen Page Verified");
    }
    public void userIsPresentOnLoginPage() {
        System.out.println("Checking for Login Page now");
        sm.verifyElement
                (loginLocators.userPresentOnLogin,"Sign in with your email and password \n" +
                        "to continue");
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

    public void setMangerUserName(String userName) throws IOException {
        System.out.println(userName);
        sm.sendKeysByPath(loginLocators.userName, userName);

    }

    public void setManagerPassword(String password) throws IOException {
        System.out.println(password);
        sm.sendKeysByPath(loginLocators.password, password);
    }
    public void loginToApp()
    {
        sm.clickByPath(loginLocators.loginBtn);
        // System.out.println("Enter OTP");
        // sm.sendKeysByPath(loginLocators.MFA,"123456");
    }
    public void verifyUserLoggedIn() throws InterruptedException {
        //Thread.sleep(5000);
        sm.verifyElement(loginLocators.userOnDashboard, "Hi");
    }
    public void verifyUserInvalid(){
        sm.verifyElement(loginLocators.patherromsg, "The email or password you entered is invalid.");
    }

    public void verifyUsernotLoggedIn() throws InterruptedException {
        //Thread.sleep(5000);
        sm.verifyElement(loginLocators.pathForMangerloginError, "This feature is under development. We will be up and coming soon");
        sm.clickByPath(loginLocators.pathlogout);

    }

}
