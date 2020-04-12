package fourCrewTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import fourCrewBaseFile.FourCrewBaseFile;

public class Categories extends FourCrewBaseFile {
	
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
		driver.findElement(By.xpath(propX.getProperty("categories"))).click();
		driver.findElement(By.xpath(propX.getProperty("categoriesAddButton"))).click();
	}
	
	@Test(dataProvider="getCategory", priority=5)
	public void addCategory(String productcategorytitle, String metatitle, String metadescription) throws Exception
	{
		
		driver.findElement(By.xpath(propX.getProperty("productcategorytitle"))).sendKeys(productcategorytitle);
		driver.findElement(By.xpath(propX.getProperty("parentproductcategory"))).click();
		Thread.sleep(5000);
		 jse = (JavascriptExecutor)driver;
		 jse.executeScript("scroll(0, 3000);");
		
		driver.findElement(By.xpath(propX.getProperty("metatitle"))).sendKeys(metatitle);
		driver.findElement(By.xpath(propX.getProperty("metadescription"))).sendKeys(metadescription);
		
		//driver.findElement(By.xpath(propX.getProperty("categoriessubmit"))).click();
			
	}
	
	

}
