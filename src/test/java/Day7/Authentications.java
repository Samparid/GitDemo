package Day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    //Basic
    @Test(priority = 1)
    public void testBasicAuthentication() {
        given().auth().basic("postman", "password").when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true)).log().all();
    }

    //Digest
    @Test(priority = 2)
    public void testDigestAuthentication() {
        given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true)).log().all();
    }

    @Test(priority = 3)
    public void testPreemptiveAuthentication() {
        given().auth().preemptive().basic("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true)).log().all();
    }

    @Test(priority = 4)
    public void testBearerTokenAuthentication() {
        String bearerToken = "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";
        given().header("Authorization", "Bearer " + bearerToken)
                .when().get("https://api.github.com/user/repos")
                .then().statusCode(200).log().all();
    }

    @Test(priority = 5)
    public void testOAuth2Authentication() {
        given().auth().oauth2("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")
                .when().get("https://api.github.com/user/repos")
                .then().statusCode(200).log().all();
    }

    @Test(priority = 6)
    public void testAPIKeyAuthentication() {


    }
}
