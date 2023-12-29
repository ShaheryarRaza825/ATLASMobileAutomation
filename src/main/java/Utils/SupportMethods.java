package Utils;

import Hooks.Hook;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class SupportMethods {

    SoftAssert softAssert = new SoftAssert();
    Hook hook;
    public AndroidDriver driver = hook.getDriver();
    long Timeout = 20;
    public SupportMethods(AndroidDriver driver) throws MalformedURLException {
        try {
            this.driver = driver;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void waitForVisibilityByPath(String path)
    {

        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).
                    until(d -> d.findElement(By.xpath(path)));
        }
        else if (path.contains("com.atlashxm"))
        {
            new WebDriverWait(driver, Duration.ofSeconds(Timeout)).until(d -> d.findElement(By.id(path)));
        }
    }
    public void sendKeysByPath(String path, String value)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.clear();
            element.sendKeys(value);
        }
        else if (path.contains("com.atlashxm"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.id(path)));
            element.clear();
            element.sendKeys(value);
        }

    }
    public void verifyElement(String Id, String message) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
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
    public void clickByPath(String path)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.xpath(path)));
            element.click();
        }
        else if (path.contains("com.atlashxm")||path.contains("android:id"))
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
            WebElement element = wait.until(d -> d.findElement(By.id(path)));
            element.click();
        }

    }
        public String getvaluesfromconfigfile(String value) throws IOException, IOException {
            FileReader fr = new FileReader("C:\\Users\\FaizanJunani\\Desktop\\AutomationTraining\\TrainingProject-2\\TrainingProject\\src\\Config.properties");
            Properties prop = new Properties();
            prop.load(fr);
            String valueconfig = prop.getProperty(value);
            return valueconfig;
        }

}
