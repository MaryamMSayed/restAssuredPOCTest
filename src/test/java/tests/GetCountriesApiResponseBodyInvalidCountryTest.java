package tests;

import org.testng.Assert; 
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test_base.TestBase;

public class GetCountriesApiResponseBodyInvalidCountryTest extends TestBase {
	 Response response;
		
	@Test (priority = 0)
	public void getCountriesResponseBodyWithInValidSpecificCountryNameTest()
	{
		RestAssured.basePath="/name";
		// Get the RequestSpecification of the  countries request
		RequestSpecification httpsRequest= RestAssured.given();
		 // Return the Response from the server For     country . Store the response in a variable.
		  response = httpsRequest.request(Method.GET, "/Maryam");
		 // Print the body of the message to see what response we will receive 
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		
	}
	
	@Test (priority = 1)
	
	public void validateResponseStatusCodeFailureTest()
	{
		// Get the status code from the Response. In case of 
		 // should get a status code of 200.
		 int statusCode = response.getStatusCode();
		 //assert that correct status code is returned.
		 Assert.assertEquals(statusCode  , 404 );
		
	}

}
