package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.ExcelIntegration;


public class BaseClass extends AbstractTestNGCucumberTests {
	
	public static Properties p;
	
	//step2
	public static ExtentReports er;
	
	//step5 
	public static ExtentTest  test;
	
	//step6 
	public String testName,testDescription,testAuthor,testCategory;

	private static final ThreadLocal<RemoteWebDriver> tlDriver=new ThreadLocal<RemoteWebDriver>();
	
	
	public void setDriver() {
		tlDriver.set(new ChromeDriver());
	}
	
	
	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}
	
	public String filepath;
	@BeforeMethod
	public void preCondition() throws IOException {
		
		FileInputStream f=new FileInputStream("src/main/resources/French.properties");
	//declare Properties as globally and make it static
	   p=new Properties();
		
	   p.load(f);
		
		
	setDriver();
	getDriver().manage().window().maximize();
	getDriver().get("http://leaftaps.com/opentaps/control/main");
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}	
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	@DataProvider(name="fetchData" ,indices = {1})
	public String[][] setValue() throws IOException{
		
		String[][] readValue = ExcelIntegration.readValue(filepath);
		return readValue;
	}
	
//step1
	@BeforeSuite
	public void startReport() {
		
		ExtentHtmlReporter wb=new ExtentHtmlReporter("./report/loginReport.html");
		wb.setAppendExisting(true);
	    er=new ExtentReports();		
		er.attachReporter(wb);
		
	}
	
	//step3
	@AfterSuite
	public void stopReport() {
       er.flush();
	}
	
	//step4
	
	@BeforeClass
	public void testdetails() {
		//step 7
  test=er.createTest(testName, testDescription);
  test.assignAuthor(testAuthor);
  test.assignCategory(testCategory);
	}
	
	
	//step -9
	public void reportStep(String testDetails,String testStatus) throws IOException {

		if(testStatus.equalsIgnoreCase("pass")) {
			test.pass(testDetails, MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/ts"+takeSnap()+".png").build());
		}else if(testStatus.equals("fail")) {
			test.fail(testDetails,  MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/ts"+takeSnap()+".png").build());
		}
	}
	
	
	//take snapshot
	
	public int takeSnap() throws IOException {
		int random = (int)(Math.random()*99999);
		File scr = getDriver().getScreenshotAs(OutputType.FILE);
		File des=new File("./SnapShots/ts"+random+".png");
		FileUtils.copyFile(scr, des);
		return random;
	}
	
	
}
