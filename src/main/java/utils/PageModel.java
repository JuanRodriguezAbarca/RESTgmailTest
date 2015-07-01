package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public abstract class PageModel {

    protected static final Logger LOG = LoggerFactory.getLogger(PageModel.class);
    WebDriver driver = WebDriverClass.getInstance();


    public WebElement waitForExpectedElement(By by) {

        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForExpectedElements(By by) {

        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void killBrowser() {
        driver.close();
    }
}



