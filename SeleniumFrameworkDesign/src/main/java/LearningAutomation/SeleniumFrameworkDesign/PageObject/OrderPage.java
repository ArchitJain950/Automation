package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (css = "tr td:nth-child(3)")
	List<WebElement> products;

	
	//	Action
	public Boolean verifyProductNameOnOrderPage(String productName)
	{
		List<WebElement> allSelectedItems = products;
		Boolean isPresent = allSelectedItems.stream().anyMatch(s->s
				.getText().equals(productName)); 
		return isPresent;
	}
	
	
}
