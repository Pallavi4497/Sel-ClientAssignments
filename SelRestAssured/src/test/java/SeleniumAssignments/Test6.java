package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test6 {
	WebDriver driver;
	String url="http://openclinic.sourceforge.net/openclinic/home/index.php";
	
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
		
		Dimension dim1=driver.manage().window().getSize();
		System.out.println("Before setting the size "+dim1);
		
		driver.manage().window().setSize(new Dimension(300, 600));
		
		Dimension dim2=driver.manage().window().getSize();
		System.out.println("After setting the size "+dim2);
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();

	}

}
