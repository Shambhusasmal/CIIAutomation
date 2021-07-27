package automationCII;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class TC_001_ProductAPI {

	
	
	@Test(groups = { "functest"})
	
	void ProductAPI()
	{
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization","Basic cHJvZHVjdGFwaTpzZWx1c2VyIUAxMjM=");
		//headers.put("userId","");
		
		Response response = RestAssured.given()
			    //.baseUri("https://metrica-services-sel.cambridgeenglish.org/product-api/v1/products?InstitutionId=CambridgeOne")
			   // .basePath("user/details")
			    .headers(headers)
			    .get("https://metrica-services-sel.cambridgeenglish.org/product-api/v1/products?InstitutionId=CambridgeOne");
		
			
			//Print response in console window
		int statuscode =response.statusCode();
		System.out.println("status code is:" +statuscode);
		
		String responsebody=response.getBody().asString();
		
		
		System.out.println("responsebody is:" +responsebody);
	
		
		
	}
	
	
	
}
