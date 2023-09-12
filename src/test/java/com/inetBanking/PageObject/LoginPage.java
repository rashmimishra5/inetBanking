package com.inetBanking.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName; 
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtUserPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement btnlogOut;
	
	public void setUserName(String Username)
	{
		txtUserName.sendKeys(Username);
	}
	
	public void setUserPassword(String UserPassword)
	{
		txtUserPassword.sendKeys(UserPassword);
	}
	
	public void clickSubmit()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
		//JavaScript js=JavaScript(driver);
	/*	int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame("gdpr-consent-manager");
		driver.findElement(By.xpath("//span[text()='Accept All']")).click();
		driver.switchTo().defaultContent();*/
		//Actions act=new Actions(driver);
		//act.moveToElement(btnlogin).click().build().perform();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnlogin);
		//btnlogin.click();
	}
	public void clickLogOut()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
		//Actions act=new Actions(driver);
		//act.moveToElement(btnlogOut).click().build().perform();
		//btnlogin.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnlogOut);
	}
}
