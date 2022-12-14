package utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener implements ITestListener{
	
	protected static ExtentReports reports;
	protected static ExtentTest test;
	
	private static String resultPath=getResultPath();
	String reportLocation = "test-output/Reports/"+resultPath+"/";
	
	// Delete the file / directory
	public static void deleteDirectory(File dir) {
		if(dir.exists()) {
			File[] files=dir.listFiles();
			if(null!=files) {
				for(int i=0;i<files.length;i++) {
					System.out.println(files[i].getName());
					if(files[i].isDirectory()) {
						deleteDirectory(files[i]);
					}else {
						files[i].delete();
					}
				}
			}
		}
	}
	
	private static String getResultPath() {
		resultPath="test";
		if(!new File(resultPath).isDirectory()) {
			new File(resultPath);
		}
		return resultPath;
	}

	public void onTestStart(ITestResult result) {

		test=reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		reports=new ExtentReports(reportLocation+"ExtentReport.html");
		test=reports.startTest("");
	}

	public void onFinish(ITestContext context) {

		reports.endTest(test);
		reports.flush();
	}
	
}
