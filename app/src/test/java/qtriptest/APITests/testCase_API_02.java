package qtriptest.APITests;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.UUID;


public class testCase_API_02 {
   
    @Test
    public void searchCity(){
     RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
     RestAssured.basePath="/api/v1/cities";
     RequestSpecification rs = RestAssured.given();
     rs.queryParam("q", "beng");
     Response res=rs.request(Method.GET);
     JsonPath jp=res.jsonPath();
     int statusCode = res.getStatusCode();
     Assert.assertEquals(statusCode, 200,"Wrong Response Code !!");
     res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("/home/crio-user/workspace/pronoysunny-47-ME_API_TESTING_PROJECT/app/src/test/resources/SearchCityScheme.json")));
    //  System.out.println(jp.get("[]"));
    int count = jp.getList(".").size();
    Assert.assertEquals(count, 1, "Returning More than One Items");
    String word = jp.get("[0].description");
    Assert.assertEquals(word, "100+ Places","Response is not matching");

    }

 




}
