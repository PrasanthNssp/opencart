package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//Global reference variable
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups={"Sanity","Regression","DataDriven","Master"})
	@Parameters({"os","browser"}) //this for Cross browsing
	public void setUp(String os, String browser) throws IOException {
	  try {  
		//It used for property file
	    FileReader file= new FileReader("./src//test//resources//config.properties");
	    p=new Properties();
	    p.load(file);
	    
	    //It used for taking logs
	    logger = LogManager.getLogger(this.getClass());
	    
	    if(p.getProperty("environment").equalsIgnoreCase("remote"))
	    {
	    	DesiredCapabilities capabilities=new DesiredCapabilities();
	    	
	    	if(os.equalsIgnoreCase("windows"))
	    	{
	    	capabilities.setPlatform(Platform.WIN11);
	    	}
	    	else if (os.equalsIgnoreCase("mac"))
	    	{
	    		capabilities.setPlatform(Platform.MAC);
	    	}
	    	else
	    	{
	    		System.out.print("You are trying to use ,undesired OS ");
	    		return;
	    	}
	    	
	    	switch(browser.toLowerCase())
	    	{
	    	case "chrome":capabilities.setBrowserName("chrome"); break ;
	    	case "edge" : capabilities.setBrowserName("edge"); break ;
	    	default : System.out.print("no matching browsers");
	    	}
	    	
	    	driver=new RemoteWebDriver(new URL(""),capabilities); // in url need to give local host port 444 but as of now not able take url from CMD
	    	
	    }
	    
	    
	    //It is used for Cross browsing 
	    
	    if(p.getProperty("environment").equalsIgnoreCase("local"))
	    {
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;

	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();   
	                break;
               
	            case "firefox" : 
	            	 WebDriverManager.firefoxdriver().setup();
	    			driver=new FirefoxDriver(); break;
	    			
	            default:
	                throw new IllegalArgumentException("Browser not supported: " + browser);
	        }
	    }
		driver.get(p.getProperty("appurl"));
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  catch (Exception e) {
          System.out.println("Error in setup: " + e.getMessage());
          throw e; // very important, otherwise tests skip silently
      }
	}
	
	//(groups={"Sanity","Regression","DataDriven","Master"})
	public void tearDown()
	{
		driver.close();
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File sourceFile= takesScreenshot.getScreenshotAs (OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
}
}