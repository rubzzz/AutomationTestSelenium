package ATBAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATBAutomation.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	
	WebDriver driver;
	
	
	
	public ConfirmationPage(WebDriver driver)// constructor created to initialize the driver
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage ;
	
	public String verifyConfirmationMessage()
	{
		String cm= confirmationMessage.getText();
		return cm;
	}
	
}
