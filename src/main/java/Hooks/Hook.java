package Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    private Hook(){}

    @BeforeTest
    public static AndroidDriver getDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional- if it's not mentioned then it fine too as it
                                            //will automatically be covered through UiAutomator2Options
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //optional- if it's not mentioned then it fine too as it
                                                                    //will automatically be covered through UiAutomator2Options
        options.setDeviceName("emulator-5554");
        options.setApp("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\test\\resources\\apps");

        return new AndroidDriver(new URL("http://localhost:4723"), options);

    }

    @AfterTest
    public void Teardown()
    {

    }
}
