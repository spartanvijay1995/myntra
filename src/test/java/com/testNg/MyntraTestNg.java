package com.testNg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Baseclass;


public class MyntraTestNg extends Baseclass{
	
		public static WebDriver driver;

		@BeforeClass
		public static void browserSetUp() {
			browserlaunch("chrome");
			
		}

		

		@BeforeClass
		public static void urlLaunch() {
			launchURL("https://www.myntra.com/");

		}

		@Test(priority = 0)
		public static void productCount() throws InterruptedException {
			
			
			WebElement productName = driver.findElement(By.xpath("(//a[@href='/shop/kids'])[1]"));
			Actions a = new Actions(driver);
			a.moveToElement(productName).build().perform();
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//a[@href='/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false']"))
					.click();
			Thread.sleep(2000);
			List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='product-base']"));
			int totalNumberOfProduct = allProducts.size();
			System.out.println(totalNumberOfProduct);

		}

		@Test(priority = 1)
		public static void minimumPriceOfAllProduct() throws InterruptedException {
			Thread.sleep(2000);
			List<Integer> priceList = new ArrayList<>();
			Thread.sleep(2000);
			List<WebElement> allProductPrice = driver.findElements(By.xpath("//li[@class='product-base']//descendant::div[@class='product-price']/span/span[@class='product-discountedPrice']"));
			for (WebElement TotalNumberOfPrice : allProductPrice) {
				String priceText = TotalNumberOfPrice.getText().replace("Rs. ", "");
				System.out.println(priceText);
				int priceValue = Integer.parseInt(priceText);
				
				priceList.add(priceValue);

			}
			int minPrice = Collections.min(priceList);
			//String s1=Integer.toString(minPrice);
			System.out.println("MINIMUMPRICE:"+minPrice);
			WebElement minimumProductName = driver.findElement(By.xpath("//span[@class='product-discountedPrice'][text()="+minPrice+"]//ancestor::div[@class='product-productMetaInfo']//child::h3"));
			String productName1 = minimumProductName.getText();
			System.out.println(productName1);
		}

		

		@AfterClass
		public static void urlClose() {
			close();
			//driver.manage().deleteAllCookies();

		}
		@AfterTest
		public static void browserclose() {
			close();
			//driver.close();
			

		}

}
