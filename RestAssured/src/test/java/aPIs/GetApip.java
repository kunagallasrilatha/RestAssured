package aPIs;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApip {

	 @Test
	public void verificationofgetapi() {
		RequestSpecification request = RestAssured.given();

		request.baseUri("https://restful-booker.herokuapp.com/booking");

		Response respone = request.get();
		System.out.println(respone.getStatusCode());
		System.out.println(respone.getBody().asPrettyString());
		System.out.println(respone.getHeaders());

		Assert.assertNotNull(respone.getBody().asPrettyString());
		Assert.assertEquals(respone.getStatusCode(), 200);

	}

	//@Test
	public void postmethod() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("firstname", "srilatha");
		map.put("lastname", "rani");
		map.put("totalprice", "2023");
		map.put("depositpaid", "yes");
		HashMap<String, Object> bookingdates = new HashMap<String, Object>();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		map.put("bookingdates", bookingdates);
		map.put("additionalneeds", "Breakfast");

		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		
		request.contentType(ContentType.JSON);
        request.body(map);
        
		Response response = request.post();
		System.out.println(response.getStatusCode());

	}

	@Test
	public void postmethod2() {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("firstname", "sri");
		map.put("lastname", "mas");
		map.put("totalprice", "2012");
		map.put("depositpaid", true);
		HashMap<String, Object> bookingdates = new HashMap<String, Object>();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		map.put("bookingdates", bookingdates);
		map.put("additionalneeds", "Breakfast");

		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		request.contentType(ContentType.JSON);
		request.body(map);
		
		Response response=request.post();
		System.out.println(response.getStatusCode());
System.out.println(response.getStatusLine());
	}

}
