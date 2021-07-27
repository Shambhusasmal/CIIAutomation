package automationCII;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_ContentAPI {

	@Test(groups = { "functest"})
	public void PublishedTest()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://metrica-services-sel.cambridgeenglish.org/content-api/v1/publishedtests";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		List<String> productList = new ArrayList<>();
		productList.add("CompassMock");

		JSONObject requestParams = new JSONObject();
		requestParams.put("productIds", productList); 
		requestParams.put("startDateTime", "2021-01-22T11:47:37.083Z");
		requestParams.put("endDateTime", "2021-07-22T11:47:37.083Z");
		
		RequestSpecification httpRequest = RestAssured.given()
				.header("Authorization","Basic Y29udGVudGFwaTpzZWx1c2VyIUAxMjM=")
				.header("Content-Type","application/json")
				.body(requestParams.toString());
		
		

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.post();

		 Assertion Assert = new Assertion();
       
       // Verify status code
       Assert.assertEquals(response.getStatusCode(),200);
       
       
       //Verify body
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("Adv_T1_L"));

	}
	@Test
	public void QTIManifest()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://metrica-services-sel.cambridgeenglish.org/content-api/v1/qtimanifest";

		
		
		RequestSpecification httpRequest = RestAssured.given()
				.header("Authorization","Basic Y29udGVudGFwaTpzZWx1c2VyIUAxMjM=")
				.param("testId", "Adv_T1_L");
		
		

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET);

		 Assertion Assert = new Assertion();
       
       // Verify status code
      Assert.assertEquals(response.getStatusCode(),200);
	}

}
