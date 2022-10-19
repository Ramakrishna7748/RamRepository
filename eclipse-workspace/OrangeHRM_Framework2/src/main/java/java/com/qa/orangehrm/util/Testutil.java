package com.qa.orangehrm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.orangehrm.base.TestBase;

public class Testutil extends TestBase {
	static JavascriptExecutor js;

	public static void takeScreenshotAtEndOfTest(String pageName) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		String homeDir = System.getProperty("user.dir");		
		try {
			FileUtils.copyFile(scrFile, new File(homeDir + "/screenshots/" + pageName 
					+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void executeJavaScript(String jsQery) {
		js = (JavascriptExecutor) driver;
		js.executeScript(jsQery);
		
		//Examples
		//js.executeScript(�document.getElementByID(�element id �).checked=false;�);
		//js.executeScript(�location.reload()�);
		//js.executeScript(�document.getElementByID(�element id �).value = �xyz�;�);		
	}
		


}
