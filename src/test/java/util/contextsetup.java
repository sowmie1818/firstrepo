package util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import pageObjects.offerspageobjects;

public class contextsetup {

	public WebDriver driver;
	
	public String productName;
	
	public String productName2;
	
	public String checkoutprodname;
	
	public PageObjectManager pagemanager;
	
	public TestBase testBase;
	
	public Generics genericUtils;

	public contextsetup() throws InterruptedException, IOException {
		
		testBase = new TestBase();
		
		pagemanager = new PageObjectManager(testBase.WebDriverManager());
		
		genericUtils = new Generics(testBase.WebDriverManager());
		
	}
	
}
