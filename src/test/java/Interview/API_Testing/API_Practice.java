package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API_Practice {

    //RestAssured.baseURI = "https://reqres.in/api/users?page=2";
    //given().when

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api/users";

        Response res = RestAssured.given().queryParam("delay", 3).get();

        System.out.println(res.getBody().asString());
        System.out.println(res.getTime());
    }


    public static void basic_Auth() {
        Response resp = given().auth().basic("", "").when().get();


    }


    public static void pre_emptive_auth(){
        Response resp = given().auth().preemptive().basic("","").get();
    }

    public void OAuth2(){
        Response resp = given().auth().oauth2("").when().get();
    }

    public void Bearer_token(){
        RestAssured.given().header("Authorization","Bearer ***************").when().get().then().assertThat().
                statusCode(200);

        RestAssured.given().header("Authorization","Bearer ***************").when().get().then().
                statusCode(200);



    }

}