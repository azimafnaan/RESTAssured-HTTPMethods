package Authorizations;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authetication {
	
	@Test(priority=1)
	
	void testBasicAuthentication()
	{
		given()
			.auth().basic("Admin", "admin123")
		.when()
			.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		.then()
			.statusCode(200)
//			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=2)
	
	void testDigestAuthentication()
	{
		given()
			.auth().digest("Admin", "admin123")
		.when()
			.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		.then()
			.statusCode(200)
//			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=3)
	void testBearerTokenAuthentication() {
		String bearerToken= "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";
		
		given()
			.headers("Authorization", "Bearer "+bearerToken)
		
		.when()
			.get("http://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
		
		
		
		
		
		
		
		
		
		
	}

}
