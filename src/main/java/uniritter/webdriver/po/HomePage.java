package uniritter.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasicPage {
	
	public WebElement getNovaMensagem() {
		getWebDriver().fluentWait(By.cssSelector("td.new-message-button > div > span"));
		return getWebDriver().findElementByCssSelector("td.new-message-button > div > span");
		
	}

	
}
