package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsHomePage {
	private WebDriver driver;
	
	//location for heading after search
	@FindAll(@FindBy(xpath="//h4[@class='css-gh0zib-H4-Header evy4yrm0']"))
	WebElement searchheading;
	
	//location for "Educator" category heading
	@FindAll(
			@FindBy(xpath="//h2[@class='css-1frklj3-H4-StyH4 ejsopzy0']")
			)
	WebElement educatorheading;
	
	//location for headings of all categories viz "Educators", "Courses& Test Series","Free Lessons"
	@FindAll({
			@FindBy(xpath = "//h2[normalize-space()='Educators']"),
			@FindBy(xpath = "//h2[@class='css-1frklj3-H4-StyH4 ejsopzy0']"),
			@FindBy(xpath= "//h2[normalize-space()='Courses & test series']"),
			@FindBy(css="#__next > div.css-19fdje3-Container-Container.e1kplr10 > div > div.css-1ech8wl-Content-Content.e1kplr13 > div:nth-child(6) > h2"),
			@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/div[7]/h2"),
			@FindBy(css="#__next > div.css-19fdje3-Container-Container.e1kplr10 > div > div.css-1ech8wl-Content-Content.e1kplr13 > div:nth-child(11) > h2")})
	List<WebElement> categories;
	
	//location for "See All" button
	@FindAll({
		@FindBy(css = "css-11urv45-StyledButton-SeeAll"),
		@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/div[2]/a/p"),
		@FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > a:nth-child(3) > p:nth-child(1)")})
	WebElement seeallbutton;
	
	//location for expanded search results after clicking on see all button
	@FindAll({
		@FindBy(css="#__next > div.css-19fdje3-Container-Container.e1kplr10 > div > div.css-1ech8wl-Content-Content.e1kplr13 > a:nth-child(6)"),
		@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/a[3]/div[1]/div[3]/span[1]/img[1]"),
		@FindBy(xpath="//h6[@class='css-15b8m-H6-SeeMore e1hhknel1']"),
		@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/button[1]")
	})
	WebElement expandedresults;
	
	//location for 1st educator under "Educator" category
	@FindAll({
		@FindBy(xpath="//*[@id='__next']/div[1]/div/div[2]/div[3]/div/div[1]/a"),
		@FindBy(xpath = " //div[@class='css-1cqew8q-StyledAnchor eyp81ai0']"),
		@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2)")
	})
	WebElement educator;
	
	//location for obtaining url of 1st educator under "Educator" category
	@FindAll({
		@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/div[3]/div/div[1]/a")
	})
	WebElement educatorlink;
	
	//location for 1st course under "Courses & TestSeries" category
	@FindAll({
		@FindBy(xpath = "//body/div[@id='__next']/div[@class='css-19fdje3-Container-Container e1kplr10']/div[@class='css-1xgbxzf-AppContainer-AppContainer e1kplr12']/div[@class='css-1ech8wl-Content-Content e1kplr13']/div[@class='css-dxeo93-CarouselWrapper ejsopzy3']/div[@class='css-1geykmp-CardContainer ejsopzy4']/div[1]/div[1]/a[1]/div[1]/span[1]/img[1]"),
		@FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > span:nth-child(1)")
	})
	WebElement course;
	
	//location for obtaining url of 1st course under "Courses & TestSeries" category
	@FindAll({
		@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/div[5]/div/div[1]/div/div/div[1]/a")
	})
	WebElement courselink;
	
	public SearchResultsHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getcurrenturl() {
		return driver.getCurrentUrl();
	}
	
	public String getsearchheading() {
		return searchheading.getText();
	}
	
	public boolean searchsuccesful() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(2)).
			until(ExpectedConditions.visibilityOf(educatorheading));
			return true;
		}
		catch(TimeoutException tex) {}
		return false;
	}

	public boolean categoriesvisible() {
		for(int i=0;i<categories.size();i++) {
			String category=categories.get(i).getText();
			if(category.contains("Educators") || category.contains("Courses & test series") || category.contains("Educators")) {
				return true;
			}
			
		}
		return false;
	}

	public boolean seeallbtnvisible() {
		
		try {
			new WebDriverWait(driver, Duration.ofSeconds(4)).
			until(ExpectedConditions.visibilityOf(seeallbutton));
			return true;
		}
		catch(TimeoutException tex) {}
		return false;
	}

	public void clickseeallbtn() {
		seeallbutton.click();
		
	}
	
	public boolean expandedresultvisible() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).
			until(ExpectedConditions.visibilityOf(expandedresults));
			return true;
		}
		catch(TimeoutException tex) {}
		return false;
	}
	
	public void clickeducatorprofile() {
		new WebDriverWait(driver,  Duration.ofSeconds(5))
		.until(ExpectedConditions.visibilityOf(educatorlink));
		educator.click();
	}
	
	public String geteducatorlink() {
		String educatorurl= educatorlink.getAttribute("href");
		new WebDriverWait(driver, Duration.ofSeconds(5)).
		until(ExpectedConditions.urlContains(educatorurl));
		return educatorurl;
	}
	
	public void  clickcourse() {
		new WebDriverWait(driver,  Duration.ofSeconds(5))
		.until(ExpectedConditions.visibilityOf(courselink));
		course.click();
	}

	public String getcourselink() {
		String courseurl= courselink.getAttribute("href");
		new WebDriverWait(driver, Duration.ofSeconds(5)).
		until(ExpectedConditions.urlContains(courseurl));
		return courseurl;
	}
	
}
