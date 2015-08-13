package utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Juan_Rodriguez on 7/2/2015.
 */
public class ScreenShotHook  extends PageModel{

    protected static final Logger LOG = LoggerFactory.getLogger(ScreenShotHook.class);
//    WebDriver driver = WebDriverClass.getInstance();

    @Before
    public void beforeTest(Scenario scenario) {
        LOG.info("Scenario Started: " + scenario.getName());
    }

    @After
    public void afterTest(Scenario scenario) {

        LOG.info("driver property contains currently: "+System.getProperty("driver"));
            try {

                Map<String,Object> screenSots = ScreenShotTaker.getScreenShotsForCurrentTest();
                for (Map.Entry<String,Object> screenShot : screenSots.entrySet()){
                    scenario.write(screenShot.getKey());
                    scenario.embed((byte[]) screenShot.getValue(),"image/png");
                }

                ScreenShotTaker.tidyUpAfterTestRun();

                if (scenario.isFailed()) {
                    scenario.write((driver.getCurrentUrl()));
                    byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenShot, "image/png");
                    driver.manage().deleteAllCookies();

                }
            } catch (WebDriverException wde) {
//                LOG.error(wde.getMessage());
            }

        LOG.info("Scenario Completed: " + scenario.getName());
    }

}
