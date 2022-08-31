package usersApiTest;

import org.testng.annotations.Test;

import apiConfig.ApiPaths;
import baseApiTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProfileTestOne extends BaseTest {

	@Test
	public void testGetAllProfiles() {
		
		/*GET request and display the response.
		 * 
		 * RestAssured.given() .when() .get(ApiPaths.apiPath.PROFILES)
		 * .then().log().all();
		 */
		
		Response res=RestAssured.given().when().get(ApiPaths.apiPath.PROFILES);
		
		System.out.println("Status Code : "+res.statusCode());
		System.out.println("Response Body : "+res.getBody().asString());
	}
}
