package Interview.API_Testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;



public class wiremock {

    public static void main(String[] args) throws JsonProcessingException {

        HashMap<String,String> map = new HashMap<>();
        map.put("name","Taylor Brown");
        map.put("id","1");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(map);

       // File fis = new File("C://Users//Srikar\\IdeaProjects\\Automation-TestNG\\src\\test\\resources\\nested-json.json");



        WireMockServer wireMockServer = new WireMockServer(9090);

        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("nested-json.json")
                )
        );

        Response res = RestAssured.given().get("http://localhost:9090/api/user/1");

        System.out.println(res.jsonPath().getString("name"));
        System.out.println(res.jsonPath().getList("roles"));
        System.out.println(res.jsonPath().getString("address.geo.lat"));
        System.out.println(res.jsonPath().getString("orders[0].delivery.expectedDate"));

        String ddd = res.jsonPath().getString("orders[0].delivery.expectedDate");
        LocalDate date = LocalDate.parse(ddd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date.getMonth());


        wireMockServer.stop();


    }
}
