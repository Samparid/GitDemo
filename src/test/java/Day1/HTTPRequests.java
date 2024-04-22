package Day1;

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequests {
    int id;

    @Test(priority = 1)
    public void getUser() {
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    public void createUser() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "samrat");
        hashMap.put("job", "trainer");
        id = given()
                .contentType("application/json")
                .body(hashMap)
                .when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Niyatee");
        hashMap.put("job", "Arhitect");
        given()
                .contentType("application/json")
                .body(hashMap)
                .when().put("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = "updateUser")
    public void deleteUser() {
        when().delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204);
    }
}
