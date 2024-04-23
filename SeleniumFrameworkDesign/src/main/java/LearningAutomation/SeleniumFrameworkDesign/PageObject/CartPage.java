package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (css = ".cartWrap")
	List<WebElement> cartItems;
	
	@FindBy (xpath = ".//button[text()= 'Checkout']")
	WebElement checkout;
	
	By productmatch = By.cssSelector("h3");	
	
	//	Action
	public Boolean verifyProductName(String productName)
	{
		List<WebElement> allSelectedItems = cartItems;
		Boolean isPresent = allSelectedItems.stream().anyMatch(s->s.findElement(productmatch)
				.getText().equals(productName)); 
		
		return isPresent;
	}
	
	public CheckoutPage checkout()
	{
		checkout.click();
		return new CheckoutPage(driver);
	}
	
	
}
