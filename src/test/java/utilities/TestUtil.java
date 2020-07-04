package utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import TestBase.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotName;
	public static void captureScreenshot() throws IOException
	{
		Date d=new Date();
		
		screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Aparna\\eclipse-workspace\\LiveProjects\\Flipkart\\target\\surefire-reports\\"+screenshotName));
		
	}
}