package testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.PageExpenses;
import com.pages.PageLogin;

import base.BaseTest;

public class Tc_Expenses {
	BaseTest bt = new BaseTest();
	PageLogin pl = new PageLogin(bt.getDriver());
	PageExpenses pe = new PageExpenses(bt.getDriver());
	
	@BeforeTest
	public void url_Launch() throws IOException {
		bt.setUP();
	}
	
	
	@Test(priority=1)
	public void pageLoginTest() throws InterruptedException {
		pl.loginTest();
		pl.validation();
	}
	
	@Test(priority=2)
	public void pageExpenses() throws InterruptedException {
		pe.addExpenses();
		pe.editExpense();
		pe.expenseFilter();
		pe.searchAndDeleteExpense();
		pe.deleteValidation();
		
	}
	@AfterTest
	public void closeBrowser() {
		bt.tearDown();
	}

}
