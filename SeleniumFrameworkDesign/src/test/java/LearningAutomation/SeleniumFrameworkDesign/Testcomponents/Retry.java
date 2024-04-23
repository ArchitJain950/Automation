package LearningAutomation.SeleniumFrameworkDesign.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int start = 0;
	int max = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(start<max)
		{
			start = start+1;

			return true;
		}
		return false;

	}

}
