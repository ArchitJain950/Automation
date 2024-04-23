package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (id = "userEmail")
	WebElement loginId;
	
	@FindBy (id = "userPassword")
	WebElement passwordele;
	
	@FindBy (id = "login")
	WebElement submit;
	
	@FindBy (css = "[class*='flyInOut']")
	WebElement errormessage;
	
	//	Action
	public ProductCatalogue LoginApplication(String username, String password)
	{
		loginId.sendKeys(username);
		passwordele.sendKeys(password);
		submit.click();
		return new ProductCatalogue(driver);
	}
	
	public String InvalidLoginMessage()
	{
		waitForWebElementToAppear(errormessage);
		return errormessage.getText();
	}
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	
}
