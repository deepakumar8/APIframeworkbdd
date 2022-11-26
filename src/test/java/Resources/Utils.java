package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	
	public RequestSpecification Request() throws IOException
	
	{
		if(req==null)
		{
			
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(Getglobalvalues("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addQueryParam("key", "qaclick123").addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	
	public String Getglobalvalues(String key) throws IOException
	{
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\deepakumar\\eclipse\\API Testing\\APIFramework\\src\\test\\java\\Resources\\global.properties");
		pro.load(file);
		return pro.getProperty(key);
		
	}
	
	public String getjsonpath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
