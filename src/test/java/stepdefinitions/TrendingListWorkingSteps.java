package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LearningGoalHomePage;
import pages.SearchResultsHomePage;
import pages.SuggestionsPage;
import utlities.Hooks;

public class TrendingListWorkingSteps {
	private WebDriver driver=Hooks.driver;

	private LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	
	@Given("user is on learning goal's homepage")
	public void user_is_on_learning_goal_s_homepage() {
		driver.get("https://unacademy.com/goal/iit-jam/SIFWL");
	    driver.manage().timeouts().implicitlyWait(Duration
	    		.ofSeconds(10));
	}

	@Then("trending list of educators is visible")
	public void trending_list_of_educators_is_visible() {
		assertEquals(lghp.trendinglistvisible(), true);
	}
	

	@When("users clicks on search icon")
	public void users_clicks_on_search_icon() {
	    lghp.clicksearchicon();
	}

	@When("user clicks on trending educator from the list")
	public void user_clicks_on_trending_educator_from_the_list() {
		SuggestionsPage sp=new SuggestionsPage(driver);
		sp.clicktrendingeducator();
	}

	@Then("user is redirected to appropriate search results")
	public void user_is_redirected_to_educator_s_profile_page() {
		SearchResultsHomePage sr=new SearchResultsHomePage(driver);
		assertEquals(sr.getsearchheading(), "Showing results for \"jatin\"" );
	}
}
