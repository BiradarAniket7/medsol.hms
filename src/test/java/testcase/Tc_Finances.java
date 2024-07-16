package testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.PageFinances;
import com.pages.PageLogin;

import base.BaseTest;

public class Tc_Finances {
	BaseTest bt = new BaseTest();
	PageLogin pl = new PageLogin(bt.getDriver());
	PageFinances pf = new PageFinances(bt.getDriver());

	@BeforeTest
	public void url_Launch() throws IOException {
		bt.setUP();
	}

	@Test(priority = 1)
	public void pageLoginTest() throws InterruptedException {
		pl.loginTest();
		pl.validation();

	}

	@Test(priority = 2)
	public void pageFinance() throws InterruptedException {
		pf.addIncomes();
		pf.editIncomes();
		pf.filter();
		pf.searchAndDelete();
		pf.Validation_Delete();
	}
	

	@AfterTest
	public void closeBrowser() {
		bt.tearDown();
	}

}
