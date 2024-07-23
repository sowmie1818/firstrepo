package stepDefinitions;

import static org.testng.Assert.assertEquals;
//import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.landingpageobjects;
import util.contextsetup;

public class LandingPageGreenCartStepDefinition {
    
//single responsibility principle	
	
	
	contextsetup setup;
	 landingpageobjects landingpage;
	
	//creating instance of contextsetup class in the parameter of constructor
	public LandingPageGreenCartStepDefinition(contextsetup setup) {
		//this.setup refereing to the global varibale declared at class level
		//=setup refers to the parameter passed in the constructor
		
		this.setup=setup;
	 this.landingpage = setup.pagemanager.getLandingPage();
	}

	@Given("User is On GreenCart Landing Page")
	public void User_is_On_GreenCart_Landing_Page() throws InterruptedException, IOException {
		//System.setProperty("webdriver.chrome.driver","C:/chromedriver-win64/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//setup.driver = new ChromeDriver();
		//setup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//setup.driver.manage().window().maximize();
		//Thread.sleep(2000);
		setup.testBase.WebDriverManager();
		Assert.assertTrue(landingpage.getTitleOfLanding().contains("GreenKart"));
	}
	@When("^User searched with shortname (.+) and extract actual name of product$")
	public void User_searched_with_shortname_and_extract_actual_name_of_product(String ShortName) throws InterruptedException {

	 landingpage.SearchItem(ShortName);
		//setup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);
	 Thread.sleep(2000);
	  setup.productName  =landingpage.getproductName();
	 //splitting the name for easy validation, splitting will create an array staring Tomato in 0 index and 1 in 1st index
	 //trim will remove the extra spaces and gives only the wanted text
	
	 
	 //setup.productName=setup.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/h4")).getText().split("-")[0].trim();
	 System.out.println("Landing page product"+ setup.productName);
	 
	}
	
	@When("^Added (.+) items to the selected product to cart$")
	public void Added_items_to_the_selected_product(String quantity) {
		
		landingpage.incrementprod(Integer.parseInt(quantity)); //changing string to int
		landingpage.selectaddtocart();
		
		
	}

}
	