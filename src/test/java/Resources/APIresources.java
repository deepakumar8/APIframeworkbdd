package Resources;

public enum APIresources {

	AddplaceAPI("/maps/api/place/add/json"),
	GetplaceAPI("/maps/api/place/get/json"),
	DeleteplaceAPI("/maps/api/place/delete/json");
	
	private String resource;

	APIresources(String resource) {
		
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}



	
	
	
}
