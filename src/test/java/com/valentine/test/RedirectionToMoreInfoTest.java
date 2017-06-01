package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedirectionToMoreInfoTest {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://awful-valentine.com/");
	}

	@Test
	public void testRedirectionToMoreInfoPage() {
		String titleOnHomePage = driver.findElement(By.cssSelector(".slide[style*='display: block'] .featured-title"))
				.getText();
		driver.findElement(By.cssSelector(".slide[style*='display: block'] .readmore")).click();

		String titleOnMoreInfoPage = driver.findElement(By.cssSelector(".category-title")).getText();

		Assert.assertEquals(titleOnMoreInfoPage, titleOnHomePage,
				"Title on 'More Info' page is different from title on Home page.");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
