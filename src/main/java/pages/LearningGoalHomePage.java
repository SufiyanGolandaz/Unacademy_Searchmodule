package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LearningGoalHomePage {
	private WebDriver driver;
	public  String query;
	
	By searchicon=By.cssSelector(".css-xg2sdt-SearchIconContainer > svg");
	By searchbar=By.id("searchInput");
	
	
	By trendinglist=By.xpath("//div[@class='css-ip5xa9-Suggestions e4n9yhi1']//a");
	
	By loginbutton= By.xpath("//div[@class='css-1jkkulm-RightContentWrapper e1tj955r3']/button");
	
	By phnumber=By.cssSelector(".e1l7v5xe1 > .MuiInputBase-input");
		
	public LearningGoalHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clicksearchicon() {
//		new WebDriverWait(driver, Duration.ofSeconds(2)).
//		until(ExpectedConditions.visibilityOf(driver.findElement(searchicon)));
		driver.findElement(searchicon).click();
	}
	
	public boolean searchiconvisible() {
		if(searchicon==null) {
			return false;
		}
		else return true;
	}
	
	public String getplaceholdervalue() {
		return driver.findElement(searchbar).getAttribute("placeholder");
	}
	
//	public boolean trendinglistvisible() {
//		if(trendinglist==null) return false;
//		else return true;
//	}
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
	
	public void enterlogindetails(String phno) {
		driver.findElement(phnumber).sendKeys(phno);
		driver.findElement(phnumber).sendKeys(Keys.ENTER);
	}
		
	
	public void searchquery(String query) {
		this.query=query;
		driver.findElement(searchbar).sendKeys(query);
		driver.findElement(searchbar).sendKeys(Keys.ENTER);
	}
}
