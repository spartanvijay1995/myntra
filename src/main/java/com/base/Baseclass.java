package com.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	public static WebDriver driver = null;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) {
		element.click();

	}

	public static String getTextOnElement(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void sleep(int n) throws InterruptedException {
		Thread.sleep(4000);

	}

	public static void isEnabled(WebElement element) {
		boolean b = element.isEnabled();
		System.out.println("to check the webelement is enabled or not:" + b);

	}

	public static WebDriver browserlaunch(String value) {

		if (value.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\admin\\eclipse-workspace\\Miniproject\\driver\\chromedriver1.exe");
			driver = new ChromeDriver();

		} else if (value.equalsIgnoreCase("edge")) {

		} else if (value.equalsIgnoreCase("gecko")) {

		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void close() {
		driver.close();

	}

	public static void launchURL(String url) {
		driver.get(url);

	}

	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void capture(String name) throws IOException {
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File from1 = ts1.getScreenshotAs(OutputType.FILE);
		File to1 = new File("C:\\Users\\admin\\eclipse-workspace\\Miniproject\\screenshot\\" + name + ".png");
		FileHandler.copy(from1, to1);
	}

	public static void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void sendkeyAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void popUp(String options) {
		if (options.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (options.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();
		}

	}

	public static void dropdownSelect(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.selectByIndex(n);
			
		}
	}

	public static List<WebElement> dropDownOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;

	}

	public static void moveToElement(WebDriver driver, String name) {
		Actions a = new Actions(driver);
		a.click().build().perform();

	}

}
