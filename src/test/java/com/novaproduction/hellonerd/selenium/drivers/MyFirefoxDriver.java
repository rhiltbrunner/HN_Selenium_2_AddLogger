package com.novaproduction.hellonerd.selenium.drivers;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.novaproduction.hellonerd.selenium.DetectingOS;
import com.novaproduction.hellonerd.selenium.MyLogger;

public class MyFirefoxDriver {

	private static MyFirefoxDriver myDriver = null;
	private static FirefoxOptions options = null;
	
	public static WebDriver getConfiguredDriver(WebDriver _driver) {		
		myDriver = new MyFirefoxDriver();
		options  = myDriver.setOptions(_driver);
		_driver = new FirefoxDriver(options);
		myDriver.setCookies(_driver);
		myDriver.setProperties(_driver);
		return _driver;
	}
	
	public FirefoxOptions setOptions(WebDriver _driver) {
		FirefoxOptions options  = new FirefoxOptions();
		options.addArguments("--disable-popup-blocking");
		return options;
	}

	public void setCookies(WebDriver _driver) {
		
	}

	public void setProperties(WebDriver _driver) {
		/**
		 * This is the path to the effective browser, not the selenium driver.
		 */
			
		if(DetectingOS.getOS().equals(DetectingOS.OS_WINDOWS)) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\firefox");
		} else if(DetectingOS.getOS().equals(DetectingOS.OS_LINUX)) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\firefox");
		}else {
		}
	}
}
