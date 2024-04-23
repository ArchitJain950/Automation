package LearningAutomation.SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningAutomation.SeleniumFrameworkDesign.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory
	
	@FindBy (css = ".hero-primary")
	WebElement confirm;
	
	
	//	Action
	public String verifyConfirmMessage()
	{
		return confirm.getText();
	}
	
}
