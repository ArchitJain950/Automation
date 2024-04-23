package LearningAutomation.SeleniumFrameworkDesign.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LearningAutomation.SeleniumFrameworkDesign.PageObject.CartPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.CheckoutPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.ConfirmationPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.LandingPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import LearningAutomation.SeleniumFrameworkDesign.Testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone extends BaseTest {
	
	@Test
	public void submitOrder() throws InterruptedException 
	{
		String productName = "ZARA COAT 3";

		
		//LandingPage lp = launchApplication(); (BeforeMethod)
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		LandingPage lp = new LandingPage(driver);	
//		lp.Goto();
		
		ProductCatalogue pc = lp.LoginApplication("Architjain@gmail.com", "Archit@123");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		pc.getProductList();
		pc.addProductToCart(productName);
		
	   //WebElement prod = products.stream().filter(s->s.findElement(By.cssSelector("b"))
	   //.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		CartPage cp = pc.goToCart();
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		Boolean isPresent = cp.verifyProductName(productName);
		Assert.assertTrue(isPresent);
		
		//Product verification on cart page
//		List<WebElement> allSelectedItems = driver.findElements(By.cssSelector(".cartWrap"));
//		Boolean isPresent = allSelectedItems.stream().anyMatch(s->s.findElement(By.cssSelector("h3"))
//				.getText().equals(productName)); 
//		Assert.assertTrue(isPresent);
		
		CheckoutPage cop = cp.checkout();
		
		//driver.findElement(By.xpath(" //button[text()= \"Checkout\"]")).click();
				//country
		String country = "India";
		cop.selectCountry(country);
		ConfirmationPage confp = cop.SubmitOrder();
		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "India").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("//section[contains(@class, 'ta-item')][2]")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
		//confirm
		//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confp.verifyConfirmMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	} 
	

}
