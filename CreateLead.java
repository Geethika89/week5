package TestLeaf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;
import testng.day2.LearnExcel;

public class CreateLead extends BaseTest{
	
	@BeforeClass
	public void setFileName() {
		excelFileName="CreateLead";
	}

	@Test(dataProvider = "fetchData")
	public  void runCreateLead(String Company,String fname, String lname) {
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();*/
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(Company);
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("submitButton").click();
		//driver.close();
}


	/*@DataProvider(name = "fetchData")
public String[][] dataSetup() throws IOException {
	LearnExcel le = new LearnExcel() ;
		return le.excelRead();
	/*	String[][] data = new String[1][3];
		data[0][0] = "NoCompany";
		data[0][1] = "Geethika";
		data[0][2] = "Gokul";
		
		return data;*/
		
	
	
}



