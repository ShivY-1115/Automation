package Interview.API_Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Testing_get {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	  
	  Response res= RestAssured.given().get();
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getBody().asString());
  }
}
