package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test3 {
	
	WebDriver driver;
	String url="http://www.popuptest.com/goodpopups.html";
	
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
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.linkText("Good PopUp #2")).click();
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows.size());
		
		int temp=0;
		String msg=null;
		
		for(String w:windows) {
			driver.switchTo().window(w);
			String title=driver.getTitle();
			if(title.equals(driver.findElement(By.xpath("/html/body/div/img")))) {
				temp=1;
				msg="Window Found";
				break;
			}
		}
		if(temp==1) {
			System.out.println(msg);
		}
		else if(temp==0){
			System.out.println("Window Not found");
		}
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
