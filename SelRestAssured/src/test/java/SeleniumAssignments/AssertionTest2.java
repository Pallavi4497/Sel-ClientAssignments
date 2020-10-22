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

public class AssertionTest2 {

	WebDriver driver;
	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() throws Exception {
		driver.findElement(By.linkText("Medical Records")).click();
		driver.findElement(By.linkText("Search Patient")).click();
		
		WebElement w=driver.findElement(By.id("search_type"));
		Select sel=new Select(w);
		sel.selectByVisibleText("First Name");
		Thread.sleep(1000);
		
		driver.findElement(By.id("search_patient")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
