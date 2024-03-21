package Utils;

import Hooks.Hook;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class SupportMethods {

    SoftAssert softAssert = new SoftAssert();
    DriverManager dm = new DriverManager();
    Hook hook;
    public AndroidDriver driver = dm.getDriver();
    long Timeout = 30;

    public SupportMethods() throws MalformedURLException {

    }

    public void waitForVisibilityByPath(String path) {

        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).
                    until(d -> d.findElement(By.xpath(path)));
        } else if (path.contains("com.atlashxm")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(d -> d.findElement(By.id(path)));
        }
    }

    public void sendKeysByPath(String path, String value) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.clear();
            element.sendKeys(value);
        } else if (path.contains("com.atlashxm")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.id(path)));
            element.clear();
            element.sendKeys(value);
        }

    }

    public void verifyElement(String path, String expectedValue) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(path)));
                WebElement element = driver.findElement(By.xpath(path));
                String actualText = element.getText();
                System.out.println(actualText);
                softAssert.assertEquals(actualText, expectedValue);
            } else if (path.contains("com.atlashxm")) {
                new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                        .visibilityOfElementLocated(By.id(path)));
                WebElement element = driver.findElement(By.id(path));
                String actualText = element.getText();
                System.out.println(actualText);
                softAssert.assertEquals(actualText, expectedValue);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void clickByPath(String path) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.id(path)));
            element.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

    }

    public String getvaluesfromconfigfile(String value) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\FaizanJunani\\Desktop\\Appium Automation\\AtlasMobileJava\\src\\Config.properties");
        Properties prop = new Properties();
        prop.load(fr);
        String valueconfig = prop.getProperty(value);
        return valueconfig;
    }

    public void getElementTextandClick(String path) {
        if (path.contains("com.atlashxm")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.id(path)));
            WebElement element = driver.findElement(By.id(path));
            System.out.println(element.getText());
            if (element.getText().equals("Vacation")) {
                clickByPath(path);
            }
        } else if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(path)));
            WebElement element = driver.findElement(By.xpath(path));
            System.out.println(element.getText());
            if (element.getText().equals("Vacation")) {
                clickByPath(path);
            }
        }
    }
    public void getElementText(String path) {
        if (path.contains("com.atlashxm")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.id(path)));
            WebElement element = driver.findElement(By.id(path));
            System.out.println(element.getText());
        } else if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(path)));
            WebElement element = driver.findElement(By.xpath(path));
            System.out.println(element.getText());
        }
    }
    public void ScrollUp(String path, int scroll ) {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
            driver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId",element.getId(),
                            "percentage", scroll,"direction","up"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        else if(path.contains("com.atlashxm"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            driver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId",element.getId(),
                            "percentage", scroll,"direction","up"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }


    }
    public void ScrollDown(String path) {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
            driver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId",element.getId(),
                            "percentage", -80,"direction","down"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }
        else if(path.contains("com.atlashxm")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            driver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", -50, "direction", "down"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
    public void selectDateFromCalendar(String path) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(AppiumBy.accessibilityId(path)));
            element.click();
        }
        public void waitForElementToDisappear(String path)
        {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(path)));
        }
}
