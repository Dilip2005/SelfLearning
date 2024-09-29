package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.And;

public class MyHomePage extends BaseClass {

	@And("Click on Leads")
	public MyLeadsPage clickonLeads() {
		try {
			getDriver().findElement(By.linkText(p.getProperty("MyHomePage.Leads"))).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	return new MyLeadsPage();
	}
	
}
