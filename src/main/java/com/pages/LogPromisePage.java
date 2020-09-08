package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class LogPromisePage extends TestBase {

	
	@FindBy(xpath = "//select[@name='cboEmp']")
	private WebElement dropdownPromise;

	@FindBy(id = "txtPromise")
	private WebElement enterText;

	@FindBy(id = "btnSubmit")
	private WebElement promiseBtn;

	@FindBy(id = ".//select[@id='cboEmp']")
	private WebElement selectPromiser;

	@FindBy(id = ".//input[@name='btnSearch']")
	private WebElement searchBtn;

	@FindBy(id = "//td[contains(text(),'Sonali test')]")
	private WebElement textVerify;

	@FindBy(xpath = "//a[@href='../logout.php']")
	private WebElement logout;

	public void enterAddPromiseDetails() {
		enterText.clear();
		enterText.sendKeys("Enter Promise");
		promiseBtn.click();
	}

	public void selectPromiser() {
		log.info("select Promise from DropDown :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Select sel = new Select(dropdownPromise);
		sel.selectByValue("Sonali test");
	}

	public void clickOnSearchButton() {
		searchBtn.isDisplayed();
		searchBtn.click();
	}

	public String verifyNameInTable() {
		return (textVerify.getText());
	}

	public void PromiseDropDown() {
		log.info("select Promise from DropDown :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Select sel = new Select(dropdownPromise);
		sel.selectByValue("Sonali test");
	}

	public void logout() {
		logout.isDisplayed();
		logout.click();
	}

}
