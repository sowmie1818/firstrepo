package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public landingpageobjects lp;
	public offerspageobjects op;
	public CheckoutPageObjects cp;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public landingpageobjects getLandingPage() {
		
		lp = new landingpageobjects(driver);
		return lp;
		
	}
	
	public offerspageobjects getOffersPage() {
		
		if (op == null) {
            op = new offerspageobjects(driver);
        }
        
		//op = new offerspageobjects(driver);
		return op;
	}

	public CheckoutPageObjects getCheckoutPage() {
		
		cp = new CheckoutPageObjects(driver);
		return cp;
		
		
	}
	
}
