package ATBAutomation.TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ATBAutomation.PageObjects.LandingPage;



public class OriginalCode
{

{
	System.setProperty("webdriver.edge.driver", "C:\\Users\\grewa\\Downloads\\msedgedriver.exe");
	WebDriver driver= new EdgeDriver();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://rahulshettyacademy.com/client");
	 LandingPage landingpage=new LandingPage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 String s= driver.getTitle();
	 System.out.println(s);
	driver.findElement(By.id("userEmail")).sendKeys("abcd@yahoo.in");
	driver.findElement(By.id("userPassword")).sendKeys("Rahul@2024");
	driver.findElement(By.id("login")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3"))); // explicit wait untill all the items are not displayed on screen.
	
	List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	
	
	WebElement prod =	products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); 
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	 
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	
	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
	Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();
	
	
}
}
