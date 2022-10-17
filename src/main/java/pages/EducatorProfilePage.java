package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EducatorProfilePage {
	private WebDriver driver;
	
	//initializing constructor
	public EducatorProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//for obtaining current url
	public String getpageurl() {
		return driver.getCurrentUrl();
	}
	
	//for pressing back button on current page
	public void pressbackbtn() {
		driver.navigate().back();
	}
}
