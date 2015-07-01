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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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


    private static WebDriver driver;


    public static WebDriver getInstance() {

        if (driver == null) {
            WebDriverClass.driver = driverSelector();
        }
        return driver;
    }

        public static WebDriver driverSelector(){

         String driverType = System.getProperty("driver");
        LOG.info("Driver loading is "+driverType);
        switch(driverType){

            case "firefox":
                    return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "ie":
                return new InternetExplorerDriver();
            default:
                throw new ExceptionInInitializerError("No driver loaded");

        }
    }



}


