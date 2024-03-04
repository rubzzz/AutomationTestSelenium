package ATBAutomation.TestComponents;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import ATBAutomation.PageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;

public class BaseTest {
	protected WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializedriver() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ATBAutomation\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Microsoft Edge"))
				{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\grewa\\Downloads\\msedgedriver.exe");
			driver= new EdgeDriver();
				}
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
return driver;
	} 
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication()throws IOException
	{
		driver=initializedriver();
		 landingpage=new LandingPage(driver); 
		landingpage.gotoPage();
		return landingpage;
		
	}
	
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
	TakesScreenshot ts= (TakesScreenshot)driver;
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 // this file we want to store it in our project but the method copy file - in destination store it in object format that's why we used File new File
	 File file= new File(System.getProperty("user.dir")+ "\\reports\\"+ testCaseName+".png");
	 FileUtils.copyFile(source, file);
	 return System.getProperty("user.dir")+ "\\reports\\"+ testCaseName+".png";
	}

		
		public List<HashMap<String, String>> getJsonDataToMap() throws IOException
		{
			//read json to string-- no need to download external dependency
			File file =new File(System.getProperty("user.dir")+"\\src\\test\\java\\ATBAutomation\\Data\\PurchaseOrder.json");
			String jsonContent= FileUtils.readFileToString(file,StandardCharsets.UTF_8);

			// convert String to Hashmap-- downlaod dependency jackson	databind
			ObjectMapper mapper = new ObjectMapper();
			  List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>()
			  {
		      });
			  return data;
			
			//{map, map}			
		
		}
	
/*	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}*/
	
}
