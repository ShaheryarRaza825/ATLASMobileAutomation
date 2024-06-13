package Utils;

import Hooks.Hook;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        } else if (path.contains("com.atlashxm")|| path.contains("android:id")) {
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
                            "percentage", scroll, "direction", "up", "speed", 30));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "up", "speed", 30
                    ));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

    }

    public void ScrollDown(String path, int scroll) {
        if (path.contains("/hierarchy/") || path.contains("//android.view")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.xpath(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "down", "speed", 90));
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
            RemoteWebElement element = (RemoteWebElement) wait.until(d -> d.findElement(By.id(path)));
            androidDriver.executeScript("gesture: swipe",
                    ImmutableMap.of("elementId", element.getId(),
                            "percentage", scroll, "direction", "down", "speed", 90));
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

    public void SelectListElementsbyPath(String path, String selectValue) {
        int attempts = 0;
        boolean elementClicked = false;
        while (!elementClicked && attempts < 3) {
            try {
                if (path.contains("/hierarchy/") || path.contains("//android.view")) {
                    WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                    List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
                    System.out.println("size of list is " + listOfElements.size());
                    for (WebElement e : listOfElements) {
                        System.out.println(e.getText());
                        if (e.getText().equals(selectValue)) {
                            e.click();
                            elementClicked = true;
                            break;
                        }
                    }
                    break;

                } else if (path.contains("com.atlashxm") || path.contains("android:id")) {
                    WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(Timeout));
                    List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(path)));
                    System.out.println("size of list is " + listOfElements.size());
                    for (WebElement e : listOfElements) {
                        wait.until((ExpectedConditions.elementToBeClickable(By.id(path))));
                        System.out.println(e.getText());
                        if (e.getText().equals(selectValue)) {
                            e.click();
                            elementClicked = true;
                            break;
                        }
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Exception Message: "+e.getMessage());
                attempts++;
                System.out.println("Exception caught. Retrying attempt " + attempts);
            }
            ScrollUp(path, 90);
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

    public void selectValueFromScrollableList(String expectedValue, String valuesPath, String scrollListPath, String scrollDirection) throws InterruptedException {
        String initialValue = "";  // Initial year value
        List<WebElement> listOfValues;
        WebElement valueOptions = null;
        // Normalize expectedValue for regex
        String regexPattern = "\\b" + Pattern.quote(expectedValue.trim()) + "\\b"; // \b is a word boundary
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        int attempts = 0;
        boolean elementClicked = false;
        while (true && attempts <=5) {
            try {
                listOfValues = androidDriver.findElements(By.id(valuesPath));
                System.out.println("Number of elements: " + listOfValues.size());
                boolean matchFound = false;
                WebElement matchingElement = null;
                for (WebElement e : listOfValues) {
                    initialValue = e.getText().trim();
                    Matcher matcher = pattern.matcher(initialValue);
                    if (matcher.find()) {
                        valueOptions = e;
                        matchFound = true;
                        break; // Exit the for loop as the expected value is found
                    }
                }
                if(matchFound)
                {
                    System.out.println("Year " + initialValue + " is equal to Expected " + expectedValue);
                    valueOptions.click();
                    elementClicked = true;
                    break;
                }
                else {
                    if (scrollDirection.equals("Down")) {
                        ScrollDown(scrollListPath, 80);
                        attempts++; // Increment the number of attempts
                    } else if (scrollDirection.equals("Up")) {
                        ScrollUp(scrollListPath, 80);
                        attempts++; // Increment the number of attempts
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception caught is "+e);
            }

        }
    }

    public void selectDateFromCalendar(String expectedYear, int expectedMonth, int expectedDay, String dateValuesList) throws InterruptedException {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int expectedYearInt = Integer.parseInt(expectedYear);
        LocalDate expectedDate = LocalDate.of(expectedYearInt, expectedMonth, expectedDay);
        //androidDriver.findElement(By.xpath(valuesPath.replace("day", String.valueOf(expectedDateValue)))).click();
        // Format the expected date in the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedDate = expectedDate.format(formatter);

        // Construct the XPath dynamically
        String formattedXPath = String.format(dateValuesList, formattedDate);

        // Add explicit wait
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXPath)));

        // Click the date element
        dateElement.click();
    }

    /*public void ScrollToElement(String scrollPersonalInfoTab) {

    }*/

    public void ScrollToElement(String resourceId)
    {
        try {
            // Use UiScrollable to scroll until the element with the specified content description is visible
            androidDriver.findElement(AppiumBy.androidUIAutomator(   "new UiScrollable(new UiSelector().scrollable(true))." +
                    "scrollIntoView(new UiSelector().resourceIdMatches(\".*" + resourceId + ".*\"));"));
            androidDriver.findElement(AppiumBy.androidUIAutomator(   "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\").instance(0))"));
          //  androidDriver.findElement(AppiumBy.androidUIAutomator(   "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10);"));
/*            androidDriver.findElement(AppiumBy.androidUIAutomator(  "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().resourceIdMatches(\".*"+resourceId+".*\").text(\".*"+expectedText+".*\"))"));*/
            System.out.println("Scroll success");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found using UiScrollable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while scrolling: " + e.getMessage());
        }
    }

}