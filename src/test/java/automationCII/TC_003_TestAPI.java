package automationCII;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.annotation.*;

public class TC_003_TestAPI {
	
	public void TestAPIIESLTSi() {
		
	}
	
	public static String Tin_ID;
	
	public void setTinID(String Tin_ID) {
		this.Tin_ID = Tin_ID;
	}
	public String getTinID() {
		return Tin_ID;
	}
	@Test(groups = { "functest"})
	public void LaunchIELTSi() throws IOException
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://metricadrdrill-services.cambridgeenglish.org/test-api/v1/launchtest";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		
		MetaDataDef metaData = new MetaDataDef();
		metaData.setIss("https://cup-lti-platform.herokuapp.com/platforms/2");
		metaData.setAud("pgHo4mR5fyQaISazt5J85cAVB64P0kDK");
		metaData.setSub("user-000-001-001");
		metaData.setNonCE("e9ff745c1702941cd669dd99c7a17f98");
		metaData.setName("Jane Doe");
		metaData.setGivenName("Jane");
		metaData.setFamilyName("Doe");
		metaData.setHi(null);
		metaData.setMiddleName("");
		metaData.setEmail("jane.doe@example.com");
		metaData.setPicture("http://picture.com/user.jpg");
		metaData.setIat(1576144239);
		metaData.setExp(1576144839);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Converting POJO to HashMap
		Map<String, Object> metaDataMap = 
				objectMapper.convertValue(metaData, new TypeReference<Map<String, Object>>() {});
		
		//String metaData="";
		JSONObject requestParams = new JSONObject();
		requestParams.put("attempt", 1); 
		requestParams.put("test", "IELTSiReadingMVP");
		requestParams.put("launchMetadata", metaDataMap);
		requestParams.put("institutionId", "CambridgeOne");
		requestParams.put("action", "Launch");
		requestParams.put("userId", "sengub2702IO7");
		
		RequestSpecification httpRequest = RestAssured.given()
				.header("Authorization","Basic dGVzdGFwaTpjYWFkbWluIUAxMjM=")
				.header("Content-Type","application/json")
				.body(requestParams.toString());
		
		

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.post();

		 Assertion Assert = new Assertion();
       
       // Verify status code
		 Map<String, String> responseMap = objectMapper.readValue(response.body().asString(), Map.class);
		 
      Assert.assertEquals(response.getStatusCode(),200);
      setTinID(responseMap.get("testInstanceId"));
      
      
}
	@Test
	public void TestResponse() {
		
		//TestAPIIESLTSi IeltsiInstance = new TestAPIIESLTSi();
		String tin_ID = getTinID();
		
		
		// Specify the base URL to the RESTful web service
				RestAssured.baseURI = "https://metricadrdrill-services.cambridgeenglish.org/testplayer-api/v1/testresponse/"+tin_ID;

				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given()
						.header("Authorization","Basic dGVzdHBsYXllcmFwaTpjYWFkbWluIUAxMjM=");
						
				Response response = httpRequest.request(Method.GET);

				 Assertion Assert = new Assertion();
		       
		       // Verify status code
			
		       Assert.assertEquals(200, response.getStatusCode());
	}
	@Test
	public void SaveResponse() {
		
		
		// Specify the base URL to the RESTful web service
				RestAssured.baseURI = "https://metricadrdrill-services.cambridgeenglish.org/testplayer-api/v1/saveresponse";
				String tin_ID = getTinID();
				
				ItemDefinition itemDef = new ItemDefinition();
				itemDef.setTestInstanceId(Integer.parseInt(tin_ID)); 
				itemDef.setTestId("IELTSiReadingMVP");
				itemDef.settimetaken(234333);
				itemDef.setIsSubmit(true);
				itemDef.setItem("IELTSiReadingMVP_1","af8dca77-c9ec-4eed-8356-91cf47e19a3c", "A");
				
				
				ObjectMapper objectMapper = new ObjectMapper();
				
				//Converting POJO to HashMap
				Map<String, Object> itemDataMap = 
						objectMapper.convertValue(itemDef, new TypeReference<Map<String, Object>>() {});
				
				JSONObject requestParams = new JSONObject();
				
				requestParams.put("response", itemDataMap);
				
				
				RequestSpecification httpRequest = RestAssured.given()
						.header("Authorization","Basic dGVzdHBsYXllcmFwaTpjYWFkbWluIUAxMjM=")
						.header("Content-Type","application/json")
						.body(requestParams.toString());
						
				Response response = httpRequest.post();

				Assertion Assert = new Assertion();
		       
		       // Verify status code
			  System.out.println(requestParams.toString());
		      Assert.assertEquals(response.getStatusCode(),200);
				
				
	}
}
