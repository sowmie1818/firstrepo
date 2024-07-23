package cucumberTest;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",
monochrome=true,tags = "@PlaceOrder or @SearchOrder",
plugin = {"html:target/cucumber.html", "json:tagrget/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedScenariosTestRunner extends AbstractTestNGCucumberTests {

	//to run tests parallely. using super keyword we are getting scenarios method from abstract class
	//testng runner extends abstract class it will get the method
	
	@Override
	@DataProvider(parallel=true)
	
	public Object[][] scenarios(){
		
		return super.scenarios();
		
	}
	
}
