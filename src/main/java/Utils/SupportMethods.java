package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.time.Duration;

public class SupportMethods {

    public void waitForVisibilityByPath(AndroidDriver driver, String path, long Timeout)
    {

        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).
                    until(d => d.FindElement(By.XPath(path)));
        }
        else if (path.contains("com.atlashxm"))
        {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(d => d.FindElement(By.Id(path)));
        }
    }
    public void sendKeysByPath(AndroidDriver driver, String path, String value)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(d => d.FindElement(By.xpath(path)));
            element.clear();
            element.sendKeys(value);
        }
        else if (path.contains("com.atlashxm"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(d => d.FindElement(By.Id(path)));
            element.clear();
            element.sendKeys(value);
        }

    }
    public void verifyElement(AndroidDriver driver, String Id, String message) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id))).getText().equals(message))
        {
            return;
        }
        else
        {
            throw new Exception("Text mismatched.");
            //System.out.println(driver.findElement(By.id((Id))).getText());

        }

    }
    public void clickByPath(AndroidDriver driver, String path)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(d => d.FindElement(By.xpath(path)));
            element.click();
        }
        else if (path.contains("com.atlashxm")||path.contains("android:id"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(d => d.FindElement(By.id(path)));
            element.click();
        }

    }
}
