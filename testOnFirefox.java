package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.junit.Assert;


public class testOnFirefox {

	public static void main(String[] args){
		String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");
		System.setProperty("webdriver.firefox.driver", "/Users/utsavbanerjee/Downloads/");

		//Creating WebDriver instance
		WebDriver driver = new FirefoxDriver();
		
		//Navigate to web page
		driver.get("https://www.browserstack.com/users/sign_in");
		
		//Maximizing window
		driver.manage().window().maximize();
		
//		Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is : " +title);
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		
//		//Locating web element
		WebElement uName = driver.findElement(By.id("user_email_login"));
		WebElement pswd = driver.findElement(By.id("user_password"));
		WebElement loginBtn1 = driver.findElement(By.id("user_submit"));
//		
//
//
////		//Peforming actions on web elements
				uName.sendKeys("username");
				pswd.sendKeys("password");
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				loginBtn1.click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//				
//				
//
//				String actualUrl="https://live.browserstack.com/dashboard";
//				String expectedUrl= driver.getCurrentUrl();
////			
//				System.out.println("Resulting page is: " +expectedUrl);
//
////				Assert.assertEquals(expectedUrl,actualUrl);
//				
//				//Closing browser session
//				driver.quit();
	}
}