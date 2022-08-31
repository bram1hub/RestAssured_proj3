package baseApiTest;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportListener;
import utils.FileAndEnv;

@Listeners(ExtentReportListener.class)
public class BaseTest extends ExtentReportListener {

	@BeforeClass
	public void BaseTest() {

		// TODO: currently the environment is set via run configuration,
		// it should be parameterized, can be done from TestNg or directly providing the value in FileAndEnv.java
		
		Map<String, String> config = FileAndEnv.getFileAndEnv();
		RestAssured.baseURI = config.get("ServerURL");
		System.out.println("Base URL is : " + RestAssured.baseURI);

		//RestAssured.baseURI = "http://localhost:3000/";
	}
}
