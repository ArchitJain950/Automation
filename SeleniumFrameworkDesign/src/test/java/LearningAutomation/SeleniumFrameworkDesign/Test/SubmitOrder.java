package LearningAutomation.SeleniumFrameworkDesign.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LearningAutomation.SeleniumFrameworkDesign.PageObject.CartPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.CheckoutPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.ConfirmationPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.LandingPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.OrderPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import LearningAutomation.SeleniumFrameworkDesign.Testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {
	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData", groups="purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException 
	{
		ProductCatalogue pc = lp.LoginApplication(input.get("email"), input.get("pass"));
		pc.getProductList();
		pc.addProductToCart(input.get("product"));
		CartPage cp = pc.goToCart();
		Boolean isPresent = cp.verifyProductName(input.get("product"));
		Assert.assertTrue(isPresent);
		CheckoutPage cop = cp.checkout();
		cop.selectCountry(input.get("country"));	
		ConfirmationPage confp = cop.SubmitOrder();
		Assert.assertTrue(confp.verifyConfirmMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	} 
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderPageConfirmation()
	{
		ProductCatalogue pc = lp.LoginApplication("Architjain@gmail.com", "Archit@123");
		OrderPage op = pc.goToOrder();
		Boolean ismatch = op.verifyProductNameOnOrderPage(productName);
		Assert.assertTrue(ismatch);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//Old HASMAP 
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "Architjain@gmail.com");
//		map.put("pass", "Archit@123");
//		map.put("product", "ZARA COAT 3");
//		map.put("country", "India");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map.put("email", "Architjain@gmail.com");
//		map.put("pass", "Archit@123");
//		map.put("product", "ADIDAS ORIGINAL");
//		map.put("country", "India");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//LearningAutomation//SeleniumFrameworkDesign//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	//Old Data Provider
	
//	public Object[][] getData()
//	{
//		return new Object[][] {{"Architjain@gmail.com", "Archit@123", "ZARA COAT 3" , "India"},{"Architjain@gmail.com", "Archit@123", "ADIDAS ORIGINAL", "India" }};
//	}
	
	
}
