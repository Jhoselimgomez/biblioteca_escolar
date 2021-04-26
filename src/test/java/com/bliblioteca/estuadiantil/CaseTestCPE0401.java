package com.bliblioteca.estuadiantil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseTestCPE0401 {
	
	private WebDriver driver;
	//Locator
	By loginLinkLocator = By.linkText("Login");
	By loginTextLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div/div/h5");
	By btnLoguinLocator = By.cssSelector("a[class='btn btn-primary']");
	By alertLocator = By.xpath("//*[@id=\"msg\"]/div");
	Object textAA = new Object();
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://bibliotecaqa.s3-website-us-east-1.amazonaws.com/index.html");
	}
	
	@Test
	public void test() {
		driver.findElement(loginLinkLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(loginTextLocator).isDisplayed()) {
			driver.findElement(btnLoguinLocator).click();
			
			assertTrue(driver.findElement(alertLocator).getText().contains("Por favor revisa el campo email"));
		} 
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
