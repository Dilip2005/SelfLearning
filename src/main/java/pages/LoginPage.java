package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BaseClass {

	
	@When("Enter the Username as")
	public LoginPage enterUserName() throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys(p.getProperty("username"));
			reportStep("UserName Enter Successfully","Pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("Username Not Enter Successfuly","Fail");
		}
		return this;
	}
	@When("Enter the Password as")
	public LoginPage enterPassword() throws IOException {
		
		//syep 10
		try {
			getDriver().findElement(By.id("password")).sendKeys(p.getProperty("password"));
			//step 11
			reportStep("PassWord Enter Successfully","Pass");

		} catch (Exception e) {
			System.out.println(e);
			reportStep("Password Not Enter Successfuly","Fail");

		}
		
		return this;

	}
	
	@When("Click on LoginButton")
	public HomePage clickonLoginButtom() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("Login is Successful","pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("Login is not Successful", "Fail");
		}
	
		
		return new HomePage();
		
		
	}
	
	@Then("Verify login is Successful")
	public void verifyPage() {
		String title = getDriver().getTitle();
		
		if(title.contains("TestLeaf")) {
			System.out.println("login is successful");
		}else {
			System.out.println("login is not successful");
		}
	}

}
