package unirriter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import uniritter.webdriver.po.CalendarPage;
import uniritter.webdriver.po.CatalogPage;
import uniritter.webdriver.po.LoginPage;
import uniritter.webdriver.po.SendEmailPage;

public class ExpressoSearchTest {

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
	}

	@Test
	public void testRealizaLoginSucesso() throws Exception {
		logaSeNaoEstaLogado();
		LoginPage lp = new LoginPage();
		logaSeNaoEstaLogado();

		String nomeUsuario = lp.getMensagemLogin().getText();
		assertTrue(nomeUsuario.contains("Mario Valmir Gomes Pereira Junior"));
	}

	@Test
	public void testEnviaEmailSemDestinatario() throws Exception {
		logaSeNaoEstaLogado();
		
		SendEmailPage sep = new SendEmailPage();
		
		sep.getNovaMensagem().click();
		sep.getCampoAssunto().sendKeys("Assunto Teste");
		sep.getBotaoEnviar().click();
		
		assertEquals("Você deve fornecer pelo menos um endereço de destinatário de email.",
				sep.getWebDriver().findElementById("em_div_write_msg").getText());
	}
	
	@Test
	public void testConsultaCatalogoEndereco() throws Exception {
		logaSeNaoEstaLogado();

		CatalogPage cp = new CatalogPage();
		cp.getCampoPesquisaCatalogo().sendKeys("M�rio Valmir");
		cp.getBotaoPesquisa().click();
		cp.getTabelaCatalogo().click();

		assertEquals("60566", cp.getLinhaCatalogo().getText());
	}
	
	@Test
	public void testCriaEventoCalendarioEmRascunho() throws Exception {
		logaSeNaoEstaLogado();
		CalendarPage cp = new CalendarPage();
		cp.getBotaoCalendario().click();

		cp.getWebDriver().doubleClick(cp.getTabelaNovoEvento());
		cp.getTituloEvento().sendKeys("Titulo Teste");
		cp.getDescricaoEvento().sendKeys("Descrição Teste");
		cp.getLocalEvento().sendKeys("Locação Teste");
		cp.getBotaSalvar().click();

		assertEquals("08:00 - 08:30 - Titulo Teste - Descrição Teste", cp.getEvento().getText());
		
		cp.getWebDriver().doubleClick(cp.getEvento());
		cp.getBotaoRemover().click();
		cp.getWebDriver().confirmDialog();
		
		assertEquals("", cp.getTabelaNovoEvento().getText());
		
	}
	
	@AfterClass
	public static void tearDown(){
		LoginPage lp = new LoginPage();
		lp.getWebDriver().close();
	}
	
	private void logaSeNaoEstaLogado(){
		LoginPage lp = new LoginPage();
		
		try {
			lp.getMensagemLogin();
			lp.getWebDriver().get("/expressoMail/index.php");
		} catch (NoSuchElementException e) {
			lp.getWebDriver().get("/login.php");
			lp.getCampoOrganizacao().sendKeys("PROCERGS");
			lp.getCampoUsuario().sendKeys("mario-pereira");
			lp.getCampoSenha().sendKeys("1interpoa");
			lp.getBotaoLogin().click();
		}
			
	}
}
