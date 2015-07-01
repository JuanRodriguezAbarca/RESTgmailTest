package GmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PageModel;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public class GmailLoginPage extends PageModel{


    private WebElement loginUserNameTextBox(){
        return waitForExpectedElement(By.id("Email"));
    }

    private WebElement loginNextButton(){
        return waitForExpectedElement(By.id("next"));
    }

    private WebElement loginPasswordTextBox(){
        return waitForExpectedElement(By.id("Passwd"));
    }

    private WebElement loginSignInButton(){
        return waitForExpectedElement(By.id("signIn"));
    }

    public void logInWithCredentials(String userName, String password){
        LOG.info("Login in as: "+userName+" and "+password);
        loginUserNameTextBox().sendKeys(userName);
        loginNextButton().click();
        loginPasswordTextBox().sendKeys(password);
        loginSignInButton().click();
    }

}
