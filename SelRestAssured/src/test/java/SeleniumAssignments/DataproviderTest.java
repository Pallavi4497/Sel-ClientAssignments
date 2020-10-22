package SeleniumAssignments;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class DataproviderTest {
	
	WebDriver driver;
	String url="https://www.google.com";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
  @Test(dataProvider = "dp")
  public void f(String s) {
	  driver.findElement(By.id("input")).sendKeys(s);
	  System.out.println(s);
  }

  @DataProvider(name="dp")
  public Object[][] dp() {
    Object[][] datavals=new Object[2][1];
    datavals[0][0]="Selenium";
    datavals[1][0]="Rest Assured";

	return datavals;
  }
  
  @AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();

	}
}
