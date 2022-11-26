package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;

public class TestplaceBuild {
	
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setWebsite("http://google.com");
		ap.setPhone_number("(+91) 983 893 3937");
		
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		
		ap.setTypes(list);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		return ap;
	}
	
	public String deleteplacepayload(String place_id)
	{
		return "{\"place_id\":\""+place_id+"\"}";
	}



}
