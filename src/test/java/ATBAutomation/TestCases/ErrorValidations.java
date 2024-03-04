package ATBAutomation.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ATBAutomation.PageObjects.ProductCatalogue;
import ATBAutomation.TestComponents.BaseTest;



public class ErrorValidations extends BaseTest
{
	
@Test(groups={"ErrorHandling"})
public void ErrorVal() throws IOException
{
	
	String productName="ZARA COAT 3";
	ProductCatalogue productcatalogue =landingpage.loginUser("abcde@yahoo.in","Rahul@2024"); // wrong username and password is sentloginUser method is created in LandingPage class to put username and passsword
	
	Assert.assertEquals("Incorrect Email and Password.",landingpage.getErrorMessage());
		
}
}
