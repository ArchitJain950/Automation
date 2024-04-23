package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (css = ".mb-3")
	List<WebElement> productList;
	
	By productBy = By.cssSelector(".mb-3");
	By addToCartButton = By.cssSelector(".card-body button:last-of-type");
	By productText = By.cssSelector("b");
	By toastContainer = By.cssSelector("#toast-container");	
	By animation = By.cssSelector(".ng-animating");
	
	//	Action
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return productList;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(s->s.findElement(productText)
				.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName)
	{
		getProductByName(productName).findElement(addToCartButton).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDisAppear(animation);
	}
	
	
}
