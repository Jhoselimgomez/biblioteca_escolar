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

public class CaseTestCPE0312 {
	
	private WebDriver driver;
	//Locator
	By registroLinkLocator = By.linkText("Registro");
	By registroTextLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div/div/h5");
	By userNameLocator = By.id("nombre");
	By lastNameLocator = By.id("apellidos");
	By emailLocator = By.id("email");
	By btnRegisterLocator = By.cssSelector("a[class='btn btn-primary']");
	By alertRegisterLocator = By.cssSelector("div[class=\"alert alert-warning alert-dismissible fade show\"]");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://bibliotecaqa.s3-website-us-east-1.amazonaws.com/index.html");
	}
	
	@Test
	public void test() {
		driver.findElement(registroLinkLocator).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(driver.findElement(registroTextLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("Daniel");
			driver.findElement(lastNameLocator).sendKeys("Lopez");
			
			driver.findElement(btnRegisterLocator).click();
			
			assertTrue(driver.findElement(alertRegisterLocator).getText().contains("Por favor revisa el campo correo, por favor llenalo."));
		} 
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
