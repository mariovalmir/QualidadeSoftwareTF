package uniritter.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasicPage {

	public WebElement getCampoPesquisaCatalogo() {
		getWebDriver().fluentWait(By.id("em_message_search"));
		return getWebDriver().findElementById("em_message_search");
	}
	
	public WebElement getBotaoPesquisa() {
		return getWebDriver().findElementByCssSelector("#search-div > span.fa.fa-user");
	}
	
	public WebElement getTabelaCatalogo() {
		getWebDriver().fluentWait(By.xpath("//input[@value='procergs-mario-pereira']"));
	    return getWebDriver().findElementByXpath("//input[@value='procergs-mario-pereira']");
	}
	
	public WebElement getLinhaCatalogo() {
		getWebDriver().fluentWait(By.xpath("//div[@id='box-person-info']/table/tbody/tr[5]/td[2]"));
		return getWebDriver().findElementByXpath("//div[@id='box-person-info']/table/tbody/tr[5]/td[2]");
	}
	
	
}
