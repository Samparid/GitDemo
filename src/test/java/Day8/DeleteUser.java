package Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void test_DeleteUser(ITestContext context) {

        String bearerToken = "7832053cb2b60674af16beb447f16940e1901d25007dd1939b4d44c269e9a950";
        int id = (int) context.getAttribute("user_id");
        given().header("Authorization", "Bearer " + bearerToken).pathParam("id", id)
                .when().delete("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(204).log().all();
    }
}
