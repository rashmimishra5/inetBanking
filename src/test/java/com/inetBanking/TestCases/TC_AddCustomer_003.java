package com.inetBanking.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.AddNewCustomer;
import com.inetBanking.PageObject.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{
	@Test()
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(rc.getUserName());
		lp.setUserPassword(rc.getUserPassword());
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddNewCustomer nc=new AddNewCustomer(driver);
		nc.clickNewCustomer();
		nc.setCustomerName("Rashmi Mishra");
		nc.selectCustomerGender("female");
		nc.setCustomerDOB("12", "12", "1993");
		nc.setCustomerAddress("stamsgardparken");
		nc.setCustomerCity("stockholm");
		nc.setCustomerState("stockholm");
		nc.setCustomerPin(222222);
		nc.setCustomerPhoneNumber("1234567890");
		String email=GenerateRandom() + "@gmail.com";
		nc.setCustomerEmailId(email);
		nc.setCustomerPassword("1234");
		nc.clickSubmit();
		
		Thread.sleep(5000);
		
		boolean b=driver.getPageSource().contains("Customer Registerd successfully");
		Assert.assertTrue(b);		
	}
	
	public String GenerateRandom()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(10);
		return(generatedstring);
	}
}
