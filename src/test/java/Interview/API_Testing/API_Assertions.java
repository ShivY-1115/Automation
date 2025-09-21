package Interview.API_Testing;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class API_Assertions {

    public static void main(String[] args)
    {
        RestAssured.baseURI = "https://reqres.in/api/users";

        RestAssured.given().when().get().then().body("name",containsString(""));
        RestAssured.given().when().get().then().
                body("name",equalTo("")).
                body("name",endsWith(""));
        RestAssured.given().when().get().then().body("name",hasItems("vamsi","srikar"));


    }
}
