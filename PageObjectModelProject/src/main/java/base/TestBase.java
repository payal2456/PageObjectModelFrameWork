package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import utility.TestUtil;

public class TestBase {
	
		 	public static WebDriver driver;
		 	public static Properties prop;
 	
 			public void openbrowser() throws IOException {
 				
 				FileInputStream f = new FileInputStream("D:\\QA\\Testing\\TheBayProp.properties");
 				Properties prop = new Properties();
 				prop.load(f);
 				String browser = prop.getProperty("browser");
 				System.out.println(browser);
 				
 				if(browser.equals("firefox")) {
 					System.setProperty("webdriver.gecko.driver","D:\\QA\\SeleniumJars\\geckodriver.exe");
 					driver = new FirefoxDriver();  
 					} else if(browser.equals("chrome")) {
 						System.setProperty("webdriver.chrome.driver", "D:\\QA\\SeleniumJars\\chromedriver.exe");
 						driver = new ChromeDriver();  
 					}else {
 						System.setProperty("webdriver.Safari.driver", "D:\\QA\\SeleniumJars\\safaridriver.exe");
 						driver = new SafariDriver();  
 					}
 			
 				driver.manage().window().maximize();
 				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
 				driver.get(prop.getProperty("url"));
 				
 				List<WebElement> popUp = driver.findElements(By.id("consent-close"));
 				
 				if (popUp.size()>0) {
 					
 					popUp.get(0).click();
	
 				}
 		}
 				
 				public void closeBrowser() {
 					driver.quit();
 				}
 			
     }