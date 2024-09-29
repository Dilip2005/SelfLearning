package runner;

import org.testng.annotations.BeforeTest;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features/LoginPage.feature",
glue="pages",
monochrome = true,
publish = true
)


public class LoginWithCucumber_TC_002 extends BaseClass{

//	  @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }
	
	
	@BeforeTest
	public void setValues() {
		testAuthor="Dilip";
		testCategory="Sanity";
		testDescription="Run from Cucumber";
		testName="LoginFeature";
		
	}
	
	
	
	
}
//super keyword -access parent class data