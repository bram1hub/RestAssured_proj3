package apiConfig;

public class ApiPaths {

	public static final class apiPath{
		
		// REST services hosted on https://reqres.in
		
		public static final String GET_LIST_USERS ="/api/users?page=2";
		
		public static final String GET_SINGLE_USER ="/api/users/2";
		
		public static final String POST_CREATE_USER = "/api/users";
		
		public static final String PUT_USER="/api/users/2";
		
		public static final String DELETE_USER="/api/users/2";
		
		// REST Services setup using json-server
		
		public static final String PROFILES ="profile";
		
		public static final String POSTS ="posts";
		
		public static final String COMMENTS ="comments";
	}
}
