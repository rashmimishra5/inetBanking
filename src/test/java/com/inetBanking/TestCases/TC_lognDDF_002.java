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

import com.inetBanking.Utilities.XLUtils;

public class TC_lognDDF_002 extends BaseClass
{
	
	@Test(dataProvider="loginData")
public void loginDDT(String username,String password) throws InterruptedException
	
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("HI IN LOGIN METHOD");
		com.inetBanking.PageObject.LoginPage lp=new com.inetBanking.PageObject.LoginPage(driver);
		lp.setUserName(username);
		lp.setUserPassword(password);
		blockingPopupsAndOtherWindow();
		lp.clickSubmit();
		
		WebElement togger=driver.findElement(By.xpath("//a[@id='gdpr-toggle']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(togger).click().build().perform();
  		driver.switchTo().frame(1);
		//Thread.sleep(5000);
		Actions act1=new Actions(driver);
		
		WebElement btnsave=driver.findElement(By.xpath("//button[@id='save']"));
		act1.moveToElement(btnsave).click().build().perform();
		//Thread.sleep(5000);
		driver.switchTo().defaultContent();
		//lp.clickSubmit();
		Actions act2=new Actions(driver);
		act2.moveToElement(driver.findElement(By.xpath("//input[@name='btnLogin']"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*Actions act2=new Actions(driver);
		WebElement button_ele=driver.findElement(By.xpath("//input[@name='btnLogin']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(button_ele)).click();
		act2.moveToElement(button_ele).click().build().perform();*/
		Thread.sleep(3000);
	
		if(isAlertPresent()==true)  //tc fail
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
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
		try
		{
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
