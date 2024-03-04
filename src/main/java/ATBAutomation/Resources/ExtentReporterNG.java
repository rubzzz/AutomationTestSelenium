package ATBAutomation.Resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReporterNG 
{
	
	public static ExtentReports getReportObject()
	{
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("ATB Automation");
	reporter.config().setDocumentTitle(" Test Results");
	
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Rubal Grewal");
	extent.createTest(path);
	return extent;
	
	
}}
