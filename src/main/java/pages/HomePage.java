package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{

	
	@When("Click on Crmsfa")
	public MyHomePage clickOnCrmsfa() throws IOException {
		try {
			getDriver().findElement(By.linkText("CRMSFA")).click();
			reportStep("Crmsfa is click succesful","pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("Crmsfa is not click","fail");
		}
		
		return new MyHomePage();

	}
	
	public LoginPage clickOnLogout() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("LogOut is Successful", "Pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("Logout is not Successful","fail");
		}
		
		return new LoginPage();

	}
	
}
