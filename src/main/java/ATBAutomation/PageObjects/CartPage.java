package ATBAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATBAutomation.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

		
		WebDriver driver;
		
		
		
		public CartPage(WebDriver driver)// constructor created to initialize the driver
		{
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		
		
		
		@FindBy(css=".cartSection h3")
		List <WebElement> cartProducts;
		
		@FindBy(css=".totalRow button")
		WebElement checkout;
		

		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		public Boolean verifyDisplay(String productName )
		{
		Boolean match= cartProducts.stream().anyMatch(cartProducts-> cartProducts.getText().equalsIgnoreCase(productName));	
		return match;
		}
		
		public CheckoutPage gotoCheckout()
		{
			checkout.click();
			return new CheckoutPage(driver);
			
		}

		
		

	}



