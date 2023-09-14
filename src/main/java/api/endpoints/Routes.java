package api.endpoints;

/*
 * Swagger URI--> https://petstore.swagger.io
 * 
 * create user(post):https://petstore.swagger.io/v2/user
 * Get User(GET):https://petstore.swagger.io/v2/user/{{firstname}}
 * Update User(PUT) : https://petstore.swagger.io/v2/user/{{firstname}}
 * Delete User(DELETE) : https://petstore.swagger.io/v2/user/{{firstname}}
 * 
 * 
 */
public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Model
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store Model
		//Here we will crate store modele url's
	
	//Pet Model
			//Here we will crate Pet modele url's
		
}
