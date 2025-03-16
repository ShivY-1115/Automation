package Interview.API_Testing;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Testing {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://reqres.in/api/register";
	  String requestbody = " {  \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";
	  String header = "{  \"id\": \"4\",  \"token\": \"QpwL5tke4Pnpja7X4\"  }";
	  
	  Response response = RestAssured.given().header("Content-Type", "application/json").body(requestbody).post();
	  
	  System.out.println(response.getStatusCode());
	  
	  String response_str = response.toString();
	  
	  System.out.println(response_str);
  }
}
