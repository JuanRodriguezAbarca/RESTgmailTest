package GmailPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PageModel;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Juan_Rodriguez on 7/1/2015.
 */
public class GmailDraftAndCreation extends PageModel{


    private WebElement userLoggedIn(){
        return waitForExpectedElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"));
    }

    private WebElement composeEmailButton(){
        return waitForExpectedElement(By.xpath("//div[@gh='cm']"));
    }

    private WebElement emailReceiver(){
        return waitForExpectedElement(By.xpath("//div[@class='AD']/div/div/div[3]//table//table//textarea"));
    }

    private WebElement emailSubject(){
        return waitForExpectedElement(By.xpath("//div[@class='AD']/div/div/div[3]//form/div[3]/input"));
    }

    private WebElement 	goToDraftsButton(){

        return waitForExpectedElement(By.xpath("//a[starts-with(@title,'Drafts')]"));
    }

    private List<WebElement> mailsInTheBox(){
        return waitForExpectedElements(By.xpath("//div[@class='AO']/div/div/div/div[2]//table/tbody//td[6]"));
    }

    private WebElement closeComposeButton(){
        return waitForExpectedElement(By.xpath("//img[@alt='Close']"));
    }

    public void currentUserLogged(String userName){
        LOG.info("User name expected: "+userName);
        String userLogged = userLoggedIn().getText();
        LOG.info("User name found: "+userLogged);
        Assert.assertTrue("User is not logged in or wrong user is logged", userLogged.equalsIgnoreCase(userName));

    }

    public void composeDraft(String recipient, String topic){
        LOG.info("Creating a draft");
        composeEmailButton().click();
        emailReceiver().sendKeys(recipient);
        emailSubject().sendKeys(topic);
        closeComposeButton().click();
    }

    public void userNavigatesToDrafts(){
        LOG.info("Navigating to Drafts mail box...");
        goToDraftsButton().click();
    }

    public void userChecksTheMailBoxListForATopic(String topic){
        for(WebElement title:mailsInTheBox()){
            LOG.info("Current mail checked is: "+title.getText());
            if(title.getText().contentEquals(topic)){
                assertTrue("Mail not found",true);
            }
        }
    }
}
