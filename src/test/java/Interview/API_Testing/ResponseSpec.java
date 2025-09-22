package Interview.API_Testing;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpec {

    public static void main(String[] args) {

        ResponseSpecification resSpec = (ResponseSpecification) new ResponseSpecBuilder().
                expectBody("name",equalTo("vamsi")).
                expectContentType("application/json").
                expectStatusCode(200);
    }


}
