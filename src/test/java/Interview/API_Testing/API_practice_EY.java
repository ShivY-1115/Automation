package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_practice_EY {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api/users";

        Response res = RestAssured.given().header("x-api-key", "reqres-free-v1").when().
                options();

        RestAssured.given().header("Authorization","Brearer ewwwwwwwwww");


    }
}
