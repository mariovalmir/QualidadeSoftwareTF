package uniritter.webdriver.po;

import uniritter.webdriver.WebDriverUtil;

public abstract class BasicPage {

	public BasicPage() {
	}

	public WebDriverUtil getWebDriver() {
		return WebDriverUtil.instance("https://expresso.rs.gov.br");
	}
}
