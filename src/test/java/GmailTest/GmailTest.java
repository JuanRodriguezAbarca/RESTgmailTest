package GmailTest;

import GmailPages.GmailDraftAndCreation;
import GmailPages.GmailLoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.PageModel;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */
public class GmailTest extends PageModel {


    GmailLoginPage loginPage = new GmailLoginPage();
    GmailDraftAndCreation drafter = new GmailDraftAndCreation();


    @Given("^the user '([^\"]*)' loggs in using his password '([^\"]*)'$")
    public void theUserLoggsInUsingHisUserNameAndPassword(String userName, String password) {

        navigate("https://gmail.com");
        loginPage.logInWithCredentials(userName, password);
        drafter.currentUserLogged(userName + "@gmail.com");

    }

    @And("^starts composing a new email providing recipient '([^\"]*)' and topic '([^\"]*)'$")
    public void userStartsComposingNewEmailProvidesRcipientAndTopic(String recipient, String topic) {
        drafter.composeDraft(recipient, topic);
    }

    @When("^user during mail composing navigates to drafts$")
    public void userDuringMailComposingNavigatesToDrafts() {
        drafter.userNavigatesToDrafts();
    }

    @Then("^verify email with title '([^\"]*)' is stored in draft's folder$")
    public void verifySpecificEmailIsInTheBox(String topic) {
        drafter.userChecksTheMailBoxListForATopic(topic);
    }
}
