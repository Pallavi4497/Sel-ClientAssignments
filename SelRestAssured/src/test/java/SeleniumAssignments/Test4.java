package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test4 {
	
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

	@Test
	public void f() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		List<WebElement> elist=driver.findElements(By.xpath("//ul[]@class='erkvQe']//li"));
		for(int i=0;i<elist.size();i++) {
			String val=elist.get(i).getText();
			if(val.contains("selenium tutorial")) {
				elist.get(i).click();
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();

	}

}
