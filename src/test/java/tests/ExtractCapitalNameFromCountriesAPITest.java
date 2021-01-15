package tests;



import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test_base.TestBase;

public class ExtractCapitalNameFromCountriesAPITest extends TestBase {
	Response response;
	String capital;
	@Test (priority = 0)
	public void testExtractCapitalNameFromCountriesAPI()
	{
		RestAssured.basePath="/name";
		response= RestAssured.given().contentType(ContentType.JSON).log().all().get("/Egypt");
	
		
		capital=(response.then().extract().path("capital")).toString();
		response.prettyPrint();
		System.out.println("Capital is : " + capital);
		
		int statusCode = response.getStatusCode();
		//assert that correct status code is returned.
		Assert.assertEquals(statusCode  , 200 );
	}
	
	@Test (priority = 1)
	public void testPassExtractedCapitalToCapitalAPI()
	{
		RestAssured.basePath="/capital";
		// We have a problem here as after casting capital var to String it will be saved like 
		//[Capital] after passing it to get()
		//it will be passed like /%5B{value}%5D 
		//Which in turn will return with 404 page not found
		response= RestAssured.given().contentType(ContentType.JSON).log().all().get(capital);
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		//assert that correct status code is returned.
		Assert.assertEquals(statusCode  , 200 );
		
	}
	

}
