package ATBAutomation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ATBAutomation.PageObjects.CartPage;
import ATBAutomation.PageObjects.OrderPage;


public class AbstractComponent
{
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)// construct to catch the driver information from child clas
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitForElementsToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
	}
	
	public void waitForWebElementsToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findBy));
			
	}
	

	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public  CartPage gotoCartPage()      // Reusable 
	{
		cartHeader.click();
		CartPage cartpage= new CartPage(driver);
		return cartpage;
		
	}
	public  OrderPage gotoOrdersPage()      // Reusable 
	{
		orderHeader.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
		
	}
	
}
