package qtriptest.APITests;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.hamcrest.object.HasToString;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import java.util.UUID;



public class testCase_API_01 {

@Test
public void testLogin(){
    RestAssured.baseURI="https://content-qtripdynamic-qa-backend.azurewebsites.net";
    String email = "s"+(Math.floor(Math.random()*10000))+"@gmail.com";
    String pwd = email;
    RequestSpecification rs = RestAssured.given();
    rs.contentType(ContentType.JSON);
    JSONObject jo=new JSONObject();
    jo.put("email",email);
    jo.put("password",pwd);
    jo.put("confirmpassword",email);
    rs.body(jo.toJSONString());
    Response responeRegister=rs.post("/api/v1/register");
    int registerResponseCode = responeRegister.getStatusCode();
    Assert.assertEquals(registerResponseCode, 201, "Response Code is not Matching for Register.");
    JsonPath jp=responeRegister.jsonPath();
    boolean istrue=jp.get("success");
    Assert.assertTrue(istrue);
    jo.clear();
    //Verify Login API
    rs.body("{\"email\": \"s1@gmail.com\",\"password\": \"s@gmail.com\"}");
    Response loginResponse =rs.post("/api/v1/login");
    int status= loginResponse.getStatusCode();
    // System.out.println(loginResponse.getBody().asString());
    Assert.assertEquals(status,201, "Response Code is not Matching For Login");
    JsonPath jp1=loginResponse.jsonPath();
    boolean istrue1=jp1.get("success");
    Assert.assertTrue(istrue1);
    // loginResponse.then().body(HasToString.hasToString("data.token"));
    // loginResponse.then().assertThat().body(HasToString.hasToString("data.id"));

}
    
    
   
}
