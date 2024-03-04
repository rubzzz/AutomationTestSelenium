package ATBAutomation.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.appender.nosql.NoSqlObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ATBAutomation.PageObjects.CartPage;
import ATBAutomation.PageObjects.CheckoutPage;
import ATBAutomation.PageObjects.ConfirmationPage;
import ATBAutomation.PageObjects.LandingPage;
import ATBAutomation.PageObjects.OrderPage;
import ATBAutomation.PageObjects.ProductCatalogue;
import ATBAutomation.TestComponents.BaseTest;





public class StandAloneTest extends BaseTest
{
	

	String productName="ZARA COAT 3";	
@Test (dataProvider= "getData", groups= {"Purchase"})
public void StandAlone(HashMap<String,String> input) throws IOException
{	
	
	
	//  driver.get("https://rahulshettyacademy.com/client"); //This line of code is in goTo() in landingpage class
	
	// LandingPage landingpage=new LandingPage(driver);  // object created of landing page class is shifted to BaseTest class
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 
	//LandingPage landingpage= launchApplication();  we declare it as beforemethod -- encapsulating it in the parent class 
	 
	// landingpage.gotoPage(); //goto method defined in landingPage class to open the website
	
	 ProductCatalogue productcatalogue =landingpage.loginUser(input.get("email"), input.get("password")); // loginUser method is created in LandingPage class to put username and passsword
	 
	 String var=input.get("productName");
	//ProductCatalogue productcatalogue= new ProductCatalogue(driver); // This object is created in landing page
	List<WebElement> products= productcatalogue.getProductlist();
	productcatalogue.addProductToCart(input.get("productName"));
	CartPage cartpage= productcatalogue.gotoCartPage();
	
	
	Boolean match= cartpage.verifyDisplay(input.get("productName"));
	Assert.assertTrue(match);

	
	CheckoutPage checkoutpage= cartpage.gotoCheckout();
	checkoutpage.selectCountry("india");
	ConfirmationPage confirmationpage= checkoutpage.submitOrder();
	String confirmMessage = confirmationpage.verifyConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
}

@Test(dependsOnMethods={"StandAlone"})

public void orderHistoryTest()
{
	ProductCatalogue productcatalogue =landingpage.loginUser("abcde@yahoo.in","Rahul@2024");
	OrderPage orderPage = productcatalogue.gotoOrdersPage();

	Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
}

@DataProvider
public Object[][] getData() throws IOException
{
/*	HashMap<String,String> map= new HashMap<String,String>();
	map.put("email"," abcde@yahoo.in" );
	map.put("password","Rahul@2024" );
	map.put("productName", "ZARA COAT 3");
	
	HashMap<String,String> map1= new HashMap<String,String>();
	map1.put("email"," abcde@yahoo.in" );
	map1.put("password","Rahulll@2024" );
	map1.put(" productName", "ADIDAS ORIGINAL");*/ 
 List<HashMap<String,String>> data= getJsonDataToMap();
return new Object[][] {{data.get(0)}, {data.get(1)}};
}
/*
@DataProvider
public Object[][] getData()
{
	 return new Object[][]{{"anishka@gmail.com","iamking@000" ,"ZARA COAT 3 " },{" anishka@gmail.com","iamking@000", " ADIDAS ORIGINAL"}}

}*/

}