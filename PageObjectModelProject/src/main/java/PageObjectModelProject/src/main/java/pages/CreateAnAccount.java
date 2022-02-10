package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateAnAccount extends TestBase{

	@FindBy(id="registration-form-fname")
	public WebElement FirstName;

	@FindBy(id="registration-form-lname")
	public WebElement LastName;

	@FindBy(id="registration-form-email")
	public WebElement Email;

	@FindBy(id="registration-form-password")
	public WebElement Password;

	@FindBy(id="registration-form-password-confirm")
	public WebElement ConfPass;

	@FindBy(name="contact")
	public List<WebElement> RadioButton;

	@FindBy(id="registration-form-zipcode2")
	public WebElement PostalCode;

	@FindBy(id="registration-form-phone2")
	public WebElement Phone;

	@FindBy(id="registration-form-pin")
	public WebElement Pin;

	@FindBy(id="registration-form-confirmPin")
	public WebElement ConfPin;

	@FindBy(id="registration-form-birthday")
	public WebElement BirthDate;
	
	@FindBy(xpath="//div[contains(text(),'Before enrollng, please read and agree to the term')]")
	public WebElement Error;

	public CreateAnAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle( ) {
		
		return driver.getTitle(); 
		
	}

	public void CreateAnAccount(String fn, String ln, String email, String pass, String cp, String pc, String phone, String pin, String cpin, String bd ) {

		FirstName.sendKeys(fn);
		LastName.sendKeys(ln);
		Email.sendKeys(email);
		Password.sendKeys(pass);
		ConfPass.sendKeys(cp);
		List<WebElement> rewards = RadioButton;
		rewards.get(0).click();
		PostalCode.sendKeys(pc);
		Phone.sendKeys(phone);
		Pin.sendKeys(pin);
		ConfPin.sendKeys(cpin);
		BirthDate.sendKeys(bd);
		
		WebElement Create = driver.findElement(By.id("registration-submit"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", Create);
		Create.click();

	}
	
	public String readActualErr() {
		
		String ActualErr= Error.getText();
		System.out.println(ActualErr);
		
		return ActualErr;
		
	}

}
