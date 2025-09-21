package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Testing_Options {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api/users";

        Response res = RestAssured.given().header("x-api-key", "reqres-free-v1").when().
                options();

        // Print status code
        System.out.println("Status Code: " + res.getStatusCode());

        // Print Allow header (contains available HTTP methods)
        String allowHeader = res.getHeader("Allow");
        System.out.println("Available Methods (from Allow header): " + allowHeader);

        String corsMethods = res.getHeader("Access-Control-Allow-Methods");
        System.out.println("Available Methods (from Access-Control-Allow-Methods): " + corsMethods);
    }
}
