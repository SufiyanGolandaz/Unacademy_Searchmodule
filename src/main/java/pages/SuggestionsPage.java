package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SuggestionsPage {
	private WebDriver driver;
	private String query;
	
	public SuggestionsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By trendingeducator=By.xpath("//div[@class='css-ip5xa9-Suggestions e4n9yhi1']//a");	
	
	By searchbar=By.id("searchInput");
	
	public void clicktrendingeducator() {
		driver.findElement(trendingeducator).click();
	}
	
	public void typequery(String query) {
		this.query=query;
		driver.findElement(searchbar).sendKeys(query);
		
	}

	public WebElement gettrendingeducator() {
		return driver.findElement(trendingeducator);
		
	}
	
	public boolean propersuggestion() {
		String text=driver.findElement(trendingeducator).getAttribute("href");
		if(text.contains(query)) {
			return true;
		}
		else return false;
	}

	public String nameofquery() {
		return query;
	}
	
	public boolean nexteducator() {
		WebElement now=driver.switchTo().activeElement();
		if(driver.findElement(trendingeducator)!=now) {
			return true;
		}
		else return false;
	}
	
}
