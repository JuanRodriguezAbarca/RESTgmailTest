package GmailTest;

import GmailLoginPage.GmailLoginPage;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PageModel;
import utils.WebDriverClass;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public class GmailTest extends PageModel{

//    WebDriver driver = new FirefoxDriver();

    GmailLoginPage loginPage = new GmailLoginPage();



    @Given("^the user '([^\"]*)' loggs in using his password '([^\"]*)'$")
    public void theUserLoggsInUsingHisUserNameAndPassword(String userName, String password){
//        setTheDriver(new FirefoxDriver(), "https://gmail.com");

        navigate("https://gmail.com");
        loginPage.logInWithCredentials(userName,password);

    }
}
