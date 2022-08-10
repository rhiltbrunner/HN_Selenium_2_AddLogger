package com.novaproduction.hellonerd.selenium.drivers;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import com.novaproduction.hellonerd.selenium.DetectingOS;
import com.novaproduction.hellonerd.selenium.MyLogger;

public class MyEdgeDriver {
	
	private static MyEdgeDriver edgeDriver = null;
	private static EdgeOptions options = null;
	
	public static WebDriver getConfiguredDriver(WebDriver _driver) {		
		edgeDriver = new MyEdgeDriver();
		options  = edgeDriver.setOptions(_driver);
		_driver = new EdgeDriver(options);
		edgeDriver.setCookies(_driver);
		edgeDriver.setProperties(_driver);
		return _driver;
	}
	
	public EdgeOptions setOptions(WebDriver _driver) {
		EdgeOptions options  = new EdgeOptions();
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
			System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge");
		} else if(DetectingOS.getOS().equals(DetectingOS.OS_LINUX)) {
			System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge");
		}else {
		}
	}
}
