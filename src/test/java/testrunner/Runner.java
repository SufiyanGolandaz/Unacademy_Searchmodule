package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/resources/Features",
plugin={"pretty",
		"html:target/cucumber-reports1/index.html", 
		"json:target/cucumber-reports2/cucumber.json",
		"junit:target/cucumber-reports3/cucumber.xml",
		},
glue= {"stepdefinitions","utlities"}
)
public class Runner extends AbstractTestNGCucumberTests {
	
}