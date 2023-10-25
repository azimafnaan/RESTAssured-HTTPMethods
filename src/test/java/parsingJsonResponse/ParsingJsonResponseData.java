package parsingJsonResponse;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJsonResponseData {
	
	@Test(priority=1)
	void testJsonResponse()
	{
		given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/store")
		.then()
			.statusCode(200)
			.body("book[0].title", equalTo("Sayings of the century"));
	}
}
