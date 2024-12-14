package pg.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import pg.config.DriverFactory;

public class SimulateBankTransferAPI {
	
	public void simulatebanktransfer(String clientTransactionRef, String currency, String amount) {
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = "https://qa-api.hydrogenpay.com/bepayment/api/v1/Payment/simulate-bank-transfer";
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("content-type", "application/json");
		
	//	API gettranref= new API();
	//	List<String> Ref=gettranref.getUrl();

	//	String transactionRef=Ref.get(0); 
		DriverFactory df=new DriverFactory();
		
		System.out.println("simulate api started");
		String transRef=df.transRef;
		System.out.println("transac ref in simulate api is "+transRef);
	//	RestAssured.baseURI = "https://qa-api.hydrogenpay.com/bepayment/api/v1/Payment";
		
	//	String requestBody = "{\"clientTransactionRef\": transRef, \"currency\": \"NGN\",\"amount\": 100 }";

//		ResponseBody body = RestAssured.given().log().all().contentType(ContentType.JSON).
		//		body(requestBody).post("/simulate-bank-transfer").getBody();

	//	System.out.println("Response Body is: " + body.asString());
		
		RequestSpecification request = RestAssured.given().log().all();

		JSONObject requestParams = new JSONObject();// JSON Object Creation

		request.header("Content-Type", "application/json")
				.accept(ContentType.JSON).contentType("application/json");

		requestParams.put("clientTransactionRef",transRef); // Adding the information as key-value pair in the JSON
		requestParams.put("currency", "NGN");
		requestParams.put("amount", 100);
		request.body(requestParams.toString());

	//	Response response = request.post("https://qa-api.hydrogenpay.com/bepayment/api/v1/Payment/simulate-bank-transfer");
		
		StringEntity params = new StringEntity(createPayloadForSimulateAPI(clientTransactionRef, currency, amount));
		postRequest.setEntity(params);
		HttpResponse response = httpClient.execute(postRequest);
		
		//convert httpresponse to string
				String jsonString = EntityUtils.toString(response.getEntity());

				//convert sring to Json
				JSONParser parser = new JSONParser();  
				JSONObject json = (JSONObject) parser.parse(jsonString);
	}
	
	//creates payload for create issue post request
		private static String createPayloadForSimulateAPI(String clientTransactionRef, String currency, String amount) {
			return "{\r\n" + 
					"    \"fields\": {\r\n" + 
					"       \"project\":\r\n" + 
					"       {\r\n" + 
					"          \"key\": \""+ProjectName+"\"\r\n" + 
					"       },\r\n" + 
					"       \"summary\": \""+issueSummary+"\",\r\n" + 
					"	   \"description\": {\r\n" + 
					"          \"type\": \"doc\",\r\n" + 
					"          \"version\": 1,\r\n" + 
					"          \"content\": [\r\n" + 
					"				{\r\n" + 
					"                    \"type\": \"paragraph\",\r\n" + 
					"                    \"content\": [\r\n" + 
					"								{\r\n" + 
					"                                    \"text\": \""+issueDescription+"\",\r\n" + 
					"                                    \"type\": \"text\"\r\n" + 
					"								}\r\n" + 
					"							   ]\r\n" + 
					"				}\r\n" + 
					"					]\r\n" + 
					"						}, \r\n" + 
					"		\"issuetype\": {\r\n" + 
					"          \"name\": \"Bug\"\r\n" + 
					"       },\r\n" + 
					"      \"components\": [\r\n" + 
					"      {\r\n" + 
					"        \"id\": \""+componentId+"\"\r\n" + 
					"      }\r\n" + 
					"    ],\r\n" + 
					"    \"priority\": {\r\n" + 
					"      \"id\": \""+priority+"\"\r\n" + 
					"    },\r\n" + 
					"        \"labels\": [\r\n" + 
					"      \""+label+"\"\r\n" + 
					"    ],\r\n" + 
					"    	\"environment\": {\r\n" + 
					"      \"type\": \"doc\",\r\n" + 
					"      \"version\": 1,\r\n" + 
					"      \"content\": [\r\n" + 
					"        {\r\n" + 
					"          \"type\": \"paragraph\",\r\n" + 
					"          \"content\": [\r\n" + 
					"            {\r\n" + 
					"              \"text\": \""+env+"\",\r\n" + 
					"              \"type\": \"text\"\r\n" + 
					"            }\r\n" + 
					"          ]\r\n" + 
					"        }\r\n" + 
					"      ]\r\n" + 
					"    },\r\n" + 
					"    	\"assignee\": {\r\n" + 
					"      \"id\": \""+assigneeId+"\"\r\n" + 
					"    }\r\n" + 
					"}\r\n" + 
					"}";
		}
}

