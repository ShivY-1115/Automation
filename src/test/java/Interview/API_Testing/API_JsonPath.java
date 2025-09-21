package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.*;

public class API_JsonPath {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/api/users";

        Response res = RestAssured.given().get();

        int numa = res.jsonPath().getInt("data.id");

        String name = res.jsonPath().getString("data.name");

        boolean value = res.jsonPath().getBoolean("data.employedStatus");

        List<Integer> ids = res.jsonPath().getList("data");



    }
}
