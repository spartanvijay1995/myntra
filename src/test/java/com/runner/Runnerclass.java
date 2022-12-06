package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.Baseclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




	@RunWith(Cucumber.class)
	@CucumberOptions(features = "C:\\Users\\admin\\eclipse-workspace\\myntra\\src\\test\\java\\com\\feature\\myntra.feature",
	glue={"com.stefdefinition"},
	monochrome = true
	,dryRun =false)

	public class Runnerclass {
		
		public static WebDriver driver =null;
		@BeforeClass
		public static void setup() {
			driver=Baseclass.browserlaunch("chrome");
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\admin\\eclipse-workspace\\myntra\\driver\\chromedriver1.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			
		}
		@AfterClass
		public static void teardown() {
			Baseclass.close();
			//driver.close();

		}
	}

