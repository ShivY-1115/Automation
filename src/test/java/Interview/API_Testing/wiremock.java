package Interview.API_Testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;



public class wiremock {

    public static void main(String[] args) throws JsonProcessingException {

        HashMap<String,String> map = new HashMap<>();
        map.put("name","Vamsi");
        map.put("id","1");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(map);

        WireMockServer wireMockServer = new WireMockServer(9090);

        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(jsonBody)
                )
        );

        Response res = RestAssured.given().get("http://localhost:9090/api/user/1");

        System.out.println(res.jsonPath().getString("name"));

        wireMockServer.stop();


    }
}
