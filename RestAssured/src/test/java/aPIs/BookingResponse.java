package aPIs;

//{
//"firstname": "Susan",
//"lastname": "Ericsson",
//"totalprice": 378,
//"depositpaid": true,
//"bookingdates": {
//  "checkin": "2018-11-23",
//  "checkout": "2018-12-03"
//},
//"additionalneeds": "Breakfast"
//}

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

@JsonProperty
private String firstname;
@JsonProperty
private String lastname;
@JsonProperty
private int totalprice;
@JsonProperty
private boolean depositpaid;
@JsonProperty
private BookingDates bookingdates;
@JsonProperty
private String additionalneeds;

public String firstname() {
	return firstname;
}

public String lastname() {
	return lastname;
}

public int totalprice() {
	return totalprice;
}

public boolean depositpaid() {
	return depositpaid;
}

public BookingDates bookingdates() {
	return bookingdates;
}

public String getAdditionalneeds() {
 return additionalneeds;
}



}
