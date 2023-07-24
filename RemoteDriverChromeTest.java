package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverChromeTest {
	String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");
    public static void main(String[] args) {
        // Set the WebDriver URL for the remote server
        String remoteUrl = "http://192.168.29.247:4444/wd/hub"; // Replace with the actual remote URL

        // Set the Desired Capabilities for the remote Firefox browser
//        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        ChromeOptions options = new ChromeOptions();
//        options.merge(capabilities);

        // Create a Remote WebDriver instance
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(remoteUrl), options);
        } catch (MalformedURLException e) {
            System.out.println("Invalid remote URL: " + remoteUrl);
            return;
        }

        // Navigate to the web page
        driver.get("https://www.browserstack.com/users/sign_in");

        // Maximizing window
        driver.manage().window().maximize();

        // Retrieving web page title
        String title = driver.getTitle();
        System.out.println("The page title is: " + title);

        // Locating web elements
        WebElement uName = driver.findElement(By.id("user_email_login"));
        WebElement pswd = driver.findElement(By.id("user_password"));
        WebElement loginBtn1 = driver.findElement(By.id("user_submit"));

        // Perform actions on web elements
        uName.sendKeys("username");
        pswd.sendKeys("password");

        loginBtn1.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Print the resulting page URL
        String expectedUrl = "https://live.browserstack.com/dashboard";
        String resultingUrl = driver.getCurrentUrl();
        System.out.println("Resulting page URL is: " + resultingUrl);

        // Close the browser session
        driver.quit();
    }
}
