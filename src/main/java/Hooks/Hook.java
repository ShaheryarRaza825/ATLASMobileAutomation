package Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import java.net.MalformedURLException;

import Utils.DriverManager;

public class Hook {

    //public static AndroidDriver driver;

    public Hook() {
    }
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        DriverManager.setupDriver();
    }
  /*  public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android"); //optional- if it's not mentioned then it fine too as it
            //will automatically be covered through UiAutomator2Options
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //optional- if it's not mentioned then it fine too as it
            //will automatically be covered through UiAutomator2Options
            options.setDeviceName("emulator-5554");
            //options.noReset();
            options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps\\app-UAT-debug 25.apk");
            System.out.println("App Setup Done");
            options.autoGrantPermissions();
            System.out.println("Permissions Granted");
            driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
            System.out.println("Driver Initialized");
        }
        return driver;
    }*/



}
