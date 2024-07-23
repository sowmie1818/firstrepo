package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObjects {
	
	public WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver) {
		this.driver=driver;
	}

    private	By cart = By.xpath("//img[@alt='Cart']");
    private By proceedToCheckout = By.cssSelector("div[class='cart-preview active'] button[type='button']");
    private By promoButton = By.cssSelector(".promoBtn");
    private By checkoutButton = By.xpath("//button[contains(text(),'Place Order')]");
    private By checkoutpageprod = By.cssSelector(".product-name");
	
	
	public void CheckoutItems() {
		driver.findElement(cart).click();
		driver.findElement(proceedToCheckout).click();
	}
   public Boolean VerifyPromoBtn() {
	   return driver.findElement(promoButton).isDisplayed();
   }
   public Boolean VerifyPlaceOrder() {
	   return driver.findElement(checkoutButton).isDisplayed();
   } 

   public String getTextcheckoutProd() {
	   return driver.findElement(checkoutpageprod).getText().split("-")[0].trim();
   }
}

