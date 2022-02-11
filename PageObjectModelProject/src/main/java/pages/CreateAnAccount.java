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
	
	@FindBy(id="registration-form-zipcode1")
	public WebElement PostalCodeMember;
	
	@FindBy(id="registration-form-phone1")
	public WebElement PhoneMember;

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
	
	@FindBy(xpath="//input[@id='registration-form-hudsonbay-rewards']")
	public WebElement HudsonReward;
	
	@FindBy (xpath = "//div[@class='form-group custom-control custom-checkbox']//label[@class='custom-control-label input-focus']")
	public WebElement termsLabel;
	
	@FindBy(xpath = "//div[@class='form-group custom-control custom-checkbox agree-message']//label[@class='custom-control-label input-focus']")
	public WebElement agreeLabel;
	
	//@FindBy(xpath="//div[@class='form-group custom-control custom-checkbox agree-message']//label[@class='custom-control-label input-focus']")
	public WebElement becomeInsider;
	
	
	@FindBy(xpath = "//div[contains(text(),'This field is required.')]")
	public WebElement FieldErr;

	public CreateAnAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle( ) {
		
		return driver.getTitle(); 
		
	}

	public void CreateAnAccount(String fn, String ln, String email, String pass, String cp ) {

		FirstName.sendKeys(fn);
		LastName.sendKeys(ln);
		Email.sendKeys(email);
		Password.sendKeys(pass);
		ConfPass.sendKeys(cp);
		
	}	
		public void SignUp(String pc, String pH, String pin, String cpin, String bd) {
		
		List<WebElement> rewards = RadioButton;
		rewards.get(0).click();
		for(WebElement a:rewards) {
		PostalCode.sendKeys(pc);
		Phone.sendKeys(pH);
		Pin.sendKeys(pin);
		ConfPin.sendKeys(cpin);
		BirthDate.sendKeys(bd);
		}
		
		}	
		public void AlreadyMember( String pc, String phone ) throws InterruptedException {
			
		List<WebElement> rewards = RadioButton;
		rewards.get(1).click();
		Thread.sleep(5000);
		
		for(WebElement a:rewards) {
			
		//HudsonReward.sendKeys(HR);	
		PostalCodeMember.sendKeys(pc);
		PhoneMember.sendKeys(phone);
		//becomeInsider.click();
		agreeLabel.click();
		
		}
		}
		
		public void create() {
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
	
	public String readFieldErr() {
		
		String ActfieldErr = FieldErr.getText();
		System.out.println(ActfieldErr);
		return ActfieldErr;
		
	}

}
