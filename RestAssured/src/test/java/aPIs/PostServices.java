package aPIs;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostServices {
	@Test
	public void postservice() {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "krishna");
		map.put("job", "SI");
		map.put("id", "420");

		map.put("createdAt", "2023-01-27T09:12:04.667Z");

		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/api/users");
		request.contentType(ContentType.JSON);
		request.body(map);

		Response response = request.post();

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asPrettyString());
	}

	
	
	@Test
	public void putmethod()
	{
		RequestSpecification request=RestAssured.given();
		request.baseUri("https://reqres.in/api/users/2");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "kunagallakrishna");
		map.put("job", "SI");
		map.put("id", "420");

		map.put("createdAt", "2023-01-27T09:12:04.667Z");
		
		request.contentType(ContentType.JSON);
		request.body(map);
		
		Response   response=request.put();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
System.out.println(response.getBody().asPrettyString());	
	}
@Test
public void deletedresouce()
{
	RequestSpecification request=RestAssured.given();
	request.baseUri("https://reqres.in/api/users/2");
	
	Response response=request.delete();
	System.out.println(response.statusCode());
	
}

}
