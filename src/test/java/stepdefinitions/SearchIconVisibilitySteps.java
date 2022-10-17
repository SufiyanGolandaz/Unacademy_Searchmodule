package stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LearningGoalHomePage;
import utlities.Hooks;
import utlities.ReadPropFile;


public class SearchIconVisibilitySteps{
	private WebDriver driver=Hooks.driver;
	ReadPropFile rp=new ReadPropFile();

	private LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	

	@Given("user is on learning goal's home page")
	public void user_is_on_learning_goal_s_home_page() {
	   driver.get(rp.geturl());
	    driver.manage().timeouts().implicitlyWait(Duration
	    		.ofSeconds(5));
	}
	

	@Then("search icon should be visible")
	public void search_icon_should_be_visible() {
		assertTrue(lghp.searchiconvisible());
	}

	@And("user clicks on search icon")
	public void user_clicks_on_search_icon() {
		
		lghp.clicksearchicon();
	}

	@Then("search tab is visible with placeholder")
	public void search_tab_is_visible_with_placeholder() {
		assertEquals(lghp.getplaceholdervalue(), "Search for courses, lessons, educators");	
	}
	
}
