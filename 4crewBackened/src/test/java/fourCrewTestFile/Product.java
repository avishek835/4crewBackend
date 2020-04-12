package fourCrewTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import fourCrewBaseFile.FourCrewBaseFile;


public class Product extends FourCrewBaseFile{
	
		
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		
		driver.get(propX.getProperty("URL"));
		
	}
	
	@Test(priority=2)
	public void getText()
	{
		s=driver.findElement(By.xpath(propX.getProperty("LoginText"))).getText();
		if(s!=null)
			System.out.println(s);
		else
			System.out.println("No text is there");
			
	}
	
	@Test(priority=3)
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider="getData", priority=4)
	
		public void login(String email, String pass){
		System.out.println(email);
		System.out.println(pass);
		driver.findElement(By.xpath(propX.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(propX.getProperty("pass"))).sendKeys(pass);
		
		driver.findElement(By.xpath(propX.getProperty("loginbutton"))).click();
		
	}
	
	@Test(priority=5)
	public void clickHamburgerMenu()
	{
		driver.findElement(By.xpath(propX.getProperty("catalogmanagment"))).click();
		driver.findElement(By.xpath(propX.getProperty("products"))).click();
		driver.findElement(By.xpath(propX.getProperty("Addbutton"))).click();
	}
	
	@Test(dataProvider="getProduct", priority=6)
	public void addProduct(String ProductName, String RegularPrice, String SalePrice, String Quantity
) throws Exception
	{
		
		driver.findElement(By.xpath(propX.getProperty("Productname"))).sendKeys(ProductName);
		driver.findElement(By.xpath(propX.getProperty("Selectmanufacturer"))).click();
		
		driver.findElement(By.xpath(propX.getProperty("regularprice"))).sendKeys(RegularPrice);
		driver.findElement(By.xpath(propX.getProperty("saleprice"))).sendKeys(SalePrice);
		driver.findElement(By.xpath(propX.getProperty("quantity"))).sendKeys(Quantity);
		Thread.sleep(5000);
		/* wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("submit"))));*/
		/* jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 2300);");
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("submit"))));*/
		 jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 3000);");
		//driver.findElement(By.xpath(propX.getProperty("submit"))).click();
			
	}
	
	
	
		

}
