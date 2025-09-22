package Interview.API_Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Testing_get extends BaseAPIUtils {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	  
	  Response res= RestAssured.given().get();
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getBody().asString());
	  string();
  }


  public static void string(){
	  Response res = get("users?page=2",200);
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getBody().asString());
  }

}
