package Day3;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameter {

    @Test
    public void testQueryAndPathParameters() {

        given().pathParam("mypath", "users") // path param
                .queryParam("page", 2) //query parameter
                .queryParam("id", 5) // query parameters
                .when().get("https://reqres.in/api/{mypath}")
                .then().statusCode(200).log().all();

    }
}
