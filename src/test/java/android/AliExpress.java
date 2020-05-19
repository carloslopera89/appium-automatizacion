package android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AliExpress {

    AndroidDriver driver;
    private By search = MobileBy.custom("search");
    @Before
    public void prepararTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "One plus 6");
        capabilities.setCapability("udid", "30bbe0e8");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app", "");
        capabilities.setCapability("appPackage", "com.alibaba.aliexpresshd");
        capabilities.setCapability("appActivity", ".home.ui.MainActivity");

        HashMap<String, String> custumFindModules = new HashMap<>();
        custumFindModules.put("ai", "test-ai-classifier");

        capabilities.setCapability("customFindModules", custumFindModules);


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void ejecutarTest() throws InterruptedException {

        Thread.sleep(2000);
        // driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Search']")).click();
        Thread.sleep(2000);
        driver.findElement(search).click();
        Thread.sleep(2000);
        driver.findElement(By.id("tv_search_view_goback_")).click();
        Thread.sleep(2000);

    }

    @After
    public void terminarTests() {
        driver.quit();
    }
}
