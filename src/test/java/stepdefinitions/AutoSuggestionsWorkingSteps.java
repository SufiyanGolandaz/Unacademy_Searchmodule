package stepdefinitions;

import static org.junit.Assert.assertTrue;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LearningGoalHomePage;
import pages.SearchResultsHomePage;
import pages.SuggestionsPage;
import utlities.Hooks;
import utlities.ReadPropFile;

public class AutoSuggestionsWorkingSteps {
	
	private WebDriver driver=Hooks.driver;
	LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	SuggestionsPage sp=new SuggestionsPage(driver);
	SearchResultsHomePage sr=new SearchResultsHomePage(driver);
	ReadPropFile rp=new ReadPropFile();
	
	@When("user types query in search bar from properties file")
	public void user_types_query_in_search_bar_from_properties_file() throws IOException {
	    rp.readfile();
	    lghp.clicksearchicon();
	    sp.typequery(rp.getquery());
	}
	
	@When("user types query {string} in search bar")
	public void user_types_query_in_search_bar(String string) {
		lghp.clicksearchicon();
	    sp.typequery(string);
	}
	
	

	@Then("user is prompted with valid suggestions")
	public void user_is_prompted_with_valid_suggestions() {
	    assertTrue(sp.propersuggestion());
	}


	@And("user clicks on suggested query")
	public void user_clicks_on_suggested_query() {
	    sp.clicktrendingeducator();
	}

	@And("user clicks on down arrow key")
	public void user_clicks_on_down_arrow_key() {
	    sp.gettrendingeducator().sendKeys(Keys.DOWN);
	}

	@Then("user is redirected to search results")
	public void user_is_redirected_to_search_results() {
	    assertTrue(sr.getsearchheading().contains(sp.nameofquery()));
	}
	
	@Then("user is redirected to next suggestion from the list")
	public void user_is_redirected_to_next_suggestion_from_the_list() {
	    assertTrue(sp.nexteducator());
	}
}
