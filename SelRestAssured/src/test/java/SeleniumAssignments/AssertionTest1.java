package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AssertionTest1 {

	WebDriver driver;
	String url="https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		String fname=driver.findElement(By.name("firstName")).getAttribute("type");
		System.out.println("First Name Type is : "+fname);
		Assert.assertTrue(fname.equals("text"));
		
		String uname=driver.findElement(By.name("Username")).getAttribute("id");
		System.out.println("UserName ID is : "+uname);
		Assert.assertTrue(uname.equals("username"));
		
		String pwd=driver.findElement(By.name("Passwd")).getAttribute("type");
		System.out.println("Password Type is : "+pwd);
		Assert.assertFalse(pwd.equals("passwrd"));
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
