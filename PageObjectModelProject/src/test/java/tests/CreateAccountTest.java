package tests;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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
	DataFormatter dataformate;
	
	public CreateAccountTest() {
		
		super();
		
	}
	
	//@BeforeMethod
	public void beforMethod() throws IOException {

		openbrowser();
		ca= new CreateAnAccount();
		lp= new LoginPage();
		df= new DataFile();
		lp.createAccountButton();
							
	}
	
	@Test
	public void test( ) throws NumberFormatException {
		df= new DataFile();
		DataFormatter dataformate = new DataFormatter();
		//System.out.println(df.PH1);
		System.out.println(df.BDY);
	}
	
	//@Test(priority=1)
	public void verifyTitleTest( ) {
		
		String Title=ca.verifyTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Login - thebay.com");
		
	}
	
	//@DataProvider
	public Object[][] getCreateAccountTestData() {
		
		Object data[][]= TestUtil.getTestData(sheetname);
		return data;
	}
	
	//@Test(priority=2 )
	public void CreateAccountSignUPTest ()throws InterruptedException {
	
		ca.CreateAnAccount(df.FN, df.LN, df.EMAIL, df.PASS, df.CONFPASS);//, df.POSTCODE, df.PH, df.PIN, df.CONFPIN, df.BDY);
		ca.SignUp(df.POSTCODE, df.PH1, df.PIN, df.CONFPIN, df.BDY);
		ca.create();
		String ActualErr = ca.readActualErr();
		String ExpectedErr = df.expectErr;
		Assert.assertEquals(ActualErr, ExpectedErr);
		
	}
	
	//@Test(priority= 3)
	
	public void CreateAccountAlreadyMemberTest ()throws InterruptedException {
		
		ca.CreateAnAccount(df.FN, df.LN, df.EMAIL, df.PASS, df.CONFPASS);//, df.POSTCODE, df.PH, df.PIN, df.CONFPIN, df.BDY);
		ca.AlreadyMember(df.POSTCODE, df.PH2);
		ca.create();
		String ActualFieldErr = ca.readFieldErr();
		String ExpectedErr = df.fieldErr;
		Assert.assertEquals(ActualFieldErr, ExpectedErr);
		
	}
	
	
	//@AfterMethod
		public void afterMethod() {
					closeBrowser();
			 }
							
	

}
