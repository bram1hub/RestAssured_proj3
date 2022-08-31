package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	/**
	 * @return
	 */
	public static Map<String, String> setFileAndEnv() {

		String environment = System.getProperty("env");
		//environment="dev";
		try {
/*
 * Converting the Properties to Map is not necessary, we can directly use the porperties from properties object.
 */
			if (environment.equalsIgnoreCase("dev")) {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/inputs/dev.properties");
				propMain.load(fis);
				fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
				fileandenv.put("port", propMain.getProperty("portNo"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));
			} else if (environment.equalsIgnoreCase("qa")) {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/inputs/qa.properties");
				propMain.load(fis);
				fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
				fileandenv.put("port", propMain.getProperty("portNo"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));
			} else if (environment.equalsIgnoreCase("staging")) {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/inputs/staging.properties");
				propMain.load(fis);
				fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
				fileandenv.put("port", propMain.getProperty("portNo"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return fileandenv;
	}
	
	/**
	 * @return: return the 
	 */
	public static Map<String,String> getFileAndEnv(){
		if(fileandenv==null || fileandenv.isEmpty()) {
			fileandenv=setFileAndEnv();
		}
		return fileandenv;
	}

}
