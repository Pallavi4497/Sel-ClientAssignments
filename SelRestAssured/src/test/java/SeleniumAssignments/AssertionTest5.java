package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AssertionTest5 {
	
	WebDriver driver;
	String url = "https://chennaiiq.com/chennai/pincode-by-name.php";

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
		WebElement tab=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody"));
		List<WebElement> rows=tab.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++) {
			List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<=col.size();j++) {
				String pin1=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[4]/td[3]")).getText();
				System.out.println("Pincode of Abiramapuram: "+pin1);
				
				String pin2=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[5]/td[3]")).getText();
				System.out.println("Pincode of Adambakkam: "+pin2);
				
				Assert.assertTrue(pin1.equals(pin2));//fails as both the pin codes are different
				
				
			}
			break;
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
