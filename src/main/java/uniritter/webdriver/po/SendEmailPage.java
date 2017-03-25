package uniritter.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SendEmailPage extends HomePage {

	public WebElement getCampoAssunto() {
		getWebDriver().fluentWait(By.name("input_subject"));
		return getWebDriver().findElementByName("input_subject");
	}
	public WebElement getBotaoEnviar() {
		return getWebDriver().findElementByXpath("//div[@id='content_id_1']/div/div/button");
	}
}
