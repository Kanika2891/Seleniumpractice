package pg.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class API {
	public List<String> dataurl = new ArrayList<String>();

	public List<String> getUrl() {

		try {
			RestAssured.baseURI = "https://qa-api.hydrogenpay.com/bepayment/api/v1/Merchant";

			String token = "23470639081006338F4A440DD441E9EC288EA8714A996";

			String requestBody = "{\"amount\": \"100\", \"email\": \"kanika02@nagarro.com\",\"customerName\": \"Kanika\", \"isAPI\": false,\"currency\": \"NGN\" }";

			ResponseBody body = RestAssured.given().header("Authorization", "Bearer " + token)
					.contentType(ContentType.JSON).body(requestBody).post("/initiate-payment").getBody();

			System.out.println("Response Body is: " + body.asString());

			JsonPath jsonPathEvaluator = body.jsonPath();
			String transactionRef = jsonPathEvaluator.get("data.transactionRef");
			String url = jsonPathEvaluator.get("data.url");
			dataurl.add(transactionRef);
			dataurl.add(url);

			System.out.println("transactionRef is " + dataurl.get(0));
			System.out.println("url is " + dataurl.get(1));

		}

		catch (IndexOutOfBoundsException ie) {
			System.out.println("IndexOutOfBoundsException exception");

		}
		return dataurl;

	}
}

/*
 * JSONObject requestParams = new JSONObject();// JSON Object Creation
 * RequestSpecification request = RestAssured.given();
 * 
 * request.header("Authorization", "Bearer " + token).header("Content-Type",
 * "application/json")
 * .accept(ContentType.JSON).contentType("application/json");
 * 
 * requestParams.put("amount", 100); // Adding the information as key-value pair
 * in the JSON requestParams.put("email", "kanika02@nagarro.com");
 * requestParams.put("customerName", "Kanika"); requestParams.put("isAPI",
 * false); requestParams.put("currency", "NGN");
 * request.body(requestParams.toString());
 * 
 * Response response = request.post(
 * "https://qa-api.hydrogenpay.com/bepayment/api/v1/Merchant/initiate-payment");
 * ResponseBody body = response.getBody();
 */
