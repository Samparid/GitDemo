package Day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class HeadersDemo {

    @Test(priority = 1)
    public void testHeader() {

        given()
                .when().get("https://google.com")
                .then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("server", "gws").log().headers();


    }

    @Test(priority = 2)
    public void getHeader() {

        Response response = given()
                .when().get("https://google.com");

        String headerValue = response.getHeader("Content-Type");
        System.out.println(headerValue);
        Headers headers = response.getHeaders();
        for (Header header : headers) {
            System.out.println(header.getName() + " " + header.getValue());

        }


    }
}
