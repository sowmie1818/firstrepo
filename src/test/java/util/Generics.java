package util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Generics {
	
	public WebDriver driver;
	public Generics(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SwitchingWindowToChild() {
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentwindow =i1.next();
		String childwindow = i1.next();
		driver.switchTo().window(childwindow);
	}

}
