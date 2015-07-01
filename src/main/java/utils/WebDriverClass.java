package utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public class WebDriverClass {

    protected static final Logger LOG = LoggerFactory.getLogger(WebDriverClass.class);

    protected final String driverType;
    private static WebDriver remoteWebDriver;


    public WebDriverClass(String driverType) {
        this.driverType = driverType;
        setRemoteDriver();
        LOG.info("Instantiating Driver as "+driverType);
    }

    public WebDriver setRemoteDriver(){
        switch (driverType){
            case "firefox":
                remoteWebDriver = new FirefoxDriver();

        }

        return  remoteWebDriver;
    }


    public WebDriver getRemoteWebDriver() {
        LOG.info("Commands to the driver");
        return remoteWebDriver;

    }

    public void close() {
        remoteWebDriver.quit();
    }


}


