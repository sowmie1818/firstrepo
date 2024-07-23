package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
public class offerspageobjects {
	
	public WebDriver driver;
	//public prodname2;
	
	public offerspageobjects(WebDriver driver) {
		
	    this.driver=driver;
	}
	 //WebDriverWait wait = new WebDriverWait(driver, Duration(10));

     // Wait until the element with the id "search-field" is present using XPath
     //WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='search-field']")));

	private By searchField = By.xpath("//*[@id='search-field']");
   
	private By offerproductName = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]");
	
	
	public void searchforoffertab(String offerproduct) {
		 driver.findElement(searchField).sendKeys(offerproduct);
		
		
	}
	
	//private java.time.Duration Duration(int i) {
		// TODO Auto-generated method stub
		//return null;
	//}

	public void getSearchText() {
		driver.findElement(searchField).getText();
	}
	
	public String getOfferproduct(String shortName) {
		return driver.findElement(offerproductName).getText();
		
	}

	
	
	
	
	
}
