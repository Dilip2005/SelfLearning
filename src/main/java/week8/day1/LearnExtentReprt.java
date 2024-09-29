package week8.day1;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReprt {

	public static void main(String[] args) throws IOException {

		//1. Set the path for the report
		ExtentHtmlReporter wb=new ExtentHtmlReporter("./report/loginReport.html");
		
		//to keep your previous report also
		wb.setAppendExisting(true);
		
		//2.Create object for Extent Reports
		ExtentReports er=new ExtentReports();
		
		//3. attach the data with physical file(combine step1 &step2)
		er.attachReporter(wb);
		
		//4.Create Testcase and add information
		ExtentTest test=er.createTest("LoginPage", "Login with DemoCsr and crmsfa");
	    test.assignAuthor("Dilip");
	    test.assignCategory("Sanity");
	    
	    //5.step level status pass/fail
	    test.pass("enterUserName",MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/img.png").build());
	    test.pass("enterPasseword",MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/img1.png").build());
	    test.fail("login Button");
	    
	    ExtentTest test1=er.createTest("LoginPage", "Login with DemoCSR2 and crmsfa");
	    test1.assignAuthor("Gokul");
	    test1.assignCategory("smoke");
	    
	    //5.step level status pass/fail
	    test1.pass("enterUserName");
	    test1.pass("enterPasseword");
	    test1.pass("login Button");
	    
	    //step 6
	    //extentreports object.flush
	    er.flush();
	    System.out.println("done");
	    
	    
	    
	    
	    
	
	
	}
	
	

}
