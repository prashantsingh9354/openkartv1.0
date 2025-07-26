package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  //log4j2
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;	 //log4j2
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; 	//log4j2
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		//loading config.properties
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass()); //log4j2
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
				{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appUrl")); //reading url from properties file
			driver.manage().window().maximize();

		
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "Firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid Browser"); return;
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appUrl")); //reading url from properties file
			driver.manage().window().maximize();
		}

	}
				
		@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown() {
		driver.quit();
	}
		
		public String randomString()
		{
			String randomtxt=RandomStringUtils.randomAlphabetic(5);
			return randomtxt;
		}
		public String randomnumber() 
		{
			String generatedNo=RandomStringUtils.randomAlphanumeric(6);
			return generatedNo;
		}
		
		public String pwd() {
			String randomtxt1=RandomStringUtils.randomAlphabetic(6);
			String generatedNo1=RandomStringUtils.randomAlphanumeric(4);
			return (randomtxt1+generatedNo1);
		}
		
		public String captureScreen(String tname)
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			
			return targetFilePath;
		}

}
