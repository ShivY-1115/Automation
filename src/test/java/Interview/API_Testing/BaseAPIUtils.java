package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIUtils  {

    protected static RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    public BaseAPIUtils(){
        requestSpec = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/")
                .addHeader("x-api-key", "reqres-free-v1").build();

    }

    public static Response get(String endpoint, int res)
    {
        return RestAssured.given().when().spec(requestSpec).
                get(endpoint).
                then().
                statusCode(res).
                extract().response();
    }


}
