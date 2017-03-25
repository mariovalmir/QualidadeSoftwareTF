package uniritter.webdriver.po;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{
	
	public WebElement getCampoOrganizacao(){
		return getWebDriver().findElementById("organization");
	}
	public WebElement getCampoUsuario(){
		return getWebDriver().findElementById("user");
	}
	public WebElement getCampoSenha(){
		return getWebDriver().findElementById("passwd");
	}
	public WebElement getBotaoLogin(){
		return getWebDriver().findElementByName("submitit");
	}
	
	public WebElement getMensagemLogin(){
		return getWebDriver().findElementById("user_info");
	}
}
