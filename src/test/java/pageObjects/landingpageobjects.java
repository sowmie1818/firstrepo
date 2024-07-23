package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingpageobjects {
	
	public WebDriver driver;
	
	public landingpageobjects(WebDriver driver) {
		this.driver=driver;
	}

    private	By search = By.xpath("//input[@type='search']");
    private By landingproductName = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/h4");
    private By topdeals = By.linkText("Top Deals");
	//private By title = By.cssSelector(".brand.greenLogo");
    private By increment =By.cssSelector("a.increment");
    private By Addtocartbtn = By.cssSelector(".product-action button");
	
	public void SearchItem(String searchName) {
		driver.findElement(search).sendKeys(searchName); 
	}
	public void topDeals() {
		driver.findElement(topdeals).click();
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
    
	public String getproductName() {
		// TODO Auto-generated method stub
		return driver.findElement(landingproductName).getText().split("-")[0].trim();
		 
	}
	
	public String getTitleOfLanding() {
		 return driver.getTitle();
		
		
	}
	
	public void incrementprod(int quantity) {
		//example quantity = 3, i=2 which satisfies while condition.i-- it will decrement
		int i = quantity-1;
		
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void selectaddtocart() {
		driver.findElement(Addtocartbtn).click();
	}
}
