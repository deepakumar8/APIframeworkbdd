package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import Resources.APIresources;
import Resources.TestplaceBuild;
import Resources.Utils;

public class stepdefinition extends Utils {
	RequestSpecification rs;
	ResponseSpecification res;
	Response response;
	String responsecode;
	TestplaceBuild data = new TestplaceBuild();
	static String place_id;
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException
	{
		res = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		rs = 	given().spec(Request())
				.body(data.AddPlacePayload(name,language,address));

	
	}
	
	
	/*@Given("Add place Payload")
	public void add_place_payload() throws IOException 
	{
		
		
			
			
	
	}*/
	@When("user calls {string} api with {string} http request")
	public void user_calls_api_with_http_request(String resource, String httpmethod)
	{
		
		//constructor will be called with the values which we pass 
		APIresources resourceAPI = APIresources.valueOf(resource);
		
		
		System.out.println(resourceAPI.getresource());
		
		if(httpmethod.equalsIgnoreCase("POST"))
		
			response = rs.when().post(resourceAPI.getresource());
		else if(httpmethod.equalsIgnoreCase("GET"))
				response = rs.when().get(resourceAPI.getresource());
				
		
		
		//response = rs.when().post(resourceAPI.getresource())
				//.then().spec(res).extract().response();
			
			
			
			//System.out.println(responsecode);
	    
	}
	@Then("API should success with status code {int}")
	public void api_should_success_with_status_code(Integer int1) {
		
		assertEquals(response.statusCode(), 200);
	    
	}
	@And("{string} should be {string}")
	public void should_be(String Keyvalue, String expected) {
		
		assertEquals(getjsonpath(response, Keyvalue), expected);
	   
	}
	
	@And("verify place_Id created maps to {string} using {string}")
	public void verify_created_maps_to_using(String expectedname, String method) throws IOException {
		 place_id= getjsonpath(response, "place_id");
		rs = 	given().spec(Request()).queryParam("place_id", place_id);
		user_calls_api_with_http_request(method,"GET");
		String actualname = getjsonpath(response,"name");
		assertEquals(actualname, expectedname);
	    
	}
	
	
	
	@Given("Delete place Payload")
	public void delete_place_payload() throws IOException {
	   rs = given().spec(Request()).body(data.deleteplacepayload(place_id));
	}


}
