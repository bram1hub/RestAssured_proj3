package usersApiTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import apiConfig.ApiPaths;
import baseApiTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPostsById extends BaseTest{
	@Test
	public void testGetPostById() {

		Response res = RestAssured.given().when().get(ApiPaths.apiPath.POSTS);
		
		System.out.println("Status Code : " + res.statusCode());
		System.out.println("Response Body : " + res.getBody().asString());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		JSONArray jres=new JSONArray(res.getBody().asString());
		System.out.println(jres);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// loop through all the objects in the Response array.
		for(int i=0;i<jres.length();i++) {
			//System.out.println(jres.get(i));
			//System.out.println(jres.get(i).getClass());
			
			JSONObject obj=jres.getJSONObject(i);
			//System.out.println(obj);
			//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(obj.get("author"));
			
			if((int)obj.get("id")==10 && obj.get("author").equals("InstagramAuthor")) {
				System.out.println("Instagram author found");
			}
		}
		
	}
}
