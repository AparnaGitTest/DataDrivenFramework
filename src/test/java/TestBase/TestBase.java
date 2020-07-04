package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties Config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait ;
	public static Actions action;
	//public static String locator_value;
	
	
	
	@BeforeSuite
	public void setUp()
	{
		
		if(driver==null)
		{
			try {
				fis=new FileInputStream("C:\\Users\\Aparna\\eclipse-workspace\\LiveProjects\\Flipkart\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis=new FileInputStream("C:\\Users\\Aparna\\eclipse-workspace\\LiveProjects\\Flipkart\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Config.getProperty("browser").equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
			}else if(Config.getProperty("browser").equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
			}
			
			driver.get(Config.getProperty("urlToTest"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("waitTime")), TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,100);
			action =new Actions(driver);

			
		}
		
	}
	
	
	public void typeData(String locator, String value)
	{
		
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		String logText="<b>"+"Typing in :- "+locator+" : Entered the value "+value;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
	}
	
	public void click(String locator)
	{
		
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		String logText="<b>"+"Clicked on :- "+locator;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
		
	}
	
	
	public void printInfo(String locator,String value )
	{
		String locator_value;
		if(locator.endsWith("MRP"))
		{
			locator_value=driver.findElement(By.xpath(OR.getProperty(locator))).getText().toString().replaceAll("[^0-9]", "");
		}
		else
		{
			locator_value=driver.findElement(By.xpath(OR.getProperty(locator))).getText().toString();
		}
		String logText=value+" "+locator_value;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
	}
	public void printInfolist(String nameOfList,String text )
	{
		String logText=text+" "+nameOfList;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
	}
	public void printInfolist(int nameOfList,String text )
	{
		String logText=text+" "+nameOfList;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
	}
	public void printInfolist(String text )
	{
		String logText=text;		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		ExtentListeners.testReport.get().info(m);
	}
	
	public boolean isElementPresent(By by)
	{
		try{
			driver.findElement(by);
			return true;
		}catch(Throwable t)
		{
			return false;
		}
		
	}
	public  void verifyEquals(ArrayList<Integer> expected,ArrayList<Integer> actual) throws IOException
	{

		try {
			Assert.assertEquals(actual, expected);
		}catch(Throwable t)
		{
			utilities.TestUtil.captureScreenshot();
			String logText=t.getMessage();		
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.BLUE);
			ExtentListeners.testReport.get().fail(m).addScreenCaptureFromPath(utilities.TestUtil.screenshotName);
			
			/*
			test.log(LogStatus.FAIL,"Verfication failed with exception: "+ t.getMessage());
			test.  log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
		*/
		}
		
	}
	public boolean retryingFindClick(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            driver.findElement(by).click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	
	@AfterSuite
	public void tearDown()
	{
		
		if (driver!=null)
		{
			driver.quit();
		}
		
		
	}
	
	

}
