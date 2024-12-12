package Hooks;
import Utils.SupportMethods;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;

import Utils.DriverManager;

import static Utils.DriverManager.getDriver;

public class Hook {

    //public static AndroidDriver driver;
    static SoftAssert softAssert = new SoftAssert();


    public Hook() throws MalformedURLException {
    }
    // Method to add assertions in step definitions
    public static SoftAssert getSoftAssert() {
        return softAssert;
    }
    @BeforeAll
    public static void beforeAll() throws IOException {
        DriverManager.setupAndroidDriver();
        DriverManager.getWebDriver();
        System.out.println("Hook Before All executed");

       // writePropertiesToFile();
    }
    public static void writePropertiesToFile() throws IOException {
        SupportMethods sm = new SupportMethods();
        String[]userName;
        userName = sm.RandomNameGenerator();

        sm.writeValuesInConfigFile("FirstName",userName[0].toString());
        sm.writeValuesInConfigFile("LastName",userName[1].toString());
        String email = userName[0]+userName[1]+"@yopmail.com";
        sm.writeValuesInConfigFile("WSEMail", email);
        System.out.println("Properties written to file" +userName[0]+", "+userName[1]+", "+email);
    }

    @AfterAll
    public static void AfterAll()
    {
        softAssert.assertAll();
        //getDriver().close();
        System.out.println("Hook After Executed");
    }




}
