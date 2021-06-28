package CIIAutomation.CIIAutomation;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyTestNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
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
	
	String responsebody=response.getBody().asString();
	
	System.out.println("status code is:" +statuscode);
	System.out.println("responsebody is:" +responsebody);

	}

}
