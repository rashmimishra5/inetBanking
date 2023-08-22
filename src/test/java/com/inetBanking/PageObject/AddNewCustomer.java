package com.inetBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer
{
	WebDriver driver;
	public AddNewCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//ul[@class="menusubnav"]/child::li//a[contains(text(),"New Customer")]
	@FindBy(how=How.XPATH,using="//ul[@class=\"menusubnav\"]/child::li//a[contains(text(),\"New Customer\")]")
	@CacheLookup
	WebElement NewCustomerLink;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"name\"]")
	@CacheLookup
	WebElement cust_name;

	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement cgender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement cdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement cstate;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement cPIN;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement Ph_no;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME,using="res")
	@CacheLookup
	WebElement btnreSet;
	
	//......Action Methods..............//
	
	public void clickNewCustomer()
	{
		NewCustomerLink.click();
		
	}
	
	public void setCustomerName(String name)
	{
		cust_name.sendKeys(name);
		
	}
	
	public void setCustomerDOB(String mm, String dd, String yy)
	{
		cdob.sendKeys(mm);
		cdob.sendKeys(dd);
		cdob.sendKeys(yy);
		
	}
	
	public void selectCustomerGender(String gender)
	{
		cgender.click();
		
	}
	
	public void setCustomerAddress(String addr)
	{
		address.sendKeys(addr);
		
	}
	
	public void setCustomerCity(String city)
	{
		this.city.sendKeys(city);
		
	}
	public void setCustomerState(String state)
	{
		cstate.sendKeys(state);
		
	}
	public void setCustomerPin(int pin)
	{
		cPIN.sendKeys(String.valueOf(pin));
		
	}
	public void setCustomerPhoneNumber(String ph)
	{
		Ph_no.sendKeys(ph);
		
	}
	public void setCustomerEmailId(String emailid)
	{
		email.sendKeys(emailid);
		
	}
	public void setCustomerPassword(String password)
	{
		this.password.sendKeys(password);
		
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
		
	}
	public void clickReset()
	{
		btnreSet.click();
		
	}
	
}
