package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties data = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	public static FileReader fr2;

	public WebDriver getDriver() {
		return driver;
	}

	public void setUP() throws IOException {

		if (driver == null) {
			String path = System.getProperty("user.dir");
			System.out.println(path);
			 fr = new FileReader(path + "//src//test//resources//configfiles//config.properties");
			 fr1 = new FileReader(path + "//src//test//resources//configfiles//locator.properties");
			fr2 = new FileReader(path +"//src//test//resources//testdata//data");
			 
			prop.load(fr);
			loc.load(fr1);
			data.load(fr2);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			String curentUrl = driver.getCurrentUrl();
			String actualUrl = "https://medsolbuffer.in/login";
			Assert.assertEquals(curentUrl, actualUrl);
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			String curentUrl = driver.getCurrentUrl();
			String actualUrl = "https://medsolbuffer.in/login";
			Assert.assertEquals(curentUrl, actualUrl);
		}
	}

	public void tearDown() {
		driver.close();
		System.out.println("Teardown Successfull");
	}
}