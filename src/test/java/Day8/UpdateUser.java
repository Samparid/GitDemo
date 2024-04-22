package Day8;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.ITestContext;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public void test_UpdateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Female");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "active");
        int id = (int) context.getAttribute("user_id");

        String bearerToken = "7832053cb2b60674af16beb447f16940e1901d25007dd1939b4d44c269e9a950";
        given().header("Authorization", "Bearer " + bearerToken).contentType(ContentType.JSON).pathParam("id", id).body(jsonObject.toString())
                .when().put("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(200).log().all();
    }
}
