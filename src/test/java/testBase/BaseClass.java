package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		//loading config.properties
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
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
				
		@AfterClass
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

}
