package LearningAutomation.SeleniumFrameworkDesign.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	 public static ExtentReports getReportObject()
	 { 
		 String path = System.getProperty("usre.dir")+"//report//index.html";
		 
		 ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		 reporter.config().setDocumentTitle("Test Result");
		 reporter.config().setReportName("webTEST");
		 
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Archit");
		 return extent;
	 }

}
