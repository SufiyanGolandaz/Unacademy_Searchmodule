package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EducatorProfilePage {
	private WebDriver driver;
	public EducatorProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getpageurl() {
		return driver.getCurrentUrl();
	}
	
	public void pressbackbtn() {
		driver.navigate().back();
	}
}
