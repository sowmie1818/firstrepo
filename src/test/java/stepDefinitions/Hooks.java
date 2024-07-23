package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import util.contextsetup;

public class Hooks{
	
	public contextsetup setup;
	//contextsetup setup is dependency injection
	public Hooks(contextsetup setup) {
		this.setup = setup;
	}
	
	
	

	@After
	
	public void AfterScenario() throws InterruptedException, IOException {
		
		setup.testBase.WebDriverManager().quit();
		
		
		
	}
	
	@AfterStep
	
	public void AddScreenshot(Scenario scenario) throws IOException, InterruptedException {
		WebDriver driver = setup.testBase.WebDriverManager();
		
		if(scenario.isFailed()) {
			
			File srcpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(srcpath);
			scenario.attach(fileContent, "image/png", "screenshot");
		}
		
	}
	
}
