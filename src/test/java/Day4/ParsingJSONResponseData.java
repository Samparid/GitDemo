package Day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJSONResponseData {

    @Test(priority = 1)
    public void testJsonResponse() {

        given().contentType(ContentType.JSON)
                .when().get("https://api.publicapis.org/entries")
                .then().statusCode(200).header("Content-Type", "application/json").body("entries[0].Category", equalTo("Animals"));
    }

    @Test(priority = 2)
    public void testJsonResponse2() {

        Response res = given().contentType(ContentType.JSON).when().get("https://api.publicapis.org/entries");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json");
        String Category = res.jsonPath().get("entries[0].Category").toString();
        Assert.assertEquals(Category, "Animals");

        //JSONObject class - >Search for category
        JSONObject jsonObject = new JSONObject(res.asString()); //converting response to json object type
        for (int i = 0; i < jsonObject.getJSONArray("entries").length(); i++) {
            String category = jsonObject.getJSONArray("entries").getJSONObject(i).get("Category").toString();
            System.out.println(category);

        }
        boolean status = false;
        for (int i = 0; i < jsonObject.getJSONArray("entries").length(); i++) {
            String category = jsonObject.getJSONArray("entries").getJSONObject(i).get("Category").toString();
            if (category.equals("Animals")) {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);

    }
}
