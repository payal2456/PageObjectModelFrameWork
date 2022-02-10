package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import data.DataFile;
import pages.CreateAnAccount;
import pages.LoginPage;
import utility.TestUtil;

public class CreateAccountTest extends TestBase {
	
	CreateAnAccount ca;
	LoginPage lp;
	TestUtil testutil;
	String sheetname = "data1";
	DataFile df;
	
						
	public CreateAccountTest() {
		
		super();
		
	}
	@BeforeMethod
	public void beforMethod() throws IOException {

		openbrowser();
		ca= new CreateAnAccount();
		lp= new LoginPage();
		testutil = new TestUtil();
		df= new DataFile();
		lp.createAccountButton();
		testutil.switchToFrame();
							
	}
	
	//@Test(priority=1)
	public void verifyTitleTest( ) {
		
		String Title=ca.verifyTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Login - thebay.com");
		
	}
	
	@DataProvider
	public Object[][] getCreateAccountTestData() {
		
		Object data[][]= testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2)
	public void CreateAccount (String FN, String LN,String EMAIL,String PASS,String CONPASS,String POSTCODE,String PH,String PIN,String CONFPIN,String BDY) {
	
		ca.CreateAnAccount(FN, LN, EMAIL, PASS, CONPASS, POSTCODE, PH, PIN, CONFPIN, BDY);
		
	}
	
	@AfterMethod
		public void afterMethod() {
					closeBrowser();
			 }
							
	

}
