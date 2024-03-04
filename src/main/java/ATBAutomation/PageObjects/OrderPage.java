package ATBAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATBAutomation.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

		
		WebDriver driver;
		
		
		
		public OrderPage(WebDriver driver)// constructor created to initialize the driver
		{
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		
		
		
		@FindBy(css="tr td:nth-child(3)")
		List<WebElement> productNames;
	
		

		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		public Boolean verifyOrderDisplay(String productName )
		{
		Boolean match= productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));	
		return match;
		}
		
		
		
		

	}



