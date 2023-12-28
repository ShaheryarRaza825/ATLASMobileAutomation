package Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    @BeforeClass
    public AndroidDriver Setup() throws MalformedURLException {
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
