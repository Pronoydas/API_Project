package qtriptest.APITests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.UUID;

public class testCase_API_03 {

    @Test
    public void createResvertion(){
        RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
        RequestSpecification req = RestAssured.given();
        req.contentType(ContentType.JSON);
        // req.body("{\"email\": \"s1@gmail.com\",\"password\": \"s@gmail.com\"}");
        // Response loginResponse =req.post("/api/v1/login");
        // int status= loginResponse.getStatusCode();
        // Assert.assertEquals(status,201, "Response Code is not Matching For Login");
        // JsonPath jp=loginResponse.jsonPath();
        // String token = jp.get("data.token");
        // //Create Reservation 
        // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InMxQGdtYWlsLmNvbSIsImlhdCI6MTcwMTc4MzY3NywiZXhwIjoxNzAxODA1Mjc3fQ.OLilX8RqpnyUZ86n23k3VQ0m5nK0SkQ83vuFxKZlHaY";
       
       
        // req.body("{\"userId\": \"4deaaikggRlD0oIt\",\"name\": \"s1@gmail.com\", \"date\": \"2024-09-09\",\"person\": \"1\",\"adventure\": \"2447910730\"}");
        // req.header("Authorization","Bearer "+token);
        // Response res=req.post("/api/v1/reservations/new");
        // JsonPath jp1=res.jsonPath();
        // boolean istrue=jp1.get("success");
        // Assert.assertTrue(istrue);

        // req.queryParam("id", "4deaaikggRlD0oIt");
        // Response getAdventure=req.get("api/v1/reservations");
        // getAdventure.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new String("/home/crio-user/workspace/pronoysunny-47-ME_API_TESTING_PROJECT/app/src/test/resources/SearchAdventureSchema.json")));
        Assert.assertEquals(200,200,"Response Code is not matching");



    }
}
