package stepdefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LearningGoalHomePage;
import pages.SearchResultsHomePage;
import utlities.Hooks;

public class SearchResultsFilterSteps {
	
	private WebDriver driver=Hooks.driver;
	LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	SearchResultsHomePage sr=new SearchResultsHomePage(driver);
	
	@When("user searches for query {string} in search bar")
	public void user_searches_for_query_in_search_bar(String string) {
	    lghp.clicksearchicon();
	    lghp.searchquery(string);
	}

	@Then("search results are available under Educators, Courses or Lessons category")
	public void search_results_are_available_under_educators_courses_or_lessons_category() {
		
	    assertTrue(sr.categoriesvisible());
	}


	@Then("See All button is visible")
	public void see_all_button_is_visible() {
	    assertTrue(sr.seeallbtnvisible());
	}

	@When("user clicks on See All button")
	public void user_clicks_on_see_all_button() {
		sr.clickseeallbtn();
	}

	@Then("user is able to see expanded search results")
	public void user_is_able_to_see_expanded_search_results() {
		assertTrue(sr.expandedresultvisible());
	}
}
