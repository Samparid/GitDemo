package Day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation(){

        given().when().get("https://dummy.restapiexample.com/api/v1/employees")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("EmployeeJsonSchema.json"));


    }
}
