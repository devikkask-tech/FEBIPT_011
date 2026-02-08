package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base_Class;

public class TestClass extends Base_Class {
	public static void main(String[] args) {
		launchBrowser("chrome");
		//launchUrl("https://www.google.com/");
		//WebElement element = driver.findElement(By.name("q"));
		//passInput(element, "Rose");
		launchUrl("https://letcode.in/dropdowns");
		WebElement element = driver.findElement(By.id("fruits"));
		selectOptions(element, "index", "1");
		//deselectOptions(element, "value", "0");
		//selectOptions(element, "text", "Orange");
		windowHandles(0);
		
	}

}
