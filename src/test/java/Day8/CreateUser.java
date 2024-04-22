package Day8;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {


    @Test
    public void test_CreateUser(ITestContext context) {

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");

        String bearerToken = "7832053cb2b60674af16beb447f16940e1901d25007dd1939b4d44c269e9a950";

        int id = given().header("Authorization", "Bearer " + bearerToken).contentType(ContentType.JSON).body(jsonObject.toString())
                .when().post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");
        System.out.println("Generated id is : " + id);
        context.setAttribute("user_id", id);

    }
}
