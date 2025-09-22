package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class Schema_Validation {

    public static void main(String[] args)
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        File schema = new File("C://Users//Srikar//Downloads//JSON_Schema.json");
        RestAssured.given().
                when().
                get("/posts").
                then().
                body(JsonSchemaValidator.matchesJsonSchema(schema));

    }
}
