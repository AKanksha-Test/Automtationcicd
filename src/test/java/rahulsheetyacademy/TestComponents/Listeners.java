package rahulsheetyacademy.TestComponents;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import rahulsheetyacademy.resources.ExtentReportNG;

import java.io.IOException;

import org.testng.ITestContext;

public class Listeners extends BaseTest implements ITestListener {//This is one of the Interface Provided by TestNG. so our class Listeners class implements these Interface
//ITestListener gives some methods which we can utilize
ExtentTest test;
ExtentReports extent=ExtentReportNG.getReportObject();
@Override
public void onTestStart(ITestResult result)
//Before running any testng test,our code control first will reach to this block.It will execute the code present 
//onTest Start before it runs any test
//if any test is success or pass,then it will immediately come to this method after the test is success

{
 test = extent.createTest(result.getMethod().getMethodName());
 //String filepath=getScreenshot(result.getMethod().getMethodName());
// test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	
}
@Override
public void onTestSuccess(ITestResult result)
{
	
}
@Override
public void onTestFailure(ITestResult result){//if any test is fail,
//then immediately this block will get executes

test.fail(result.getThrowable());	
String filePath=null;
//try{
 //filePath=getScreenshot(result.getMethod().getMethodName());

//}catch(IOException e) {
//e.printStackTrace();
//}
//test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
}
@Override
public void onTestSkipped(ITestResult result)
{
	
}
}
