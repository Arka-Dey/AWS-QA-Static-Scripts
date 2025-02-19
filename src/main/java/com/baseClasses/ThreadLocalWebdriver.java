package com.baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ThreadLocalWebdriver {
	 private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	 
	    public static WebDriver getDriver() {
	        return webDriver.get();
	    }
	 
	    public static WebDriver getDriver(ChromeOptions options) {
	        return webDriver.get();
	    }
		static void setWebDriver(WebDriver driver) {
	        webDriver.set(driver);
	    }
}
