package com.stefdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.Baseclass;
import com.runner.Runnerclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends Baseclass {
	public static WebDriver driver = Runnerclass.driver;
	public static int minprice;

	@Given("^user Launch The Url$")
	public static void user_Launch_The_Url() throws Throwable {
		launchURL("https://www.myntra.com/");
		//driver.get("https://www.myntra.com/");

	}

	@When("^user Find The Kids Project$")
	public static void user_Find_The_Kids_Project() throws Throwable {
		WebElement productName = driver.findElement(By.xpath("(//a[@href='/shop/kids'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(productName).build().perform();
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("//a[@href='/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false']"))
				.click();
	}

	@When("^user Find The Total Number Of Product$")
	public static void user_Find_The_Total_Number_Of_Product() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='product-base']"));
		int totalNumberOfProduct = allProducts.size();
		System.out.println(totalNumberOfProduct);

	}

	

	@When("^user Find The Minimum Price Of Product$")
	public static void user_Find_The_Minimum_Price_Of_Product() throws Throwable {
		Thread.sleep(2000);
		List<Integer> priceList = new ArrayList<>();
		Thread.sleep(2000);
		List<WebElement> allProductPrice = driver.findElements(By.xpath("//li[@class='product-base']//descendant::div[@class='product-price']/span/span[@class='product-discountedPrice']"));
		for (WebElement TotalNumberOfPrice : allProductPrice) {
			String priceText = getTextOnElement(TotalNumberOfPrice).replace("Rs. ", "");
			System.out.println(priceText);
			int priceValue = Integer.parseInt(priceText);
			
			priceList.add(priceValue);

		}
		 minprice = Collections.min(priceList);
		//String s1=Integer.toString(minPrice);
		System.out.println("MINIMUMPRICE:"+minprice);
	}

	@Then("^user Find The Minimum Price Of The Product Name$")
	public static void user_Find_The_Minimum_Price_Of_The_Product_Name() throws Throwable {
		WebElement minimumProductName = driver.findElement(By.xpath("//span[@class='product-discountedPrice'][text()="+minprice+"]//ancestor::div[@class='product-productMetaInfo']//child::h3"));
		String productName1 = getTextOnElement(minimumProductName);
		System.out.println(productName1);
	}

}
