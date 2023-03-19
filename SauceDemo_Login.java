package jar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SauceDemo_Login {

	WebDriver driver;
	String url="https://www.saucedemo.com/";
	String driverPath="..\\AutomationPractice\\Drivers\\chromedriver.exe";
	Actions actions;
	
	
	@BeforeSuite
		public void SetUp() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
	        options.addArguments("remote-allow-origins=*");
	        driver= new ChromeDriver(options);
	        driver.get(url);	        
	        actions = new Actions(driver);
	}
	
	
	@AfterSuite
		public void CloseNav() {
			driver.close();
		}

	@Test(description="Positive case")
		public void LoginPostive() throws InterruptedException{
			WebElement username=driver.findElement(By.id("user-name"));
			username.sendKeys("standard_user");
			Thread.sleep(2000);
			
			WebElement pass=driver.findElement(By.id("password"));
			pass.sendKeys("secret_sauce");
			Thread.sleep(2000);
		
			WebElement next=driver.findElement(By.name("login-button"));
			actions.moveToElement(next).click().perform();
			Thread.sleep(1000);
			
			WebElement success=driver.findElement(By.className("title"));
			String actualLabel = success.getText();
			String expectedLabel = "Products";
			Assert.assertEquals(actualLabel, expectedLabel, "Login Succesful!");
			
			}
	
	@Test(description="Negative Case")
		public void LoginNegative() throws InterruptedException{
			
			WebElement username=driver.findElement(By.id("user-name"));
			username.sendKeys("IncorrectUser");
			Thread.sleep(2000);
			
			WebElement password=driver.findElement(By.id("password"));
			password.sendKeys("incorrectPassword");
			Thread.sleep(2000);
			
			WebElement click=driver.findElement(By.name("login-button"));
			actions.moveToElement(click).click().perform();
			Thread.sleep(1000);
			
			WebElement failure=driver.findElement(By.tagName("h3"));
			String actualLabel = failure.getText();
			String expectedLabel = "Epic sadface";
			Assert.assertTrue(actualLabel.contains(expectedLabel));
			
	}
	
}