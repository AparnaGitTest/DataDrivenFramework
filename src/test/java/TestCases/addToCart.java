package TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

import TestBase.TestBase;

public class addToCart extends TestBase {

	@Test
	public void addToCart() throws IOException {
		
		//After going to Flipkart website a popup appears asking to login.
		//below script is used to close the window
		//waitToClick("popUpButton");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("popUpButton")))).click();
		
		//Enter Selenium in Search Box
		typeData("searchBox_XPATH", "Selenium");
		action.sendKeys(Keys.ENTER).perform();
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("itemToAdd")))).click();
		

		// getting the window handle of first main window
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> iterate = windIds.iterator();
		String firstWindow = iterate.next();

		// window id of add to cart window
		windIds = driver.getWindowHandles();
		iterate = windIds.iterator();

		iterate.next();
		String secondWindow = iterate.next();
		driver.switchTo().window(secondWindow);

		System.out.println("The Title of the page is "+driver.getTitle());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addToCart")))).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));

		System.out.println("The Title of the page after adding to cart is "+driver.getTitle());
		printInfo("nameOfBook", "You have added to cart book ");
		printInfo("newMRP", "Due to offer the MRP of the book is  ");
		
		
		driver.close();
		driver.switchTo().window(firstWindow);
		
		driver.navigate().refresh();
		String i=driver.findElement(By.xpath(OR.getProperty("itemInCart"))).getText();
		
		printInfolist("No. of items in the cart  : "+i);
		

	}

}
