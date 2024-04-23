package LearningAutomation.SeleniumFrameworkDesign.StepDefination;

import java.io.IOException;

import LearningAutomation.SeleniumFrameworkDesign.PageObject.LandingPage;
import LearningAutomation.SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import LearningAutomation.SeleniumFrameworkDesign.Testcomponents.BaseTest;
import io.cucumber.java.en.Given; 
import io.cucumber.java.en.When;

public class StepDefiniationImplimentation extends BaseTest{
	
	LandingPage landingPage;
	ProductCatalogue pc;
	@Given ("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^logged  in using the (.+) and (.+)$")
	public void Logged_in_username_pass(String username, String password)
	{
	     pc = lp.LoginApplication(username, password);
	}
	
	@When("^add (.+) to the cart$")
	public void add_toCart(String product)
	{
		pc.getProductList();
		pc.addProductToCart(product);
	}

}
