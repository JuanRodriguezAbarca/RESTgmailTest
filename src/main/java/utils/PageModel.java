package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public abstract class PageModel  {

    WebDriverClass webDriverClass = new WebDriverClass("firefox");

    private static final int DRIVER_WAIT_TIME = 60;
    protected static final Logger LOG = LoggerFactory.getLogger(PageModel.class);

    public WebDriver getDriver() {
        return webDriverClass.getRemoteWebDriver();
    }



    public void navigate(String url) {
        LOG.info("Navigating to : " + url);
        getDriver().get(url);
    }

    public WebElement waitForExpectedElement(final By by) {
//        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
//        return wait.until(visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }


}
