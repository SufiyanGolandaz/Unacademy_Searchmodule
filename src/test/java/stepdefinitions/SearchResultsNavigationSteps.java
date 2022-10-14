package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EducatorProfilePage;
import pages.LearningGoalHomePage;
import pages.SearchResultsHomePage;
import utlities.Hooks;

public class SearchResultsNavigationSteps {
	
	private WebDriver driver=Hooks.driver;
	
	LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	SearchResultsHomePage sr=new SearchResultsHomePage(driver);
	EducatorProfilePage epp=new EducatorProfilePage(driver);
	
	@When("user clicks on profile under Educator category")
	public void user_clicks_on_profile_under_educator_category() throws InterruptedException {
		Thread.sleep(5000);
		sr.clickeducatorprofile();
	}

	@Then("user is redirected to educator's profile page")
	public void user_is_redirected_to_educator_s_profile_page() {
		assertEquals(sr.geteducatorlink(), epp.getpageurl());
	}
	
	@When("user searches for query in search bar")
	public void user_searches_for_query_in_search_bar(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data=dataTable.cells();
	    lghp.clicksearchicon();
	    lghp.searchquery(data.get(0).get(0));
	}

	@When("user clicks on search results under Courses category")
	public void user_clicks_on_search_results_under_courses_category() {
	    sr.clickcourse();
	}

	@Then("user is redirected to course subscription page")
	public void user_is_redirected_to_course_subscription_page() {
		assertEquals(sr.getcourselink(), epp.getpageurl());
	}


	@When("user presses back button")
	public void user_presses_back_button() {
	    driver.navigate().back();
	}

	@Then("user is redirected back to search results")
	public void user_is_redirected_back_to_search_results() {
		assertEquals(driver.getCurrentUrl(),sr.getcurrenturl());
	}

	
}
