package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass11;
import com.actitime.generic.BaseClass11;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass11 {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("Create customer",true);
		FileLib f=new FileLib();
		String customerName = f.getExcelData("createCustomer", 1,3);
		String customerDesc = f.getExcelData("createCustomer", 1, 4);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getCustomerNameTbx().sendKeys(customerName);
		t.getCustomerDescription().sendKeys(customerDesc);
		t.getSelectCustomerDD().click();
		t.getOurComapny().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(3000);
		String actualText = t.getActualCustomerCreated().getText();
		Assert.assertEquals(actualText,customerName);
		
		
		
		
	}

}
