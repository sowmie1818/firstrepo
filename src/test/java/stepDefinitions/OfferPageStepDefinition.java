package stepDefinitions;

import static org.testng.Assert.assertEquals;
//import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.landingpageobjects;
import pageObjects.offerspageobjects;
import util.contextsetup;

public class OfferPageStepDefinition {
  
	contextsetup setupoff;
	PageObjectManager pagemanager;
	public OfferPageStepDefinition(contextsetup setupoff) {
		
		this.setupoff=setupoff;
	
	}

	
	@SuppressWarnings("deprecation")
	@Then("^User searched for short name(.+) in offers page$")
	public void User_searched_for_short_name_in_offers(String ShortName) throws InterruptedException {
		System.out.println("opffers page changes");
		switchtoofferpage();
		 //setupoff.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		offerspageobjects offerspage = setupoff.pagemanager.getOffersPage();
		//offerspage.getOfferproduct(ShortName);
		//pagemanager = new PageObjectManager(setupoff.driver);
		//offerspageobjects offers= pagemanager.getOffersPage();
	System.out.println(ShortName);
	    //pagemanager.searchforoffertab(ShortName);
		
	
				offerspage.searchforoffertab(ShortName);
				setupoff.productName2 = offerspage.getOfferproduct(ShortName);
		//setupoff.driver.findElement(By.id("search-field")).sendKeys(ShortName);
		//setupoff.productName2= setupoff.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]")).getText();
		System.out.println(setupoff.productName2+  "offer page prod");
		Thread.sleep(2000);
	}
	
	//follows SRP rule and increase code reusability
	//factory design pattern
	public void switchtoofferpage() {
		//if you already switched to offer page you can skip below part
		//if (setupoff.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//setupoff.driver.findElement(By.linkText("Top Deals")).click();
		//pagemanager = new PageObjectManager(setupoff.driver);
		
		landingpageobjects landingp1= setupoff.pagemanager.getLandingPage();
		//landingpageobjects td = new landingpageobjects(setupoff.driver);
		landingp1.topDeals();
		setupoff.genericUtils.SwitchingWindowToChild();
		
		
	}
	@Then("validate product name matches with offer page and landing page")
	public void validate_product_name_matches_with_offer_page_and_landing_page() {
        Assert.assertEquals(setupoff.productName,setupoff.productName2 );
        //setupoff.driver.quit();
		
	}
	
}
