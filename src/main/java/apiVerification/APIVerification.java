package apiVerification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListener;

public class APIVerification extends ExtentReportListener{
	
	// Method to validate the response code
	public static void verifyResponseCode(Response response, int resStatusCode) {
		
		try {
			Assert.assertEquals(response.getStatusCode(), resStatusCode);
			test.log(LogStatus.PASS, "Status Code Validation Passed - "+resStatusCode);
			
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}catch(Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
		
	}
	
	public static void verifyResponseKey(Response response, String key) {
		
		try {
			JSONArray jres = new JSONArray(response.getBody().asString());
			for(int i=0;i<jres.length();i++) {
				JSONObject obj=jres.getJSONObject(i);
			}
		}catch(JSONException e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
		
	}
	
	

}
