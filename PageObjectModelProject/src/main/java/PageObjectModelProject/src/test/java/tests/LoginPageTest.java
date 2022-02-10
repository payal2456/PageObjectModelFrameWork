package tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

		LoginPage lp;

		public LoginPageTest() {
		super();
	}
		@BeforeMethod
		public void beforMethod() throws IOException {

		openbrowser();
		lp= new LoginPage();
		
		}
		
		@Test(priority=1)
		public void loginPageTitletest() {
			
			String title = lp.Validatetitle();
			System.out.println(title);
			Assert.assertEquals(title, "Hudson's Bay: Canada's Iconic Department Store");
		}
		
		@Test(priority=2)
		public void newTabTest() throws InterruptedException {
			
			lp.NewTab();
			
			}
		
		@Test(priority=3)
		public void createAccountTest() {
			lp.createAccountButton();
		}
		
		
		@AfterMethod
		public void afterMethod() {
			closeBrowser();
	 }
}
