package fourCrewTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import fourCrewBaseFile.FourCrewBaseFile;

public class Manufacturers extends FourCrewBaseFile{
	
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		driver.get(propX.getProperty("URL"));
	}
	
				
	@Test(priority=2)
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider="getData", priority=3)
	
		public void login(String email, String pass){
		System.out.println(email);
		System.out.println(pass);
		driver.findElement(By.xpath(propX.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(propX.getProperty("pass"))).sendKeys(pass);
		
		driver.findElement(By.xpath(propX.getProperty("loginbutton"))).click();
		
	}
	
	@Test(priority=4)
	public void clickHamburgerMenu()
	{
		driver.findElement(By.xpath(propX.getProperty("catalogmanagment"))).click();
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("manufacturers"))));
		
		driver.findElement(By.xpath(propX.getProperty("manufacturers"))).click();
		driver.findElement(By.xpath(propX.getProperty("manufacturersAdd"))).click();
	}
	

	@Test(dataProvider="getManufacturers", priority=5)
	public void addManufacturer(String manufacturertitle, String manufacturermetatitle, String manufacturermetadescription) throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath(propX.getProperty("manufacturertitle"))).sendKeys(manufacturertitle);
		
		driver.findElement(By.xpath(propX.getProperty("category"))).click();
		/*Select dropdown=new Select(driver.findElement(By.xpath(propX.getProperty("category"))));
		dropdown.selectByIndex(2);*/
		
		 driver.findElement(By.xpath(propX.getProperty("categoryselection"))).click();
		 driver.findElement(By.xpath(propX.getProperty("descriptiontext"))).click();
		 Thread.sleep(5000);
		 jse = (JavascriptExecutor)driver;
		 jse.executeScript("scroll(0, 3000);");
		
		driver.findElement(By.xpath(propX.getProperty("manufacturermetatitle"))).sendKeys(manufacturermetatitle);
		driver.findElement(By.xpath(propX.getProperty("manufacturermetadescription"))).sendKeys(manufacturermetadescription);
		
		//driver.findElement(By.xpath(propX.getProperty("categoriessubmit"))).click();
			
	}
}
