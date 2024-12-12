package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private static AndroidDriver mobileDriver;
    private static WebDriver webDriver;
    static SoftAssert softAssert = new SoftAssert();
    public static AndroidDriver getDriver(){

        return mobileDriver;
    }

    public static void setupAndroidDriver() throws MalformedURLException {
       UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional- if it's not mentioned then it fine too as it
        //will automatically be covered through UiAutomator2Options
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //optional- if it's not mentioned then it fine too as it
        //will automatically be covered through UiAutomator2Options
        options.setDeviceName("743f64f0");
        //options.setDeviceName("emulator-5554");
        //options.noReset();
        options.setFullReset(true);
       // options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps\\app-UAT-debug 25.apk");
        //options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps\\app-UAT-5June2024.apk");
        options.setApp("C:\\Users\\FaizanJunani\\Downloads\\app-UAT-debug.apk");
        System.out.println("App Setup Done");
        options.autoGrantPermissions();
        System.out.println("Permissions Granted");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        setAndroidDriver(driver);
        System.out.println("Driver Initialized");
    }
    public static void setAndroidDriver(AndroidDriver driver){
        mobileDriver = driver;
    }
    public static WebDriver getWebDriver() {
            if (webDriver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                //options.addArguments("--headless=new");
                webDriver = new ChromeDriver(options);
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://core-uat.atlasbyelements.com/");
            }
            return webDriver;
        }
    @AfterAll
    public static void closeDriver()
    {
        getDriver().close();
        softAssert.assertAll();
    }

}
