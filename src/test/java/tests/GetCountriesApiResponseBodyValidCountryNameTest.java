package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert; 
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test_base.TestBase;

public class GetCountriesApiResponseBodyValidCountryNameTest extends TestBase {

	@Test 
	public void getCountriesResponseBodyWithValidSpecificCountryNameTest()
	{
		RestAssured.basePath="/name";
		// Get the RequestSpecification of the  countries request
		RequestSpecification httpsRequest= RestAssured.given();
		// Return the Response from the server For     country . Store the response in a variable.
		Response	response = httpsRequest.request(Method.GET, "/Afghanistan");
		// Print the body of the message to see what response we will receive 
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		// Get the status code from the Response. In case of 
				// should get a status code of 200.
				int statusCode = response.getStatusCode();
				//assert that correct status code is returned.
				Assert.assertEquals(statusCode  , 200 );
				// Get the status line from the Response and store it in a variable called statusLine
				String statusLine = response.getStatusLine();
				assertTrue(statusLine.contains("HTTP/1.1 200 "));

	}






}
