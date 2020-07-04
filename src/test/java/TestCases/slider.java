package TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class slider extends TestBase {
	@Test
	public void sliderPrice() throws InterruptedException
	{
		WebElement slide=driver.findElement(By.xpath(OR.getProperty("slider")));
		WebElement sliderLine=driver.findElement(By.xpath("//div[@class='gl5Kwg']"));
		
		
		action.dragAndDropBy(slide, -50, 0).click();
	    action.build().perform();
	
	  
	    	 WebElement maxSelect=driver.findElement(By.xpath(OR.getProperty("maxSelect")));
	    	 //System.out.println(maxSelect);
	    	 
	    	wait.until(ExpectedConditions.textToBePresentInElement(maxSelect, "0"));
	    	
	 	    
	    	 
	 	    Select select=new Select(maxSelect);
	 	  // wait.until(ExpectedConditions.textToBePresentInElement(select.getFirstSelectedOption(), "0"));
	 	    String options=select.getFirstSelectedOption().getText().toString();
	 	    System.out.println("the range selected is in String value "+options); 
	 	   
	 	    String option_new=options.replaceAll("[^0-9]", "");
	 	   System.out.println("keeping only integer from range"+option_new); 
	 	  
	 	    int option_integer=Integer.valueOf(option_new);
	 	    System.out.println("Converting it to integer"+option_integer); 
	 	
	 	   printInfolist(option_integer,"Price is filtered to :");
	 	   /*
	 	    List<WebElement> filteredList = driver.findElements(By.xpath(OR.getProperty("prices")));
	 	  // System.out.println(filteredList);
	  
	   
	 	  printInfolist("Checking whether the list of the books after filtering are based on the price :"+option_integer);
	 	   ArrayList<Integer> filteredListWithPrice = new ArrayList<Integer>();

	 	   for (WebElement webElement : filteredList)
        {
            String name = webElement.getText();
            int extractPrice=Integer.valueOf(name.toString().replace(",","").substring(1));
            filteredListWithPrice.add(extractPrice);
        }
	 	 

        //filteredListWithPrice.add(2000);
		 Collections.sort(filteredListWithPrice);
		 String priceListAfterFiltering="";
			for (Integer s : filteredListWithPrice)
			{
				priceListAfterFiltering += s + ",";
			}
			printInfolist(priceListAfterFiltering,"The price list is ");
     System.out.println("The final list is"+filteredListWithPrice);
		 int i=filteredListWithPrice.size()-1;
		
		printInfolist("After sorting the list we found out that last value in list is "+filteredListWithPrice.get(i));
		boolean check=filteredListWithPrice.get(i)<=option_integer;
		if(check==true)
		{
			printInfolist("the list of price retrieved after filtering is(less than or equal to)"+option_integer);
		}
		else
		{
			printInfolist("After sorting the list we found out that last value in list is "+filteredListWithPrice.get(i));
		}
		System.out.println("Whether true or flase"+check);
		
		
	//	Assert.assertEquals(check, true,"The retrived data is greater than "+option_integer);
		
	
		*/ 
		 
	
	}
	

}
