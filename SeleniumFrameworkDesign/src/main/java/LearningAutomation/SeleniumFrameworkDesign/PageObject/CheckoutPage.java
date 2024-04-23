package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (css = "[placeholder = 'Select Country']")
	WebElement countryBox;
	
	@FindBy (xpath= "//button[contains(@class, 'ta-item')][2]")
	WebElement countrySelected;
	
	@FindBy (css = ".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	//	Action
	public void selectCountry (String countryname)
	{
		Actions a = new Actions(driver);
		a.sendKeys(countryBox, countryname).build().perform();
		
		waitForElementToAppear(results);
		countrySelected.click();
	}
	
	public ConfirmationPage SubmitOrder() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		submit.click();

		return new ConfirmationPage(driver);
	}

	
}
