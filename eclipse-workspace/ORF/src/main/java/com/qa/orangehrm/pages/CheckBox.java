package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.TestBase;

public class CheckBox extends TestBase {
	
	public static void assertCheckBox() {
		WebElement checkbox = driver.findElement(By.id("initialRows_0_toDelete"));
		
		
		boolean isChecked = checkbox.isSelected();
		boolean isEnabled = checkbox.isEnabled();
		boolean isVisible = checkbox.isDisplayed();
		
		if (isVisible) {
			System.out.println("Check box is visible!");
			if (isEnabled) {
				System.out.println("Check box is enabled!!");
				if (isChecked) {
					System.out.println("Check box is already checked!!!");
				} else {
					checkbox.click();
					System.out.println("Check box was not checked, I have checked it now!");
				}
			} else {
				System.out.println("Check box is not enabled, I can't check the checkbox!");
			}
		} else {
			System.out.println("Check box is not visible and not enabled, hence I can't performa any action on it!");
		}
		
	}

}
