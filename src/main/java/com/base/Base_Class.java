package com.base;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class Base_Class {
    public static WebDriver driver;
	protected static void launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				
			}
			else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				
			}
			else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} 
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();

	}
	
     protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING URL LAUNCH");
		}

	}
   protected static void passInput(WebElement element, String value) {
	   try {
		element.sendKeys(value);
	} catch (Exception e) {
		Assert.fail("ERROR : OCCUR DURING PASSING INPUT");
	}
	

}
   protected static void clickOnElement(WebElement element) {
	try {
		element.click();
		
	} catch (Exception e) {
		Assert.fail("ERROR : OCCUR DURING CLICKING ELEMENT");
	}

}
   protected static void browserTermination() {
	try {
		driver.quit();
	} catch (Exception e) {
		Assert.fail("ERROR : OCCUR DURING BROWSER TERMINATION");
	}

}
   protected static  void selectOptions(WebElement element,String type,String value) {
	try {
		Select select = new Select(element);
		if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
			
		}
		else if (type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
			
		}
		else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
			
		}
		
	} catch (Exception e) {
		Assert.fail("ERROR : OCCUR DURING SELECTION OPTIONS");
	}

}
   protected static  void deselectOptions(WebElement element,String type,String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
				
			}
			else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
				
			}
			else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
				
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING DESELECTION OPTIONS");
		}

	}
   
   protected static void windowHandles(int num) {
	try {
		List<String> allwindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindow.get(num));
	} catch (Exception e) {
		Assert.fail("ERROR : OCCUR DURING WINDOWHANDLES");
	}

}
   
}
