package com.baseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class DelayListener implements IInvokedMethodListener{
	
	@Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Check if the method is the first method in the class
        if (method.isTestMethod()) {
        	String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = BrowserFactory.openBrowser(browserName);
            ThreadLocalWebdriver.setWebDriver(driver);
            try {
                // Introduce a delay before the first test method of each class
                Thread.sleep(30000); // 30 seconds delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } 
	 
	    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	        if (method.isTestMethod()) {
	            WebDriver driver = ThreadLocalWebdriver.getDriver();
	            if (driver != null) {
	            	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	              driver.quit();
	            }
	        }
	    }


}
