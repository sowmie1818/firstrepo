package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws InterruptedException, IOException {
		//gets the file from any system when we use user.dir
		FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String url = prop.getProperty("QAurl");
		String browser_prop = prop.getProperty("browser");
		String mvnbrowser=System.getProperty("browser"); // this will return value passed from maven command
		//java ternary operator
		 String browser = mvnbrowser!=null?mvnbrowser:browser_prop; //if browser value coming from 
		 //maven is null then it will go with browser prop or if it true then with mvnbrowser
		
		if(driver==null) {	
			
			if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox")) {
				
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		//driver.manage().window().maximize();
		
		}
		return driver;
		
		
	}

}
