package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;
	public static void setUpProperty() {
		try {
			File file = new File("C:\\Users\\Devika\\Desktop\\Maven_Project\\src\\main\\resources\\TestData.properties");
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR : OCCUR DURING FILE LOADING");
		}
		catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FILE READING");
		}
		
	}
	public static String getDataProperty(String value) {
		setUpProperty();
		String data = property.getProperty(value);
		return data;
	}
	public static void main(String[] args) {
		System.out.println(getDataProperty("url"));
	}
	

}
