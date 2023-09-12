package com.inetBanking.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper 
{
	final public static int MAX_IMPLICIT_WAIT_TIME=30;
	final public static int PAGE_LOAD_TIME=30;
	public WebDriver driver;
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	public void vaitForElementVisibility(WebElement ele, long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

}
