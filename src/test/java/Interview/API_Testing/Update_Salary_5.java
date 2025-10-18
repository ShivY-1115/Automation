package Interview.API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Update_Salary_5 {

    public static void main(String[] args)
    {
        int empID = 101;
        Response get_res = RestAssured.given().pathParam("id",empID).when().get("");

        float cur_Sal = get_res.jsonPath().getFloat("Salary");

        float updated_sal = cur_Sal*1.05f;

        RestAssured.given().pathParam("id",empID).body("{\"salary\": "+updated_sal+"}")
                .when().put();




    }
}
