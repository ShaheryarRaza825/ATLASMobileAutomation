package Utils;

import Hooks.Hook;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.ajbrown.namemachine.NameGenerator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SupportMethods {

    SoftAssert softAssert = new SoftAssert();
    DriverManager dm = new DriverManager();
    Hook hook;
    public AndroidDriver androidDriver = dm.getDriver();
    public WebDriver webDriver = dm.getWebDriver();
    long Timeout = 30;
    List<WebElement> listItems;

    public SupportMethods() throws MalformedURLException {

    }

    public void waitForVisibilityByPath(String path) {

        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).
                    until(d -> d.findElement(By.xpath(path)));
        } else if (path.contains("com.atlashxm")) {
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(d -> d.findElement(By.id(path)));
        }
    }

    public void sendKeysByPath(String path, String value) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.clear();
            element.sendKeys(value);
        } else if (path.contains("com.atlashxm")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.id(path)));
            element.clear();
            element.sendKeys(value);
        } else if (path.contains("//*") || path.contains("/html")) {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.clear();
            element.sendKeys(value);
        }

    }

    public void verifyElement(String path, String expectedValue) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(path)));
                WebElement element = androidDriver.findElement(By.xpath(path));
                String actualText = element.getText();
                System.out.println(actualText);
                softAssert.assertEquals(actualText, expectedValue);
            } else if (path.contains("com.atlashxm")) {
                new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                        .visibilityOfElementLocated(By.id(path)));
                WebElement element = androidDriver.findElement(By.id(path));
                String actualText = element.getText();
                System.out.println(actualText);
                softAssert.assertEquals(actualText, expectedValue);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void clickByPath(String path) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
                element.click();
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
                element.click();
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            } else if (path.contains("//*") || path.contains("/html")) {
                WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(Timeout));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
                element.click();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.id(path)));
            WebElement element = androidDriver.findElement(By.id(path));
            System.out.println(element.getText());
            if (element.getText().equals("Vacation")) {
                clickByPath(path);
            }
        } else if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(path)));
            WebElement element = androidDriver.findElement(By.xpath(path));
            System.out.println(element.getText());
            if (element.getText().equals("Vacation")) {
                clickByPath(path);
            }
        }
    }

    public void getElementText(String path) {
        if (path.contains("com.atlashxm")) {
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.id(path)));
            WebElement element = androidDriver.findElement(By.id(path));
            System.out.println(element.getText());
        } else if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(path)));
            WebElement element = androidDriver.findElement(By.xpath(path));
            System.out.println(element.getText());
        }
    }

    public void ScrollUp(String path, int scroll) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "up", "speed", 60));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "up", "speed", 60));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

    }

    public void ScrollDown(String path, int scroll) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "down", "speed", 60));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "down", "speed", 60));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }
    }

    public void selectDateFromCalendar(String path) {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
        WebElement element = wait.until(d -> d.findElement(AppiumBy.accessibilityId(path)));
        element.click();
    }

    public void waitForElementToDisappear(String path) {
        new WebDriverWait(androidDriver, Duration.ofSeconds(10)).until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath(path)));
    }

    public void Scroll(String text) {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
    }

    public String[] RandomNameGenerator() {
        NameGenerator generator = new NameGenerator();
        String name = String.valueOf(generator.generateName());
        String[] splitName = name.split(" ");
        return splitName;
    }

    public void VerifyImageDisplayed(String path, String expectedValue) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(path)));
        WebElement image = webDriver.findElement(By.xpath(path));
        boolean imagePresent = image.isDisplayed();
        Assert.assertTrue(imagePresent, "No image exist");
    }

    public void getListElementsbyClass(String path, String selectValue) {
        List<WebElement> listOfElements = webDriver.findElements(By.className(path));
        for (WebElement e : listOfElements) {
            if (e.getText().equals(selectValue)) {
                e.click();
                break;
            }
        }
    }

    public void getListElementsbyPath(String path, String selectValue) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
            System.out.println("size of list is " + listOfElements.size());
            for (WebElement e : listOfElements) {
                if (e.getText().equals(selectValue)) {
                    e.click();
                    break;
                }
            }
        } else if (path.contains("com.atlashxm")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(path)));
            System.out.println("size of list is " + listOfElements.size());
            for (WebElement e : listOfElements) {
                wait.until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(path))));
                if (e.getText().equals(selectValue)) {
                    e.click();
                    break;
                }
            }
        }
    }

    public void writeValuesInConfigFile(String property, String value) throws IOException {
        Properties prop = new Properties();
        prop.remove(property, value);
        prop.put(property, value);
        FileOutputStream file = new FileOutputStream("./src/Config.properties", true);
        prop.store(file, "");
        System.out.println("Data written");
    }

    public void Tap(String path) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                RemoteWebElement element = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
                androidDriver.executeScript("mobile: clickGesture", ImmutableMap.of(
                        "elementId", element.getId()));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            } else if (path.contains("com.atlashxm")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                RemoteWebElement element = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
                androidDriver.executeScript("mobile: clickGesture", ImmutableMap.of(
                        "elementId", element.getId()));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SwipeLeft(String path) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "left",
                        "percent", 0.75
                ));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            } else if (path.contains("com.atlashxm")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
                ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "left",
                        "percent", 0.75
                ));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SwipeRight(String path) {
        try {
            if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "right",
                        "percent", 0.75
                ));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            } else if (path.contains("com.atlashxm")) {
                WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
                ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "right",
                        "percent", 0.75
                ));
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectYearFromCalendar(String expectedYearValue, String valuesPath, String scrollListPath) throws InterruptedException {
        String year = "";  // Initial year value
        List<WebElement> listOfYears;
        WebElement yearOption = null;
        while (!year.equals(expectedYearValue)) {
            listOfYears = androidDriver.findElements(By.id(valuesPath));
            System.out.println("Number of elements: " + listOfYears.size());
            for (WebElement e : listOfYears) {
                year = e.getText();
                System.out.println("THIS IS VALUE OF E " + year);
                System.out.println("Selected Year = " + year + " Expected Year = " + expectedYearValue + " = " + year.equals(expectedYearValue));

                if (year.equals(expectedYearValue)) {
                    yearOption = e;
                    break;  // Exit the for loop as the expected value is found
                }
            }
            if (!year.equals(expectedYearValue)) {
                ScrollDown(scrollListPath, 70);  // Scroll down if the expected value was not found
            }
        }
        System.out.println("Year " + year + " is equal to Expected " + expectedYearValue);
        yearOption.click();
    }

    public void selectDateFromCalendar(String expectedDateValue, String valuesPath) throws InterruptedException {
        androidDriver.findElement(By.xpath(valuesPath.replace("day", String.valueOf(expectedDateValue)))).click();
    }
         /*   year = String.valueOf(e.getText());
            System.out.println("value of year is " + year);
            if (e.equals(expectedYearValue)) {
                e.click();
            } else {
                ScrollDown(scrollListPath, 50);
            }*/

    /*            String date = "";  // Initial year value
            List<WebElement> listOfDates;
            WebElement dateOption = null;
            while (!date.equals(expectedDateValue)) {
                listOfDates = androidDriver.findElements(By.id(valuesPath));
                System.out.println("Number of elements: " + listOfDates.size());
                for (WebElement e : listOfDates) {
                    date = e.getText();
                    System.out.println("THIS IS VALUE OF E " + date);
                    System.out.println("Selected Year = " + date + " Expected Year = " + expectedDateValue + " = " + date.equals(expectedDateValue));

                    if (date.equals(expectedDateValue)) {
                        dateOption = e;
                        dateOption.click();
                        break;  // Exit the for loop as the expected value is found
                    }
                }
            }*/
}
