package aPIs;

//Directly static methods can be called like get("htts://reqres.in/api/users?page=2")  
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApi {

	@Test
	public void getbookid() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		Response response = request.get();
		Assert.assertNotNull(response.getBody().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200, "both are equal");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		System.out.println(response.getBody().asPrettyString());

	}

	@Test
	public void getbookidbdd() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		User usr = RestAssured.given().when().get(RestAssured.baseURI).as(User.class);
		System.out.println(usr.data.get(0).getId() + usr.data.get(0).getEmail());
		usr.getPage();
		java.util.List<DataPOJO> dp = usr.getDp();
		for (DataPOJO d : dp) {
			System.out.println("Id : " + d.getId() + "  " + d.getEmail());
		}

		System.out.println(usr.support);
		Assert.assertEquals(usr.data.get(0).getId(), 7);
//Assert.assertEquals(rs.statusCode(), 200);

	}

	@Test
	public void myFifthRaTest() {
		// Alternatively AuthPayload can be used or JSONObject
		// AuthPayload authPayload = new AuthPayload("admin", "password123");
		// JSONObject requestParams = new JSONObject();

		HashMap<String, Object> requestParams = new HashMap<String, Object>();
		requestParams.put("username", "admin");
		requestParams.put("password", "password123");

		// body(authPayload)
		Response response = given().body(requestParams).contentType("application/json")
				.post("https://restful-booker.herokuapp.com/auth");

		String authResponse = response.getBody().print();
		// assertThat(authResponse, containsString("token"));
		System.out.println(authResponse);
	}

	@Test
	public void UserRegistrationSuccessful() {

		HashMap<String, Object> requestParams = new HashMap<String, Object>();
		requestParams.put("username", "admin");
		requestParams.put("password", "password123");

		System.out.println("Inside ... UserRegistrationSuccessful");
		baseURI = "https://restful-booker.herokuapp.com";

		given().contentType(ContentType.JSON).body(requestParams).when().post("/auth").then().statusCode(200).log()
				.all();

		System.out.println("Out of  ... UserRegistrationSuccessful");
	}

	/*
	 * @Test public void myFourthRaTest(){ Response response = given().
	 * get("https://restful-booker.herokuapp.com/booking/2"); BookingResponse
	 * responseBody = response.as(BookingResponse.class); String additionalneeds =
	 * responseBody.getAdditionalneeds(); System.out.println(additionalneeds);
	 * System.out.println(responseBody.firstname() + "  " +
	 * responseBody.lastname()); System.out.println("");
	 * 
	 * //System.out.println("Checkin : " +
	 * responseBody.bookingdates().checkin().toString());
	 * //System.out.println("Checkout: " +
	 * responseBody.bookingdates().checkout().toString());
	 * //assertThat(additionalneeds,is()); }
	 */

}
