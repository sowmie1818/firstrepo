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
import pageObjects.CheckoutPageObjects;
import pageObjects.landingpageobjects;
import util.contextsetup;

public class CheckoutPageStepDefinition {
    
//single responsibility principle	
	
	public CheckoutPageObjects checkoutpage;
	contextsetup setup;
	
	//creating instance of contextsetup class in the parameter of constructor
	public CheckoutPageStepDefinition(contextsetup setup) {
		//this.setup refereing to the global varibale declared at class level
		//=setup refers to the parameter passed in the constructor
		
		this.setup=setup;
		this.checkoutpage=setup.pagemanager.getCheckoutPage();
		
	}
@Then("Verify user has ability to enter promo code and place the order")
public void Verify_user_has_ability_to_enter_promo_code_and_place_the_order()  {
	
	
	Assert.assertTrue(checkoutpage.VerifyPromoBtn());
	Assert.assertTrue(checkoutpage.VerifyPlaceOrder());
	System.out.println("practicing git");
	System.out.println("practice git 2");
	System.out.println("laod it to eclipseworkspace repo");
	
	System.out.println("delete branch");
	
	System.out.println("changed to branch");
	
	}
@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void User_proceeds_to_Checkout(String ShortName) throws InterruptedException {
	
	checkoutpage.CheckoutItems();
	setup.checkoutprodname =   checkoutpage.getTextcheckoutProd();
	 Assert.assertEquals(setup.productName,setup.checkoutprodname );
	
}
}
	