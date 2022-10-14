package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LearningGoalHomePage;
import pages.SearchResultsHomePage;
import utlities.Hooks;

public class DataValidationSteps {
	private WebDriver driver=Hooks.driver;
	LearningGoalHomePage lghp=new LearningGoalHomePage(driver);
	SearchResultsHomePage sr=new SearchResultsHomePage(driver);
	XSSFSheet sheet=Hooks.sheet;
	
	@When("user enters query as {string} in search bar")
	public void user_enters_query_as_in_search_bar(String query) {
		lghp.clicksearchicon();
	    lghp.searchquery(query);
	}

	@Then("user obtains search results same as {string}")
	public void user_obtains_search_results_same_as(String string) {
	    assertEquals(sr.getsearchheading(), "Showing results for \""+string+"\"");
	}
	
	@Then("user does not get results")
	public void user_does_not_get_results() {	    
	    assertEquals(sr.searchsuccesful(),false);
		
	}
	
	@When("user enters query in search bar from sheet from rownumbers {int}")
	public void user_enters_query_in_search_bar_from_sheet_from_rownumbers(int rownum) {
		lghp.clicksearchicon();
		lghp.searchquery(sheet.getRow(rownum).getCell(0).getStringCellValue());
	}

}
