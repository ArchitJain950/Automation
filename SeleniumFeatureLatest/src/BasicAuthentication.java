import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		////////Using Predicate class/////////////////////////////////
		
         Predicate<URI> uriPredicate = uri -> uri.getHost().contains("herokuapp");
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		////////////Direct URL method////////////////////////////////////// 
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}
