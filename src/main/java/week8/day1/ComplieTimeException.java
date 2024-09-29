package week8.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplieTimeException {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File ds=new File("./data/img.png");
		FileUtils.copyFile(screenshotAs, ds);
		
		
		
		Thread.sleep(3000);
		//throws and Throw
		//Throws : exception given system
		//throw : user define exception
		
		throw new ArrayIndexOutOfBoundsException("array is empty");
	
	}

}
