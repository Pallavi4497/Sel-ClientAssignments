package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test7 {
	WebDriver driver;
	String url = "https://www.instagram.com/accounts/login/?hl=en";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		WebElement phnnum=driver.findElement(By.name("username"));
		WebElement pwd=driver.findElement(By.name("password"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='xyz@gmail.com'", phnnum);
		js.executeScript("arguments[0].value='xyz@678'", pwd);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
