package testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.PageDiagnosisCategories;
import com.pages.PageLogin;

import base.BaseTest;

public class Tc_Diagnosis {
	BaseTest bt = new BaseTest();
	PageLogin pl = new PageLogin(bt.getDriver());
	PageDiagnosisCategories pd = new PageDiagnosisCategories(bt.getDriver());
	
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
	public void pageDiagnosis() throws InterruptedException {
		pd.addDiagnosis();
		pd.editDiagnosis();
		pd.searchAndDeleteDiagnosis();
		pd.deleteValidation();
	}
	
	@AfterTest
	public void closeBrowser() {
		bt.tearDown();
	}

}
