package Day2;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class WaysToCreatePostRequestBody {

    int id;

    //https://dummy.restapiexample.com/api/v1/create
    //{"name":"test","salary":"123","age":"23"}

    //post request body using hashmap
    @Test(priority = 1)
    public void testPostUsingHashmap() {

        HashMap hashMap = new HashMap();
        hashMap.put("name", "Niyatee");
        hashMap.put("job", "Arhitect");
        id = given()
                .contentType("application/json")
                .body(hashMap)
                .when().post("https://reqres.in/api/users/").jsonPath().getInt("id");


    }

    @Test(priority = 2)
    public void testDelete() {
        when().delete("https://reqres.in/api/users/" + id)
                .then().statusCode(204);

    }

    @Test
    public void testPostUsingorgjsonLibrary() {

        JSONObject data = new JSONObject();
        data.put("name", "samrat");
        data.put("job", "QA");

        given()
                .contentType("application/json")
                .body(data.toString())
                .when().post("https://reqres.in/api/users/")
                .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void testPostusingPOJO() {
        Pojo_PostRequest pojoPostRequest = new Pojo_PostRequest();
        pojoPostRequest.setName("Nihar");
        pojoPostRequest.setJob("Doctor");

        given()
                .contentType("application/json")
                .body(pojoPostRequest)
                .when().post("https://reqres.in/api/users/")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void testPostUsingExternalFile() throws FileNotFoundException {

        File file = new File("/Users/samratkeshriparida/IdeaProjects/RestAssuredTraining/src/test/java/Day2/Body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        given()
                .contentType("application/json")
                .body(jsonObject.toString())
                .when().post("https://reqres.in/api/users/")
                .then()
                .statusCode(201)
                .log().all();

    }

}
