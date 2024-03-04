package ATBAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATBAutomation.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

		
		WebDriver driver;
		
		
		
		
		public LandingPage(WebDriver driver)// constructor created to initialize the driver
		{
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		
		@FindBy(id="login")
		WebElement submit;
		
		public void gotoPage()
		{
			driver.get(" https://rahulshettyacademy.com/client");
		}
		
		public String getErrorMessage()
		{
			waitForWebElementsToAppear(errorMessage);
			 return errorMessage.getText();
		}
		
		public ProductCatalogue loginUser(String email, String password)
		{
			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			submit.click();
			ProductCatalogue productcatalogue= new ProductCatalogue(driver);
			return productcatalogue;
			
		}

		
		

	}



