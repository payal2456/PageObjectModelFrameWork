package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	Actions account = new Actions(driver);
	

	@FindBy(id="Layer_1")
	public WebElement TheBayLogo;

	@FindBy(id="checkSoftLogout")
	public WebElement CreateAccount;

	//@FindBy(linkText="CREATE AN ACCOUNT")
	public WebElement CreateAnAccount;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String Validatetitle () {
		return driver.getTitle();		
	}

	public void NewTab() throws InterruptedException {
		
		WebElement New = driver.findElement(By.id("new-in"));
		account.moveToElement(New).build().perform();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@data-adobelaunchsubcategory='New & Now']//li"));
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
	}
		
		}

		public CreateAnAccount createAccount () {
			WebElement SignIn = driver.findElement(By.id("checkSoftLogout"));
			account.moveToElement(SignIn).build().perform();

			return new CreateAnAccount();

		}











	}