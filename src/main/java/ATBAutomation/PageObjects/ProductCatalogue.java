package ATBAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATBAutomation.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

		
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver)// constructor created to initialize the driver
		{
			super(driver); 
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		
		//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		
		@FindBy(css=".mb-3")
		List<WebElement> products;// Page factory is exclusively used for web element construction
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		
		
		By product1= By.cssSelector(".mb-3");
		By addToCart= By.cssSelector(".card-body button:last-of-type");
		By toastMessage= By.cssSelector("#toast-container");
		
		public List<WebElement> getProductlist()
		{
			waitForElementsToAppear(product1);
		    return products;
			}
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod =	getProductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			
			return prod;
		}
		
		
		

		public void addProductToCart(String productName) {
			// TODO Auto-generated method stub
			WebElement prod= getProductByName(productName);
			waitForElementsToAppear(toastMessage);
			prod.findElement(addToCart).click();
			waitForElementsToAppear(toastMessage);
			waitForElementToDisappear(spinner);
		}
		
		
		
}
		
		
		
		
		

	



