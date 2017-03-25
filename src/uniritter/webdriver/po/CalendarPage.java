package uniritter.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarPage extends BasicPage {

	public WebElement getBotaoCalendario() {
		return getWebDriver().findElementById("calendarid");
	}
	
	public WebElement getTabelaNovoEvento() {
		getWebDriver().fluentWait(By.xpath("//div[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td/div[2]"));
		return getWebDriver().findElementByXpath("//div[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td/div[2]");
	}
	
	public WebElement getTituloEvento() {
		getWebDriver().fluentWait(By.name("cal[title]"));
		return getWebDriver().findElementByName("cal[title]");
	}
	public WebElement getDescricaoEvento() {
		getWebDriver().fluentWait(By.name("cal[description]"));
		return getWebDriver().findElementByName("cal[description]");
	}
	
	public WebElement getLocalEvento() {
		getWebDriver().fluentWait(By.name("cal[location]"));
		return getWebDriver().findElementByName("cal[location]");
	}
	
	public WebElement getBotaSalvar() {
		return getWebDriver().findElementById("submit_button");
	}
	
	public WebElement getEvento() {
		getWebDriver().fluentWait(By.className("dhx_cal_event_clear"));
		return getWebDriver().findElementByClassName("dhx_cal_event_clear");
	}
	
	public WebElement getBotaoRemover() {
		getWebDriver().fluentWait(By.cssSelector("form[name=\"Removerform\"] > div > input[type=\"submit\"]"));
		return getWebDriver().findElementByCssSelector("form[name=\"Removerform\"] > div > input[type=\"submit\"]");
	}
}
