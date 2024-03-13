package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private static AndroidDriver mobileDriver;

    public static AndroidDriver getDriver(){

        return mobileDriver;
    }

    public static void setupDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional- if it's not mentioned then it fine too as it
        //will automatically be covered through UiAutomator2Options
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //optional- if it's not mentioned then it fine too as it
        //will automatically be covered through UiAutomator2Options
        options.setDeviceName("743f64f0");
        //options.noReset();
       // options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps\\app-UAT-debug 25.apk");
        options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps\\app-TRNG-debug.apk");
        System.out.println("App Setup Done");
        options.autoGrantPermissions();
        System.out.println("Permissions Granted");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        setDriver(driver);
        System.out.println("Driver Initialized");

    }
    public static void setDriver(AndroidDriver driver){
        mobileDriver = driver;
    }
    public static void closeDriver()
    {
        getDriver().close();
    }


}
