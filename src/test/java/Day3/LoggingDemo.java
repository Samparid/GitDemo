package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {

    @Test(priority = 1)
    public void testLogging() {

        given()
                .when().get("https://google.com")
                .then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("server", "gws").log().headers();


    }
}
