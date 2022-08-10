package com.novaproduction.hellonerd.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.novaproduction.hellonerd.selenium.BaseClass;
import java.time.Duration;

public class Testclass extends BaseClass {
	private static WebDriver driver;
	
    @Test
    public void simpleTest() throws InterruptedException {
    	driver = super.startup();
        driver.get("https://google.com");
        
        Thread.sleep(3000);
        
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);

        driver.quit();
    }
}
