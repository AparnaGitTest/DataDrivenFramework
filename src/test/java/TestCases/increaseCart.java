package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class increaseCart extends TestBase {

	@Test
	public void increaseCart() throws InterruptedException{
		// isElementPresent(By.xpath(OR.getProperty("clickCart")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("clickCart")))).click();
		int flag=0;
		System.out.println("flag is "+flag);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("MRP"))));
		//String MRP=driver.findElement(By.xpath(OR.getProperty("MRP"))).getText();
		
				//driver.findElement(By.xpath(OR.getProperty("MRP"));
	//	int MRP=
		int MRP=Integer.valueOf(driver.findElement(By.xpath(OR.getProperty("MRP"))).getText().toString().replace(",", "").substring(1));
		System.out.println("Mrp is "+MRP);
		
		
		
	//	requirement
		
		while(flag==0)
		{
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("plusButton"))));

			//click("plusButton");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("plusButton")))).click();
			Thread.sleep(2000);
			//if(isElementPresent(By.xpath(OR.getProperty("message")).))
			if(driver.findElement(By.xpath(OR.getProperty("message"))).getText().contains("requirement"))
			{
				flag=1;
				System.out.println(flag);
			}
			
		}
		System.out.println(driver.findElement(By.xpath(OR.getProperty("message"))).getText());
	
		System.out.println("flag is "+flag);
		
		int noOfElement=Integer.valueOf(driver.findElement(By.xpath(OR.getProperty("noOfItem"))).getAttribute("value"));
		String percentOff=driver.findElement(By.xpath(OR.getProperty("percentOff"))).getText();
		int percent=Integer.valueOf(percentOff.substring(0, percentOff.indexOf('%')));
		System.out.println("MRP is : "+MRP);
		System.out.println("Total Items : "+noOfElement);
		System.out.println("Percent off: "+percent);
		
		double priceAsPerItem=(MRP*noOfElement);
		double percentDeduct=(priceAsPerItem/100)*(percent);
		int finalPrice=(int) (priceAsPerItem-percentDeduct);
		System.out.println(priceAsPerItem);
		System.out.println(percentDeduct);
		System.out.println(finalPrice);
		int ActualMRP=Integer.valueOf(driver.findElement(By.xpath(OR.getProperty("actualMRP"))).getText().toString().replace(",", "").substring(1));
		Assert.assertEquals(ActualMRP, finalPrice);
		
		
		
		
		
		
	}

}
