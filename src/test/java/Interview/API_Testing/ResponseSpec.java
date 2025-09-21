package Interview.API_Testing;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpec {

    public static void main(String[] args) {

        ResponseSpecification resspec = (ResponseSpecification) new ResponseSpecBuilder().expectContentType("Application/json")
                .expectStatusCode(200).expectBody("ststud",equalTo("mawa"));

    }
}
