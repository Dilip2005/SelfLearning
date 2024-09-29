package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginwithLang extends BaseClass{


	@BeforeTest
	public void Value() {
		
		filepath="Login";
	}
	
	
	
	@Test()
	public void runnerz() throws IOException {
		
		LoginPage lp=new LoginPage();
		lp.enterUserName()
		.enterPassword()
		.clickonLoginButtom()
		.clickOnCrmsfa().clickonLeads();
	}
}
