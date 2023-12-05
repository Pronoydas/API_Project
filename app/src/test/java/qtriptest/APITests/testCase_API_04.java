package qtriptest.APITests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class testCase_API_04 {


    @Test
    public void negative (){
    RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
    String email = "s1@gmail.com";
    String pwd = email;
    RequestSpecification rqs = RestAssured.given();
    rqs.contentType(ContentType.JSON);
    JSONObject jo=new JSONObject();
    jo.put("email",email);
    jo.put("password",pwd);
    jo.put("confirmpassword",email);
    rqs.body(jo.toJSONString());
    Response responeRegister=rqs.post("/api/v1/register");
    // int registerResponseCode = responeRegister.getStatusCode();
    // Assert.assertEquals(registerResponseCode, 400, "Response Code is not Matching for Register.");
    }
    }

  

