package com.bliblioteca.estuadiantil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseTestCPE0101 {
	
	private WebDriver driver;
	//Locator
	By RegisterLinkLocator = By.linkText("Registro");
	By RegisterTextLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div/div/h5");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://bibliotecaqa.s3-website-us-east-1.amazonaws.com/index.html");
	}
	
	@Test
	public void test() {
		driver.findElement(RegisterLinkLocator).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		assertTrue(driver.findElement(RegisterTextLocator).isDisplayed());
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
}
