package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforescenario() throws IOException
	{
		
		
		
		stepdefinition m = new stepdefinition();
		if(stepdefinition.place_id==null)
		{
		m.add_place_payload_with("deepak", "English", "Azadpur");
		m.user_calls_api_with_http_request("AddplaceAPI", "POST");
		m.verify_created_maps_to_using("deepak", "GetplaceAPI");
		}
				
		
	}

}

