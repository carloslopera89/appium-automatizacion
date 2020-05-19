package ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Calendar {

    IOSDriver driver;

    @Before
    public void prepararTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", "13.4");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("udid", "C02AD56A-ED6E-4814-AA58-0AD1FFA9A4CA");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("bundleId", "com.apple.mobilecal");

        HashMap<String, String> custumFindModules = new HashMap<>();
        custumFindModules.put("ai", "test-ai-classifier");

        capabilities.setCapability("customFindModules", custumFindModules);


        driver = new IOSDriver<MobileElement>(new URL("http://localhost:4724/wd/hub"), capabilities);
    }

    @Test
    public void ejecutarTest() throws InterruptedException {

        Thread.sleep(2000);
        // driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Search']")).click();
        driver.findElementByCustom("ai:search").click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeSearchField[@name='Search']")).sendKeys("prueba");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancel']")).click();

    }

    @After
    public void terminarTests() {
        driver.quit();
    }
}
