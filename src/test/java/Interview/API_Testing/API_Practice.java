package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class API_Practice {

    //RestAssured.baseURI = "https://reqres.in/api/users?page=2";
    //given().when

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api/users";

        Response res = RestAssured.given().queryParam("delay",3).get();

        System.out.println(res.getBody().asString());
        System.out.println(res.getTime());
    }






}
