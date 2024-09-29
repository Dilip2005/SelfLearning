package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class Login_TC_001 extends BaseClass {	
	
	@BeforeTest
	public void Value() {
		
		filepath="Login";
		
		//step 8
		testAuthor="Dilip";
		testCategory="Smoke";
		testDescription="Login Sceaniro with Positive Value";
		testName="LoginPage";
	}
	
	
	
	@Test(dataProvider = "fetchData")
	public void runnerz(String uName,String pWd) throws IOException {
		
		LoginPage lp=new LoginPage();
		lp.enterUserName()
		.enterPassword()
		.clickonLoginButtom()
		.clickOnCrmsfa();
	}
}
