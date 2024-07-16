package testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.PageLogin;

import base.BaseTest;

public class Tc_Login {
	BaseTest bt = new BaseTest();
	PageLogin pl = new PageLogin(bt.getDriver());
	
	@BeforeTest
	public void url_Launch() throws IOException {
		bt.setUP();
	}
	
	
	@Test
	public void pageLoginTest() throws InterruptedException {
		pl.loginTest();
		pl.validation();
	}
	
	@AfterTest
	public void closeBrowser() {
		bt.tearDown();
	}
}