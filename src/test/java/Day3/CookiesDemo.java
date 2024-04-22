package Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {

    @Test(priority = 1)
    public void testCookies() {

        given()
                .when().get("https://google.com")
                .then()
                .cookie("AEC", "Ae3NU9Mx7TNcAZjVt9J6ODNIuOfrPym4KVFzt5NaKU2HN0sy6SiPOlmiag").log().all();

    }

    @Test(priority = 2)
    public void getCookiesInfo() {

        Response res = given()
                .when().get("https://google.com");
        String Cookie_Value = res.getCookie("AEC");
        Map<String, String> cookies = res.getCookies();
        for (String k : cookies.keySet()) {
            Cookie_Value = res.getCookie(k);
            System.out.println(k + " " + cookies.values());
        }


    }


}
