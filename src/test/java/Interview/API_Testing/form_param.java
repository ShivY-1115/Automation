package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class form_param {

    @Test
    public void testprogram(){
        RestAssured.baseURI ="";
        RestAssured.given().contentType(ContentType.URLENC)
                .formParam("username","john")
                .formParam("password","secrest")
                .when()
                .post("/submit")
                .then()
                .statusCode(200);
    }

}
