package test_base;

import org.testng.annotations.*;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeSuite
	
	public void redirectToTheWebServiceAPI()
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2";
		
	}

}
