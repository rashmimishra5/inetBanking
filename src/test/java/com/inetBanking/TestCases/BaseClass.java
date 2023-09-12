package com.inetBanking.TestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	ReadConfig rc=new ReadConfig();
	Utils u=new Utils();
	WaitHelper waithelper=new WaitHelper(driver);
	
	@Parameters("Browser")
	@BeforeTest
	
	public void setUp(String browser_Name)
	{
		switch(browser_Name)
		{
		case "chrome":
			System.out.println("driver  "+ browser_Name);
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability("capability", true);
			ChromeOptions op=new ChromeOptions();
			op.merge(cap);
			driver=new ChromeDriver(op);
			op.setAcceptInsecureCerts(true);
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
		
		case "firefox":
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
			break;
		}
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		//driver.get("https://demo.guru99.com/v3/index.php");
		driver.get(rc.getAppUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waithelper.MAX_IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		
		/*
		 * Accepting privacy policy and getting back to the main frame
		 */
		driver.switchTo().frame("gdpr-consent-notice");
		WebElement accept_all=driver.findElement(By.xpath("//span[contains(text(),'Accept All')]"));
		//waithelper.vaitForElementVisibility(accept_all, 10);
		//accept_all.click();*/
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", accept_all);
		//driver.findElement(By.xpath("//span[contains(text(),'Accept All')]")).click();
		driver.switchTo().defaultContent();
		
		
		System.out.println("Successfully window launched and maximixed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Successfully window closed");
	}
	
	//closing popups and other windows opened
		//@Test
		public void blockingPopupsAndOtherWindow() throws InterruptedException
		{
			String parent_window=driver.getWindowHandle();
			//get all windows opened
			
			Set<String> all_window=driver.getWindowHandles();
			int total_window=all_window.size();
			System.out.println("Total Window = "+ total_window);
			
			//extracting all window and blocking other than parent window
			for(String ele:all_window)
			{
				if(!parent_window.equalsIgnoreCase(ele))
				{
					driver.switchTo().window(ele);
					Thread.sleep(2000);
					driver.close();
				}
			}
			driver.switchTo().window(parent_window);
			System.out.println("Parent Window Title " +driver.getTitle());		
		}
		
		/*
		 * getting all cookies and printing the name and value
		 */
		public static void cookies()
		{
			Set<Cookie> cookie=driver.manage().getCookies();
			System.out.println(cookie.size());
			
			for(Cookie c:cookie)
			{
				System.out.println(c.getName() +"::"+c.getValue());
			}
		}

}
