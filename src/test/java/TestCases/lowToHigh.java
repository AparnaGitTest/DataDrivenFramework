package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestBase.TestBase;
import extentlisteners.ExtentListeners;

public class lowToHigh extends TestBase {
	@Test
	public void lowToHigh() throws IOException {

		click("lowToHigh_XPATH");
		driver.navigate().refresh();
		//we can get the prices by using the get text function  
		List<WebElement> priceList = driver.findElements(By.xpath(OR.getProperty("prices")));

		//There new array to be create to get only the price from the above price list
		ArrayList<Integer> newlist = new ArrayList<Integer>();
		String displayOriginalPricelist="";
		for (int i = 0; i < priceList.size(); i++) {
			int price = Integer.valueOf(priceList.get(i).getText().toString().replace(",","").substring(1));
			newlist.add(price);
			displayOriginalPricelist+=price+ ", ";
		}
		printInfolist(displayOriginalPricelist,"The Original list is ");
		System.out.println("The Original list is "+newlist);
		
		
		ArrayList<Integer> newlist2 = (ArrayList<Integer>)newlist.clone();
		Collections.sort(newlist2);
		String sortedlist="";
		for (Integer s : newlist2)
		{
			sortedlist += s + ",";
		}
		printInfolist(sortedlist,"The Sorted list is ");
		System.out.println("The sorted list is "+newlist2);
		//verifyEquals(newlist,newlist2);
		//Assert.assertEquals(newlist, newlist2, "Not same");
		
		if (newlist.equals(newlist2)) {
			System.out.println("The list is sorted correctly".toUpperCase());
			
		} else {
			System.out.println("The list is not sorted correctly".toUpperCase());
		}
		
	}

}
