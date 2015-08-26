package GmailTest;

import GmailPages.MethodsForRestImprementations;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created by Juan_Rodriguez on 8/12/2015.
 */
public class GmailREST {

    MethodsForRestImprementations mforRest = new MethodsForRestImprementations();

    protected static final Logger LOG = LoggerFactory.getLogger(GmailREST.class);

    public static final String CURRENT_URI = "http://gmail.com";

    @Given("^a get requests to the home page$")
    public void aGetRequestsToTheHomePage() {

        baseURI = CURRENT_URI;

        String cType = get().andReturn().getContentType();
        String sessionID = get().andReturn().getSessionId();
        Map<String, String> cookies = get().andReturn().getCookies();


        LOG.info("\n\tContent Type is: {}\n\tSessionID is: {}\n\t" +
                        "Cookies: {}\n\t",
                cType, sessionID, cookies.toString());

        expect().statusCode(200).get();

    }

    @When("^post requests using '([^\"]*)' and '([^\"]*)' for authentication$")
    public void postRequestUsingUserNameAndPasswordForAuthentication(String userName, String password) {

        baseURI = "https://developers.google.com";


        String response = given().contentType(ContentType.JSON).
                body("{\"scope\":[\"https://www.googleapis.com/auth/gmail.compose\"],\"response_type\":\"code\",\"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\"approval_prompt\":\"force\",\"access_type\":\"offline\"}").when().post("/oauthplayground/buildAuthorizeUri").asString();

        //TODO try to get the AuthorizationCode from this request

        JsonPath jsonPath = new JsonPath(response);

        boolean successfull = jsonPath.getBoolean("success");

        Assert.assertTrue(successfull);

        String autrizeUri = jsonPath.getString("authorize_uri");
        LOG.info("Authorization URI: {}",autrizeUri);


        System.out.println("First authentication step: \n" + response);

        String secResponse = given().contentType(ContentType.JSON).
                body("{\"token_uri\":\"https://www.googleapis.com/oauth2/v3/token\",\"code\":\"4/_dBBlypQF__lfuxiXhJpQd5TOWLrmspkFeYhboGWL98\"}").when().post("/oauthplayground/exchangeAuthCode").asString();

        System.out.println("Second authentication step: \n"+secResponse);


        //TODO maybe other way

        String responseLocation = given().
                body("Cookie: PREF=ID=1111111111111111:FF=0:LD=en:TM=1435073707:LM=1435156795:GM=1:V=1:S=Vo6TeUpFAHQ0cdPG; GAPS=1:emgoPJqyBPHa4eOrY4Uo29sSDiG6Xg:JwxcvB2L5h2QduoX; RMME=false; NID=70=n4EOMF77OMc5bD_84RcgjbZf0crHBIHhiuP3gT_Za-4UJeYERXV4BJN6TZ060sU62pOUswYbKrUdDzi-2F2-ig1WUntsOZIm1Wb8Wph0RE-5y_fp6-LfTD-aCX0v8LL3q28sVkRtn3m1uws_hPHvNbkMdyDf6f4lQMfzlavLdPruQB0NRw; SID=DQAAAPYAAAA3RsT-RVZbEji9LZlfE6usEXy8OqUTWfyKDsDNcjp7FM4xv9dOnRmuUyR8woBTOKNVeG8ROhDg9_MCkdqm6w0cnUFZ3b6H78nsFY8dXL-qH0tvUA4ErUfgPh8sFTuceWPNv7vJlO_OPvPy_AgXNhgVYEBgO8ipWciFKKZDgUXaFhXSd3mseVMAu-xHVCJUpubfolvUzTpZ8mF_G9cRf45rea7pqbDvi9KOK41xiftd8iJ8cCzzW3fMSuZVQ5nuMdadQwgwNxdyhtHChQSgywiwpw0IRxfRmqzBwv_YcHqxhBOlJW_TFEz8avFLrhxd-fmMyeoLK1tmHzUXvOmKruvX; LSID=doritos|s.AF|s.PL|s.youtube:DQAAAPcAAABQy_94z1oDXMQ2rGJmvTq1wC4PKskeV7G9l0PK6QJibGeUZsaPwY7NuT2o0V97AU4a567pQufht3U9aoQBQhuIBEhbJ_Q5KX1QUyH0WODwZih5zPBb23vcpvgtm7lL7p-aSPLdETW_WHA8I9E5TnC2PO-PUrB7uz9KXrEhVclIzxdJOd9PjHNiPsirf9_3UPhCMn1xuu1Rfinqhn09CRtpUM4CtX9C5WjUu-y79aOexRI37yltcEc4oDMoghfEed3Oh4KEEF7rt7sOlxnN4aHMXQUaQC0XfNwjHLpdvNiurj3w-v1Xrd0CEzfh6oCjuzm-4U3QYIgLlBl0wO88oc4j; HSID=Ac8QJCdbeRRVvmpho; SSID=AiOr0O3kS9BkGCGcP; APISID=lRjYzdmJNz8rbEb8/ATBXOL8KCk2j9mDGx; SAPISID=DAOo_R6x4Tk0Z8Rl/AEksbjY5SxRXmeFj5; ACCOUNT_CHOOSER=AFx_qI6W17c_fQ3rkIxO1_jAeTFy-IqtftOvpciOOiT0DOgfEhRe9B7JX6SWGQcoJSAGjvsXEJx03UXzZsY5ba3e182SGvutUGZ8CIhxFl0symyHHkpeJSQEUhYUz2_murSCpIHtp1yK\n" +
                        "Connection: keep-alive; bgresponse=%21ZGdCUiceN8inguxExSPjWH9z2EYCAAAALFIAAAALKgEd7YWrCCXBAZDNGaRPoJ4625H5PUXyyskPBZXwFEK89XDLPqEhyFKS5_rfvMtOd-LzaV5BiUIVDZhjqE_pm-42u0h1vEXECg9mcuJOJxiarGAsrrzodhSxJcHiZl4nR_KiVXs9Hb6eCOW7dl-3CcA1evTmQnq2rgVSfgShjo9oRv-jXBlcpXlEtMrYR7C9spmMuXbf-gn325MXW-5K4CcDGmtviHLrxQM6X7iBUM6RZtq5SlAU0-26-y3521-0-fSGAmnZrz8V5QQ2euy4EElKVwwlWAgL-INm8A6-tIoUopkvIldmNtRtAaiE6oKY1GF-rGZlxg2z6dJ7doGSpxZwE1WuNRHydkHVhc2T5RCJSSnCyQZbTWNN9Sj1RKzh&_utf8=%E2%98%83&state_wrapper=CqkCYWNjZXNzX3R5cGU9b2ZmbGluZSZyZXNwb25zZV90eXBlPWNvZGUmcmVkaXJlY3RfdXJpPWh0dHBzOi8vZGV2ZWxvcGVycy5nb29nbGUuY29tL29hdXRocGxheWdyb3VuZCZjb29raWVfcG9saWN5X2VuZm9yY2U9ZmFsc2UmY2xpZW50X2lkPTQwNzQwODcxODE5Mi5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSZkaXNwbGF5PXBhZ2UmcHJvbXB0PWNvbnNlbnQmc2NvcGU9aHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9nbWFpbC5jb21wb3NlJnNwZWNfY29tcGxpYW50PWZhbHNlJmFzPS02NjNlYmRmODU4NWRkZWQzEhUxMDIyODU3MDY5NTY0MjA5MTMyOTQY__aZ_bmIh5XuAQ&submit_access=true")
                    .post("https://accounts.google.com/o/oauth2/approval?as=-663ebdf8585dded3&hl=en&pageId=none&xsrfsign=APsBz4gAAAAAVdxxBqj1R5KCiZzE5-ciQR9Js5I6hrS_").asString();


//TODO figure out how to insert: Cookie: PREF=ID=1111111111111111:FF=0:LD=en:TM=1435073707:LM=1435156795:GM=1:V=1:S=Vo6TeUpFAHQ0cdPG; GAPS=1:emgoPJqyBPHa4eOrY4Uo29sSDiG6Xg:JwxcvB2L5h2QduoX; RMME=false; NID=70=n4EOMF77OMc5bD_84RcgjbZf0crHBIHhiuP3gT_Za-4UJeYERXV4BJN6TZ060sU62pOUswYbKrUdDzi-2F2-ig1WUntsOZIm1Wb8Wph0RE-5y_fp6-LfTD-aCX0v8LL3q28sVkRtn3m1uws_hPHvNbkMdyDf6f4lQMfzlavLdPruQB0NRw; SID=DQAAAPYAAAA3RsT-RVZbEji9LZlfE6usEXy8OqUTWfyKDsDNcjp7FM4xv9dOnRmuUyR8woBTOKNVeG8ROhDg9_MCkdqm6w0cnUFZ3b6H78nsFY8dXL-qH0tvUA4ErUfgPh8sFTuceWPNv7vJlO_OPvPy_AgXNhgVYEBgO8ipWciFKKZDgUXaFhXSd3mseVMAu-xHVCJUpubfolvUzTpZ8mF_G9cRf45rea7pqbDvi9KOK41xiftd8iJ8cCzzW3fMSuZVQ5nuMdadQwgwNxdyhtHChQSgywiwpw0IRxfRmqzBwv_YcHqxhBOlJW_TFEz8avFLrhxd-fmMyeoLK1tmHzUXvOmKruvX; LSID=doritos|s.AF|s.PL|s.youtube:DQAAAPcAAABQy_94z1oDXMQ2rGJmvTq1wC4PKskeV7G9l0PK6QJibGeUZsaPwY7NuT2o0V97AU4a567pQufht3U9aoQBQhuIBEhbJ_Q5KX1QUyH0WODwZih5zPBb23vcpvgtm7lL7p-aSPLdETW_WHA8I9E5TnC2PO-PUrB7uz9KXrEhVclIzxdJOd9PjHNiPsirf9_3UPhCMn1xuu1Rfinqhn09CRtpUM4CtX9C5WjUu-y79aOexRI37yltcEc4oDMoghfEed3Oh4KEEF7rt7sOlxnN4aHMXQUaQC0XfNwjHLpdvNiurj3w-v1Xrd0CEzfh6oCjuzm-4U3QYIgLlBl0wO88oc4j; HSID=Ac8QJCdbeRRVvmpho; SSID=AiOr0O3kS9BkGCGcP; APISID=lRjYzdmJNz8rbEb8/ATBXOL8KCk2j9mDGx; SAPISID=DAOo_R6x4Tk0Z8Rl/AEksbjY5SxRXmeFj5; ACCOUNT_CHOOSER=AFx_qI6W17c_fQ3rkIxO1_jAeTFy-IqtftOvpciOOiT0DOgfEhRe9B7JX6SWGQcoJSAGjvsXEJx03UXzZsY5ba3e182SGvutUGZ8CIhxFl0symyHHkpeJSQEUhYUz2_murSCpIHtp1yK
//        Connection: keep-alive
//        in the header
    }



}
