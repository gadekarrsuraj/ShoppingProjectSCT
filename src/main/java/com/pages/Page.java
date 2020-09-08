package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;


public class Page extends TestBase{
	
	@FindBy(xpath=".//a[@class='login']")
	WebElement signIn;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath=".//*[@class='icon-lock left']")
	WebElement signInBtn;	
	
	@FindBy(xpath=".//a[@class='sf-with-ul']")
	WebElement elementWomen;

	@FindBy(xpath=".//*[contains(text(),'Evening Dresses')]")
	WebElement elementEveningDress;
	
	@FindBy(xpath=".//input[@id='layered_id_attribute_group_2']")
	WebElement elementSize;
	
	@FindBy(xpath=".//input[@id='layered_id_attribute_group_24']")
	WebElement elementColor;

	@FindBy(xpath=".//*[@class='available-now']")
	WebElement elementInstock;
	
	@FindBy(xpath=".//*[text()='More']")
	WebElement elementMore;
	
	@FindBy(id="quantity_wanted")
	WebElement elementQty;
	
	@FindBy(xpath=".//select[@id='group_1']")
	WebElement elemenDropDownSize;
	
	@FindBy(xpath=".//a[@id='color_24']")
	WebElement elemenPinkCheckBox;
	
	@FindBy(xpath=".//*[text()='Add to cart']")
	WebElement elemenAddToCart;
	
	//popup xpath
	
	@FindBy(xpath=".//div[@class='layer_cart_product col-xs-12 col-md-6']")
	WebElement popup;
	
	//pop up Left side------------------------------------------
	
	@FindBy(id="layer_cart_product_quantity")
	WebElement popupQty;
	
	@FindBy(id="layer_cart_product_attributes")
	WebElement popupColSize;
	
	@FindBy(id="layer_cart_product_price")
	WebElement popupProdPrize;
	
	//pop up right side----------------------------------------
	
	@FindBy(xpath=".//span[@class='ajax_block_products_total']")
	WebElement popup2TotalProdPrize;
	
	@FindBy(xpath=".//span[@class='ajax_cart_shipping_cost']")
	WebElement popup2TotalShippPrize;

	@FindBy(xpath=".//span[@class='ajax_block_cart_total']")
	WebElement popup2Total;
	
	@FindBy(id=".//a[@class='ui-slider-handle ui-state-default ui-corner-all'][1]")
	WebElement elementsliderMin;
	
	@FindBy(id=".//a[@class='ui-slider-handle ui-state-default ui-corner-all'][2]")
	WebElement elementsliderMax;
	
	@FindBy(xpath=".//span[@class='cross']")
	WebElement popUpClose;
	
	@FindBy(xpath=".//a[@class='logout']")
	WebElement signOut;
	
	public Page() {		
		PageFactory.initElements(driver, this);		
	}
	
	public void emptyLoginTest(){
		username.clear();
		password.clear();
		log.info("Empty credentials and click submit Button...");
		signInBtn.click();
	}

	public void login(String un, String pwd) {
		signIn.click();
		
		username.sendKeys(un);
		log.info("Entering Username ...");
		password.sendKeys(pwd);
		log.info("Entering Password...");
		
		signInBtn.click();
		log.info("click on sign in...");
		
    	//JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();", signInBtn);
	}		
	
	public void clickWomenEveningDress() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(elementWomen).perform();
		log.info("mouse hover to women...");
		action.moveToElement(elementEveningDress).click().build().perform();;
		log.info("mouse hover to dress and click...");
	}
	
	public void selectSizeColor() {
		elementSize.click();
		log.info("Click on element size...");
		elementColor.click();
		log.info("Click on pink color...");
	}
	
	public void sliderMin() {
		Actions action=new Actions(driver);
		action.clickAndHold(elementsliderMin).moveByOffset(1441, 102).release().perform();
		log.info("Click on Slider Min Range...");
		
	}
	
	public void sliderMax() {
		Actions action=new Actions(driver);
		action.clickAndHold(elementsliderMax).moveByOffset(1441, 98).release().perform();
		log.info("Click on Slider Max Range...");
		
	}
	public void clickOnMoreButton() {
		elementInstock.isDisplayed();
		Actions action=new Actions(driver);
		action.moveToElement(elementInstock).perform();
		log.info("Mouse hover to women...");
		action.moveToElement(elementMore).click().build().perform();
		log.info("Mouse hover to More and click...");
	}
	
	public void SelectQty() {
		elementQty.clear();
		elementQty.sendKeys("3");
		log.info("Enter 3 number quantity ...");
		
	}
	public void SelectSize() {
		Select sel=new Select(elemenDropDownSize);
		sel.selectByIndex(1);
		log.info("Select M size from drop down...");
	}
	public void SelectColor()  {
		if(elemenPinkCheckBox.isDisplayed()) {
		elemenPinkCheckBox.click();
		}
		log.info("click on pink check box...");
		
	}
	
	public void clickAddToCart() {
		elemenAddToCart.click();
		log.info("click on add to cart...");
//		verify quantity, size, color and total cost of the product on pop-up.
//		   Find out shipping cost.
//		   Verify total cost (total product cost + shipping cost).   	
	}
	public String getColSizePopUp()  {
		String ColSize=popupColSize.getText();
		//log.info("Colour and size on pop up is :"+ColSize);
		return ColSize;
	}
	public void getColPopUp()  {
		String ColSize=popupColSize.getText();
		String size=ColSize.split(",")[0];
		//log.info("Color on pop up is :"+ColSize);
		//return size;
		}
	
	public void getSizePopUp()  {
		String ColSize=popupColSize.getText();
		//String size=ColSize.split(",")[1];
		log.info("size on pop up is :"+ColSize);
		//return size;
	}
	
	
	
	public float getTextTotalCostpopup()  {
		String totalprize=popupProdPrize.getText();
		String cost = totalprize.replaceAll("[$,]", "");
		float cost1 = Float.parseFloat(totalprize.replaceAll("[$,]", ""));
		//log.info("total cost on pop up is :"+totalprize);
		return cost1;
	}
	
	public int getTextQytpopup()  {
		String totalQty=popupQty.getText();
		int totalQty1=Integer.parseInt(totalQty);
		//log.info("total Quantity on pop up is :"+totalQty);
		return totalQty1;
	}
	
//	Print all values (quantity,Size,Color,Total product cost, Shipping cost, total cost) on the console.
//	   Use assertions, Waits as needed.
	public float getTotalPProd() {
		String totalProducts=popup2TotalProdPrize.getText();
		float total =  Float.parseFloat(totalProducts.replaceAll("[$,]", ""));
		//log.info("total Product coston pop up 2 is :"+totalProducts);
		return total;
	}
	public float getShipping() {
		String shippPrize=popup2TotalShippPrize.getText();
		float shipp = Float.parseFloat((shippPrize.replaceAll("[$,]", "")));
		//log.info("total Shipping cost on pop up 2 is :"+shippPrize);
		return shipp;
		
	}
	
	public float getTotal() {
		String total=popup2Total.getText();
		float tot =  Float.parseFloat(total.replaceAll("[$,]", ""));
		//log.info("total cost on pop up 2 is :"+total);
		return tot;
		
	}

	public float getCalTotalCost() {
		String totalPrize=popup2TotalProdPrize.getText();
		float total =  Float.parseFloat(totalPrize.replaceAll("[$,]", ""));
		String shippPrize=popup2TotalShippPrize.getText();
		float shipp = Float.parseFloat((shippPrize.replaceAll("[$,]", "")));
		float Add=total+shipp;
		return Add;
	}
	
	public void closePopUp() {
		popUpClose.click();
		log.info("Pop up is closed");
	}
	
	public void signOut() throws InterruptedException {
		signOut.click();
		log.info("Successfully Sign out from the website");
	}
	
	public void PrintAllData() {
		String ColSize=popupColSize.getText();
		String totalQty=popupQty.getText();
		String totalPrize=popup2TotalProdPrize.getText();
		String totalProducts=popup2TotalProdPrize.getText();
		String shippPrize=popup2TotalShippPrize.getText();
		String total=popup2Total.getText();
		System.out.println("**********Print data from Pop Up Window Start*****************");
		System.out.println("Coloum and size is :"+ColSize);
		System.out.println("Total Quantity is :"+totalQty);
		System.out.println("Total Cost is :"+totalPrize);
		System.out.println("Total Product cost is :"+totalProducts);
		System.out.println("Total Shipping cost is :"+shippPrize);
		System.out.println("Total Cost is :"+total);
		System.out.println("**********Print data from Pop Up Window End*****************");
		
	}
	
}
