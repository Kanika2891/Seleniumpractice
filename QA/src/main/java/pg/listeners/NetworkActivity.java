package pg.listeners;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.network.model.RequestId;
import org.openqa.selenium.devtools.v122.network.model.Response;
import org.openqa.selenium.devtools.v122.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkActivity {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools dt=driver.getDevTools();
        final RequestId[] requestIds = new RequestId[1];

		dt.createSession();
		dt.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dt.addListener(Network.responseReceived(), response ->	
		{
           /* requestIds[0] = response.getRequestId();
            String  responseBody = dt.send(Network.getResponseBody(requestIds[0])).getBody();
            System.out.println(responseBody);*/
			
			Response res= response.getResponse();
			String url=res.getUrl();
			
            System.out.println("URL - " + res.getUrl());
            System.out.println("Status - " + res.getStatus());
            System.out.println("Headers - " + res.getHeaders());
            System.out.println("Header text - " + res.getHeadersText());
		});
		
		driver.get("https://qa-gateway.hydrogenpay.com?transactionId=aef70000-64cc-6e07-d0f3-08dc548ff092");
	}

}
