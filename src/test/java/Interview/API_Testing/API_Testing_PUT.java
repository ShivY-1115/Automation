package Interview.API_Testing;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class API_Testing_PUT {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/users?delay=3";

	  Response res = given().get();
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getBody());

      long time1 = res.getTime();
      System.out.println(time1);


      given().when().get("https://reqres.in/api/users?delay=3").then().time(lessThan(2000L));




  }
}
