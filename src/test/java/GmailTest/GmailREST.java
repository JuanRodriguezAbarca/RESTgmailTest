package GmailTest;

import GmailPages.MethodsForRestImprementations;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import com.jayway.restassured.config.JsonConfig;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.config.JsonConfig.jsonConfig;
import static com.jayway.restassured.config.RestAssuredConfig.newConfig;
import static org.hamcrest.Matchers.*;

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
        baseURI = "https://accounts.google.com";

        delete(baseURI).cookies();


        expect().statusCode(200).given().queryParam("Email",userName).queryParam("Passwd", password).when().post("/ServiceLoginAuth");

        expect().statusCode(200).given().when().post("/logout");


//        int status = get().andReturn().statusCode();
//        LOG.info("Status code when credentials are wrong: " + status);
//
//
//
//
//        given().auth().basic(userName, password).when().get().then().statusCode(200);


    }

}
