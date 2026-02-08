package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadExcelData;

public class TestRunner {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.facebook.com");
		driver.get("https://www.youtube.com");
		String text = ReadExcelData.getParticularRowData(4,2);
		driver.findElement(By.name("search_query")).sendKeys(text);
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		/*String userName = ReadExcelData.getParticularRowData(2,0);
		
		driver.findElement(By.name("email")).sendKeys(userName);
		
		String password = ReadExcelData.getParticularRowData(2,1);
		
		driver.findElement(By.name("pass")).sendKeys(password);*/

	}

}
