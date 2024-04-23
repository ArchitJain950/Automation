import java.util.Optional;
import java.util.function.Consumer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.Request;
import org.openqa.selenium.devtools.v121.network.model.Response;

public class NetworkResult {

	public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
		
		DevTools devTool = driver.getDevTools();
		devTool.createSession();
		
		devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTool.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		}
		);
		
		devTool.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			System.out.println(res.getStatus());
		}
		);
		
		Thread.sleep(2000);
		driver.get("https://www.google.com");
	}

}
