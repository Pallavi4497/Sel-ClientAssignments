package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Test1 {
	WebDriver driver;
	String url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void f() {
		
		WebElement w=driver.findElement(By.className("multiselect-selected-text"));
		Select s1=new Select(w);
		s1.selectByIndex(2);
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
