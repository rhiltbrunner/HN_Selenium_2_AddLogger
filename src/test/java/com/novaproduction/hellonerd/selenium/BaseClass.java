package com.novaproduction.hellonerd.selenium;

import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.rules.TestName;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.WebDriver;

/**
 * there are 3 browsertypes:
 * <li>BROWSER_CHROME</li>
 * <li>BROWSER_FIREFOX</li>
 * <li>BROWSER_EDGE</li>
 * 
 * The default browsertype is BROWSER_CHROME.
 * 
 * @author hir
 *
 */
public abstract class BaseClass {
	
	public WebDriver wDriver;
	private static Logger logger = MyLogger.getLogger(BaseClass.class);
	
    public WebDriver startup() {
    	logger.info("this is an info log message.");
    	logger.warning("this is a warning log message.");
    	logger.severe("this is a severe log message.");
    	try {
    		wDriver = DetectingDriver.getDriver();
    		if(wDriver != null) {
    			return wDriver;    			
    		}
    	}catch(Exception ex) {
    		
    	}
    	return null;
    }
    
    @AfterEach
    public void teardown() {
        if (wDriver != null) {
        	wDriver.quit();
        }
    }
    
    @AfterAll
    public static void afterall() {
       // save log file
    }
}