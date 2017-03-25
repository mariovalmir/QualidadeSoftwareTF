package uniritter.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class WebDriverUtil {

	private static WebDriverUtil webDriverUtil;
	private WebDriver driver;
	private String baseUrl;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public WebElement fluentWait(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		while (true) {
			if (!foo.isDisplayed()) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
				}
			} else {
				break;
			}
		}

		return foo;
	}
	
	public void doubleClick(WebElement webElement){
		Actions action = new Actions(driver);
		action.moveToElement(webElement).doubleClick().build().perform();
	}
	
	public void confirmDialog(){
		driver.switchTo().alert().accept();
	}
	
	public WebElement findElementByCssSelector(String element) {
		return driver.findElement(By.cssSelector(element));
	}
	public WebElement findElementByName(String element) {
		return driver.findElement(By.name(element));
	}

	public WebElement findElementByXpath(String element) {
		return driver.findElement(By.xpath(element));
	}

	public WebElement findElementById(String element) {
		return driver.findElement(By.id(element));
	}
	public WebElement findElementByClassName(String element) {
		return driver.findElement(By.className(element));
	}
	
	public void get(String pagina){
		driver.get(baseUrl + pagina);
	}
	
	public void close(){
		driver.close();
	}

	public static WebDriverUtil instance(String baseUrl) {
		if(webDriverUtil == null){
			webDriverUtil = new WebDriverUtil();
			webDriverUtil.setDriver(new ChromeDriver());
			webDriverUtil.setBaseUrl(baseUrl);
		}
		return webDriverUtil;
	}

	private WebDriverUtil(){
	}
}
