package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            caps.setCapability(MobileCapabilityType.UDID, new GlobalParams().getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, new GlobalParams().getDeviceName());
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
            caps.setCapability("systemPort", new GlobalParams().getSystemPort());
            caps.setCapability("chromeDriverPort", new GlobalParams().getChromeDriverPort());
            caps.setCapability("browserName","Chrome");
            caps.setCapability("chromedriverExecutable","C:/Users/eminc/OneDrive/Desktop/chromedriver.exe");


            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
