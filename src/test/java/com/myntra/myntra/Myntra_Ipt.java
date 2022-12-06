package com.myntra.myntra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra_Ipt {

	public static WebDriver driver;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Miniproject\\driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/?utm_source=perf_googl_BM_TROAS_SOK&gclid=CjwKCAjw2OiaBhBSEiwAh2ZSP67FbwQFHfKVdjzUqDZvB-pkpZjtelQf5OyFVewwst70tvQJnEQ6shoCm24QAvD_BwE");

	}

	public static void productCount() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(2000);
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
//		List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='product-base']"));
//		for (WebElement productName : allProducts) {
//			String text = productName.getText();
//			if(text.contains(s1)) {
//				System.out.println(text);
//			
//		}
//		}

	}

	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		productCount();
		minimumPriceOfAllProduct();

	}

}
