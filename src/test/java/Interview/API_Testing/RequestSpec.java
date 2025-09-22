package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static void main(String[] args) {

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/users")
                .addHeader("x-api-key", "reqres-free-v1").build();

        Response res = RestAssured.given().spec(req).when().get();

        System.out.println(res.getBody().asString());

    }
}
