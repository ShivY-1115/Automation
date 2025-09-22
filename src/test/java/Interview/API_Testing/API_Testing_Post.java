package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.*;

public class API_Testing_Post {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 1000);
        payload.put("id", 102);
        payload.put("title", "API Automation");
        payload.put("body", "we're sending the post request through RestAssuered");


        Response res = RestAssured.given().when().body(payload).post("/posts");
        System.out.println(res.getStatusCode());

        Headers head = res.getHeaders();

        Header content_type = head.get("Content-Type");

        System.out.println(content_type);


    }
}
