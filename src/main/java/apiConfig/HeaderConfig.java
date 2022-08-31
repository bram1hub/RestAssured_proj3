package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {
	
	Map<String, String> headers;
	
	public Map<String, String> defaultHeaders(){
		headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		return headers;
	}
	
	public Map<String,String> headersWithToken(){
		headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		headers.put("Access_Token", "fjashashflskhdflksj hsdsafsadfs fsdf ssdfw453dfsdf f");
		headers.put("Jwt_Token", "fjashashflskhdflksj hsdsafsadfs fsdf ssdfw453dfsdf f");
		headers.put("Tenet_user", "test");
		
		return headers;
	}

}
