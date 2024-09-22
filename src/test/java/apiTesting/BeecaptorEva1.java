package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class BeecaptorEva1 {
	
	@Test
	public void SchedulaAHook() {
		
		RestAssured.baseURI="https://posthook-api.mock.beeceptor.com";
		
		given().contentType("application/json").when().post("/v1/hooks").then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void GetHooks() {
		
		RestAssured.baseURI="https://posthook-api.mock.beeceptor.com";
		
		given().get("/v1/hooks").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void GetahookbyID() {
		
        RestAssured.baseURI="https://posthook-api.mock.beeceptor.com";
		
		given().get("/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66").then().statusCode(200).log().all();
		
		
	}
	
	@Test
	public void UpdateHook() {
		
		RestAssured.baseURI="https://posthook-api.mock.beeceptor.com";
		
		JSONObject js = new JSONObject();
		
		js.put("name", "updated-project");
		
		js.put("domain", "api.example.com");
		
		js.put("headerAuthorization", "");
		
		js.put("minRetries", 1);
		
		js.put("retryDelaySecs", 5);
		
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().put("/v1/projects/").then()
		.statusCode(200).log().all();
		
	}
	
	@Test
	public void DeleteHookbyID() {
		
		RestAssured.baseURI="https://posthook-api.mock.beeceptor.com";
		
		given().contentType(ContentType.JSON).delete("/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66")
		.then().log().all();
		
	}
	
	
	
   

}
