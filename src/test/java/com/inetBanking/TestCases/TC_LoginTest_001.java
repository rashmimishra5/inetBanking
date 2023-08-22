package com.inetBanking.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Utilities.Utils;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException
	
	{
		System.out.println("HI IN LOGIN METHOD");
	   LoginPage lp=new LoginPage(driver);
		lp.setUserName(rc.getUserName());
		lp.setUserPassword(rc.getUserPassword());
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		String SucessMsg="Manager";
		String Actual_msg=driver.findElement(By.xpath("//ul[@class='menusubnav']/child::li[@class='orange']/a")).getText();
		System.out.println(Actual_msg);
		//marquee[@class='heading3']
		//Assert.assertEquals(driver.getTitle().contains("Guru1") ,"Guru");
		if(Actual_msg.equalsIgnoreCase(SucessMsg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Utils.captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			
		}
	}

}


