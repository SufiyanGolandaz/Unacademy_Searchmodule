package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LearningGoalHomePage {
	private WebDriver driver;
	public  String query;
	
	//search icon location
	By searchicon=By.cssSelector(".css-xg2sdt-SearchIconContainer > svg");
	
	//search bar location
	By searchbar=By.id("searchInput");
	
	//trending list location
	By trendinglist=By.xpath("//div[@class='css-ip5xa9-Suggestions e4n9yhi1']//a");
	
	//login button location
	By loginbutton= By.xpath("//div[@class='css-1jkkulm-RightContentWrapper e1tj955r3']/button");
	
	//location for phone number input
	By phnumber=By.cssSelector(".e1l7v5xe1 > .MuiInputBase-input");
		

	public LearningGoalHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clicksearchicon() {
		driver.findElement(searchicon).click();
	}
	
	//checks if search icon is visible or not
	public boolean searchiconvisible() {
		if(searchicon==null) {
			return false;
		}
		else return true;
	}
	
	//returns placeholder value
	public String getplaceholdervalue() {
		return driver.findElement(searchbar).getAttribute("placeholder");
	}
	
	//checks if trending list is visible or not
	public boolean trendinglistvisible() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(2)).
			until(ExpectedConditions.visibilityOf(driver.findElement(trendinglist)));
			return true;
		}
		catch(Exception ne) {}
		return false;
	}
	
	public void clickloginbutton() {
		driver.findElement(loginbutton).click();
	}
	
	//for logging in
	public void enterlogindetails(String phno) {
		driver.findElement(phnumber).sendKeys(phno);
		driver.findElement(phnumber).sendKeys(Keys.ENTER);
	}
		
	//for searching query
	public void searchquery(String query) {
		this.query=query;
		driver.findElement(searchbar).sendKeys(query);
		driver.findElement(searchbar).sendKeys(Keys.ENTER);
	}
}
