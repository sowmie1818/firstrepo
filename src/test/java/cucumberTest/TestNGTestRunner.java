package cucumberTest;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",
monochrome=true,tags = "@PlaceOrder or @SearchOrder",
plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	//to run tests parallely. using super keyword we are getting scenarios method from abstract class
	//testng runner extends abstract class it will get the method
	
	@Override
	@DataProvider(parallel=true)
	
	public Object[][] scenarios(){
		
		return super.scenarios();
		
	}
	
}
