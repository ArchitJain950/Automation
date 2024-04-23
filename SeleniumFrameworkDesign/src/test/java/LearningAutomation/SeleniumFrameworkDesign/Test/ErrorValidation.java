package LearningAutomation.SeleniumFrameworkDesign.Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import LearningAutomation.SeleniumFrameworkDesign.Testcomponents.BaseTest;
import LearningAutomation.SeleniumFrameworkDesign.Testcomponents.Retry;

public class ErrorValidation extends BaseTest {
	
	@Test(groups= {"errorHandling"}, retryAnalyzer= Retry.class)
	public void WrongPasswordLogin()
	{
		lp.LoginApplication("Architjain@gmail.com", "1234567");
		String message = lp.InvalidLoginMessage();
		Assert.assertEquals(message, "Incorrect email r password.");
	} 

}
