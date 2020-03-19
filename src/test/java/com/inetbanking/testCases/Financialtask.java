package com.inetbanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Financialtask {
	
	/* Login to the application with invalid credentials 
	 *  Validate the error message displayed on the screen
	 *  Close the browser at the end of the test
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trwm.financial.com");
		WebElement username = driver.findElement(By.id("loginNameInput"));
		WebElement password = driver.findElement(By.id("passwordInput"));
		WebElement login = driver.findElement(By.xpath("//*[@id=\"yui-gen0-button\"]"));
		String errormsg = "The entered user name/password combination is invalid.";
		username.sendKeys("example@gmail.com");
		password.sendKeys("password");
		login.click();
		boolean res = driver.getPageSource().contains(errormsg);

		if (res == true) {
			Assert.assertTrue(true);
			System.out.println("Test passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Test Failed");
		}

		driver.close();
	}

}
