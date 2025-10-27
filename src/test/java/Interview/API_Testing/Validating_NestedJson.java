package Interview.API_Testing;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class Validating_NestedJson {

    public static void main(String[] args) {
        RestAssured.given()
                .when()
                .get("https://api.example.com/user/101")
                .then()
                .statusCode(200)
                .body("user.name", equalTo("Vamsi"))
                .body("user.address.city", equalTo("Hyderabad"))
                .body("user.orders[0].item", equalTo("Laptop"))
                .body("user.orders[1].price", equalTo(1500));
    }
}
