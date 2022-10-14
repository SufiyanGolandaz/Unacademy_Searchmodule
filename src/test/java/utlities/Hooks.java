package utlities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	
	public static WebDriver driver;
	ExcelReader reader; 
	public static XSSFSheet sheet;
	
	
	@Before(order = 0)
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\safzalgo\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Before(order=1)
	public void setupexcel() throws IOException {
		reader = new ExcelReader();
		sheet = reader.getEnquiryFormSheet();
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}