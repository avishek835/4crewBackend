package fourCrewBaseFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import screenRecording.ScreenRecordingUtil;
import utilityFile.UtilityFile;



public class FourCrewBaseFile {
	public Properties propX;
	
	protected WebElement element;
	protected WebDriverWait wait;
	protected JavascriptExecutor jse;
	protected WebDriver driver;
	protected String s;
		
	protected FourCrewBaseFile(){
	UtilityFile up= new UtilityFile();
	propX=up.getProp();
	}
	
	
	@BeforeClass
	public void setup() throws Exception
	{
		ScreenRecordingUtil.startRecording("navigation_FeatureTest");
		String browserName = propX.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if(browserName.equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
	}
	
	@AfterClass
	public void teardown() throws Exception
	{
		driver.close();
		ScreenRecordingUtil.stopRecording();
	}
	
	@DataProvider(name="getData")
	 
	 public Object[][] getData() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\\4crewBackend\\4crewBackened\\src\\test\\java\\FourCrewData.xls","Login");
			return arrayObject;
	}
	
	@DataProvider(name="getProduct")
	 
	 public Object[][] getProduct() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\\4crewBackend\\4crewBackened\\src\\test\\java\\FourCrewData.xls","AddProduct");
			return arrayObject;
	}
	
	
	@DataProvider(name="getCategory")
	 
	 public Object[][] getCategory() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\\4crewBackend\\4crewBackened\\src\\test\\java\\FourCrewData.xls","AddCategory");
			return arrayObject;
	}
	
	@DataProvider(name="getManufacturers")
	 
	 public Object[][] getManufacturers() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\\4crewBackend\\4crewBackened\\src\\test\\java\\FourCrewData.xls","AddManufacturers");
			return arrayObject;
	}
	
	@DataProvider(name="getParentCategory")
	 
	 public Object[][] getParentCategory() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\4crewBackend\4crewBackened\\src\\test\\java\\FourCrewData.xls","AddParentCategory");
			return arrayObject;
	}
	
	
	
	
	 public String[][] getExcelData(String fileName, String sheetName) 
	 {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) 
				{
					for (int j=0; j < totalNoOfCols; j++) 
					{
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}
				}
				fs.close();
				} catch (FileNotFoundException e) 
						{
							e.printStackTrace();
						} catch (IOException e) 
								{
									e.printStackTrace();
									//e.printStackTrace();
								} catch (BiffException e) 
										{
											e.printStackTrace();
										}
			return arrayExcelData;
		}


}
