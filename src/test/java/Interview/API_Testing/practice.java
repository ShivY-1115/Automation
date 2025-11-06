package Interview.API_Testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class practice {

    public static void main(String[] args) throws JsonProcessingException {
        WireMockServer wiremock = new WireMockServer(9000);
        wiremock.start();

        wiremock.stubFor(get(urlEqualTo("/api/test"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type","application/json")
                        .withBody("{\"message\":\"Hello, World!\"}")
                )
        );
        HashMap<String,String> map = new HashMap<>();
         map.put("name","Srikar");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        wiremock.stubFor(post("/api/test")
                .withRequestBody(equalToJson(json))
                .willReturn(aResponse().withStatus(201)
                .withHeader("Content-Type","application/json")
                .withBody("{\"message\":\"User created successfully\"}")
                )
        );



        RequestSpecification reqs = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9000/api/test")
                .setBody(map)
                .addHeader("Content-Type","application/json").build();

       Response res = RestAssured.given().spec(reqs).post();
        System.out.println(res.getBody().asString());
        wiremock.stop();

        RestAssured.given().pathParam("name","Srikar")
                .when().get("http://localhost:9000/api/test")
                .then().statusCode(200);

    }
}
