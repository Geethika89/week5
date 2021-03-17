package testng.day1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day2.LearnExcel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	public ChromeDriver driver;
	
	public String excelFileName;
	
  @Parameters({"url","username","password"})
  @BeforeMethod
  public void preConditions(String url,String username,String password) {
	  
	  WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		driver=new ChromeDriver();
		
		//driver.get("http://leaftaps.com/opentaps/control/main");
		driver.get(url);
		
		driver.manage().window().maximize();
		//driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("username").sendKeys(username);
		
		//driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementById("password").sendKeys(password);
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  
	@DataProvider(name = "fetchData")
    public String[][] dataSetup() throws IOException {
	LearnExcel le = new LearnExcel() ;
		
		return le.excelRead(excelFileName);
		
		
}

}
