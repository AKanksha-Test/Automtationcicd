package rahulsheetyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()	//this will create report entry and give the object out of it
	{
		//ExtentReports,ExtentSparkReporter
		String Path=System.getProperty("user.dir")+"\\reports\\indedx.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(Path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("TestResults");
		ExtentReports extent =new ExtentReports();
	     extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Akanksha ");
		return extent;
		/*First we are create object of Extent Reports which is responsible for these happen.For that we are attaching the reporter.That reporter tells regarding meta data  about what is the report name ,what is title
		and all the details like if we want html reporter or spark reporter.They create report based on the meta data,what we send as an object*/
		//using extent object we are going to create entry for each and every test in the report
		//To create an entry for any test we will use extent.createTest(which will create entry for particular Test and whatever result is there,it will shown in hTML report)
		//For testNG listener
}
}
