package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	float shippingChargeExp=(float) 2.0;
	float productCostExp=(float) 154.97;
	float totalCostExp=(float) 152.97;
	

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		log.info("Launching the Chrome...");
		loginPage = new LoginPage();
		log.info("Opening Browser...");

	}


	@Test(priority = 1)
	public void verifyLoginFunctionslityTest() throws InterruptedException {
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void clickWomenEveningDress() throws InterruptedException {
		loginPage.clickWomenEveningDress();
		
	}
	@Test(priority = 3)
	public void selectSizeColor() throws InterruptedException {
		loginPage.selectSizeColor();
		
	}
	/*@Test(priority = 4)
	public void setPrizeRange() throws InterruptedException {
		loginPage.sliderMin();
		loginPage.sliderMax();
		
	}*/
	
	@Test(priority = 5)
	public void clickOnMoreButton() throws InterruptedException {
		loginPage.clickOnMoreButton();
	}
	
	@Test(priority = 6)
	public void selectQtyColSize() throws InterruptedException {
		loginPage.SelectQty();
		loginPage.SelectSize();
		loginPage.SelectColor();
		loginPage.clickAddToCart();
		Thread.sleep(5000);
	}
	
	/*@Test(priority = 7)
	public void printAllDetails() throws InterruptedException {
		loginPage.getColSizePopUp();
		loginPage.getTextQytpopup();
		loginPage.getTextTotalCostpopup();
		loginPage.getTotalPProd();
		loginPage.getShipping();
		loginPage.getTotal();
		loginPage.closePopUp();
		loginPage.getColPopUp();
		loginPage.getSizePopUp();
	}*/
	
	@Test(priority = 8)
	public void validateColorSize() throws InterruptedException {
		String TotalQty=loginPage.getColSizePopUp();
		Assert.assertEquals(TotalQty,"Pink, M","Color and size is not as expected");
	}
	
	@Test(priority = 8)
	public void validateTotalQuantity() throws InterruptedException {
		int TotalQty=loginPage.getTextQytpopup();
		Assert.assertEquals(TotalQty, 3,"Total Quantity 3 is not as expected");
	}
	@Test(priority = 9)
	public void validateColour() {
		loginPage.getColPopUp();
		Assert.assertEquals("Pink", "Pink","Color is not as expected");
	}
	@Test(priority = 10)
	public void validateSize() {
	loginPage.getSizePopUp();
		Assert.assertEquals(" M", " M","Total Size is not as expected");
	}
	
	@Test(priority = 11)
	public void validateTotalCost()  {
		float TotalCost=loginPage.getTextTotalCostpopup();
		Assert.assertEquals(TotalCost,totalCostExp,"Total Cost is not as ");
	}
	@Test(priority = 11)
	public void validateTotalshipping() {
		float TotalShipp=loginPage.getShipping();
		Assert.assertEquals(TotalShipp,shippingChargeExp,"Total Cost is not as ");
	}
	
	@Test(priority = 12)
	public void validateTotalProductCost() throws InterruptedException {
		float TotalProd=loginPage.getCalTotalCost();
		float total=loginPage.getTotal();
		Assert.assertEquals(TotalProd,productCostExp,"Sum of Total Product cost & Total Shipping charges is not as Total Cost");
	}
	
	@Test(priority = 13)
	public void PrintAllData() {
		loginPage.PrintAllData();
		
	}
	
	@Test(priority = 14)
	public void popUpClosed()  {
		loginPage.closePopUp();
	}
	@Test(priority = 15)
	public void signOut() throws InterruptedException  {
		loginPage.signOut();
	}
	
	@AfterClass
	public void tearDown() {
		log.info("Closing Browser...");
		driver.quit();
	}
}
