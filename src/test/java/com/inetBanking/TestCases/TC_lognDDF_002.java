package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Utilities.XLUtils;

public class TC_lognDDF_002 extends BaseClass
{
	
	@Test(dataProvider="loginData")
public void loginDDT(String username,String password) throws InterruptedException
	
	{
		System.out.println("HI IN LOGIN METHOD");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setUserPassword(password);
		//blockingPopupsAndOtherWindow();
		lp.clickSubmit();
		Thread.sleep(3000);
	
		if(isAlertPresent()==true)  //tc fail
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false,"fail");
		}
		else   ////tc passed
		{
			Assert.assertTrue(true);
			lp.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		//Assert.assertEquals(driver.getTitle().contains("Guru") ,"Guru");
	}
	
	@DataProvider(name="loginData")
	public String [][]getData() throws IOException
	{
		String path= System.getProperty("user.dir") + "/src/test/java/com/inetBanking/TestData/LoginData.xlsx";
		//File file=new File(System.getProperty("user.dir") + "/src/test/java/com/inetBanking/TestData/LoginData.xlsx");
		
		int rownum=XLUtils.getRowCount(path, "login");
		System.out.println(rownum);
		int cellnum=XLUtils.getCellCount(path,"login",1);
		System.out.println(cellnum);
		String data[][]=new String[rownum][cellnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				data[i-1][j]=XLUtils.getCellData(path, "login", i, j);
				
			}
		}
		return data;
	}
	
	
	public Boolean isAlertPresent()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) /*timeout in seconds*/);
		try
		{
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
